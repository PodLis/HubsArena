package ru.hubsmc.hubsarena.util;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.potion.PotionEffect;

public class PlayerUtils {

    public static void curePotionEffects(Player player) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

    public static ClickType getClickType(Action action, boolean isSneaking) {
        if (isSneaking) {
            return action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK ? ClickType.SHIFT_RIGHT : ClickType.SHIFT_LEFT;
        }
        return action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK ? ClickType.RIGHT : ClickType.LEFT;
    }

}
