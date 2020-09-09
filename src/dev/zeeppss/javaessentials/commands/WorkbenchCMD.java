package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCMD implements CommandExecutor {
    public WorkbenchCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        if (args.length == 0) {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.workbench")) {
                ((Player) sender).openWorkbench(((Player) sender).getLocation(), true);
                sender.sendMessage(Main.pre + "§aOpened Crafting Table");
                return true;
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.workbench permissions!");
            }
            return false;
        } else {
            sender.sendMessage(ChatColor.RED + "Usage: /workbench");
        }
        return false;
    }
}
