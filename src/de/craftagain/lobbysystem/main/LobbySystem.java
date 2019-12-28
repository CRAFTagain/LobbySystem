package de.craftagain.lobbysystem.main;

import de.alpharout.lobbysystem.data.Data;
import de.alpharout.lobbysystem.events.PlayerJoinListener;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {
    PluginManager pluginManager;

    @Override
    public void onEnable() {
        Data.log("§7Lobby System started, coded by " + Data.getAuthors() + "!");

        pluginManager = Bukkit.getPluginManager();
        pluginManager.registerEvents(new PlayerJoinListener(), this);
    }

    @Override
    public void onDisable() {
        Data.log("§7Lobby System stopped, coded by " + Data.getAuthors() + "!");
    }
}
