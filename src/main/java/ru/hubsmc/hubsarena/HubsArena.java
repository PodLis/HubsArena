package ru.hubsmc.hubsarena;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import ru.hubsmc.hubsarena.event.JoinEvent;
import ru.hubsmc.hubsarena.event.LeaveEvent;

import java.io.File;
import java.util.logging.Level;

import static ru.hubsmc.hubsarena.util.StringUtils.replaceColor;

public final class HubsArena extends JavaPlugin {

    public static final String CHAT_PREFIX = ChatColor.DARK_GREEN + "[" + ChatColor.GREEN + "HA" + ChatColor.DARK_GREEN + "] " + ChatColor.GREEN;

    public static float LOBBY_X, LOBBY_Y, LOBBY_Z, LOBBY_YAW, LOBBY_PITCH;
    public static World LOBBY_WORLD;
    public static ItemStack ITEM_MENU;

    private FileConfiguration configuration;
    private File configFile;

    @Override
    public void onEnable() {

        loadConfiguration();

        try {
            getServer().getPluginManager().registerEvents(new LeaveEvent(), this);
            getServer().getPluginManager().registerEvents(new JoinEvent(), this);

            Commands commands = new Commands(this);
            getCommand("hubsarena").setExecutor(commands);
            getCommand("hubsarena").setTabCompleter(commands);

            logConsole("Successfully enabled.");
        } catch (Throwable e) {
            e.printStackTrace();
            logConsole(Level.WARNING, "There was an error :(");
        }
    }

    @Override
    public void onDisable() {
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

        LOBBY_WORLD = Bukkit.getWorld(configuration.getString("lobby-coordinates.world"));
        LOBBY_X = (float) configuration.getDouble("lobby-coordinates.x");
        LOBBY_Y = (float) configuration.getDouble("lobby-coordinates.y");
        LOBBY_Z = (float) configuration.getDouble("lobby-coordinates.z");
        LOBBY_YAW = (float) configuration.getDouble("lobby-coordinates.yaw");
        LOBBY_PITCH = (float) configuration.getDouble("lobby-coordinates.pitch");
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
