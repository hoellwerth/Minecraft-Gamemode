package eu.baumistlustig.gamemode.events;

import eu.baumistlustig.gamemode.commands.StartCommand;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class ItemClickEvents implements Listener {

    @EventHandler(ignoreCancelled = true)
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        if (e.getItem() == null) return;

        ItemStack itemstack = e.getItem();

        if (itemstack.getItemMeta().getLocalizedName().equals("startmenu")) {
            StartCommand.openStartmenu(p);
        }
    }
}
