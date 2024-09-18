/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityFallingBlock
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityVelocity
 *  net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity
 *  net.minecraft.server.v1_8_R3.World
 *  net.minecraft.server.v1_8_R3.WorldServer
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.World
 *  org.bukkit.craftbukkit.v1_8_R3.CraftWorld
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.entity.Player
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.api.block;

import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityFallingBlock;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityVelocity;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntity;
import net.minecraft.server.v1_8_R3.WorldServer;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.util.SUtil;

public class BlockFallAPI {
    public static void sendVelocityBlock(Location loc, Material mat, byte data, World players, Integer delay, Vector vec) {
        WorldServer world = ((CraftWorld)loc.getWorld()).getHandle();
        EntityFallingBlock entityfallingblock = new EntityFallingBlock((net.minecraft.server.v1_8_R3.World)world);
        entityfallingblock.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0.0f, 0.0f);
        PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity((Entity)entityfallingblock, 70, mat.getId() + (data << 12));
        double x2 = vec.getX();
        double y2 = vec.getY();
        double z2 = vec.getZ();
        for (Player player : players.getPlayers()) {
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)packet);
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutEntityVelocity(entityfallingblock.getId(), x2, y2, z2));
        }
        SUtil.delay(() -> BlockFallAPI.removeBlock(entityfallingblock, players), delay.intValue());
    }

    public static void sendBlock(Location loc, Material mat, byte data, World players, Integer delay) {
        WorldServer world = ((CraftWorld)loc.getWorld()).getHandle();
        EntityFallingBlock entityfallingblock = new EntityFallingBlock((net.minecraft.server.v1_8_R3.World)world);
        entityfallingblock.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0.0f, 0.0f);
        PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity((Entity)entityfallingblock, 70, mat.getId() + (data << 12));
        for (Player player : players.getPlayers()) {
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)packet);
        }
        SUtil.delay(() -> BlockFallAPI.removeBlock(entityfallingblock, players), delay.intValue());
    }

    public static void removeBlock(EntityFallingBlock entityfallingblock, World players) {
        if (entityfallingblock == null) {
            return;
        }
        PacketPlayOutEntityDestroy destroy = new PacketPlayOutEntityDestroy(new int[]{entityfallingblock.getId()});
        for (Player player : players.getPlayers()) {
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)destroy);
        }
    }

    public static EntityFallingBlock sendBlockDestroyWithSignal(Location loc, Material mat, byte data, World players) {
        WorldServer world = ((CraftWorld)loc.getWorld()).getHandle();
        EntityFallingBlock entityfallingblock = new EntityFallingBlock((net.minecraft.server.v1_8_R3.World)world);
        entityfallingblock.setLocation(loc.getX(), loc.getY(), loc.getZ(), 0.0f, 0.0f);
        PacketPlayOutSpawnEntity packet = new PacketPlayOutSpawnEntity((Entity)entityfallingblock, 70, mat.getId() + (data << 12));
        for (Player player : players.getPlayers()) {
            ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)packet);
        }
        SUtil.delay(() -> BlockFallAPI.removeBlock(entityfallingblock, players), 300L);
        return entityfallingblock;
    }
}

