package me.dev;

import me.dev.commands.*;
import me.dev.managers.GamemodeManager;
import me.dev.managers.RtpManager;
import me.dev.listeners.JoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String pre = "§6[§bJavaNotepad§6] | ";
    public static String mbp = "§cPlayer Only!.";
    public static String np = "§cYou don't have essentials permissions!";

    public Main() {
    }

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
        Bukkit.getConsoleSender().sendMessage(pre + " §aPlugin was loaded successfully");
        Bukkit.getConsoleSender().sendMessage(pre + " §aPLugin was created by Zeeppss!");
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
        this.getCommand("vanish").setExecutor(new VanishCMD());
        this.getCommand("v").setExecutor(new VanishCMD());
        this.getCommand("feed").setExecutor(new FeedCMD());
        this.getCommand("heal").setExecutor(new HealCMD());
        this.getCommand("gamemode").setExecutor(new GamemodeCMD());
        this.getCommand("gm").setExecutor(new GamemodeCMD());
        this.getCommand("fly").setExecutor(new FlyCMD());
        this.getCommand("chatclear").setExecutor(new ClearChatCMD());
        this.getCommand("rtp").setExecutor(new RtpCMD());
        this.getCommand("tp").setExecutor(new TpCMD());
        Bukkit.getPluginManager().registerEvents(new GamemodeManager(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new RtpManager(), this);
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
        Bukkit.getConsoleSender().sendMessage(pre + " §cPlugin was disabled!");
        Bukkit.getConsoleSender().sendMessage(pre + " §cPlugin was created by Zeeppss!");
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
    }
}
