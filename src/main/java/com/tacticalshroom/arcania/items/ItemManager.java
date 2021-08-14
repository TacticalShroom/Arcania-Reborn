package com.tacticalshroom.arcania.items;

import com.tacticalshroom.arcania.Main;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class ItemManager implements Listener {
    private ArrayList<ArcaniaItemType> registeredItemTypes = new ArrayList<>();

    public void registerItemType(ArcaniaItemType type){
        if(!registeredItemTypes.contains(type)){
            registeredItemTypes.add(type);
        }
    }

    public void removeItemType(ArcaniaItemType type){
        registeredItemTypes.remove(type);
    }

    public ArcaniaItemType getItemType(ItemStack itemStack){
        for(ArcaniaItemType type : registeredItemTypes){
            if(type.matches(itemStack)){
                return type;
            }
        }
        return new VanillaArcaniaItemType(itemStack.getType());
    }

    public ArcaniaItemType getItemType(String key){
        for(ArcaniaItemType type : registeredItemTypes){
            if(type.getKey().equals(key)){
                return type;
            }
        }
        Material vanillaMaterial = Material.matchMaterial(key);
        if(vanillaMaterial != null){
            return new VanillaArcaniaItemType(vanillaMaterial);
        }
        return null;
    }

    @EventHandler
    void onPlayerInteract(PlayerInteractEvent e){
        if(e.hasItem() && (e.getAction() == Action.RIGHT_CLICK_BLOCK || e.getAction() == Action.RIGHT_CLICK_AIR)){
            ItemStack itemStack = e.getItem();
            ArcaniaItemType itemType = getItemType(itemStack);
            if(itemType != null){
                e.setCancelled(itemType.onInteract(e.getPlayer(), itemStack, e));
            }
        }
    }

    @EventHandler
    void onPlayerInteractEntity(PlayerInteractEntityEvent e){
        ItemStack itemStack = e.getPlayer().getInventory().getItemInMainHand();
        ArcaniaItemType itemType = Main.plugin.itemManager.getItemType(itemStack);
        if(itemType != null){
            e.setCancelled(itemType.onInteractEntity(e.getPlayer(), itemStack, e.getRightClicked(), e));
        }
    }
}