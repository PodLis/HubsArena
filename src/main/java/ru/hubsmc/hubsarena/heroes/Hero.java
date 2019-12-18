package ru.hubsmc.hubsarena.heroes;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.HubsArena;
import ru.hubsmc.hubsarena.data.Actions;
import ru.hubsmc.hubsarena.data.Items;
import ru.hubsmc.hubsarena.data.Particles;
import ru.hubsmc.hubsarena.data.Sounds;
import ru.hubsmc.hubsarena.util.PlayerUtils;
import ru.hubsmc.hubsarena.util.ServerUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import static ru.hubsmc.hubsvalues.api.API.takeMana;

public abstract class Hero {

    protected Player player;

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
        player.setInvulnerable(true);

        inBattle = true;

        Location location = HubsArena.SPAWN_LOCATIONS.get( (int) (Math.random() * HubsArena.SPAWN_LOCATIONS.size()) );
        location.setYaw( (float) ((Math.random() * 360) - 180) );
        player.teleport(location);

        PlayerUtils.spawnParticle(Particles.TEST_NORMAL_PARTICLE, player);
        ServerUtils.broadcastJoinMessage(player.getDisplayName(), name, altName);

        getDressed();
        player.updateInventory();

        getBuffed();

        player.setInvulnerable(false);
    }

    protected void getDressed() {
        player.getInventory().clear();
        player.getInventory().setItem(7, Items.TOSSER_WAND.getItemStack());
        player.getInventory().setItem(8, Items.HEALING_WAND.getItemStack());
    }

    protected void getBuffed() {
        PlayerUtils.curePotionEffects(player);
    }

    public void KillEvent() {}
    public void DeathEvent() {}

    public void useSpell(Actions action) {
        int currentDelay = spellCooldown(action);

        if (currentDelay > 0) {
            switch (action) {
                case TOSS:
                case HEAL:
                    player.sendMessage("Подождите ещё " + currentDelay + " секунд");
                    return;

                case LOAD0:
                case LOAD1:
                case LOAD2:
                case LOAD3:
                case LOAD4:
                    player.sendMessage("Черт, не получается перезаряжаться так быстро!");
            }
            return;
        }

        if (action.getManaCost() > 0 && takeMana(player, action.getManaCost()) == 0) {
            player.sendMessage("Недостаточно маны!");
            return;
        }

        cooldowns.put(action, System.currentTimeMillis());

        switch (action) {
            case TOSS:
                HubsArena.getInstance().disabledFallDamagePlayers.add(player);
                player.setVelocity(player.getLocation().getDirection().multiply(5).setY(2));
                PlayerUtils.spawnParticle(Particles.TOSS_PARTICLE, player);
                PlayerUtils.playSound(Sounds.TOSS_SOUND, player);
                break;
            case HEAL:
                player.setHealth(player.getMaxHealth());
                PlayerUtils.spawnParticle(Particles.TEST_REDSTONE_PARTICLE, player);
                PlayerUtils.playSound(Sounds.HEAL_SOUND, player);
                break;
        }

    }

    private int spellCooldown(Actions action) {
        if (cooldowns.containsKey(action)) {
            return (int) TimeUnit.MILLISECONDS.toSeconds(cooldowns.get(action) + action.getCooldownInTicks() * 50 - System.currentTimeMillis());
        }
        return 0;
    }

    protected static void setNames(ArenaKeeper.Heroes hero, String name, String altName) {
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
