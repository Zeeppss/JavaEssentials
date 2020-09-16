package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpeedCMD implements CommandExecutor {
    public SpeedCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("essentials.speed") | !p.isOp()) {
            p.sendMessage(Main.pre + "§cYou don't have essentials.speed permissions!");
        }
        if (args.length == 0) {
            p.sendMessage(Main.pre + "§cUsage: /speed [amount]");
            return false;
        }
        if (p.hasPermission("essentials.speed") | p.isOp()) {
            if (args.length > 1) {
                p.sendMessage(Main.pre + "§cUsage: /speed [amount]");
                return false;
            }

            if (args[0].equals("1")) {
                p.setWalkSpeed(0.1F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("2")) {
                p.setWalkSpeed(0.2F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("3")) {
                p.setWalkSpeed(0.3F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("4")) {
                p.setWalkSpeed(0.4F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("5")) {
                p.setWalkSpeed(0.5F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("6")) {
                p.setWalkSpeed(0.6F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("7")) {
                p.setWalkSpeed(0.7F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("8")) {
                p.setWalkSpeed(0.8F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("9")) {
                p.setWalkSpeed(0.9F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("10")) {
                p.setWalkSpeed(1.0F);
                p.sendMessage(Main.pre + "§aYour speed has been changed to §6" + args[0]);
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.speed permissions!");
        }
        return false;
    }
}
