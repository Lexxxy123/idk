/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityLiving
 *  net.minecraft.server.v1_8_R3.EntityWither
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityMetadata
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport
 *  net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving
 *  net.minecraft.server.v1_8_R3.World
 *  org.bukkit.Location
 *  org.bukkit.craftbukkit.v1_8_R3.CraftWorld
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.util;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityWither;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityMetadata;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import net.minecraft.server.v1_8_R3.World;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;

public class BossBar
extends BukkitRunnable {
    private String title;
    private HashMap<Player, EntityWither> withers = new HashMap();

    public BossBar(String title) {
        this.title = title;
        this.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
    }

    public void addPlayer(Player p2) {
        EntityWither wither = new EntityWither((World)((CraftWorld)p2.getWorld()).getHandle());
        Location l2 = this.getWitherLocation(p2.getLocation());
        wither.setCustomName(this.title);
        wither.setInvisible(true);
        wither.r(877);
        wither.setLocation(l2.getX(), l2.getY(), l2.getZ(), 0.0f, 0.0f);
        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving)wither);
        ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
        this.withers.put(p2, wither);
    }

    public void removePlayer(Player p2) {
        EntityWither wither = this.withers.remove(p2);
        PacketPlayOutEntityDestroy packet = new PacketPlayOutEntityDestroy(new int[]{wither.getId()});
        ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
    }

    public void setTitle(String title) {
        this.title = title;
        for (Map.Entry<Player, EntityWither> entry : this.withers.entrySet()) {
            EntityWither wither = entry.getValue();
            wither.setCustomName(title);
            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(wither.getId(), wither.getDataWatcher(), true);
            ((CraftPlayer)entry.getKey()).getHandle().playerConnection.sendPacket((Packet)packet);
        }
    }

    public void setProgress(double progress) {
        for (Map.Entry<Player, EntityWither> entry : this.withers.entrySet()) {
            EntityWither wither = entry.getValue();
            wither.setHealth((float)(progress * (double)wither.getMaxHealth()));
            PacketPlayOutEntityMetadata packet = new PacketPlayOutEntityMetadata(wither.getId(), wither.getDataWatcher(), true);
            ((CraftPlayer)entry.getKey()).getHandle().playerConnection.sendPacket((Packet)packet);
        }
    }

    public Location getWitherLocation(Location l2) {
        return l2.add(l2.getDirection().multiply(20));
    }

    public void run() {
        for (Map.Entry<Player, EntityWither> en : this.withers.entrySet()) {
            EntityWither wither = en.getValue();
            Location l2 = this.getWitherLocation(en.getKey().getLocation());
            wither.setLocation(l2.getX(), l2.getY(), l2.getZ(), 0.0f, 0.0f);
            PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport((Entity)wither);
            ((CraftPlayer)en.getKey()).getHandle().playerConnection.sendPacket((Packet)packet);
        }
    }
}

