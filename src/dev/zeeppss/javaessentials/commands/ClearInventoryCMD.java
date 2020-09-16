package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
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
        if (p.hasPermission("essentials.clearinventory")) {
            if (args.length == 0) {
                p.getInventory().clear();
                p.getInventory().setArmorContents(null);
                p.sendMessage(Main.pre + "§aYour inventory has been cleared!");
            } else {
                p.sendMessage(Main.pre + "§cUsage: /clearinventory");
                p.sendMessage(Main.pre + "§cUsage: /ci");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.clearinventory permissions!");
        }
        return false;
    }
}
