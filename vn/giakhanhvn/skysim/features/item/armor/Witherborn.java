/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.ChatColor
 *  org.bukkit.Effect
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Damageable
 *  org.bukkit.entity.EnderDragonPart
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Villager
 *  org.bukkit.entity.Wither
 *  org.bukkit.metadata.FixedMetadataValue
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.scheduler.BukkitRunnable
 */
package vn.giakhanhvn.skysim.features.item.armor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragonPart;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Villager;
import org.bukkit.entity.Wither;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.skill.Skill;
import vn.giakhanhvn.skysim.listener.PlayerListener;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.util.EntityManager;
import vn.giakhanhvn.skysim.util.Groups;
import vn.giakhanhvn.skysim.util.SUtil;

public class Witherborn {
    private Player p;
    private int size = 790;
    private Wither w;
    private boolean isTargetting = false;
    public Entity withersTarget = null;
    public static final Map<UUID, Witherborn> WITHER_MAP = new HashMap<UUID, Witherborn>();
    public static final Map<UUID, Boolean> WITHER_COOLDOWN = new HashMap<UUID, Boolean>();

    public Witherborn(Player p2) {
        this.p = p2;
        this.isTargetting = false;
        WITHER_MAP.put(p2.getUniqueId(), this);
    }

    public boolean checkCondition() {
        SItem helm = SItem.find(this.p.getInventory().getHelmet());
        SItem chest = SItem.find(this.p.getInventory().getChestplate());
        SItem leg = SItem.find(this.p.getInventory().getLeggings());
        SItem boots = SItem.find(this.p.getInventory().getBoots());
        if (helm != null && chest != null && leg != null && boots != null) {
            if (Groups.WITHER_HELMETS.contains((Object)helm.getType()) && Groups.WITHER_CHESTPLATES.contains((Object)chest.getType()) && Groups.WITHER_LEGGINGS.contains((Object)leg.getType()) && Groups.WITHER_BOOTS.contains((Object)boots.getType())) {
                return true;
            }
            WITHER_MAP.remove(this.p.getUniqueId());
            this.w.remove();
            return false;
        }
        WITHER_MAP.remove(this.p.getUniqueId());
        this.w.remove();
        return false;
    }

    public void spawnWither() {
        final Wither w2 = (Wither)this.p.getWorld().spawn(this.p.getLocation(), Wither.class);
        EntityManager.noAI((Entity)w2);
        EntityManager.setNBTTag((Entity)w2, "Invul", this.size);
        EntityManager.noHit((Entity)w2);
        EntityManager.shutTheFuckUp((Entity)w2);
        w2.setMetadata("GiantSword", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)0));
        w2.setMetadata("NoAffect", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)0));
        w2.setMetadata("Ire", (MetadataValue)new FixedMetadataValue((Plugin)SkySimEngine.getPlugin(), (Object)0));
        this.w = w2;
        new BukkitRunnable(){

            public void run() {
                if (!Witherborn.this.p.isOnline() || w2.isDead() || Witherborn.getWitherbornInstance(Witherborn.this.p) == null) {
                    this.cancel();
                    return;
                }
                if (Witherborn.this.withersTarget == null) {
                    List er = w2.getNearbyEntities(10.0, 10.0, 10.0);
                    er.removeIf(en -> en.hasMetadata("GiantSword") || en.hasMetadata("NPC"));
                    er.removeIf(en -> !(en instanceof LivingEntity));
                    er.removeIf(en -> en instanceof Player);
                    er.removeIf(en -> en instanceof ArmorStand);
                    er.removeIf(en -> en instanceof Villager);
                    er.removeIf(Entity::isDead);
                    if (!er.isEmpty()) {
                        LivingEntity le = (LivingEntity)er.get(SUtil.random(0, er.size() - 1));
                        Witherborn.this.setWithersTarget((Entity)le);
                    }
                }
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 100L, 100L);
        new BukkitRunnable(){
            float cout;
            {
                this.cout = Witherborn.this.p.getLocation().getYaw();
            }

            public void run() {
                if (!Witherborn.this.p.isOnline() || w2.isDead() || Witherborn.getWitherbornInstance(Witherborn.this.p) == null) {
                    w2.remove();
                    Witherborn.this.p.playSound(Witherborn.this.p.getLocation(), Sound.WITHER_DEATH, 0.5f, 1.0f);
                    this.cancel();
                    return;
                }
                Witherborn.this.checkCondition();
                if (Witherborn.this.withersTarget != null) {
                    if (Witherborn.this.withersTarget instanceof LivingEntity) {
                        if (!Witherborn.this.isTargetting) {
                            LivingEntity r1 = (LivingEntity)Witherborn.this.withersTarget;
                            Witherborn.this.selfSacrificeHeroAction(w2, (Entity)r1);
                            Witherborn.this.isTargetting = true;
                        }
                    } else {
                        Witherborn.this.withersTarget = null;
                    }
                }
                Location loc = Witherborn.this.p.getLocation();
                loc.setYaw(this.cout);
                loc.setPitch(0.0f);
                loc.add(loc.getDirection().normalize().multiply(1.45));
                if (Witherborn.this.withersTarget == null && !Witherborn.this.isTargetting) {
                    w2.teleport(loc);
                }
                this.cout += 7.0f;
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 2L, 2L);
    }

    public void selfSacrificeHeroAction(final Wither w2, final Entity e2) {
        new BukkitRunnable(){

            public void run() {
                if (!Witherborn.this.p.isOnline() || w2.isDead()) {
                    w2.remove();
                    w2.getWorld().playEffect(w2.getLocation(), Effect.EXPLOSION_LARGE, Witherborn.this.size);
                    w2.getWorld().playEffect(w2.getLocation(), Effect.EXPLOSION_LARGE, Witherborn.this.size);
                    w2.getWorld().playSound(w2.getLocation(), Sound.EXPLODE, 1.0f, 1.0f);
                    w2.getWorld().playSound(w2.getLocation(), Sound.WITHER_DEATH, 0.3f, 1.0f);
                    this.cancel();
                    return;
                }
                if (e2.isDead()) {
                    Witherborn.this.isTargetting = false;
                    Witherborn.this.withersTarget = null;
                    this.cancel();
                    return;
                }
                if (w2.getNearbyEntities(0.2, 0.2, 0.2).contains(e2)) {
                    WITHER_COOLDOWN.put(Witherborn.this.p.getUniqueId(), true);
                    SUtil.delay(() -> {
                        if (Witherborn.this.checkCondition()) {
                            WITHER_MAP.remove(Witherborn.this.p.getUniqueId());
                            Witherborn a2 = new Witherborn(Witherborn.this.p);
                            a2.spawnWither();
                        }
                        WITHER_COOLDOWN.put(Witherborn.this.p.getUniqueId(), false);
                    }, 600L);
                    w2.remove();
                    int j2 = 0;
                    double d2 = 0.0;
                    for (Entity entity : w2.getNearbyEntities(3.0, 3.0, 3.0)) {
                        if (entity.isDead() || !(entity instanceof LivingEntity) || entity.hasMetadata("GiantSword") || entity.hasMetadata("NoAffect") || entity instanceof Player || entity instanceof EnderDragonPart || entity instanceof Villager || entity instanceof ArmorStand) continue;
                        ++j2;
                        double damage = 1000000.0;
                        double find = 0.0;
                        int combatLevel = Skill.getLevel(User.getUser(Witherborn.this.p.getUniqueId()).getCombatXP(), false);
                        double damageMultiplier = 1.0 + (double)combatLevel * 0.04;
                        find = damage * damageMultiplier;
                        if (EntityManager.DEFENSE_PERCENTAGE.containsKey(entity)) {
                            int defensepercent = EntityManager.DEFENSE_PERCENTAGE.get(entity);
                            if (defensepercent > 100) {
                                defensepercent = 100;
                            }
                            find -= find * (double)defensepercent / 100.0;
                        }
                        PlayerListener.spawnDamageInd(entity, find, false);
                        User.getUser(Witherborn.this.p.getUniqueId()).damageEntityIgnoreShield((Damageable)entity, find);
                        d2 += find;
                    }
                    d2 = new BigDecimal(d2).setScale(1, RoundingMode.HALF_EVEN).doubleValue();
                    if (j2 > 0) {
                        if (j2 == 1) {
                            Witherborn.this.p.sendMessage(ChatColor.GRAY + "Your Witherborn hit " + ChatColor.RED + j2 + ChatColor.GRAY + " enemy for " + ChatColor.RED + SUtil.commaify(d2) + ChatColor.GRAY + " damage.");
                        } else {
                            Witherborn.this.p.sendMessage(ChatColor.GRAY + "Your Witherborn hit " + ChatColor.RED + j2 + ChatColor.GRAY + " enemies for " + ChatColor.RED + SUtil.commaify(d2) + ChatColor.GRAY + " damage.");
                        }
                    }
                }
                Witherborn.this.withersTarget = e2;
                Location r2 = w2.getLocation().setDirection(e2.getLocation().toVector().subtract(w2.getLocation().toVector()));
                w2.teleport(r2);
                w2.teleport(w2.getLocation().add(w2.getLocation().getDirection().normalize().multiply(0.3)));
            }
        }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 2L, 1L);
    }

    public static Witherborn getWitherbornInstance(Player p2) {
        return WITHER_MAP.get(p2.getUniqueId());
    }

    public Entity getWithersTarget() {
        return this.withersTarget;
    }

    public void setWithersTarget(Entity withersTarget) {
        this.withersTarget = withersTarget;
    }
}

