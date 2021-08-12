package com.tacticalshroom.arcania.profiles.classes.wizard;

import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Wizard extends ArcaniaPlayer {

    public Wizard(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player) {
        super(health, maxHealth, mana, maxMana, level, location, player);
    }

    public Wizard(Player player) {
        super(player);
    }


    @Override
    protected String getConfigName() {
        return "wizard";
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
