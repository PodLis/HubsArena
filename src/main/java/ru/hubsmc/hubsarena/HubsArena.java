package ru.hubsmc.hubsarena;

import org.bukkit.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import ru.hubsmc.hubsarena.command.CommandGo;
import ru.hubsmc.hubsarena.event.*;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import static ru.hubsmc.hubsarena.util.StringUtils.replaceColor;

public final class HubsArena extends JavaPlugin {

    public static final String CHAT_PREFIX = ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "HA" + ChatColor.DARK_GREEN + "] " + ChatColor.GREEN;

    public static World ARENA_WORLD;
    public static Location LOBBY_LOCATION;
    public static List<Location> SPAWN_LOCATIONS;
    public static ItemStack ITEM_MENU;
    public static List<String> JOIN_NOTIFICATIONS;

    private ArenaKeeper arenaKeeper;

    private FileConfiguration configuration;
    private File configFile;

    @Override
    public void onEnable() {

        loadConfiguration();

        try {
            arenaKeeper = new ArenaKeeper(new File(getFolder(), "data.yml"));

            getServer().getPluginManager().registerEvents(new LeaveEvent(arenaKeeper), this);
            getServer().getPluginManager().registerEvents(new JoinEvent(arenaKeeper), this);
            getServer().getPluginManager().registerEvents(new MobKillEvent(arenaKeeper), this);
            getServer().getPluginManager().registerEvents(new ItemInteractEvent(arenaKeeper), this);
            getServer().getPluginManager().registerEvents(new PlayerKillEvent(arenaKeeper), this);

            Commands commands = new Commands(this);
            getCommand("hubsarena").setExecutor(commands);
            getCommand("hubsarena").setTabCompleter(commands);

            CommandGo commandGo = new CommandGo(this);
            getCommand("go").setExecutor(commandGo);
            getCommand("go").setTabCompleter(commandGo);

            logConsole("Successfully enabled.");
        } catch (Throwable e) {
            e.printStackTrace();
            logConsole(Level.WARNING, "There was an error :(");
        }
    }

    @Override
    public void onDisable() {
    }

    public ArenaKeeper getArenaKeeper() {
        return arenaKeeper;
    }

    void loadConfiguration() {
        try {
            if (configFile == null) {
                configFile = new File(getFolder(), "config.yml");
            }
            if (configFile.exists()) {
                configuration = YamlConfiguration.loadConfiguration(configFile);
                configuration.load(configFile);
                reloadConfig();
            } else {
                saveResource("config.yml", false);
                configuration = YamlConfiguration.loadConfiguration(configFile);
                logConsole("The 'config.yml' file successfully created!");
            }
        } catch (Throwable e) {
            e.printStackTrace();
            logConsole(Level.WARNING, "There was a file error.");
        }

        JOIN_NOTIFICATIONS = configuration.getStringList("on-arena-join-notifications");

        ARENA_WORLD = Bukkit.getWorld(configuration.getString("lobby-coordinates.world"));

        LOBBY_LOCATION = new Location(ARENA_WORLD,
                (float) configuration.getDouble("lobby-coordinates.x"),
                (float) configuration.getDouble("lobby-coordinates.y"),
                (float) configuration.getDouble("lobby-coordinates.z"),
                (float) configuration.getDouble("lobby-coordinates.yaw"),
                (float) configuration.getDouble("lobby-coordinates.pitch"));

        SPAWN_LOCATIONS = new ArrayList<>();
        for (String s : configuration.getStringList("arena-spawns")) {
            String[] coordinates = s.split(":");
            SPAWN_LOCATIONS.add(new Location(ARENA_WORLD,
                    Double.parseDouble(coordinates[0]),
                    Double.parseDouble(coordinates[1]),
                    Double.parseDouble(coordinates[2]),
                    0, 0));
        }

        ItemStack stack = new ItemStack(Material.getMaterial(configuration.getString("menu.material")));
        ItemMeta meta = stack.getItemMeta();
        meta.setDisplayName(replaceColor(configuration.getString("menu.name")));
        stack.setItemMeta(meta);
        ITEM_MENU = stack;

    }

    private File getFolder() {
        File folder = getDataFolder();
        if (!folder.exists() && folder.mkdir()) {
            logConsole("Folder recreated");
        }
        return folder;
    }

    public void logConsole(String info) {
        logConsole(Level.INFO, info);
    }

    public void logConsole(Level level, String message) {
        Bukkit.getLogger().log(level, "[HubsArena] " + message);
    }

}
