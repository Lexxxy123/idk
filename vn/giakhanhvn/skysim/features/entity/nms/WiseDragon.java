/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.World
 *  org.bukkit.Bukkit
 *  org.bukkit.craftbukkit.v1_8_R3.CraftWorld
 */
package vn.giakhanhvn.skysim.features.entity.nms;

import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import vn.giakhanhvn.skysim.features.entity.nms.Dragon;

public class WiseDragon
extends Dragon {
    public WiseDragon(World world) {
        super(world, 1.4, Dragon.DEFAULT_DAMAGE_DEGREE_RANGE, 200L);
    }

    public WiseDragon() {
        this((World)((CraftWorld)Bukkit.getWorlds().get(0)).getHandle());
    }

    @Override
    public String getEntityName() {
        return "Wise Dragon";
    }

    @Override
    public double getEntityMaxHealth() {
        return 9000000.0;
    }

    @Override
    public double getDamageDealt() {
        return 1200.0;
    }
}

