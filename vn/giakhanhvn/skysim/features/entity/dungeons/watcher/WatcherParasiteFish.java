/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.dungeons.watcher;

import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;

public class WatcherParasiteFish
implements EntityStatistics,
EntityFunction {
    @Override
    public String getEntityName() {
        return "Parasite";
    }

    @Override
    public double getEntityMaxHealth() {
        return 6.0E7;
    }

    @Override
    public double getDamageDealt() {
        return 500000.0;
    }

    @Override
    public double getXPDropped() {
        return 90.0;
    }

    @Override
    public int mobLevel() {
        return 125;
    }
}

