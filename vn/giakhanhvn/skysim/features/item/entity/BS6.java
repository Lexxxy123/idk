/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.entity;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;

public class BS6
implements SkullStatistics,
MaterialFunction {
    @Override
    public String getURL() {
        return "f052be1c06a4a325129d6f41bb84f0ea1ca6f9f69ebdfff4316e742451c79c21";
    }

    @Override
    public String getDisplayName() {
        return "BZB6";
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

