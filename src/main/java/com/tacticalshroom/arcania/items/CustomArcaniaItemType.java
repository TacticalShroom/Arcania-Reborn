package com.tacticalshroom.arcania.items;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public abstract class CustomArcaniaItemType implements ArcaniaItemType {

    private Material material;
    private String key;
    private int customModelData;
    private String displayName;
    private List<String> lore;

    public CustomArcaniaItemType(Material material, String key, int customModelData){
        this.material = material;
        this.key = key;
        this.customModelData = customModelData;

        displayName = key;
        lore = new ArrayList<>();
    }

    @Override
    public boolean onInteract(Player player, ItemStack itemStack, PlayerInteractEvent event){
        return true;
    }

    @Override
    public boolean onInteractEntity(Player player, ItemStack itemStack, Entity entity, PlayerInteractEntityEvent event){
        return true;
    }

    @Override
    public ItemStack createItemStack(int amount) {
        ItemStack itemStack = new ItemStack(material, amount);
        ItemMeta meta = itemStack.getItemMeta();
        assert meta != null;
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_UNBREAKABLE);
        meta.setDisplayName(ChatColor.WHITE + displayName);
        meta.setCustomModelData(customModelData);
        meta.setLore(lore);
        itemStack.setItemMeta(meta);
        return itemStack;
    }

    @Override
    public boolean matches(ItemStack itemStack) {
        if(itemStack.getType() != material) return false;
        ItemMeta meta = itemStack.getItemMeta();
        if(meta == null || !meta.hasCustomModelData()) return false;
        return meta.getCustomModelData() == customModelData;
    }

    protected void setMaterial(Material material){
        this.material = material;
    }

    protected void setKey(String key){
        this.key = key;
    }

    protected void setCustomModelData(int customModelData){
        this.customModelData = customModelData;
    }

    protected void setDisplayName(String displayName){
        this.displayName = displayName;
    }

    protected void setLore(List<String> lore){
        this.lore = lore;
    }

    protected void setLore(String... lore){
        this.lore = List.of(lore);
    }

    public Material getMaterial(){
        return material;
    }

    @Override
    public String getKey() {
        return key;
    }

    public int getCustomModelData(){
        return customModelData;
    }

    public String getDisplayName() {
        return displayName;
    }

    public List<String> getLore(){
        return lore;
    }
}
