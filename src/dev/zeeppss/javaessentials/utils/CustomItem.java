package dev.zeeppss.javaessentials.utils;

import java.util.Arrays;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomItem {
    private final ItemStack item;

    public CustomItem(String name, String description, Material mat) {
        this.item = new ItemStack(mat, 1);
        ItemMeta meta = this.item.getItemMeta();
        meta.setLore(Arrays.asList(ChatColor.RESET + description));
        this.item.setItemMeta(meta);
    }

    public void addEnchantment(Enchantment enchant, int level) {
        ItemMeta meta = this.item.getItemMeta();
        meta.addEnchant(enchant, level, true);
        this.item.setItemMeta(meta);
    }

    public ItemStack getItem() {
        return this.item;
    }
}
