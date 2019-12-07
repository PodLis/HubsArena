package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;

public class Archer extends Hero {

    public Archer(Player player) {
        super(player);
        player.sendMessage("Hello, I'm Archer");
    }

}
