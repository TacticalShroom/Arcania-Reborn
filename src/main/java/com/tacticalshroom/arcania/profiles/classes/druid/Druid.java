package com.tacticalshroom.arcania.profiles.classes.druid;

import com.tacticalshroom.arcania.Main;
import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;

public class Druid extends ArcaniaPlayer {

    public Druid(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player) {
        super(health, maxHealth, mana, maxMana, level, location, player);
    }

    public Druid(Player player)  {
        super(player);
    }

    public void save() {
        File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "druid" + "-Profile.yml");
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

        try {
            c.save(file);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

        player.getInventory().clear();
        player.teleport(Bukkit.getWorld("SG").getSpawnLocation());
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
        player.setHealth(20);
        player.setLevel(0);

        player.removeMetadata("class", Main.plugin);
    }

    public void load() {
        File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "druid" + "-Profile.yml");
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
        this.setHealth(c.getDouble("stats.health"));
        this.setMaxHealth(c.getDouble("stats.maxHealth"));
        this.setLevel(c.getDouble("stats.level"));
        this.setMana(c.getDouble("stats.mana"));
        this.setMaxMana(c.getDouble("stats.maxMana"));

        this.setStr(c.getInt("stats.strength"));
        this.setDex(c.getInt("stats.dexterity"));
        this.setCon(c.getInt("stats.constitution"));
        this.setWis(c.getInt("stats.wisdom"));
        this.setChr(c.getInt("stats.charisma"));
    }

    public void statBar() {

    }
}
