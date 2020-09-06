package dev.zeeppss.javaessentials.commands;

import java.io.File;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class NickCMD extends JavaPlugin implements Listener, CommandExecutor {
    public NickCMD() {
    }

    public static File nickFile;
    public static FileConfiguration nicks;

    public static void saveNicks() {
        try {
            nicks.save(nickFile);
        } catch (Exception var1) {
        }

    }

    public String colorize(String msg) {
        String coloredMsg = "";

        for(int i = 0; i < msg.length(); ++i) {
            if (msg.charAt(i) == '&') {
                coloredMsg = coloredMsg + '§';
            } else {
                coloredMsg = coloredMsg + msg.charAt(i);
            }
        }

        return coloredMsg;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String commandLable, String[] args) {
        Player p = (Player)sender;
        if (cmd.getName().equalsIgnoreCase("nick") && p.hasPermission("nick.use")) {
            if (args.length == 0) {
                p.sendMessage("§cUsage: /nick [nick]");
                return true;
            }

            String nick = this.colorize(args[0] + "§r");
            int length = this.getConfig().getInt("Nick-Maximum-Length");
            if (nick.length() > length + 1) {
                p.sendMessage("§cNick is too long! §8[§e" + length + "§8] §cletters");
                return true;
            }

            if (nick.contains(nick)) {
                p.sendMessage("§cNick's taken!");
                return true;
            }

            p.sendMessage("§aNick has updated to:  " + nick);
            nicks.set(p.getName(), nick);
            saveNicks();
            p.setCustomName(nick);
        }

        return true;
    }
}

