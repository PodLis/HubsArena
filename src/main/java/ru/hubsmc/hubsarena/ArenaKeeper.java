package ru.hubsmc.hubsarena;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import ru.hubsmc.hubsarena.heroes.*;
import ru.hubsmc.hubsarena.util.PlayerUtils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static ru.hubsmc.hubsvalues.api.API.addDollars;
import static ru.hubsmc.hubsvalues.api.API.updateCustomPlaceholders;

public class ArenaKeeper {
    private File dataFile;
    private YamlConfiguration dataFileConfig;

    private Map<Player, Hero> heroMap;

    public ArenaKeeper(File dataFile) {
        this.heroMap = new HashMap<>();
        this.dataFile = dataFile;
        this.dataFileConfig = YamlConfiguration.loadConfiguration(dataFile);
    }


    /*
     *  Heroes
     */
    public enum Heroes {ARCHER, KNIGHT, PYRO, BERSERK, ENDERGLEK, ASSASSIN, FLYER, COWBOY}

    public void pickHero(Player player, Heroes heroes) {
        switch (heroes) {
            case ARCHER:
                heroMap.put(player, new Archer(player));
                break;

            case KNIGHT:
                heroMap.put(player, new Knight(player));
                break;

            case PYRO:
                heroMap.put(player, new Pyro(player));
                break;

            case BERSERK:
                heroMap.put(player, new Berserk(player));
                break;

            case ASSASSIN:
                heroMap.put(player, new Assassin(player));
                break;

            case FLYER:
                heroMap.put(player, new Flyer(player));
                break;

            case COWBOY:
                heroMap.put(player, new Cowboy(player));
                break;

            case ENDERGLEK:
                heroMap.put(player, new EnderGlek(player));
                break;

            default: {
                break;
            }
        }
        updateCustomPlaceholders(player, heroMap.get(player).getName(), "", "", "");
    }

    public Hero getHero(Player player) {
        return heroMap.get(player);
    }



    /*
     *  Battle
     */
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



    /*
     *  Rewards
     */
    private int GetReward(EntityType type) {
        switch (type) {
            case ZOMBIE:          return 10;
            case HUSK:            return 20;
            case SKELETON:        return 15;
            case SPIDER:          return 10;
            case CAVE_SPIDER:     return 25;
            case PHANTOM:         return 25;
            case ZOMBIE_VILLAGER: return 10;
            case ENDERMAN:        return 15;
            case ILLUSIONER:      return 30;
            case RAVAGER:         return 35;
            case VINDICATOR:      return 15;
            case WITCH:           return 15;
            default:              return 5;
        }
    }

    public void rewardPlayerForMobKill(Player player, EntityType type) {
        addDollars(player, GetReward(type));
    }

    public void rewardPlayerForKill(Player player) {
        addDollars(player, 50);
    }



    /*
     *  Data storing
     */
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