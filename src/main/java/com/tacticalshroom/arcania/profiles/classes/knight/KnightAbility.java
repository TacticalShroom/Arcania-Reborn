package com.tacticalshroom.arcania.profiles.classes.knight;

import com.tacticalshroom.arcania.Main;
import com.tacticalshroom.arcania.profiles.ArcaniaPlayer;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class KnightAbility implements Listener {

    @EventHandler
    public void onRightClick(PlayerInteractEvent e)  {
        ArcaniaPlayer player = Main.plugin.getArcaniaPlayer(e.getPlayer());
        if(player != null){
            if (player instanceof Knight knight) {
                if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                    knight.ability();
                }
            }
        }
    }
}
