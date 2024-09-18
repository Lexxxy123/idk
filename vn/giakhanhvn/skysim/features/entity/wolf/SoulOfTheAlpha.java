/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.ChatColor
 */
package vn.giakhanhvn.skysim.features.entity.wolf;

import java.util.Arrays;
import java.util.List;
import org.bukkit.ChatColor;
import vn.giakhanhvn.skysim.features.entity.EntityDrop;
import vn.giakhanhvn.skysim.features.entity.EntityDropType;
import vn.giakhanhvn.skysim.features.entity.wolf.BaseWolf;
import vn.giakhanhvn.skysim.features.item.SMaterial;

public class SoulOfTheAlpha
extends BaseWolf {
    @Override
    public String getEntityName() {
        return ChatColor.DARK_AQUA + "Soul of the Alpha";
    }

    @Override
    public double getEntityMaxHealth() {
        return 31150.0;
    }

    @Override
    public double getDamageDealt() {
        return 1282.0;
    }

    @Override
    public List<EntityDrop> drops() {
        return Arrays.asList(new EntityDrop(SMaterial.JUNGLE_WOOD, EntityDropType.GUARANTEED, 1.0), new EntityDrop(SMaterial.WEAK_WOLF_CATALYST, EntityDropType.VERY_RARE, 0.005));
    }

    @Override
    public double getXPDropped() {
        return 50.0;
    }

    @Override
    public boolean isAngry() {
        return true;
    }

    @Override
    public int mobLevel() {
        return 55;
    }
}

