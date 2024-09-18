/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.oddities;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;

public class ShardoftheShredded
implements MaterialStatistics,
MaterialFunction,
SkullStatistics {
    @Override
    public String getDisplayName() {
        return "Shard of The Shredded";
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
        return true;
    }

    @Override
    public String getURL() {
        return "b10857e872711e7e6925c9ef1115353b47f58ef07eb5c2d565f1f86023e7a284";
    }

    @Override
    public boolean isStackable() {
        return false;
    }

    @Override
    public String getLore() {
        return "The core of a powerful weapon, dropped by the Atoned Horror.";
    }
}

