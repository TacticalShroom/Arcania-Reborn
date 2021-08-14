package com.tacticalshroom.arcania.items;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public interface ArcaniaItemType {
    boolean onInteract(Player player, ItemStack itemStack, PlayerInteractEvent event);
    boolean onInteractEntity(Player player, ItemStack itemStack, Entity entity, PlayerInteractEntityEvent event);
    String getKey();
    ItemStack createItemStack(int amount);
    boolean matches(ItemStack itemStack);
}