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

        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getGameMode() == GameMode.CREATIVE || onlinePlayer.getGameMode() == GameMode.SPECTATOR) {
                return;
            }

            timer.setRunning(false);
            p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Game Over!",
                    ChatColor.GREEN + "" + onlinePlayer.name() + ChatColor.GRAY + " has eliminated every other player and won!"
            );
        }
    }
}
