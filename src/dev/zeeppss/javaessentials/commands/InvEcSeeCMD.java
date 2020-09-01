package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class InvEcSeeCMD implements CommandExecutor {
    public InvEcSeeCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.invecsee")) {
                if (args.length == 0) {
                    p.openInventory(p.getEnderChest());
                    return true;
                } else if (args.length == 1) {
                    Player target = Bukkit.getPlayer(args[0]);
                    if (target == null || !target.isOnline()) {
                        p.sendMessage("§cPlayer not found");
                        return true;
                    }
                    p.sendMessage("§aOpening §e" + target.getName() + "'s enderchest.");
                    p.openInventory(target.getEnderChest());
                    return true;
                } else {
                    p.sendMessage(Main.pre + "§cUsage: /invecsee [player]");
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.invecsee");
            }
            return false;
        }
    }
}
