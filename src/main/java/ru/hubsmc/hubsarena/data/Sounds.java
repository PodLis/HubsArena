package ru.hubsmc.hubsarena.data;

import org.bukkit.Sound;

public enum Sounds {

    TOSS_SOUND(
            Sound.BLOCK_STONE_PRESSURE_PLATE_CLICK_ON, 0, 0, 0,
            1.0f, 1.0f
    ),
    HEAL_SOUND(
            Sound.ENTITY_EXPERIENCE_ORB_PICKUP, 0, 0, 0,
            1.0f, 1.0f
    );

    private Sound sound;
    private double x;
    private double y;
    private double z;
    private float volume;
    private float pitch;

    Sounds(Sound sound, double x, double y, double z, float volume, float pitch) {
        this.sound = sound;
        this.x = x;
        this.y = y;
        this.z = z;
        this.volume = volume;
        this.pitch = pitch;
    }

    public Sound getSound() {
        return sound;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getZ() {
        return z;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

}
