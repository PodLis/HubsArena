package ru.hubsmc.hubsarena.data;

import net.Indyuce.mmoitems.MMOItems;
import net.Indyuce.mmoitems.api.item.MMOItem;
import net.Indyuce.mmoitems.manager.ItemManager;
import org.bukkit.inventory.ItemStack;

public enum MiItems {

    PYRO_SWORD("sword", "KITPVP_PYROSWORD");

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
