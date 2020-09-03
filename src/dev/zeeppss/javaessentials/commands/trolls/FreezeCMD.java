package dev.zeeppss.javaessentials.commands.trolls;

import java.util.HashMap;
import java.util.Map;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class FreezeCMD implements CommandExecutor {
    public FreezeCMD() {
    }

    public static Map<Player, Boolean> frozenPlayers = new HashMap();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length != 1) {
            sender.sendMessage("§cUsage: /freeze [player]");
            return false;
        } else if (Bukkit.getPlayer(args[0]) != null) {
            Player target = Bukkit.getPlayer(args[0]);
            if (target.hasPermission("essentials.freeze")) {
                target.sendMessage(Main.pre + "§cYou don't have essentials.freeze permissions!");
                return true;
            } else if (frozenPlayers.containsKey(target) && (Boolean)frozenPlayers.get(target)) {
                frozenPlayers.put(target, false);
                sender.sendMessage(Main.pre + "§e" + target.getName() + " §cis no longer frozen.");
                return true;
            } else {
                frozenPlayers.put(target, true);
                sender.sendMessage(Main.pre + "§c" + target.getName() + " §ais now frozen.");
                return true;
            }
        } else {
            sender.sendMessage(Main.pre + "§cPlayer not found.");
            return true;
        }
    }
}