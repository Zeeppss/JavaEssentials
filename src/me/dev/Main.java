package me.dev;

import me.dev.commands.*;
import me.dev.listeners.BanJoinListener;
import me.dev.listeners.EventJoinListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("JavaNotepad success to enabling...!");
        getServer().getPluginManager().registerEvents(new EventJoinListener(), this);
        getServer().getPluginManager().registerEvents(new BanJoinListener(), this);
        this.getCommand("heal").setExecutor(new HealCMD(this));
        this.getCommand("feed").setExecutor(new FeedCMD(this));
        this.getCommand("tp").setExecutor(new TpCMD(this));
        this.getCommand("gamemode").setExecutor(new GamemodeCMD(this));
        this.getCommand("fly").setExecutor(new FlyCMD(this));
        this.getCommand("ban").setExecutor(new BanCMD(this));
        this.getCommand("kick").setExecutor(new KickCMD(this));
        this.getCommand("vanish").setExecutor(new VanishCMD(this));
        this.getCommand("invsee").setExecutor(new InvseeCMD(this));
    }

    public void onDisable() {
        getLogger().info("JavaNotepad disabling...");
    }
}
