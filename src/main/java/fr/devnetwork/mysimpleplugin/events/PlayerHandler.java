package fr.devnetwork.mysimpleplugin.events;

import fr.devnetwork.mysimpleplugin.Main;
import fr.devnetwork.mysimpleplugin.enums.PlayerPermissions;
import fr.devnetwork.mysimpleplugin.utils.managers.Rank;
import fr.devnetwork.mysimpleplugin.utils.messages.CustomColorMessage;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerHandler implements Listener {
    private final Main main;
    private final Rank rank;

    public PlayerHandler(Main main) {
        this.main = main;
        this.rank = this.main.rank;
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        event.setJoinMessage(null);
        final Player player = event.getPlayer();
        Bukkit.broadcastMessage(new CustomColorMessage("[&2 + &r] " + player.getName()).toString());
        this.rank.loadPlayer(player);
        player.setScoreboard(this.rank.getScoreboard());
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent event) {
        event.setQuitMessage(null);
        final Player player = event.getPlayer();
        Bukkit.broadcastMessage(new CustomColorMessage("[&a - &r] " + player.getName()).toString());
        this.rank.deletePlayer(player);
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent event) {
        final Player player = event.getPlayer();
        PlayerPermissions Rank = this.rank.getPlayerRank(player);
        event.setFormat(Rank.getPrefix() + player.getName() + Rank.getChatPrefix() + event.getMessage());
    }

    @EventHandler
    public void onDie(PlayerDeathEvent event) {
        event.setDeathMessage(null);
    }
}
