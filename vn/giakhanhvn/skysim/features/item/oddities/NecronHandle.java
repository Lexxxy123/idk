/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.oddities;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;

public class NecronHandle
implements MaterialStatistics,
MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Necron's Handle";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }

    @Override
    public boolean isEnchanted() {
        return true;
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public long getValue() {
        return 200000000L;
    }

    @Override
    public long getPrice() {
        return 200000000L;
    }
}

