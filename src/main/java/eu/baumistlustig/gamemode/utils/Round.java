package eu.baumistlustig.gamemode.utils;

import eu.baumistlustig.gamemode.Gamemode;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.GameMode;

public class Round {

    private boolean gameRunning;
    private int gameTime;

    public Round (boolean gameRunning, int gameTime) {
        this.gameRunning = gameRunning;
        this.gameTime = gameTime;
        run();
    }

    public boolean gameIsRunning() {
        return gameRunning;
    }

    public void setGameRunning(boolean running) {
        this.gameRunning = running;
    }

    public int getGameTime() {
        return gameTime;
    }

    public void setGameTime(int time) {
        this.gameTime = time;
    }

    public void startedGame(Player p) {
        p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Let's Go!", ChatColor.GRAY + "Das Spiel ist eröffnet.");
    }

    public void checkForWin (Player p ) {
        if (!gameIsRunning()) { return; }

        //Win Logic
    }

    public void sendActionBar() {
        int playerCount = 0;
        for (Player p : Bukkit.getOnlinePlayers()) {

            if (!gameIsRunning()) {
                continue;
            }

            if (!(p.isOp()) && p.getGameMode().equals(GameMode.SURVIVAL)) playerCount += 1;

            if (playerCount == 1) {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD + "Runde läuft seit: "
                        + ChatColor.BOLD + getGameTime()
                        + ChatColor.RESET + ChatColor.RED + " ┃ "
                        + ChatColor.GOLD + ChatColor.BOLD + "Es lebt noch " + playerCount + " Spieler"
                ));
                return;
            } else {
                p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD + "Runde läuft seit: "
                        + ChatColor.BOLD + getGameTime()
                        + ChatColor.RESET + ChatColor.RED + " ┃ "
                        + ChatColor.GOLD + ChatColor.BOLD + "Es leben noch " + playerCount + " Spieler"
                ));
            }
        }
    }

    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();

                if (!gameIsRunning()) {
                    return;
                }

                setGameTime(getGameTime() + 1);
            }
        }.runTaskTimer(Gamemode.getInstance(), 20, 20);
    }
}
