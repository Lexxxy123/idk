/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.den;

import vn.giakhanhvn.skysim.features.entity.den.BaseSpider;

public class DasherSpider
extends BaseSpider {
    @Override
    public String getEntityName() {
        return "Dasher Spider";
    }

    @Override
    public double getEntityMaxHealth() {
        return 160.0;
    }

    @Override
    public double getDamageDealt() {
        return 55.0;
    }

    @Override
    public double getMovementSpeed() {
        return 0.3;
    }

    @Override
    public double getXPDropped() {
        return 10.8;
    }
}

