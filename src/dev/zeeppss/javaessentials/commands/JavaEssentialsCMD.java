package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.PluginDescriptionFile;

public class JavaEssentialsCMD implements CommandExecutor {
    public JavaEssentialsCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        PluginDescriptionFile des = Main.getInstance().getDescription();
        sender.sendMessage("§aCurrently you are using §e[§bJavaEssentials§e] §acreated by §eZeeppss §3" + des.getVersion());
        sender.sendMessage("§aWebsite: §ehttps://github.com/Zeeppss/JavaEssentials");

        for (String p : des.getAuthors()) sender.sendMessage(ChatColor.GREEN + "  - " + p);

        return true;
    }
}

