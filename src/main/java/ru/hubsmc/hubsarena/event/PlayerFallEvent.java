package ru.hubsmc.hubsarena.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import ru.hubsmc.hubsarena.HubsArena;

public class PlayerFallEvent implements Listener {

    private HubsArena plugin;

    public PlayerFallEvent(HubsArena plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerFall(EntityDamageEvent event) {
        if (event.getEntity() instanceof Player) {
            Player player = (Player) event.getEntity();
            if (event.getCause() == EntityDamageEvent.DamageCause.FALL){
                if (plugin.disabledFallDamagePlayers.contains(player)) {
                    event.setCancelled(true);
                    plugin.disabledFallDamagePlayers.remove(player);
                }
            }
        }
    }

}
