/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.dragon.protector;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SkullStatistics;

public class ProtectorDragonFragment
implements SkullStatistics,
MaterialFunction {
    @Override
    public String getURL() {
        return "48de339af63a229c9238d027e47f53eeb56141a419f51b35c31ea1494b435dd3";
    }

    @Override
    public String getDisplayName() {
        return "Protector Dragon Fragment";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ITEM;
    }
}

