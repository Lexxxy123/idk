/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.event.player.PlayerFishEvent
 */
package vn.giakhanhvn.skysim.features.item;

import org.bukkit.event.player.PlayerFishEvent;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.SItem;

public interface FishingRodFunction
extends MaterialFunction {
    public void onFish(SItem var1, PlayerFishEvent var2);
}

