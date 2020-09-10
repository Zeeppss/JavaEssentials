package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuicideCMD implements CommandExecutor {
    public SuicideCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.suicide")) {
                if (args.length == 0) {
                    p.damage(20.0D);
                    p.setHealth(0.00);
                    p.sendMessage(Main.pre + "§cYou have killed yourself!");
                    if (p.getGameMode() == GameMode.CREATIVE) {
                        p.performCommand("kill");
                    }
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /suicide");
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.suicide permissions!");
            }
            return false;
        }
        return false;
    }
}
