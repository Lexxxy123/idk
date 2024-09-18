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

public class BerserkSkill
extends Skill
implements DungeonsSkill {
    public static final BerserkSkill INSTANCE = new BerserkSkill();

    @Override
    public String getName() {
        return "Berserk";
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
        t2.add("Bloodlust");
        t2.add("Lust for Blood");
        return t2;
    }

    @Override
    public List<String> getOrb() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Throwing Axe");
        t2.add("Ragnagrok");
        return t2;
    }

    @Override
    public List<String> getGhost() {
        ArrayList<String> t2 = new ArrayList<String>();
        t2.add("Throwing Axe");
        t2.add("Strength Potion");
        return t2;
    }
}

