package com.tacticalshroom.arcania.profiles;

import com.tacticalshroom.arcania.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import java.io.File;
import java.io.IOException;

public class ProfileSaver implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e)  {

        Player player = e.getPlayer();
        String classSelection = "";
        if (player.hasMetadata("knight"))   {
            classSelection = "knight";
        }
        else if (player.hasMetadata("rogue"))   {
            classSelection = "rogue";
        }
        else if (player.hasMetadata("wizard"))   {
            classSelection = "wizard";
        }
        else if (player.hasMetadata("ranger"))   {
            classSelection = "ranger";
        }
        else if (player.hasMetadata("druid"))   {
            classSelection = "druid";
        }

        if (player.hasMetadata("playing"))   {
            File file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + classSelection + "-Profile.yml");
            FileConfiguration c = YamlConfiguration.loadConfiguration(file);

            c.set("stats.maxHealth", player.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue());
            c.set("stats.health", player.getHealth());
            c.set("stats.level", player.getLevel());
            c.set("inventory.contents", player.getInventory().getContents());
            c.set("inventory.armor", player.getInventory().getArmorContents());
            c.set("location.x", player.getLocation().getX());
            c.set("location.y", player.getLocation().getY());
            c.set("location.z", player.getLocation().getZ());
            c.set("location.yaw", player.getLocation().getYaw());
            c.set("location.pitch", player.getLocation().getPitch());
            c.set("location.world", player.getLocation().getWorld().getName().trim());


            try {
                c.save(file);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

            player.getInventory().clear();
            player.teleport(Bukkit.getWorld("SG").getSpawnLocation());
            player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(20);
            player.setLevel(0);

            player.removeMetadata("playing", Main.plugin);
            player.removeMetadata(classSelection, Main.plugin);
        }
    }

}
