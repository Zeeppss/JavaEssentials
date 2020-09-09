package dev.zeeppss.javaessentials.listeners;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import java.util.HashMap;

public class BackEvent implements Listener {
    public BackEvent() {
    }

    private HashMap<Player, Location> deaths = new HashMap();

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
            Player p = e.getEntity();
            if (this.deaths.containsKey(p)) {
            this.deaths.put(p, p.getLocation());
            p.sendMessage(Main.pre + "§cUsage: /back");
        }
    }
}
