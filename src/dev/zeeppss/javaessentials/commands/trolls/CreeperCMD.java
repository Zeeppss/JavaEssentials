package dev.zeeppss.javaessentials.commands.trolls;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Player;

public class CreeperCMD implements CommandExecutor {
    public CreeperCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        }
        if (args.length == 1) {
            if (Bukkit.getPlayer(args[0]) != null) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target.hasPermission("essentials.creeper")) {
                    Location targetLoc = target.getLocation();
                    World targetWorld = target.getWorld();
                    Creeper creeper = (Creeper) targetWorld.spawn(targetLoc, Creeper.class);
                    creeper.setPowered(true);
                    sender.sendMessage(Main.pre + "§e" + target.getName() + " §aWas Creepered!");
                    return true;
                } else {
                    target.sendMessage(Main.pre + "§cYou don't have essentials.creeper permissions!");
                }
                return false;
            }
        } else {
            sender.sendMessage(Main.pre + "§cPlayer not found!");
            return true;
        }
        return false;
    }
}

