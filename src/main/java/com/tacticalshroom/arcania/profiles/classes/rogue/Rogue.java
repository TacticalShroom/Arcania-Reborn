package com.tacticalshroom.arcania.profiles.classes.rogue;

import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Rogue extends ArcaniaPlayer {
    public Rogue(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player) {
        super(health, maxHealth, mana, maxMana, level, location, player);
    }

    public Rogue(Player player) {
        super(player);
    }

    @Override
    protected String getConfigName() {
        return "rogue";
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
