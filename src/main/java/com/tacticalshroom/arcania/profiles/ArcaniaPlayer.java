package com.tacticalshroom.arcania.profiles;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class ArcaniaPlayer {

    protected double health, maxHealth, mana, maxMana, level;
    protected Location location;
    protected ItemStack[] inventory;
    protected ItemStack[] armor;
    protected Player player;

    //stats
    protected int str, dex, con, wis, chr;

    public ArcaniaPlayer(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player)  {
        this.health = health;
        this.maxHealth = maxHealth;
        this.mana = mana;
        this.level = level;
        this.location = location;
        this.inventory = new ItemStack[36];
        this.armor = new ItemStack[4];
        this.maxMana = maxMana;
        this.player = player;

        this.str = 0;
        this.dex = 0;
        this.con = 0;
        this.wis = 0;
        this.chr = 0;

        player.teleport(location);
    }

    public ArcaniaPlayer(Player player)  {
        this.player = player;
        load();
    }

    public abstract void save();
    public abstract void load();
    public abstract void update();


    public void setHealth(float health) {
        this.health = health;
    }

    public void setMana(float mana) {
        this.mana = mana;
    }

    public void setLevel(float level) {
        this.level = level;
    }

    public void setMaxHealth(float maxHealth) {
        this.maxHealth = maxHealth;
    }

    public double getHealth() {
        update();
        return health;
    }

    public double getLevel() {
        update();
        return level;
    }

    public double getMana() {
        update();
        return mana;
    }

    public double getMaxHealth() {
        update();
        return maxHealth;
    }

    public double getMaxMana() {
        update();
        return maxMana;
    }

    public ItemStack[] getArmor() {
        update();
        return armor;
    }

    public ItemStack[] getInventory() {
        update();
        return inventory;
    }

    public Location getLocation() {
        update();
        return location;
    }

    public Player getPlayer() {
        return player;
    }
}
