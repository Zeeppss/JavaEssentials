package me.dev.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class EventJoinListener implements Listener {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        boolean hasjoined = player.hasPlayedBefore();

        if (hasjoined);
        event.setJoinMessage(ChatColor.WHITE + player.getName() + ChatColor.GREEN + "Welcome to this server!!");
    }
}
