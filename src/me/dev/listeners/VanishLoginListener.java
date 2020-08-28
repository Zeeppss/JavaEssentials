package me.dev.listeners;

import me.dev.commands.VanishCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class VanishLoginListener implements Listener {

    private VanishCMD plugin;

    public VanishLoginListener(VanishCMD plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerLogin(PlayerLoginEvent event) {
        Player player = event.getPlayer();

        if (plugin.isVanished(player)) {
            plugin.showPlayer(player);
        }
        if (player.hasPermission("essentials.vanish.seeall")) return;
        for (Player p1 : plugin.getServer().getOnlinePlayers()) {
            if (plugin.isVanished(p1) && player != p1 && p1 != null) { //`&& p1 != null` shouldn't be necessary. odd.
                player.hidePlayer(p1);
            }
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (plugin.isVanished(player)) {
            plugin.showPlayer(player);
        }
    }
}
