package ru.hubsmc.hubsarena.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;
import ru.hubsmc.hubsarena.ArenaKeeper;

public class LeaveEvent implements Listener {

    private ArenaKeeper arenaKeeper;

    public LeaveEvent(ArenaKeeper arenaKeeper) {
        this.arenaKeeper = arenaKeeper;
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        arenaKeeper.savePlayer(event.getPlayer());
    }

}
