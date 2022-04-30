package eu.baumistlustig.gamemode;

import eu.baumistlustig.gamemode.commands.StartMenuCommand;
import eu.baumistlustig.gamemode.utils.Round;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class Gamemode extends JavaPlugin {

    private static Gamemode instance;

    private Round round;

    private StartMenuCommand startMenuCommand;

    @Override
    public void onLoad() { instance = this; }

    @Override
    public void onEnable() {

        final PluginManager pluginManager = Bukkit.getPluginManager();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public Round getRound() { return round; }

    public StartMenuCommand getStartMenuCommand() { return startMenuCommand; }

    public static Gamemode getInstance() {
        return instance;
    }

}
