package de.craftagain.lobbysystem.scoreboard;

import de.alpharout.lobbysystem.data.Data;
import de.craftagain.lobbysystem.main.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class ScoreboardManager {



    public static void addScoreboard(Player player){

        org.bukkit.scoreboard.ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard board = scoreboardManager.getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb");

        Team players = board.registerNewTeam("players");
        players.addEntry("§a");

        obj.setDisplayName(Data.getPrefix());
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        obj.getScore("§7------------------").setScore(5);
        obj.getScore("§7Spieler online: ").setScore(4);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(LobbySystem.getPlugin(LobbySystem.class), new Runnable() {
            @Override
            public void run() {

            int online = Bukkit.getOnlinePlayers().size();
            players.setPrefix("§a" + online);
            obj.getScore("§a").setScore(3);
            }
        },0, 10);

        player.setScoreboard(board);


    }

}
