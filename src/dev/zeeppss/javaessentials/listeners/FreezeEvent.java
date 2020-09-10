package dev.zeeppss.javaessentials.listeners;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import dev.zeeppss.javaessentials.commands.trolls.FreezeCMD;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;

public class FreezeEvent extends JavaPlugin implements Listener {
    public FreezeEvent() {
    }

    public HashMap<Player, Location> frozenPlayers = new HashMap<>();

    @EventHandler
    public void onPlayerMoveBlock(PlayerMoveEvent e){
        if(!frozenPlayers.containsKey(e.getPlayer())){
            return;
        }
        if(e.getFrom().getBlockX() != e.getTo().getBlockX() || e.getFrom().getBlockZ() != e.getTo().getBlockZ()){
            e.getPlayer().teleport(frozenPlayers.get(e.getPlayer()));
        }
    }
}
