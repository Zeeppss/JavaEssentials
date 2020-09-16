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
                sender.sendMessage(Main.pre + "§aInventory cleared!");
                return true;
            } else {
                p.sendMessage(Main.pre + "§cUsage: /ci [player]");
                p.sendMessage(Main.pre + "§cUsage: /clearinventory [player]");
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    p.sendMessage(Main.pre + "§cPlayer not found!");
                    return true;
                } else {
                    target.getInventory().clear();
                    target.sendMessage(Main.pre + "§aYour inventory has been cleared!");
                    p.sendMessage(Main.pre + target.getName() + " Inventory was successfully cleared!");
                    return false;
                }
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.clearinventory permissions!");
        }
        return false;
    }
}

