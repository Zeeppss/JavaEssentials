package me.dev.managers;

import me.dev.Main;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class GamemodeManager implements Listener {
    static List<String> gm0 = new ArrayList(Arrays.asList("0", "survival", "survival"));
    static List<String> gm1 = new ArrayList(Arrays.asList("1", "creative", "creative"));
    static List<String> gm2 = new ArrayList(Arrays.asList("2", "adventure", "adventure"));
    static List<String> gm3 = new ArrayList(Arrays.asList("3", "spectator", "spectator"));

    public GamemodeManager() {
    }

    public static void changeGamemode(Player player, String gamemode) {
        if (gm0.contains(gamemode)) {
            if (player.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                player.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else if (gm1.contains(gamemode)) {
            if (player.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                player.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else if (gm2.contains(gamemode)) {
            if (player.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                player.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else if (gm3.contains(gamemode)) {
            if (player.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                player.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else {
            player.sendMessage(Main.pre + "§cGamemode not found!.");
        }

    }

    public static void changeGamemode(Player player, String gamemode, Player sender) {
        if (gm0.contains(gamemode)) {
            if (sender.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(Main.pre + "§aGamemode for §e" + player.getName() + " §ahas been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                sender.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else if (gm1.contains(gamemode)) {
            if (sender.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(Main.pre + "§aGamemode for §e" + player.getName() + " §ahas been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                sender.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else if (gm2.contains(gamemode)) {
            if (sender.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(Main.pre + "§aGamemode for §e" + player.getName() + " §ahas been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                sender.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else if (gm3.contains(gamemode)) {
            if (sender.hasPermission("essentials.gamemode")) {
                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(Main.pre + "§aYour gamemode has been changed!. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(Main.pre + "§aGamemode for §e" + player.getName() + " §ahas been changed!. §8[§e" + player.getGameMode() + "§8]");
            } else {
                sender.sendMessage(Main.pre + "§cYou don't have essentials.gamemode permissions.");
            }
        } else {
            sender.sendMessage(Main.pre + "§cGamemode not found!.");
        }

    }
}
