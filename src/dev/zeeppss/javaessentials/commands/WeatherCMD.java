package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class WeatherCMD implements CommandExecutor {
    public WeatherCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String l, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.weather")) {
                if (l.equalsIgnoreCase("sun")) {
                    p.getWorld().setStorm(false);
                    sender.sendMessage(Main.pre + "§aSet weather to §8[§eCLEAR§8] §ain " + p.getWorld().getName());
                    return true;
                }
                if (l.equalsIgnoreCase("rain")) {
                    p.getWorld().setStorm(true);
                    sender.sendMessage(Main.pre + "§aSet weather to §8[§eSTORM§8] §ain " + p.getWorld().getName());
                    return true;
                }

                if (args.length < 1) {
                    sender.sendMessage(Main.pre + "§cUsage: /weather <sun|rain> [world]");
                    return true;
                }
                World w = p.getWorld();
                if (args.length > 1) w = Bukkit.getWorld(args[1]);

                if (args[0].equalsIgnoreCase("sun")) {
                    w.setStorm(false);
                    sender.sendMessage(Main.pre + "§aSet weather to §8[§eCLEAR§8] §ain " + w.getName());
                    return true;
                }
                if (args[0].equalsIgnoreCase("rain")) {
                    w.setStorm(true);
                    sender.sendMessage(Main.pre + "§aSet weather to §8[§eSTORM§8] §ain " + w.getName());
                    return true;
                }
                return true;
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.weather permissions!");
            }
            return false;
        }
    }
}
