package ru.hubsmc.hubsarena.util;

import org.bukkit.entity.Player;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.potion.PotionEffect;
import ru.hubsmc.hubsarena.data.Particles;
import ru.hubsmc.hubsarena.data.Sounds;

public class PlayerUtils {

    public static void curePotionEffects(Player player) {
        for (PotionEffect effect : player.getActivePotionEffects()) {
            player.removePotionEffect(effect.getType());
        }
    }

    public static ClickType getClickType(Action action, boolean isSneaking) {
        if (isSneaking) {
            return action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK ? ClickType.SHIFT_RIGHT : ClickType.SHIFT_LEFT;
        }
        return action == Action.RIGHT_CLICK_AIR || action == Action.RIGHT_CLICK_BLOCK ? ClickType.RIGHT : ClickType.LEFT;
    }

    public static void spawnParticle(Particles particle, Player player) {
        for (int i = 0; i < particle.getOutCount(); i++) {
            player.getWorld().spawnParticle(
                    particle.getParticle(),
                    player.getLocation().add( particle.getOffsetX(), particle.getOffsetY(), particle.getOffsetZ() ),
                    particle.getCount(),
                    particle.getS1(),
                    particle.getS2(),
                    particle.getS3(),
                    particle.getExtra(),
                    particle.getData(),
                    particle.isForce()
            );
        }
    }

    public static void playSound(Sounds sound, Player player) {
        player.getWorld().playSound(
                player.getLocation().add( sound.getOffsetX(), sound.getOffsetY(), sound.getOffsetZ() ),
                sound.getSound(),
                sound.getVolume(),
                sound.getPitch()
        );
    }

}
