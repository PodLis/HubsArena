package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.PotionEffects;
import ru.hubsmc.hubsarena.data.MiItems;

public class Pyro extends Hero {

    static {
        setNames(ArenaKeeper.Heroes.PYRO, "Пиромант", "Пироманта");
    }

    public Pyro(Player player) {
        super(player);
    }

    @Override
    protected void getDressed() {
        super.getDressed();

        PlayerInventory inv = player.getInventory();

        inv.setHelmet(Items.PYRO_HELMET.getItemStack());
        inv.setChestplate(Items.PYRO_CHESTPLATE.getItemStack());
        inv.setLeggings(Items.PYRO_PANTS.getItemStack());
        inv.setBoots(Items.PYRO_BOOTS.getItemStack());

        inv.setItem(0, MiItems.PYRO_SWORD.getItemStack());
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
        player.addPotionEffect(PotionEffects.NORMAL_SPEED.getPotionEffect());
        player.addPotionEffect(PotionEffects.FIRE_PROTECTION.getPotionEffect());
    }

    @Override
    public void useSpell(Actions action) {
        super.useSpell(action);

        switch (action) {

        }

    }

}
