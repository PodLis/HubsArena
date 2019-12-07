package ru.hubsmc.hubsarena.util;

import org.bukkit.Bukkit;
import ru.hubsmc.hubsarena.HubsArena;

public class ServerUtils {

    public static void broadcastJoinMessage(String player, String hero, String altHero) {
        String message = StringUtils.replacePlaceholders(HubsArena.JOIN_NOTIFICATIONS.get(
                (int) (Math.random() * HubsArena.JOIN_NOTIFICATIONS.size())
        ), player, hero, altHero);
        Bukkit.broadcastMessage(message);
    }

}
