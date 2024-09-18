/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.accessory;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.accessory.AccessoryStatistics;

public class BlankTalisman
implements AccessoryStatistics,
MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Blank Talisman";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EXCLUSIVE;
    }

    @Override
    public String getLore() {
        return "Apply reforges to this talisman to get effects.";
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.ACCESSORY;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.ACCESSORY;
    }

    @Override
    public String getURL() {
        return "1ad6c81f899a785ecf26be1dc48eae2bcfe777a862390f5785e95bd83bd14d";
    }
}

