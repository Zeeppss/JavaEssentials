package dev.zeeppss.javaessentials.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class IpBlockedEvent extends JavaPlugin implements Listener {
    public IpBlockedEvent() {
    }

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent e) {
        String[] var5;
        int var4 = (var5 = e.getMessage().split(" ")).length;

        for (int var3 = 0; var3 < var4; ++var3) {
            String word = var5[var3];
            if (this.getConfig().getStringList("ipblocked").contains(word)) {
                e.setCancelled(true);
                e.getPlayer().sendMessage("" + "§cPlease Don't Advertise Other IP Addresses Here!");
            }
        }

    }
}
