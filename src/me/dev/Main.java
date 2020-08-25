package me.dev;

import me.dev.commands.FeedCMD;
import me.dev.commands.GamemodeCMD;
import me.dev.commands.HealCMD;
import me.dev.commands.TpCMD;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        getLogger().info("JavaNotepad success to enabling...!");
        this.getCommand("heal").setExecutor(new HealCMD(this));
        this.getCommand("feed").setExecutor(new FeedCMD(this));
        this.getCommand("tp").setExecutor(new TpCMD(this));
        this.getCommand("gamemode").setExecutor(new GamemodeCMD(this));
    }

    public void onDisable() {
        getLogger().info("JavaNotepad disabling...!");
    }
}
