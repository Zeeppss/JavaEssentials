package dev.zeeppss.javaessentials;

import dev.zeeppss.javaessentials.commands.*;
import dev.zeeppss.javaessentials.listeners.JoinEvent;
import dev.zeeppss.javaessentials.listeners.QuitEvent;
import dev.zeeppss.javaessentials.managers.GamemodeManager;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public static String pre = "§6[§bJavaEssentials§6] | ";
    public static String mbp = "§cPlayer only!";
    public static String np = "§cYou don't have this permissions!";
    FileConfiguration players;

    public Main() {
    }

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
        Bukkit.getConsoleSender().sendMessage(pre + " §aPlugin was loaded successfully");
        Bukkit.getConsoleSender().sendMessage(pre + " §aPLugin was created by Zeeppss!");
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
        this.getCommand("clearchat").setExecutor(new ClearChatCMD());
        this.getCommand("feed").setExecutor(new FeedCMD());
        this.getCommand("fly").setExecutor(new FlyCMD());
        this.getCommand("gamemode").setExecutor(new GamemodeCMD());
        this.getCommand("gm").setExecutor(new GamemodeCMD());
        this.getCommand("heal").setExecutor(new HealCMD());
        this.getCommand("kick").setExecutor(new KickCMD());
        this.getCommand("ban").setExecutor(new BanCMD());
        this.getCommand("broadcast").setExecutor(new BroadcastCMD());
        this.getCommand("bc").setExecutor(new BroadcastCMD());
        this.getCommand("tp").setExecutor(new TpCMD());
        this.getCommand("teleport").setExecutor(new TpCMD());
        Bukkit.getPluginManager().registerEvents(new GamemodeManager(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
        Bukkit.getConsoleSender().sendMessage(pre + " §cPlugin was disabled!");
        Bukkit.getConsoleSender().sendMessage(pre + " §cPlugin was created by Zeeppss!");
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
    }

    public FileConfiguration getPlayers() {

        return players;
    }
}

