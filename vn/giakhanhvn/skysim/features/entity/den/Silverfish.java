/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.den;

import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;

public class Silverfish
implements EntityStatistics,
EntityFunction {
    @Override
    public String getEntityName() {
        return "Silverfish";
    }

    @Override
    public double getEntityMaxHealth() {
        return 50.0;
    }

    @Override
    public double getDamageDealt() {
        return 20.0;
    }

    @Override
    public double getXPDropped() {
        return 5.4;
    }
}

