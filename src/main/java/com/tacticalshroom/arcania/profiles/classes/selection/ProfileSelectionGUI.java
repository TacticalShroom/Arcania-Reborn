package com.tacticalshroom.arcania.profiles.classes.selection;

import com.tacticalshroom.arcania.Main;
import com.tacticalshroom.arcania.gui.ArcaniaGUI;
import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import com.tacticalshroom.arcania.profiles.classes.druid.Druid;
import com.tacticalshroom.arcania.profiles.classes.knight.Knight;
import com.tacticalshroom.arcania.profiles.classes.ranger.Ranger;
import com.tacticalshroom.arcania.profiles.classes.rogue.Rogue;
import com.tacticalshroom.arcania.profiles.classes.wizard.Wizard;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;

public class ProfileSelectionGUI extends ArcaniaGUI {

    @Override
    public String getTitle() {
        return ChatColor.DARK_PURPLE + "Select Profile";
    }

    @Override
    public int getSize() {
        return 27;
    }

    private FileConfiguration getProfileConfig(String className){
        File f = new File(Main.plugin.getDataFolder().getAbsolutePath() + File.separator + "Profiles",
                getPlayer().getUniqueId() + "-" + className + "-Profile.yml");
        if(f.exists()){
            return YamlConfiguration.loadConfiguration(f);
        }
        return null;
    }

    private String[] getLore(FileConfiguration config){
        return new String[] {
                "Level: " + ChatColor.YELLOW + config.getInt("stats.level"),
                "Health: " + ChatColor.RED + config.getInt("stats.health"),
                "",
                ChatColor.YELLOW + "LEFT CLICK TO SELECT PROFILE"
        };
    }

    private void handleSelection(ArcaniaPlayer player){
        player.login();
        close();
    }

    @Override
    protected void onOpen() {
        int index = 0;

        FileConfiguration config = getProfileConfig("knight");
        if(config != null){
            setSlot(11 + index, Material.SHIELD, ChatColor.DARK_RED + "Knight", getLore(config));
            addClickHandler(11 + index, () -> handleSelection(new Knight(getPlayer())));
            index++;
        }

        config = getProfileConfig("rogue");
        if(config != null){
            setSlot(11 + index, Material.LEATHER_BOOTS, ChatColor.DARK_PURPLE + "Rogue", getLore(config));
            addClickHandler(11 + index, () -> handleSelection(new Rogue(getPlayer())));
            index++;
        }

        config = getProfileConfig("wizard");
        if(config != null){
            setSlot(11 + index, Material.END_CRYSTAL, ChatColor.GOLD + "Wizard", getLore(config));
            addClickHandler(11 + index, () -> handleSelection(new Wizard(getPlayer())));
            index++;
        }

        config = getProfileConfig("ranger");
        if(config != null){
            setSlot(11 + index, Material.BOW, ChatColor.DARK_GREEN + "Ranger", getLore(config));
            addClickHandler(11 + index, () -> handleSelection(new Ranger(getPlayer())));
            index++;
        }

        config = getProfileConfig("druid");
        if(config != null){
            setSlot(11 + index, Material.FLOWERING_AZALEA_LEAVES, ChatColor.DARK_GREEN + "Druid", getLore(config));
            addClickHandler(11 + index, () -> handleSelection(new Druid(getPlayer())));
            index++;
        }

        while(index < 5) {
            setSlot(11 + index, Material.BLACK_STAINED_GLASS_PANE, "Add Profile",
                    ChatColor.ITALIC + "This is an empty profile slot!",
                    "",
                    ChatColor.YELLOW + "CLICK TO CREATE A NEW PROFILE");
            addClickHandler(11 + index, () -> new ClassSelectionGUI().open(getPlayer()));
            index++;
        }
    }

    @Override
    protected void onClose() {
    }
}
