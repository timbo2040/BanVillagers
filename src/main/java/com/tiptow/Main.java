package com.tiptow;

import org.bukkit.ChatColor;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        // Check if the clicked inventory is a villager trading inventory
        if (event.getInventory().getHolder() instanceof Villager) {
            // Cancel the trading action
            event.setCancelled(true);
            event.getWhoClicked().sendMessage(ChatColor.RED + "Trading with villagers is blocked.");
        }
    }
}