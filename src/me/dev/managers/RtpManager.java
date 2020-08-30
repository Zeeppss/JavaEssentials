package me.dev.managers;

import me.dev.Main;
import java.util.Random;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;

public class RtpManager implements Listener {
    public RtpManager() {
    }

    public static void rtp(Player p) {
        Random random = new Random();
        int randomX = random.nextInt(20000) - 10000;
        int randomZ = random.nextInt(20000) - 10000;
        World world = p.getWorld();
        int higestblock = world.getHighestBlockYAt(randomX, randomZ);
        Location toTeleport = new Location(world, (double)randomX, (double)higestblock, (double)randomZ);
        p.teleport(toTeleport);
        p.sendMessage(Main.pre + "You become §ex=" + randomX + " z=" + randomZ + " §cTeleported!");
    }
}
