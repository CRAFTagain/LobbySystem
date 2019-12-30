package de.alpharout.lobbysystem.events;

import de.craftagain.lobbysystem.main.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {
    FileConfiguration configuration;
    Player player;

    @EventHandler
    public void onClick(InventoryClickEvent event) {
        event.setCancelled(true);
        player = (Player) event.getWhoClicked();
        configuration = LobbySystem.getInstance().getConfig();

        try {
            if (event.getClickedInventory().getName().equals("§8» §cNavigator")) {

                switch (event.getCurrentItem().getItemMeta().getDisplayName()) {
                    case "§8» §bSurvival Empire":
                        double x = configuration.getDouble("settings.gamemode1.x");
                        double y = configuration.getDouble("settings.gamemode1.y");
                        double z = configuration.getDouble("settings.gamemode1.z");
                        double yaw = configuration.getDouble("settings.gamemode1.yaw");
                        double pitch = configuration.getDouble("settings.gamemode1.pitch");
                        String world = configuration.getString("settings.gamemode1.world");

                        Location suvEmpLocation = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);

                        player.teleport(suvEmpLocation);
                        player.playSound(player.getLocation(), Sound.LEVEL_UP, 1, 1);

                        break;
                }
            }
        } catch (Exception e) {

        }


    }
}
