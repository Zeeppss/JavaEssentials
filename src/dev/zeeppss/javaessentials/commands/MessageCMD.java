package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCMD implements CommandExecutor {
    public MessageCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length < 2) {
            sender.sendMessage(Main.pre + "§cUsage /pm <player> <message>");
            return false;
        }
        Player target = Bukkit.getPlayer(args[0]);
        if(target != null) {
            String message = ChatColor.translateAlternateColorCodes('&', join(args));
            String format = ChatColor.GOLD + "[%s" + ChatColor.GOLD + " -> %s" + ChatColor.GOLD + "]";

            target.sendMessage(String.format(format, sender.getName(), "me") + message);
            sender.sendMessage(String.format(format, "me", target.getName()) + message);

        } else sender.sendMessage("§cPlayer not found!");

        return false;
    }

    public String join(String[] args) {
        String result = " ";

        int i = 0;
        for (String s : args) {
            if (i > 0) result = result + " " + s;

            i++;
        }

        return result.trim();
    }

}
