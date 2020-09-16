package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvseeCMD implements CommandExecutor {
    public InvseeCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.invsee")) {
                if (args.length != 1) {
                    sender.sendMessage(Main.pre + "§cUsage: /invsee [player]");
                    return false;
                }
                Player target = Bukkit.getPlayer(args[0]);
                ((Player) sender).openInventory(target.getInventory());
                sender.sendMessage("§aOpened Inventory");
                return true;
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.invsee permissions!");
            }
            return false;
        }
    }
}
