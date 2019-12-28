package de.alpharout.lobbysystem.utils;

import de.alpharout.lobbysystem.api.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class Navigator {

    public static void openNavigator(Player player) {
        Inventory inventory = Bukkit.createInventory(null, 3*9, "§8» §cNavigator");

        ItemStack surviveItItem = ItemBuilder.createItem("§8» §bSurvive it!", Material.STONE_AXE);
        ItemStack placeholderItem = ItemBuilder.createItem(" ", Material.STAINED_GLASS_PANE);

        inventory.setItem(2, placeholderItem);
        inventory.setItem(6, placeholderItem);
        inventory.setItem(10, placeholderItem);
        inventory.setItem(16, placeholderItem);
        inventory.setItem(20, placeholderItem);
        inventory.setItem(24, placeholderItem);
        inventory.setItem(13, surviveItItem);

        player.openInventory(inventory);
    }

}
