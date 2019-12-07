package ru.hubsmc.hubsarena.heroes;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.HubsArena;
import ru.hubsmc.hubsarena.util.PlayerUtils;
import ru.hubsmc.hubsarena.util.ServerUtils;

public abstract class Hero {

    Player player;

    private static ArenaKeeper.Heroes hero;
    private static String name;
    private static String altName;

    public Hero(Player player) {
        this.player = player;
    }

    public void joinTheArena() {
        player.setInvulnerable(true);
        Location location = HubsArena.SPAWN_LOCATIONS.get( (int) (Math.random() * HubsArena.SPAWN_LOCATIONS.size()) );
        location.setYaw( (float) ((Math.random() * 360) - 180) );
        PlayerUtils.curePotionEffects(player);
        player.getInventory().clear();
        player.teleport(location);
        ServerUtils.broadcastJoinMessage(player.getDisplayName(), name, altName);
    }

    static void setNames(ArenaKeeper.Heroes hero, String name, String altName) {
        Hero.hero = hero;
        Hero.name = name;
        Hero.altName = altName;
    }

    public String getName() {
        return name;
    }

    public String getAltName() {
        return altName;
    }

    public ArenaKeeper.Heroes getHero() {
        return hero;
    }

}
