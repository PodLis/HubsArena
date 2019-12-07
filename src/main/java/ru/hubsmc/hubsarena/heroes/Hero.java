package ru.hubsmc.hubsarena.heroes;

import org.bukkit.entity.Player;

public abstract class Hero {

    Player player;

    public Hero(Player player) {
        this.player = player;
    }

    public void joinTheArena() {

    }

}
