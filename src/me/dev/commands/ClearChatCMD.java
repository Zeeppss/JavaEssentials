package me.dev.commands;

import me.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ClearChatCMD implements CommandExecutor {
    public ClearChatCMD() {
    }

    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender.hasPermission("essentials.clearchat")) {
            if (args.length == 0) {
                Bukkit.getOnlinePlayers().forEach((target) -> {
                    if (target.hasPermission("essentials.clearchat.bypass")) {
                        target.sendMessage(Main.pre + "§eThe chat was just opened by §a" + sender.getName() + " §e§lempty.");
                    } else {
                        for(int i = 0; i < 100; ++i) {
                            target.sendMessage("");
                        }

                        target.sendMessage(Main.pre + "§e§lThe chat was just opened by §a" + sender.getName() + " §e§lempty.");
                    }

                });
            } else {
                sender.sendMessage(Main.pre + "Usage: /cc");
            }
        } else {
            sender.sendMessage(Main.pre + "§cYou don't have essentials.clearchat permissions");
        }

        return false;
    }
}
