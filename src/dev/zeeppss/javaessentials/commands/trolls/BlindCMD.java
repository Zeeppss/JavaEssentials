package dev.zeeppss.javaessentials.commands.trolls;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class BlindCMD implements CommandExecutor {
    public BlindCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.blind")) {
            if (args.length == 0) {
                p.sendMessage(Main.pre + "§cUsage: /blind [player]");
                return true;
            }

            Player target = Bukkit.getServer().getPlayer(args[0]);
            if (target == null) {
                p.sendMessage(Main.pre + "§cPlayer not found!");
                return true;
            }

            if (args.length == 1) {
                target.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 500, 2));
                sender.sendMessage(Main.pre + "§e" + target.getName() + " §aHas gone blind!");
                return true;
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.blind permissions!");
        }
        return false;
    }
}

