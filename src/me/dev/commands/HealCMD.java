package me.dev.commands;

import me.dev.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCMD implements CommandExecutor {
    private Main plugin;

    public HealCMD(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("heal").setExecutor(this);

    }
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("heal")) ;
        Player p = (Player) sender;
        if (args.length == 0) {
            if (p.hasPermission("essentials.heal") && p.isOp()) {
            }
            p.setHealth(20.0);
            p.setFoodLevel(20);
            p.setFireTicks(0);
            return true;
        } else {
            p.sendMessage("§cYou are lacking this permission essentials.heal");
        }
        return true;
    }
}