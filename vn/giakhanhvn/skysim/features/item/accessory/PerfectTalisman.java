/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.accessory;

import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.accessory.AccessoryStatistics;
import vn.giakhanhvn.skysim.util.Sputnik;

public class PerfectTalisman
implements AccessoryStatistics,
MaterialFunction {
    @Override
    public String getURL() {
        return "13e8bbc8d174aecd6b46888fa63f9bade14b042e5e17063139d67f8e0163a38";
    }

    @Override
    public String getDisplayName() {
        return "Perfect Talisman";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.MYTHIC;
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
    public String getLore() {
        return Sputnik.trans("&7Perfection, the Motherland proud of you...");
    }

    @Override
    public double getBaseHealth() {
        return 600.0;
    }

    @Override
    public double getBaseStrength() {
        return 180.0;
    }

    @Override
    public double getBaseCritChance() {
        return 0.1;
    }

    @Override
    public double getBaseCritDamage() {
        return 0.15;
    }

    @Override
    public double getBaseIntelligence() {
        return 200.0;
    }

    @Override
    public double getBaseDefense() {
        return 200.0;
    }

    @Override
    public double getBaseFerocity() {
        return 5.0;
    }

    @Override
    public double getBaseMagicFind() {
        return 0.1;
    }

    @Override
    public boolean isStackable() {
        return false;
    }
}

