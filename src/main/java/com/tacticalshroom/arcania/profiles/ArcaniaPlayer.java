package com.tacticalshroom.arcania.profiles;

import com.tacticalshroom.arcania.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public abstract class ArcaniaPlayer {

    protected double mana, maxMana, power, maxPower;
    protected Player player;

    //stats
    protected int str, dex, con, wis, chr;

    private Timer timer;

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

    public abstract void statBar();
    public abstract String getClassName();

    protected abstract void saveCustomConfig(FileConfiguration conifg);
    protected abstract void loadCustomConfig(FileConfiguration config);

    public void save() {
        File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + getClassName() + "-Profile.yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(file);

        //stats
        c.set("stats.maxHealth", this.getMaxHealth());
        c.set("stats.health", this.getHealth());
        c.set("stats.level", this.getLevel());
        c.set("stats.mana", this.getMana());
        c.set("stats.maxMana", this.getMaxMana());

        //inventory
        c.set("inventory.contents", this.getInventory());
        c.set("inventory.armor", this.getArmor());

        //location
        c.set("location.x", this.getLocation().getX());
        c.set("location.y", this.getLocation().getY());
        c.set("location.z", this.getLocation().getZ());
        c.set("location.yaw", this.getLocation().getYaw());
        c.set("location.pitch", this.getLocation().getPitch());
        c.set("location.world", this.getLocation().getWorld().getName().trim());


        //core stats
        c.set("stats.strength", this.getStr());
        c.set("stats.dexterity", this.getDex());
        c.set("stats.constitution", this.getCon());
        c.set("stats.wisdom", this.getWis());
        c.set("stats.charisma", this.getChr());

        saveCustomConfig(c);

        try {
            c.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void load(){
        File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + getClassName() + "-Profile.yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(file);

        double x = c.getDouble("location.x");
        double y = c.getDouble("location.y");
        double z = c.getDouble("location.z");
        double pitch = c.getDouble("location.pitch");
        double yaw = c.getDouble("location.yaw");

        World world = Bukkit.getWorld(c.getString("location.world"));
        Location location = new Location(world, x, y, z, (float) yaw, (float) pitch);
        this.setLocation(location);
        this.setInventory(c.getList("inventory.contents").toArray(new ItemStack[36]));
        this.setArmor(c.getList("inventory.armor").toArray(new ItemStack[4]));
        this.setMaxHealth(c.getDouble("stats.maxHealth"));
        this.setHealth(c.getDouble("stats.health"));
        this.setLevel(c.getDouble("stats.level"));
        this.setMaxMana(c.getDouble("stats.maxMana"));
        this.setMana(c.getDouble("stats.mana"));

        this.setStr(c.getInt("stats.strength"));
        this.setDex(c.getInt("stats.dexterity"));
        this.setCon(c.getInt("stats.constitution"));
        this.setWis(c.getInt("stats.wisdom"));
        this.setChr(c.getInt("stats.charisma"));

        loadCustomConfig(c);
    }

    public void logout(){
        save();
        timer.cancel();
        Main.plugin.players.remove(this);
        player.removeMetadata("class", Main.plugin);
        Main.plugin.getLogger().info("Logged out " + this);
    }

    public void login(){
        ArcaniaPlayer existingPlayer = Main.plugin.getArcaniaPlayer(getPlayer());
        if(existingPlayer != null){
            existingPlayer.logout();
        }

        Main.plugin.players.add(this);
        getPlayer().setMetadata("class", new FixedMetadataValue(Main.plugin, getClassName()));
        loop();
        Main.plugin.getLogger().info("Logged in " + this);
    }

    public void loop()  {
        timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                statBar();
            }
        };

        timer.schedule(task, 0, 100);
    }

    @Override
    public String toString(){
        return player.getDisplayName() + " [" + getClassName() + "]";
    }

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

    public float getXP()   {
        return this.player.getExp();
    }

    public void setXP(float xp) {
        this.player.setExp(xp);
    }

    public void addXP(float xp) {
        this.player.giveExp((int) xp);
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
