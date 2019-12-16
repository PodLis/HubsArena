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
    /*
     *  Common items
     */
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

    /*
     *  Archer kit:
     *  - Armor
     *  - Bow
     *  - Arrow x1
     */
    ARCHER_HELMET(
            Material.LEATHER_HELMET,
            "&lШляпа лучника",
            new String[]{
                    "&5Остерегайся попаданий в голову!",
                    "&5Это просто зеленая шляпа!"
            },
            Color.fromRGB(6192150),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    ARCHER_CHESTPLATE(
            Material.LEATHER_CHESTPLATE,
            "&lРубашка лучника",
            new String[]{
                    "&5Это не совсем броня, но смотрится красиво!"
            },
            Color.fromRGB(6192150),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    ARCHER_PANTS(
            Material.LEATHER_LEGGINGS,
            "&lШтаны лучника",
            new String[]{
                    "&5Боевые штанишки!"
            },
            Color.fromRGB(6192150),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    ARCHER_BOOTS(
            Material.LEATHER_BOOTS,
            "&lСапоги лучника",
            new String[]{
                    "&5Ну, по ногам то редко прилетает...",
                    "&5Так что мы выдали вам простые ботинки."
            },
            Color.fromRGB(6192150),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    ARCHER_ARROW(
            Material.ARROW,
            "&lСтрела",
            null,
            null,
            new Enchantment[]{},
            new int[]{}
    ),

    /*
     *  Heavy kit:
     *  - Armor
     *  - Sword
     *  - Shield
     */
    KNIGHT_HELMET(
            Material.IRON_HELMET,
            "&lШлем",
            new String[]{
                    "&5Береги голову!"
            },
            null,
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    KNIGHT_CHESTPLATE(
            Material.IRON_CHESTPLATE,
            "&lНагрудник",
            new String[]{
                    "&lТупо броня!"
            },
            null,
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    KNIGHT_PANTS(
            Material.IRON_LEGGINGS,
            "Штаны",
            new String[]{
                    "&lВ них конечно же не побегаешь...",
                    "&lНо за жопу точно не страшно!"
            },
            null,
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    KNIGHT_BOOTS(
            Material.IRON_BOOTS,
            "&lСапоги",
            new String[]{
                    "&5Таким тапком не только таракана убить можно..."
            },
            null,
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    KNIGHT_SWORD(
            Material.IRON_SWORD,
            "&lТяжеленный меч!",
            new String[]{
                    "&5Таким по лбу лучше лишний раз не получать..."
            },
            null,
            new Enchantment[]{Enchantment.DAMAGE_ALL, Enchantment.KNOCKBACK},
            new int[]{4, 2}
    ),

    KNIGHT_SHIELD(
            Material.SHIELD,
            "&lБашенный щит",
            new String[]{
                    "&5Идеальный стрелоприемник!"
            },
            null,
            new Enchantment[]{},
            new int[]{}
    ),

    /*
     *  Pyro kit:
     *  - Armor
     *  - Sword
     */
    PYRO_HELMET(
            Material.LEATHER_HELMET,
            "&lШляпа пироманта",
            new String[]{
                    "&5В огне не горит!",
                    "&5В воде... А, не. В воде тонет..."
            },
            Color.fromRGB(0xFF7E00),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    PYRO_CHESTPLATE(
            Material.LEATHER_CHESTPLATE,
            "&lРубашка пироманта",
            new String[]{
                    "&5Одежда с огоньком!"
            },
            Color.fromRGB(0xFF7E00),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    PYRO_PANTS(
            Material.LEATHER_LEGGINGS,
            "&lШтаны пироманта",
            new String[]{
                    "&5Немного в саже, но смотрятся просто огонь!"
            },
            Color.fromRGB(0xFF7E00),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    PYRO_BOOTS(
            Material.LEATHER_BOOTS,
            "&lСапоги пироманта",
            new String[]{
                    "&5Вы видели тех монахов, которые ходят по углям?",
                    "&5Там где ходишь ты - там и уголь сам собой появляется!"
            },
            Color.fromRGB(0xFF7E00),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),


    /*
     *  Another
     */

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

    /*
     *  Implementation of some methods:
     */
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
        itemMeta.addItemFlags(
                ItemFlag.HIDE_ATTRIBUTES,
                ItemFlag.HIDE_UNBREAKABLE,
                ItemFlag.HIDE_ENCHANTS
        );

        if (enchantments != null) {
            for (int i = 0; i < enchantments.length; i++) {
                itemMeta.addEnchant(enchantments[i], levels[i], true);
            }
        }

        if ( material == Material.LEATHER_HELMET ||
             material == Material.LEATHER_CHESTPLATE ||
             material == Material.LEATHER_LEGGINGS ||
             material == Material.LEATHER_BOOTS ) {
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
