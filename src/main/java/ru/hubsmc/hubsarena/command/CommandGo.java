package ru.hubsmc.hubsarena.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import ru.hubsmc.hubsarena.ArenaKeeper;
import ru.hubsmc.hubsarena.HubsArena;
import ru.hubsmc.hubsarena.Permissions;
import ru.hubsmc.hubscore.HubsCommand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static ru.hubsmc.hubscore.util.MessageUtils.sendPrefixMessage;

public class CommandGo extends HubsCommand {

    private HubsArena plugin;

    public CommandGo(HubsArena plugin) {
        super("go", null, true, 0);
        this.plugin = plugin;
    }

    @Override
    public boolean onHubsCommand(CommandSender sender, Command command, String label, String[] args) {
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

        return true;
    }

    @Override
    public List<String> onHubsComplete(CommandSender sender, Command command, String alias, String[] args) {

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

}
