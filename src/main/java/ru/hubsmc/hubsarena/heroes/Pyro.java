package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Effects;
import ru.hubsmc.hubsarena.data.MiItems;

public class Pyro extends Hero {

    public Pyro(Player player) {
        super(player);
        setNames(ArenaKeeper.Heroes.PYRO, "Пиромант", "Пироманта");
        player.sendMessage("Ку здарова, я " + getName());
    }

    @Override
    public void joinTheBattlefield() {
        super.joinTheBattlefield();
        getDressed();
        player.setInvulnerable(false);
    }

    private void getDressed() {
        player.getInventory().setItem(0, MiItems.PYRO_SWORD.getItemStack());
        player.updateInventory();
        player.addPotionEffect(Effects.NORMAL_SPEED.getPotionEffect());
    }

}
