/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.item.dragon.unstable;

import vn.giakhanhvn.skysim.features.item.MaterialStatistics;
import vn.giakhanhvn.skysim.features.item.armor.ArmorSet;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonBoots;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonChestplate;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonHelmet;
import vn.giakhanhvn.skysim.features.item.dragon.unstable.UnstableDragonLeggings;

public class UnstableDragonSet
implements ArmorSet {
    @Override
    public String getName() {
        return "Unstable Blood";
    }

    @Override
    public String getDescription() {
        return "Every 10 seconds, strike nearby mobs within a 7 block radius dealing 3,000 Damage!";
    }

    @Override
    public Class<? extends MaterialStatistics> getHelmet() {
        return UnstableDragonHelmet.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getChestplate() {
        return UnstableDragonChestplate.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getLeggings() {
        return UnstableDragonLeggings.class;
    }

    @Override
    public Class<? extends MaterialStatistics> getBoots() {
        return UnstableDragonBoots.class;
    }
}

