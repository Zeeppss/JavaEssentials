package dev.zeeppss.javaessentials.listeners;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class NickEvent implements Listener {
    public NickEvent() {
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        if (Main.getInstance().getConfig().getString(e.getPlayer().getName()) != null) {
            e.getPlayer().setDisplayName(Main.getInstance().getConfig().getString(e.getPlayer().getName()) + ChatColor.RESET);
        }

    }
}

