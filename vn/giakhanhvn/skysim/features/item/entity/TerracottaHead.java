/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.entity;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;

public class TerracottaHead
implements SkullStatistics,
MaterialFunction {
    @Override
    public String getURL() {
        return "6570a2d2a362adeeb05e6f25edcd54cac335f22f0e4669e9c1ebd9a02573bcab";
    }

    @Override
    public String getDisplayName() {
        return "E";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ARMOR;
    }
}

