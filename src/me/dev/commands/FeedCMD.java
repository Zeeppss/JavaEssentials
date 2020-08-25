package me.dev.commands;

import me.dev.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCMD implements CommandExecutor {
    private Main plugin;

    public FeedCMD(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("feed").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("feed")) ;
        Player p = (Player) sender;
        if (args.length == 0) {
            if (p.hasPermission("essentials.feed") && p.isOp()) {
            }
            p.setFoodLevel(20);
            p.sendMessage("You has been feed!");
            return true;
        } else {
            p.sendMessage("§cYou are lacking the permission essentials.feed");
        }
        return true;
    }
}
