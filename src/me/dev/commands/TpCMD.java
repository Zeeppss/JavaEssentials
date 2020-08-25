package me.dev.commands;

import me.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCMD implements CommandExecutor {
    private Main plugin;

    public TpCMD(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("tp").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player) sender;
        p.sendMessage(cmd.getName() + " has requested to teleport to you.\nType /tpaccept to accept or /tpdecline to decline");
        p.sendMessage("You have requested to teleport to " + cmd.getName());
        if (args.length == 0) {
            if (p.hasPermission("essentials.tp") && p.isOp()) {
                return true;
            } else if (cmd.getName().equalsIgnoreCase("tp")) {
                for (Player online : Bukkit.getOnlinePlayers()) {

                    if (online.getName().equals(p)) {
                        Location player = online.getLocation();
                        online.teleport(player);

                        return true;

                    }

                }

                for (Player online : Bukkit.getOnlinePlayers()) {

                    if (online.getName().equals(p)) {

                        online.sendMessage(cmd.getName() + " has declined your telelport request");

                        return true;

                    }

                }

            }

        }
        return false;
    }
}
