package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FlySpeedCMD implements CommandExecutor {
    public FlySpeedCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (!p.hasPermission("essentials.flyspeed") | !p.isOp()) {
            p.sendMessage(Main.pre + "§cYou don't have essentials.speed permissions!");
        }
        if (args.length == 0) {
            p.sendMessage(Main.pre + "§cUsage: /flyspeed [amount]");
            return false;
        }
        if (p.hasPermission("essentials.flyspeed") | p.isOp()) {
            if (args.length > 1) {
                p.sendMessage(Main.pre + "§cUsage: /flyspeed [amount]");
                return false;
            }

            if (args[0].equals("1")) {
                p.setFlySpeed(0.1F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("2")) {
                p.setFlySpeed(0.2F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("3")) {
                p.setFlySpeed(0.3F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("4")) {
                p.setFlySpeed(0.4F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("5")) {
                p.setFlySpeed(0.5F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("6")) {
                p.setFlySpeed(0.6F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("7")) {
                p.setFlySpeed(0.7F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("8")) {
                p.setFlySpeed(0.8F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("9")) {
                p.setFlySpeed(0.9F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }

            if (args[0].equals("10")) {
                p.setFlySpeed(1.0F);
                p.sendMessage(Main.pre + "§aYour flight speed has been changed to §6" + args[0]);
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.flyspeed permissions!");
        }
        return false;
    }
}
