package de.craftagain.lobbysystem.scoreboard;

import de.alpharout.coinsystem.api.Account;
import de.alpharout.lobbysystem.data.Data;
import de.craftagain.lobbysystem.main.LobbySystem;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import java.sql.SQLException;

public class ScoreboardManager {



    public static void addScoreboard(Player player) throws SQLException {

        org.bukkit.scoreboard.ScoreboardManager scoreboardManager = Bukkit.getScoreboardManager();
        Scoreboard board = scoreboardManager.getNewScoreboard();
        Objective obj = board.registerNewObjective("aaa", "bbb");

        Account account = new Account(player);

        Team players = board.registerNewTeam("players");
        players.addEntry("§a");

        obj.setDisplayName(Data.getName());
        obj.setDisplaySlot(DisplaySlot.SIDEBAR);

        String clan = account.getClanName();

        if(clan.equals("none")) {
            clan = "Kein Clan!";
        }

        obj.getScore("§6").setScore(8);
        obj.getScore("§7Clan:").setScore(7);
        obj.getScore("§8» §b" + clan).setScore(6);

        obj.getScore("§c").setScore(5);
        obj.getScore("§7Spieler:").setScore(4);

        obj.getScore("§8").setScore(2);
        obj.getScore("§7Coins:").setScore(1);
        obj.getScore("§8» §6" + account.getBalance()).setScore(0);

        Bukkit.getScheduler().scheduleSyncRepeatingTask(LobbySystem.getPlugin(LobbySystem.class), new Runnable() {
            @Override
            public void run() {

                int online = Bukkit.getOnlinePlayers().size();
                players.setPrefix("§8» §6" + online);
                obj.getScore("§a").setScore(3);
            }
        },0, 10);

        player.setScoreboard(board);


    }

}
