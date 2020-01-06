package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.MiItems;
import ru.hubsmc.hubsarena.data.PotionEffects;

public class Flier extends Hero{

    static {
        setNames(ArenaKeeper.Heroes.FLIER, "Летун", "Летун");
    }

    public Flier(Player player) {
        super(player);
    }

    @Override
    protected void getDressed() {
        super.getDressed();

        PlayerInventory inv = player.getInventory();
        inv.setChestplate(Items.FLYER_CHEST.getItemStack());

        inv.setItem(0, MiItems.FLYER_STICK.getItemStack());
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
        player.addPotionEffect(PotionEffects.NORMAL_SPEED.getPotionEffect());
        player.addPotionEffect(PotionEffects.FALL_PROTECTION.getPotionEffect());
    }

}
