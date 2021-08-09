package com.tacticalshroom.arcania;

import com.tacticalshroom.arcania.classes.selection.ClassSelectionCommand;
import com.tacticalshroom.arcania.classes.selection.ClassSelectionListener;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    Main plugin = null;

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





        //-------------------------------COMMANDS--------------------------------------------------------------------------------------
        this.getCommand("class").setExecutor(new ClassSelectionCommand());




    }

    public void onDisable() {


        plugin = null;
    }
}
