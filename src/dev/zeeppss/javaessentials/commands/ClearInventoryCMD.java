package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class ClearInventoryCMD implements CommandExecutor {
    public static ArrayList<String> onClear = new ArrayList();

    public ClearInventoryCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("essentials.clearinventory")) {
            if (args.length == 0) {
                p.getInventory().clear();
                p.updateInventory();
                p.sendMessage(Main.pre + "§cYou cleared your inventory");
                return false;
            } else {
                sender.sendMessage(Main.pre + "§cUsage: /ci [player]");
                Player t = Bukkit.getPlayer(args[0]);
                if (!p.hasPermission("essentials.clearinventory.others")) {
                    p.sendMessage(Main.pre + "§cYou don't have essentials.clearinventory.others permissions!");
                    return false;
                } else {
                    t.getInventory().clear();
                    t.updateInventory();
                    p.sendMessage(Main.pre + "You cleared the §e" + t.getDisplayName() + " §ainventory");
                    t.sendMessage(Main.pre + "§c" + t.getDisplayName() + "cleaned" + p.getDisplayName());
                }
                return false;
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.clearinventory permissions!");
        }
        return false;
    }
}

