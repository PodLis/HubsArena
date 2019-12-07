package ru.hubsmc.hubsarena;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;

import static ru.hubsmc.hubsarena.util.StringUtils.replaceColor;
import static ru.hubsmc.hubsvalues.api.API.updateCustomPlaceholders;

public class Commands implements CommandExecutor, TabCompleter {

    private HubsArena plugin;

    Commands(HubsArena plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        try {
            if (command.getName().equalsIgnoreCase("hubsarena")) {
                if (args.length == 0) {
                    sendPrefixMessage(sender, "&b&l Info");
                    sendMessage(sender, "&5Version:&a " + plugin.getDescription().getVersion());
                    sendMessage(sender, "&5Author, created by:&a Rosenboum, pavel151");
                } else {
                    switch (args[0].toLowerCase()) {
                        case "help":
                            if (!sender.hasPermission(Permissions.Perm.HELP.getPerm())) {
                                sendPrefixMessage(sender, "You have no permissions to use&6 " + args[0]);
                                return true;
                            }
                            sendPrefixMessage(sender, "Commands:");
                            sendMessage(sender, "/" + label + " reload&7 - Reloads the plugin.");
                            sendMessage(sender, "/" + label + " send <player> [hero]&7 - Send player to battle.");
                            return true;


                        case "reload":
                            if (sender instanceof Player && !sender.hasPermission(Permissions.Perm.RELOAD.getPerm())) {
                                sendPrefixMessage(sender, "You have no permissions to use&6 " + args[0]);
                                return true;
                            }

                            plugin.getArenaKeeper().savePlayers();
                            plugin.loadConfiguration();
                            plugin.getArenaKeeper().loadPlayers();

                            sendPrefixMessage(sender, "Plugin reloaded.");

                            return true;


                        case "send":
                            if (sender instanceof Player && !sender.hasPermission(Permissions.Perm.SEND.getPerm())) {
                                sendPrefixMessage(sender, "You have no permissions to use&6 " + args[0]);
                                return true;
                            }

                            if (args.length < 2) {
                                sendPrefixMessage(sender, "Not enough arguments!");
                                return true;
                            }

                            Player player = Bukkit.getPlayer(args[1]);
                            if (player == null) {
                                sendPrefixMessage(sender, "Player must be online!");
                                return true;
                            }
                            plugin.getArenaKeeper().pickHero(player, ArenaKeeper.Heroes.valueOf("ARCHER"));
                            plugin.getArenaKeeper().sendPlayer(player);

                            return true;


                        default:
                            sendPrefixMessage(sender, "unknown sub-command&6 " + args[0]);
                            return true;
                    }
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
            plugin.logConsole(Level.WARNING, "Some troubles with commands.");
            plugin.logConsole("oops...");
        }
        return true;
    }

    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        List<String> completionList = new ArrayList<>();
        String partOfCommand;
        List<String> cmds = new ArrayList<>();

        if (args.length == 1) {
            cmds = new ArrayList<>(getCmds(sender));
            partOfCommand = args[0];

            StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
            Collections.sort(completionList);
            return completionList;
        }

        if (args.length == 2) {
            for (Player player : Bukkit.getOnlinePlayers()) {
                cmds.add(player.getName());
            }
            partOfCommand = args[1];

            StringUtil.copyPartialMatches(partOfCommand, cmds, completionList);
            Collections.sort(completionList);
            return completionList;
        }

        return null;
    }

    private List<String> getCmds(CommandSender sender) {
        List<String> c = new ArrayList<>();
        for (String cmd : Arrays.asList("help", "reload", "send")) {
            if (!sender.hasPermission("hubsarena." + cmd)) {
                continue;
            }
            c.add(cmd);
        }
        return c;
    }

    private void sendMessage(CommandSender sender, String message) {
        sender.sendMessage(replaceColor(message));
    }

    private void sendPrefixMessage(CommandSender sender, String message) {
        sender.sendMessage(HubsArena.CHAT_PREFIX + replaceColor(message));
    }

}
