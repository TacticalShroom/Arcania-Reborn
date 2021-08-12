package com.tacticalshroom.arcania.profiles;

import com.tacticalshroom.arcania.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class ProfileSaver implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e)  {

        Player player = e.getPlayer();

        if (player.hasMetadata("class"))   {
            for (ArcaniaPlayer arcaniaPlayer : Main.plugin.players)    {
                if (arcaniaPlayer.player == player) {
                    arcaniaPlayer.save();
                    Main.plugin.players.remove(arcaniaPlayer);
                    break;
                }
            }
        }
    }

}
