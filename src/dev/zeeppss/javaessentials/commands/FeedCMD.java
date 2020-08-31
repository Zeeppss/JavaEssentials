package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FeedCMD implements CommandExecutor {
    public FeedCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player)sender;
            if (p.hasPermission("essentials.feed")) {
                if (args.length == 0) {
                    p.setFoodLevel(20);
                    p.sendMessage(Main.pre + "§aYou has been feed");
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /feed");
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.feed permissions");
            }
            return false;
        }
    }
}
