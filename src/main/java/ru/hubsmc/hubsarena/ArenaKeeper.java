package ru.hubsmc.hubsarena;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.heroes.Archer;
import ru.hubsmc.hubsarena.heroes.Hero;
import ru.hubsmc.hubsarena.heroes.Knight;
import ru.hubsmc.hubsarena.heroes.Pyro;
import ru.hubsmc.hubsarena.util.PlayerUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ru.hubsmc.hubsvalues.api.API.addDollars;
import static ru.hubsmc.hubsvalues.api.API.updateCustomPlaceholders;

public class ArenaKeeper {

    private Map<Player, Hero> heroMap;
    private File dataFile;
    private YamlConfiguration dataFileConfig;

    public ArenaKeeper(File dataFile) {
        this.heroMap = new HashMap<>();
        this.dataFile = dataFile;
        this.dataFileConfig = YamlConfiguration.loadConfiguration(dataFile);
    }

    public enum Heroes {ARCHER, KNIGHT, PYRO}

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
            case PYRO: {
                heroMap.put(player, new Pyro(player));
                break;
            }
            default: {
                break;
            }
        }
        updateCustomPlaceholders(player, heroMap.get(player).getName(), "", "", "");
    }

    public void sendPlayerToBattlefield(Player player) {
        heroMap.get(player).joinTheBattlefield();
    }

    // Need to realize
    public boolean hasPlayerAccessToHero(Player player, Heroes hero) {
        return true;
    }

    public boolean isPlayerInBattlefield(Player player) {
        return heroMap.containsKey(player) && heroMap.get(player).isInBattle();
    }

    public void sendPlayerToLobby(Player player) {
        if (isPlayerInBattlefield(player)) {
            heroMap.get(player).leaveTheBattlefield();
        }
        player.teleport(HubsArena.LOBBY_LOCATION);
        player.getInventory().clear();
        PlayerUtils.curePotionEffects(player);
        player.getInventory().setItem(0, HubsArena.ITEM_MENU);
    }

    public void onJoinToArena(Player player) {
        sendPlayerToLobby(player);
        loadPlayer(player);
    }

    public Hero getHero(Player player) {
        return heroMap.get(player);
    }

    // Need to fill
    public void rewardPlayerForMobKill(Player player, EntityType type) {
        switch (type) {
            case ZOMBIE:
                addDollars(player, 10);
                return;
            case HUSK:
                addDollars(player, 20);
                return;
            case SKELETON:
                addDollars(player, 25);
        }
    }


    public void loadPlayer(Player player) {
        if (dataFileConfig.contains(player.getUniqueId().toString())) {
            pickHero(player, Heroes.valueOf(dataFileConfig.getString(player.getUniqueId().toString())));
        } else {
            pickHero(player, Heroes.KNIGHT);
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