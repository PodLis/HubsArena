package ru.hubsmc.hubsarena.data;

import org.bukkit.event.inventory.ClickType;

public enum Actions {

    TOSS(ClickType.RIGHT, Items.TOSSER_WAND, 80),
    HEAL(ClickType.RIGHT, Items.HEALING_WAND, 80);

    private ClickType clickType;
    private Items item;
    private int cooldownInTicks;

    Actions(ClickType clickType, Items item, int cooldownInTicks) {
        this.clickType = clickType;
        this.item = item;
        this.cooldownInTicks = cooldownInTicks;
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
}
