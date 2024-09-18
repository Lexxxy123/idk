/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity;

import vn.giakhanhvn.skysim.features.entity.Ageable;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;

public interface ZombieStatistics
extends EntityStatistics,
Ageable {
    default public boolean isVillager() {
        return false;
    }
}

