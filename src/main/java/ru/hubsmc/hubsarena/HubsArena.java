package ru.hubsmc.hubsarena;

import org.bukkit.*;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.PluginManager;
import ru.hubsmc.hubsarena.command.CommandGo;
import ru.hubsmc.hubsarena.event.*;
import ru.hubsmc.hubscore.HubsPlugin;
import ru.hubsmc.hubscore.PluginUtils;
import ru.hubsmc.hubscore.module.chesterton.internal.ClickHandler;
import ru.hubsmc.hubscore.module.chesterton.internal.menu.ChestMenu;
import ru.hubsmc.hubscore.module.chesterton.internal.parser.MenuParser;

import java.io.File;
import java.util.*;
import java.util.logging.Level;

import static ru.hubsmc.hubsarena.util.StringUtils.replaceColor;

public final class HubsArena extends HubsPlugin {

    // temporary solution
    public List<Player> disabledFallDamagePlayers;

    // temporary solution
    private static HubsArena instance;

    public static final String CHAT_PREFIX = ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "HA" + ChatColor.DARK_GREEN + "] " + ChatColor.GREEN;

    public static World ARENA_WORLD;
    public static Location LOBBY_LOCATION;
    public static List<Location> SPAWN_LOCATIONS;
    public static ItemStack ITEM_MENU;
    public static ChestMenu CHEST_MENU;
    public static List<String> JOIN_NOTIFICATIONS;

    private ArenaKeeper arenaKeeper;

    private static FileConfiguration configuration;
    private File arenaFolder;

    @Override
    public void afterCoreStart() {

        this.disabledFallDamagePlayers = new LinkedList<>();

        // temporary solution
        instance = this;

        loadConfiguration();

        try {
            arenaKeeper = new ArenaKeeper(new File(getFolder(), "data.yml"));

            PluginManager pm = getServer().getPluginManager();

            pm.registerEvents(new LeaveEvent(arenaKeeper), this);
            pm.registerEvents(new JoinEvent(arenaKeeper), this);
            pm.registerEvents(new MobKillEvent(arenaKeeper), this);
            pm.registerEvents(new ItemInteractEvent(arenaKeeper), this);
            pm.registerEvents(new PlayerKillEvent(arenaKeeper), this);
            pm.registerEvents(new PlayerFallEvent(this), this);
            pm.registerEvents(new ItemDropEvent(), this);

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
    public void beforeCoreStop() {
    }

    @Override
    public void onPluginEnable() {
    }

    @Override
    public void onPluginDisable() {
    }

    @Override
    public void onPlayerJoin(Player player) {
    }

    @Override
    public void onPlayerQuit(Player player) {
    }

    @Override
    public void onReload() {
    }

    @Override
    public void onStringsReload() {
    }

    @Override
    public void onSchedule() {
    }

    @Override
    public String getStringData(String s) {
        return null;
    }

    public ArenaKeeper getArenaKeeper() {
        return arenaKeeper;
    }

    // temporary solutions
    public static boolean getBooleanConfigData(String path) {
        if (configuration.contains(path)) {
            return configuration.getBoolean(path);
        }
        return false;
    }
    public static int getIntConfigData(String path) {
        if (configuration.contains(path)) {
            return configuration.getInt(path);
        }
        return 0;
    }
    public static double getDoubleConfigData(String path) {
        if (configuration.contains(path)) {
            return configuration.getDouble(path);
        }
        return 0;
    }
    public static String getStringConfigData(String path) {
        if (configuration.contains(path)) {
            return configuration.getString(path);
        }
        return "";
    }
    public static List<String> getStringListConfigData(String path) {
        if (configuration.contains(path)) {
            return configuration.getStringList(path);
        }
        return null;
    }
    public static List<Integer> getIntegerListConfigData(String path) {
        if (configuration.contains(path)) {
            return configuration.getIntegerList(path);
        }
        return null;
    }
    public static Set<String> getKeySetConfigData(String path) {
        return configuration.getConfigurationSection(path).getKeys(false);
    }

    void loadConfiguration() {

        arenaFolder = new File(PluginUtils.getMainFolder(), "server_arena");
        configuration = PluginUtils.getConfigInFolder(arenaFolder, "config");

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
        meta.setLore(replaceColor(configuration.getStringList("menu.lore")));
        stack.setItemMeta(meta);
        ITEM_MENU = stack;

        CHEST_MENU = MenuParser.parseChestMenu(configuration.getString("menu.chesterton-file"));
        ConfigurationSection section = configuration.getConfigurationSection("menu.chesterton-items");
        if (section != null) {
            for (String key : section.getKeys(false)) {
                int slot = Integer.parseInt(key);
                CHEST_MENU.getItem(slot).setClickHandler(new ClickHandler() {
                    @Override
                    public boolean onClick(Player player) {
                        ArenaKeeper.Heroes hero = ArenaKeeper.Heroes.getHeroByName(section.getString(key));
                        if (hero != null) {
                            arenaKeeper.pickHero(player, hero);
                            player.closeInventory();
                            arenaKeeper.sendPlayerToBattlefield(player);
                            return true;
                        }
                        return false;
                    }
                });
            }
        }

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

    // temporary solution
    public static HubsArena getInstance() {
        return instance;
    }

}
