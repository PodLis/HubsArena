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
     *  Berserk kit:
     *  - Armor
     *  - Weapon
     */
    BERSERK_HELMET(
            Material.LEATHER_HELMET,
            "&lСуровый шлем викинга",
            new String[]{
                    "&5Они надевают их чтобы запугать врагов!"
            },
            Color.fromRGB(0x8c460b),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    BERSERK_CHESTPLATE(
            Material.LEATHER_CHESTPLATE,
            "&lСурово выглядящая рубаха",
            new String[]{
                    "&5Смотрится круто!"
            },
            Color.fromRGB(0x8c460b),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    BERSERK_PANTS(
            Material.LEATHER_LEGGINGS,
            "&lШтаны викинга",
            new String[]{
                    "&5Суровые боевые штаны!"
            },
            Color.fromRGB(0x8c460b),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    BERSERK_BOOTS(
            Material.LEATHER_BOOTS,
            "&lСапоги викинга",
            new String[]{
                    "&5В них ты прошел через тысячи боёв!",
                    "&5В них тебе не стыдно будет топтать земли Вальхаллы!"
            },
            Color.fromRGB(0x8c460b),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    BERSERK_AXE_1(
            Material.IRON_AXE,
            "&lТопор викинга! &a&lI",
            new String[]{
                    "&5С каждым убийством он будто становится острее!",
                    "&5Ровно также, как и сверепеет его хозяин!"
            },
            null,
            new Enchantment[]{Enchantment.DAMAGE_ALL},
            new int[]{1}
    ),

    BERSERK_AXE_2(
            Material.IRON_AXE,
            "&lТопор викинга! &e&lII",
            new String[]{
                    "&5С каждым убийством он будто становится острее!",
                    "&5Ровно также, как и сверепеет его хозяин!"
            },
            null,
            new Enchantment[]{Enchantment.DAMAGE_ALL},
            new int[]{3}
    ),

    BERSERK_AXE_3(
            Material.IRON_AXE,
            "&lКровавый топор викинга! &6&lIII",
            new String[]{
                    "&5С каждым убийством он будто становится острее!",
                    "&5Ровно также, как и сверепеет его хозяин!"
            },
            null,
            new Enchantment[]{Enchantment.DAMAGE_ALL},
            new int[]{6}
    ),

    BERSERK_AXE_4(
            Material.IRON_AXE,
            "&lКровожадный топор викинга! &c&lIV",
            new String[]{
                    "&5С каждым убийством он будто становится острее!",
                    "&5Ровно также, как и сверепеет его хозяин!"
            },
            null,
            new Enchantment[]{Enchantment.DAMAGE_ALL},
            new int[]{10}
    ),

    BERSERK_AXE_5(
            Material.IRON_AXE,
            "&lЗачарованный топор викинга! &5&lV",
            new String[]{
                    "&5Этот топор изничтожил десятки врагов!",
                    "&5Один явно на твоей стороне!"
            },
            null,
            new Enchantment[]{Enchantment.DAMAGE_ALL},
            new int[]{15}
    ),


    /*
     *  Archer kit:
     *  - Armor
     *  - Bow
     *  - Arrow x1
     */
    END_HELMET(
            Material.LEATHER_HELMET,
            "&lШляпа Енда",
            new String[]{
                    "&5От нежданчиков в голову не телепортируешься!"
            },
            Color.fromRGB(0xB284BE),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    END_CHESTPLATE(
            Material.LEATHER_CHESTPLATE,
            "&lРубашка Енда",
            new String[]{
                    "&5Это не совсем броня, но смотрится красиво!"
            },
            Color.fromRGB(0xB284BE),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    END_PANTS(
            Material.LEATHER_LEGGINGS,
            "&lШтаны Енда",
            new String[]{
                    "&5При телепортации не забывай про них!"
            },
            Color.fromRGB(0xB284BE),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    END_BOOTS(
            Material.LEATHER_BOOTS,
            "&lСапоги Енда",
            new String[]{
                    "&5Иногда и побегать в радость..."
            },
            Color.fromRGB(0xB284BE),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),

    END_BOX(
            Material.PURPLE_SHULKER_BOX,
            "&lКарманный шалкербокс",
            new String[]{
                    "&5Хмм... Что же внутри...?"
            },
            Color.fromRGB(0xB284BE),
            new Enchantment[]{Enchantment.PROTECTION_ENVIRONMENTAL},
            new int[]{2}
    ),


    /*
     *  Flyer
     */
    FLYER_CHEST(
            Material.ELYTRA,
            "&lКрылья",
            new String[]{
                    "&5Просто крылья..."
            },
            null,
            null,
            null
    ),


    /*
     *  Cowboy
     *  - Armor
     *  - Weapon states
     */

    COWBOY_CHESTPLATE(
            Material.LEATHER_CHESTPLATE,
            "&lРубашка ковбоя",
            new String[]{
                    "&5От пуль конечно не защитит, но ты и не подставляйся!"
            },
            Color.fromRGB(0xE8E8E8),
            new Enchantment[]{},
            new int[]{}
    ),

    COWBOY_PANTS(
            Material.LEATHER_LEGGINGS,
            "&lШтанишки дикого запада",
            new String[]{
                    "&5Ультра брутальные!"
            },
            Color.fromRGB(0x663000),
            new Enchantment[]{},
            new int[]{}
    ),

    COWBOY_BOOTS(
            Material.LEATHER_BOOTS,
            "&lСапоги ковбоя",
            new String[]{
                    "&5Шпоры остались на западе, вместе с лошадкой..."
            },
            Color.fromRGB(0x1F1F1F),
            new Enchantment[]{},
            new int[]{}
    ),

    COWBOY_PISTOL_0(
            Material.IRON_HORSE_ARMOR,
            "&lРевольвер: &c&lX",
            null,
            null,
            null,
            null
    ),

    COWBOY_PISTOL_1(
            Material.IRON_HORSE_ARMOR,
            "&lРевольвер: &e&lI",
            null,
            null,
            null,
            null
    ),

    COWBOY_PISTOL_2(
            Material.IRON_HORSE_ARMOR,
            "&lРевольвер: &e&lII",
            null,
            null,
            null,
            null
    ),

    COWBOY_PISTOL_3(
            Material.IRON_HORSE_ARMOR,
            "&lРевольвер: &6&lIII",
            null,
            null,
            null,
            null
    ),

    COWBOY_PISTOL_4(
            Material.IRON_HORSE_ARMOR,
            "&lРевольвер: &6&lIIII",
            null,
            null,
            null,
            null
    ),

    COWBOY_PISTOL_5(
            Material.IRON_HORSE_ARMOR,
            "&lРевольвер: &6&lIIIII",
            null,
            null,
            null,
            null
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
        String[] aLore = null;
        Enchantment[] anEnchantments = null;
        int[] aLevels = null;

        if (lore != null) {
            aLore = new String[lore.size()];
            aLore = lore.toArray(aLore);
        }

        if (enchantments != null) {
            anEnchantments = new Enchantment[enchantments.size()];
            for (int i = 0; i < enchantments.size(); i++) {
                anEnchantments[i] = Enchantment.getByName(enchantments.get(i));
            }
        }

        if (levels != null) {
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

    public static Items getItemIfExist(ItemMeta itemMeta) {
        for (Items item : Items.values()) {
            if (item.itemStack.getItemMeta().equals(itemMeta)) {
                return item;
            }
        }
        return null;
    }

}
