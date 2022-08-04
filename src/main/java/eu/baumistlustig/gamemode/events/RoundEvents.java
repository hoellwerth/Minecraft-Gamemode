package eu.baumistlustig.gamemode.events;

import eu.baumistlustig.gamemode.Gamemode;
import eu.baumistlustig.gamemode.utils.Round;
import eu.baumistlustig.gamemode.utils.Timer;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class RoundEvents implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerDeath(PlayerDeathEvent e) {
        Player p = e.getEntity().getPlayer();

        Timer timer = Gamemode.getPlugin().getTimer();
        Round round = Gamemode.getPlugin().getRound();

        if (timer.isRunning()) {
            Objects.requireNonNull(p).setGameMode(GameMode.SPECTATOR);
        }

        round.checkForWin(p);
    }
}
