package ru.hubsmc.hubsarena;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.heroes.Archer;
import ru.hubsmc.hubsarena.heroes.Hero;
import ru.hubsmc.hubsarena.heroes.Knight;
import ru.hubsmc.hubsarena.util.PlayerUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ArenaKeeper {

    private Map<Player, Hero> heroMap;
    private File dataFile;
    private YamlConfiguration dataFileConfig;

    public ArenaKeeper(File dataFile) {
        this.heroMap = new HashMap<>();
        this.dataFile = dataFile;
        this.dataFileConfig = YamlConfiguration.loadConfiguration(dataFile);
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

    public void onPlayerJoin(Player player) {
        player.teleport(HubsArena.LOBBY_LOCATION);
        player.getInventory().clear();
        PlayerUtils.curePotionEffects(player);
        player.getInventory().setItem(0, HubsArena.ITEM_MENU);
        loadPlayer(player);
    }

    public void loadPlayer(Player player) {
        if (dataFileConfig.contains(player.getUniqueId().toString())) {
            pickHero(player, Heroes.valueOf(dataFileConfig.getString(player.getUniqueId().toString())));
        } else {
            pickHero(player, Heroes.ARCHER);
        }
    }

    public void loadPlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (dataFileConfig.contains(player.getUniqueId().toString())) {
                pickHero(player, Heroes.valueOf(dataFileConfig.getString(player.getUniqueId().toString())));
            } else {
                pickHero(player, Heroes.ARCHER);
            }
        }
    }

    public void savePlayer(Player player) {
        dataFileConfig.set(player.getUniqueId().toString(), heroMap.get(player).getHero().toString());
        heroMap.remove(player);
        saveData();
    }

    public void savePlayers() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            dataFileConfig.set(player.getUniqueId().toString(), heroMap.get(player).getHero().toString());
        }
        heroMap.clear();
        saveData();
    }

    private void saveData() {
        try {
            dataFileConfig.save(dataFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}