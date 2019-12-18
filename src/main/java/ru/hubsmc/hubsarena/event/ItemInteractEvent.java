package ru.hubsmc.hubsarena.event;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.util.PlayerUtils;

public class ItemInteractEvent implements Listener {

    private ArenaKeeper arenaKeeper;

    public ItemInteractEvent(ArenaKeeper arenaKeeper) {
        this.arenaKeeper = arenaKeeper;
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
