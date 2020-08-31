package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;

public class ClearInventoryCMD implements CommandExecutor {
    public ClearInventoryCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length > 2) {
            sender.sendMessage("Usage: /clear [material]");
            return false;
        }
        Player p = (Player) sender;
        PlayerInventory i = p.getInventory();
        if (p.hasPermission("essentials.clearinventory")) {
            if (args.length == 0) {
                p.sendMessage("Removing " + args[0] + " from inventory");
                i.remove(Material.valueOf(args[0]));
                return true;
            }
            p.sendMessage("Clearing inventory");
            i.clear();
            return false;
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.clearinventory permissions");
        }
        return false;
    }
}

