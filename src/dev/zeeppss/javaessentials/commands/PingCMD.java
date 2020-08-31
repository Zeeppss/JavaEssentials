package dev.zeeppss.javaessentials.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class PingCMD implements CommandExecutor {
    public PingCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        sender.sendMessage(sender instanceof Player ?
                ChatColor.GREEN + "Your Ping: " + getPing((Player) sender) + " ms" : "Your Ping: 0ms");

        return true;
    }

    public int getPing(Player p) {
        try {
            String bukkitversion = Bukkit.getServer().getClass().getPackage().getName().substring(23);
            Class<?> craftPlayer = Class.forName("org.bukkit.craftbukkit." + bukkitversion + ".entity.CraftPlayer");
            Object handle = craftPlayer.getMethod("getHandle").invoke(p);
            return ((Integer) handle.getClass().getDeclaredField("ping").get(handle)).intValue();
        } catch (Exception e) { return -1; }
    }

}
