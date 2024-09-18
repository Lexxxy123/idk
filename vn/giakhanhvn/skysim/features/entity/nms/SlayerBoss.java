/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.nms;

import java.util.UUID;

public interface SlayerBoss {
    public UUID getSpawnerUUID();

    default public int getTier() {
        return 1;
    }
}

