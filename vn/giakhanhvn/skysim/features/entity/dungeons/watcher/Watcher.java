/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 *  com.mojang.authlib.properties.Property
 *  net.md_5.bungee.api.ChatColor
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityArmorStand
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport
 *  org.bukkit.Effect
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftArmorStand
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Listener
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.meta.ItemMeta
 *  org.bukkit.inventory.meta.SkullMeta
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.EulerAngle
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.features.entity.dungeons.watcher;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityTeleport;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftArmorStand;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.EulerAngle;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.Cuboid;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.EnumWatcherType;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.GlobalBossBar;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.HeadsOnWall;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;

public class Watcher
implements Listener {
    private static final Map<World, Watcher> WATCHER_CACHE = new HashMap<World, Watcher>();
    private World arg0;
    private boolean a;
    private Location arg1;
    private Location arg2;
    public Location watcher;
    public ArmorStand ewatcher;
    public ArmorStand econv;
    public ArmorStand wfe2;
    public ArmorStand wfe1;
    public float floorY;
    public int mobSpawned;
    public int perRunMS;
    private boolean wfe1_shoot;
    private boolean wfe2_shoot;
    public boolean isResting;
    private boolean firstRun;
    public int currentMobsCount = 15;
    public boolean welcomeParticles;
    private List<HeadsOnWall> how = new ArrayList<HeadsOnWall>();
    private List<String> spawnedMob = new ArrayList<String>();
    public List<Location> P1Heads = new ArrayList<Location>();
    public String[] mobSummonConvs = new String[]{"You'll do", "Let's see how you can handle this", "Go, fight!", "Go and live again!", "Hmm... This one!", "Oops. Wasn't meant to revive that one.", "This one looks like a fighter."};
    public String[] mobDeathConvs = new String[]{"That one was weak anyway.", "I'm Impressed.", "Not bad.", "Aw, I liked that one.", "Very nice."};
    public String[] sneakyPeaky = new String[]{"We're always watching. Come down from there!", "Don't try to sneak anything past my Watchful Eyes. They see you up there!", "My Watchful Eyes see you up there! Come down and fight!"};
    public String[] watcherAttack = new String[]{"I am not your enemy", "Stop Attacking me", "Don't make me zap you", "Ouch, just kidding..."};

    public Watcher(Location pos1, Location pos2, int floorY) {
        this.arg0 = pos1.getWorld();
        this.arg1 = pos1;
        this.arg2 = pos2;
        this.floorY = floorY;
        this.a = false;
    }

    public static Watcher getWatcher(World world) {
        if (WATCHER_CACHE.containsKey(world)) {
            return WATCHER_CACHE.get(world);
        }
        return null;
    }

    public void intitize() {
        Cuboid cb = new Cuboid(this.arg0, this.arg1.getBlockX(), this.arg1.getBlockY(), this.arg1.getBlockZ(), this.arg2.getBlockX(), this.arg2.getBlockY(), this.arg2.getBlockZ());
        for (Block b2 : cb.getBlocks()) {
            if (b2.getType() == Material.BEACON) {
                this.watcher = b2.getLocation().add(0.5, 0.0, 0.5);
                continue;
            }
            if (b2.getType() != Material.WOOL || b2.getData() != 4) continue;
            this.P1Heads.add(b2.getLocation().add(0.5, 0.0, 0.5));
        }
        this.apt();
        WATCHER_CACHE.put(this.arg0, this);
        this.a = true;
        if (this.isIntitized()) {
            int i2 = 0;
            for (Location loc : this.P1Heads) {
                this.placeHead(loc, i2);
                ++i2;
            }
        }
        this.spawnWatcher(this.watcher);
        final GlobalBossBar bb2 = new GlobalBossBar(Watcher.trans("&c&lThe Watcher"), this.watcher.getWorld());
        for (Player p2 : this.watcher.getWorld().getPlayers()) {
            bb2.addPlayer(p2);
        }
        bb2.setProgress(this.currentMobsCount / 15);
        new BukkitRunnable(){

            public void run() {
                if (Watcher.this.ewatcher.isDead()) {
                    ArrayList<Player> plist = new ArrayList<Player>();
                    for (Player p2 : bb2.players) {
                        plist.add(p2);
                    }
                    plist.forEach(pl -> bb2.removePlayer((Player)pl));
                    bb2.setProgress(0.0);
                    bb2.cancel();
                    this.cancel();
                    return;
                }
                if (Watcher.this.currentMobsCount > 0) {
                    bb2.setProgress((double)Watcher.this.currentMobsCount / 15.0);
                } else {
                    bb2.setProgress(1.0E-5);
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
    }

    public static double random(double min, double max) {
        return Math.random() * (max - min) + min;
    }

    private void apt() {
        for (EnumWatcherType ew : EnumWatcherType.values()) {
            if (ew.equals((Object)EnumWatcherType.PLAYER)) continue;
            this.how.add(new HeadsOnWall(ew));
        }
        for (Player p2 : this.arg0.getPlayers()) {
            HeadsOnWall a2 = new HeadsOnWall(EnumWatcherType.PLAYER);
            a2.skullTexture = p2.getName();
            a2.arg0 = true;
            this.how.add(a2);
        }
        EnumWatcherType[] rp = EnumWatcherType.values();
        ArrayList<EnumWatcherType> ewt = new ArrayList<EnumWatcherType>(Arrays.asList(rp));
        ewt.removeIf(r2 -> r2 == EnumWatcherType.BONZO || r2 == EnumWatcherType.LIVID || r2 == EnumWatcherType.PLAYER);
        Collections.shuffle(ewt);
        for (EnumWatcherType ew : ewt) {
            this.how.add(new HeadsOnWall(ew));
            if (this.how.size() != 30) continue;
        }
        Collections.shuffle(this.how);
    }

    public void cleanUp() {
        WATCHER_CACHE.remove(this.arg0);
    }

    public boolean isIntitized() {
        return this.a;
    }

    public static float getYaw(Location loc) {
        Location newA = loc.getBlock().getLocation().add(0.5, 0.0, 0.5);
        newA.add(0.0, 1.7, 0.0);
        int rot = 0;
        for (int i2 = 0; i2 < 4; ++i2) {
            newA.setYaw((float)(rot += 90));
            Location newLoc = newA.clone().add(newA.getDirection().normalize().multiply(2));
            if (newLoc.getBlock().getType() != Material.AIR) continue;
            return rot;
        }
        return 0.0f;
    }

    public void placeHead(Location l2, int index) {
        index = Math.min(29, index);
        l2.getBlock().setType(Material.AIR);
        Location sloc = l2.add(0.0, -1.25, 0.0);
        sloc.setYaw(Watcher.getYaw(sloc));
        ArmorStand stand = (ArmorStand)l2.getWorld().spawn(sloc, ArmorStand.class);
        stand.setMetadata("WATCHER_ENTITY", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)0));
        stand.setMetadata("TYPE", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)this.how.get((int)index).stype));
        stand.setCustomNameVisible(false);
        if (!this.how.get((int)index).arg0) {
            stand.getEquipment().setHelmet(Watcher.getSkull(this.how.get((int)index).skullTexture));
        } else {
            stand.getEquipment().setHelmet(Watcher.getSkullStack(this.how.get((int)index).skullTexture));
        }
        stand.setGravity(false);
        stand.setVisible(false);
    }

    public void returnWatcher(final org.bukkit.entity.Entity e2) {
        final Watcher w2 = Watcher.getWatcher(e2.getWorld());
        new BukkitRunnable(){

            public void run() {
                if (e2.isDead()) {
                    this.cancel();
                    return;
                }
                if (e2.getWorld().getNearbyEntities(w2.watcher.clone().add(0.0, -1.5, 0.0), 0.1, 0.1, 0.1).contains(e2)) {
                    Watcher.this.isResting = true;
                    if (Watcher.this.mobSpawned < 15) {
                        SUtil.delay(() -> {
                            if (e2.isDead() || Watcher.this.mobSpawned >= 15) {
                                return;
                            }
                            Watcher.this.moveWatcher(e2, false);
                        }, 100L);
                    }
                    if (Watcher.random(1, 7) == 2) {
                        Watcher.this.sd(Watcher.this.mobSummonConvs[Watcher.random(0, Watcher.this.mobSummonConvs.length - 1)], 10, 50, true);
                    }
                    Watcher.this.perRunMS = 0;
                    this.cancel();
                    return;
                }
                Location r2 = e2.getLocation().setDirection(w2.watcher.clone().add(0.0, -1.5, 0.0).toVector().subtract(e2.getLocation().toVector()));
                e2.teleport(r2);
                Watcher.sendHeadRotation(e2, r2.getYaw(), r2.getPitch());
                double x2 = 0.0;
                double y2 = 0.0;
                double z2 = 0.0;
                x2 = Math.toRadians(r2.getPitch());
                ((ArmorStand)e2).setHeadPose(new EulerAngle(x2, y2, z2));
                e2.teleport(e2.getLocation().add(e2.getLocation().getDirection().multiply(0.5)));
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
    }

    public ArmorStand findArmorStand(Location l2) {
        for (org.bukkit.entity.Entity e2 : l2.getWorld().getNearbyEntities(l2, (double)0.1f, (double)0.1f, (double)0.1f)) {
            if (!(e2 instanceof ArmorStand) || !e2.hasMetadata("WATCHER_ENTITY")) continue;
            return (ArmorStand)e2;
        }
        return null;
    }

    public void moveWatcher(final org.bukkit.entity.Entity e2, boolean firstMove) {
        this.firstRun = firstMove;
        this.isResting = false;
        Watcher w2 = Watcher.getWatcher(e2.getWorld());
        int inx = Watcher.random(0, w2.P1Heads.size() - 1);
        Location tpTo = null;
        if (this.firstRun) {
            this.firstRun = false;
            ArrayList<Location> removedLoc = new ArrayList<Location>();
            for (Location l2 : w2.P1Heads) {
                if (!((MetadataValue)this.findArmorStand(l2).getMetadata("TYPE").get(0)).asString().contains("TEAMMATE")) continue;
                removedLoc.add(l2);
            }
            w2.P1Heads.removeAll(removedLoc);
            for (Location l2 : w2.P1Heads) {
                String lb = ((MetadataValue)this.findArmorStand(l2).getMetadata("TYPE").get(0)).asString();
                if (!lb.contains("BONZO") && !lb.contains("LIVID")) continue;
                tpTo = l2;
                w2.P1Heads.remove(l2);
                break;
            }
        } else {
            tpTo = w2.P1Heads.get(inx);
            w2.P1Heads.remove(inx);
            while (this.spawnedMob.contains(((MetadataValue)this.findArmorStand(tpTo).getMetadata("TYPE").get(0)).asString())) {
                int inxe = Watcher.random(0, w2.P1Heads.size() - 1);
                tpTo = w2.P1Heads.get(inxe);
                w2.P1Heads.remove(inxe);
            }
        }
        this.spawnedMob.add(((MetadataValue)this.findArmorStand(tpTo).getMetadata("TYPE").get(0)).asString());
        final Location tpToC = tpTo;
        if (this.perRunMS < 1) {
            this.sd(this.mobSummonConvs[Watcher.random(0, this.mobSummonConvs.length - 1)], 10, 50, true);
        }
        new BukkitRunnable(){

            public void run() {
                if (e2.isDead()) {
                    this.cancel();
                    return;
                }
                if (e2.getWorld().getNearbyEntities(tpToC, 0.6, 0.6, 0.6).contains(e2)) {
                    ArmorStand st = Watcher.this.findArmorStand(tpToC);
                    st.getEquipment().setHelmet(null);
                    st.setCustomNameVisible(false);
                    Watcher.this.playHeadSpawning((org.bukkit.entity.Entity)st);
                    SUtil.delay(() -> {
                        if (Watcher.this.mobSpawned >= 15) {
                            Watcher.this.sd("That will be enough for now.", 20, 50, true);
                        }
                        if (Watcher.this.perRunMS >= 3 || Watcher.this.mobSpawned >= 15) {
                            Watcher.this.returnWatcher(e2);
                        } else {
                            Watcher.this.moveWatcher(e2, false);
                        }
                    }, 15L);
                    ++Watcher.this.perRunMS;
                    ++Watcher.this.mobSpawned;
                    if (Watcher.random(1, 3) == 1) {
                        Watcher.this.sd(Watcher.this.mobSummonConvs[Watcher.random(0, Watcher.this.mobSummonConvs.length - 1)], 10, 50, true);
                    }
                    this.cancel();
                    return;
                }
                Location r2 = e2.getLocation().setDirection(tpToC.toVector().subtract(e2.getLocation().toVector()));
                e2.teleport(r2);
                Watcher.sendHeadRotation(e2, r2.getYaw(), r2.getPitch());
                double x2 = 0.0;
                double y2 = 0.0;
                double z2 = 0.0;
                x2 = Math.toRadians(r2.getPitch());
                ((ArmorStand)e2).setHeadPose(new EulerAngle(x2, y2, z2));
                e2.teleport(e2.getLocation().add(e2.getLocation().getDirection().multiply(0.5)));
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
    }

    public static void sendHeadRotation(org.bukkit.entity.Entity e2, float yaw, float pitch) {
        EntityArmorStand pl = ((CraftArmorStand)e2).getHandle();
        pl.setLocation(e2.getLocation().getX(), e2.getLocation().getY(), e2.getLocation().getZ(), yaw, pitch);
        PacketPlayOutEntityTeleport packet = new PacketPlayOutEntityTeleport((Entity)pl);
        for (Player p2 : e2.getWorld().getPlayers()) {
            ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
        }
    }

    public static int random(int min, int max) {
        if (min < 0) {
            min = 0;
        }
        if (max < 0) {
            max = 0;
        }
        return new Random().nextInt(max - min + 1) + min;
    }

    public ArmorStand spawnWatchfulEyes(final org.bukkit.entity.Entity e2) {
        Location l1 = e2.getLocation().clone().add(e2.getLocation().getDirection().normalize().multiply(-1.5));
        float angle1 = l1.getYaw() / 60.0f;
        Location loc_1 = l1.add(Math.cos(angle1), 0.0, Math.sin(angle1));
        Location loc = e2.getLocation();
        final ArmorStand stand = (ArmorStand)loc.getWorld().spawn(loc_1.add(0.0, 1.5, 0.0), ArmorStand.class);
        stand.setCustomName(Watcher.trans("&3&lWatchful Eye"));
        stand.setCustomNameVisible(true);
        stand.setVisible(false);
        stand.getEquipment().setHelmet(Watcher.getSkull("37cc76e7af29f5f3fbfd6ece794160811eff96f753459fa61d7ad176a064e3c5"));
        stand.setGravity(false);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 3L, 3L);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                if (e2 instanceof ArmorStand && !Watcher.this.wfe1_shoot) {
                    Location r2 = stand.getLocation().setDirection(e2.getLocation().toVector().subtract(stand.getLocation().toVector()));
                    stand.teleport(r2);
                    Watcher.sendHeadRotation((org.bukkit.entity.Entity)stand, r2.getYaw(), r2.getPitch());
                    double x2 = 0.0;
                    double y2 = 0.0;
                    double z2 = 0.0;
                    x2 = Math.toRadians(r2.getPitch());
                    stand.setHeadPose(new EulerAngle(x2, y2, z2));
                }
                Location l2 = e2.getLocation().clone().add(0.0, 1.0, 0.0).add(e2.getLocation().getDirection().normalize().multiply(-1.5));
                float angle = l2.getYaw() / 60.0f;
                Location loc_ = l2.add(Math.cos(angle), 0.0, Math.sin(angle));
                if (stand.getLocation().distance(e2.getLocation()) > 2.5 && !Watcher.this.wfe1_shoot) {
                    stand.teleport(stand.getLocation().add(loc_.toVector().subtract(stand.getLocation().toVector()).normalize().multiply(Math.min(9.0, Math.min(15.0, e2.getLocation().distance(stand.getLocation())) / 4.0 + 0.2))));
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 3L);
        return stand;
    }

    public ArmorStand spawnWatchfulEyes2(final org.bukkit.entity.Entity e2) {
        Location l1 = e2.getLocation().clone().add(e2.getLocation().getDirection().normalize().multiply(-1.5));
        float angle1 = l1.getYaw() / 60.0f;
        Location loc_1 = l1.subtract(Math.cos(angle1), 0.0, Math.sin(angle1));
        Location loc = e2.getLocation();
        final ArmorStand stand = (ArmorStand)loc.getWorld().spawn(loc_1.add(0.0, 1.5, 0.0), ArmorStand.class);
        stand.setCustomName(Watcher.trans("&3&lWatchful Eye"));
        stand.setCustomNameVisible(true);
        stand.setVisible(false);
        stand.getEquipment().setHelmet(Watcher.getSkull("37cc76e7af29f5f3fbfd6ece794160811eff96f753459fa61d7ad176a064e3c5"));
        stand.setGravity(false);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.MAGIC_CRIT, 21, 0, 0.2f, 0.1f, 0.2f, 0.01f, 1, 30);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 3L, 3L);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                if (e2 instanceof ArmorStand && !Watcher.this.wfe2_shoot) {
                    Location r2 = stand.getLocation().setDirection(e2.getLocation().toVector().subtract(stand.getLocation().toVector()));
                    stand.teleport(r2);
                    Watcher.sendHeadRotation((org.bukkit.entity.Entity)stand, r2.getYaw(), r2.getPitch());
                    double x2 = 0.0;
                    double y2 = 0.0;
                    double z2 = 0.0;
                    x2 = Math.toRadians(r2.getPitch());
                    stand.setHeadPose(new EulerAngle(x2, y2, z2));
                }
                Location l2 = e2.getLocation().clone().add(0.0, 1.0, 0.0).add(e2.getLocation().getDirection().normalize().multiply(-1.5));
                float angle = l2.getYaw() / 60.0f;
                Location loc_ = l2.subtract(Math.cos(angle), 0.0, Math.sin(angle));
                if (stand.getLocation().distance(e2.getLocation()) > 2.5 && !Watcher.this.wfe2_shoot) {
                    stand.teleport(stand.getLocation().add(loc_.toVector().subtract(stand.getLocation().toVector()).normalize().multiply(Math.min(9.0, Math.min(15.0, e2.getLocation().distance(stand.getLocation())) / 4.0 + 0.2))));
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 3L);
        return stand;
    }

    public void spawnWatcher(Location loc) {
        ArmorStand stand2;
        final ArmorStand stand = (ArmorStand)loc.getWorld().spawn(loc, ArmorStand.class);
        this.welcomeParticles = true;
        this.ewatcher = stand;
        stand.setCustomName(Watcher.trans("&e\ufd3e &c&lThe Watcher &e\ufd3f"));
        stand.setMetadata("WATCHER_M", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)0));
        stand.setCustomNameVisible(true);
        stand.setVisible(false);
        stand.getEquipment().setHelmet(Watcher.getSkull("a137229538d619da70b5fd2ea06a560d9ce50b0e2f92413e6aa73d99f9d7a878"));
        stand.setGravity(false);
        this.econv = stand2 = (ArmorStand)loc.getWorld().spawn(loc.add(0.0, 2.4, 0.0), ArmorStand.class);
        stand2.setCustomNameVisible(false);
        stand2.setVisible(false);
        stand2.setMarker(true);
        stand2.setGravity(false);
        this.isResting = true;
        for (org.bukkit.entity.Entity e2 : stand.getNearbyEntities(20.0, 20.0, 20.0)) {
            if (!(e2 instanceof Player)) continue;
            Location r2 = stand.getLocation().setDirection(e2.getLocation().toVector().subtract(stand.getLocation().toVector()));
            stand.teleport(r2);
            Watcher.sendHeadRotation((org.bukkit.entity.Entity)stand, r2.getYaw(), r2.getPitch());
            double x2 = 0.0;
            double y2 = 0.0;
            double z2 = 0.0;
            x2 = Math.toRadians(r2.getPitch());
            stand.setHeadPose(new EulerAngle(x2, y2, z2));
            break;
        }
        this.wfe1 = this.spawnWatchfulEyes((org.bukkit.entity.Entity)stand);
        this.wfe2 = this.spawnWatchfulEyes2((org.bukkit.entity.Entity)stand);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                for (final org.bukkit.entity.Entity e2 : stand.getNearbyEntities(20.0, 20.0, 20.0)) {
                    if (!(e2 instanceof Player) || Watcher.this.welcomeParticles || !(e2.getLocation().getY() >= (double)(Watcher.this.floorY + 6.0f))) continue;
                    ArmorStand st = null;
                    final int rnd = Watcher.random(0, 1);
                    ArmorStand armorStand = st = rnd == 1 ? Watcher.this.wfe1 : Watcher.this.wfe2;
                    if (rnd == 1) {
                        Watcher.this.wfe1_shoot = true;
                    } else {
                        Watcher.this.wfe2_shoot = true;
                    }
                    for (int i2 = 0; i2 < 2; ++i2) {
                        Watcher.drawLineforMovingPoints(st.getLocation().clone().add(0.0, 1.8, 0.0), e2.getLocation().clone().add(0.0, 1.4, 0.0), 25.0, (Player)e2, (org.bukkit.entity.Entity)stand);
                    }
                    Watcher.this.sd(Watcher.this.sneakyPeaky[Watcher.random(0, Watcher.this.sneakyPeaky.length - 1)], 0, 50, true);
                    User.getUser(((Player)e2).getUniqueId()).damage(((Player)e2).getMaxHealth() * 1.0 / 4.0, EntityDamageEvent.DamageCause.ENTITY_ATTACK, (org.bukkit.entity.Entity)Watcher.this.ewatcher);
                    ((Player)e2).damage(1.0E-5);
                    final ArmorStand s2 = st;
                    new BukkitRunnable(){
                        int i = 0;

                        public void run() {
                            if (this.i >= 15) {
                                if (rnd == 1) {
                                    Watcher.this.wfe1_shoot = false;
                                } else {
                                    Watcher.this.wfe2_shoot = false;
                                }
                                this.cancel();
                                return;
                            }
                            ++this.i;
                            Location r2 = stand.getLocation().setDirection(e2.getLocation().toVector().subtract(s2.getLocation().toVector()));
                            stand.teleport(r2);
                            Watcher.sendHeadRotation((org.bukkit.entity.Entity)s2, r2.getYaw(), r2.getPitch());
                            double x2 = 0.0;
                            double y2 = 0.0;
                            double z2 = 0.0;
                            x2 = Math.toRadians(r2.getPitch());
                            s2.setHeadPose(new EulerAngle(x2, y2, z2));
                        }
                    }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 30L);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.CLOUD, 21, 0, 0.1f, 0.0f, 0.1f, 0.01f, 1, 30);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.2, 0.0), Effect.EXPLOSION, 21, 0, 0.1f, 0.0f, 0.1f, 0.01f, 1, 30);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 5L);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                if (Watcher.this.isResting) {
                    for (org.bukkit.entity.Entity e2 : stand.getNearbyEntities(20.0, 20.0, 20.0)) {
                        if (!(e2 instanceof Player)) continue;
                        Location r2 = stand.getLocation().setDirection(e2.getLocation().toVector().subtract(stand.getLocation().toVector()));
                        stand.teleport(r2);
                        Watcher.sendHeadRotation((org.bukkit.entity.Entity)stand, r2.getYaw(), r2.getPitch());
                        double x2 = 0.0;
                        double y2 = 0.0;
                        double z2 = 0.0;
                        x2 = Math.toRadians(r2.getPitch());
                        stand.setHeadPose(new EulerAngle(x2, y2, z2));
                        break;
                    }
                }
                stand2.teleport(stand.getLocation().clone().add(0.0, 2.4, 0.0));
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
        new BukkitRunnable(){

            public void run() {
                if (Watcher.this.ewatcher.isDead()) {
                    this.cancel();
                    return;
                }
                if (Watcher.this.currentMobsCount <= 0) {
                    this.cancel();
                    Watcher.this.sd("You have proven yourself. You may pass.", 5, 50, true);
                    SUtil.delay(() -> {
                        Watcher.this.ewatcher.getWorld().strikeLightningEffect(Watcher.this.ewatcher.getLocation().clone().add(0.0, 1.8, 0.0));
                        Watcher.this.ewatcher.remove();
                        Watcher.this.wfe1.remove();
                        Watcher.this.wfe2.remove();
                        Watcher.this.econv.remove();
                    }, 60L);
                    return;
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead() || !Watcher.this.welcomeParticles) {
                    this.cancel();
                    return;
                }
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 0.75, 0.0), Effect.LARGE_SMOKE, 0, 1, (float)Watcher.random(-2, 2), (float)Watcher.random(-1.5, 1.5), (float)Watcher.random(-2, 2), 0.0f, 1, 20);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 0.75, 0.0), Effect.WITCH_MAGIC, 0, 1, (float)Watcher.random(-2, 2), (float)Watcher.random(-1.5, 1.5), (float)Watcher.random(-2, 2), 0.0f, 1, 20);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 0.75, 0.0), Effect.LARGE_SMOKE, 0, 1, (float)Watcher.random(-2, 2), (float)Watcher.random(-1.5, 1.5), (float)Watcher.random(-2, 2), 0.0f, 1, 20);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 0.75, 0.0), Effect.WITCH_MAGIC, 0, 1, (float)Watcher.random(-2, 2), (float)Watcher.random(-1.5, 1.5), (float)Watcher.random(-2, 2), 0.0f, 1, 20);
                stand.getWorld().spigot().playEffect(new Location(stand.getWorld(), stand.getLocation().getX() + (double)Watcher.random(-2, 2), stand.getLocation().getY() + 1.75 + Watcher.random(-1.5, 1.5), stand.getLocation().getZ() + (double)Watcher.random(-2, 2)), Effect.COLOURED_DUST, 0, 1, 0.99607843f, 0.12941177f, 0.003921569f, 1.0f, 0, 64);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 2L, 2L);
        this.sd("Oh... hello?", 20, 0, false);
        this.sd(null, 60, 0, false);
        this.sd("You've arrived too early, I haven't even set up...", 80, 0, false);
        this.sd(null, 120, 0, false);
        this.sd("Anyway, let's fight... I guess.", 140, 0, false);
        this.sd(null, 180, 0, false);
        SUtil.delay(() -> {
            this.moveWatcher((org.bukkit.entity.Entity)stand, true);
            this.welcomeParticles = false;
        }, 200L);
    }

    public static void drawLineforMovingPoints(Location point1, Location point2, double space, Player p2, org.bukkit.entity.Entity e2) {
        Location blockLocation = point1;
        Location crystalLocation = point2;
        Vector vector = blockLocation.clone().toVector().subtract(crystalLocation.clone().toVector());
        double count = 45.0;
        for (int i2 = 1; i2 <= (int)count; ++i2) {
            Vector v2 = vector.clone().multiply((double)i2 / count);
            point1.getWorld().spigot().playEffect(crystalLocation.clone().add(v2), Effect.MAGIC_CRIT, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
        }
    }

    public static String trans(String content) {
        return ChatColor.translateAlternateColorCodes((char)'&', (String)content);
    }

    public static ItemStack getSkull(String texture) {
        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1);
        stack.setDurability((short)3);
        SkullMeta meta = (SkullMeta)stack.getItemMeta();
        String stringUUID = UUID.randomUUID().toString();
        GameProfile profile = new GameProfile(UUID.fromString(stringUUID), null);
        byte[] ed = Base64.getEncoder().encode(String.format("{textures:{SKIN:{url:\"http://textures.minecraft.net/texture/%s\"}}}", texture).getBytes());
        profile.getProperties().put((Object)"textures", (Object)new Property("textures", new String(ed)));
        try {
            Field f2 = meta.getClass().getDeclaredField("profile");
            f2.setAccessible(true);
            f2.set(meta, profile);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchFieldException exception) {
            // empty catch block
        }
        stack.setItemMeta((ItemMeta)meta);
        return stack;
    }

    public static ItemStack getSkullStack(String name) {
        ItemStack stack = new ItemStack(Material.SKULL_ITEM, 1);
        stack.setDurability((short)3);
        SkullMeta meta = (SkullMeta)stack.getItemMeta();
        meta.setOwner(name);
        stack.setItemMeta((ItemMeta)meta);
        return stack;
    }

    public void playHeadSpawning(org.bukkit.entity.Entity e2) {
        String amd = ((MetadataValue)e2.getMetadata("TYPE").get(0)).asString();
        amd = amd.replace("WATCHER_", "");
        final HeadsOnWall h2 = new HeadsOnWall(EnumWatcherType.valueOf(amd));
        final Location target = this.watcher.clone().add(0.0, -3.5, 0.0);
        final ArmorStand stand = (ArmorStand)e2.getWorld().spawn(e2.getLocation(), ArmorStand.class);
        stand.setCustomNameVisible(false);
        stand.setVisible(false);
        stand.getEquipment().setHelmet(Watcher.getSkull(h2.skullTexture));
        stand.setGravity(false);
        new BukkitRunnable(){

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.6, 0.0), Effect.LARGE_SMOKE, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.6, 0.0), Effect.WITCH_MAGIC, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
                stand.getWorld().playEffect(stand.getLocation().clone().add(0.0, 1.6, 0.0), Effect.POTION_SWIRL, 0);
                stand.getWorld().playEffect(stand.getLocation().clone().add(0.0, 1.6, 0.0), Effect.FLYING_GLYPH, 0);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.6, 0.0), Effect.COLOURED_DUST, 0, 1, 0.99607843f, 0.12941177f, 0.003921569f, 1.0f, 0, 64);
                stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 1.6, 0.0), Effect.COLOURED_DUST, 0, 1, 0.99607843f, 0.12941177f, 0.003921569f, 1.0f, 0, 64);
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 2L, 2L);
        new BukkitRunnable(){
            int t = 0;
            int i = 0;

            public void run() {
                if (stand.isDead()) {
                    this.cancel();
                    return;
                }
                if (this.i >= Watcher.random(40, 45) && stand.getLocation().getBlock().getType() == Material.AIR && stand.getLocation().clone().add(0.0, 1.0, 0.0).getBlock().getType() == Material.AIR) {
                    stand.remove();
                    for (int i2 = 0; i2 < 20; ++i2) {
                        stand.getWorld().spigot().playEffect(stand.getLocation().clone().add(0.0, 0.25, 0.0), Effect.EXPLOSION, 0, 1, (float)Watcher.random(-0.5, 0.5), (float)Watcher.random(-1, 1), (float)Watcher.random(-0.5, 0.5), 0.0f, 1, 20);
                    }
                    stand.getWorld().playSound(stand.getLocation(), Sound.ZOMBIE_REMEDY, 0.2f, 1.8f);
                    new SEntity(stand.getLocation(), SEntityType.valueOf(h2.stype), new Object[0]);
                    this.cancel();
                    return;
                }
                ++this.i;
                this.t += 15;
                Location r2 = stand.getLocation().setDirection(target.toVector().subtract(stand.getLocation().toVector()));
                stand.teleport(r2);
                stand.teleport(stand.getLocation().add(stand.getLocation().getDirection().multiply(0.25)));
                Watcher.sendHeadRotation((org.bukkit.entity.Entity)stand, this.t, r2.getPitch());
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 1L, 1L);
    }

    public void say(String str) {
        if (str == null) {
            this.econv.setCustomNameVisible(false);
            return;
        }
        for (Player p2 : this.econv.getWorld().getPlayers()) {
            p2.sendMessage(Watcher.trans("&c[BOSS] The Watcher&f: " + str));
        }
        this.econv.setCustomNameVisible(true);
        this.econv.setCustomName(Watcher.trans("&f&l" + str));
    }

    public void sd(String str, int delay, int timeout, boolean needTo) {
        SUtil.delay(() -> this.say(str), delay);
        if (needTo) {
            SUtil.delay(() -> {
                if (this.econv.getCustomName().contains(str)) {
                    this.say(null);
                }
            }, timeout + delay);
        }
    }
}

