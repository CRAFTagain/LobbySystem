package de.alpharout.lobbysystem.events;

import de.alpharout.lobbysystem.api.ItemBuilder;
import de.alpharout.lobbysystem.data.Data;
import de.craftagain.lobbysystem.main.LobbySystem;
import de.craftagain.lobbysystem.scoreboard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import java.sql.SQLException;

public class PlayerJoinListener implements Listener {
    Player player;
    FileConfiguration configuration;

    @EventHandler
    public void onJoin(PlayerJoinEvent event) throws SQLException {
        player = event.getPlayer();
        configuration = LobbySystem.getInstance().getConfig();

        double x = configuration.getDouble("settings.spawn.x");
        double y = configuration.getDouble("settings.spawn.y");
        double z = configuration.getDouble("settings.spawn.z");
        double yaw = configuration.getDouble("settings.spawn.yaw");
        double pitch = configuration.getDouble("settings.spawn.pitch");
        String worldName = configuration.getString("settings.spawn.world");

        Location spawnLocation = new Location(Bukkit.getWorld(worldName), x, y, z);
        player.teleport(spawnLocation);
        player.getLocation().setYaw((float) yaw);
        player.getLocation().setPitch((float) pitch);

        player.getInventory().clear();
        player.setGameMode(GameMode.ADVENTURE);

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
    }
}
