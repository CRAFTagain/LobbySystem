package de.alpharout.lobbysystem.events;

import de.alpharout.lobbysystem.data.Data;
import de.craftagain.lobbysystem.scoreboard.ScoreboardManager;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {
    Player player;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        player = event.getPlayer();

        event.setJoinMessage(Data.getPrefix() + "§6" + player.getName() + "§7 ist dem Server beigetreten.");
        ScoreboardManager.addScoreboard(player);
    }
}
