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
        update();
        File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "druid" + "-Profile.yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(file);

        //stats
        c.set("stats.maxHealth", this.maxHealth);
        c.set("stats.health", this.health);
        c.set("stats.level", this.level);
        c.set("stats.mana", this.mana);
        c.set("stats.maxMana", this.maxMana);

        //inventory
        c.set("inventory.contents", this.inventory);
        c.set("inventory.armor", this.armor);

        //location
        c.set("location.x", this.location.getX());
        c.set("location.y", this.location.getY());
        c.set("location.z", this.location.getZ());
        c.set("location.yaw", this.location.getYaw());
        c.set("location.pitch", this.location.getPitch());
        c.set("location.world", this.location.getWorld().getName().trim());


        //core stats
        c.set("stats.strength", this.str);
        c.set("stats.dexterity", this.dex);
        c.set("stats.constitution", this.con);
        c.set("stats.wisdom", this.wis);
        c.set("stats.charisma", this.chr);

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

        player.removeMetadata("playing", Main.plugin);
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
        this.location = location;
        this.inventory = c.getList("inventory.contents").toArray(new ItemStack[36]);
        this.armor = c.getList("inventory.armor").toArray(new ItemStack[4]);
        this.health = c.getDouble("stats.health");
        this.maxHealth = c.getDouble("stats.maxHealth");
        this.level = c.getDouble("stats.level");
        this.mana = c.getDouble("stats.mana");
        this.maxMana = c.getDouble("stats.maxMana");

        this.str = c.getInt("stats.strength");
        this.dex = c.getInt("stats.dexterity");
        this.con = c.getInt("stats.constitution");
        this.wis = c.getInt("stats.wisdom");
        this.chr = c.getInt("stats.charisma");

        player.teleport(this.location);
        player.getInventory().setContents(this.inventory);
        player.getInventory().setArmorContents(this.armor);
        player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(this.maxHealth);
        player.setHealth(this.health);
    }




    public void update()    {
        this.health = (float) player.getHealth();
        this.inventory = player.getInventory().getContents();
        this.armor = player.getInventory().getArmorContents();
        this.level = player.getLevel();
        this.maxHealth = (float) player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getBaseValue();
        this.location = player.getLocation();
        //mana and maxMana is not needed to update because mana is purely stored in the arcaniaPlayer class
    }
}
