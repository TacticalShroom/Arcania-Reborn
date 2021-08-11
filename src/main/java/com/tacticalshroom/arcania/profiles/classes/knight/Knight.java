package com.tacticalshroom.arcania.profiles.classes.knight;

import com.tacticalshroom.arcania.Main;
import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.FixedMetadataValue;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class Knight extends ArcaniaPlayer {

    private int countdown;

    public Knight(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player) {
        super(health, maxHealth, mana, maxMana, level, location, player);
    }

    public Knight(Player player) {
        super(player);
    }

    public void save() {
        File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "knight" + "-Profile.yml");
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
        File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "knight" + "-Profile.yml");
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

    public void ability()   {
        this.player.setMetadata("knightAbility", new FixedMetadataValue(Main.plugin, true));
        countDownStart();
    }

    public void countDownStart()    {
        countdown = 15;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countdown -= 1;
                if (countdown <= 0) {
                    timer.cancel();
                    cancel();
                }
            }
        };
        timer.schedule(task, 1000, 1000);
    }

    public void statBar() {
        String arg1 = ChatColor.RED + "♡ " + getHealth() + "/" + getMaxHealth();
        String arg2 = " ";
        String arg3 = ChatColor.WHITE + "Ability: [";

        for (int i = 0; i < 15; i++)    {
            arg3 += i + countdown < 15 ? ChatColor.GREEN + "|" : ChatColor.DARK_RED + "|";
        }
        arg3 += ChatColor.WHITE + "]";

        this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(arg1 + "                     " + arg2 + "                     " + arg3));
    }
}
