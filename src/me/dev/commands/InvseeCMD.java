package me.dev.commands;

import me.dev.Main;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InvseeCMD implements CommandExecutor {
    private Main plugin;

    public InvseeCMD(Main plugin) {
        this.plugin = plugin;
        plugin.getCommand("invsee").setExecutor(this);

    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("invsee")) {
            Player p = (Player) sender;
            if (args.length == 0) {
                if (p.hasPermission("essentials.invsee") && p.isOp()) {
                    p.sendMessage("You don't have essentials.invsee permissions");
                    sender.sendMessage("§cUsage: /invsee <target> [armorContents = true/false]!");
                    return true;
                }
                Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
            } else {
                Inventory targetInv = p.getInventory();
                p.openInventory(targetInv);
                p.closeInventory();
            }
            Inventory inv = plugin.getServer().createInventory(null, 9, "Equipment");
            Player targetPlayer = Bukkit.getServer().getPlayer(args[0]);
            Player player = (Player) sender;
            ItemStack[] targetArmInv = targetPlayer.getInventory().getArmorContents();
            inv.setContents(targetArmInv);
            player.openInventory(inv);
            player.closeInventory();
            return true;
        }
        return false;
    }
}

