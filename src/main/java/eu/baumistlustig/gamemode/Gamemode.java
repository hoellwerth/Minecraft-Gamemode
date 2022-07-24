package eu.baumistlustig.gamemode;

import eu.baumistlustig.gamemode.commands.Start;
import eu.baumistlustig.gamemode.commands.TimerCommand;
import eu.baumistlustig.gamemode.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Gamemode extends JavaPlugin {

    private Timer timer;
    private static Gamemode plugin;

    public static Gamemode getPlugin() {
        return plugin;
    }

    @Override
    public void onEnable() {
        plugin = this;
        timer = new Timer(false, 0);

        Objects.requireNonNull(getCommand("start")).setExecutor(new Start());
        Objects.requireNonNull(getCommand("timer")).setExecutor(new TimerCommand());

        // Init Message
        Bukkit.getLogger().info("§a Gamemode Template Plugin has been loaded");
    }

    @Override
    public void onDisable() {
    }

    public Timer getTimer() {
        return timer;
    }
}
