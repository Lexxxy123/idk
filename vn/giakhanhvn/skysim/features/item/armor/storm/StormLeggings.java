/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.armor.storm;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.armor.LeatherArmorStatistics;

public class StormLeggings
implements MaterialFunction,
LeatherArmorStatistics {
    @Override
    public double getBaseIntelligence() {
        return 250.0;
    }

    @Override
    public double getBaseHealth() {
        return 230.0;
    }

    @Override
    public double getBaseDefense() {
        return 105.0;
    }

    @Override
    public int getColor() {
        return 1550532;
    }

    @Override
    public String getDisplayName() {
        return "Storm's Leggings";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.LEGGINGS;
    }

    @Override
    public String getLore() {
        return null;
    }
}

