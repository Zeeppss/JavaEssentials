package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MessageCMD implements CommandExecutor {
    public MessageCMD() {
    }

    HashMap<Player, Player> reply = new HashMap();
    ArrayList<Player> spy = new ArrayList();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        int i;
        Player opPlayer;
        Iterator var12;
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        String message = "";
        if (p.hasPermission("essentials.msg")) {
            if (args.length >= 2) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    for (i = 1; i < args.length; ++i) {
                        message = message + args[i] + " ";
                    }

                    var12 = Bukkit.getOnlinePlayers().iterator();

                    while (var12.hasNext()) {
                        opPlayer = (Player) var12.next();
                        if (opPlayer.hasPermission("essentials.msg") && this.spy.contains(opPlayer)) {
                            opPlayer.sendMessage("§6" + p.getName() + " §ahat eine Nachricht an §6" + target.getName() + " §agesendet mit dem Text §6: " + message);
                        }
                    }

                    p.sendMessage("§cme §r-> §a " + target.getName() + " §f» " + message);
                    target.sendMessage("§a" + p.getName() + " §r-> §cme  §f» " + message);
                    message = "";
                    this.reply.put(target, p);
                }
            } else {
                p.sendMessage(Main.pre + "§Usage: /msg [player] [text]");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.msg permissions!");
        }
        return false;
    }
}

