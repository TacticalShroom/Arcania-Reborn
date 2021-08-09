package com.tacticalshroom.arcania.classes.selection;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class ClassSelectionListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
        if (e.getView().getTitle().equals(ChatColor.GOLD + "Class Selection"))  {
            e.setCancelled(true);

        }
    }
}
