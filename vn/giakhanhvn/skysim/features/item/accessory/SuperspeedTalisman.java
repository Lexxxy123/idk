/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.accessory;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.accessory.AccessoryStatistics;

public class SuperspeedTalisman
implements AccessoryStatistics,
MaterialFunction {
    @Override
    public String getDisplayName() {
        return "Superspeed Talisman";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.EPIC;
    }

    @Override
    public double getBaseSpeed() {
        return 3.0;
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
    public boolean isStackable() {
        return false;
    }

    @Override
    public String getURL() {
        return "bb884d61f235235047483ac4ba4ce528691e6424bac13814159272d9673ac";
    }
}

