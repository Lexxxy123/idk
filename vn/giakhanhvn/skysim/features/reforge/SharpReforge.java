/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.reforge;

import java.util.Collections;
import java.util.List;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.RarityValue;
import vn.giakhanhvn.skysim.features.reforge.Reforge;

public class SharpReforge
implements Reforge {
    @Override
    public String getName() {
        return "Sharp";
    }

    @Override
    public RarityValue<Double> getCritChance() {
        return new RarityValue<Double>(0.1, 0.12, 0.14, 0.17, 0.2, 0.25);
    }

    @Override
    public RarityValue<Double> getCritDamage() {
        return new RarityValue<Double>(0.2, 0.3, 0.4, 0.55, 0.75, 0.9);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}

