package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class ClearChatCMD implements CommandExecutor {
    public ClearChatCMD() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        String var10001;
        int i;
        Player player;
        FileConfiguration var9;
        if (!(sender instanceof Player)) {
            if (args.length == 0) {
                for(i = 0; i < 500; ++i) {
                    Bukkit.broadcastMessage("\n");
                    Bukkit.broadcastMessage(" ");
                }

                Bukkit.broadcastMessage(Main.pre + "§cConsole clears the chat!");
            } else if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) instanceof Player) {
                    player = Bukkit.getPlayer(args[0]);

                    for(i = 0; i < 99; ++i) {
                        player.sendMessage("\n");
                        player.sendMessage(" ");
                    }

                    sender.sendMessage(Main.pre + "§cYou cleaned the chat of §e" + player.getName());
                    player.sendMessage(Main.pre + "§cConsole clears your chats!");
                } else if (!(Bukkit.getPlayer(args[0]) instanceof Player)) {
                    sender.sendMessage("§cPlayer not found!");
                }
            }
        }

        if (sender instanceof Player) {
            if (!sender.hasPermission("essentials.clearchat")) {
                sender.sendMessage(Main.pre + "§cYou don't have essentials.clearchat permissions");
                return false;
            }

            if (args.length == 0) {
                for(i = 0; i < 500; ++i) {
                    Bukkit.broadcastMessage("\n");
                    Bukkit.broadcastMessage(" ");
                }

                Bukkit.broadcastMessage(Main.pre + "§e" + sender.getName() + " §cCleared the chat!");
            } else if (args.length == 1) {
                if (Bukkit.getPlayer(args[0]) instanceof Player) {
                    player = Bukkit.getPlayer(args[0]);
                    if (sender.getName().equals(player.getName())) {
                        for(i = 0; i < 99; ++i) {
                            sender.sendMessage("\n");
                            sender.sendMessage(" ");
                        }

                        sender.sendMessage(Main.pre + "§cYou cleaned your own chat");
                        return true;
                    }

                    for(i = 0; i < 99; ++i) {
                        player.sendMessage("\n");
                        player.sendMessage(" ");
                    }

                    sender.sendMessage(Main.pre + "§e" + sender.getName() + "§cCleared the chat of §e " + player.getName());
                    player.sendMessage(Main.pre + sender.getName() + " §cCleaned the chat!");
                } else {
                    sender.sendMessage(Main.pre + "§cPlayer not found!");
                }
            }
        }

        return true;
    }
}

