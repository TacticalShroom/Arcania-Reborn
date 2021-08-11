package com.tacticalshroom.arcania;

import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import com.tacticalshroom.arcania.profiles.classes.selection.ClassSelectionCommand;
import com.tacticalshroom.arcania.profiles.classes.selection.ClassSelectionListener;
import com.tacticalshroom.arcania.profiles.ProfileSaver;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public class Main extends JavaPlugin {

    public static Main plugin = null;
    public static ArrayList<ArcaniaPlayer> players = new ArrayList<>();

    public void onEnable()  {
        plugin = this;

        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + " ");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  ______ " + ChatColor.BLUE + "   Arcania Reborn");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  |    | " + ChatColor.WHITE + "   Fantasy MMORPG By Knightways");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  |----| " + ChatColor.WHITE + "   Developed by TacticalShroom_");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + "  |    | " + ChatColor.RED + "   Developed by PilotBen");
        getServer().getConsoleSender().sendMessage(ChatColor.LIGHT_PURPLE + " ");

        //-------------------------------LISTENERS--------------------------------------------------------------------------------------
        this.getServer().getPluginManager().registerEvents(new ClassSelectionListener(), this);
        this.getServer().getPluginManager().registerEvents(new ProfileSaver(), this);




        //-------------------------------COMMANDS--------------------------------------------------------------------------------------
        this.getCommand("profiles").setExecutor(new ClassSelectionCommand());




    }

    public void onDisable() {


        plugin = null;
    }
}
