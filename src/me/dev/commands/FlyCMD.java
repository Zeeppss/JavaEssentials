package me.dev.commands;

import me.dev.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {
    private Main plugin;

    public FlyCMD(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("feed").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("fly")) ;
        Player p = (Player) sender;
        if (args.length == 0) {
            if (p.hasPermission("essentials.fly") && p.isOp()) {
            }
            if (p.getAllowFlight() == true) ;
            p.setAllowFlight(false);
            p.sendMessage(ChatColor.RED + "Fly has been disabled!");
        } else {
            p.setAllowFlight(true);
            p.sendMessage(ChatColor.GREEN + "Fly has been enabled!");
        }
        return false;
    }
}
