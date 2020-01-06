package ru.hubsmc.hubsarena.data;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ru.hubsmc.hubsarena.HubsArena;

public enum PotionEffects {

    NORMAL_SPEED(PotionEffectType.SPEED, 9999999, 0),
    LOW_SPEED(PotionEffectType.SLOW, 9999999, 0),
    QUICK_SPEED(PotionEffectType.SPEED, 9999999, 2),

    FIRE_PROTECTION(PotionEffectType.FIRE_RESISTANCE, 9999999, 1),
    FALL_PROTECTION(PotionEffectType.SLOW_FALLING, 9999999, 2),

    INVISIBILITY(PotionEffectType.INVISIBILITY, 9999999, 2),

    FIRST_TEST_EFFECT(
            PotionEffectType.getByName(HubsArena.getStringConfigData("effects.FIRST_TEST_EFFECT.effectType")),
            HubsArena.getIntConfigData("effects.FIRST_TEST_EFFECT.duration"),
            HubsArena.getIntConfigData("effects.FIRST_TEST_EFFECT.amplifier")
    ),
    SECOND_TEST_EFFECT(
            PotionEffectType.getByName(HubsArena.getStringConfigData("effects.SECOND_TEST_EFFECT.effectType")),
            HubsArena.getIntConfigData("effects.SECOND_TEST_EFFECT.duration"),
            HubsArena.getIntConfigData("effects.SECOND_TEST_EFFECT.amplifier")
    );

    private final PotionEffect potionEffect;

    PotionEffects(PotionEffectType effectType, int duration, int amplifier) {
        this.potionEffect = new PotionEffect(effectType, duration, amplifier, false, false);
    }

    public PotionEffect getPotionEffect() {
        return potionEffect;
    }

}
