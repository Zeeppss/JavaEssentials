package dev.zeeppss.javaessentials.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LightningLoginEvent implements Listener {
    public LightningLoginEvent() {
    }

    @EventHandler
    public void onLogin(PlayerJoinEvent e) {
        Player player = e.getPlayer();
        if (player.hasPermission("essentials.lightninglogin") || player.isOp()) {
            player.getWorld().strikeLightningEffect(player.getLocation());
        }

    }
}

