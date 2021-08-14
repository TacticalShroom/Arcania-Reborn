package com.tacticalshroom.arcania.items;

import com.tacticalshroom.arcania.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class AGiveCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player player) {
            if(strings.length < 2 || strings.length > 3){
                player.sendRawMessage(ChatColor.RED + "Invalid number of arguments.");
                return false;
            }

            Player targetPlayer = player.getServer().getPlayer(strings[0]);
            if(targetPlayer == null){
                player.sendRawMessage(ChatColor.RED + "Could not find the specified player.");
                return false;
            }

            ArcaniaItemType itemType = Main.plugin.itemManager.getItemType(strings[1]);
            if(itemType == null){
                player.sendRawMessage(ChatColor.RED + "Invalid item key.");
                return false;
            }

            int amount = 1;
            if(strings.length == 3){
                try {
                    amount = Integer.parseInt(strings[2]);
                } catch (NumberFormatException ignored) {
                    player.sendRawMessage(ChatColor.RED + "Could not parse number of items.");
                    return false;
                }
            }

            targetPlayer.getInventory().addItem(itemType.createItemStack(amount));
        }
        return false;
    }
}
