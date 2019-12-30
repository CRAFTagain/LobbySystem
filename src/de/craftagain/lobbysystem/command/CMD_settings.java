package de.craftagain.lobbysystem.command;

import de.alpharout.lobbysystem.data.Data;
import de.craftagain.lobbysystem.main.LobbySystem;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CMD_settings implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if(commandSender instanceof Player) {
            Player player = (Player) commandSender;
            FileConfiguration configuration = LobbySystem.getInstance().getConfig();

            if(player.hasPermission("system.settings")) {

                if(strings.length == 1) {
                    if(strings[0].equalsIgnoreCase("setspawn")) {
                        Location spawnLocation = player.getLocation();

                        configuration.set("settings.spawn.x", spawnLocation.getX());
                        configuration.set("settings.spawn.y", spawnLocation.getY());
                        configuration.set("settings.spawn.z", spawnLocation.getZ());
                        configuration.set("settings.spawn.yaw", spawnLocation.getYaw());
                        configuration.set("settings.spawn.pitch", spawnLocation.getPitch());
                        configuration.set("settings.spawn.world", spawnLocation.getWorld().getName());

                        LobbySystem.getInstance().saveConfig();

                        player.sendMessage(Data.getPrefix() + "§7Der §6Spawn §7wurde gesetzt!");
                    }
                    if(strings[0].equalsIgnoreCase("setgamemode1")) {
                        Location gameModeLocation = player.getLocation();

                        configuration.set("settings.gamemode1.x", gameModeLocation.getX());
                        configuration.set("settings.gamemode1.y", gameModeLocation.getY());
                        configuration.set("settings.gamemode1.z", gameModeLocation.getZ());
                        configuration.set("settings.gamemode1.yaw", gameModeLocation.getYaw());
                        configuration.set("settings.gamemode1.pitch", gameModeLocation.getPitch());
                        configuration.set("settings.gamemode1.world", gameModeLocation.getWorld().getName());

                        LobbySystem.getInstance().saveConfig();

                        player.sendMessage(Data.getPrefix() + "§7Du hast den Punkt für den §61. Spielmodus§7 gesetzt.");
                    }
                } else {
                    player.sendMessage(Data.getPrefix() + "§cBitte benutze §6/settings <setspawn/setgamemode1>");
                }


            } else {
                player.sendMessage(Data.getPrefix() + "§cDazu hast du keine Berechtigung!");
            }
        } else {
            Data.log("§cDu musst ein Spieler sein!");
        }

        return false;
    }
}
