package dev.zeeppss.javaessentials.commands;

import java.util.HashSet;
import java.util.logging.Logger;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SmiteCMD implements CommandExecutor {
    public SmiteCMD() {
    }

    public static SmiteCMD plugin;
    public final Logger logger = Logger.getLogger("Minecraft");

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.smite")) {
                World world = p.getWorld();
                if (commandLabel.equalsIgnoreCase("smite") && p.hasPermission("smite.me")) {
                    Location location;
                    if (args.length == 0) {
                        Block targetblock = p.getTargetBlock((HashSet<Byte>) null, 50);
                        location = targetblock.getLocation();
                        world.strikeLightning(location);
                        world.createExplosion(location, 2.0F);
                    } else if (args.length == 1) {
                        if (p.getServer().getPlayer(args[0]) != null) {
                            Player targetplayer = p.getServer().getPlayer(args[0]);
                            location = targetplayer.getLocation();
                            world.strikeLightning(location);
                            p.sendMessage(Main.pre + "§cSmiting " + targetplayer.getDisplayName());
                        } else {
                            p.sendMessage("§cPlayer not found!");
                        }
                    } else if (args.length > 1) {
                        p.sendMessage(Main.pre + "§cUsage: /smite [player]");
                    }
                } else {
                    p.sendMessage(Main.pre + "§cYou don't have essentials.smite permissions!");
                }
                return false;
            }
        }
        return false;
    }
}