package dev.zeeppss.javaessentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import dev.zeeppss.javaessentials.commands.trolls.FreezeCMD;

public class FreezeEvent implements Listener {
    public FreezeEvent() {
    }

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        if (FreezeCMD.frozenPlayers.containsKey(event.getPlayer()) && (Boolean)FreezeCMD.frozenPlayers.get(event.getPlayer())) {
            event.getPlayer().teleport(event.getFrom());
        }

    }
}
