package dev.zeeppss.javaessentials.commands.trolls;

import dev.zeeppss.javaessentials.Main;
import dev.zeeppss.javaessentials.listeners.FreezeEvent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class FreezeCMD implements CommandExecutor {
    public FreezeCMD() {
    }

    FreezeEvent plugin;

    public HashMap<Player, Location> frozenPlayers = new HashMap<>();

    @SuppressWarnings("deprecation")
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.freeze")) {
            if (args.length == 1) {
                String targetName = args[0];
                if (Bukkit.getOfflinePlayer(targetName).getPlayer() != null) {
                    Player target = Bukkit.getPlayer(targetName);
                    if (this.frozenPlayers.containsKey(target)) {
                        this.frozenPlayers.remove(target);
                    } else {
                        this.frozenPlayers.put(target, target.getLocation().clone());
                    }
                }
            } else {
                p.sendMessage(Main.pre + "§cUsage: /freeze [player]");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.freeze permissions!");
        }
        return false;
    }
}

