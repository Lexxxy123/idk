/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.entity;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;

public class JerryGunBullet
implements SkullStatistics,
MaterialFunction {
    @Override
    public String getURL() {
        return "17db1923d03c4ef4e9f6e872c5a6ad2578b1aff2b281fbc3ffa7466c825fb9";
    }

    @Override
    public String getDisplayName() {
        return "item.watcher.skull";
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

