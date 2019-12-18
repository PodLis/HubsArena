package ru.hubsmc.hubsarena.event;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ItemSpawnEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.inventory.ItemStack;

public class ItemDropEvent implements Listener {
    /*
     *  Cancel items spawning
     *  Cancel drop items
     */
    public ItemDropEvent(){ super(); }

    @EventHandler
    public void onArrowPickup(PlayerPickupItemEvent event){
        Player player = event.getPlayer();
        if(event.getItem() == new ItemStack(Material.ARROW)){
            if(!(player.hasPermission("arrowpickup.bypass") || player.isOp())){
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onItemSpawn(ItemSpawnEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onItemDrop (PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
}
