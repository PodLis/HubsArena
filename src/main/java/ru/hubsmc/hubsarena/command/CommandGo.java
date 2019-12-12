package ru.hubsmc.hubsarena.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.HubsArena;
import ru.hubsmc.hubsarena.Permissions;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import static ru.hubsmc.hubsarena.util.StringUtils.replaceColor;

public class CommandGo implements CommandExecutor, TabCompleter {

    private HubsArena plugin;

    public CommandGo(HubsArena plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (command.getName().equalsIgnoreCase("go")) {

                if (!(sender instanceof Player)) {
                    sendPrefixMessage(sender, "goer must be a player!");
                    return true;
                }

                Player player = (Player) sender;

                if (plugin.getArenaKeeper().isPlayerInBattlefield(player) && !player.hasPermission(Permissions.Perm.IGNORE_TABOOS.getPerm())) {
                    sendPrefixMessage(player, "Нельзя использовать эту команду вне лобби Арены!");
                    return true;
                }

                if (args.length == 0) {
                    plugin.getArenaKeeper().sendPlayerToBattlefield(player);
                    return true;
                }

                ArenaKeeper.Heroes hero = null;
                boolean exists = true;
                try {
                    hero = ArenaKeeper.Heroes.valueOf(args[0].toUpperCase());
                } catch (IllegalArgumentException e) {
                    exists = false;
                }

                if (!exists) {
                    sendPrefixMessage(player, "Такого класса не существует!");
                    return true;
                }

                if (!plugin.getArenaKeeper().hasPlayerAccessToHero(player, hero)) {
                    sendPrefixMessage(player, "У тебя нет доступа к этому классу!");
                    return true;
                }

                plugin.getArenaKeeper().pickHero(player, hero);
                plugin.getArenaKeeper().sendPlayerToBattlefield(player);

            }
        } catch (Throwable e) {
            e.printStackTrace();
            plugin.logConsole(Level.WARNING, "Some troubles with command go.");
            plugin.logConsole("oops...");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {

        if (!(sender instanceof Player)) {
            return null;
        }

        List<String> completionList = new ArrayList<>();
        String partOfCommand;
        List<String> cmds;

        if (args.length == 1) {
            cmds = new ArrayList<>(getCmds((Player)sender));
            partOfCommand = args[0];

            StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
            Collections.sort(completionList);
            return completionList;
        }

        return null;
    }

    private List<String> getCmds(Player player) {
        List<String> c = new ArrayList<>();
        for (ArenaKeeper.Heroes hero : ArenaKeeper.Heroes.values()) {
            if (plugin.getArenaKeeper().hasPlayerAccessToHero(player, hero)) {
                c.add(hero.name().toLowerCase());
            }
        }
        return c;
    }

    private void sendPrefixMessage(CommandSender sender, String message) {
        sender.sendMessage(HubsArena.CHAT_PREFIX + replaceColor(message));
    }

}
