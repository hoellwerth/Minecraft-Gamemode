package eu.baumistlustig.gamemode.utils;

import eu.baumistlustig.gamemode.Gamemode;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class Round {
    public void checkForWin (Player p ) {
        Timer timer = Gamemode.getPlugin().getTimer();
        if (!timer.isRunning()) { return; }

        int flag = 0;
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getGameMode() == GameMode.CREATIVE || onlinePlayer.getGameMode() == GameMode.SPECTATOR) {
                continue;
            }

            flag++;
        }

        if (flag == 1) {
            timer.setRunning(false);
            Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Game Over!");
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Game Over!", ChatColor.GRAY + "The round is over!");
            }
        }
    }
}
