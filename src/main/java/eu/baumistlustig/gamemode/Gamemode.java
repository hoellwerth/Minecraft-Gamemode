package eu.baumistlustig.gamemode;

import eu.baumistlustig.gamemode.commands.Start;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class Gamemode extends JavaPlugin {

    private static Gamemode plugin;

    public static Gamemode getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;

        getCommand("start").setExecutor(new Start());

        // Init Message
        Bukkit.getLogger().info("§a Gamemode Template Plugin wurde erfolgreich geladen.");
    }

    @Override
    public void onDisable() {
    }
}
