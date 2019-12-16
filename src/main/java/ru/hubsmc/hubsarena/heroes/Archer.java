package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.MiItems;
import ru.hubsmc.hubsarena.data.PotionEffects;
import ru.hubsmc.hubsarena.data.Items;

public class Archer extends Hero {

    static {
        setNames(ArenaKeeper.Heroes.ARCHER, "Лучник", "Лучника");
    }

    public Archer(Player player) {
        super(player);
    }

    @Override
    protected void getDressed() {
        super.getDressed();
        PlayerInventory inv = player.getInventory();

        inv.setHelmet(Items.ARCHER_HELMET.getItemStack());
        inv.setChestplate(Items.ARCHER_CHESTPLATE.getItemStack());
        inv.setLeggings(Items.ARCHER_PANTS.getItemStack());
        inv.setBoots(Items.ARCHER_BOOTS.getItemStack());

        inv.setItem(0, MiItems.ARCHER_BOW.getItemStack());
        inv.setItem(1, Items.ARCHER_ARROW.getItemStack());
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
        player.addPotionEffect(PotionEffects.NORMAL_SPEED.getPotionEffect());
    }

    @Override
    public void useSpell(Actions action) {
        super.useSpell(action);

        switch (action) {

        }

    }

}
