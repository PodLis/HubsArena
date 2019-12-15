package ru.hubsmc.hubsarena.data;

import org.bukkit.Sound;
import ru.hubsmc.hubsarena.HubsArena;

public enum Sounds {

    TOSS_SOUND(
            Sound.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON,
            0, 0, 0,
            1.0f, 1.0f
    ),
    HEAL_SOUND(
            Sound.ENTITY_EXPERIENCE_ORB_PICKUP,
            0, 0, 0,
            1.0f, 1.0f
    ),
    FIRST_TEST_SOUND(
            Sound.valueOf(HubsArena.getStringConfigData("sounds.FIRST_TEST_SOUND.sound")),
            HubsArena.getDoubleConfigData("sounds.FIRST_TEST_SOUND.offsetX"),
            HubsArena.getDoubleConfigData("sounds.FIRST_TEST_SOUND.offsetY"),
            HubsArena.getDoubleConfigData("sounds.FIRST_TEST_SOUND.offsetZ"),
            (float) HubsArena.getDoubleConfigData("sounds.FIRST_TEST_SOUND.volume"),
            (float) HubsArena.getDoubleConfigData("sounds.FIRST_TEST_SOUND.pitch")
    ),
    SECOND_TEST_SOUND(
            Sound.valueOf(HubsArena.getStringConfigData("sounds.SECOND_TEST_SOUND.sound")),
            HubsArena.getDoubleConfigData("sounds.SECOND_TEST_SOUND.offsetX"),
            HubsArena.getDoubleConfigData("sounds.SECOND_TEST_SOUND.offsetY"),
            HubsArena.getDoubleConfigData("sounds.SECOND_TEST_SOUND.offsetZ"),
            (float) HubsArena.getDoubleConfigData("sounds.SECOND_TEST_SOUND.volume"),
            (float) HubsArena.getDoubleConfigData("sounds.SECOND_TEST_SOUND.pitch")
    );

    private Sound sound;
    private double offsetX;
    private double offsetY;
    private double offsetZ;
    private float volume;
    private float pitch;

    Sounds(Sound sound, double offsetX, double offsetY, double offsetZ, float volume, float pitch) {
        this.sound = sound;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.volume = volume;
        this.pitch = pitch;
    }

    public Sound getSound() {
        return sound;
    }

    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public double getOffsetZ() {
        return offsetZ;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

}
