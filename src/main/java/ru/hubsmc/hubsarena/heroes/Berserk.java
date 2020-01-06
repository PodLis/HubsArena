package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import org.bukkit.inventory.PlayerInventory;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.PotionEffects;

public class Berserk extends Hero {

    static {
        setNames(ArenaKeeper.Heroes.BERSERK, "Викинг", "Викинга");
    }

    public int KillsCounter;
    public int AxeLevel;

    public Berserk(Player player) {
        super(player);
        this.KillsCounter = 0;
        this.AxeLevel = 1;
    }

    private void ChangeAxeLevel(int AxeLvl) {
        this.AxeLevel = AxeLvl;
        switch (AxeLvl) {
            case 2:
                player.getInventory().setItem(0, Items.BERSERK_AXE_2.getItemStack());
                break;
            case 3:
                player.getInventory().setItem(0, Items.BERSERK_AXE_3.getItemStack());
                break;
            case 4:
                player.getInventory().setItem(0, Items.BERSERK_AXE_4.getItemStack());
                break;
            case 5:
                player.getInventory().setItem(0, Items.BERSERK_AXE_5.getItemStack());
                break;
        }
    }

    @Override
    public void KillEvent( ){
        super.KillEvent();
        this.KillsCounter++;

        int AxeLvl = 1;
        if (KillsCounter > 2) AxeLvl++;
        if (KillsCounter > 5) AxeLvl++;
        if (KillsCounter > 10) AxeLvl++;
        if (KillsCounter > 15) AxeLvl++;

        if (this.AxeLevel != AxeLvl)
            ChangeAxeLevel(AxeLvl);
    }

    @Override
    protected void getDressed() {
        super.getDressed();

        PlayerInventory inv = player.getInventory();

        inv.setHelmet(Items.BERSERK_HELMET.getItemStack());
        inv.setChestplate(Items.BERSERK_CHESTPLATE.getItemStack());
        inv.setLeggings(Items.BERSERK_PANTS.getItemStack());
        inv.setBoots(Items.BERSERK_BOOTS.getItemStack());

        inv.setItem(0, Items.BERSERK_AXE_1.getItemStack());
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
        player.addPotionEffect(PotionEffects.NORMAL_SPEED.getPotionEffect());
    }
}
