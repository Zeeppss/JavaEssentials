package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class GiveCMD implements CommandExecutor {
    public GiveCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String args[]) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.give")) {
                if (args.length == 0) {

                    Material item = Material.getMaterial(args[0].toUpperCase());
                    if (item != null) {
                        Inventory inv = ((Player) sender).getInventory();
                        inv.addItem(new ItemStack(item, 64));
                        return false;
                    } else {
                        p.sendMessage(Main.pre + "§c" + args[0] + " §cnot a valid item!");
                        return true;
                    }
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /give");
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.give permissions!");
            }
        }
        return false;
    }
}
