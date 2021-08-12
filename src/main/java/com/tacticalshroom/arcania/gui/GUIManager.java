package com.tacticalshroom.arcania.gui;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

public class GUIManager implements Listener {

    ArrayList<ArcaniaGUI> registeredGUIs = new ArrayList<>();

    public void register(ArcaniaGUI gui){
        if(!registeredGUIs.contains(gui)){
            registeredGUIs.add(gui);
        }
    }

    public void remove(ArcaniaGUI gui){
        registeredGUIs.remove(gui);
    }

    @EventHandler
    void onInventoryClick(InventoryClickEvent ev) {
        Inventory inv = ev.getInventory();
        for(ArcaniaGUI gui : registeredGUIs){
            if(gui.getInventory() == inv){
                gui.handleClick(ev);
                return;
            }
        }
    }

    @EventHandler
    void onInventoryClose(InventoryCloseEvent ev){
        Inventory inv = ev.getInventory();
        for(ArcaniaGUI gui : registeredGUIs){
            if(gui.getInventory() == inv){
                remove(gui);
                gui.onClose();
                return;
            }
        }
    }
}
