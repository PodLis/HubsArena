package ru.hubsmc.hubsarena;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import ru.hubsmc.hubsarena.data.*;
import ru.hubsmc.hubsarena.util.PlayerUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static ru.hubsmc.hubscore.util.MessageUtils.*;

public class Commands implements CommandExecutor, TabCompleter {

    private HubsArena plugin;

    Commands(HubsArena plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (command.getName().equalsIgnoreCase("hubsarena")) {
                switch (args[0].toLowerCase()) {

                    case "send":
                        if (sender instanceof Player && !sender.hasPermission(Permissions.Perm.SEND.getPerm())) {
                            sendNoPermMessage(sender, args[0]);
                            return true;
                        }

                        if (args.length < 2) {
                            sendWrongUsageMessage(sender, "send <player> [hero]");
                            return true;
                        }

                        Player target = Bukkit.getPlayer(args[1]);
                        if (target == null) {
                            sendMustBePlayerMessage(sender, args[1]);
                            return true;
                        }

                        if (args.length > 2) {
                            try {
                                ArenaKeeper.Heroes hero = ArenaKeeper.Heroes.valueOf(args[2].toUpperCase());
                                plugin.getArenaKeeper().pickHero(target, hero);
                            } catch (Throwable E) {
                                if (sender instanceof Player) {
                                    sendPrefixMessage(sender, "Неизвестный класс...");
                                }
                            }
                        }
                        plugin.getArenaKeeper().sendPlayerToBattlefield(target);

                        return true;


                    case "lobby":
                        if (!(sender instanceof Player)) {
                            sendMustBePlayerMessage(sender, args[1]);
                            return true;
                        }

                        Player player = (Player) sender;

                        if (!player.hasPermission(Permissions.Perm.SEND.getPerm())) {
                            sendNoPermMessage(player, args[0]);
                            return true;
                        }

                        plugin.getArenaKeeper().sendPlayerToLobby(player);
                        return true;

                    case "test":
                        if (!(sender instanceof Player)) {
                            sendMustBePlayerMessage(sender, args[1]);
                            return true;
                        }

                        Player player1 = (Player) sender;

                        if (!player1.hasPermission(Permissions.Perm.SEND.getPerm())) {
                            sendNoPermMessage(player1, args[0]);
                            return true;
                        }

                        if (args.length < 3) {
                            sendWrongUsageMessage(sender, "test <type> <id>");
                            return true;
                        }

                        switch (args[1].toLowerCase()) {
                            case "particles":
                                PlayerUtils.spawnParticle(Particles.valueOf(args[2].toUpperCase()), player1);
                                return true;
                            case "sounds":
                                PlayerUtils.playSound(Sounds.valueOf(args[2].toUpperCase()), player1);
                                return true;
                            case "items":
                                player1.getInventory().addItem(Items.valueOf(args[2].toUpperCase()).getItemStack());
                                return true;
                            case "miitems":
                                player1.getInventory().addItem(MiItems.valueOf(args[2].toUpperCase()).getItemStack());
                                return true;
                            case "effects":
                                player1.addPotionEffect(PotionEffects.valueOf(args[2].toUpperCase()).getPotionEffect());
                                return true;
                        }

                        return true;

                    default:
                        sendUnknownCommandMessage(sender, args[0]);
                        return true;
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completionList = new ArrayList<>();
        String partOfCommand;
        List<String> cmds = new ArrayList<>();

        switch (args.length) {
            case 1:

                cmds = new ArrayList<>(getCmds(sender));
                partOfCommand = args[0];

                StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
                Collections.sort(completionList);
                return completionList;

            case 2:
                switch (args[0]) {
                    case "send":
                        for (Player player : Bukkit.getOnlinePlayers()) {
                            cmds.add(player.getName());
                        }
                        partOfCommand = args[1];

                        StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
                        Collections.sort(completionList);
                        return completionList;

                    case "test":
                        cmds.addAll(Arrays.asList("particles", "sounds", "items", "miItems", "effects"));
                        partOfCommand = args[1];
                        StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
                        Collections.sort(completionList);
                        return completionList;

                    default:
                        return null;
                }

            case 3:
                switch (args[0]) {
                    case "send":
                        for (ArenaKeeper.Heroes hero : ArenaKeeper.Heroes.values()) {
                            cmds.add(hero.name().toLowerCase());
                        }
                        partOfCommand = args[2];

                        StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
                        Collections.sort(completionList);
                        return completionList;

                    case "test":
                        cmds.addAll(HubsArena.getKeySetConfigData(args[1].toLowerCase()));
                        partOfCommand = args[2];

                        StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
                        Collections.sort(completionList);
                        return completionList;

                    default:
                        return null;
                }

            default:
                return null;
        }
    }

    private List<String> getCmds(CommandSender sender) {
        List<String> c = new ArrayList<>();
        for (String cmd : Arrays.asList("send", "lobby", "test")) {
            if (!sender.hasPermission("hubsarena." + cmd)) {
                continue;
            }
            c.add(cmd);
        }
        return c;
    }

}
