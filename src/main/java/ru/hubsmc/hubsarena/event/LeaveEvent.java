package ru.hubsmc.hubsarena.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class LeaveEvent implements Listener {

    public LeaveEvent() {
    }

    @EventHandler
    public void onQuit(PlayerJoinEvent event) {
    }

}
