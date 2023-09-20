package fr.devnetwork.mysimpleplugin.utils.managers;

import com.google.common.collect.Maps;
import fr.devnetwork.mysimpleplugin.Main;
import fr.devnetwork.mysimpleplugin.enums.PlayerPermissions;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class Rank {
    private final Main main;
    private final Map<String, PlayerPermissions> players = Maps.newHashMap();
    private Scoreboard scoreboard;

    private FileConfiguration BDD;
    private File file;

    public Rank(Main main) {
        this.main = main;
    }

    private void initBDD() {
        File f = new File("plugins/SimplePlugin/Permissions/");
        if (!f.exists()) f.mkdirs();
        file = new File(f, "bdd.yml");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ioe) {
                ioe.printStackTrace();
            }
        }

        BDD = YamlConfiguration.loadConfiguration(file);
    }

    public void init() {
        this.initBDD();
        if (scoreboard != null) throw new UnsupportedOperationException("this.scoreboard is init !");
        this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();

        for (PlayerPermissions rank : PlayerPermissions.values()) {
            Team team = this.scoreboard.registerNewTeam(rank.getName());
            team.setPrefix(rank.getPrefix());
            team.setSuffix("");
        }
    }

    public void loadPlayer(Player player) {
        String uuid = player.getUniqueId().toString();
        if (players.containsKey(uuid)) return;
        if (!BDD.contains(uuid)) {
            BDD.set(uuid, PlayerPermissions.PLAYER.getId());
            save();
        }
        players.put(uuid, this.getRankById(BDD.getInt(uuid)));
        this.scoreboard.getTeam(players.get(uuid).getName()).addEntry(player.getName());
    }

    public void deletePlayer(Player player) {
        String uuid = player.getUniqueId().toString();
        if (!players.containsKey(uuid)) return;
        players.remove(uuid);
    }

    public PlayerPermissions getPlayerRank(Player player) {
        String uuid = player.getUniqueId().toString();
        if (!players.containsKey(uuid)) loadPlayer(player);
        return players.get(uuid);
    }

    public PlayerPermissions getRankById(int id) {
        for (PlayerPermissions rank : PlayerPermissions.values()) {
            if (rank.getId() == id) return rank;
        }
        return PlayerPermissions.PLAYER;
    }

    public void save() {
        try {
            BDD.save(file);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }

    public final Main getMain() {
        return main;
    }

    public final Scoreboard getScoreboard() {
        return this.scoreboard;
    }
}
