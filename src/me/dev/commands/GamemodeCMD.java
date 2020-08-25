package me.dev.commands;

import me.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCMD implements CommandExecutor {
    private Main plugin;

    public GamemodeCMD(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("gamemode").setExecutor(this);

    }

    @SuppressWarnings("unused")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("gamemode")) ;
        Player p = (Player) sender;
        Player t = Bukkit.getPlayer(args[0]);
        if (args.length == 0) {
            if (p.hasPermission("essentials.gamemode") && p.isOp()) {
            }
            p.setGameMode(GameMode.ADVENTURE);
            p.sendMessage("&7Toggled Adventure &8(&cOff&8)");
            p.setGameMode(GameMode.CREATIVE);
            p.sendMessage("&7Toggled Creative &8(&aOn&8)");
            return true;
        } else {
            p.sendMessage("§cYou are lacking this permission essentials.gamemode");
        }
        return true;
    }
}


