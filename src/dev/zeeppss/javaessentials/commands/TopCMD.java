package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerTeleportEvent;

public class TopCMD implements CommandExecutor {
    public TopCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.top")) {
                if (args.length == 0) {
                    Location l = p.getLocation();
                    int x = l.getBlockX(), y = l.getBlockY(), z = l.getBlockZ();
                    while (p.getWorld().getBlockAt(x, y, z).getType() != Material.AIR)
                        y++;

                    p.teleport(new Location(p.getWorld(), x, y + 1, z), PlayerTeleportEvent.TeleportCause.COMMAND);
                    return false;
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /top");
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.top permissions");
            }
            return false;
        }
    }
}
