/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Entity
 *  net.minecraft.server.v1_8_R3.EntityEnderDragon
 *  net.minecraft.server.v1_8_R3.World
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Effect
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.craftbukkit.v1_8_R3.CraftWorld
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Fireball
 *  org.bukkit.entity.Item
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.entity.CreatureSpawnEvent$SpawnReason
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.features.entity.nms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.minecraft.server.v1_8_R3.Entity;
import net.minecraft.server.v1_8_R3.EntityEnderDragon;
import net.minecraft.server.v1_8_R3.World;
import org.apache.commons.lang3.Range;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.Item;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.entity.EntityFunction;
import vn.giakhanhvn.skysim.features.entity.EntityStatistics;
import vn.giakhanhvn.skysim.features.entity.KillEnderCrystal;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.SEntityType;
import vn.giakhanhvn.skysim.features.entity.StaticDragonManager;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.GlobalBossBar;
import vn.giakhanhvn.skysim.features.entity.nms.SNMSEntity;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.SUtil;

public abstract class Dragon
extends EntityEnderDragon
implements SNMSEntity,
EntityFunction,
EntityStatistics {
    public static final long DEFAULT_ATTACK_COOLDOWN = 300L;
    public static final Range DEFAULT_DAMAGE_DEGREE_RANGE = Range.between(0.3, 0.7);
    public static final double DEFAULT_SPEED_MODIFIER = 1.4;
    private boolean frozen = false;
    private double yD = 1.0;
    private double speedModifier;
    private Range<Double> damageDegree;
    private final long attackCooldown;

    protected Dragon(World world, double speedModifier, Range<Double> damageDegree, long attackCooldown) {
        super(world);
        this.speedModifier = speedModifier;
        this.damageDegree = damageDegree;
        this.attackCooldown = attackCooldown;
    }

    protected Dragon(double speedModifier, Range<Double> damageDegree, long attackCooldown) {
        this((World)((CraftWorld)Bukkit.getWorlds().get(0)).getHandle(), speedModifier, damageDegree, attackCooldown);
    }

    @Override
    public double getXPDropped() {
        return 0.0;
    }

    public GlobalBossBar setBar(org.bukkit.World w2) {
        GlobalBossBar bb2 = new GlobalBossBar(ChatColor.RED + this.getEntityName(), w2);
        for (Player p2 : w2.getPlayers()) {
            bb2.addPlayer(p2);
        }
        return bb2;
    }

    public void updateBar(float percent, GlobalBossBar bb2) {
        bb2.setProgress(percent);
    }

    @Override
    public boolean tick(LivingEntity entity) {
        this.target = null;
        if (this.frozen) {
            entity.setVelocity(new Vector(0, 0, 0));
            return true;
        }
        Location location = entity.getLocation();
        if (location.getY() < SUtil.random(7.0, 13.0)) {
            this.yD = SUtil.random(0.6, 1.2);
        }
        if (location.getY() > SUtil.random(57.0, 63.0)) {
            this.yD = SUtil.random(-1.2, -0.6);
        }
        if (location.getX() < -718.0 || location.getX() > -623.0 || location.getZ() < -328.0 || location.getZ() > -224.0) {
            Vector vector = entity.getLocation().clone().subtract(new Vector(-670.5, 58.0, -275.5)).toVector();
            Location center = location.clone();
            center.setDirection(vector);
            entity.teleport(center);
            entity.setVelocity(vector.clone().normalize().multiply(-1.0).multiply(3.0));
            return true;
        }
        entity.setVelocity(entity.getLocation().getDirection().clone().multiply(-1.0).multiply(this.speedModifier).setY(this.yD));
        return true;
    }

    @Override
    public void onSpawn(final LivingEntity entity, final SEntity sEntity) {
        final GlobalBossBar bb2 = this.setBar(entity.getWorld());
        new BukkitRunnable(){

            public void run() {
                if (entity.isDead()) {
                    Dragon.this.updateBar(1.0E-4f, bb2);
                    SUtil.delay(() -> {
                        ArrayList<Player> plist = new ArrayList<Player>(bb22.players);
                        plist.forEach(pl -> bb2.removePlayer((Player)pl));
                        bb2.setProgress(0.0);
                        bb2.cancel();
                    }, 400L);
                    this.cancel();
                    return;
                }
                Dragon.this.updateBar((float)(entity.getHealth() / entity.getMaxHealth()), bb2);
            }
        }.runTaskTimerAsynchronously((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
        new BukkitRunnable(){

            public void run() {
                if (entity.isDead()) {
                    this.cancel();
                    return;
                }
                switch (SUtil.random(0, 1)) {
                    case 0: {
                        Dragon.this.frozen = true;
                        for (int i2 = 1; i2 <= 4; ++i2) {
                            SUtil.lightningLater(entity.getLocation(), true, 10 * i2);
                        }
                        new BukkitRunnable(){

                            public void run() {
                                if (entity.isDead()) {
                                    return;
                                }
                                for (org.bukkit.entity.Entity e2 : entity.getNearbyEntities(200.0, 200.0, 200.0)) {
                                    e2.getWorld().strikeLightningEffect(e2.getLocation());
                                    double r2 = SUtil.random((Double)Dragon.this.damageDegree.getMinimum(), (Double)Dragon.this.damageDegree.getMaximum());
                                    if (!(e2 instanceof LivingEntity)) continue;
                                    LivingEntity le = (LivingEntity)e2;
                                    int damage = (int)(le.getMaxHealth() * r2);
                                    if (le instanceof Player) {
                                        User.getUser(le.getUniqueId()).damage(damage, EntityDamageEvent.DamageCause.ENTITY_ATTACK, (org.bukkit.entity.Entity)entity);
                                    } else {
                                        le.damage((double)damage);
                                    }
                                    e2.sendMessage(ChatColor.DARK_PURPLE + "\u262c " + ChatColor.RED + Dragon.this.getEntityName() + ChatColor.LIGHT_PURPLE + " used " + ChatColor.YELLOW + "Lightning Strike" + ChatColor.LIGHT_PURPLE + " on you for " + ChatColor.RED + damage + " damage.");
                                }
                                Dragon.this.frozen = false;
                            }
                        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 50L);
                        return;
                    }
                    case 1: {
                        Dragon.this.frozen = true;
                        org.bukkit.entity.Entity near = null;
                        for (org.bukkit.entity.Entity n2 : entity.getNearbyEntities(50.0, 50.0, 50.0)) {
                            if (!(n2 instanceof Player)) continue;
                            near = n2;
                        }
                        final org.bukkit.entity.Entity finalNear = near;
                        if (near != null) {
                            SUtil.runIntervalForTicks(() -> {
                                if (entity.isDead()) {
                                    return;
                                }
                                for (int i2 = 0; i2 < 15; ++i2) {
                                    entity.getWorld().spigot().playEffect(entity.getEyeLocation().subtract(0.0, 8.0, 0.0).add(entity.getLocation().getDirection().multiply(-8.0)).add(SUtil.random(-0.5, 0.5), SUtil.random(-0.5, 0.5), SUtil.random(-0.5, 0.5)), Effect.FLAME, 0, 1, 0.0f, 0.0f, 0.0f, 0.0f, 1, 50);
                                }
                            }, 5L, 140L);
                            final float fn = SUtil.getLookAtYaw(near.getLocation().toVector());
                            new BukkitRunnable(){

                                public void run() {
                                    SUtil.runIntervalForTicks(() -> {
                                        if (entity.isDead()) {
                                            return;
                                        }
                                        if ((int)fn == (int)entity.getLocation().getYaw()) {
                                            return;
                                        }
                                        Location location = entity.getLocation().clone();
                                        location.setYaw(entity.getLocation().clone().getYaw() + 1.0f);
                                        entity.teleport(location);
                                    }, 1L, 120L);
                                }
                            }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 20L);
                            new BukkitRunnable(){

                                public void run() {
                                    SUtil.runIntervalForTicks(() -> {
                                        if (entity.isDead()) {
                                            return;
                                        }
                                        Fireball fireball = (Fireball)entity.getWorld().spawn(entity.getEyeLocation().subtract(0.0, 8.0, 0.0).add(entity.getLocation().getDirection().multiply(-10.0)), Fireball.class);
                                        fireball.setMetadata("dragon", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)sEntity));
                                        fireball.setDirection(finalNear.getLocation().getDirection().multiply(-1.0).normalize());
                                    }, 5L, 60L);
                                }
                            }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 80L);
                        }
                        new BukkitRunnable(){

                            public void run() {
                                Dragon.this.frozen = false;
                            }
                        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 140L);
                        return;
                    }
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 100L, this.attackCooldown);
    }

    @Override
    public void onDeath(final SEntity sEntity, final org.bukkit.entity.Entity killed, org.bukkit.entity.Entity damager) {
        int place;
        final HashMap<UUID, List<Location>> eyes = new HashMap<UUID, List<Location>>(StaticDragonManager.EYES);
        KillEnderCrystal.killEC(killed.getWorld());
        SUtil.delay(() -> StaticDragonManager.endFight(), 500L);
        StringBuilder message = new StringBuilder();
        message.append(ChatColor.GREEN).append(ChatColor.BOLD).append("\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\n");
        message.append(ChatColor.GOLD).append(ChatColor.BOLD).append("                 ").append(sEntity.getStatistics().getEntityName().toUpperCase()).append(" DOWN!\n \n");
        final ArrayList<Map.Entry<UUID, Double>> damageDealt = new ArrayList<Map.Entry<UUID, Double>>(sEntity.getDamageDealt().entrySet());
        damageDealt.sort(Map.Entry.comparingByValue());
        Collections.reverse(damageDealt);
        String name = null;
        if (damager instanceof Player) {
            name = damager.getName();
        }
        if (damager instanceof Arrow && ((Arrow)damager).getShooter() instanceof Player) {
            name = ((Player)((Arrow)damager).getShooter()).getName();
        }
        if (name != null) {
            message.append("            ").append(ChatColor.GREEN).append(name).append(ChatColor.GRAY).append(" dealt the final blow.\n \n");
        }
        for (int i2 = 0; i2 < Math.min(3, damageDealt.size()); ++i2) {
            message.append("\n");
            Map.Entry<UUID, Double> d2 = damageDealt.get(i2);
            place = i2 + 1;
            switch (place) {
                case 1: {
                    message.append("        ").append(ChatColor.YELLOW);
                    break;
                }
                case 2: {
                    message.append("        ").append(ChatColor.GOLD);
                    break;
                }
                case 3: {
                    message.append("        ").append(ChatColor.RED);
                }
            }
            message.append(ChatColor.BOLD).append(place);
            switch (place) {
                case 1: {
                    message.append("st");
                    break;
                }
                case 2: {
                    message.append("nd");
                    break;
                }
                case 3: {
                    message.append("rd");
                }
            }
            message.append(" Damager").append(ChatColor.RESET).append(ChatColor.GRAY).append(" - ").append(ChatColor.GREEN).append(Bukkit.getOfflinePlayer((UUID)d2.getKey()).getName()).append(ChatColor.GRAY).append(" - ").append(ChatColor.YELLOW).append(SUtil.commaify(d2.getValue().intValue()));
        }
        message.append("\n \n").append("         ").append(ChatColor.RESET).append(ChatColor.YELLOW).append("Your Damage: ").append("%s").append(ChatColor.RESET).append("\n").append("             ").append(ChatColor.YELLOW).append("Runecrafting Experience: ").append(ChatColor.LIGHT_PURPLE).append("N/A").append(ChatColor.RESET).append("\n \n");
        message.append(ChatColor.GREEN).append(ChatColor.BOLD).append("\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac\u25ac");
        for (Player player : Bukkit.getOnlinePlayers()) {
            place = -1;
            int damage = 0;
            for (int i3 = 0; i3 < damageDealt.size(); ++i3) {
                Map.Entry<UUID, Double> d3 = damageDealt.get(i3);
                if (!d3.getKey().equals(player.getUniqueId())) continue;
                place = i3 + 1;
                damage = d3.getValue().intValue();
            }
            if (!player.getWorld().getName().equals("dragon")) continue;
            player.sendMessage(String.format(message.toString(), place != -1 ? ChatColor.GREEN + SUtil.commaify(damage) + ChatColor.GRAY + " (Position #" + place + ")" : ChatColor.RED + "N/A" + ChatColor.GRAY + " (Position #N/A)"));
        }
        new BukkitRunnable(){

            public void run() {
                for (int i2 = 0; i2 < damageDealt.size(); ++i2) {
                    Map.Entry d2 = (Map.Entry)damageDealt.get(i2);
                    Player player = Bukkit.getPlayer((UUID)((UUID)d2.getKey()));
                    if (player == null) continue;
                    int weight = 0;
                    if (eyes.containsKey(player.getUniqueId())) {
                        weight += Math.min(400, ((List)eyes.get(player.getUniqueId())).size() * 100);
                    }
                    if (i2 == 0) {
                        weight += 300;
                    }
                    if (i2 == 1) {
                        weight += 250;
                    }
                    if (i2 == 2) {
                        weight += 200;
                    }
                    if (i2 >= 3 && i2 <= 6) {
                        weight += 125;
                    }
                    if (i2 >= 7 && i2 <= 14) {
                        weight += 100;
                    }
                    if (i2 >= 15) {
                        weight += 75;
                    }
                    ArrayList possibleMajorDrops = new ArrayList();
                    SEntityType type = sEntity.getSpecType();
                    SUtil.addIf(new DragonDrop(SMaterial.ASPECT_OF_THE_DRAGONS, 450), possibleMajorDrops, weight >= 450);
                    SUtil.addIf(new DragonDrop(SMaterial.ENDER_DRAGON_PET, 450), possibleMajorDrops, weight >= 450);
                    SUtil.addIf(new DragonDrop(SMaterial.ENDER_DRAGON_PET2, 450), possibleMajorDrops, weight >= 450);
                    SUtil.addIf(new DragonDrop(SMaterial.VagueEntityMaterial.HELMET, 400, type), possibleMajorDrops, weight >= 400);
                    SUtil.addIf(new DragonDrop(SMaterial.VagueEntityMaterial.CHESTPLATE, 325, type), possibleMajorDrops, weight >= 325);
                    SUtil.addIf(new DragonDrop(SMaterial.VagueEntityMaterial.LEGGINGS, 350, type), possibleMajorDrops, weight >= 350);
                    SUtil.addIf(new DragonDrop(SMaterial.VagueEntityMaterial.BOOTS, 300, type), possibleMajorDrops, weight >= 300);
                    int remainingWeight = weight;
                    if (possibleMajorDrops.size() > 0) {
                        DragonDrop drop = (DragonDrop)possibleMajorDrops.get(SUtil.random(0, possibleMajorDrops.size() - 1));
                        SMaterial majorDrop = drop.getMaterial();
                        remainingWeight -= drop.getWeight();
                        if (majorDrop != null) {
                            Item item;
                            SItem sItem = SItem.of(majorDrop);
                            if (!sItem.getFullName().equals("\u00a76Ender Dragon") && !sItem.getFullName().equals("\u00a75Ender Dragon")) {
                                item = SUtil.spawnPersonalItem(sItem.getStack(), killed.getLocation(), player);
                                item.setMetadata("obtained", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
                                item.setCustomNameVisible(true);
                                item.setCustomName(item.getItemStack().getAmount() + "x " + sItem.getFullName());
                            } else {
                                item = SUtil.spawnPersonalItem(sItem.getStack(), killed.getLocation(), player);
                                item.setMetadata("obtained", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)true));
                                item.setCustomNameVisible(true);
                                item.setCustomName(item.getItemStack().getAmount() + "x " + ChatColor.GRAY + "[Lvl 1] " + sItem.getFullName());
                            }
                        }
                    }
                    ArrayList<DragonDrop> minorDrops = new ArrayList<DragonDrop>(Arrays.asList(new DragonDrop(SMaterial.ENDER_PEARL, 0), new DragonDrop(SMaterial.ENCHANTED_ENDER_PEARL, 0)));
                    SUtil.addIf(new DragonDrop(SMaterial.VagueEntityMaterial.FRAGMENT, 22, type), minorDrops, weight >= 22);
                    int frags = 0;
                    while (remainingWeight >= 22) {
                        remainingWeight -= 22;
                        ++frags;
                    }
                    for (DragonDrop minorDrop : minorDrops) {
                        Item item;
                        SItem sItem = SItem.of(minorDrop.getMaterial());
                        if (minorDrop.getMaterial() == null) continue;
                        if (minorDrop.getVagueEntityMaterial() != null && frags != 0) {
                            item = SUtil.spawnPersonalItem(SUtil.setStackAmount(sItem.getStack(), frags), killed.getLocation(), player);
                            item.setCustomNameVisible(true);
                            item.setCustomName(item.getItemStack().getAmount() + "x " + sItem.getFullName());
                            continue;
                        }
                        item = SUtil.spawnPersonalItem(SUtil.setStackAmount(sItem.getStack(), SUtil.random(5, 10)), killed.getLocation(), player);
                        item.setCustomNameVisible(true);
                        item.setCustomName(item.getItemStack().getAmount() + "x " + sItem.getFullName());
                    }
                }
            }
        }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 200L);
    }

    @Override
    public LivingEntity spawn(Location location) {
        this.world = ((CraftWorld)location.getWorld()).getHandle();
        this.setPosition(location.getX(), location.getY(), location.getZ());
        this.world.addEntity((Entity)this, CreatureSpawnEvent.SpawnReason.CUSTOM);
        return (LivingEntity)this.getBukkitEntity();
    }

    @Override
    public void onAttack(EntityDamageByEntityEvent e2) {
        int d2 = SUtil.random(354, 902);
        if (e2.getEntity() instanceof Player) {
            User.getUser(e2.getEntity().getUniqueId()).damage(d2, e2.getCause(), e2.getDamager());
        } else if (e2.getEntity() instanceof LivingEntity) {
            ((LivingEntity)e2.getEntity()).damage((double)d2);
        }
        e2.getEntity().setVelocity(e2.getEntity().getVelocity().multiply(8.0));
        e2.getEntity().sendMessage(ChatColor.DARK_PURPLE + "\u262c " + ChatColor.RED + this.getEntityName() + ChatColor.LIGHT_PURPLE + " used " + ChatColor.YELLOW + "Rush" + ChatColor.LIGHT_PURPLE + " on you for " + ChatColor.RED + d2 + " damage.");
    }

    public double getSpeedModifier() {
        return this.speedModifier;
    }

    public void setSpeedModifier(double speedModifier) {
        this.speedModifier = speedModifier;
    }

    public Range<Double> getDamageDegree() {
        return this.damageDegree;
    }

    public void setDamageDegree(Range<Double> damageDegree) {
        this.damageDegree = damageDegree;
    }

    public long getAttackCooldown() {
        return this.attackCooldown;
    }

    private static class DragonDrop {
        private final SMaterial material;
        private final SMaterial.VagueEntityMaterial vagueEntityMaterial;
        private final int weight;

        public DragonDrop(SMaterial material, int weight) {
            this.material = material;
            this.vagueEntityMaterial = null;
            this.weight = weight;
        }

        public DragonDrop(SMaterial.VagueEntityMaterial material, int weight, SEntityType type) {
            this.material = material.getEntityArmorPiece(type);
            this.vagueEntityMaterial = material;
            this.weight = weight;
        }

        public SMaterial getMaterial() {
            return this.material;
        }

        public SMaterial.VagueEntityMaterial getVagueEntityMaterial() {
            return this.vagueEntityMaterial;
        }

        public int getWeight() {
            return this.weight;
        }
    }
}

