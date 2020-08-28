package me.dev.commands;

import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.dev.Main;
import net.md_5.bungee.api.ChatColor;

public class BanCMD implements CommandExecutor {

    public static ArrayList<Player> ban = new ArrayList<Player>();

    public BanCMD(Main plugin) {
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        if(cmd.getName().equalsIgnoreCase("ban")) {
            Player player = (Player) sender;
            if(!(player.hasPermission("essentials.ban"))) {//b
                player.sendMessage(ChatColor.RED + "You don't have essentials.ban permissions");
            }
            if(player.hasPermission("essentials.ban")) {
                if(args.length == 0) {
                    player.sendMessage(ChatColor.RED + "Invalid Usage - /ban <player> <reason>");
                }
                if(args.length == 1) {
                    Player target = Bukkit.getPlayerExact(args[0]);
                    if(target == null) {
                        ban.add(target);
                    }
                    if(target != null) {
                        target.kickPlayer("§cYou have been banned from the server!");
                        ban.add(target);
                    }
                }
            }
        }
        return true;
    }

}