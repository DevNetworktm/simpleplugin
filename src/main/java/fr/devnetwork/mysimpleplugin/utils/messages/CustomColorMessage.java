package fr.devnetwork.mysimpleplugin.utils.messages;

import org.bukkit.ChatColor;

public class CustomColorMessage {
    final String message;

    public CustomColorMessage(String message) {
        this.message = message;
    }

    public String toString() {
        return ChatColor.translateAlternateColorCodes('&', this.message);
    }
}
