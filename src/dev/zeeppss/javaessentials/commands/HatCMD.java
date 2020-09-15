package dev.zeeppss.javaessentials.commands;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class HatCMD implements CommandExecutor {
    public HatCMD() {
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage(Main.pre + "§cPlayer only!");
            return false;
        } else {
            Player p = (Player) sender;
            if (p.hasPermission("essentials.hat")) {
                if (args.length == 0) {
                    if (p.getInventory().getItemInHand().getType() != Material.AIR) {
                        ItemStack itemHand = p.getInventory().getItemInHand();
                        PlayerInventory inventory = p.getInventory();
                        ItemStack itemHead = inventory.getHelmet();
                        inventory.removeItem(new ItemStack[]{itemHand});
                        inventory.setHelmet(itemHand);
                        inventory.setItemInHand(itemHead);
                        p.sendMessage(Main.pre + "§aItem successfuly put on your head.");
                        return true;
                    }
                    p.sendMessage(Main.pre + "§cYou must have something to put on your head!");
                    return true;
                } else {
                    p.sendMessage("§cUsage: /hat");
                }
            } else {
                p.sendMessage(Main.pre + "§cYou don't have essentials.hat permissions!");
            }
            return false;
        }
    }
}