/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.entity.Player
 */
package vn.giakhanhvn.skysim.features.item.armor;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import org.bukkit.entity.Player;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.armor.ArmorSet;

public interface TickingSet
extends ArmorSet {
    public void tick(Player var1, SItem var2, SItem var3, SItem var4, SItem var5, List<AtomicInteger> var6);
}

