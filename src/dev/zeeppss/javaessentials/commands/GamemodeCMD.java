package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import dev.zeeppss.javaessentials.managers.GamemodeManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GamemodeCMD implements CommandExecutor {
    public GamemodeCMD() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player player = (Player)sender;
            if (player.hasPermission("essentials.gamemode")) {
                if (args.length == 1) {
                    GamemodeManager.changeGamemode(player, args[0]);
                } else if (args.length == 2) {
                    Player target = Bukkit.getPlayer(args[1]);
                    if (target != null) {
                        GamemodeManager.changeGamemode(target, args[0], player);
                    } else {
                        player.sendMessage(Main.pre + "§cPlayer not found!");
                    }
                } else {
                    player.sendMessage(Main.pre + "§cUsage: /gm [0,1,2,3] [player]");
                }
            } else {
                player.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions!");
            }
            return false;
        }
    }
}

