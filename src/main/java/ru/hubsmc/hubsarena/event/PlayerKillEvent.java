package ru.hubsmc.hubsarena.event;

import org.bukkit.Bukkit;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import ru.hubsmc.hubsarena.ArenaKeeper;

import java.util.Set;

public class PlayerKillEvent implements Listener {

    private ArenaKeeper arenaKeeper;

    public PlayerKillEvent(ArenaKeeper arenaKeeper) {
        this.arenaKeeper = arenaKeeper;
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();

        Entity killer = player.getLastDamageCause().getEntity();
        if (killer != null) {
            switch (killer.getType()) {
                //  Cause Null-pointer exception
                /* case SKELETON:
                    Set<String> killerTags = killer.getScoreboardTags();

                    ScoreboardManager manager = Bukkit.getScoreboardManager();
                    Scoreboard scoreboard = manager.getMainScoreboard();

                    Set<Team> teamSet = scoreboard.getTeams();

                    for (Team team : teamSet) {
                        String teamName = team.getName();
                        if (killerTags.contains(teamName)) {
                            Player playerKiller = Bukkit.getPlayer(teamName);
                            if (playerKiller != null)
                                arenaKeeper.rewardPlayerForKill(playerKiller);
                        }
                    }
                    break; */

                case PLAYER:
                    arenaKeeper.rewardPlayerForKill(player.getKiller());
                    break;
            }
        }

        arenaKeeper.sendPlayerToLobby(player);
    }

}
