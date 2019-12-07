package ru.hubsmc.hubsarena.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.hubsmc.hubsarena.ArenaKeeper;

public class JoinEvent implements Listener {

    private ArenaKeeper arenaKeeper;

    public JoinEvent(ArenaKeeper arenaKeeper) {
        this.arenaKeeper = arenaKeeper;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        arenaKeeper.onPlayerJoin(event.getPlayer());
    }

}
