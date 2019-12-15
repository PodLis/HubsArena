package ru.hubsmc.hubsarena.data;

import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import ru.hubsmc.hubsarena.HubsArena;

public enum PotionEffects {

    NORMAL_SPEED(PotionEffectType.SPEED, 9999999, 0),
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
