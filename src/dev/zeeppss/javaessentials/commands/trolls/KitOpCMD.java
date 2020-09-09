package dev.zeeppss.javaessentials.commands.trolls;

import java.util.HashMap;
import java.util.logging.Logger;

import dev.zeeppss.javaessentials.Main;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class KitOpCMD implements CommandExecutor {
    public KitOpCMD() {
    }

    public final Logger logger = Logger.getLogger("Minecraft");
    public HashMap<Player, ItemStack[]> Things = new HashMap();

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("§cPlayer only!");
            return true;
        }
        Player player = (Player) sender;
        if (player.hasPermission("essentials.kitop")) {
            player.sendMessage(Main.pre + "§aYou have KitOp now!");
            ItemStack stack = new ItemStack(Material.DIAMOND_CHESTPLATE);
            ItemMeta meta = stack.getItemMeta();
            meta.setDisplayName("§cOpChestplate");
            stack.setItemMeta(meta);
            ItemStack H = new ItemStack(Material.DIAMOND_HELMET);
            ItemMeta HMeta = H.getItemMeta();
            HMeta.setDisplayName("§cOpHelmet");
            H.setItemMeta(HMeta);
            ItemStack b = new ItemStack(Material.DIAMOND_BOOTS);
            ItemMeta bMeta = b.getItemMeta();
            bMeta.setDisplayName("§cOpBoots");
            b.setItemMeta(bMeta);
            ItemStack l = new ItemStack(Material.DIAMOND_LEGGINGS);
            ItemMeta lMeta = l.getItemMeta();
            lMeta.setDisplayName("§cOpLeggings");
            l.setItemMeta(lMeta);
            ItemStack Sword = new ItemStack(Material.DIAMOND_SWORD);
            ItemMeta SwordMeta = Sword.getItemMeta();
            SwordMeta.setDisplayName("§cOpSword");
            Sword.setItemMeta(SwordMeta);
            ItemStack Bow = new ItemStack(Material.BOW);
            ItemMeta BowMeta = Bow.getItemMeta();
            BowMeta.setDisplayName("§cOpBow");
            Bow.setItemMeta(BowMeta);
            ItemStack Arrow = new ItemStack(Material.ARROW);
            ItemMeta ArrowMeta = Arrow.getItemMeta();
            ArrowMeta.setDisplayName("§cOpArrow");
            Arrow.setItemMeta(ArrowMeta);
            ItemStack p = new ItemStack(Material.DIAMOND_PICKAXE);
            ItemMeta pMeta = p.getItemMeta();
            pMeta.setDisplayName("§cOpPickaxe");
            p.setItemMeta(pMeta);
            ItemStack Spade = new ItemStack(Material.DIAMOND_SPADE);
            ItemMeta SpadeMeta = Spade.getItemMeta();
            SpadeMeta.setDisplayName("§cOpSpade");
            Spade.setItemMeta(SpadeMeta);
            ItemStack Axe = new ItemStack(Material.DIAMOND_AXE);
            ItemMeta AxeMeta = Spade.getItemMeta();
            AxeMeta.setDisplayName("§cOpAxe");
            Axe.setItemMeta(AxeMeta);
            b.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
            l.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
            H.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
            stack.addUnsafeEnchantment(Enchantment.PROTECTION_ENVIRONMENTAL, 1000);
            Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1000);
            Sword.addUnsafeEnchantment(Enchantment.FIRE_ASPECT, 1000);
            Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 1000);
            Sword.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 1000);
            Sword.addUnsafeEnchantment(Enchantment.KNOCKBACK, 1000);
            Sword.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            Sword.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1000);
            stack.addUnsafeEnchantment(Enchantment.THORNS, 1000);
            Sword.addUnsafeEnchantment(Enchantment.LOOT_BONUS_MOBS, 1000);
            b.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1000);
            l.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1000);
            H.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1000);
            stack.addUnsafeEnchantment(Enchantment.PROTECTION_EXPLOSIONS, 1000);
            b.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 1000);
            l.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 1000);
            H.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 1000);
            stack.addUnsafeEnchantment(Enchantment.PROTECTION_FALL, 1000);
            b.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1000);
            l.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1000);
            H.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1000);
            stack.addUnsafeEnchantment(Enchantment.PROTECTION_FIRE, 1000);
            b.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1000);
            l.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1000);
            H.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1000);
            stack.addUnsafeEnchantment(Enchantment.PROTECTION_PROJECTILE, 1000);
            b.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1000);
            l.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1000);
            H.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1000);
            stack.addUnsafeEnchantment(Enchantment.WATER_WORKER, 1000);
            b.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            l.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            H.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            stack.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            Bow.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            Bow.addUnsafeEnchantment(Enchantment.ARROW_DAMAGE, 1000);
            Bow.addUnsafeEnchantment(Enchantment.ARROW_FIRE, 1000);
            Bow.addUnsafeEnchantment(Enchantment.ARROW_INFINITE, 1000);
            Bow.addUnsafeEnchantment(Enchantment.ARROW_KNOCKBACK, 1000);
            p.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1000);
            p.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            p.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1000);
            p.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1000);
            Spade.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1000);
            Spade.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1000);
            Spade.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            Spade.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1000);
            Axe.addUnsafeEnchantment(Enchantment.DIG_SPEED, 1000);
            Axe.addUnsafeEnchantment(Enchantment.SILK_TOUCH, 1000);
            Axe.addUnsafeEnchantment(Enchantment.DURABILITY, 1000);
            Axe.addUnsafeEnchantment(Enchantment.LOOT_BONUS_BLOCKS, 1000);
            Axe.addUnsafeEnchantment(Enchantment.DAMAGE_ALL, 1000);
            Axe.addUnsafeEnchantment(Enchantment.DAMAGE_UNDEAD, 1000);
            Axe.addUnsafeEnchantment(Enchantment.DAMAGE_ARTHROPODS, 1000);
            player.getInventory().setHelmet(H);
            player.getInventory().setChestplate(stack);
            player.getInventory().setLeggings(l);
            player.getInventory().setBoots(b);
            player.getInventory().addItem(new ItemStack[]{Sword});
            player.getInventory().addItem(new ItemStack[]{Bow});
            player.getInventory().addItem(new ItemStack[]{Arrow});
            player.getInventory().addItem(new ItemStack[]{p});
            player.getInventory().addItem(new ItemStack[]{Spade});
            player.getInventory().addItem(new ItemStack[]{Axe});
        } else {
            player.sendMessage(Main.pre + "§cYou don't have essentials.kitop permissions!");
        }
        return false;
    }
}
