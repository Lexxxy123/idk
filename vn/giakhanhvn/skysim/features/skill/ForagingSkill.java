/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.features.skill;

import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import vn.giakhanhvn.skysim.features.skill.Skill;
import vn.giakhanhvn.skysim.user.PlayerStatistics;
import vn.giakhanhvn.skysim.user.PlayerUtils;
import vn.giakhanhvn.skysim.user.User;

public class ForagingSkill
extends Skill {
    public static final ForagingSkill INSTANCE = new ForagingSkill();

    @Override
    public String getName() {
        return "Foraging";
    }

    @Override
    public String getAlternativeName() {
        return "Logger";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("Cut trees and forage for other", "plants to earn Foraging XP!");
    }

    public double getDoubleDropChance(int level) {
        return (double)level * 4.0 / 100.0;
    }

    public double getTripleDropChance(int level) {
        return ((double)level - 25.0) * 4.0 / 100.0;
    }

    public double getStrength(int level) {
        return (double)level < 15.0 ? (double)level : (double)level + ((double)level - 14.0);
    }

    @Override
    public List<String> getLevelUpInformation(int level, int lastLevel, boolean showOld) {
        String dropChance = (showOld ? ChatColor.DARK_GRAY + "" + lastLevel * 4 + "\u279c" : "") + ChatColor.GREEN + level * 4;
        if (level > 25) {
            dropChance = (showOld ? ChatColor.DARK_GRAY + "" + (lastLevel - 25) * 4 + "\u279c" : "") + ChatColor.GREEN + (level - 25) * 4;
        }
        return Arrays.asList(ChatColor.WHITE + " Grants " + dropChance + "%" + ChatColor.WHITE + " chance", ChatColor.WHITE + " to drop " + (level > 25 ? "3" : "2") + "x logs.", ChatColor.DARK_GRAY + "+" + ChatColor.GREEN + (level >= 15 ? "2" : "1") + " " + ChatColor.RED + "\u2741 Strength");
    }

    @Override
    public boolean hasSixtyLevels() {
        return false;
    }

    @Override
    public void onSkillUpdate(User user, double previousXP) {
        super.onSkillUpdate(user, previousXP);
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(user.getUuid());
        statistics.zeroAll(13);
        statistics.getStrength().set(13, this.getStrength(ForagingSkill.getLevel(user.getSkillXP(this), this.hasSixtyLevels())));
    }
}

