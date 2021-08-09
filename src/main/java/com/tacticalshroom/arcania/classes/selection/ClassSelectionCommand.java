package com.tacticalshroom.arcania.classes.selection;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

public class ClassSelectionCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player)   {
            Player player = (Player) sender;
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
            rogueMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Rogue");
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


            player.openInventory(inv);
        }
        return false;
    }
}
