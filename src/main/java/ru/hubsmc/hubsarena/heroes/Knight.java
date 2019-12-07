package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;

public class Knight extends Hero {

    public Knight(Player player) {
        super(player);
        player.sendMessage("Hello, I'm Knight");
    }

}
