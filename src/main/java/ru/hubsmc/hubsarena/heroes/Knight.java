package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Effects;
import ru.hubsmc.hubsarena.data.Items;

public class Knight extends Hero {

    public Knight(Player player) {
        super(player);
        setNames(ArenaKeeper.Heroes.KNIGHT, "Рыцарь", "Рыцаря");
        player.sendMessage("Ку здарова, я " + getName());
    }

    @Override
    public void joinTheBattlefield() {
        super.joinTheBattlefield();
        getDressed();
        player.setInvulnerable(false);
    }

    private void getDressed() {
        player.getInventory().setHelmet(Items.ARCHER_HELMET.getItemStack());
        player.updateInventory();
        player.addPotionEffect(Effects.NORMAL_SPEED.getPotionEffect());
    }

}
