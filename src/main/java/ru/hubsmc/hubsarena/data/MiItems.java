package ru.hubsmc.hubsarena.data;

import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.item.MMOItem;
import net.Indyuce.mmoitems.manager.ItemManager;
import org.bukkit.inventory.ItemStack;
import ru.hubsmc.hubsarena.HubsArena;

public enum MiItems {

    PYRO_SWORD("sword", "KITPVP_PYROSWORD"),
    FIRST_TEST_MI_ITEM(
            HubsArena.getStringConfigData("miitems.FIRST_TEST_MI_ITEM.itemType"),
            HubsArena.getStringConfigData("miitems.FIRST_TEST_MI_ITEM.itemName")
    ),
    SECOND_TEST_MI_ITEM(
            HubsArena.getStringConfigData("miitems.SECOND_TEST_MI_ITEM.itemType"),
            HubsArena.getStringConfigData("miitems.SECOND_TEST_MI_ITEM.itemName")
    );

    private final ItemStack itemStack;

    MiItems(String itemType, String itemName) {
        ItemStack item;
        try {
            ItemManager itemManager = MMOItems.plugin.getItems();
            MMOItem mmoitem = itemManager.getMMOItem(MMOItems.plugin.getTypes().get(itemType.toUpperCase()), itemName);
            item = mmoitem.newBuilder().build();
        } catch (Exception e) {
            e.printStackTrace();
            item = null;
        }
        itemStack = item;
    }

    public ItemStack getItemStack() {
        return itemStack;
    }
}
