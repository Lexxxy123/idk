/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.reforge;

import java.util.Arrays;
import java.util.List;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.RarityValue;

public interface Reforge {
    public String getName();

    default public RarityValue<Double> getStrength() {
        return RarityValue.zeroDouble();
    }

    default public RarityValue<Double> getCritChance() {
        return RarityValue.zeroDouble();
    }

    default public RarityValue<Double> getCritDamage() {
        return RarityValue.zeroDouble();
    }

    default public RarityValue<Double> getIntelligence() {
        return RarityValue.zeroDouble();
    }

    default public RarityValue<Double> getFerocity() {
        return RarityValue.zeroDouble();
    }

    default public RarityValue<Double> getAttackSpeed() {
        return RarityValue.zeroDouble();
    }

    default public List<GenericItemType> getCompatibleTypes() {
        return Arrays.asList(GenericItemType.values());
    }

    public static Reforge blank() {
        return () -> "Blank";
    }
}

