package me.dev.listeners;

import me.dev.commands.VanishCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByBlockEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;

public class VanishPlayerListener implements Listener {

    private VanishCMD plugin;

    public VanishPlayerListener(VanishCMD plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityTarget(EntityTargetEvent event) {
        if (event.getTarget() instanceof Player && plugin.isVanished((Player)event.getTarget())) {
            event.setCancelled(true);
        }
    }


    @EventHandler
    public void onDamageByBlock(EntityDamageByBlockEvent event) {
        if (event.getEntity() instanceof Player && plugin.isVanished((Player)event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onDamageByEntity(EntityDamageByEntityEvent event) {
        if (event.getDamager() instanceof Player && plugin.isVanished((Player)event.getEntity())) {
            event.setCancelled(true);
        } else if (event.getEntity() instanceof Player && plugin.isVanished((Player)event.getEntity())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onItemPickup(PlayerPickupItemEvent event) {
        if (plugin.isVanished(event.getPlayer())) {
            event.setCancelled(true);
        }
    }
}
