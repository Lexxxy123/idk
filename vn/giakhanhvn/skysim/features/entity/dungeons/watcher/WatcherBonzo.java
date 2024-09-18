/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  me.libraryaddict.disguise.disguisetypes.PlayerDisguise
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityLiving
 *  net.minecraft.server.v1_8_R3.EntityZombie
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutAnimation
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport
 *  org.bukkit.Bukkit
 *  org.bukkit.Color
 *  org.bukkit.FireworkEffect
 *  org.bukkit.FireworkEffect$Builder
 *  org.bukkit.FireworkEffect$Type
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.features.entity.dungeons.watcher;

import com.google.common.util.concurrent.AtomicDouble;
import java.util.Random;
import me.libraryaddict.disguise.disguisetypes.PlayerDisguise;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.EntityZombie;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutAnimation;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftLivingEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftZombie;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityEquipment;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.EnumWatcherType;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.HeadsOnWall;
import vn.giakhanhvn.skysim.features.entity.zombie.BaseZombie;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.EntityManager;
import vn.giakhanhvn.skysim.util.SSU;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;

public class WatcherBonzo
extends BaseZombie {
    private ArmorStand tb;
    private boolean barrCD = true;
    private String[] bozoCringe = new String[]{"Cringe.", "Lame.", "Why are you running?", "Leave me alone!", "Oh noes! You got me! Whatever will I do?", "OUCH!", "Stop.", "Hacker!"};

    @Override
    public String getEntityName() {
        return Sputnik.trans("&4&lMaster Bonzo");
    }

    @Override
    public double getEntityMaxHealth() {
        return 9.0E8;
    }

    @Override
    public double getDamageDealt() {
        return 5800000.0;
    }

    @Override
    public void onSpawn(final LivingEntity entity, SEntity sEntity) {
        HeadsOnWall h2 = new HeadsOnWall(EnumWatcherType.BONZO);
        PlayerDisguise p2 = Sputnik.applyPacketNPC((org.bukkit.entity.Entity)entity, h2.value, h2.signature, true);
        EntityManager.DEFENSE_PERCENTAGE.put((org.bukkit.entity.Entity)entity, 85);
        entity.setMetadata("SlayerBoss", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        entity.setMetadata("LD", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        entity.setMetadata("WATCHER_E", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
        p2.setReplaceSounds(true);
        this.tb = Sputnik.spawnDialougeBox((org.bukkit.entity.Entity)entity, 2.2);
        this.sd("I'm back baby!", 10, 50, true);
        SUtil.delay(() -> {
            this.barrCD = false;
        }, 250L);
        new BukkitRunnable(){

            public void run() {
                if (entity.isDead()) {
                    WatcherBonzo.this.sd("Bruh, just you wait...", 0, 40, true);
                    this.cancel();
                    return;
                }
                if (!WatcherBonzo.this.barrCD && SUtil.random(0, 30) <= 5 && ((CraftZombie)entity).getTarget() != null) {
                    WatcherBonzo.this.barrCD = true;
                    WatcherBonzo.this.ballonBarrage(entity);
                    SUtil.delay(() -> WatcherBonzo.this.barrCD = false, 300L);
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
        new BukkitRunnable(){

            public void run() {
                if (entity.isDead()) {
                    this.cancel();
                    return;
                }
                if (((CraftZombie)entity).getTarget() != null) {
                    WatcherBonzo.this.sd(WatcherBonzo.this.bozoCringe[SUtil.random(0, WatcherBonzo.this.bozoCringe.length - 1)], 1, 50, true);
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 80L, 80L);
        new BukkitRunnable(){

            public void run() {
                EntityLiving nms = ((CraftLivingEntity)entity).getHandle();
                if (entity.isDead()) {
                    this.cancel();
                    return;
                }
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
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 3L);
    }

    @Override
    public SEntityEquipment getEntityEquipment() {
        return new SEntityEquipment(SItem.of(SMaterial.BONZO_STAFF).getStack(), null, null, null, null);
    }

    @Override
    public void onDamage(SEntity sEntity, org.bukkit.entity.Entity damager, EntityDamageByEntityEvent e2, AtomicDouble damage) {
        LivingEntity en = sEntity.getEntity();
        Vector v2 = new Vector(0, 0, 0);
        SUtil.delay(() -> WatcherBonzo.lambda$onDamage$1((org.bukkit.entity.Entity)en, v2), 1L);
    }

    public void say(String str) {
        if (str == null) {
            this.tb.setCustomNameVisible(false);
            return;
        }
        for (Player p2 : this.tb.getWorld().getPlayers()) {
            p2.sendMessage(Sputnik.trans("&c[BOSS] Bonzo&f: " + str));
        }
        this.tb.setCustomNameVisible(true);
        this.tb.setCustomName(Sputnik.trans("&f&l" + str));
    }

    public void sd(String str, int delay, int timeout, boolean needTo) {
        SUtil.delay(() -> this.say(str), delay);
        if (needTo) {
            SUtil.delay(() -> {
                if (this.tb.getCustomName().contains(str)) {
                    this.say(null);
                }
            }, timeout + delay);
        }
    }

    public void ballonBarrage(final LivingEntity e2) {
        this.sd("SHOOOOOOWWWWWWWW TIMEEEEEEEEEEEE!!!", 1, 50, true);
        new BukkitRunnable(){
            int i = 0;

            public void run() {
                if (e2.isDead() || this.i >= 100) {
                    e2.removePotionEffect(PotionEffectType.SLOW);
                    this.cancel();
                    return;
                }
                ++this.i;
                e2.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 1000, 10));
                Location lc = e2.getLocation();
                lc.setYaw(lc.getYaw() + (float)SUtil.random(0, 360));
                ((CraftZombie)e2).getHandle().setPositionRotation(lc.getX(), lc.getY(), lc.getZ(), lc.getYaw(), lc.getPitch());
                WatcherBonzo.sendHeadRotation((org.bukkit.entity.Entity)e2, lc.getYaw(), lc.getPitch());
                WatcherBonzo.this.launchBaloon(e2);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 2L);
    }

    public static void sendHeadRotation(org.bukkit.entity.Entity e2, float yaw, float pitch) {
        EntityZombie pl = ((CraftZombie)e2).getHandle();
        pl.setLocation(e2.getLocation().getX(), e2.getLocation().getY(), e2.getLocation().getZ(), yaw, pitch);
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport((Entity)pl);
        for (Player p2 : e2.getWorld().getPlayers()) {
            ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
        }
    }

    public void launchBaloon(final LivingEntity player1) {
        player1.getWorld().playSound(player1.getLocation(), Sound.GHAST_MOAN, 1.0f, 2.0f);
        final Location location = player1.getLocation().add(0.0, -0.5, 0.0);
        Vector vecTo = location.getDirection().normalize().multiply(1);
        Location location1 = player1.getLocation();
        Random random = new Random();
        int i2 = random.nextInt(9);
        Color color = Color.RED;
        final ArmorStand stand = (ArmorStand)player1.getWorld().spawn(location.add(player1.getLocation().getDirection().multiply(1)), ArmorStand.class);
        stand.setVisible(false);
        stand.setGravity(false);
        stand.setMarker(true);
        stand.teleport(player1.getEyeLocation().add(vecTo));
        if (i2 == 1) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_1).getStack());
            color = Color.RED;
        }
        if (i2 == 2) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_2).getStack());
            color = Color.ORANGE;
        }
        if (i2 == 3) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_3).getStack());
            color = Color.YELLOW;
        }
        if (i2 == 4) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_4).getStack());
            color = Color.PURPLE;
        }
        if (i2 == 5) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_5).getStack());
            color = Color.BLUE;
        }
        if (i2 == 6) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_6).getStack());
            color = Color.AQUA;
        }
        if (i2 == 7) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_7).getStack());
            color = Color.LIME;
        }
        if (i2 == 8) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_8).getStack());
            color = Color.FUCHSIA;
        }
        if (i2 == 9) {
            stand.setHelmet(SItem.of(SMaterial.BONZO_BALLOON_9).getStack());
            color = Color.GREEN;
        }
        final Color color1 = color;
        final Vector direction = location1.getDirection();
        new BukkitRunnable(){
            double t = 0.0;
            int tick = 0;

            public void run() {
                this.t += 1.0995574287564276;
                ++this.tick;
                float yaw = location.getYaw() + 10.0f;
                if (yaw >= 180.0f) {
                    yaw *= -1.0f;
                }
                location.setYaw(yaw);
                double x2 = direction.getX() * this.t;
                double y2 = direction.getY() * this.t;
                double z2 = direction.getZ() * this.t;
                location.add(x2, y2, z2);
                stand.teleport(location);
                location.subtract(x2, y2, z2);
                if (this.t >= 50.0) {
                    this.cancel();
                    stand.remove();
                }
                Location locof = stand.getLocation();
                locof.setY(locof.getY() + 1.0);
                if (locof.getBlock().getType() != Material.AIR) {
                    stand.remove();
                    FireworkEffect.Builder builder = FireworkEffect.builder();
                    FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BURST).withColor(color1).build();
                    SSU.spawn(stand.getLocation(), effect, new Player[0]);
                    this.cancel();
                }
                for (org.bukkit.entity.Entity en : stand.getNearbyEntities(1.0, 1.0, 1.0)) {
                    if (!(en instanceof Player)) continue;
                    Player p2 = (Player)en;
                    p2.getWorld().playSound(p2.getLocation(), Sound.ITEM_BREAK, 1.0f, 1.0f);
                    User.getUser(p2.getUniqueId()).damage(p2.getMaxHealth() * 30.0 / 100.0, EntityDamageEvent.DamageCause.ENTITY_ATTACK, (org.bukkit.entity.Entity)player1);
                    p2.sendMessage(Sputnik.trans("&4&lMaster Bonzo&7's Balloon hit you for &c" + SUtil.commaify(p2.getMaxHealth() * 20.0 / 100.0) + " &7damage."));
                    p2.damage(1.0E-5);
                    p2.setVelocity(player1.getLocation().toVector().subtract(p2.getLocation().toVector()).normalize().multiply(-1.0).multiply(1.5));
                    FireworkEffect.Builder builder = FireworkEffect.builder();
                    FireworkEffect effect = builder.flicker(false).trail(false).with(FireworkEffect.Type.BURST).withColor(color1).build();
                    SSU.spawn(stand.getLocation(), effect, new Player[0]);
                    stand.remove();
                    this.cancel();
                    break;
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e2) {
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
    public double getXPDropped() {
        return 155.0;
    }

    @Override
    public double getMovementSpeed() {
        return 0.4;
    }

    @Override
    public int mobLevel() {
        return 540;
    }

    private static void lambda$onDamage$1(org.bukkit.entity.Entity en, Vector v2) {
        en.setVelocity(v2);
    }
}

