package eu.baumistlustig.gamemode.commands;

import eu.baumistlustig.gamemode.Gamemode;
import eu.baumistlustig.gamemode.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.jetbrains.annotations.NotNull;

public class Start implements CommandExecutor {

    private int time;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        int flag = 0;
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
                continue;
            }

            flag++;
        }

        if (flag < 2) {
            sender.sendMessage(ChatColor.RED + "Cannot start Game! " + ChatColor.GRAY + "There are less than 2 players in survival!");
            return false;
        }

        time = 15;

        BukkitRunnable runnable = new BukkitRunnable() {

            final Timer timer = Gamemode.getPlugin().getTimer();

            @Override
            public void run() {

                switch (time) {
                    case 15:
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + " Game starts in " + ChatColor.GREEN + time + ChatColor.GRAY + " seconds!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2,1);
                        });
                        break;
                    case 5:
                    case 3:
                    case 4:
                    case 2: {
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + " Only " + ChatColor.GREEN + time + ChatColor.GRAY + " second left!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2,1);
                        });
                        break;
                    }
                    case 1: {
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + " Only " + ChatColor.GREEN + time + ChatColor.GRAY + " seconds left!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 2,1);
                        });
                        break;
                    }
                    case 0:
                        Bukkit.broadcastMessage(ChatColor.GRAY + "[" + ChatColor.GREEN + "GAME" + ChatColor.GRAY + "]" + ChatColor.GREEN + " Game starts" + ChatColor.BOLD +  " now" + ChatColor.RESET + "" + ChatColor.GRAY + "!");
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT, 3,2);
                        });
                        for (Player p : Bukkit.getOnlinePlayers()) {
                            p.sendTitle(ChatColor.GREEN.toString() + ChatColor.BOLD + "Let's Go!", ChatColor.GRAY + "Game starts now");
                        }
                        timer.setRunning(true);
                        Bukkit.getOnlinePlayers().forEach(player -> {
                            player.setExp(0);
                            player.setLevel(0);
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
