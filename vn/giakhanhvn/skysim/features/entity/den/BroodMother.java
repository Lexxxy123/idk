/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Entity
 */
package vn.giakhanhvn.skysim.features.entity.den;

import org.bukkit.entity.Entity;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.entity.den.BaseSpider;
import vn.giakhanhvn.skysim.util.SUtil;

public class BroodMother
extends BaseSpider {
    @Override
    public String getEntityName() {
        return "Brood Mother";
    }

    @Override
    public double getEntityMaxHealth() {
        return 6000.0;
    }

    @Override
    public double getDamageDealt() {
        return 100.0;
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        int am2 = SUtil.random(4, 5);
        for (int i2 = 0; i2 < am2; ++i2) {
            new SEntity((Entity)sEntity.getEntity(), SEntityType.CAVE_SPIDER, new Object[0]);
        }
    }

    @Override
    public double getXPDropped() {
        return 17.0;
    }
}

