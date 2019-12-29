package de.alpharout.lobbysystem.events;

import de.alpharout.lobbysystem.data.Data;
import de.craftagain.lobbysystem.main.LobbySystem;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        Player player = (Player) event.getWhoClicked();

        try {
            if(event.getClickedInventory().getName().equals("§8» §cNavigator")) {

                ByteArrayOutputStream b = new ByteArrayOutputStream();
                DataOutputStream out = new DataOutputStream(b);

                switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§8» §bSurvive it!":

                        try {
                            out.writeUTF("Connect");
                            out.writeUTF("survivalempire01");

                        }catch(IOException e){
                            e.printStackTrace();
                        }

                        player.sendPluginMessage(LobbySystem.getPlugin(LobbySystem.class), "BungeeCord", b.toByteArray());

                        break;
                }
            }
        } catch (Exception e) {

        }


    }
}
