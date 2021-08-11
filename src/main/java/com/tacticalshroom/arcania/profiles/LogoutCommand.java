package com.tacticalshroom.arcania.profiles;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class LogoutCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player)   {
            Player player = (Player) sender;
            if (player instanceof ArcaniaPlayer)    {

            }
        }
        return false;
    }
}
