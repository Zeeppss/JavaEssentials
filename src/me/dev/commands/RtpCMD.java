package me.dev.commands;

import me.dev.Main;
import me.dev.managers.RtpManager;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class RtpCMD implements CommandExecutor {
    public RtpCMD() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + Main.mbp);
            return false;
        } else {
            Player p = (Player)sender;
            if (p.hasPermission("essentials.rtp")) {
                if (args.length == 0) {
                    if (p.getWorld().getName().equals("Farm World")) {
                        RtpManager.rtp(p);
                    } else {
                        p.sendMessage(Main.pre + "§cYou must be in the world of agriculture!.");
                    }
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /rtp");
                }
            } else {
                p.sendMessage(Main.pre + Main.np);
            }

            return false;
        }
    }
}
