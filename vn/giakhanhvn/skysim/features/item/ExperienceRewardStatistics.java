/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item;

import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.skill.Skill;

public interface ExperienceRewardStatistics
extends MaterialStatistics {
    public double getRewardXP();

    public Skill getRewardedSkill();
}

