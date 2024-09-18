/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.mining;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.util.Sputnik;

public class Mitril
implements MaterialStatistics,
MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Mithril";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.COMMON;
    }

    @Override
    public String getLore() {
        return Sputnik.trans("&7&o\"The man called it \"true-silver\" while the Dwarves, who loved it above all other things, had their own, secret name for it.\"");
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
    public boolean isStackable() {
        return true;
    }
}

