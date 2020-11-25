package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KillCMD implements CommandExecutor {
    public KillCMD() {
    }


    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.kill")) {
            if (args.length == 1) {
                Player target = Bukkit.getServer().getPlayer(args[0]);
                if (target == null) {
                    p.sendMessage(Main.pre + "§cPlayer not found");
                    return false;

                } else {
                    target.setHealth(0.0D);
                    p.sendMessage(Main.pre + "§e" + target.getName() + "§aHas been killed!");
                }
                return true;
            } else {
                p.sendMessage(Main.pre + "§cUsage: /kill [player]");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.kill permissions!");
        }
        return false;
    }
}