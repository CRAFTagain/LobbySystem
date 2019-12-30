package de.craftagain.lobbysystem.main;

import de.alpharout.lobbysystem.data.Data;
import de.alpharout.lobbysystem.events.*;
import de.craftagain.lobbysystem.command.CMD_info;
import de.craftagain.lobbysystem.command.CMD_settings;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {
    PluginManager pluginManager;
    private static LobbySystem plugin;

    @Override
    public void onEnable() {
        plugin = this;

        Bukkit.setDefaultGameMode(GameMode.ADVENTURE);

        Data.log("§7Lobby System started, coded by " + Data.getAuthors() + "!");

        pluginManager = Bukkit.getPluginManager();

        pluginManager.registerEvents(new PlayerJoinListener(), this);
        pluginManager.registerEvents(new PlayerInteractListener(), this);
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new PlayerDropItemListener(), this);
        pluginManager.registerEvents(new PlayerDamageListener(), this);
        pluginManager.registerEvents(new PlayerQuitListener(), this);

        getCommand("info").setExecutor(new CMD_info());
        getCommand("settings").setExecutor(new CMD_settings());
    }

    @Override
    public void onDisable() {
        Data.log("§7Lobby System stopped, coded by " + Data.getAuthors() + "!");
    }

    public static LobbySystem getInstance() {
        return plugin;
    }
}
