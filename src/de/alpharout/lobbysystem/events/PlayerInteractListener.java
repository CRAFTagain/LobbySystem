package de.alpharout.lobbysystem.events;

import de.alpharout.lobbysystem.data.Data;
import de.alpharout.lobbysystem.utils.Navigator;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

import java.util.ArrayList;

public class PlayerInteractListener implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();

        try {
            if(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK) {
                if(event.getItem().getItemMeta().getDisplayName().equals("§8» §bNavigator")) {
                    Navigator.openNavigator(player);
                }

                if(event.getItem().getItemMeta().getDisplayName().equals("§8» §aNews")) {
                    ArrayList<String> changelog = new ArrayList<>();

                    changelog.add("§6Navigator §7hinzugefügt");
                    changelog.add("§6Info Command §7hinzugefügt");
                    changelog.add("§6Start Inventar §7hinzugefügt");

                    player.sendMessage(Data.getPrefix() + "§7Aktuelle Neuigkeiten:");

                    for(int i = 0; i < changelog.size(); i++) {
                        player.sendMessage("§7   • " + changelog.get(i));
                    }
                }
            }
        } catch (Exception e) {

        }

    }
}
