package fr.devnetwork.mysimpleplugin;

import fr.devnetwork.mysimpleplugin.commands.BroadcastCommand;
import fr.devnetwork.mysimpleplugin.events.PlayerHandler;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
    @Override
    public void onEnable() {
        // Commands
        getCommand("broadcast")
                .setExecutor(new BroadcastCommand());

        // Event
        getServer()
                .getPluginManager()
                .registerEvents(new PlayerHandler(), this);
    }
}
