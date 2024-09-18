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

public class ArcherSkill
extends Skill
implements DungeonsSkill {
    public static final ArcherSkill INSTANCE = new ArcherSkill();

    @Override
    public String getName() {
        return "Archer";
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
        t2.add("Doubleshot");
        t2.add("Bone Plating");
        t2.add("Bouncy Arrows" + ChatColor.RED + " Soon!");
        return t2;
    }

    @Override
    public List<String> getOrb() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Explosive Shot");
        t2.add("Machine Gun Bow");
        return t2;
    }

    @Override
    public List<String> getGhost() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Stun Bow");
        t2.add("Healing Bow");
        return t2;
    }
}

