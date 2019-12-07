package ru.hubsmc.hubsarena.data;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public enum Effects {

    NORMAL_SPEED(PotionEffectType.SPEED, 9999999, 0);

    private final PotionEffect potionEffect;

    Effects(PotionEffectType effectType, int duration, int amplifier) {
        this.potionEffect = new PotionEffect(effectType, duration, amplifier, false, false);
    }

    public PotionEffect getPotionEffect() {
        return potionEffect;
    }

}
