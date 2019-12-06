package ru.hubsmc.hubsarena.event;

import org.bukkit.Location;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import ru.hubsmc.hubsarena.HubsArena;
import ru.hubsmc.hubsarena.util.PlayerUtils;

public class JoinEvent implements Listener {

    public JoinEvent() {
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.getPlayer().teleport(new Location(HubsArena.LOBBY_WORLD, HubsArena.LOBBY_X, HubsArena.LOBBY_Y, HubsArena.LOBBY_Z, HubsArena.LOBBY_YAW, HubsArena.LOBBY_PITCH));
        event.getPlayer().getInventory().clear();
        PlayerUtils.curePotionEffects(event.getPlayer());
        event.getPlayer().getInventory().setItem(0, HubsArena.ITEM_MENU);
    }

}
