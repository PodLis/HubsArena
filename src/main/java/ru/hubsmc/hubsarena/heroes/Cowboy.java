package ru.hubsmc.hubsarena.heroes;

import org.bukkit.*;
import org.bukkit.entity.*;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.util.Vector;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.PotionEffects;
import ru.hubsmc.hubsarena.data.Sounds;
import ru.hubsmc.hubsarena.util.PlayerUtils;

public class Cowboy extends Hero {

    static {
        setNames(ArenaKeeper.Heroes.COWBOY, "Ковбой", "Ковбоя");
    }

    public int Ammo;

    public Cowboy(Player player) {
        super(player);
        this.Ammo = 5;
    }

    private void ChangeAmmo(int ammo) {
        this.Ammo = ammo;
        switch (ammo) {
            case 0:
                player.getInventory().setItem(0, Items.COWBOY_PISTOL_0.getItemStack());
                break;
            case 1:
                player.getInventory().setItem(0, Items.COWBOY_PISTOL_1.getItemStack());
                break;
            case 2:
                player.getInventory().setItem(0, Items.COWBOY_PISTOL_2.getItemStack());
                break;
            case 3:
                player.getInventory().setItem(0, Items.COWBOY_PISTOL_3.getItemStack());
                break;
            case 4:
                player.getInventory().setItem(0, Items.COWBOY_PISTOL_4.getItemStack());
                break;
            case 5:
                player.getInventory().setItem(0, Items.COWBOY_PISTOL_5.getItemStack());
                break;
        }
    }

    public void Shoot(){
        if (this.Ammo > 0) {
            /*
             *  We should create arrow around player.
             *  Otherwise arrow will get collision with shooter.
             */
            Location spawnPoint = player.getLocation().add(0, 1.5, 0); // Get cds of player ass
            Vector direction = player.getLocation().getDirection(); // Get player viewpoint direction

            // And normalize vector (vector len == 1)
            Vector vector = direction.normalize().multiply(3);
            Location arrowSpawnPoint = spawnPoint.add(vector);

            Arrow bullet = player.getWorld().spawn(arrowSpawnPoint, Arrow.class);
            bullet.setPickupStatus(Arrow.PickupStatus.CREATIVE_ONLY);
            bullet.setShooter(player);

            bullet.setSilent(true);

            //bullet.setCritical(true);
            //bullet.setGlowing(true);

            Vector dispersion = new Vector(
                    (Math.random() - 0.5) / 5.75f,
                    (Math.random() - 0.5) / 5.75f,
                    (Math.random() - 0.5) / 5.75f
            );

            direction.add(dispersion);

            bullet.setVelocity(direction.multiply(3));

            PlayerUtils.playSound(Sounds.SHOOT_SOUND, player);

            Vector offset = direction.normalize();
            player.getWorld().spawnParticle(
                    Particle.SMOKE_LARGE,
                    spawnPoint.subtract(-offset.getX() / 2.0f,
                                        -offset.getY() / 2.0f + 0.3,
                                        -offset.getZ() / 2.0f),
                    5,
                    0.01, 0.01, 0.01,
                    0.01, null, false
            );

            this.ChangeAmmo(this.Ammo - 1);
        }
    }

    public void Reload(){
        if (this.Ammo < 5) {
            PlayerUtils.playSound(Sounds.RELOAD_SOUND, player);
            this.ChangeAmmo(this.Ammo + 1);
        }
    }

    @Override
    public void useSpell(Actions action) {
        super.useSpell(action);

        switch (action) {
            case SHOOT1:
            case SHOOT2:
            case SHOOT3:
            case SHOOT4:
            case SHOOT5:
                this.Shoot();
                break;

            case LOAD0:
            case LOAD1:
            case LOAD2:
            case LOAD3:
            case LOAD4:
                this.Reload();
                break;
        }
    }

    @Override
    protected void getDressed() {
        super.getDressed();

        PlayerInventory inv = player.getInventory();

        inv.setChestplate(Items.COWBOY_CHESTPLATE.getItemStack());
        inv.setLeggings(Items.COWBOY_PANTS.getItemStack());
        inv.setBoots(Items.COWBOY_BOOTS.getItemStack());

        inv.setItem(0, Items.COWBOY_PISTOL_5.getItemStack());
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
        player.addPotionEffect(PotionEffects.NORMAL_SPEED.getPotionEffect());
    }
}
