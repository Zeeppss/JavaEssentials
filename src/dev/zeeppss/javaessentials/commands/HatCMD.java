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
            Player player = (Player) sender;
            if (player.hasPermission("essentials.hat")) {
                if (args.length == 0) {
                    if (player.getInventory().getItemInHand().getType() != Material.AIR) {
                        ItemStack itemHand = player.getInventory().getItemInHand();
                        PlayerInventory inventory = player.getInventory();
                        ItemStack itemHead = inventory.getHelmet();
                        inventory.removeItem(new ItemStack[]{itemHand});
                        inventory.setHelmet(itemHand);
                        inventory.setItemInHand(itemHead);
                        player.sendMessage(Main.pre + "§aItem successfuly put on your head.");
                        return true;
                    }
                    player.sendMessage(Main.pre + "§cYou must have something to put on your head!");
                    return true;
                } else {
                    player.sendMessage("§cUsage: /hat");
                }
            } else {
                player.sendMessage(Main.pre + "§cYou don't have essentials.hat permissions!");
            }
            return false;
        }
    }
}