package eu.baumistlustig.gamemode.commands;

import eu.baumistlustig.gamemode.Gamemode;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class Start implements CommandExecutor {

    private int time;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        time = 15;

        BukkitRunnable runnable = new BukkitRunnable() {
            @Override
            public void run() {

                switch (time) {
                    case 15:
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + " Das Spiel startet in " + ChatColor.GREEN + time + ChatColor.GRAY + " Sekunden!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2,1);
                        });
                        break;
                    case 5:
                    case 3:
                    case 4:
                    case 2: {
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + " Noch " + ChatColor.GREEN + time + ChatColor.GRAY + " Sekunden übrig!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2,1);
                        });
                        break;
                    }
                    case 1: {
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + " Noch " + ChatColor.GREEN + time + ChatColor.GRAY + " Sekunde übrig!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2,1);
                        });
                        break;
                    }
                    case 0:
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Das Spiel startet" + ChatColor.BOLD +  " jetzt" + ChatColor.RESET + "" + ChatColor.GRAY + "!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 3,2);
                        });
                        cancel();
                        return;
                }

                Bukkit.getOnlinePlayers().forEach(player -> {
                    player.setLevel(time);
                    player.setExp(time / 15f);
                });
                time--;
            }
        };
        runnable.runTaskTimer(Gamemode.getPlugin(), 0, 20);
        return false;
    }
}
