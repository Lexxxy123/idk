/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityLiving
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutAnimation
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport
 *  net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving
 *  org.bukkit.Bukkit
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitTask
 */
package vn.giakhanhvn.skysim.util;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import org.bukkit.Bukkit;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitTask;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.user.User;

public class PacketEntity {
    Entity entity;
    List<Player> players;
    Packet spawn;
    List<Packet> spawnPackets;
    BukkitTask tickTask;
    String permission;
    static final int showRadius = 50;
    public static List<PacketEntity> managers = new ArrayList<PacketEntity>();
    double x;
    double y;
    double z;

    public PacketEntity(Entity e2) {
        this.entity = e2;
        this.players = new ArrayList<Player>();
        this.updateSpawnPacket();
        managers.add(this);
        this.tickTask = Bukkit.getScheduler().runTaskTimer((Plugin)SkySimEngine.getPlugin(), () -> this.tick(), 1L, 5L);
    }

    public void setShowPermission(String permission) {
        this.permission = permission;
    }

    public void addSpawnPacket(Packet packet) {
        if (this.spawnPackets == null) {
            this.spawnPackets = new ArrayList<Packet>();
        }
        this.spawnPackets.add(packet);
        this.sendCustomPacket(packet);
    }

    public void removeSpawnPacket(Packet packet) {
        if (this.spawnPackets.contains(packet)) {
            this.spawnPackets.remove(packet);
        }
    }

    public boolean updateLocation() {
        if (this.players.isEmpty()) {
            return false;
        }
        if (this.x == this.entity.locX && this.y == this.entity.locY && this.z == this.entity.locZ) {
            return true;
        }
        this.x = this.entity.locX;
        this.y = this.entity.locY;
        this.z = this.entity.locZ;
        PacketPlayOutEntityTeleport teleport = new PacketPlayOutEntityTeleport((Entity)((EntityLiving)this.entity));
        for (int i2 = 0; i2 < this.players.size(); ++i2) {
            Player next = this.players.get(i2);
            ((CraftPlayer)next).getHandle().playerConnection.sendPacket((Packet)teleport);
        }
        return true;
    }

    public boolean playAnimation(int anim) {
        if (this.players.isEmpty()) {
            return false;
        }
        PacketPlayOutAnimation teleport = new PacketPlayOutAnimation((Entity)((EntityLiving)this.entity), anim);
        for (int i2 = 0; i2 < this.players.size(); ++i2) {
            Player next = this.players.get(i2);
            ((CraftPlayer)next).getHandle().playerConnection.sendPacket((Packet)teleport);
        }
        return true;
    }

    public void tick() {
        ArrayList<Player> newPlayers = new ArrayList<Player>();
        this.updateSpawnPacket();
        for (Player p2 : Bukkit.getOnlinePlayers()) {
            if (!p2.getWorld().equals(this.entity.getBukkitEntity().getWorld()) || !(p2.getLocation().distance(this.entity.getBukkitEntity().getLocation()) < 50.0)) continue;
            if (this.players.contains(p2)) {
                if (this.permission != null && !User.getUser(p2.getUniqueId()).hasPermission(this.permission)) continue;
                this.players.remove(p2);
                newPlayers.add(p2);
                continue;
            }
            if (!this.sendSpawnPacket(p2)) continue;
            newPlayers.add(p2);
        }
        for (Player p2 : this.players) {
            this.sendDestroyPacket(p2);
        }
        this.players = newPlayers;
    }

    public void destroy() {
        this.hide();
        this.tickTask.cancel();
        if (managers.contains(this)) {
            managers.remove(this);
        }
    }

    public void hide() {
        for (int i2 = 0; i2 < this.players.size(); ++i2) {
            Player next = this.players.get(i2);
            this.sendDestroyPacket(next);
        }
    }

    protected void updateSpawnPacket() {
        this.spawn = new PacketPlayOutSpawnEntityLiving((EntityLiving)this.entity);
    }

    public List<Player> getPlayers() {
        return this.players;
    }

    public void spawn() {
        for (Player next : this.players) {
            this.sendSpawnPacket(next);
        }
    }

    public void sendCustomPacket(Packet packet) {
        for (Player p2 : this.players) {
            ((CraftPlayer)p2).getHandle().playerConnection.sendPacket(packet);
        }
    }

    protected boolean sendSpawnPacket(Player player) {
        if (this.permission != null && !User.getUser(player.getUniqueId()).hasPermission(this.permission)) {
            this.players.remove(player);
            return false;
        }
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket(this.spawn);
        if (this.spawnPackets != null) {
            for (Packet packet : this.spawnPackets) {
                ((CraftPlayer)player).getHandle().playerConnection.sendPacket(packet);
            }
        }
        return true;
    }

    protected void sendDestroyPacket(Player player) {
        ((CraftPlayer)player).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutEntityDestroy(new int[]{this.entity.getId()}));
    }

    public static void removePlayer(Player player) {
        for (PacketEntity manager : managers) {
            if (!manager.players.contains(player)) continue;
            manager.players.remove(player);
        }
    }
}

