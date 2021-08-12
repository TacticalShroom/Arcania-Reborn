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
        for (ArcaniaPlayer arcaniaPlayer : Main.plugin.players)    {
            if (arcaniaPlayer.getPlayer() == e.getPlayer()) {
                if (arcaniaPlayer instanceof Knight)    {
                    if (e.getAction().equals(Action.RIGHT_CLICK_AIR) || e.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
                        Knight knight = (Knight) arcaniaPlayer;
                        knight.ability();
                    }
                }
            }
        }
    }

    @EventHandler
    public void onHit(PlayerInteractEvent e) {
        if (e.getAction().equals(Action.LEFT_CLICK_AIR) || e.getAction().equals(Action.LEFT_CLICK_BLOCK))  {
            if (e.getPlayer().hasMetadata("knightAbility"))  {
                e.getPlayer().removeMetadata("knightAbility", Main.plugin);
                if (e.getClickedBlock() != null)    {

                }
            }
        }
    }

}
