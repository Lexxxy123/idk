/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.block.Block
 *  org.bukkit.block.BlockState
 *  org.bukkit.plugin.Plugin
 */
package vn.giakhanhvn.skysim.features.entity;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockState;
import org.bukkit.plugin.Plugin;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.SEntity;

public final class StaticDragonManager {
    public static boolean ACTIVE = false;
    public static Map<UUID, List<Location>> EYES = new HashMap<UUID, List<Location>>();
    public static SEntity DRAGON = null;

    public static void endFight() {
        if (DRAGON == null) {
            return;
        }
        ACTIVE = false;
        for (List<Location> locations : EYES.values()) {
            for (Location location : locations) {
                Block b2 = location.getBlock();
                BlockState s2 = b2.getState();
                s2.setRawData((byte)0);
                s2.update();
                b2.removeMetadata("placer", (Plugin)SkySimEngine.getPlugin());
            }
        }
        EYES.clear();
        DRAGON = null;
    }
}

