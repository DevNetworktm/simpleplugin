package fr.devnetwork.mysimpleplugin.utils.messages;

import org.bukkit.ChatColor;

public class Error {
    private final String message;

    public Error(String message) {
        this.message = message;
    }

    public String toString() {
        return "[" + ChatColor.RED + "ERROR" + ChatColor.RESET + "] " + this.message;
    }
}
