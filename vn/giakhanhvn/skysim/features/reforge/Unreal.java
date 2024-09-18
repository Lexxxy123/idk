/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.reforge;

import java.util.Collections;
import java.util.List;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.RarityValue;
import vn.giakhanhvn.skysim.features.reforge.Reforge;

public class Unreal
implements Reforge {
    @Override
    public String getName() {
        return "Unreal";
    }

    @Override
    public RarityValue<Double> getStrength() {
        return new RarityValue<Double>(3.0, 7.0, 12.0, 18.0, 25.0, 34.0);
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<Double>(0.08, 0.09, 0.1, 0.11, 0.13, 0.15);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<Double>(0.05, 0.1, 0.18, 0.32, 0.5, 0.7);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.RANGED_WEAPON);
    }
}

