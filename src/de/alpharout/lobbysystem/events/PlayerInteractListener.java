package de.alpharout.lobbysystem.events;

import de.alpharout.lobbysystem.utils.Navigator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if(event.getItem().getItemMeta().getDisplayName().equals("§8» §bNavigator")) {
                Navigator.openNavigator(player);
            }
        }
    }
}
