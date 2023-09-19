package fr.devnetwork.mysimpleplugin.commands;

import fr.devnetwork.mysimpleplugin.utils.messages.Error;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BroadcastCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(new Error("/broadcast <args>").toString());
        }

        String message = String.join(" ", args);
        message = ChatColor.translateAlternateColorCodes('&', message);

        Bukkit.broadcastMessage(message);
        return false;
    }
}
