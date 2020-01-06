package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.MiItems;
import ru.hubsmc.hubsarena.data.PotionEffects;

public class Assassin extends Hero{

    static {
        setNames(ArenaKeeper.Heroes.PYRO, "ЕндерГлэк", "ЕндерГлэка");
    }

    public Assassin(Player player) {
        super(player);
    }

    @Override
    protected void getDressed() {
        super.getDressed();
        player.getInventory().setItem(0, MiItems.KOSA.getItemStack());
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
        player.addPotionEffect(PotionEffects.NORMAL_SPEED.getPotionEffect());
        player.addPotionEffect(PotionEffects.FALL_PROTECTION.getPotionEffect());
        player.addPotionEffect(PotionEffects.INVISIBILITY.getPotionEffect());
    }

}
