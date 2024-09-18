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

public class SplitterSpider
extends BaseSpider {
    @Override
    public String getEntityName() {
        return "Splitter Spider";
    }

    @Override
    public double getEntityMaxHealth() {
        return 180.0;
    }

    @Override
    public double getDamageDealt() {
        return 30.0;
    }

    @Override
    public double getXPDropped() {
        return 9.7;
    }

    @Override
    public void onDeath(SEntity sEntity, Entity killed, Entity damager) {
        super.onDeath(sEntity, killed, damager);
        for (int i2 = 0; i2 < 2; ++i2) {
            new SEntity((Entity)sEntity.getEntity(), SEntityType.SILVERFISH, new Object[0]);
        }
    }
}

