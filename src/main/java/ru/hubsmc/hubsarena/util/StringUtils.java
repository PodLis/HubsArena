package ru.hubsmc.hubsarena.util;

import java.util.LinkedList;
import java.util.List;

public class StringUtils {

    public static String replaceColor(String s) {
        return s.replace("&", "\u00a7");
    }

    public static List<String> replaceColor(List<String> strings) {
        List<String> result = new LinkedList<>();
        for (String s : strings) {
            result.add(replaceColor(s));
        }
        return result;
    }

    public static String replacePlaceholders(String s, String player, String hero, String altHero) {
        return s.replaceAll("%player%", player)
                .replaceAll("%hero%", hero)
                .replaceAll("%alt_hero%", altHero);
    }

}
