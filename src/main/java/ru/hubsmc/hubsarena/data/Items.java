package ru.hubsmc.hubsarena.data;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import ru.hubsmc.hubsarena.HubsArena;
import ru.hubsmc.hubsarena.util.StringUtils;

import java.util.Arrays;
import java.util.List;

public enum Items {

    ARCHER_HELMET(
            Material.LEATHER_HELMET,
            "&lШляпа лучника",
            null,
            Color.fromRGB(6192150),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),
    TOSSER_WAND(
            Material.BEETROOT_SEEDS,
            "&lПодбрасывающий порошок",
            null,
            null,
            null,
            null
    ),
    HEALING_WAND(
            Material.BEETROOT_SOUP,
            "&lЦелебный супчик",
            null,
            null,
            null,
            null
    ),
    FIRST_TEST_ITEM(
            Material.getMaterial(HubsArena.getStringConfigData("items.FIRST_TEST_ITEM.material")),
            HubsArena.getStringConfigData("items.FIRST_TEST_ITEM.name"),
            HubsArena.getStringListConfigData("items.FIRST_TEST_ITEM.lore"),
            HubsArena.getIntConfigData("items.FIRST_TEST_ITEM.color"),
            HubsArena.getStringListConfigData("items.FIRST_TEST_ITEM.enchantments"),
            HubsArena.getIntegerListConfigData("items.FIRST_TEST_ITEM.levels")
    ),
    SECOND_TEST_ITEM(
            Material.getMaterial(HubsArena.getStringConfigData("items.SECOND_TEST_ITEM.material")),
            HubsArena.getStringConfigData("items.SECOND_TEST_ITEM.name"),
            HubsArena.getStringListConfigData("items.SECOND_TEST_ITEM.lore"),
            HubsArena.getIntConfigData("items.SECOND_TEST_ITEM.color"),
            HubsArena.getStringListConfigData("items.SECOND_TEST_ITEM.enchantments"),
            HubsArena.getIntegerListConfigData("items.SECOND_TEST_ITEM.levels")
    );

    private final ItemStack itemStack;

    Items(Material material, String name, String[] lore, Color color, Enchantment[] enchantments, int[] levels) {
        this.itemStack = init(material, name, lore, color, enchantments, levels);
    }

    Items(Material material, String name, List<String> lore, int color, List<String> enchantments, List<Integer> levels) {
        String[] aLore;
        Enchantment[] anEnchantments;
        int[] aLevels;

        if (lore == null) {
            aLore = null;
        } else {
            aLore = new String[lore.size()];
            aLore = lore.toArray(aLore);
        }

        if (enchantments == null) {
            anEnchantments = null;
        } else {
            anEnchantments = new Enchantment[enchantments.size()];
            for (int i = 0; i < enchantments.size(); i++) {
                anEnchantments[i] = Enchantment.getByName(enchantments.get(i));
            }
        }

        if (levels == null) {
            aLevels = null;
        } else {
            aLevels = new int[levels.size()];
            for (int i = 0; i < levels.size(); i++) {
                aLevels[i] = levels.get(i);
            }
        }

        this.itemStack = init(material, name, aLore, Color.fromRGB(color), anEnchantments, aLevels);
    }

    private ItemStack init(Material material, String name, String[] lore, Color color, Enchantment[] enchantments, int[] levels) {
        ItemStack itemStack = new ItemStack(material, 1);
        ItemMeta itemMeta = itemStack.getItemMeta();
        itemMeta.setDisplayName(StringUtils.replaceColor(name));

        if (lore != null)
            itemMeta.setLore(StringUtils.replaceColor(Arrays.asList(lore)));

        itemMeta.setUnbreakable(true);
        itemMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);

        if (enchantments != null) {
            for (int i = 0; i < enchantments.length; i++) {
                itemMeta.addEnchant(enchantments[i], levels[i], true);
            }
        }

        if ( material == Material.LEATHER_HELMET ||
                material == Material.LEATHER_CHESTPLATE ||
                material == Material.LEATHER_LEGGINGS ||
                material == Material.LEATHER_BOOTS) {
            LeatherArmorMeta leatherArmorMeta = (LeatherArmorMeta) itemMeta;
            leatherArmorMeta.setColor(color);
            itemStack.setItemMeta(leatherArmorMeta);
        } else {
            itemStack.setItemMeta(itemMeta);
        }
        return itemStack;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }

    public static Items getItemIfExist(ItemStack itemStack) {
        for (Items item : Items.values()) {
            if (item.itemStack.getType() == itemStack.getType()) {
                return item;
            }
        }
        return null;
    }

}
