package com.tacticalshroom.arcania.profiles.classes.knight;

import com.tacticalshroom.arcania.Main;
import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;

import java.util.Timer;
import java.util.TimerTask;

public class Knight extends ArcaniaPlayer {

    private int countdown;

    public Knight(double health, double maxHealth, double mana, double maxMana, double level, Location location, Player player) {
        super(health, maxHealth, mana, maxMana, level, location, player);
    }

    public Knight(Player player) {
        super(player);
    }

    @Override
    public String getClassName() {
        return "knight";
    }

    @Override
    protected void saveCustomConfig(FileConfiguration conifg) {
    }

    @Override
    protected void loadCustomConfig(FileConfiguration config) {
    }

    public void ability()   {
        this.player.setMetadata("knightAbility", new FixedMetadataValue(Main.plugin, true));
        countDownStart();
    }

    public void countDownStart()    {
        countdown = 15;
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                countdown -= 1;
                if (countdown <= 0) {
                    timer.cancel();
                    cancel();
                }
            }
        };
        timer.schedule(task, 1000, 1000);
    }

    public void statBar() {
        String arg1 = ChatColor.RED + "♡ " + getHealth() + "/" + getMaxHealth();
        String arg2 = " ";
        String arg3 = ChatColor.WHITE + "Ability: [";

        for (int i = 0; i < 15; i++)    {
            arg3 += i + countdown < 15 ? ChatColor.GREEN + "|" : ChatColor.DARK_RED + "|";
        }
        arg3 += ChatColor.WHITE + "]";

        this.player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(arg1 + "                     " + arg2 + "                     " + arg3));
    }
}
