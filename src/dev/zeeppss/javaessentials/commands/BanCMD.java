package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanCMD implements CommandExecutor {
    private Main plugin = Main.getPlugin(Main.class);

    public BanCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.ban")) {
                if (args.length == 0) {
                    sender.sendMessage(Main.pre + "§cUsage: /ban [player] [reason]");
                } else if (args.length == 1) {
                    sender.sendMessage(Main.pre + "§cUsage: /ban [player] [reason]");
                } else {
                    StringBuilder x = new StringBuilder();
                    int i = 1;
                    while (i < args.length) {
                        x.append((args[i]) + " ");
                        ++i;
                    }
                    String banner = sender.getName();
                    if (sender instanceof Player) {
                        banner = sender.getName();
                    }
                    Player target = Bukkit.getPlayer((String) args[0]);
                    this.plugin.getPlayers().set((args[0]) + ".banned", (Object) true);
                    this.plugin.getPlayers().set(String.valueOf(args[0]) + ".reason", (Object) x.toString());
                    this.plugin.getPlayers().set(String.valueOf(args[0]) + ".banner", (Object) banner);
                    Bukkit.getOfflinePlayer(args[0]).isBanned();
                    target.kickPlayer("§cYou have been banned from the server!\nBy: " + banner + "\nReason: " + x.toString());
                    Bukkit.broadcastMessage(Main.pre + "§a" + args[0] + " was banned from the server!");
                    sender.sendMessage(Main.pre + "Successfully banned: " + "§a" + target);
                    return true;
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.ban permissions!");
            }
            return false;
        }
    }
}