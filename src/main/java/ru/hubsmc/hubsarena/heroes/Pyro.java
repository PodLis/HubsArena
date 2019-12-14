package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
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
        player.getInventory().setItem(0, MiItems.PYRO_SWORD.getItemStack());
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
