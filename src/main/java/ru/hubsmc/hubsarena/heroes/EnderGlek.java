package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.MiItems;
import ru.hubsmc.hubsarena.data.PotionEffects;

import static ru.hubsmc.hubsarena.heroes.Hero.setNames;

public class EnderGlek extends Hero{

    static {
        setNames(ArenaKeeper.Heroes.PYRO, "ЕндерГлэк", "ЕндерГлэка");
    }

    public EnderGlek(Player player) {
        super(player);
    }

    @Override
    protected void getDressed() {
        super.getDressed();

        PlayerInventory inv = player.getInventory();

        inv.setHelmet(Items.END_HELMET.getItemStack());
        inv.setChestplate(Items.END_CHESTPLATE.getItemStack());
        inv.setLeggings(Items.END_PANTS.getItemStack());
        inv.setBoots(Items.END_BOOTS.getItemStack());

        inv.setItem(0, MiItems.GLEK_SWORD.getItemStack());
        inv.setItem(1, Items.END_BOX.getItemStack());
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
        player.addPotionEffect(PotionEffects.NORMAL_SPEED.getPotionEffect());
        player.addPotionEffect(PotionEffects.FALL_PROTECTION.getPotionEffect());
    }

}
