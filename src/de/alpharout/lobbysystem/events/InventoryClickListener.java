package de.alpharout.lobbysystem.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    @EventHandler
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);

        try {
            if(event.getClickedInventory().getName().equals("§8» §cNavigator")) {

                switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§8» §bSurvive it!":
                        break;
                }
            }
        } catch (Exception e) {

        }


    }
}
