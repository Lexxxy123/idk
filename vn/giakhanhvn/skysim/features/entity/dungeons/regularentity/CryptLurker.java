/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.AttributeInstance
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityLiving
 *  net.minecraft.server.v1_8_R3.EntityZombie
 *  net.minecraft.server.v1_8_R3.GenericAttributes
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutAnimation
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport
 *  org.bukkit.Bukkit
 *  org.bukkit.Color
 *  org.bukkit.Effect
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.EulerAngle
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.features.entity.dungeons.regularentity;

import com.google.common.util.concurrent.AtomicDouble;
import net.minecraft.server.v1_8_R3.AttributeInstance;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityZombie;
import net.minecraft.server.v1_8_R3.GenericAttributes;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityEquipment;
import vn.giakhanhvn.skysim.features.entity.zombie.BaseZombie;
import vn.giakhanhvn.skysim.features.entity.zombie.NPCMobs;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.EntityManager;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;

public class CryptLurker
extends BaseZombie
implements NPCMobs {
    private boolean stop = false;

    @Override
    public String getEntityName() {
        return "Crypt Soulstealer";
    }

    @Override
    public double getEntityMaxHealth() {
        return 1.0E8;
    }

    @Override
    public double getDamageDealt() {
        return 900000.0;
    }

    public static ItemStack b(int hexcolor, Material m2) {
        ItemStack stack = SUtil.applyColorToLeatherArmor(new ItemStack(m2), Color.fromRGB((int)hexcolor));
        ItemMeta itemMeta = stack.getItemMeta();
        itemMeta.spigot().setUnbreakable(true);
        stack.setItemMeta(itemMeta);
        return stack;
    }

    @Override
    public void onSpawn(final LivingEntity entity, SEntity sEntity) {
        ((CraftZombie)entity).setBaby(false);
        AttributeInstance followRange = ((CraftLivingEntity)entity).getHandle().getAttributeInstance(GenericAttributes.FOLLOW_RANGE);
        followRange.setValue(40.0);
        EntityManager.DEFENSE_PERCENTAGE.put((org.bukkit.entity.Entity)entity, 60);
        entity.setMetadata("LD", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        entity.setMetadata("DungeonMobs", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        entity.setMetadata("SlayerBoss", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        new BukkitRunnable(){

            public void run() {
                if (entity.isDead()) {
                    Sputnik.zero((org.bukkit.entity.Entity)entity);
                    this.cancel();
                    return;
                }
                if (((CraftZombie)entity).getTarget() != null && !CryptLurker.this.stop && ((CraftZombie)entity).getTarget().getLocation().distance(entity.getLocation()) <= 10.0) {
                    CryptLurker.this.throwThickAssBone((org.bukkit.entity.Entity)entity);
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        ((CraftPlayer)players).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutAnimation((Entity)((CraftLivingEntity)entity).getHandle(), 0));
                    }
                    CryptLurker.this.stop = true;
                    entity.getEquipment().setItemInHand(null);
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 40L, 20L);
        new BukkitRunnable(){

            public void run() {
                EntityLiving nms = ((CraftLivingEntity)entity).getHandle();
                if (entity.isDead()) {
                    this.cancel();
                    return;
                }
                CraftLivingEntity target1 = ((CraftZombie)entity).getTarget();
                for (org.bukkit.entity.Entity entities : entity.getWorld().getNearbyEntities(entity.getLocation().add(entity.getLocation().getDirection().multiply(1.0)), 1.5, 1.5, 1.5)) {
                    Player target;
                    if (!(entities instanceof Player) || (target = (Player)entities).getGameMode() == GameMode.CREATIVE || target.getGameMode() == GameMode.SPECTATOR || target.hasMetadata("NPC") || target.getNoDamageTicks() == 7 || SUtil.random(0, 10) > 8) continue;
                    entity.teleport(entity.getLocation().setDirection(target.getLocation().subtract(entities.getLocation()).toVector()));
                    for (Player players : Bukkit.getOnlinePlayers()) {
                        ((CraftPlayer)players).getHandle().playerConnection.sendPacket((Packet)new PacketPlayOutAnimation((Entity)((CraftLivingEntity)entity).getHandle(), 0));
                    }
                    nms.r((Entity)((CraftPlayer)target).getHandle());
                    break;
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 2L);
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(new ItemStack(Material.BONE), null, null, null, null);
    }

    @Override
    public void onDeath(SEntity sEntity, org.bukkit.entity.Entity killed, org.bukkit.entity.Entity damager) {
    }

    @Override
    public boolean isBaby() {
        return false;
    }

    @Override
    public boolean hasNameTag() {
        return false;
    }

    @Override
    public boolean isVillager() {
        return false;
    }

    @Override
    public void onDamage(SEntity sEntity, org.bukkit.entity.Entity damager, EntityDamageByEntityEvent e2, AtomicDouble damage) {
    }

    @Override
    public double getXPDropped() {
        return 56.0;
    }

    @Override
    public double getMovementSpeed() {
        return 0.25;
    }

    public static void sendHeadRotation(org.bukkit.entity.Entity e2, float yaw, float pitch) {
        EntityZombie pl = ((CraftZombie)e2).getHandle();
        pl.setLocation(e2.getLocation().getX(), e2.getLocation().getY(), e2.getLocation().getZ(), yaw, pitch);
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport((Entity)pl);
        Sputnik.sendPacket(e2.getWorld(), (Packet)packet);
    }

    public void throwThickAssBone(final org.bukkit.entity.Entity e2) {
        final Vector throwVec = e2.getLocation().add(e2.getLocation().getDirection().multiply(10)).toVector().subtract(e2.getLocation().toVector()).normalize().multiply(1.2);
        Location throwLoc = e2.getLocation().add(0.0, 0.5, 0.0);
        final ArmorStand armorStand1 = (ArmorStand)e2.getWorld().spawnEntity(throwLoc, EntityType.ARMOR_STAND);
        armorStand1.getEquipment().setItemInHand(SItem.of(SMaterial.BONE).getStack());
        armorStand1.setGravity(false);
        armorStand1.setVisible(false);
        armorStand1.setMarker(true);
        Vector teleportTo = e2.getLocation().getDirection().normalize().multiply(1);
        final Vector[] previousVector = new Vector[]{throwVec};
        new BukkitRunnable(){
            private int run = -1;

            public void run() {
                boolean back;
                int angle;
                Vector newVector;
                int ran = 0;
                int i2 = 0;
                int num = 90;
                Object loc = null;
                ++this.run;
                if (this.run > 100) {
                    this.cancel();
                    return;
                }
                Location locof = armorStand1.getLocation();
                locof.setY(locof.getY() + 1.0);
                if (locof.getBlock().getType() != Material.AIR) {
                    armorStand1.remove();
                    this.cancel();
                    return;
                }
                double xPos = armorStand1.getRightArmPose().getX();
                armorStand1.setRightArmPose(new EulerAngle(xPos + 0.7, 0.0, 0.0));
                previousVector[0] = newVector = new Vector(throwVec.getX(), previousVector[0].getY() - 0.03, throwVec.getZ());
                armorStand1.setVelocity(newVector);
                if (i2 < 13) {
                    angle = i2 * 20 + num;
                    back = false;
                } else {
                    angle = i2 * 20 - num;
                    back = true;
                }
                if (locof.getBlock().getType() != Material.AIR && locof.getBlock().getType() != Material.WATER) {
                    armorStand1.remove();
                    this.cancel();
                    return;
                }
                for (int j2 = 0; j2 < 20; ++j2) {
                    armorStand1.getWorld().spigot().playEffect(armorStand1.getLocation().clone().add(0.0, 1.75, 0.0), Effect.CRIT, 0, 1, (float)SUtil.random(-0.5, 0.5), (float)SUtil.random(0.0, 0.5), (float)SUtil.random(-0.5, 0.5), 0.0f, 1, 20);
                }
                for (org.bukkit.entity.Entity en : armorStand1.getNearbyEntities(1.0, 1.0, 1.0)) {
                    if (!(en instanceof Player)) continue;
                    Player p2 = (Player)en;
                    p2.getWorld().playSound(p2.getLocation(), Sound.ITEM_BREAK, 1.0f, 1.0f);
                    User.getUser(p2.getUniqueId()).damage(p2.getMaxHealth() * 20.0 / 100.0, EntityDamageEvent.DamageCause.ENTITY_ATTACK, e2);
                    p2.damage(1.0E-5);
                    armorStand1.remove();
                    this.cancel();
                    break;
                }
            }

            public synchronized void cancel() throws IllegalStateException {
                super.cancel();
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 2L);
    }
}

