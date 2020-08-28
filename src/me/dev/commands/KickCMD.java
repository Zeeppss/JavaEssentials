package me.dev.commands;

import me.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class KickCMD implements CommandExecutor {
    private Main plugin;

    public KickCMD(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("kick").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (cmd.getName().equalsIgnoreCase("kick"));
        if (args.length < 3)
            return false;
        Player p = Bukkit.getPlayer(args[1]);
        p.hasPermission("essentials.kick");
        p.sendMessage(ChatColor.RED + "You don't have essentials.kick permissions");
        if (p == null) {
            sender.sendMessage(ChatColor.RED + "Player not found");
            return true;
        }
        List<String> list = new LinkedList<>(Arrays.asList(args));
        list.remove(0);
        list.remove(0);
        String reason = ChatColor.translateAlternateColorCodes('&', String.join(" ", list));
        p.kickPlayer(reason);
        sender.sendMessage(ChatColor.RED + p.getName() + " has been kicked.");
        return true;
    }
}
