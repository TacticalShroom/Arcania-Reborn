package com.tacticalshroom.arcania.profiles.classes.druid;

import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Druid extends ArcaniaPlayer {

    public Druid(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player) {
        super(health, maxHealth, mana, maxMana, level, location, player);
    }

    public Druid(Player player)  {
        super(player);
    }

    @Override
    protected String getConfigName() {
        return "druid";
    }

    @Override
    protected void saveCustomConfig(FileConfiguration conifg) {
    }

    @Override
    protected void loadCustomConfig(FileConfiguration config) {
    }

    public void statBar() {

    }
}
