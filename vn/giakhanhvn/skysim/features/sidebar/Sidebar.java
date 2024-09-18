/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.scoreboard.DisplaySlot
 *  org.bukkit.scoreboard.Objective
 *  org.bukkit.scoreboard.Score
 *  org.bukkit.scoreboard.Scoreboard
 *  org.bukkit.scoreboard.ScoreboardManager
 */
package vn.giakhanhvn.skysim.features.sidebar;

import java.util.ArrayList;
import java.util.List;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class Sidebar {
    private static ScoreboardManager manager = Bukkit.getScoreboardManager();
    private String name;
    private String identifier;
    private Scoreboard board;
    private Objective obj;
    private List<Score> scores;

    public Sidebar(String name, String identifier) {
        this.name = name;
        this.identifier = identifier;
        this.board = manager.getNewScoreboard();
        this.obj = this.board.registerNewObjective(identifier, "");
        this.scores = new ArrayList<Score>();
        this.obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        this.obj.setDisplayName(name);
    }

    public void add(String s2) {
        Score score = this.obj.getScore(s2);
        this.scores.add(0, score);
    }

    public void apply(Player player) {
        for (int i2 = 0; i2 < this.scores.size(); ++i2) {
            this.scores.get(i2).setScore(i2);
        }
        player.setScoreboard(this.board);
    }
}

