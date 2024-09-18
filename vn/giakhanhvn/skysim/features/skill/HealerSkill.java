/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.features.skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import vn.giakhanhvn.skysim.features.skill.DungeonsSkill;
import vn.giakhanhvn.skysim.features.skill.Skill;
import vn.giakhanhvn.skysim.user.User;

public class HealerSkill
extends Skill
implements DungeonsSkill {
    public static final HealerSkill INSTANCE = new HealerSkill();

    @Override
    public String getName() {
        return "Healer";
    }

    @Override
    public String getAlternativeName() {
        return "{skip}";
    }

    @Override
    public List<String> getDescription() {
        return Arrays.asList("");
    }

    @Override
    public List<String> getLevelUpInformation(int level, int lastLevel, boolean showOld) {
        return Arrays.asList("");
    }

    @Override
    public boolean hasSixtyLevels() {
        return false;
    }

    @Override
    public void onSkillUpdate(User user, double previousXP) {
        super.onSkillUpdate(user, previousXP);
    }

    @Override
    public List<String> getPassive() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Renew");
        t2.add("Healing Aura");
        t2.add("Revive");
        t2.add("Orbies" + ChatColor.RED + " Soon!");
        t2.add("Soul Tether" + ChatColor.RED + " Soon!");
        return t2;
    }

    @Override
    public List<String> getOrb() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Healing Circle");
        t2.add("Wish");
        return t2;
    }

    @Override
    public List<String> getGhost() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Healing Potion");
        t2.add("Revive Self");
        return t2;
    }
}

