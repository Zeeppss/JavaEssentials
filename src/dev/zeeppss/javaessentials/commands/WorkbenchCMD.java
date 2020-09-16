package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WorkbenchCMD implements CommandExecutor {
    public WorkbenchCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player)sender;
            if (p.hasPermission("essentials.wb")) {
                if (args.length == 0) {
                    p.openWorkbench((Location)null, true);
                    p.sendMessage(Main.pre + "§aOpened Workbench!");
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /workbench");
                    p.sendMessage(Main.pre + "§cUsage: /wb");
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.workbench permissions");
            }
            return false;
        }
    }
}
