package com.tacticalshroom.arcania.classes.selection;

import com.tacticalshroom.arcania.Main;
import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

public class ClassSelectionListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        if (e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
        if (e.getView().getTitle().startsWith(ChatColor.GOLD + "Class Selection"))  {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();

            File file;
            FileConfiguration c = null;
            boolean load = false;

            if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("knight"))   {
                player.setMetadata("knight", new FixedMetadataValue(Main.plugin, "knight"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));
                player.sendMessage(ChatColor.GREEN + "You have selected the knight class!");

                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "knight" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);

                load = true;
                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("rogue"))   {
                player.setMetadata("rogue", new FixedMetadataValue(Main.plugin, "rogue"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));
                player.sendMessage(ChatColor.GREEN + "You have selected the rogue class!");

                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "rogue" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);

                load = true;
                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("wizard"))   {
                player.setMetadata("wizard", new FixedMetadataValue(Main.plugin, "wizard"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));
                player.sendMessage(ChatColor.GREEN + "You have selected the wizard class!");


                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "wizard" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);


                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("ranger"))   {
                player.setMetadata("ranger", new FixedMetadataValue(Main.plugin, "ranger"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));
                player.sendMessage(ChatColor.GREEN + "You have selected the ranger class!");

                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("druid"))   {
                player.setMetadata("druid", new FixedMetadataValue(Main.plugin, "druid"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));
                player.sendMessage(ChatColor.GREEN + "You have selected the druid class!");

                player.closeInventory();
            }
        }
        else if (e.getView().getTitle().startsWith(ChatColor.GOLD + "Profile Selection"))    {
            e.setCancelled(true);
            Player player = (Player) e.getWhoClicked();
            if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("create"))   {


                Inventory inv = Bukkit.createInventory(player, 27, ChatColor.GOLD + "Class Selection");

                ItemStack[] classItems = new ItemStack[27];

                ItemStack knight = new ItemStack(Material.SHIELD, 1);
                ItemMeta knightMeta = knight.getItemMeta();
                knightMeta.setDisplayName(ChatColor.DARK_RED + "Knight");
                knightMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                knightMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                knightMeta.setLocalizedName("knight");
                ArrayList<String> knightLore = new ArrayList<>();
                knightLore.add(" ");
                knightLore.add(ChatColor.RED + "Base Health: 14");
                knightLore.add("[TEMPLATE]");
                knightLore.add(" ");
                knightLore.add(ChatColor.YELLOW + "LEFT CLICK TO CREATE CHARACTER");
                knightMeta.setLore(knightLore);
                knight.setItemMeta(knightMeta);

                ItemStack rogue = new ItemStack(Material.LEATHER_BOOTS, 1);
                ItemMeta rogueMeta = rogue.getItemMeta();
                rogueMeta.setDisplayName(ChatColor.DARK_PURPLE + "Rogue");
                rogueMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                rogueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                rogueMeta.setLocalizedName("rogue");
                ArrayList<String> rogueLore = new ArrayList<>();
                rogueLore.add(" ");
                rogueLore.add(ChatColor.RED + "Base Health: 10");
                rogueLore.add("[TEMPLATE]");
                rogueLore.add(" ");
                rogueLore.add(ChatColor.YELLOW + "LEFT CLICK TO CREATE CHARACTER");
                rogueMeta.setLore(rogueLore);
                rogue.setItemMeta(rogueMeta);

                ItemStack wizard = new ItemStack(Material.END_CRYSTAL, 1);
                ItemMeta wizardMeta = wizard.getItemMeta();
                wizardMeta.setDisplayName(ChatColor.GOLD + "Wizard");
                wizardMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                wizardMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                wizardMeta.setLocalizedName("wizard");
                ArrayList<String> wizardLore = new ArrayList<>();
                wizardLore.add(" ");
                wizardLore.add(ChatColor.RED + "Base Health: 8");
                wizardLore.add("[TEMPLATE]");
                wizardLore.add(" ");
                wizardLore.add(ChatColor.YELLOW + "LEFT CLICK TO CREATE CHARACTER");
                wizardMeta.setLore(wizardLore);
                wizard.setItemMeta(wizardMeta);

                ItemStack ranger = new ItemStack(Material.BOW, 1);
                ItemMeta rangerMeta = ranger.getItemMeta();
                rangerMeta.setDisplayName(ChatColor.DARK_GREEN + "Ranger");
                rangerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                rangerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                rangerMeta.setLocalizedName("ranger");
                ArrayList<String> rangerLore = new ArrayList<>();
                rangerLore.add(" ");
                rangerLore.add(ChatColor.RED + "Base Health: 12");
                rangerLore.add("[TEMPLATE]");
                rangerLore.add(" ");
                rangerLore.add(ChatColor.YELLOW + "LEFT CLICK TO CREATE CHARACTER");
                rangerMeta.setLore(rangerLore);
                ranger.setItemMeta(rangerMeta);

                ItemStack druid = new ItemStack(Material.FLOWERING_AZALEA_LEAVES, 1);
                ItemMeta druidMeta = druid.getItemMeta();
                druidMeta.setDisplayName(ChatColor.BLUE + "Druid");
                druidMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
                druidMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
                druidMeta.setLocalizedName("druid");
                ArrayList<String> druidLore = new ArrayList<>();
                druidLore.add(" ");
                druidLore.add(ChatColor.RED + "Base Health: 10");
                druidLore.add("[TEMPLATE]");
                druidLore.add(" ");
                druidLore.add(ChatColor.YELLOW + "LEFT CLICK TO CREATE CHARACTER");
                druidMeta.setLore(druidLore);
                druid.setItemMeta(druidMeta);


                classItems[11] = knight;
                classItems[12] = rogue;
                classItems[13] = wizard;
                classItems[14] = ranger;
                classItems[15] = druid;

                inv.setContents(classItems);

                player.closeInventory();
                player.openInventory(inv);
            }
            File file;
            FileConfiguration c = null;
            boolean load = false;

            if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("knight"))   {
                player.setMetadata("knight", new FixedMetadataValue(Main.plugin, "knight"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));

                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "knight" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);

                load = true;
                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("rogue"))   {
                player.setMetadata("rogue", new FixedMetadataValue(Main.plugin, "rogue"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));

                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "rogue" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);

                load = true;
                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("wizard"))   {
                player.setMetadata("wizard", new FixedMetadataValue(Main.plugin, "wizard"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));


                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "wizard" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);

                load = true;
                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("ranger"))   {
                player.setMetadata("ranger", new FixedMetadataValue(Main.plugin, "ranger"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));

                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "ranger" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);

                load = true;
                player.closeInventory();
            }
            else if (e.getCurrentItem().getItemMeta().getLocalizedName().equals("druid"))   {
                player.setMetadata("druid", new FixedMetadataValue(Main.plugin, "druid"));
                player.setMetadata("playing", new FixedMetadataValue(Main.plugin, "playing"));

                file = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "druid" + "-Profile.yml");
                c = YamlConfiguration.loadConfiguration(file);

                load = true;
                player.closeInventory();
            }
            if (load)   {
                double x = c.getDouble("location.x");
                double y = c.getDouble("location.y");
                double z = c.getDouble("location.z");
                double pitch = c.getDouble("location.pitch");
                double yaw = c.getDouble("location.yaw");

                World world = Bukkit.getWorld(c.getString("location.world"));

                Location location = new Location(world, x, y, z, (float) yaw, (float) pitch);
                player.teleport(location);

                player.getInventory().setContents(c.getList("inventory.contents").toArray(new ItemStack[36]));
                player.getInventory().setArmorContents(c.getList("inventory.armor").toArray(new ItemStack[4]));
                player.setLevel(c.getInt("stats.level"));
                player.getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(c.getInt("stats.maxHealth"));
                player.setHealth(c.getDouble("stats.health"));
            }
        }
    }
}
