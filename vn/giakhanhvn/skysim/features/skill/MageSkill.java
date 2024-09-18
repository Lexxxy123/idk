/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.skill;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import vn.giakhanhvn.skysim.features.skill.DungeonsSkill;
import vn.giakhanhvn.skysim.features.skill.Skill;
import vn.giakhanhvn.skysim.user.User;

public class MageSkill
extends Skill
implements DungeonsSkill {
    public static final MageSkill INSTANCE = new MageSkill();

    @Override
    public String getName() {
        return "Mage";
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
        t2.add("Mage Staff");
        t2.add("Efficent Spells");
        return t2;
    }

    @Override
    public List<String> getOrb() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Guided Sheep");
        t2.add("Thunderstorm");
        return t2;
    }

    @Override
    public List<String> getGhost() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Pop-up Wall");
        t2.add("Fireball");
        return t2;
    }
}

