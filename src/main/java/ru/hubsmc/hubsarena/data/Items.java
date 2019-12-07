package ru.hubsmc.hubsarena.data;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import ru.hubsmc.hubsarena.util.StringUtils;

import java.util.Arrays;

public enum Items {

    ARCHER_HELMET(Material.LEATHER_HELMET, "&lШляпа лучника", null, Color.fromRGB(6192150),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL}, new int[]{2});

    private final ItemStack itemStack;

    Items(Material material, String name, String[] lore, Color color, Enchantment[] enchantments, int[] levels) {
        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.replaceColor(name));
        if (lore != null)
            itemMeta.setLore(StringUtils.replaceColor(Arrays.asList(lore)));
        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        for (int i = 0; i < enchantments.length; i++) {
            itemMeta.addEnchant(enchantments[i], levels[i], true);
        }
        if (    material == Material.LEATHER_HELMET ||
                material == Material.LEATHER_CHESTPLATE ||
                material == Material.LEATHER_LEGGINGS ||
                material == Material.LEATHER_BOOTS) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
            leatherArmorMeta.setColor(color);
            itemStack.setItemMeta(leatherArmorMeta);
        } else {
            itemStack.setItemMeta(itemMeta);
        }
        this.itemStack = itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

}
