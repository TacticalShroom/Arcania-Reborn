package com.tacticalshroom.arcania.profiles.classes.selection;

import com.tacticalshroom.arcania.Main;
import com.tacticalshroom.arcania.gui.ArcaniaGUI;
import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import com.tacticalshroom.arcania.profiles.classes.druid.Druid;
import com.tacticalshroom.arcania.profiles.classes.knight.Knight;
import com.tacticalshroom.arcania.profiles.classes.ranger.Ranger;
import com.tacticalshroom.arcania.profiles.classes.rogue.Rogue;
import com.tacticalshroom.arcania.profiles.classes.wizard.Wizard;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.metadata.FixedMetadataValue;

public class ClassSelectionGUI extends ArcaniaGUI {
    @Override
    public String getTitle() {
        return ChatColor.DARK_PURPLE + "Select Class";
    }

    @Override
    public int getSize() {
        return 27;
    }

    private String[] getLore(int baseHealth, String line1, String line2){
        return new String[] {
                ChatColor.ITALIC + line1,
                ChatColor.ITALIC + line2,
                "",
                ChatColor.RED + "Base Health: " + baseHealth,
                "",
                ChatColor.YELLOW + "CLICK TO CREATE A NEW PROFILE"
        };
    }

    private void handleSelection(ArcaniaPlayer player){
        Main.plugin.players.add(player);
        getPlayer().setMetadata("class", new FixedMetadataValue(Main.plugin, player.getClassName()));
        getPlayer().sendMessage(ChatColor.GREEN + "You have selected the " + player.getClassName() + " class!");
        close();
    }

    @Override
    protected void onOpen() {
        setSlot(11, Material.SHIELD, ChatColor.DARK_RED + "Knight",
                getLore(14, "...And in the reigning glory of", "our king we stand true..."));
        addClickHandler(11, () -> {
            handleSelection(new Knight(14, 14, 0, 0, 0, Bukkit.getWorld("SG").getSpawnLocation(), getPlayer()));
        });

        setSlot(12, Material.LEATHER_BOOTS, ChatColor.DARK_PURPLE + "Rogue",
                getLore(10, "When the sun sets, there are", "no laws that bind us..."));
        addClickHandler(12, () -> {
            handleSelection(new Rogue(10, 10, 0, 0, 0, Bukkit.getWorld("SG").getSpawnLocation(), getPlayer()));
        });

        setSlot(13, Material.END_CRYSTAL, ChatColor.GOLD + "Wizard",
                getLore(8, "Bound by the Arcane nature of", "this world, we fight..."));
        addClickHandler(13, () -> {
            handleSelection(new Wizard(8, 8, 0, 0, 0, Bukkit.getWorld("SG").getSpawnLocation(), getPlayer()));
        });

        setSlot(14, Material.BOW, ChatColor.DARK_GREEN + "Ranger",
                getLore(12, "Through cursed shadow and bone,", "our bow shoots true..."));
        addClickHandler(14, () -> {
            handleSelection(new Ranger(12, 12, 0, 0, 0, Bukkit.getWorld("SG").getSpawnLocation(), getPlayer()));
        });

        setSlot(15, Material.FLOWERING_AZALEA_LEAVES, ChatColor.BLUE + "Druid",
                getLore(10, "Through cursed shadow and bone,", "our bow shoots true..."));
        addClickHandler(15, () -> {
            handleSelection(new Druid(10, 10, 0, 0, 0, Bukkit.getWorld("SG").getSpawnLocation(), getPlayer()));
        });

        setSlot(18, Material.BARRIER, "Back");
        addClickHandler(18, () -> new ProfileSelectionGUI().open(getPlayer()));
    }

    @Override
    protected void onClose() {
    }
}
