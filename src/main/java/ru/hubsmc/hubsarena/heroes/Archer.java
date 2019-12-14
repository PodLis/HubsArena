package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
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
        player.getInventory().setHelmet(Items.ARCHER_HELMET.getItemStack());
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
