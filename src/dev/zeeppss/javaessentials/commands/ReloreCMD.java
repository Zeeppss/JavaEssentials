package dev.zeeppss.javaessentials.commands;

import java.util.ArrayList;
import java.util.List;

import dev.zeeppss.javaessentials.Main;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class ReloreCMD implements CommandExecutor {
    public ReloreCMD() {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§Player only!");
            return false;
        }
        Player p = (Player) sender;
        if (p.hasPermission("essentials.relore")) {
            if (args.length == 0) {
                StringBuilder sb1 = new StringBuilder();

                for (int f = 0; f < args.length; ++f) {
                    sb1.append(args[f]).append(" ");
                }

                String allArgs2 = sb1.toString().trim();
                ItemStack item = p.getInventory().getItemInHand();
                ItemMeta m = item.getItemMeta();
                List lore = new ArrayList();
                lore.add(ChatColor.translateAlternateColorCodes('&', allArgs2));
                m.setLore(lore);
                item.setItemMeta(m);
                p.sendMessage("§aItem lore has been set to: " + ChatColor.translateAlternateColorCodes('&', allArgs2));
            } else {
                p.sendMessage(Main.pre + "§cUsage: /relore [name]");
            }
        } else {
            p.sendMessage(Main.pre + "§cYou don't have essentials.relore permissions!");
        }
        return false;
    }
}
