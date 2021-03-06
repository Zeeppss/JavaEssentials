package dev.zeeppss.javaessentials;

import dev.zeeppss.javaessentials.commands.*;
import dev.zeeppss.javaessentials.commands.trolls.*;
import dev.zeeppss.javaessentials.listeners.*;
import dev.zeeppss.javaessentials.managers.GamemodeManager;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class Main extends JavaPlugin {
    public static String pre = "§e[§3Java§bEssentials§e] | ";
    public static String mbp = "§cPlayer only!";
    public static String np = "§cYou don't have this permissions!";
    public HashMap<Player, Location> lastLogins = new HashMap<>();
    FileConfiguration players;

    public static Main instance;
    public static Main plugin;

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
        this.getCommand("broadcast").setExecutor(new BroadcastCMD());
        this.getCommand("bc").setExecutor(new BroadcastCMD());
        this.getCommand("afk").setExecutor(new AfkCMD());
        this.getCommand("ping").setExecutor(new PingCMD());
        this.getCommand("invsee").setExecutor(new InvseeCMD());
        this.getCommand("hat").setExecutor(new HatCMD());
        this.getCommand("top").setExecutor(new TopCMD());
        this.getCommand("clearinventory").setExecutor(new ClearInventoryCMD());
        this.getCommand("ci").setExecutor(new ClearInventoryCMD());
        this.getCommand("invecsee").setExecutor(new InvEcSeeCMD());
        this.getCommand("weather").setExecutor(new WeatherCMD());
        this.getCommand("javaessentials").setExecutor(new JavaEssentialsCMD());
        this.getCommand("js").setExecutor(new JavaEssentialsCMD());
        this.getCommand("smite").setExecutor(new SmiteCMD());
        this.getCommand("lightning").setExecutor(new SmiteCMD());
        this.getCommand("kill").setExecutor(new KillCMD());
        this.getCommand("suicide").setExecutor(new SuicideCMD());
        this.getCommand("help").setExecutor(new HelpCMD());
        this.getCommand("nuke").setExecutor(new NukeCMD());
        this.getCommand("creeper").setExecutor(new CreeperCMD());
        this.getCommand("ip").setExecutor(new IpCMD());
        this.getCommand("speed").setExecutor(new SpeedCMD());
        this.getCommand("flyspeed").setExecutor(new FlySpeedCMD());
        this.getCommand("workbench").setExecutor(new WorkbenchCMD());
        this.getCommand("wb").setExecutor(new WorkbenchCMD());
        this.getCommand("nick").setExecutor(new NickCMD());
        this.getCommand("repair").setExecutor(new RepairCMD());
        this.getCommand("blind").setExecutor(new BlindCMD());
        this.getCommand("give").setExecutor(new GiveCMD());
        instance = this;
        Bukkit.getPluginManager().registerEvents(new GamemodeManager(), this);
        Bukkit.getPluginManager().registerEvents(new JoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QuitEvent(), this);
        Bukkit.getPluginManager().registerEvents(new LightningLoginEvent(), this);
        Bukkit.getPluginManager().registerEvents(new NickEvent(), this);
        this.getConfig().options().copyDefaults(true);
        this.saveConfig();
        Bukkit.getServer().getPluginManager().registerEvents(new IpBlockedEvent(), this);
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
        Bukkit.getConsoleSender().sendMessage(pre + " §cPlugin was disabled!");
        Bukkit.getConsoleSender().sendMessage(pre + " §cPlugin was created by Zeeppss!");
        Bukkit.getConsoleSender().sendMessage(pre + " §7------------------------------------");
    }

    public static Main getInstance() {
        return instance;
    }


    public FileConfiguration getPlayers() {

        return players;
    }
}

