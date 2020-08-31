package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BroadcastCMD implements CommandExecutor {
    public BroadcastCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.broadcast")) {
                if (args.length == 0) {
                    if (args.length > 0) {
                        String broadcast = "";
                        String[] arrstring = args;
                        int n = arrstring.length;
                        int n2 = 0;
                        while (n2 < n) {
                            String message = arrstring[n2];
                            broadcast = (broadcast) + message + " ";
                            ++n2;
                        }
                        Bukkit.getServer().broadcastMessage("§c" + "[" + "§e" + "BROADCAST" + "§c" + "] " + "§a" + broadcast);
                    }
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /broadcast [text]");
                }
            } else {
                p.sendMessage("§cYou don't have essentials.broadcast permissions");
            }
        }
        return false;
    }
}