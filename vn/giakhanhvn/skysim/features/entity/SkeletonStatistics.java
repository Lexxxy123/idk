/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity;

import vn.giakhanhvn.skysim.features.entity.EntityStatistics;

public interface SkeletonStatistics
extends EntityStatistics {
    default public boolean isWither() {
        return false;
    }
}

