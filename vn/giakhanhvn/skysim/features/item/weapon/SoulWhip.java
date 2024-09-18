/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.EnumParticle
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Damageable
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.ExperienceOrb
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Villager
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.features.item.weapon;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.ExperienceOrb;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.item.Ability;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.MaterialFunction;
import vn.giakhanhvn.skysim.features.item.Ownable;
import vn.giakhanhvn.skysim.features.item.Rarity;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SpecificItemType;
import vn.giakhanhvn.skysim.features.item.ToolStatistics;
import vn.giakhanhvn.skysim.listener.PlayerListener;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.FerocityCalculation;
import vn.giakhanhvn.skysim.util.Sputnik;

public class SoulWhip
implements ToolStatistics,
MaterialFunction,
Ability,
Ownable {
    public static final Map<UUID, Boolean> cd = new HashMap<UUID, Boolean>();
    public static final Map<Integer, Boolean> hit = new HashMap<Integer, Boolean>();

    @Override
    public String getAbilityName() {
        return "Flay";
    }

    @Override
    public String getAbilityDescription() {
        return "Flay your whip in an arc, dealing your melee damage to all enemies in its path";
    }

    @Override
    public int getAbilityCooldownTicks() {
        return 0;
    }

    @Override
    public void onAbilityUse(final Player player, final SItem sItem) {
        final Player p2 = player;
        if (!cd.containsKey(p2.getUniqueId())) {
            cd.put(p2.getUniqueId(), true);
            final Vector v2 = p2.getLocation().getDirection().normalize().multiply(0.15);
            final Location loc = p2.getLocation().clone().add(0.0, 1.55, 0.0);
            final World world = loc.getWorld();
            p2.playSound(loc, Sound.CAT_HISS, 0.2f, 10.0f);
            new BukkitRunnable(){
                int count = 0;

                public void run() {
                    for (final Entity e2 : world.getNearbyEntities(loc, 1.0, 1.0, 1.0)) {
                        if (!(e2 instanceof LivingEntity) || e2 instanceof Player || e2 instanceof ExperienceOrb || e2 instanceof ArmorStand || e2 instanceof Villager || e2.isDead() || e2.hasMetadata("NPC") || e2.hasMetadata("GiantSword") || hit.containsKey(e2.getEntityId())) continue;
                        hit.put(e2.getEntityId(), true);
                        new BukkitRunnable(){

                            public void run() {
                                User user = User.getUser(player.getUniqueId());
                                Object[] atp = Sputnik.calculateDamage(player, player, sItem.getStack(), (LivingEntity)e2, false);
                                double finalDamage1 = ((Float)atp[0]).floatValue();
                                PlayerListener.spawnDamageInd(e2, ((Float)atp[2]).floatValue(), (Boolean)atp[1]);
                                FerocityCalculation.activeFerocityTimes(player, (LivingEntity)e2, (int)finalDamage1, (Boolean)atp[1]);
                                user.damageEntity((Damageable)e2, finalDamage1);
                            }
                        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 0L);
                        new BukkitRunnable(){

                            public void run() {
                                hit.remove(e2.getEntityId());
                            }
                        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 10L);
                    }
                    for (int i2 = 0; i2 < 10; ++i2) {
                        loc.add(v2);
                        loc.setY(loc.getY() + (double)(50 - this.count) / 1000.0);
                        Object packetx = null;
                        PacketPlayOutWorldParticles packet = this.count % 2 == 0 ? new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float)loc.getX(), (float)loc.getY(), (float)loc.getZ(), 3.9215687E-5f, 0.0f, 0.0f, 1.0f, 0, new int[0]) : new PacketPlayOutWorldParticles(EnumParticle.REDSTONE, true, (float)loc.getX(), (float)loc.getY(), (float)loc.getZ(), -0.9f, 0.2f, 0.2f, 1.0f, 0, new int[0]);
                        ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
                        for (Entity player2 : p2.getNearbyEntities(10.0, 10.0, 10.0)) {
                            if (!(player2 instanceof Player)) continue;
                            ((CraftPlayer)player2).getHandle().playerConnection.sendPacket((Packet)packet);
                        }
                        ++this.count;
                    }
                    if (this.count >= 100) {
                        this.cancel();
                    }
                    if (world.getBlockAt((int)(loc.getX() - 0.5), loc.getBlockY(), (int)(loc.getZ() - 0.5)).getType() != Material.AIR) {
                        this.cancel();
                    }
                }
            }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 1L, 1L);
            new BukkitRunnable(){

                public void run() {
                    cd.remove(p2.getUniqueId());
                }
            }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 10L);
        }
    }

    @Override
    public int getManaCost() {
        return 0;
    }

    @Override
    public String getDisplayName() {
        return "Soul Whip";
    }

    @Override
    public int getBaseDamage() {
        return 145;
    }

    @Override
    public double getBaseStrength() {
        return 175.0;
    }

    @Override
    public boolean displayUsage() {
        return false;
    }

    @Override
    public boolean requirementsUse(Player player, SItem sItem) {
        return User.getUser(player.getUniqueId()).getBCollection() < 25L;
    }

    @Override
    public String getAbilityReq() {
        return "&cYou do not have requirement to use this item!\n&cYou need at least &525 Sadan Kills &cto use it!";
    }

    @Override
    public Rarity getRarity() {
        return Rarity.LEGENDARY;
    }

    @Override
    public GenericItemType getType() {
        return GenericItemType.WEAPON;
    }

    @Override
    public SpecificItemType getSpecificType() {
        return SpecificItemType.SWORD;
    }

    @Override
    public NBTTagCompound getData() {
        return Ownable.super.getData();
    }
}

