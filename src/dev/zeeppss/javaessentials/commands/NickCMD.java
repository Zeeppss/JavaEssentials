package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class NickCMD implements CommandExecutor {
    public NickCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.nick")) {
                if (args.length == 0) {
                    p.sendMessage(Main.pre + "§cUsage: /nick [nickname]");
                    return true;
                } else {
                    String nick = "";
                    String[] var10 = args;
                    int var9 = args.length;

                    for (int var8 = 0; var8 < var9; ++var8) {
                        String arg = var10[var8];
                        nick = nick + arg + " ";
                    }

                    nick = nick.substring(0, nick.length() - 1);
                    nick = nick.replaceAll("&", "§");
                    p.sendMessage(Main.pre + "§aYou have changed your nickname to " + "§c" + nick);
                    Main.getInstance().getConfig().set(p.getName(), nick);
                    Main.getInstance().saveConfig();
                    return true;
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.nick permissions!");
            }
            return false;
        }
    }
}
