package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import java.util.HashMap;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import dev.zeeppss.javaessentials.listeners.BackEvent;

public class BackCMD implements CommandExecutor {
    public BackCMD() {
    }

    private HashMap<Player, Location> deaths = new HashMap();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.back")) {
            if (this.deaths.containsKey(p)) {
                p.teleport((Location) this.deaths.get(p));
                p.sendMessage(Main.pre + "§aYou have returned to your checkpoint!");
                this.deaths.remove(p);
            } else {
                p.sendMessage(Main.pre + "§cCheckpoint not found!");
            }
            return false;
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.back permissions!");
        }
        return false;
    }
}

