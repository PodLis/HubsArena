package ru.hubsmc.hubsarena.event;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import ru.hubsmc.hubsarena.ArenaKeeper;

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
                    try {
                        Player PlayerKiller = player.getKiller();
                        arenaKeeper.getHero(PlayerKiller).KillEvent();
                        arenaKeeper.rewardPlayerForKill(PlayerKiller);
                    } catch (Throwable E) {
                        // Wtf?
                    }
                    break;
            }
        }

        arenaKeeper.getHero(player).DeathEvent();
        arenaKeeper.sendPlayerToLobby(player);
    }

}
