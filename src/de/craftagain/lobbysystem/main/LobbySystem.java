package de.craftagain.lobbysystem.main;

import de.alpharout.lobbysystem.data.Data;
import org.bukkit.plugin.java.JavaPlugin;

public class LobbySystem extends JavaPlugin {

    @Override
    public void onEnable() {
        Data.log("§7Lobby System started, coded by " + Data.getAuthors() + "!");
    }

    @Override
    public void onDisable() {
        Data.log("§7Lobby System stopped, coded by " + Data.getAuthors() + "!");
    }
}
