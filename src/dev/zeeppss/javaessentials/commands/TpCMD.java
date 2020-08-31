package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TpCMD implements CommandExecutor {
    private Player tptarget;

    public TpCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player)sender;
            if (!p.hasPermission("essentials.teleport")) {
                p.sendMessage("§cYou don't have essentials.teleport permissions!");
                return false;
            } else {
                if (args.length == 1) {
                    this.tptarget = Bukkit.getPlayer(args[0]);
                    if (this.tptarget != null) {
                        p.teleport(this.tptarget);
                        p.sendMessage(Main.pre + "§aYou have been teleport to §e" + this.tptarget.getName());
                        this.tptarget.sendMessage(Main.pre + "§e" + p.getName() + "§aHas been teleported to you!");
                        Iterator var6 = Bukkit.getOnlinePlayers().iterator();

                        while(var6.hasNext()) {
                            Player players = (Player)var6.next();
                            players.playEffect(p.getLocation(), Effect.ENDER_SIGNAL, 5);
                        }
                    } else {
                        p.sendMessage("§cPlayer not found!");
                    }
                } else {
                    p.sendMessage("§cUsage: /teleport [player]");
                }

                return true;
            }
        }
    }
}

