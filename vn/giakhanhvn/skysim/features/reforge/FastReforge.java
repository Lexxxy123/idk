/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.reforge;

import java.util.Collections;
import java.util.List;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.RarityValue;
import vn.giakhanhvn.skysim.features.reforge.Reforge;

public class FastReforge
implements Reforge {
    @Override
    public String getName() {
        return "Fast";
    }

    @Override
    public RarityValue<Double> getAttackSpeed() {
        return new RarityValue<Double>(10.0, 20.0, 30.0, 40.0, 50.0, 60.0);
    }

    @Override
    public List<GenericItemType> getCompatibleTypes() {
        return Collections.singletonList(GenericItemType.WEAPON);
    }
}

