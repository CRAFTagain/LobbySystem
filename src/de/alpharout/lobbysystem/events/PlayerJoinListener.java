package de.alpharout.lobbysystem.events;

import de.alpharout.lobbysystem.api.ItemBuilder;
import de.alpharout.lobbysystem.data.Data;
import de.craftagain.lobbysystem.scoreboard.ScoreboardManager;
import de.craftagain.lobbysystem.utils.ActionBarManager;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;

public class PlayerJoinListener implements Listener {
    Player player;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws SQLException {
        player = event.getPlayer();

        ItemStack navigatorItem = ItemBuilder.createItem("§8» §bNavigator", Material.COMPASS);
        ItemStack changelogItem = ItemBuilder.createItem("§8» §aNews", Material.PAPER);
        ItemStack musicItem = ItemBuilder.createItem("§8» §eMusic", Material.NOTE_BLOCK);
        ItemStack placeholder = ItemBuilder.createItem(" ", Material.STAINED_GLASS_PANE);

        player.getInventory().setItem(4, navigatorItem);
        player.getInventory().setItem(6, changelogItem);
        player.getInventory().setItem(2, musicItem);

        player.getInventory().setItem(0, placeholder);
        player.getInventory().setItem(1, placeholder);
        player.getInventory().setItem(3, placeholder);
        player.getInventory().setItem(5, placeholder);
        player.getInventory().setItem(7, placeholder);
        player.getInventory().setItem(8, placeholder);


        event.setJoinMessage(Data.getPrefix() + "§6" + player.getName() + "§7 ist dem Server beigetreten.");
        ScoreboardManager.addScoreboard(player);
        ActionBarManager.addActionBarText(player, Data.getNews());
    }
}
