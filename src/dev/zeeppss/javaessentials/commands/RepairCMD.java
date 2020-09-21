package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import com.sun.istack.internal.NotNull;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RepairCMD implements CommandExecutor {
    public RepairCMD() {
    }

    @Deprecated
    @NotNull
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.repair")) {
            if (args.length == 0) {
                p.getItemInHand().setDurability((short) 0);
                p.sendMessage(Main.pre + "§aThe item has been repaired!");
                return true;
            } else {
                p.sendMessage(Main.pre + "§cUsage: /repair");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.repair permissions!");
        }
        return false;
    }
}
