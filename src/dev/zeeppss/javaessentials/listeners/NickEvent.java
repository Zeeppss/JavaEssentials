package dev.zeeppss.javaessentials.listeners;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class NickEvent implements Listener {

    public static FileConfiguration nicks;

    @EventHandler
    public void nickOnJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        if (nicks.contains(p.getName())) {
            String nick = nicks.getString(p.getName());
            p.setCustomName(nick);
        }
    }
}
