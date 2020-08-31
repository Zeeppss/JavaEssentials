package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class KickCMD implements CommandExecutor {
    public KickCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.kick")) {
                if (args.length == 0) {
                    sender.sendMessage(Main.pre + "§cUsage: /kick [player] [reason]");
                } else if (args.length == 1) {
                    sender.sendMessage(Main.pre + "§cUsage: /kick [player] [reason]");
                } else {
                    Player target = Bukkit.getPlayer((String) args[0]);
                    if (target == null) {
                        sender.sendMessage(Main.pre + "§cPlayer not found!");
                        return true;
                    }
                    StringBuilder x = new StringBuilder();
                    int i = 1;
                    while (i < args.length) {
                        x.append(args[i] + " ");
                        ++i;
                    }
                    String kicker = "Server";
                    if (sender instanceof Player) {
                        kicker = sender.getName();
                    }
                    target.kickPlayer(Main.pre + "§cYou have been kicked from the server!\nBy: " + kicker + "\nReason: " + x.toString().trim());
                    sender.sendMessage(Main.pre + "Successfully kicked §e:" + target.getName());
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.kick permissions!");
            }
            return false;
        }
    }
}
