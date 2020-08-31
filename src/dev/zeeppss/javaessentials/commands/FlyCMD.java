package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlyCMD implements CommandExecutor {
    public FlyCMD() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player player;
        if (!(sender instanceof Player)) {
            if (args.length == 1) {
                player = Bukkit.getPlayer(args[0]);
                if (player != null) {
                    this.toggleFly(player);
                    sender.sendMessage(Main.pre + "§aFly not active for §e" + player.getName());
                } else {
                    sender.sendMessage(Main.pre + "§cPlayer not found!");
                }
            }

            sender.sendMessage(Main.pre + "Usage: /fly [player]");
            return false;
        } else {
            player = (Player)sender;
            if (player.hasPermission("essentials.fly")) {
                if (args.length == 0) {
                    this.toggleFly(player);
                } else if (args.length == 1) {
                    if (player.hasPermission("essentials.fly.other")) {
                        Player target = Bukkit.getPlayer(args[0]);
                        if (target != null) {
                            this.toggleFly(target);
                            player.sendMessage(Main.pre + "§aFly active for §e" + player.getName());
                        } else {
                            player.sendMessage(Main.pre + "§cPlayer not found!");
                        }
                    } else {
                        player.sendMessage(Main.pre + "§cYou don't have essentials.fly.other permissions!");
                    }
                } else {
                    player.sendMessage(Main.pre + "Usage: /fly [player]");
                }
            } else {
                player.sendMessage(Main.pre + "§cYou don't have essentials.fly permissions!");
            }

            return false;
        }
    }

    private void toggleFly(Player player) {
        if (player.getAllowFlight()) {
            player.setAllowFlight(false);
            player.sendMessage(Main.pre + "§cFly not active!");
        } else {
            player.setAllowFlight(true);
            player.sendMessage(Main.pre + "§aFly active!");
        }

    }
}

