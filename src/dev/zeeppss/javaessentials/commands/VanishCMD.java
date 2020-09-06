package dev.zeeppss.javaessentials.commands;

import java.util.ArrayList;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class VanishCMD extends JavaPlugin implements CommandExecutor {
    private ArrayList<Player> vanished = new ArrayList();

    public VanishCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return true;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.vanish")) {
            if (args.length == 0) {
                Player pl;
                int var7;
                int var8;
                Player[] var9;
                if (!this.vanished.contains(p)) {
                    var8 = (var9 = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0])).length;

                    for (var7 = 0; var7 < var8; ++var7) {
                        pl = var9[var7];
                        pl.hidePlayer(p);
                    }

                    this.vanished.add(p);
                    p.sendMessage(Main.pre + "§aVanish active!");
                    return true;
                } else {
                    var8 = (var9 = Bukkit.getServer().getOnlinePlayers().toArray(new Player[0])).length;

                    for (var7 = 0; var7 < var8; ++var7) {
                        pl = var9[var7];
                        pl.showPlayer(p);
                    }

                    this.vanished.remove(p);
                    p.sendMessage(Main.pre + "§cVanish not active!");
                    return true;
                }
            } else {
                p.sendMessage(Main.pre + "§cUsage: /vanish, /v");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.vanish permissions!");
        }
        return false;
    }
}
