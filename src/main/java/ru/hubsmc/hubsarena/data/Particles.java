package ru.hubsmc.hubsarena.data;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;

public enum Particles {

    TOSS_PARTICLE(
            Particle.CAMPFIRE_SIGNAL_SMOKE, 0, 0, 0,
            10, false, 0
    ),
    HEAL_PARTICLE(
            Particle.HEART, 0, 0, 0,
            10, false, 0
    ),
    JOIN_PARTICLE(
            Particle.DRAGON_BREATH, 0, 2, 0,
            10, true, 0
    ),


    TEST_DIRECTIONAL_PARTICLE(
            Particle.SMOKE_LARGE, 0, 0, 0,
            0, 0, 0, 1,
            10, false, 0
    ),
    TEST_REDSTONE_PARTICLE(
            0, 0, 0,
            Color.fromRGB(0, 255, 0), 3,
            10, false, 0
    ),
    TEST_SPELL_MOB_PARTICLE(
            Particle.SPELL_MOB, 0, 0, 0,
            Color.fromRGB(0, 0, 255), 1,
            10, false, 0
    ),
    TEST_NOTE_PARTICLE(
            0, 0, 0,
            5,
            10, false, 0
    ),
    TEST_ITEM_PARTICLE(
            Particle.ITEM_CRACK, 0, 0, 0,
            Material.BEEF,
            10, false, 0
    ),
    TEST_BLOCK_PARTICLE(
            Particle.FALLING_DUST, 0, 0, 0,
            Material.SAND,
            10, false, 0
    );

    private Particle particle;
    private double x;
    private double y;
    private double z;
    private int count = 0;
    private double s1 = 1;
    private double s2 = 1;
    private double s3 = 1;
    private double extra = 1;
    private Object data = null;
    private boolean force;
    private int outCount = 1;
    private int repeatTicks;

    //
    // Absolutely normal particles constructor
    //
    Particles(Particle particle, double x, double y, double z, int count, boolean force, int repeatTicks) {
        this.particle = particle;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
        this.force = force;
        this.repeatTicks = repeatTicks;
    }

    //
    // Directional particles constructor
    //
    Particles(Particle particle, double x, double y, double z, double x1, double y1, double z1, double speed, int count, boolean force, int repeatTicks) {
        this.particle = particle;
        this.x = x;
        this.y = y;
        this.z = z;
        this.s1 = x1;
        this.s2 = y1;
        this.s3 = z1;
        this.extra = speed;
        this.force = force;
        this.outCount = count;
        this.repeatTicks = repeatTicks;
    }

    // Redstone particles constructor
    //
    // possible particle type: REDSTONE
    Particles(double x, double y, double z, Color color, float size, int count, boolean force, int repeatTicks) {
        this.particle = Particle.REDSTONE;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
        this.data = new Particle.DustOptions(color, size);
        this.force = force;
        this.repeatTicks = repeatTicks;
    }

    // Spell mob particles constructor
    //
    // possible particle types: SPELL_MOB, SPELL_MOB_AMBIENT
    Particles(Particle particle, double x, double y, double z, Color color, double randomColorCoefficient, int count, boolean force, int repeatTicks) {
        this.particle = particle;
        this.x = x;
        this.y = y;
        this.z = z;
        this.s1 = color.getRed() / 255D;
        this.s2 = color.getGreen() / 255D;
        this.s3 = color.getBlue() / 255D;
        this.extra = randomColorCoefficient;
        this.force = force;
        this.outCount = count;
        this.repeatTicks = repeatTicks;
    }

    // Note particles constructor
    //
    // possible particle type: NOTE
    Particles(double x, double y, double z, int colorID, int count, boolean force, int repeatTicks) {
        this.particle = Particle.NOTE;
        this.x = x;
        this.y = y;
        this.z = z;
        this.s1 = colorID / 24D;
        this.force = force;
        this.outCount = count;
        this.repeatTicks = repeatTicks;
    }

    // Item/Block particles constructor
    //
    // possible particle types: ITEM_CRACK, BLOCK_CRACK, BLOCK_DUST, FALLING_DUST
    Particles(Particle particle, double x, double y, double z, Material material, int count, boolean force, int repeatTicks) {
        this.particle = particle;
        this.x = x;
        this.y = y;
        this.z = z;
        this.count = count;
        if (particle == Particle.ITEM_CRACK) {
            this.data = new ItemStack(material);
        } else {
            this.data = material.createBlockData();
        }
        this.force = force;
        this.repeatTicks = repeatTicks;
    }

    public Particle getParticle() {
        return particle;
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

    public int getCount() {
        return count;
    }

    public double getS1() {
        return s1;
    }

    public double getS2() {
        return s2;
    }

    public double getS3() {
        return s3;
    }

    public double getExtra() {
        return extra;
    }

    public Object getData() {
        return data;
    }

    public boolean isForce() {
        return force;
    }

    public int getOutCount() {
        return outCount;
    }

    public int getRepeatTicks() {
        return repeatTicks;
    }

}
