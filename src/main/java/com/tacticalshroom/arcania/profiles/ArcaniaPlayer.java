package com.tacticalshroom.arcania.profiles;

import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public abstract class ArcaniaPlayer {

    protected double mana, maxMana, power, maxPower;
    protected Player player;

    //stats
    protected int str, dex, con, wis, chr;

    public ArcaniaPlayer(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player)  {
        this.mana = mana;
        this.maxMana = maxMana;
        this.player = player;
        this.setMaxHealth(maxHealth);
        this.setHealth(health);
        this.setLevel(level);
        this.setLocation(location);
        this.setInventory(new ItemStack[36]);
        this.setArmor(new ItemStack[4]);

        this.str = 0;
        this.dex = 0;
        this.con = 0;
        this.wis = 0;
        this.chr = 0;
    }

    public ArcaniaPlayer(Player player)  {
        this.player = player;
        load();
    }

    public abstract void save();
    public abstract void load();

    public abstract void statBar();


    public void setHealth(double health) {
        this.player.setHealth(health);
    }

    public void setMana(double mana) {
        this.mana = mana;
    }

    public void setLevel(double level) {
        this.player.setLevel((int) level);
    }

    public void setMaxHealth(double maxHealth) {
        this.player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(maxHealth);
    }

    public void setLocation(Location location)  {
        this.player.teleport(location);
    }

    public void setInventory(ItemStack[] inventory)  {
        this.player.getInventory().setContents(inventory);
    }

    public void setArmor(ItemStack[] armor) {
        this.player.getInventory().setArmorContents(armor);
    }

    public double getHealth() {
        return this.player.getHealth();
    }

    public double getLevel() {
        return this.player.getLevel();
    }

    public double getMana() {
        return mana;
    }

    public double getMaxHealth() {
        return player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
    }

    public double getMaxMana() {
        return maxMana;
    }

    public ItemStack[] getArmor() {
        return this.player.getInventory().getArmorContents();
    }

    public ItemStack[] getInventory() {
        return this.player.getInventory().getContents();
    }

    public Location getLocation() {
        return this.player.getLocation();
    }

    public Player getPlayer() {
        return player;
    }

    public int getChr() {
        return chr;
    }

    public int getCon() {
        return con;
    }

    public int getDex() {
        return dex;
    }

    public int getStr() {
        return str;
    }

    public int getWis() {
        return wis;
    }

    public void setChr(int chr) {
        this.chr = chr;
    }

    public void setCon(int con) {
        this.con = con;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public void setMaxMana(double maxMana) {
        this.maxMana = maxMana;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public void setWis(int wis) {
        this.wis = wis;
    }
}
