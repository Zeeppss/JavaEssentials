package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCMD implements CommandExecutor {
    public MessageCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            Player target = Bukkit.getPlayer(args[0]);
            if (args.length == 0) {
                if (target != null) {
                    String message = "";
                    for (int i = 1; i != args.length; i++)
                        message += args[1] + " ";

                    target.sendMessage("§c" + sender.getName() + " §e§l>>> §6" + target.getName() + " §7§l" + message);
                    sender.sendMessage("§6" + sender.getName() + " §e§l>>> §c" + target.getName() + " §7§l" + message);
                } else if (!(target != null)) {
                    sender.sendMessage("§cPlayer not found!");
                }
                return true;
            } else {
                p.sendMessage(Main.pre + "§cUsage: /msg [player] [message]");
            }
            return false;
        }
    }
}