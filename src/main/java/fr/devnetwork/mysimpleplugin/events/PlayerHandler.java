package fr.devnetwork.mysimpleplugin.events;

import fr.devnetwork.mysimpleplugin.utils.messages.CustomColorMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerHandler implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        final Player player = event.getPlayer();
        Bukkit.broadcastMessage(new CustomColorMessage("[&2 + &r] " + player.getName()).toString());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        final Player player = event.getPlayer();
        Bukkit.broadcastMessage(new CustomColorMessage("[&a - &r] " + player.getName()).toString());
    }

    @EventHandler
    public void onDie(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }
}
