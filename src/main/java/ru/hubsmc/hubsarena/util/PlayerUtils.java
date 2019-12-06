package ru.hubsmc.hubsarena.util;

import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PlayerUtils {

    public static void curePotionEffects(Player player) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

}
