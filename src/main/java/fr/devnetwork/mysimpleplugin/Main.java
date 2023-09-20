package fr.devnetwork.mysimpleplugin;

import fr.devnetwork.mysimpleplugin.commands.BroadcastCommand;
import fr.devnetwork.mysimpleplugin.events.PlayerHandler;
import fr.devnetwork.mysimpleplugin.utils.managers.Rank;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    public Rank rank;

    @Override
    public void onLoad() {
        rank = new Rank(this);
    }

    @Override
    public void onEnable() {
        // Commands
        getCommand("broadcast")
                .setExecutor(new BroadcastCommand());

        // Event
        getServer()
                .getPluginManager()
                .registerEvents(new PlayerHandler(this), this);

        // ScoreBoard
        rank.init();
    }
}
