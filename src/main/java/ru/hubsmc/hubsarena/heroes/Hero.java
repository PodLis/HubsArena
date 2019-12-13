package ru.hubsmc.hubsarena.heroes;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.HubsArena;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.util.PlayerUtils;
import ru.hubsmc.hubsarena.util.ServerUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public abstract class Hero {

    Player player;

    private static ArenaKeeper.Heroes hero;
    private static String name;
    private static String altName;

    private Map<Actions, Long> cooldowns;
    private boolean inBattle;

    public Hero(Player player) {
        this.player = player;
        this.inBattle = false;
        this.cooldowns = new HashMap<>();
    }

    public void joinTheBattlefield() {
        inBattle = true;
        player.setInvulnerable(true);
        Location location = HubsArena.SPAWN_LOCATIONS.get( (int) (Math.random() * HubsArena.SPAWN_LOCATIONS.size()) );
        location.setYaw( (float) ((Math.random() * 360) - 180) );
        PlayerUtils.curePotionEffects(player);
        player.getInventory().clear();
        player.getInventory().setItem(7, Items.TOSSER_WAND.getItemStack());
        player.getInventory().setItem(8, Items.HEALING_WAND.getItemStack());
        player.teleport(location);
        ServerUtils.broadcastJoinMessage(player.getDisplayName(), name, altName);
    }

    public void useSpell(Actions action) {
        int currentDelay = spellCooldown(action);
        if (currentDelay > 0) {
            player.sendMessage("Подождите ещё " + currentDelay + " секунд");
            return;
        }
        switch (action) {
            case TOSS:
                player.setVelocity(player.getLocation().getDirection().multiply(5).setY(2));
                break;
            case HEAL:
                player.setHealth(player.getMaxHealth());
                break;
        }
        cooldowns.put(action, System.currentTimeMillis());
    }

    int spellCooldown(Actions action) {
        if (cooldowns.containsKey(action)) {
            return (int) TimeUnit.MILLISECONDS.toSeconds(cooldowns.get(action) + action.getCooldownInTicks() * 50 - System.currentTimeMillis());
        }
        return 0;
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

    public boolean isInBattle() {
        return inBattle;
    }

    public void leaveTheBattlefield() {
        this.inBattle = false;
    }

}
