/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.features.entity.wolf;

import java.util.Arrays;
import java.util.List;
import vn.giakhanhvn.skysim.features.entity.EntityDrop;
import vn.giakhanhvn.skysim.features.entity.EntityDropType;
import vn.giakhanhvn.skysim.features.entity.wolf.BaseWolf;
import vn.giakhanhvn.skysim.features.item.SMaterial;

public class HowlingSpirit
extends BaseWolf {
    @Override
    public String getEntityName() {
        return "Howling Spirit";
    }

    @Override
    public double getEntityMaxHealth() {
        return 7000.0;
    }

    @Override
    public double getDamageDealt() {
        return 450.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.SPRUCE_WOOD, EntityDropType.COMMON, 0.25), new EntityDrop(SMaterial.DARK_OAK_WOOD, EntityDropType.COMMON, 0.25), new EntityDrop(SMaterial.ACACIA_WOOD, EntityDropType.COMMON, 0.25));
    }

    @Override
    public double getXPDropped() {
        return 15.0;
    }

    @Override
    public boolean isAngry() {
        return true;
    }
}

