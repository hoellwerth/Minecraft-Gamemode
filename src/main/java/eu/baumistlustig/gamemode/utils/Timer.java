package eu.baumistlustig.gamemode.utils;

import eu.baumistlustig.gamemode.Gamemode;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Timer {
    private boolean gameRunning;
    private int gameTime;

    public Timer (boolean gameRunning, int gameTime) {
        this.gameRunning = gameRunning;
        this.gameTime = gameTime;
        run();
    }

    public boolean isRunning() {
        return gameRunning;
    }

    public void setRunning(boolean running) {
        this.gameRunning = running;
    }

    public int getTime() {
        return gameTime;
    }

    public void setTime(int time) {
        this.gameTime = time;
    }

    public void sendActionBar() {
        int playerCount = 0;
        for (Player p : Bukkit.getOnlinePlayers()) {

            if (!isRunning()) {
                continue;
            }

            if (p.getGameMode().equals(GameMode.SURVIVAL) || p.getGameMode().equals(GameMode.SPECTATOR)) playerCount += 1;

            if (playerCount == 1) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + "Running for: "
                        + ChatColor.BOLD + ChatColor.AQUA + getTime()
                        + ChatColor.RESET + ChatColor.GREEN + " ┃ "
                        + ChatColor.GRAY + "Only " + ChatColor.GREEN + ChatColor.BOLD + playerCount + ChatColor.RESET + ChatColor.GRAY + " player left"
                ));
                return;
            }

            p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GRAY + "Runde läuft seit: "
                    + ChatColor.BOLD + ChatColor.AQUA + getTime()
                    + ChatColor.RESET + ChatColor.GREEN + " ┃ "
                    + ChatColor.GRAY + "Only " + ChatColor.GREEN + ChatColor.BOLD + playerCount + ChatColor.RESET + ChatColor.GRAY + " players left"
            ));
        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!isRunning()) {
                    return;
                }

                setTime(getTime() + 1);
            }
        }.runTaskTimer(Gamemode.getPlugin(), 20, 20);
    }
}
