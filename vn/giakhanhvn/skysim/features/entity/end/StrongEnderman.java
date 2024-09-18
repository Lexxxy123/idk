/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.end;

import vn.giakhanhvn.skysim.features.entity.end.BaseEnderman;

public class StrongEnderman
extends BaseEnderman {
    @Override
    public String getEntityName() {
        return "Enderman";
    }

    @Override
    public double getEntityMaxHealth() {
        return 9000.0;
    }

    @Override
    public double getDamageDealt() {
        return 700.0;
    }

    @Override
    public double getXPDropped() {
        return 36.0;
    }

    @Override
    public int mobLevel() {
        return 50;
    }
}

