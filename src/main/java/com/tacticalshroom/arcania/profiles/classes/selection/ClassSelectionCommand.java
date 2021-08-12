package com.tacticalshroom.arcania.profiles.classes.selection;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClassSelectionCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player player) {
            new ProfileSelectionGUI().open(player);

//
//            Inventory inv = Bukkit.createInventory(player, 27, ChatColor.GOLD + "Profile Selection");
//
//            ItemStack[] profileSelectorItems = new ItemStack[27];
//            int counter = 11;
//
//            if (new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "knight" + "-Profile.yml").exists()) {
//
//                File f = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "knight" + "-Profile.yml");
//                FileConfiguration c = YamlConfiguration.loadConfiguration(f);
//
//
//                ItemStack knight = new ItemStack(Material.SHIELD, 1);
//                ItemMeta knightMeta = knight.getItemMeta();
//                knightMeta.setDisplayName(ChatColor.DARK_RED + "Knight");
//                knightMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//                knightMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//                knightMeta.setLocalizedName("knight");
//                ArrayList<String> knightLore = new ArrayList<>();
//                knightLore.add(ChatColor.ITALIC + "...And in the reigning glory of");
//                knightLore.add(ChatColor.ITALIC + "our king we stand true...");
//                knightLore.add("Level: " + ChatColor.YELLOW + c.getInt("stats.level"));
//                knightLore.add("Health: " + ChatColor.RED + c.getInt("stats.health"));
//                knightLore.add("[TEMPLATE]");
//                knightLore.add(" ");
//                knightLore.add(ChatColor.YELLOW + "LEFT CLICK TO SELECT PROFILE");
//                knightMeta.setLore(knightLore);
//                knight.setItemMeta(knightMeta);
//
//                profileSelectorItems[counter] = knight;
//                counter += 1;
//            }
//            if (new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "rogue" + "-Profile.yml").exists()) {
//                File f = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "rogue" + "-Profile.yml");
//                FileConfiguration c = YamlConfiguration.loadConfiguration(f);
//
//                ItemStack rogue = new ItemStack(Material.LEATHER_BOOTS, 1);
//                ItemMeta rogueMeta = rogue.getItemMeta();
//                rogueMeta.setDisplayName(ChatColor.DARK_PURPLE + "Rogue");
//                rogueMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//                rogueMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//                rogueMeta.setLocalizedName("rogue");
//                ArrayList<String> rogueLore = new ArrayList<>();
//                rogueLore.add(ChatColor.ITALIC + "When the sun sets, there are");
//                rogueLore.add(ChatColor.ITALIC + "no laws that bind us...");
//                rogueLore.add("Level: " + ChatColor.YELLOW + c.getInt("stats.level"));
//                rogueLore.add("Health: " + ChatColor.RED + c.getInt("stats.health"));
//                rogueLore.add("[TEMPLATE]");
//                rogueLore.add(" ");
//                rogueLore.add(ChatColor.YELLOW + "LEFT CLICK TO SELECT PROFILE");
//                rogueMeta.setLore(rogueLore);
//                rogue.setItemMeta(rogueMeta);
//
//                profileSelectorItems[counter] = rogue;
//                counter += 1;
//            }
//            if (new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "wizard" + "-Profile.yml").exists()) {
//                File f = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "wizard" + "-Profile.yml");
//                FileConfiguration c = YamlConfiguration.loadConfiguration(f);
//
//                ItemStack wizard = new ItemStack(Material.END_CRYSTAL, 1);
//                ItemMeta wizardMeta = wizard.getItemMeta();
//                wizardMeta.setDisplayName(ChatColor.GOLD + "Wizard");
//                wizardMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//                wizardMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//                wizardMeta.setLocalizedName("wizard");
//                ArrayList<String> wizardLore = new ArrayList<>();
//                wizardLore.add(ChatColor.ITALIC + "Bound by the Arcane nature of");
//                wizardLore.add(ChatColor.ITALIC + "this world, we fight...");
//                wizardLore.add("Level: " + ChatColor.YELLOW + c.getInt("stats.level"));
//                wizardLore.add("Health: " + ChatColor.RED + c.getInt("stats.health"));
//                wizardLore.add("[TEMPLATE]");
//                wizardLore.add(" ");
//                wizardLore.add(ChatColor.YELLOW + "LEFT CLICK TO SELECT PROFILE");
//                wizardMeta.setLore(wizardLore);
//                wizard.setItemMeta(wizardMeta);
//
//                profileSelectorItems[counter] = wizard;
//                counter += 1;
//            }
//            if (new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "ranger" + "-Profile.yml").exists()) {
//                File f = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "ranger" + "-Profile.yml");
//                FileConfiguration c = YamlConfiguration.loadConfiguration(f);
//
//                ItemStack ranger = new ItemStack(Material.BOW, 1);
//                ItemMeta rangerMeta = ranger.getItemMeta();
//                rangerMeta.setDisplayName(ChatColor.DARK_GREEN + "Ranger");
//                rangerMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//                rangerMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//                rangerMeta.setLocalizedName("ranger");
//                ArrayList<String> rangerLore = new ArrayList<>();
//                rangerLore.add(ChatColor.ITALIC + "Through cursed shadow and bone,");
//                rangerLore.add(ChatColor.ITALIC + "our bow shoots true...");
//                rangerLore.add("Level: " + ChatColor.YELLOW + c.getInt("stats.level"));
//                rangerLore.add("Health: " + ChatColor.RED + c.getInt("stats.health"));
//                rangerLore.add("[TEMPLATE]");
//                rangerLore.add(" ");
//                rangerLore.add(ChatColor.YELLOW + "LEFT CLICK TO SELECT PROFILE");
//                rangerMeta.setLore(rangerLore);
//                ranger.setItemMeta(rangerMeta);
//
//                profileSelectorItems[counter] = ranger;
//                counter += 1;
//            }
//            if (new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "druid" + "-Profile.yml").exists()) {
//                File f = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles", player.getUniqueId() + "-" + "druid" + "-Profile.yml");
//                FileConfiguration c = YamlConfiguration.loadConfiguration(f);
//
//                ItemStack druid = new ItemStack(Material.FLOWERING_AZALEA_LEAVES, 1);
//                ItemMeta druidMeta = druid.getItemMeta();
//                druidMeta.setDisplayName(ChatColor.DARK_GREEN + "Druid");
//                druidMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//                druidMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//                druidMeta.setLocalizedName("druid");
//                ArrayList<String> druidLore = new ArrayList<>();
//                druidLore.add(ChatColor.ITALIC + "Through cursed shadow and bone,");
//                druidLore.add(ChatColor.ITALIC + "our bow shoots true...");
//                druidLore.add("Level: " + ChatColor.YELLOW + c.getDouble("stats.level"));
//                druidLore.add("Health: " + ChatColor.RED + c.getDouble("stats.maxHealth"));
//                druidLore.add("[TEMPLATE]");
//                druidLore.add(" ");
//                druidLore.add(ChatColor.YELLOW + "LEFT CLICK TO SELECT PROFILE");
//                druidMeta.setLore(druidLore);
//                druid.setItemMeta(druidMeta);
//
//                profileSelectorItems[counter] = druid;
//                counter += 1;
//            }
//
//            ItemStack blank = new ItemStack(Material.BLACK_STAINED_GLASS_PANE, 1);
//            ItemMeta blankMeta = blank.getItemMeta();
//            blankMeta.setDisplayName(ChatColor.WHITE + "Empty Profile Slot");
//            blankMeta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
//            blankMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
//            blankMeta.setLocalizedName("create");
//            ArrayList<String> blankLore = new ArrayList<>();
//            blankLore.add(ChatColor.ITALIC + "The future of Arcania rests");
//            blankLore.add(ChatColor.ITALIC + "in your hands...");
//            blankLore.add("This is an empty profile slot!");
//            blankLore.add(ChatColor.YELLOW + "CLICK TO CREATE A NEW PROFILE");
//            blankMeta.setLore(blankLore);
//            blank.setItemMeta(blankMeta);
//
//            while (counter < 16)   {
//                profileSelectorItems[counter] = blank;
//                counter++;
//            }
//
//            inv.setContents(profileSelectorItems);
//            player.openInventory(inv);
        }
        return false;
    }
}
