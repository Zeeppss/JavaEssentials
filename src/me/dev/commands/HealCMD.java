package me.dev.commands;

import me.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class HealCMD implements CommandExecutor {
    public HealCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + " | §cPlayer Only!.");
        }

        Player p = (Player)sender;
        if (p.hasPermission("essentials.heal")) {
            if (args.length == 0) {
                this.healOther(p);
            } else if (args.length == 1) {
                Player target = Bukkit.getPlayer(args[0]);
                if (target != null) {
                    this.healOther(target);
                    p.sendMessage(Main.pre + "§e" + target.getName() + "§aYou has been healed!.");
                } else {
                    p.sendMessage(Main.pre + "§cPlayer not found!.");
                }
            } else {
                p.sendMessage(Main.pre + "§cUsage: /heal");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.heal permissions.");
        }

        return false;
    }

    private void healOther(Player p) {
        p.setFoodLevel(20);
        p.setHealth(20.0D);
        p.setFireTicks(0);
        p.sendMessage(Main.pre + "§aYou has been healed!.");
    }
}
