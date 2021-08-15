package com.tacticalshroom.arcania.items;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class VanillaArcaniaItemType implements ArcaniaItemType {

    private Material material;

    public VanillaArcaniaItemType(Material material){
        this.material = material;
    }

    @Override
    public boolean onInteract(Player player, ItemStack itemStack, PlayerInteractEvent event) {
        return false;
    }

    @Override
    public boolean onInteractEntity(Player player, ItemStack itemStack, Entity entity, PlayerInteractEntityEvent event){
        return false;
    }

    @Override
    public String getKey() {
        return material.getKey().getKey();
    }

    @Override
    public ItemStack createItemStack(int amount) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_UNBREAKABLE);
        meta.setUnbreakable(true);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @Override
    public boolean matches(ItemStack itemStack) {
        if(itemStack.getType() != material) return false;
        ItemMeta meta = itemStack.getItemMeta();
        if(meta == null || meta.hasCustomModelData()) return false;
        return true;
    }

    public Material getMaterial(){
        return material;
    }
}
