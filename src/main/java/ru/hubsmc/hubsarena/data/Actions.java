package ru.hubsmc.hubsarena.data;

import org.bukkit.event.inventory.ClickType;
import ru.hubsmc.hubsarena.HubsArena;

public enum Actions {

    TOSS(ClickType.RIGHT, Items.TOSSER_WAND, 80, 2),
    HEAL(ClickType.RIGHT, Items.HEALING_WAND, 80, 4),

    SHOOT1(ClickType.RIGHT, Items.COWBOY_PISTOL_1, 20, 0),
    SHOOT2(ClickType.RIGHT, Items.COWBOY_PISTOL_2, 20, 0),
    SHOOT3(ClickType.RIGHT, Items.COWBOY_PISTOL_3, 20, 0),
    SHOOT4(ClickType.RIGHT, Items.COWBOY_PISTOL_4, 20, 0),
    SHOOT5(ClickType.RIGHT, Items.COWBOY_PISTOL_5, 20, 0),

    LOAD0(ClickType.LEFT, Items.COWBOY_PISTOL_0, 80, 0),
    LOAD1(ClickType.LEFT, Items.COWBOY_PISTOL_1, 80, 0),
    LOAD2(ClickType.LEFT, Items.COWBOY_PISTOL_2, 80, 0),
    LOAD3(ClickType.LEFT, Items.COWBOY_PISTOL_3, 80, 0),
    LOAD4(ClickType.LEFT, Items.COWBOY_PISTOL_4, 80, 0),

    FIRST_TEST_ACTION(
            ClickType.valueOf(HubsArena.getStringConfigData("actions.FIRST_TEST_ACTION.clickType")),
            Items.valueOf(HubsArena.getStringConfigData("actions.FIRST_TEST_ACTION.item")),
            HubsArena.getIntConfigData("actions.FIRST_TEST_ACTION.cooldownInTicks"),
            HubsArena.getIntConfigData("actions.FIRST_TEST_ACTION.manaCost")
    ),
    SECOND_TEST_ACTION(
            ClickType.valueOf(HubsArena.getStringConfigData("actions.FIRST_TEST_ACTION.clickType")),
            Items.valueOf(HubsArena.getStringConfigData("actions.FIRST_TEST_ACTION.item")),
            HubsArena.getIntConfigData("actions.FIRST_TEST_ACTION.cooldownInTicks"),
            HubsArena.getIntConfigData("actions.FIRST_TEST_ACTION.manaCost")
    );

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
        if (item == null) {
            return null;
        }

        for (Actions action: Actions.values()) {
            if (action.item.getItemStack().equals(item.getItemStack())) {
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
