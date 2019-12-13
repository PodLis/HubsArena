package ru.hubsmc.hubsarena.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import ru.hubsmc.hubsarena.ArenaKeeper;

public class PlayerKillEvent implements Listener {

    private ArenaKeeper arenaKeeper;

    public PlayerKillEvent(ArenaKeeper arenaKeeper) {
        this.arenaKeeper = arenaKeeper;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        arenaKeeper.sendPlayerToLobby(event.getEntity());
    }

}
