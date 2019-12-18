package ru.hubsmc.hubsarena.heroes;

import org.bukkit.*;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;
import org.bukkit.block.PistonMoveReaction;
import org.bukkit.entity.*;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.permissions.Permission;
import org.bukkit.permissions.PermissionAttachment;
import org.bukkit.permissions.PermissionAttachmentInfo;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionData;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.util.BoundingBox;
import org.bukkit.util.Vector;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.PotionEffects;
import ru.hubsmc.hubsarena.data.Sounds;
import ru.hubsmc.hubsarena.util.PlayerUtils;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public class Cowboy extends Hero {

    static {
        setNames(ArenaKeeper.Heroes.BERSERK, "Ковбой", "Ковбоя");
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
            Location spawnPoint = player.getLocation().add(0, 1.2, 0); // Get coords of player ass
            Vector direction = player.getLocation().getDirection(); // Get player viewpoint direction

            // And normalize vector (vect len == 1)
            Vector vector = direction.normalize().multiply(2);
            spawnPoint.add(vector);

            Arrow bullet = player.getWorld().spawn(spawnPoint, Arrow.class);
            bullet.setPickupStatus(Arrow.PickupStatus.CREATIVE_ONLY);
            bullet.setShooter(player);

            //bullet.setCritical(true);
            //bullet.setGlowing(true);

            Vector dispersion = new Vector(
                    (Math.random() - 0.5) / 4.0f,
                    (Math.random() - 0.5) / 4.0f,
                    (Math.random() - 0.5) / 4.0f
            );

            direction.add(dispersion);

            bullet.setVelocity(direction.multiply(3));

            //player.launchProjectile(bullet, player.getLocation().getDirection().multiply(3));
            PlayerUtils.playSound(Sounds.SHOOT_SOUND, player);

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
