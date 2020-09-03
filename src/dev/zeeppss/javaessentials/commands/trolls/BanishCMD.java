package dev.zeeppss.javaessentials.commands.trolls;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class BanishCMD implements CommandExecutor {
    public BanishCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1 && args.length != 2) {
            sender.sendMessage("§cUsage: /banish [player]");
            return false;
        } else if (Bukkit.getPlayer(args[0]) != null) {
            Player target = Bukkit.getPlayer(args[0]);
            int radius = 20000;
            if (target.hasPermission("essentials.banish")) {
                target.sendMessage(Main.pre + "§cYou don't have essentials.banish permissions!");
                return true;
            } else {
                if (args.length == 2) {
                    radius = Integer.valueOf(args[1]);
                }

                this.banishPlayer(target, radius);
                sender.sendMessage(Main.pre + "§e" + target.getName() + "§aHas been banished!");
                return true;
            }
        } else {
            sender.sendMessage(Main.pre + "§cPlayer not found!");
            return true;
        }
    }

    public void banishPlayer(Player p, int radius) {
        Location banish = new Location(p.getWorld(), (double)(-radius) + Math.random() * (double)(2 * radius + 1), 5.0D + Math.random() * 66.0D, (double)(-radius) + Math.random() * (double)(2 * radius + 1));
        p.teleport(banish);
        this.removePlayerFromBlock(p);
    }

    public void removePlayerFromBlock(Player p) {
        Location loc = p.getLocation();
        if (!p.getLocation().getBlock().getType().equals(Material.AIR)) {
            p.teleport(new Location(loc.getWorld(), loc.getX(), loc.getY() + 1.0D, loc.getZ()));
            this.removePlayerFromBlock(p);
        }

    }
}

