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

public class TankSkill
extends Skill
implements DungeonsSkill {
    public static final TankSkill INSTANCE = new TankSkill();

    @Override
    public String getName() {
        return "Tank";
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
        t2.add("Protective Barrier" + ChatColor.RED + " Soon!");
        t2.add("Taunt");
        t2.add("Diversion");
        t2.add("Defensive Stance");
        return t2;
    }

    @Override
    public List<String> getOrb() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Seismic Wave");
        t2.add("Castle of Stone");
        return t2;
    }

    @Override
    public List<String> getGhost() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Stun Potion");
        t2.add("Absorption Potion");
        return t2;
    }
}

