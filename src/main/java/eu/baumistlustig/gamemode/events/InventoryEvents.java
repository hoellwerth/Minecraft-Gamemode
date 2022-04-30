package eu.baumistlustig.gamemode.events;

import eu.baumistlustig.gamemode.Gamemode;
import eu.baumistlustig.gamemode.utils.Round;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryEvents implements Listener {
    @EventHandler(ignoreCancelled = true)
    public void onInvClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null) return;

        if (e.getView().getTitle().equals(ChatColor.GREEN.toString() + ChatColor.BOLD + "Startmenü")) {
            Player p = (Player) e.getWhoClicked();

            e.setCancelled(true);

            //Timer timer = OnevsAll.getInstance().getTimer();
            Round round = Gamemode.getInstance().getRound();

            if (e.getCurrentItem().getItemMeta().hasLocalizedName()) {
                switch (e.getCurrentItem().getItemMeta().getLocalizedName()) {
                    case "start": {
                        //timer.setTimerTime(100);

                        //TODO: Add Countdown!!

                        //timer.setTimerRunning(true);

                        p.closeInventory();

                        p.sendMessage(
                                ChatColor.GRAY + "Der Timer wurde " + ChatColor.GREEN + ChatColor.BOLD + "gestartet" +
                                        ChatColor.RESET + ChatColor.GRAY + "."
                        );
                        break;
                    }

                    case "instastart": {
                        round.setGameRunning(true);
                        round.startedGame(p);

                        p.closeInventory();
                        break;
                    }
                }
            }
        }
    }
}
