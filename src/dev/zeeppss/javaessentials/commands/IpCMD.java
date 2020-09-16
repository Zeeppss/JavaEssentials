package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class IpCMD implements CommandExecutor {
    public IpCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        String IP;
        if (args.length == 0) {
            IP = p.getAddress().toString().split("/")[p.getAddress().toString().split("/").length - 1].split(":")[0];
            p.sendMessage("§6IP: §c" + IP);
            return true;
        } else {
            if (args.length == 1) {
                p = Bukkit.getPlayer(args[0]);
                if (sender.hasPermission("essentials.ip")) {
                    if (p == null) {
                        sender.sendMessage(Main.pre + "§cPlayer not found!");
                        return true;
                    }
                    IP = p.getAddress().toString().split("/")[p.getAddress().toString().split("/").length - 1].split(":")[0];
                    sender.sendMessage("§6" + p.getName() + "'s IP is: §c" + IP);
                    return true;
                } else {
                    p.sendMessage(Main.pre + "§cYou don't have essentials.ip permissions!");
                }
                return false;
            } else {
                p.sendMessage(Main.pre + "§cUsage: /ip [player]");
            }
            return false;
        }
    }
}
