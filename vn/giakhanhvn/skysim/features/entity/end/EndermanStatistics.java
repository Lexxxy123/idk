/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.material.MaterialData
 */
package vn.giakhanhvn.skysim.features.entity.end;

import org.bukkit.material.MaterialData;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;

public interface EndermanStatistics
extends EntityStatistics {
    default public MaterialData getCarriedMaterial() {
        return null;
    }
}

