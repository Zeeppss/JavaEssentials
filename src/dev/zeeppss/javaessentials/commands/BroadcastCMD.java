package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import dev.zeeppss.javaessentials.utils.StringUtils;
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
                    sender.sendMessage(Main.pre + "§cUsage: /broadcast [message]");
                    return true;
                }

                String message = StringUtils.join(args, " ");
                Bukkit.broadcastMessage("§e[§aBroadcast§e] " + "§r" + message);
                return true;
            }
            p.sendMessage(Main.pre + "§cYou don't have essentials.broadcast permissions!");
        }
        return false;
    }
}
