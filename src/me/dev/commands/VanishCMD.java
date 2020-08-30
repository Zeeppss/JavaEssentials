package me.dev.commands;

import me.dev.Main;
import java.util.ArrayList;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class VanishCMD implements CommandExecutor {
    ArrayList<String> vanish = new ArrayList();

    public VanishCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        Player p = (Player)sender;
        if (p.hasPermission("essentials.vanish")) {
            if (args.length == 0) {
                Iterator var6;
                Player all;
                if (this.vanish.contains(p.getName())) {
                    this.vanish.remove(p.getName());
                    p.sendMessage(Main.pre + "§cYou are now visible!");
                    var6 = Bukkit.getOnlinePlayers().iterator();

                    while(var6.hasNext()) {
                        all = (Player)var6.next();
                        all.showPlayer(p);
                    }
                } else {
                    var6 = Bukkit.getOnlinePlayers().iterator();

                    while(var6.hasNext()) {
                        all = (Player)var6.next();
                        all.hidePlayer(p);
                    }

                    this.vanish.add(p.getName());
                    p.sendMessage(Main.pre + "§aYou are now invisible!");
                }
            } else if (args.length == 1) {
            }
        } else {
            p.sendMessage(Main.pre + "§cWrong syntax or no rights use: /v, /vanish");
        }

        return false;
    }
}

