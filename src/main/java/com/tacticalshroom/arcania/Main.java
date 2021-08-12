package com.tacticalshroom.arcania;

import com.tacticalshroom.arcania.gui.GUIManager;
import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import com.tacticalshroom.arcania.profiles.classes.selection.ProfileSelectionCommand;
import com.tacticalshroom.arcania.profiles.ProfileSaver;
import org.bukkit.ChatColor;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static Main plugin = null;
    public ArrayList<ArcaniaPlayer> players = new ArrayList<>();
    public GUIManager gui = new GUIManager();

    public void onEnable()  {
        plugin = this;

        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + " ");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  ______ " + ChatColor.BLUE + "   Arcania Reborn");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  |    | " + ChatColor.WHITE + "   Fantasy MMORPG By Knightways");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  |----| " + ChatColor.WHITE + "   Developed by TacticalShroom_");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  |    | " + ChatColor.RED + "   Developed by PilotBen");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + " ");


        //-------------------------------LISTENERS--------------------------------------------------------------------------------------
        PluginManager pluginManager = getServer().getPluginManager();
        pluginManager.registerEvents(new ProfileSaver(), this);
        pluginManager.registerEvents(gui, this);


        //-------------------------------COMMANDS--------------------------------------------------------------------------------------
        this.getCommand("profiles").setExecutor(new ProfileSelectionCommand());
    }

    public void onDisable() {
        plugin = null;
    }
}
