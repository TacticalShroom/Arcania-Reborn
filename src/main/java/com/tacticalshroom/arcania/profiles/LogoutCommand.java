package com.tacticalshroom.arcania.profiles;

import com.tacticalshroom.arcania.Main;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LogoutCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            ArcaniaPlayer player = Main.plugin.getArcaniaPlayer((Player)sender);
            if(player != null){
                player.logout();
            }
        }
        return false;
    }
}
