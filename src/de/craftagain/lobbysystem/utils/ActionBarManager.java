package de.craftagain.lobbysystem.utils;

import de.craftagain.lobbysystem.main.LobbySystem;
import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutChat;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

public class ActionBarManager {

    public static void addActionBarText(Player player, String message){

        IChatBaseComponent ichat = IChatBaseComponent.ChatSerializer.a("{\"text\":\"\"}").a("§aNews: " + "§8>> " + message + " §8<<");
        PacketPlayOutChat actionbar = new PacketPlayOutChat(ichat, (byte) 2);

        CraftPlayer craftPlayer = (CraftPlayer) player;

        Bukkit.getScheduler().scheduleSyncRepeatingTask(LobbySystem.getPlugin(LobbySystem.class), () -> craftPlayer.getHandle().playerConnection.sendPacket(actionbar),0,20);
    }
}
