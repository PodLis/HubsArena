package ru.hubsmc.hubsarena;

import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.heroes.Archer;
import ru.hubsmc.hubsarena.heroes.Hero;
import ru.hubsmc.hubsarena.heroes.Knight;

import java.util.HashMap;
import java.util.Map;

public class ArenaKeeper {

    private Map<Player, Hero> heroMap;

    public ArenaKeeper() {
        heroMap = new HashMap<>();
    }

    public enum Heroes {ARCHER, KNIGHT}

    public void pickHero(Player player, Heroes heroes) {
        switch (heroes) {
            case ARCHER: {
                heroMap.put(player, new Archer(player));
                break;
            }
            case KNIGHT: {
                heroMap.put(player, new Knight(player));
                break;
            }
        }
    }

    public void sendPlayer(Player player) {
        heroMap.get(player).joinTheArena();
    }

}
