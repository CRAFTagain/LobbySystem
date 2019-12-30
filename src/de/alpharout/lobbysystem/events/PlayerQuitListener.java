package de.alpharout.lobbysystem.events;

import de.alpharout.lobbysystem.data.Data;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerQuitListener implements Listener {
    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(Data.getPrefix() + "§6" + event.getPlayer().getName() + "§7 hat den Server verlassen.");
    }
}
