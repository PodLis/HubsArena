package ru.hubsmc.hubsarena.util;

public class StringUtils {

    public static String replacePlaceholders(String s, String player, String hero, String altHero) {
        return s.replaceAll("%player%", player)
                .replaceAll("%hero%", hero)
                .replaceAll("%alt_hero%", altHero);
    }

}
