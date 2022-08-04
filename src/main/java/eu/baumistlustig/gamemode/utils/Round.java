package eu.baumistlustig.gamemode.utils;

import eu.baumistlustig.gamemode.Gamemode;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.Stack;

public class Round {
    public void checkForWin (Player p) {
        Timer timer = Gamemode.getPlugin().getTimer();
        if (!timer.isRunning()) { return; }

        Stack<String> onlinePlayers = new Stack<String>();
        int flag = 0;
        for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
            if (onlinePlayer.getGameMode() == GameMode.CREATIVE || onlinePlayer.getGameMode() == GameMode.SPECTATOR) {
                continue;
            }

            onlinePlayers.push(onlinePlayer.getName());
            flag++;
        }

        if (flag == 1) {
            timer.setRunning(false);
            Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Game Over!");
            for (Player player : Bukkit.getOnlinePlayers()) {
                player.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Game Over!", ChatColor.GRAY + onlinePlayers.peek() + " has won the game!");
            }
            return;
        }

        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + ChatColor.RED + p.getName() + ChatColor.GRAY + " died!");
    }
}
