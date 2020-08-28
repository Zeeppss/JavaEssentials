package me.dev.listeners;

import me.dev.commands.BanCMD;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class BanJoinListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        for(Player player : BanCMD.ban) {
            player.kickPlayer("§7You have been banned from the server!");
        }
    }

}
