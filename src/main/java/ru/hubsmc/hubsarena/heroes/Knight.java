package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.PotionEffects;

public class Knight extends Hero {

    static {
        setNames(ArenaKeeper.Heroes.KNIGHT, "Рыцарь", "Рыцаря");
    }

    public Knight(Player player) {
        super(player);
    }

    @Override
    protected void getDressed() {
        super.getDressed();

        PlayerInventory inv = player.getInventory();

        inv.setHelmet(Items.KNIGHT_HELMET.getItemStack());
        inv.setChestplate(Items.KNIGHT_CHESTPLATE.getItemStack());
        inv.setLeggings(Items.KNIGHT_PANTS.getItemStack());
        inv.setBoots(Items.KNIGHT_BOOTS.getItemStack());

        inv.setItem(0, Items.KNIGHT_SWORD.getItemStack());
        inv.setItemInOffHand(Items.KNIGHT_SHIELD.getItemStack());
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
