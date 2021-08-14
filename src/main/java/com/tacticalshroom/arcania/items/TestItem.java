package com.tacticalshroom.arcania.items;

import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class TestItem extends CustomArcaniaItemType {

    public TestItem(){
        super(Material.STICK, "yeet", 0);
        setDisplayName("Yeet");
    }

    @Override
    public boolean onInteract(Player player, ItemStack itemStack, PlayerInteractEvent event) {
        player.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, player.getLocation(), 50, 1, 1, 1);
        return true;
    }
}