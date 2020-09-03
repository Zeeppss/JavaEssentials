package dev.zeeppss.javaessentials.commands.trolls;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class NukeCMD implements CommandExecutor {
    public NukeCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            try {
                Player target = Bukkit.getPlayer(args[0]);
                nuke(target.getLocation());
                sender.sendMessage(Main.pre + "§cTNT RAIN!");
                target.sendMessage(Main.pre + "§cTNT RAIN!");
            } catch (NullPointerException e) {
                sender.sendMessage(Main.pre + "§cPlayer not found!");
            }
        } else if (args.length == 0) {
            if (sender instanceof Player) {
                nuke(((Player) sender).getLocation());
                sender.sendMessage("§cTNT RAIN!");
            } else sender.sendMessage(Main.pre + "§cUsage: /nuke [player]");
        } else sender.sendMessage(Main.pre + "§cUsage: /nuke [player]");
        return true;
    }
    public void nuke(Location l) {
        for (int i = 0; i < 5; i++)
            l.getWorld().spawnEntity(l, EntityType.PRIMED_TNT);
    }
}
