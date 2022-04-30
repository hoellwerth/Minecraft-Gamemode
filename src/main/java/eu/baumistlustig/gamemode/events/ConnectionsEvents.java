package eu.baumistlustig.gamemode.events;

import eu.baumistlustig.gamemode.Gamemode;
import eu.baumistlustig.gamemode.commands.StartMenuCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class ConnectionsEvents implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onPlayerJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();

        // Give a StartMenuItem to Admins
        StartMenuCommand startMenuCommand = Gamemode.getInstance().getStartMenuCommand();
        startMenuCommand.giveStartMenuItem(p);
    }
}
