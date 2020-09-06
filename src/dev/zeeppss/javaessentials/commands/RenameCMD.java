package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class RenameCMD implements CommandExecutor {
    public RenameCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§Player only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.rename")) {
            if (args.length == 0) {
                StringBuilder sb1 = new StringBuilder();

                for (int f = 0; f < args.length; ++f) {
                    sb1.append(args[f]).append(" ");
                }

                String allArgs2 = sb1.toString().trim();
                ItemStack item = p.getInventory().getItemInHand();
                ItemMeta m = item.getItemMeta();
                m.setDisplayName(ChatColor.translateAlternateColorCodes('&', allArgs2));
                item.setItemMeta(m);
                p.sendMessage("§aItem has been renamed to: " + ChatColor.translateAlternateColorCodes('&', allArgs2));
            } else {
                p.sendMessage(Main.pre + "§cUsage: /rename [name]");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.rename permissions!");
        }
        return false;
    }
}

