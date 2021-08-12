package com.tacticalshroom.arcania.profiles;

import com.tacticalshroom.arcania.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class ProfileSaver implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e)  {
        ArcaniaPlayer player = Main.plugin.getArcaniaPlayer(e.getPlayer());
        if(player != null){
            player.logout();
        }
    }
}
