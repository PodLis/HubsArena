package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;

public class Knight extends Hero {

    public Knight(Player player) {
        super(player);
        setNames(ArenaKeeper.Heroes.KNIGHT, "Рыцарь", "Рыцаря");
        player.sendMessage("Ку здарова, я " + getName());
    }

}
