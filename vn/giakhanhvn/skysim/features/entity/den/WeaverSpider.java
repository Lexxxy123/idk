/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.den;

import vn.giakhanhvn.skysim.features.entity.den.BaseSpider;

public class WeaverSpider
extends BaseSpider {
    @Override
    public String getEntityName() {
        return "Splitter Spider";
    }

    @Override
    public double getEntityMaxHealth() {
        return 160.0;
    }

    @Override
    public double getDamageDealt() {
        return 35.0;
    }

    @Override
    public double getXPDropped() {
        return 9.7;
    }

    @Override
    public int mobLevel() {
        return 2;
    }

    public static class Strong
    extends BaseSpider {
        @Override
        public String getEntityName() {
            return "Splitter Spider";
        }

        @Override
        public double getEntityMaxHealth() {
            return 200.0;
        }

        @Override
        public double getDamageDealt() {
            return 45.0;
        }

        @Override
        public double getXPDropped() {
            return 8.0;
        }

        @Override
        public int mobLevel() {
            return 2;
        }
    }
}

