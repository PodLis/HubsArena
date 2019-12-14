package ru.hubsmc.hubsarena.data;

import org.bukkit.event.inventory.ClickType;

public enum Actions {

    TOSS(ClickType.RIGHT, Items.TOSSER_WAND, 80, 2),
    HEAL(ClickType.RIGHT, Items.HEALING_WAND, 80, 4);

    private ClickType clickType;
    private Items item;
    private int cooldownInTicks;
    private int manaCost;

    Actions(ClickType clickType, Items item, int cooldownInTicks, int manaCost) {
        this.clickType = clickType;
        this.item = item;
        this.cooldownInTicks = cooldownInTicks;
        this.manaCost = manaCost;
    }

    public static Actions getActionIfExist(ClickType clickType, Items item) {
        for (Actions action : Actions.values()) {
            if (action.item == item) {
                if (action.clickType == clickType) {
                    return action;
                }
            }
        }
        return null;
    }

    public int getCooldownInTicks() {
        return cooldownInTicks;
    }

    public int getManaCost() {
        return manaCost;
    }
}
