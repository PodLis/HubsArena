package ru.hubsmc.hubsarena.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class ItemDropEvent implements Listener {
    /*
     *  Cancel items spawning
     *  Cancel drop items
     */
    public ItemDropEvent(){ super(); }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop (PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
}
