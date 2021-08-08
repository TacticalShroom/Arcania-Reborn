package main.java.com.tacticalshroom.arcania;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    Main plugin = null;

    public void onEnable()  {
        plugin = this;
    }

    public void onDisable() {




        plugin = null;
    }
}
