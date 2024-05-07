package com.tiptow;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryOpenEvent;
import org.bukkit.event.inventory.InventoryType;
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
    public void onClick(InventoryOpenEvent event) {
        Player player = (Player)event.getPlayer();
        if (event.getInventory().getType().equals(InventoryType.MERCHANT))
            if (!player.hasPermission("antivillager.override")) {
                event.setCancelled(true);
                player.sendMessage(ChatColor.RED + "You are not allowed to trade with villagers.");
            } else {
                return;
            }
    }
}