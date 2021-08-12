package com.tacticalshroom.arcania.gui;

import com.tacticalshroom.arcania.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.List;

public abstract class ArcaniaGUI {

    private HashMap<Integer, Runnable> clickHandlers = new HashMap<>();

    private Inventory inventory;
    private Player player;

    public abstract String getTitle();
    public abstract int getSize();

    protected abstract void onOpen();
    protected abstract void onClose();

    protected void setSlot(int slot, Material material, String name, String... lore){
        ItemStack stack = new ItemStack(material, 1);
        ItemMeta meta = stack.getItemMeta();
        assert meta != null;
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS);
        meta.setDisplayName(ChatColor.WHITE + name);
        meta.setLore(List.of(lore));
        stack.setItemMeta(meta);
        inventory.setItem(slot, stack);
    }

    protected void addClickHandler(int slot, Runnable handler){
        clickHandlers.put(slot, handler);
    }

    public void open(Player player){
        this.player = player;
        inventory = Bukkit.createInventory(player, getSize(), getTitle());
        onOpen();
        Main.plugin.gui.register(this);
        player.openInventory(inventory);
    }

    public void handleClick(InventoryClickEvent e){
        e.setCancelled(true);

        Runnable handler = clickHandlers.get(e.getSlot());
        if(handler != null){
            handler.run();
        }
    }

    public void close() {
        player.closeInventory();
    }

    public Inventory getInventory(){
        return inventory;
    }

    public Player getPlayer(){
        return player;
    }
}