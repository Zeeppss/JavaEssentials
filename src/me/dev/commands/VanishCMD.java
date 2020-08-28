package me.dev.commands;

import me.dev.Main;
import me.dev.listeners.VanishLoginListener;
import me.dev.listeners.VanishPlayerListener;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.logging.Logger;

public class VanishCMD extends JavaPlugin implements CommandExecutor {
    public VanishCMD(Main plugin) {

    }

    public Logger log = Logger.getLogger("Minecraft");
    private ArrayList<String> hiddenUsernames = new ArrayList<String>();

    public void onEnable() {
        getServer().getPluginManager().registerEvents(new VanishLoginListener(this), this);
        getServer().getPluginManager().registerEvents(new VanishPlayerListener(this), this);
        getCommand("vanish").setExecutor(this);
    }

    public void onDisable() {
        for (Player p : getServer().getOnlinePlayers()) {
            if (isVanished(p)) {
                showPlayer(p);
            }
        }
        hiddenUsernames.clear();
        log.info("All players are visible again");
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (cmd.getName().equalsIgnoreCase("vanish"));
        Player p = (Player) sender;
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("list")) {
                if (!p.hasPermission("essentials.vanish.list")) {
                    p.sendMessage(ChatColor.RED + "You don't have essentials.vanish.list permissions");
                    return true;
                }
                if (hiddenUsernames.size() > 0) {
                    StringBuilder builder = new StringBuilder();
                    for (int i = 0; i < hiddenUsernames.size(); i++) {
                        builder.append(hiddenUsernames.get(i));
                        if (i < hiddenUsernames.size() - 1) {
                            builder.append(", ");
                        }
                    }

                    p.sendMessage(ChatColor.RED + "Hidden players: " + builder.toString());
                } else {
                    p.sendMessage(ChatColor.RED + "There are no hidden players");
                }
                return true;
            } else if (args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
                return false;
            } else if (p.hasPermission("essentials.vanish.vanishother")) {
                Player player = getServer().getPlayer(args[0]);
                if (player == null) p = getServer().getPlayerExact(args[0]);
                if (player == null) {
                    player.sendMessage(ChatColor.RED + "Player doesn't exist or too many results");
                    return true;
                }

                if (!isVanished(p)) {
                    vanishPlayer(p);
                    player.sendMessage(ChatColor.RED + "You have vanished");
                    player.sendMessage(ChatColor.RED + player.getName() + " is now invisible");
                    getServer().broadcastMessage(ChatColor.YELLOW + player.getName() + " left the game.");
                    return true;
                } else {
                    showPlayer(p);
                    player.sendMessage(ChatColor.RED + "You are no longer invisible");
                    player.sendMessage(ChatColor.RED + player.getName() + " is no longer invisible");
                    getServer().broadcastMessage(ChatColor.YELLOW + player.getName() + " joined the game.");
                    return true;
                }
            }
        } else if (p.hasPermission("essentials.vanish")) {
            if (!isVanished(p)) {
                vanishPlayer(p);
                p.sendMessage(ChatColor.RED + "You have vanished");
                getServer().broadcastMessage(ChatColor.YELLOW + p.getName() + " left the game.");
                return true;
            } else {
                showPlayer(p);
                p.sendMessage(ChatColor.RED + "You are visible again");
                getServer().broadcastMessage(ChatColor.YELLOW + p.getName() + " joined the game.");
                return true;
            }
        }
        return false;
    }

    public boolean isVanished(Player player) {
        return hiddenUsernames.contains(player.getName());
    }

    public void vanishPlayer(Player player) {
        hiddenUsernames.add(player.getName());
        for (Player p1 : getServer().getOnlinePlayers()) {
            if (p1 == player) {
                continue;
            } else if (p1.hasPermission("essentials.vanish.seeall")) {
                p1.sendMessage(ChatColor.RED + player.getName() + " vanished");
                continue;
            } else if (p1.hasPermission("essentials.vanish.list")) {
                p1.hidePlayer(player);
                p1.sendMessage(ChatColor.RED + player.getName() + " vanished");
                continue;
            }
            p1.hidePlayer(player);
        }
    }

    public void showPlayer(Player player) {
        hiddenUsernames.remove(player.getName());
        for (Player p1 : getServer().getOnlinePlayers()) {
            p1.showPlayer(player);
        }
    }

}
