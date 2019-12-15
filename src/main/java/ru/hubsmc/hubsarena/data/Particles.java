package ru.hubsmc.hubsarena.data;

import org.bukkit.*;
import org.bukkit.inventory.ItemStack;
import ru.hubsmc.hubsarena.HubsArena;

public enum Particles {

    TOSS_PARTICLE(
            Particle.CAMPFIRE_SIGNAL_SMOKE,
            0, 0, 0,
            1, 1, 1,
            10, false, 0
    ),
    HEAL_PARTICLE(
            0, 0, 0,
            1, 1, 1,
            Color.fromRGB(0, 255, 0), 3,
            10, false, 0
    ),
    JOIN_PARTICLE(
            Particle.DRAGON_BREATH,
            0, 2, 0,
            1, 1, 1,
            10, true, 0
    ),


    TEST_NORMAL_PARTICLE(
            Particle.valueOf(HubsArena.getStringConfigData("particles.TEST_NORMAL_PARTICLE.particle")),
            HubsArena.getDoubleConfigData("particles.TEST_NORMAL_PARTICLE.offsetX"), HubsArena.getDoubleConfigData("particles.TEST_NORMAL_PARTICLE.offsetY"), HubsArena.getDoubleConfigData("particles.TEST_NORMAL_PARTICLE.offsetZ"),
            HubsArena.getDoubleConfigData("particles.TEST_NORMAL_PARTICLE.spreadX"), HubsArena.getDoubleConfigData("particles.TEST_NORMAL_PARTICLE.spreadY"), HubsArena.getDoubleConfigData("particles.TEST_NORMAL_PARTICLE.spreadZ"),
            HubsArena.getIntConfigData("particles.TEST_NORMAL_PARTICLE.count"), HubsArena.getBooleanConfigData("particles.TEST_NORMAL_PARTICLE.force"), HubsArena.getIntConfigData("particles.TEST_NORMAL_PARTICLE.repeatTicks")
    ),
    TEST_DIRECTIONAL_PARTICLE(
            Particle.valueOf(HubsArena.getStringConfigData("particles.TEST_DIRECTIONAL_PARTICLE.particle")),
            HubsArena.getDoubleConfigData("particles.TEST_DIRECTIONAL_PARTICLE.offsetX1"), HubsArena.getDoubleConfigData("particles.TEST_DIRECTIONAL_PARTICLE.offsetY1"), HubsArena.getDoubleConfigData("particles.TEST_DIRECTIONAL_PARTICLE.offsetZ1"),
            HubsArena.getDoubleConfigData("particles.TEST_DIRECTIONAL_PARTICLE.offsetX2"), HubsArena.getDoubleConfigData("particles.TEST_DIRECTIONAL_PARTICLE.offsetY2"), HubsArena.getDoubleConfigData("particles.TEST_DIRECTIONAL_PARTICLE.offsetZ2"),
            HubsArena.getDoubleConfigData("particles.TEST_DIRECTIONAL_PARTICLE.speed"),
            HubsArena.getIntConfigData("particles.TEST_DIRECTIONAL_PARTICLE.count"), HubsArena.getBooleanConfigData("particles.TEST_DIRECTIONAL_PARTICLE.force"), HubsArena.getIntConfigData("particles.TEST_DIRECTIONAL_PARTICLE.repeatTicks")
    ),
    TEST_REDSTONE_PARTICLE(
            HubsArena.getDoubleConfigData("particles.TEST_REDSTONE_PARTICLE.offsetX"), HubsArena.getDoubleConfigData("particles.TEST_REDSTONE_PARTICLE.offsetY"), HubsArena.getDoubleConfigData("particles.TEST_REDSTONE_PARTICLE.offsetZ"),
            HubsArena.getDoubleConfigData("particles.TEST_REDSTONE_PARTICLE.spreadX"), HubsArena.getDoubleConfigData("particles.TEST_REDSTONE_PARTICLE.spreadY"), HubsArena.getDoubleConfigData("particles.TEST_REDSTONE_PARTICLE.spreadZ"),
            Color.fromRGB(HubsArena.getIntConfigData("particles.TEST_REDSTONE_PARTICLE.red"), HubsArena.getIntConfigData("particles.TEST_REDSTONE_PARTICLE.green"), HubsArena.getIntConfigData("particles.TEST_REDSTONE_PARTICLE.blue")), (float) HubsArena.getDoubleConfigData("particles.TEST_REDSTONE_PARTICLE.size"),
            HubsArena.getIntConfigData("particles.TEST_REDSTONE_PARTICLE.count"), HubsArena.getBooleanConfigData("particles.TEST_REDSTONE_PARTICLE.force"), HubsArena.getIntConfigData("particles.TEST_REDSTONE_PARTICLE.repeatTicks")
    ),
    TEST_SPELL_MOB_PARTICLE(
            Particle.valueOf(HubsArena.getStringConfigData("particles.TEST_SPELL_MOB_PARTICLE.particle")),
            HubsArena.getDoubleConfigData("particles.TEST_SPELL_MOB_PARTICLE.offsetX"), HubsArena.getDoubleConfigData("particles.TEST_SPELL_MOB_PARTICLE.offsetY"), HubsArena.getDoubleConfigData("particles.TEST_SPELL_MOB_PARTICLE.offsetZ"),
            Color.fromRGB(HubsArena.getIntConfigData("particles.TEST_SPELL_MOB_PARTICLE.red"), HubsArena.getIntConfigData("particles.TEST_SPELL_MOB_PARTICLE.green"), HubsArena.getIntConfigData("particles.TEST_SPELL_MOB_PARTICLE.blue")), HubsArena.getDoubleConfigData("particles.TEST_SPELL_MOB_PARTICLE.randomColorCoefficient"),
            HubsArena.getIntConfigData("particles.TEST_SPELL_MOB_PARTICLE.count"), HubsArena.getBooleanConfigData("particles.TEST_SPELL_MOB_PARTICLE.force"), HubsArena.getIntConfigData("particles.TEST_SPELL_MOB_PARTICLE.repeatTicks")
    ),
    TEST_NOTE_PARTICLE(
            HubsArena.getDoubleConfigData("particles.TEST_NOTE_PARTICLE.offsetX"), HubsArena.getDoubleConfigData("particles.TEST_NOTE_PARTICLE.offsetY"), HubsArena.getDoubleConfigData("particles.TEST_NOTE_PARTICLE.offsetZ"),
            HubsArena.getIntConfigData("particles.TEST_NOTE_PARTICLE.colorID"),
            HubsArena.getIntConfigData("particles.TEST_NOTE_PARTICLE.count"), HubsArena.getBooleanConfigData("particles.TEST_NOTE_PARTICLE.force"), HubsArena.getIntConfigData("particles.TEST_NOTE_PARTICLE.repeatTicks")
    ),
    TEST_ITEM_PARTICLE(
            Particle.valueOf(HubsArena.getStringConfigData("particles.TEST_ITEM_PARTICLE.particle")),
            HubsArena.getDoubleConfigData("particles.TEST_ITEM_PARTICLE.offsetX"), HubsArena.getDoubleConfigData("particles.TEST_ITEM_PARTICLE.offsetY"), HubsArena.getDoubleConfigData("particles.TEST_ITEM_PARTICLE.offsetZ"),
            HubsArena.getDoubleConfigData("particles.TEST_ITEM_PARTICLE.spreadX"), HubsArena.getDoubleConfigData("particles.TEST_ITEM_PARTICLE.spreadY"), HubsArena.getDoubleConfigData("particles.TEST_ITEM_PARTICLE.spreadZ"),
            Material.getMaterial(HubsArena.getStringConfigData("particles.TEST_ITEM_PARTICLE.material")),
            HubsArena.getIntConfigData("particles.TEST_ITEM_PARTICLE.count"), HubsArena.getBooleanConfigData("particles.TEST_ITEM_PARTICLE.force"), HubsArena.getIntConfigData("particles.TEST_ITEM_PARTICLE.repeatTicks")
    ),
    TEST_BLOCK_PARTICLE(
            Particle.valueOf(HubsArena.getStringConfigData("particles.TEST_BLOCK_PARTICLE.particle")),
            HubsArena.getDoubleConfigData("particles.TEST_BLOCK_PARTICLE.offsetX"), HubsArena.getDoubleConfigData("particles.TEST_BLOCK_PARTICLE.offsetY"), HubsArena.getDoubleConfigData("particles.TEST_BLOCK_PARTICLE.offsetZ"),
            HubsArena.getDoubleConfigData("particles.TEST_BLOCK_PARTICLE.spreadX"), HubsArena.getDoubleConfigData("particles.TEST_BLOCK_PARTICLE.spreadY"), HubsArena.getDoubleConfigData("particles.TEST_BLOCK_PARTICLE.spreadZ"),
            Material.getMaterial(HubsArena.getStringConfigData("particles.TEST_BLOCK_PARTICLE.material")),
            HubsArena.getIntConfigData("particles.TEST_BLOCK_PARTICLE.count"), HubsArena.getBooleanConfigData("particles.TEST_BLOCK_PARTICLE.force"), HubsArena.getIntConfigData("particles.TEST_BLOCK_PARTICLE.repeatTicks")
    );

    private Particle particle;
    private double offsetX;
    private double offsetY;
    private double offsetZ;
    private int count = 0;
    private double s1;
    private double s2;
    private double s3;
    private double extra = 1;
    private Object data = null;
    private boolean force;
    private int outCount = 1;
    private int repeatTicks;

    //
    // Absolutely normal particles constructor
    //
    Particles(Particle particle,
              double offsetX, double offsetY, double offsetZ,
              double spreadX, double spreadY, double spreadZ,
              int count, boolean force, int repeatTicks) {
        this.particle = particle;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.s1 = spreadX;
        this.s2 = spreadY;
        this.s3 = spreadZ;
        this.count = count;
        this.force = force;
        this.repeatTicks = repeatTicks;
    }

    //
    // Directional particles constructor
    //
    Particles(Particle particle,
              double offsetX1, double offsetY1, double offsetZ1,
              double offsetX2, double offsetY2, double offsetZ2,
              double speed,
              int count, boolean force, int repeatTicks) {

        this.particle = particle;
        this.offsetX = offsetX1;
        this.offsetY = offsetY1;
        this.offsetZ = offsetZ1;
        this.s1 = offsetX2;
        this.s2 = offsetY2;
        this.s3 = offsetZ2;
        this.extra = speed;
        this.force = force;
        this.outCount = count;
        this.repeatTicks = repeatTicks;
    }

    // Redstone particles constructor
    //
    // possible particle type: REDSTONE
    Particles(
            double offsetX, double offsetY, double offsetZ,
            double spreadX, double spreadY, double spreadZ,
            Color color, float size,
            int count, boolean force, int repeatTicks) {

        this.particle = Particle.REDSTONE;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.s1 = spreadX;
        this.s2 = spreadY;
        this.s3 = spreadZ;
        this.count = count;
        this.data = new Particle.DustOptions(color, size);
        this.force = force;
        this.repeatTicks = repeatTicks;
    }

    // Spell mob particles constructor
    //
    // possible particle types: SPELL_MOB, SPELL_MOB_AMBIENT
    Particles(Particle particle,
              double offsetX, double offsetY, double offsetZ,
              Color color, double randomColorCoefficient,
              int count, boolean force, int repeatTicks) {

        this.particle = particle;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
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
    Particles(
            double offsetX, double offsetY, double offsetZ,
            int colorID,
            int count, boolean force, int repeatTicks) {

        this.particle = Particle.NOTE;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.s1 = colorID / 24D;
        this.s2 = 0;
        this.s3 = 0;
        this.force = force;
        this.outCount = count;
        this.repeatTicks = repeatTicks;
    }

    // Item/Block particles constructor
    //
    // possible particle types: ITEM_CRACK, BLOCK_CRACK, BLOCK_DUST, FALLING_DUST
    Particles(Particle particle,
              double offsetX, double offsetY, double offsetZ,
              double spreadX, double spreadY, double spreadZ,
              Material material,
              int count, boolean force, int repeatTicks) {

        this.particle = particle;
        this.offsetX = offsetX;
        this.offsetY = offsetY;
        this.offsetZ = offsetZ;
        this.s1 = spreadX;
        this.s2 = spreadY;
        this.s3 = spreadZ;
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

    public double getOffsetX() {
        return offsetX;
    }

    public double getOffsetY() {
        return offsetY;
    }

    public double getOffsetZ() {
        return offsetZ;
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
