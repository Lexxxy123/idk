/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.oddities;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;

public class JudgementCore
implements MaterialStatistics,
MaterialFunction,
SkullStatistics {
    @Override
    public String getDisplayName() {
        return "Judgement Core";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return false;
    }

    @Override
    public String getURL() {
        return "2f3ddd7f81089c85b26ed597675519f03a1dcd6d1713e0cfc66afb8743cbe0";
    }

    @Override
    public boolean isStackable() {
        return false;
    }
}

