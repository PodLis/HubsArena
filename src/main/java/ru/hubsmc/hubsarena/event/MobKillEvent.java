package ru.hubsmc.hubsarena.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import ru.hubsmc.hubsarena.ArenaKeeper;

public class MobKillEvent implements Listener {

    private ArenaKeeper arenaKeeper;

    public MobKillEvent(ArenaKeeper arenaKeeper) {
        this.arenaKeeper = arenaKeeper;
    }

    @EventHandler
    public void onJoin(EntityDeathEvent event) {
        Player player = event.getEntity().getKiller();
        if (player != null) {
            arenaKeeper.rewardPlayerForMobKill(player, event.getEntity().getType());
        }
    }

}
