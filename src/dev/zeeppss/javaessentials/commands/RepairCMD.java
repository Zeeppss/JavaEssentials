package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepairCMD implements CommandExecutor {
    public RepairCMD() {
    }

    public boolean onCommand(CommandSender sender, Command arg1, String arg2, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player)sender;
        if (p.hasPermission("essentials.repair")) {
            if (args.length != 0) {
                return false;
            } else {
                try {
                    if (p.getItemInHand().getDurability() == 0) {
                        p.sendMessage(Main.pre + "§cRepair failed!");
                        return true;
                    } else {
                        p.getItemInHand().setDurability((short)0);
                        p.sendMessage(Main.pre + "§cRepair worked!");
                        return true;
                    }
                } catch (Exception var7) {
                    p.sendMessage(Main.pre + "§cRepair failed!");
                    return true;
                }
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.repair permissions!");
            return false;
        }
    }
}

