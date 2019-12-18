package ru.hubsmc.hubsarena.event;

import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.projectiles.ProjectileSource;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.Particles;
import ru.hubsmc.hubsarena.heroes.Cowboy;
import ru.hubsmc.hubsarena.util.PlayerUtils;

public class ItemInteractEvent implements Listener {

    private ArenaKeeper arenaKeeper;

    public ItemInteractEvent(ArenaKeeper arenaKeeper) {
        this.arenaKeeper = arenaKeeper;
    }

    @EventHandler
    public void onArrowHit(ProjectileHitEvent event){
        if (event.getEntity() instanceof Arrow) {
            Arrow arrow = (Arrow)event.getEntity();
            ProjectileSource shooter = arrow.getShooter();
            if (shooter instanceof Player)
                if (arenaKeeper.getHero((Player)shooter) instanceof Cowboy) {
                    Location dest = arrow.getLocation();

                    ((Player) shooter).getWorld().spawnParticle(
                            Particle.SMOKE_NORMAL,
                            dest, 5,
                            0, 0, 0,
                            0.01, null, false
                    );

                    arrow.remove();
                }
        }
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        if ( (event.getAction() != Action.PHYSICAL) && (event.getItem() != null) ) {
            Actions action = Actions.getActionIfExist(
                    PlayerUtils.getClickType(event.getAction(), event.getPlayer().isSneaking()),
                    Items.getItemIfExist(event.getItem())
            );

            if (action != null) {
                event.setCancelled(true);
                arenaKeeper.getHero(event.getPlayer()).useSpell(action);
            }
        }
    }

}
