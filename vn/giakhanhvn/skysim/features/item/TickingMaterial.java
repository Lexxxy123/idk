/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item;

import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.SItem;

public interface TickingMaterial
extends MaterialFunction {
    default public void tick(SItem item, Player owner) {
    }

    default public long getInterval() {
        return 2L;
    }
}

