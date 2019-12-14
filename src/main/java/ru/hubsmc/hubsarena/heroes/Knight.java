package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.data.Actions;

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
    }

    @Override
    protected void getBuffed() {
        super.getBuffed();
    }

    @Override
    public void useSpell(Actions action) {
        super.useSpell(action);

        switch (action) {

        }

    }

}
