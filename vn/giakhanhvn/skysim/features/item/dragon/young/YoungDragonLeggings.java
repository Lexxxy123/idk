/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.dragon.young;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.armor.LeatherArmorStatistics;

public class YoungDragonLeggings
implements MaterialFunction,
LeatherArmorStatistics {
    @Override
    public double getBaseSpeed() {
        return 0.2;
    }

    @Override
    public double getBaseHealth() {
        return 110.0;
    }

    @Override
    public double getBaseDefense() {
        return 140.0;
    }

    @Override
    public int getColor() {
        return 14542064;
    }

    @Override
    public String getDisplayName() {
        return "Young Dragon Leggings";
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

