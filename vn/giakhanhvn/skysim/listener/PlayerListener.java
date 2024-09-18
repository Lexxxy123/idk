/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.Block
 *  net.minecraft.server.v1_8_R3.BlockPosition
 *  net.minecraft.server.v1_8_R3.Blocks
 *  net.minecraft.server.v1_8_R3.EntityArmorStand
 *  net.minecraft.server.v1_8_R3.EntityLiving
 *  net.minecraft.server.v1_8_R3.Packet
 *  net.minecraft.server.v1_8_R3.PacketPlayOutBlockAction
 *  net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy
 *  net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving
 *  net.minecraft.server.v1_8_R3.World
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.Effect
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.craftbukkit.v1_8_R3.CraftWorld
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.entity.ArmorStand
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.Damageable
 *  org.bukkit.entity.EnderDragon
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Fireball
 *  org.bukkit.entity.FishHook
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.entity.Projectile
 *  org.bukkit.entity.Skeleton
 *  org.bukkit.entity.WitherSkull
 *  org.bukkit.event.EventHandler
 *  org.bukkit.event.EventPriority
 *  org.bukkit.event.block.Action
 *  org.bukkit.event.block.BlockPlaceEvent
 *  org.bukkit.event.entity.EntityDamageByEntityEvent
 *  org.bukkit.event.entity.EntityDamageEvent
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.event.entity.EntityDamageEvent$DamageModifier
 *  org.bukkit.event.entity.EntityRegainHealthEvent
 *  org.bukkit.event.entity.EntityShootBowEvent
 *  org.bukkit.event.entity.EntityTeleportEvent
 *  org.bukkit.event.entity.ProjectileHitEvent
 *  org.bukkit.event.player.AsyncPlayerChatEvent
 *  org.bukkit.event.player.PlayerArmorStandManipulateEvent
 *  org.bukkit.event.player.PlayerChangedWorldEvent
 *  org.bukkit.event.player.PlayerCommandPreprocessEvent
 *  org.bukkit.event.player.PlayerInteractEntityEvent
 *  org.bukkit.event.player.PlayerInteractEvent
 *  org.bukkit.event.player.PlayerItemConsumeEvent
 *  org.bukkit.event.player.PlayerJoinEvent
 *  org.bukkit.event.player.PlayerLoginEvent
 *  org.bukkit.event.player.PlayerLoginEvent$Result
 *  org.bukkit.event.player.PlayerMoveEvent
 *  org.bukkit.event.player.PlayerQuitEvent
 *  org.bukkit.event.player.PlayerTeleportEvent
 *  org.bukkit.event.world.ChunkLoadEvent
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.potion.PotionEffectType
 *  org.bukkit.projectiles.ProjectileSource
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.listener;

import com.google.common.util.concurrent.AtomicDouble;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import net.minecraft.server.v1_8_R3.Block;
import net.minecraft.server.v1_8_R3.BlockPosition;
import net.minecraft.server.v1_8_R3.Blocks;
import net.minecraft.server.v1_8_R3.EntityArmorStand;
import net.minecraft.server.v1_8_R3.EntityLiving;
import net.minecraft.server.v1_8_R3.Packet;
import net.minecraft.server.v1_8_R3.PacketPlayOutBlockAction;
import net.minecraft.server.v1_8_R3.PacketPlayOutEntityDestroy;
import net.minecraft.server.v1_8_R3.PacketPlayOutSpawnEntityLiving;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.EnderDragon;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Fireball;
import org.bukkit.entity.FishHook;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.entity.Skeleton;
import org.bukkit.entity.WitherSkull;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityRegainHealthEvent;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.EntityTeleportEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerArmorStandManipulateEvent;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerLoginEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerTeleportEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.projectiles.ProjectileSource;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.Repeater;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.command.RebootServerCommand;
import vn.giakhanhvn.skysim.extra.beam.Beam;
import vn.giakhanhvn.skysim.features.dungeons.BlessingChest;
import vn.giakhanhvn.skysim.features.dungeons.Blessings;
import vn.giakhanhvn.skysim.features.dungeons.ItemChest;
import vn.giakhanhvn.skysim.features.enchantment.Enchantment;
import vn.giakhanhvn.skysim.features.enchantment.EnchantmentType;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.dungeons.watcher.Watcher;
import vn.giakhanhvn.skysim.features.entity.nms.VoidgloomSeraph;
import vn.giakhanhvn.skysim.features.item.Ability;
import vn.giakhanhvn.skysim.features.item.SBlock;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.features.item.accessory.AccessoryFunction;
import vn.giakhanhvn.skysim.features.item.armor.PrecursorEye;
import vn.giakhanhvn.skysim.features.item.bow.BowFunction;
import vn.giakhanhvn.skysim.features.item.pet.Pet;
import vn.giakhanhvn.skysim.features.item.pet.PetAbility;
import vn.giakhanhvn.skysim.features.skill.Skill;
import vn.giakhanhvn.skysim.features.slayer.SlayerQuest;
import vn.giakhanhvn.skysim.gui.PetsGUI;
import vn.giakhanhvn.skysim.gui.ProfileViewerGUI;
import vn.giakhanhvn.skysim.listener.PListener;
import vn.giakhanhvn.skysim.user.PlayerStatistics;
import vn.giakhanhvn.skysim.user.PlayerUtils;
import vn.giakhanhvn.skysim.user.TemporaryStats;
import vn.giakhanhvn.skysim.user.User;
import vn.giakhanhvn.skysim.user.UserStash;
import vn.giakhanhvn.skysim.util.EntityManager;
import vn.giakhanhvn.skysim.util.FerocityCalculation;
import vn.giakhanhvn.skysim.util.SLog;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;
import vn.giakhanhvn.skysim.util.SputnikPlayer;

public class PlayerListener
extends PListener {
    private static final Map<UUID, BowShooting> BOW_MAP = new HashMap<UUID, BowShooting>();
    private static final Map<UUID, CombatAction> COMBAT_MAP = new HashMap<UUID, CombatAction>();
    private final Map<UUID, Boolean> isNotLoaded = new HashMap<UUID, Boolean>();
    public static final Map<Player, Double> LAST_DAMAGE_DEALT = new HashMap<Player, Double>();

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent e2) {
        Player player = e2.getPlayer();
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        PlayerUtils.updateInventoryStatistics(player, statistics);
        SBlock block = SBlock.getBlock(player.getLocation().clone().subtract(0.0, 0.3, 0.0));
        if (player.getGameMode() != GameMode.SPECTATOR && e2.getTo().getY() <= -25.0) {
            User.getUser(player.getUniqueId()).kill(EntityDamageEvent.DamageCause.VOID, null);
        }
        if (block == null) {
            // empty if block
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent e2) {
        final Player player = e2.getPlayer();
        this.getIsNotLoaded().put(player.getUniqueId(), true);
        SUtil.delay(() -> {
            if (player.isOnline()) {
                SkySimEngine.getPlugin().updateServerName(player);
            }
        }, 10L);
        SUtil.delay(() -> {
            PlayerUtils.USER_SESSION_ID.put(player.getUniqueId(), UUID.randomUUID());
            PlayerUtils.COOKIE_DURATION_CACHE.remove(player.getUniqueId());
            PlayerUtils.AUTO_SLAYER.remove(player.getUniqueId());
            Repeater.SBA_MAP.remove(player.getUniqueId());
            PetsGUI.PET_SHOWN.remove(player.getUniqueId());
            User.getHash().remove(player.getUniqueId());
            player.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 1000000, 255));
            PrecursorEye.PrecursorLaser.put(player.getUniqueId(), false);
            User user = User.getUser(player.getUniqueId());
            if (!PlayerUtils.STATISTICS_CACHE.containsKey(player.getUniqueId())) {
                PlayerUtils.STATISTICS_CACHE.put(player.getUniqueId(), PlayerUtils.getStatistics(player));
            }
            for (Skill skill : Skill.getSkills()) {
                skill.onSkillUpdate(user, user.getSkillXP(skill));
            }
            user.loadCookieStatus();
            user.loadStatic();
            try {
                user.loadPlayerData();
            } catch (IOException | IllegalArgumentException e1) {
                SLog.severe("============ SKYSIM DATA LOAD ERROR ============");
                SLog.severe("Ah shit, here we go again.");
                SLog.severe(" ");
                SLog.severe("Some bullshit errors happended on this user!");
                SLog.severe("User UUID: " + user.toBukkitPlayer().getUniqueId());
                SLog.severe("User Name: " + user.toBukkitPlayer().getName());
                SLog.severe("SkySim Session ID: " + PlayerUtils.USER_SESSION_ID.get(user.toBukkitPlayer().getUniqueId()));
                SLog.severe("Stack Trace:" + e1.getMessage());
                SLog.severe("============  END OF ERROR REPORT  ============");
            }
            SputnikPlayer.BonemerangFix(player);
            SputnikPlayer.KatanasFix(player);
            user.updateInventory();
            SlayerQuest quest = user.getSlayerQuest();
            if (quest != null) {
                quest.setLastKilled(null);
            }
            final int[] counters = new int[]{0, 0};
            final ArrayList<AtomicInteger> counters2 = new ArrayList<AtomicInteger>(5);
            counters2.add(new AtomicInteger());
            new BukkitRunnable(){

                public void run() {
                    if (!player.isOnline()) {
                        this.cancel();
                        return;
                    }
                    UserStash.getStash(player.getUniqueId()).sendNotificationMessage();
                }
            }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 600L, 550L);
            new BukkitRunnable(){

                public void run() {
                    if (!player.isOnline()) {
                        if (TemporaryStats.getFromPlayer(player) != null) {
                            TemporaryStats.getFromPlayer(player).cleanUp();
                        }
                        this.cancel();
                        return;
                    }
                    Repeater.runPlayerTask(player, counters, counters2);
                    if (TemporaryStats.getFromPlayer(player) != null) {
                        TemporaryStats.getFromPlayer(player).update();
                    }
                    counters[0] = counters[0] + 1;
                    counters[1] = counters[1] + 1;
                    if (counters[0] == 3) {
                        counters[0] = 1;
                    }
                    if (counters[1] == 5) {
                        counters[1] = 1;
                    }
                }
            }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 20L);
            Pet.PetItem pet = User.getUser(player.getUniqueId()).getActivePet();
            Pet petclass = User.getUser(player.getUniqueId()).getActivePetClass();
            if (pet != null && petclass != null) {
                PetsGUI.spawnFlyingHeads(player, petclass, pet.toItem().getStack());
            }
            SUtil.delay(() -> player.setHealth(player.getMaxHealth()), 1L);
            SUtil.delay(() -> this.getIsNotLoaded().remove(player.getUniqueId()), 20L);
            SUtil.delay(() -> UserStash.getStash(player.getUniqueId()).sendNotificationMessage(), 30L);
        }, 3L);
        SUtil.delay(() -> {
            Location l2 = new Location(Bukkit.getWorld((String)"world"), -2.5, 70.0, -68.5, 180.0f, 0.0f);
            player.teleport(l2);
        }, 1L);
    }

    @EventHandler
    public void chunkLoad(ChunkLoadEvent e2) {
        for (Entity enn : e2.getChunk().getEntities()) {
            if (enn instanceof Player || enn.hasMetadata("pets") || enn.hasMetadata("specEntityObject")) continue;
            enn.remove();
        }
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent e2) {
        Player player = e2.getPlayer();
        User user = User.getUser(player.getUniqueId());
        SlayerQuest quest = user.getSlayerQuest();
        user.removeAllSlayerBosses();
        if (quest != null && quest.getXp() >= (double)quest.getType().getSpawnXP()) {
            user.failSlayerQuest();
            player.sendMessage("  " + ChatColor.RED + ChatColor.BOLD + "SLAYER QUEST FAILED!");
            player.sendMessage("   " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "\u00bb " + ChatColor.GRAY + "You need to learn how to play this game first!");
        }
        user.save();
        user.saveCookie();
        user.saveAllVanillaInstances();
        Blessings.STAT_MAP.remove(player.getUniqueId());
        PrecursorEye.PrecursorLaser.remove(player.getUniqueId());
        PlayerUtils.COOKIE_DURATION_CACHE.remove(player.getUniqueId());
        PlayerUtils.AUTO_SLAYER.remove(player.getUniqueId());
        PetsGUI.PET_SHOWN.remove(player.getUniqueId());
        PlayerUtils.COOLDOWN_MAP.remove(player.getUniqueId());
        PlayerUtils.USER_SESSION_ID.remove(player.getUniqueId());
        PlayerUtils.SOUL_EATER_MAP.remove(player.getUniqueId());
        PlayerUtils.LAST_KILLED_MAPPING.remove(player.getUniqueId());
        Repeater.PTN_CACHE.remove(user.getUuid());
        PlayerUtils.STATISTICS_CACHE.remove(user.getUuid());
        user.unload();
    }

    @EventHandler
    public void onPlayerQuit2(PlayerQuitEvent e2) {
        Player player = e2.getPlayer();
        SputnikPlayer.BonemerangFix(player);
        SputnikPlayer.KatanasFix(player);
    }

    @EventHandler
    public void onMoveWorld(PlayerChangedWorldEvent e2) {
        Player player = e2.getPlayer();
        SputnikPlayer.BonemerangFix(player);
        SputnikPlayer.KatanasFix(player);
        User.getUser(player.getUniqueId()).updateInventory();
        Pet.PetItem pet = User.getUser(player.getUniqueId()).getActivePet();
        Pet petclass = User.getUser(player.getUniqueId()).getActivePetClass();
        SUtil.delay(() -> UserStash.getStash(player.getUniqueId()).sendNotificationMessage(), 20L);
        if (pet != null && petclass != null) {
            PetsGUI.spawnFlyingHeads(player, petclass, pet.toItem().getStack());
        }
    }

    @EventHandler
    public void onEndermanMove(EntityTeleportEvent e2) {
        if (e2.getEntityType() == EntityType.ENDERMAN) {
            e2.setCancelled(true);
            Location locbf = e2.getFrom();
            e2.getEntity().teleport(locbf);
        }
    }

    @EventHandler
    public void onPlayerDeath(EntityDamageEvent e2) {
        if (!(e2.getEntity() instanceof Player)) {
            return;
        }
        if (e2 instanceof EntityDamageByEntityEvent) {
            return;
        }
        Player player = (Player)e2.getEntity();
        User user = User.getUser(player.getUniqueId());
        if (player.getHealth() + (double)SputnikPlayer.getCustomAbsorptionHP(player).intValue() - e2.getDamage() <= 0.0) {
            e2.setCancelled(true);
            user.kill(e2.getCause(), null);
            return;
        }
        user.damage(e2.getDamage(), e2.getCause(), null);
        e2.setDamage(0.0);
    }

    @EventHandler
    public void listen(PlayerInteractEntityEvent e2) {
        if (e2.getRightClicked().hasMetadata("NPC")) {
            return;
        }
        Player performer = e2.getPlayer();
        if (e2.getRightClicked() instanceof Player) {
            Player clicked = (Player)e2.getRightClicked();
            if (performer.isSneaking()) {
                Sputnik.tradeIntitize(clicked, performer);
            } else if (!performer.getWorld().getName().contains("f6")) {
                new ProfileViewerGUI(clicked).open(performer);
            }
        }
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onEntityDamage_(EntityDamageEvent e2) {
        if (!(e2.getEntity() instanceof LivingEntity)) {
            return;
        }
        if (e2.getEntity() instanceof Player) {
            return;
        }
        if (e2.getEntity() instanceof ArmorStand) {
            e2.setCancelled(true);
            return;
        }
        LivingEntity en = (LivingEntity)e2.getEntity();
        if (!(e2.getCause() != EntityDamageEvent.DamageCause.FIRE_TICK && e2.getCause() != EntityDamageEvent.DamageCause.FIRE || en.hasMetadata("SlayerBoss"))) {
            e2.setCancelled(true);
            return;
        }
        if (e2.getCause() == EntityDamageEvent.DamageCause.DROWNING && !en.hasMetadata("SlayerBoss")) {
            e2.setDamage(en.getMaxHealth() * 5.0 / 100.0);
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.DARK_AQUA);
        } else if (!(e2.getCause() != EntityDamageEvent.DamageCause.FIRE && e2.getCause() != EntityDamageEvent.DamageCause.FIRE_TICK || en.hasMetadata("SlayerBoss"))) {
            e2.setDamage(5.0);
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.GOLD);
        } else if (e2.getCause() == EntityDamageEvent.DamageCause.LAVA && !en.hasMetadata("SlayerBoss")) {
            e2.setDamage(20.0);
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.GOLD);
        } else if (e2.getCause() == EntityDamageEvent.DamageCause.CONTACT && !en.hasMetadata("SlayerBoss")) {
            e2.setDamage(5.0);
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.GRAY);
        } else if (e2.getCause() == EntityDamageEvent.DamageCause.POISON) {
            e2.setDamage(5.0);
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.DARK_GREEN);
        } else if (e2.getCause() == EntityDamageEvent.DamageCause.WITHER) {
            e2.setDamage(5.0);
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.BLACK);
        } else if (e2.getCause() == EntityDamageEvent.DamageCause.FALL) {
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.GRAY);
        }
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onEntityDamage_2(EntityDamageByEntityEvent e2) {
        if (!(e2.getEntity() instanceof LivingEntity)) {
            return;
        }
        if (e2.getEntity() instanceof Player) {
            return;
        }
        LivingEntity en = (LivingEntity)e2.getEntity();
        if (e2.getCause() == EntityDamageEvent.DamageCause.ENTITY_ATTACK) {
            if (e2.getDamager() instanceof Player) {
                return;
            }
            if (e2.getDamager() instanceof Arrow && ((Arrow)e2.getDamager()).getShooter() instanceof Player) {
                return;
            }
            PlayerListener.spawnSpecialDamageInd((Entity)en, e2.getDamage(), ChatColor.GRAY);
        }
    }

    public boolean checkArrowSource(Entity damager) {
        return !(damager instanceof Arrow) || !(((Arrow)damager).getShooter() instanceof Player);
    }

    @EventHandler(priority=EventPriority.MONITOR, ignoreCancelled=true)
    public void onTeleport(PlayerTeleportEvent event) {
    }

    @EventHandler(priority=EventPriority.HIGH)
    public void onEntityDamage(EntityDamageByEntityEvent e2) {
        SItem sItem;
        ItemStack weapon;
        Player player;
        Entity damaged = e2.getEntity();
        if (!(damaged instanceof Player) && e2.getDamager() instanceof Player) {
            Ability ability2;
            SItem sitem;
            ItemStack st;
            PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(e2.getDamager().getUniqueId());
            double atkSpeed = Math.min(100L, Math.round(statistics.getAttackSpeed().addAll()));
            if (damaged instanceof LivingEntity) {
                ((LivingEntity)damaged).setNoDamageTicks((int)Math.round(15.0 / (1.0 + atkSpeed / 100.0)));
                ((LivingEntity)damaged).setMaximumNoDamageTicks((int)Math.round(15.0 / (1.0 + atkSpeed / 100.0)));
            }
            if ((st = ((Player)e2.getDamager()).getItemInHand()) != null && (sitem = SItem.find(st)) != null && (ability2 = sitem.getType().getAbility()) != null && ability2.requirementsUse((Player)e2.getDamager(), sitem)) {
                e2.getDamager().sendMessage(Sputnik.trans(ability2.getAbilityReq()));
                e2.getEntity().getWorld().spigot().playEffect(e2.getEntity().getLocation().clone().add(0.0, 1.5, 0.0).add(e2.getEntity().getLocation().getDirection().normalize().multiply(0.2)), Effect.CRIT, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
                e2.getEntity().getWorld().spigot().playEffect(e2.getEntity().getLocation().clone().add(0.0, 1.5, 0.0).add(e2.getEntity().getLocation().getDirection().normalize().multiply(0.2)), Effect.CRIT, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
                e2.getEntity().getWorld().spigot().playEffect(e2.getEntity().getLocation().clone().add(0.0, 1.5, 0.0).add(e2.getEntity().getLocation().getDirection().normalize().multiply(0.2)), Effect.CRIT, 0, 1, 1.0f, 1.0f, 1.0f, 0.0f, 0, 64);
                e2.setCancelled(true);
                return;
            }
        }
        if (VoidgloomSeraph.HIT_SHIELD.containsKey(damaged)) {
            VoidgloomSeraph.HIT_SHIELD.put(damaged, VoidgloomSeraph.HIT_SHIELD.get(damaged) - 1);
            damaged.getWorld().playSound(damaged.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 2.0f);
        }
        if (damaged instanceof ArmorStand) {
            e2.setCancelled(true);
            return;
        }
        Entity damager = e2.getDamager();
        if (damaged instanceof LivingEntity && damager instanceof FishHook && damager.hasMetadata("owner")) {
            User.getUser(((Player)((MetadataValue)damager.getMetadata("owner").get(0)).value()).getUniqueId()).damageEntity((LivingEntity)damaged);
            return;
        }
        SEntity sEntity = null;
        if (!(damager instanceof Player)) {
            Arrow arrow;
            ProjectileSource shooter;
            Entity in = damager;
            if (in instanceof Arrow && (shooter = (arrow = (Arrow)in).getShooter()) instanceof Entity) {
                in = (Entity)shooter;
            }
            if (in instanceof WitherSkull && (shooter = (arrow = (Arrow)in).getShooter()) instanceof Entity) {
                in = (Entity)shooter;
            }
            if ((sEntity = SEntity.findSEntity(in)) != null) {
                sEntity.getFunction().onAttack(e2);
                e2.setDamage(sEntity.getStatistics().getDamageDealt());
                try {
                    e2.setDamage(EntityDamageEvent.DamageModifier.ARMOR, 0.0);
                } catch (UnsupportedOperationException unsupportedOperationException) {
                    // empty catch block
                }
            }
        }
        if (damaged instanceof Player) {
            User user;
            if (damaged.hasMetadata("NPC")) {
                return;
            }
            Player damagedPlayer = (Player)damaged;
            if (!Sputnik.HaveDMGReduction.containsKey(damagedPlayer.getUniqueId())) {
                Sputnik.HaveDMGReduction.put(damagedPlayer.getUniqueId(), false);
            }
            if (damagedPlayer.hasMetadata("frozen")) {
                Player en = damagedPlayer;
                Vector v2 = new Vector(0, 0, 0);
                SUtil.delay(() -> PlayerListener.lambda$onEntityDamage$7((Entity)en, v2), 0L);
            }
            if ((user = User.getUser(damagedPlayer.getUniqueId())) == null) {
                return;
            }
            PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(damagedPlayer.getUniqueId());
            if (statistics == null) {
                return;
            }
            double defense = statistics.getDefense().addAll();
            double trueDefense = statistics.getTrueDefense().addAll();
            if (sEntity != null && sEntity.getStatistics().dealsTrueDamage()) {
                e2.setDamage(e2.getDamage() - e2.getDamage() * (trueDefense / (trueDefense + 100.0)));
            } else {
                e2.setDamage(e2.getDamage() - e2.getDamage() * (defense / (defense + 100.0)));
            }
            if (Sputnik.HaveDMGReduction.get(damagedPlayer.getUniqueId()).booleanValue()) {
                e2.setDamage(e2.getDamage() - e2.getDamage() * 10.0 / 100.0);
            }
            if (!(e2.getDamager() instanceof Player)) {
                PlayerListener.spawnSpecialDamageInd(damaged, e2.getDamage(), ChatColor.GRAY);
                if (SputnikPlayer.getCustomAbsorptionHP(damagedPlayer) > 0) {
                    if (e2.getDamage() > (double)SputnikPlayer.getCustomAbsorptionHP(damagedPlayer).intValue()) {
                        e2.setDamage(e2.getDamage() - (double)SputnikPlayer.getCustomAbsorptionHP(damagedPlayer).intValue());
                        SputnikPlayer.setCustomAbsorptionHP(damagedPlayer, 0.0f);
                    } else {
                        SputnikPlayer.minusCustomAbsorptionHP(damagedPlayer, (float)e2.getDamage());
                        e2.setDamage(0.0);
                    }
                }
            }
            EntityDamageEvent.DamageCause cause = e2.getCause();
            if (damager instanceof Projectile && ((Projectile)damager).getShooter() instanceof Entity) {
                damager = (Entity)((Projectile)damager).getShooter();
                cause = EntityDamageEvent.DamageCause.ENTITY_ATTACK;
            }
            Pet.PetItem item = user.getActivePet();
            Pet pet = user.getActivePetClass();
            if (item != null && pet != null) {
                for (PetAbility ability3 : pet.getPetAbilities(item.toItem())) {
                    ability3.onHurt(e2, damager);
                }
            }
            try {
                e2.setDamage(EntityDamageEvent.DamageModifier.ARMOR, 0.0);
            } catch (UnsupportedOperationException unsupportedOperationException) {
                // empty catch block
            }
            if (damagedPlayer.getHealth() - e2.getDamage() <= 0.0) {
                e2.setCancelled(true);
                User.getUser(damagedPlayer.getUniqueId()).kill(cause, damager);
            }
            COMBAT_MAP.put(damagedPlayer.getUniqueId(), PlayerListener.createCombatAction(false, e2.getDamage(), e2.getDamager() instanceof Arrow, System.currentTimeMillis()));
            return;
        }
        if (!(damager instanceof Player) && !(damager instanceof Arrow)) {
            return;
        }
        float bowForceReducer = 1.0f;
        if (damager instanceof Arrow) {
            Arrow arrow = (Arrow)damager;
            ProjectileSource shooter = arrow.getShooter();
            if (!(shooter instanceof Player)) {
                return;
            }
            player = (Player)shooter;
            if (!BOW_MAP.containsKey(player.getUniqueId())) {
                return;
            }
            BowShooting shooting = BOW_MAP.get(player.getUniqueId());
            weapon = shooting.getBow();
            bowForceReducer = shooting.getForce();
            player.playSound(player.getLocation(), Sound.SUCCESSFUL_HIT, 1.0f, 1.0f);
        } else {
            player = (Player)e2.getDamager();
            weapon = player.getInventory().getItemInHand();
        }
        PlayerUtils.DamageResult result = PlayerUtils.getDamageDealt(weapon, player, damaged, damager instanceof Arrow);
        AtomicDouble finalDamage = new AtomicDouble(result.getFinalDamage() * (double)bowForceReducer);
        e2.setDamage(finalDamage.get());
        if (e2.getEntity().getType() == EntityType.ENDER_DRAGON) {
            double formula = finalDamage.get() / ((EnderDragon)e2.getEntity()).getMaxHealth() * 100.0;
            if (formula < 10.0) {
                e2.setDamage(finalDamage.get());
            } else if (formula > 10.0 && formula < 15.0) {
                e2.setDamage(finalDamage.get() * 10.0 / 100.0);
            } else if (formula > 15.0 && formula < 20.0) {
                e2.setDamage(finalDamage.get() / 100.0);
            } else if (formula > 20.0 && formula <= 25.0) {
                e2.setDamage(finalDamage.get() * 0.01 / 100.0);
            } else if (formula > 25.0) {
                e2.setDamage(finalDamage.get() * 0.0);
            } else {
                e2.setDamage(finalDamage.get());
            }
        }
        if (EntityManager.DEFENSE_PERCENTAGE.containsKey(e2.getEntity())) {
            int defensepercent = EntityManager.DEFENSE_PERCENTAGE.get(e2.getEntity());
            if (defensepercent > 100) {
                defensepercent = 100;
            }
            e2.setDamage(finalDamage.get() - finalDamage.get() * (double)defensepercent / 100.0);
        }
        if (e2.getEntity().hasMetadata("frozen")) {
            e2.setDamage(e2.getDamage() + e2.getDamage() * 10.0 / 100.0);
        }
        if ((sItem = SItem.find(weapon)) != null) {
            if (sItem.getType().getFunction() != null) {
                sItem.getType().getFunction().onDamage(damaged, player, finalDamage, sItem);
            }
            if (sItem.getType().getFunction() instanceof BowFunction && e2.getDamager() instanceof Arrow) {
                ((BowFunction)sItem.getType().getFunction()).onBowHit(damaged, player, (Arrow)e2.getDamager(), sItem, finalDamage);
            }
        }
        for (SItem accessory : PlayerUtils.getAccessories(player)) {
            if (!(accessory.getType().getFunction() instanceof AccessoryFunction)) continue;
            ((AccessoryFunction)accessory.getType().getFunction()).onDamageInInventory(sItem, player, damaged, accessory, finalDamage);
        }
        User user = User.getUser(player.getUniqueId());
        Pet pet = user.getActivePetClass();
        if (pet != null) {
            pet.runAbilities(ability -> ability.onDamage(e2), user.getActivePet());
        }
        try {
            e2.setDamage(EntityDamageEvent.DamageModifier.ARMOR, 0.0);
        } catch (UnsupportedOperationException trueDefense) {
            // empty catch block
        }
        SEntity s2 = SEntity.findSEntity(damaged);
        if (s2 != null) {
            s2.getFunction().onDamage(s2, damager, e2, finalDamage);
        }
        if (e2.isCancelled()) {
            return;
        }
        LAST_DAMAGE_DEALT.put(player, e2.getDamage());
        FerocityCalculation.activeFerocityTimes(player, (LivingEntity)damaged, (int)e2.getDamage(), result.didCritDamage());
        PlayerUtils.handleSpecEntity(damaged, player, new AtomicDouble(e2.getDamage()));
        COMBAT_MAP.put(player.getUniqueId(), PlayerListener.createCombatAction(true, e2.getDamage(), e2.getDamager() instanceof Arrow, System.currentTimeMillis()));
        Location l_ = damaged.getLocation().clone();
        PlayerListener.spawnDamageInd(damaged, e2.getDamage(), result.didCritDamage());
    }

    public static void eshortBowActive(Player p2, Entity damaged, Arrow a2) {
        SItem sItem;
        if (p2 == null) {
            return;
        }
        ItemStack weapon = p2.getInventory().getItemInHand();
        PlayerUtils.DamageResult result = PlayerUtils.getDamageDealt(weapon, p2, damaged, true);
        AtomicDouble finalDamage_ = new AtomicDouble(result.getFinalDamage());
        double finalDamage = finalDamage_.get();
        boolean crit = result.didCritDamage();
        LivingEntity le = (LivingEntity)damaged;
        if (EntityManager.DEFENSE_PERCENTAGE.containsKey(damaged)) {
            int defensepercent = EntityManager.DEFENSE_PERCENTAGE.get(damaged);
            if (defensepercent > 100) {
                defensepercent = 100;
            }
            finalDamage -= finalDamage * (double)defensepercent / 100.0;
        }
        if ((sItem = SItem.find(weapon)) != null) {
            if (sItem.getType().getFunction() != null) {
                sItem.getType().getFunction().onDamage(damaged, p2, finalDamage_, sItem);
            }
            if (sItem.getType().getFunction() instanceof BowFunction && a2 instanceof Arrow) {
                ((BowFunction)sItem.getType().getFunction()).onBowHit(damaged, p2, a2, sItem, finalDamage_);
            }
        }
        for (SItem accessory : PlayerUtils.getAccessories(p2)) {
            if (!(accessory.getType().getFunction() instanceof AccessoryFunction)) continue;
            ((AccessoryFunction)accessory.getType().getFunction()).onDamageInInventory(sItem, p2, damaged, accessory, finalDamage_);
        }
        FerocityCalculation.activeFerocityTimes(p2, (LivingEntity)damaged, (int)finalDamage, result.didCritDamage());
        User user = User.getUser(p2.getUniqueId());
        user.damageEntityBowEman((Damageable)le, finalDamage, p2, a2);
        PlayerListener.spawnDamageInd(damaged, finalDamage, crit);
    }

    public static void ferocityActive(int times, final Player p2, final double finalDMG, final Entity damaged, final Boolean crit) {
        LivingEntity le;
        if (times > 0) {
            p2.playSound(p2.getLocation(), Sound.FIRE_IGNITE, 0.4f, 0.0f);
        }
        for (int i2 = 0; i2 < times && !(le = (LivingEntity)damaged).isDead(); ++i2) {
            if (le.isDead()) {
                return;
            }
            final User user = User.getUser(p2.getUniqueId());
            new BukkitRunnable(){

                public void run() {
                    if (damaged.isDead()) {
                        return;
                    }
                    p2.playSound(p2.getLocation(), Sound.FIRE_IGNITE, 0.4f, 0.0f);
                    SUtil.delay(() -> {
                        if (damaged.isDead()) {
                            return;
                        }
                        double finalDamage = finalDMG;
                        if (EntityManager.DEFENSE_PERCENTAGE.containsKey(damaged)) {
                            int defensepercent = EntityManager.DEFENSE_PERCENTAGE.get(damaged);
                            if (defensepercent > 100) {
                                defensepercent = 100;
                            }
                            finalDamage -= finalDamage * (double)defensepercent / 100.0;
                        }
                        if (VoidgloomSeraph.HIT_SHIELD.containsKey(damaged)) {
                            VoidgloomSeraph.HIT_SHIELD.put(damaged, VoidgloomSeraph.HIT_SHIELD.get(damaged) - 1);
                            damaged.getWorld().playSound(damaged.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 2.0f);
                        }
                        Sputnik.ferocityParticle((LivingEntity)damaged);
                        PlayerListener.spawnDamageInd(damaged, finalDamage, crit);
                        p2.playSound(p2.getLocation(), Sound.IRONGOLEM_THROW, 1.0f, 1.35f);
                        user.damageEntityIgnoreShield((Damageable)damaged, finalDamage);
                    }, 10L);
                }
            }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 4L * (long)i2);
        }
    }

    @EventHandler
    public void onBoatPlace(PlayerInteractEvent event) {
        Player player;
        if (!(event.getAction() != Action.RIGHT_CLICK_AIR && event.getAction() != Action.RIGHT_CLICK_BLOCK || (player = event.getPlayer()).getItemInHand().getType() != Material.BOAT && player.getItemInHand().getType() != Material.MINECART && player.getItemInHand().getType() != Material.EYE_OF_ENDER || player.isOp())) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBowLaunch(PlayerInteractEvent e2) {
        final SItem id = SItem.find(e2.getPlayer().getItemInHand());
        if (id != null && (id.getType() == SMaterial.TERMINATOR || id.getType() == SMaterial.JUJU_SHORTBOW)) {
            BOW_MAP.put(e2.getPlayer().getUniqueId(), new BowShooting(){

                @Override
                public ItemStack getBow() {
                    return id.getStack();
                }

                @Override
                public float getForce() {
                    return 1.0f;
                }
            });
            final User user = User.getUser(e2.getPlayer().getUniqueId());
            final Player player = e2.getPlayer();
            SItem arrows = SItem.find(player.getInventory().getItem(8));
            if (arrows != null && arrows.getType() == SMaterial.QUIVER_ARROW) {
                final int save = arrows.getStack().getAmount();
                new BukkitRunnable(){

                    public void run() {
                        ItemStack last = player.getInventory().getItem(8);
                        if (last == null) {
                            user.subFromQuiver(SMaterial.ARROW);
                            player.getInventory().setItem(8, SItem.of(SMaterial.SKYBLOCK_MENU).getStack());
                            return;
                        }
                        if (save == last.getAmount()) {
                            return;
                        }
                        user.subFromQuiver(SMaterial.ARROW);
                        player.getInventory().setItem(8, SUtil.setStackAmount(SItem.of(SMaterial.QUIVER_ARROW).getStack(), Math.min(64, user.getQuiver(SMaterial.ARROW))));
                    }
                }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 1L);
            }
        }
    }

    @EventHandler
    public void onBowShoot(final EntityShootBowEvent e2) {
        SItem sItem;
        if (!(e2.getEntity() instanceof Player)) {
            return;
        }
        BOW_MAP.put(e2.getEntity().getUniqueId(), new BowShooting(){

            @Override
            public ItemStack getBow() {
                return e2.getBow();
            }

            @Override
            public float getForce() {
                return e2.getForce();
            }
        });
        final User user = User.getUser(e2.getEntity().getUniqueId());
        final Player player = (Player)e2.getEntity();
        SItem arrows = SItem.find(player.getInventory().getItem(8));
        if (arrows != null && arrows.getType() == SMaterial.QUIVER_ARROW) {
            final int save = arrows.getStack().getAmount();
            new BukkitRunnable(){

                public void run() {
                    ItemStack last = player.getInventory().getItem(8);
                    if (last == null) {
                        user.subFromQuiver(SMaterial.ARROW);
                        player.getInventory().setItem(8, SItem.of(SMaterial.SKYBLOCK_MENU).getStack());
                        return;
                    }
                    if (save == last.getAmount()) {
                        return;
                    }
                    user.subFromQuiver(SMaterial.ARROW);
                    player.getInventory().setItem(8, SUtil.setStackAmount(SItem.of(SMaterial.QUIVER_ARROW).getStack(), Math.min(64, user.getQuiver(SMaterial.ARROW))));
                }
            }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 1L);
        }
        if ((sItem = SItem.find(e2.getBow())) != null) {
            Enchantment aiming = sItem.getEnchantment(EnchantmentType.AIMING);
            SUtil.markAimingArrow((Projectile)e2.getProjectile(), aiming);
            if (sItem.getType().getFunction() instanceof BowFunction) {
                ((BowFunction)sItem.getType().getFunction()).onBowShoot(sItem, e2);
            }
        }
    }

    @EventHandler
    public void onArmorStandChange(PlayerArmorStandManipulateEvent e2) {
        e2.setCancelled(true);
    }

    @EventHandler
    public void onTeleport(PlayerChangedWorldEvent e2) {
        User user = User.getUser(e2.getPlayer().getUniqueId());
        if (user == null) {
            return;
        }
        TemporaryStats ts = null;
        TemporaryStats temporaryStats = ts = TemporaryStats.getFromPlayer(user.toBukkitPlayer()) != null ? TemporaryStats.getFromPlayer(user.toBukkitPlayer()) : new TemporaryStats(User.getUser(user.toBukkitPlayer().getUniqueId()));
        if (TemporaryStats.getFromPlayer(user.toBukkitPlayer()) != null) {
            ts.cleanStats();
        }
        SlayerQuest quest = user.getSlayerQuest();
        user.saveAllVanillaInstances();
        if (quest != null && quest.getXp() >= (double)quest.getType().getSpawnXP() && quest.getKilled() == 0L) {
            User.getUser(e2.getPlayer().getUniqueId()).failSlayerQuest();
        }
    }

    @EventHandler(priority=EventPriority.HIGHEST)
    public void onPlayerChat(AsyncPlayerChatEvent e2) {
        Player plr = e2.getPlayer();
        Set recipients = e2.getRecipients();
        for (Player p2 : Bukkit.getServer().getOnlinePlayers()) {
            if (p2.getWorld().getName().equals(plr.getWorld().getName())) continue;
            recipients.remove(p2);
        }
        if (e2.getMessage().toLowerCase().contains("${")) {
            e2.setCancelled(true);
            e2.getPlayer().sendMessage(ChatColor.RED + "This message is blocked!");
            e2.getPlayer().sendMessage(ChatColor.RED + "Listen kiddo, it wont work anymore.");
        }
    }

    @EventHandler
    public void placeBlockEvent(PlayerInteractEvent e2) {
        Player player = e2.getPlayer();
        org.bukkit.block.Block b2 = e2.getClickedBlock();
        Map<org.bukkit.block.Block, BlessingChest> map = BlessingChest.CHEST_CACHE;
        if (b2 == null) {
            return;
        }
        if (b2.getType() != Material.CHEST) {
            return;
        }
        if (!map.containsKey(b2)) {
            return;
        }
        if (player.isSneaking() && e2.getAction() == Action.LEFT_CLICK_BLOCK && player.isOp()) {
            e2.setCancelled(true);
            map.get(b2).destroy();
            player.sendMessage("removed");
            return;
        }
        if (e2.getAction() != Action.RIGHT_CLICK_BLOCK) {
            e2.setCancelled(true);
            return;
        }
        e2.setCancelled(true);
        BlessingChest be2 = map.get(b2);
        if (!be2.isOpened() && !be2.isLocked()) {
            Location chestLocation = b2.getLocation();
            BlockPosition pos = new BlockPosition(chestLocation.getBlockX(), chestLocation.getBlockY(), chestLocation.getBlockZ());
            PacketPlayOutBlockAction packet = new PacketPlayOutBlockAction(pos, (Block)Blocks.CHEST, 1, 1);
            chestLocation.getWorld().playSound(chestLocation, Sound.CHEST_OPEN, 1.0f, 1.0f);
            for (Player p2 : chestLocation.getWorld().getPlayers()) {
                ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
            }
        }
        be2.open(player);
    }

    @EventHandler
    public void placeBlockEventTwo(PlayerInteractEvent e2) {
        Player player = e2.getPlayer();
        org.bukkit.block.Block b2 = e2.getClickedBlock();
        Map<org.bukkit.block.Block, ItemChest> map = ItemChest.ITEM_CHEST_CACHE;
        if (b2 == null) {
            return;
        }
        if (b2.getType() != Material.CHEST) {
            return;
        }
        if (!map.containsKey(b2)) {
            return;
        }
        if (player.isSneaking() && e2.getAction() == Action.LEFT_CLICK_BLOCK && player.isOp()) {
            e2.setCancelled(true);
            map.get(b2).destroy();
            player.sendMessage("removed");
            return;
        }
        if (e2.getAction() != Action.RIGHT_CLICK_BLOCK) {
            e2.setCancelled(true);
            return;
        }
        e2.setCancelled(true);
        ItemChest be2 = map.get(b2);
        if (!be2.isOpened() && !be2.isLocked()) {
            Location chestLocation = b2.getLocation();
            BlockPosition pos = new BlockPosition(chestLocation.getBlockX(), chestLocation.getBlockY(), chestLocation.getBlockZ());
            PacketPlayOutBlockAction packet = new PacketPlayOutBlockAction(pos, (Block)Blocks.CHEST, 1, 1);
            chestLocation.getWorld().playSound(chestLocation, Sound.CHEST_OPEN, 1.0f, 1.0f);
            for (Player p2 : chestLocation.getWorld().getPlayers()) {
                ((CraftPlayer)p2).getHandle().playerConnection.sendPacket((Packet)packet);
            }
        }
        be2.open(player);
    }

    @EventHandler
    public void onPlayerAsyncCommand(PlayerCommandPreprocessEvent e2) {
        if (this.isNotLoaded.containsKey(e2.getPlayer().getUniqueId())) {
            e2.setCancelled(true);
            e2.getPlayer().sendMessage(ChatColor.RED + "Your instance haven't been intitized yet, please wait!");
        }
        if (RebootServerCommand.secondMap.containsKey(Bukkit.getServer()) && (e2.getMessage().contains("pv") || e2.getMessage().contains("auction"))) {
            e2.setCancelled(true);
            e2.getPlayer().sendMessage(ChatColor.RED + "The server is restarting! You cannot do this!");
        }
    }

    public static String replaceChatColors(String s2) {
        for (ChatColor c2 : ChatColor.values()) {
            s2 = s2.replaceAll("&" + c2.getChar(), String.valueOf(s2) + ChatColor.getByChar((char)c2.getChar()));
        }
        return s2;
    }

    @EventHandler(priority=EventPriority.MONITOR)
    public void onJoin(PlayerLoginEvent event) {
        if (!event.getPlayer().isWhitelisted() && Bukkit.hasWhitelist()) {
            String message = "&cWe are sorry but SkySim Network BETA is currently down for maintenance.\n\n&cFor more information: &bhttps://discord.skysim.sbs\n&c";
            message = ChatColor.translateAlternateColorCodes((char)'&', (String)message);
            message = message.replaceAll("&p", event.getPlayer().getName());
            event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, message);
        }
    }

    @EventHandler
    public void onPotionDrink(PlayerItemConsumeEvent e2) {
        SItem sItem = SItem.find(e2.getItem());
        if (sItem == null) {
            return;
        }
        if (sItem.getType() != SMaterial.WATER_BOTTLE) {
            return;
        }
        e2.setCancelled(true);
        List<vn.giakhanhvn.skysim.features.potion.PotionEffect> effects = sItem.getPotionEffects();
        User user = User.getUser(e2.getPlayer().getUniqueId());
        for (vn.giakhanhvn.skysim.features.potion.PotionEffect effect : effects) {
            user.removePotionEffect(effect.getType());
            PlayerUtils.updatePotionEffects(user, PlayerUtils.STATISTICS_CACHE.get(user.getUuid()));
            if (effect.getType().getOnDrink() != null) {
                effect.getType().getOnDrink().accept(effect, e2.getPlayer());
            }
            user.addPotionEffect(effect);
            e2.getPlayer().sendMessage((effect.getType().isBuff() ? ChatColor.GREEN + "" + ChatColor.BOLD + "BUFF!" : ChatColor.RED + "" + ChatColor.BOLD + "DEBUFF!") + ChatColor.RESET + ChatColor.WHITE + " You have gained " + effect.getDisplayName() + ChatColor.WHITE + "!");
        }
        if (e2.getPlayer().getGameMode() != GameMode.CREATIVE && e2.getPlayer().getGameMode() != GameMode.SPECTATOR) {
            e2.getPlayer().setItemInHand(SItem.of(SMaterial.GLASS_BOTTLE).getStack());
        }
    }

    @EventHandler
    public void onMilkDrink(PlayerItemConsumeEvent e2) {
        SItem sItem = SItem.find(e2.getItem());
        if (sItem == null) {
            return;
        }
        if (sItem.getType() != SMaterial.MILK_BUCKET) {
            return;
        }
        e2.setCancelled(true);
        User user = User.getUser(e2.getPlayer().getUniqueId());
        user.clearPotionEffects();
        e2.getPlayer().sendMessage(ChatColor.GREEN + "You have cleared all your active effects.");
        if (e2.getPlayer().getGameMode() != GameMode.CREATIVE && e2.getPlayer().getGameMode() != GameMode.SPECTATOR) {
            e2.getPlayer().setItemInHand(SItem.of(SMaterial.BUCKET).getStack());
        }
    }

    @EventHandler
    public void onProjectileHit(final ProjectileHitEvent e2) {
        if (e2.getEntity() instanceof Arrow) {
            new BukkitRunnable(){

                public void run() {
                    e2.getEntity().remove();
                }
            }.runTaskLater((Plugin)SkySimEngine.getPlugin(), 10L);
            return;
        }
        if (e2.getEntity() instanceof Fireball && (e2.getEntity().hasMetadata("dragon") || e2.getEntity().hasMetadata("magma"))) {
            String type = e2.getEntity().hasMetadata("dragon") ? "dragon" : "magma";
            SEntity sEntity = (SEntity)((MetadataValue)e2.getEntity().getMetadata(type).get(0)).value();
            e2.getEntity().getWorld().playEffect(e2.getEntity().getLocation(), Effect.EXPLOSION_HUGE, (Object)Effect.EXPLOSION_HUGE.getData());
            e2.getEntity().getWorld().playSound(e2.getEntity().getLocation(), Sound.EXPLODE, 5.0f, 0.0f);
            for (Entity entity : e2.getEntity().getNearbyEntities(2.0, 2.0, 2.0)) {
                if (!(entity instanceof LivingEntity)) continue;
                int d2 = type.equals("dragon") ? SUtil.random(292, 713) : 125;
                int n2 = d2;
                if (entity instanceof Player) {
                    User.getUser(entity.getUniqueId()).damage(d2, EntityDamageEvent.DamageCause.ENTITY_ATTACK, (Entity)sEntity.getEntity());
                } else {
                    ((LivingEntity)entity).damage((double)d2);
                }
                if (!type.equals("dragon")) continue;
                entity.sendMessage(ChatColor.DARK_PURPLE + "\u262c " + ChatColor.RED + sEntity.getStatistics().getEntityName() + ChatColor.LIGHT_PURPLE + " used " + ChatColor.YELLOW + "Fireball" + ChatColor.LIGHT_PURPLE + " on you for " + ChatColor.RED + d2 + " damage.");
            }
        }
    }

    public static CombatAction getLastCombatAction(Player player) {
        return COMBAT_MAP.get(player.getUniqueId());
    }

    private static CombatAction createCombatAction(final boolean attacked, final double damage, final boolean bowShot, final long timestamp) {
        return new CombatAction(){

            @Override
            public boolean attacked() {
                return attacked;
            }

            @Override
            public double getDamageDealt() {
                return damage;
            }

            @Override
            public boolean isBowShot() {
                return bowShot;
            }

            @Override
            public long getTimeStamp() {
                return timestamp;
            }
        };
    }

    @EventHandler
    public void onEntityDamage1(EntityDamageByEntityEvent event) {
        if (event.getEntity().hasMetadata("GiantSword")) {
            event.setCancelled(true);
        }
    }

    public static Double COGCalculation(Integer baseDmg, Player player) {
        User user = User.getUser(player.getUniqueId());
        long coin = user.getCoins();
        if (coin > (long)baseDmg.intValue()) {
            user.subCoins(baseDmg.intValue());
            Sputnik.CoinsTakenOut.put(player.getUniqueId(), baseDmg);
            if (Sputnik.CoinsTakenOut.containsKey(player.getUniqueId())) {
                SUtil.delay(() -> Sputnik.CoinsTakenOut.remove(player.getUniqueId()), 35L);
            }
            return (double)baseDmg.intValue() * 25.0 / 100.0;
        }
        return 0.0;
    }

    @EventHandler
    public void onHeal(EntityRegainHealthEvent event) {
        if (!(event.getEntity() instanceof EnderDragon)) {
            return;
        }
        event.setCancelled(true);
        EnderDragon drag = (EnderDragon)event.getEntity();
        int addamount = SUtil.random(15000, 35000);
        if (drag.getHealth() + (double)addamount < drag.getMaxHealth()) {
            drag.setHealth(drag.getHealth() + (double)addamount);
        } else {
            drag.setHealth(drag.getHealth() + (drag.getMaxHealth() - drag.getHealth()));
        }
    }

    @EventHandler
    void onInteract(PlayerInteractEntityEvent e2) {
        if (e2.getRightClicked().getType() == EntityType.ENDER_CRYSTAL) {
            e2.setCancelled(true);
        }
    }

    public void onCrystalDMG(World world, Player player) {
        for (Entity e2 : world.getEntities()) {
            if (e2.getType() != EntityType.ENDER_DRAGON) continue;
            User user = User.getUser(player.getUniqueId());
            user.damageEntity((Damageable)e2, 2000.0);
        }
    }

    @EventHandler
    void onHit(EntityShootBowEvent e2) {
        if (e2.getEntity() instanceof Skeleton && e2.getEntity().hasMetadata("SkeletonMaster")) {
            e2.setCancelled(true);
            WitherSkull skull = (WitherSkull)e2.getEntity().launchProjectile(WitherSkull.class);
            skull.setShooter((ProjectileSource)e2.getEntity());
            e2.getEntity().getWorld().playSound(e2.getEntity().getLocation(), Sound.WITHER_SHOOT, 1.0f, 1.0f);
        }
    }

    @EventHandler
    void onHit(EntityDamageByEntityEvent e2) {
        if (e2.getDamager() instanceof Player && e2.getEntity().getType() == EntityType.ENDER_CRYSTAL) {
            if (!e2.getEntity().getWorld().getName().toLowerCase().contains("dragon")) {
                e2.setCancelled(true);
                return;
            }
            e2.setCancelled(true);
            Location loc = e2.getEntity().getLocation();
            e2.getEntity().getWorld().playEffect(e2.getEntity().getLocation(), Effect.EXPLOSION_HUGE, 3);
            e2.getEntity().getWorld().playSound(e2.getEntity().getLocation(), Sound.EXPLODE, 3.0f, 1.0f);
            SUtil.broadcastExcept(ChatColor.translateAlternateColorCodes((char)'&', (String)("&5\u262c &a" + e2.getDamager().getName() + " &dhas destroyed an &5Ender Crystal&d!")), (Player)e2.getDamager());
            e2.getDamager().sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&5\u262c &dYou destroyed an &5Ender Crystal&d!"));
            e2.getEntity().remove();
            ItemStack cf = SItem.of(SMaterial.CRYSTAL_FRAGMENT).getStack();
            this.onCrystalDMG(e2.getDamager().getWorld(), (Player)e2.getDamager());
            SItem sitem = SItem.find(((Player)e2.getDamager()).getItemInHand());
            if (sitem != null) {
                if (sitem.getEnchantment(EnchantmentType.TELEKINESIS) != null && !Sputnik.isFullInv((Player)e2.getDamager()) && sitem.getType() != SMaterial.ENCHANTED_BOOK) {
                    Sputnik.GiveItem(cf, (Player)e2.getDamager());
                } else {
                    e2.getEntity().getWorld().dropItem(loc, cf);
                }
            } else {
                e2.getEntity().getWorld().dropItem(loc, cf);
            }
        } else if (e2.getDamager() instanceof Arrow && e2.getEntity().getType() == EntityType.ENDER_CRYSTAL) {
            Projectile p2 = (Projectile)e2.getDamager();
            if (!(p2.getShooter() instanceof Player)) {
                return;
            }
            e2.setCancelled(true);
            Location loc = e2.getEntity().getLocation();
            e2.getEntity().getWorld().playEffect(e2.getEntity().getLocation(), Effect.EXPLOSION_HUGE, 3);
            e2.getEntity().getWorld().playSound(e2.getEntity().getLocation(), Sound.EXPLODE, 3.0f, 1.0f);
            SUtil.broadcastExcept(ChatColor.translateAlternateColorCodes((char)'&', (String)("&5\u262c &a" + ((Player)p2.getShooter()).getName() + " &dhas destroyed an &5Ender Crystal&d!")), (Player)p2.getShooter());
            ((Player)p2.getShooter()).sendMessage(ChatColor.translateAlternateColorCodes((char)'&', (String)"&5\u262c &dYou destroyed an &5Ender Crystal&d!"));
            e2.getEntity().remove();
            ItemStack cf = SItem.of(SMaterial.CRYSTAL_FRAGMENT).getStack();
            this.onCrystalDMG(e2.getEntity().getWorld(), (Player)p2.getShooter());
            SItem sitem = SItem.find(((Player)p2.getShooter()).getItemInHand());
            if (sitem != null) {
                if (sitem.getEnchantment(EnchantmentType.TELEKINESIS) != null && !Sputnik.isFullInv((Player)p2.getShooter()) && sitem.getType() != SMaterial.ENCHANTED_BOOK) {
                    Sputnik.GiveItem(cf, (Player)p2.getShooter());
                } else {
                    e2.getEntity().getWorld().dropItem(loc, cf);
                }
            } else {
                e2.getEntity().getWorld().dropItem(loc, cf);
            }
        }
    }

    public static void spawnDamageInd(final Entity damaged, double damage, boolean isCrit) {
        if (damaged.hasMetadata("Dimoon")) {
            return;
        }
        Location l_ = damaged.getLocation().clone();
        l_.add(SUtil.random(-1.5, 1.5), 2.0, SUtil.random(-1.5, 1.5));
        final EntityArmorStand stand = new EntityArmorStand((net.minecraft.server.v1_8_R3.World)((CraftWorld)damaged.getWorld()).getHandle());
        stand.setLocation(l_.getX(), l_.getY(), l_.getZ(), 0.0f, 0.0f);
        ((ArmorStand)stand.getBukkitEntity()).setMarker(true);
        stand.setCustomName(isCrit ? SUtil.rainbowize("\u2727" + (int)damage + "\u2727") : "" + ChatColor.GRAY + (int)damage);
        stand.setCustomNameVisible(true);
        stand.setGravity(false);
        stand.setInvisible(true);
        final ArrayList prp = new ArrayList();
        new BukkitRunnable(){

            public void run() {
                PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving)stand);
                for (Entity e2 : damaged.getNearbyEntities(12.0, 12.0, 12.0)) {
                    if (!(e2 instanceof Player)) continue;
                    ((CraftPlayer)e2).getHandle().playerConnection.sendPacket((Packet)packet);
                    prp.add((Player)e2);
                }
            }
        }.runTaskAsynchronously((Plugin)SkySimEngine.getPlugin());
        new BukkitRunnable(){

            public void run() {
                PacketPlayOutEntityDestroy pa = new PacketPlayOutEntityDestroy(new int[]{stand.getId()});
                for (Player e2 : prp) {
                    if (e2 == null) continue;
                    ((CraftPlayer)e2).getHandle().playerConnection.sendPacket((Packet)pa);
                }
            }
        }.runTaskLaterAsynchronously((Plugin)SkySimEngine.getPlugin(), 30L);
    }

    public static void spawnSpecialDamageInd(final Entity damaged, double damage, ChatColor c2) {
        Location l_ = damaged.getLocation().clone();
        l_.add(SUtil.random(-1.5, 1.5), 1.0, SUtil.random(-1.5, 1.5));
        final EntityArmorStand stand = new EntityArmorStand((net.minecraft.server.v1_8_R3.World)((CraftWorld)damaged.getWorld()).getHandle());
        stand.setLocation(l_.getX(), l_.getY(), l_.getZ(), 0.0f, 0.0f);
        ((ArmorStand)stand.getBukkitEntity()).setMarker(true);
        stand.setCustomName(c2 + String.valueOf((int)Math.round(damage)));
        stand.setCustomNameVisible(true);
        stand.setGravity(false);
        stand.setInvisible(true);
        final ArrayList prp = new ArrayList();
        new BukkitRunnable(){

            public void run() {
                PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving)stand);
                for (Entity e2 : damaged.getNearbyEntities(12.0, 12.0, 12.0)) {
                    if (!(e2 instanceof Player)) continue;
                    ((CraftPlayer)e2).getHandle().playerConnection.sendPacket((Packet)packet);
                    prp.add((Player)e2);
                }
            }
        }.runTaskAsynchronously((Plugin)SkySimEngine.getPlugin());
        new BukkitRunnable(){

            public void run() {
                PacketPlayOutEntityDestroy pa = new PacketPlayOutEntityDestroy(new int[]{stand.getId()});
                for (Player e2 : prp) {
                    if (e2 == null) continue;
                    ((CraftPlayer)e2).getHandle().playerConnection.sendPacket((Packet)pa);
                }
            }
        }.runTaskLaterAsynchronously((Plugin)SkySimEngine.getPlugin(), 30L);
    }

    public static void customDMGIND(final Entity damaged, String text) {
        Location l_ = damaged.getLocation().clone();
        l_.add(SUtil.random(-1.5, 1.5), 1.0, SUtil.random(-1.5, 1.5));
        final EntityArmorStand stand = new EntityArmorStand((net.minecraft.server.v1_8_R3.World)((CraftWorld)damaged.getWorld()).getHandle());
        stand.setLocation(l_.getX(), l_.getY(), l_.getZ(), 0.0f, 0.0f);
        ((ArmorStand)stand.getBukkitEntity()).setMarker(true);
        stand.setCustomName(text);
        stand.setCustomNameVisible(true);
        stand.setGravity(false);
        stand.setInvisible(true);
        final ArrayList prp = new ArrayList();
        new BukkitRunnable(){

            public void run() {
                PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving)stand);
                for (Entity e2 : damaged.getNearbyEntities(12.0, 12.0, 12.0)) {
                    if (!(e2 instanceof Player)) continue;
                    ((CraftPlayer)e2).getHandle().playerConnection.sendPacket((Packet)packet);
                    prp.add((Player)e2);
                }
            }
        }.runTaskAsynchronously((Plugin)SkySimEngine.getPlugin());
        new BukkitRunnable(){

            public void run() {
                PacketPlayOutEntityDestroy pa = new PacketPlayOutEntityDestroy(new int[]{stand.getId()});
                for (Player e2 : prp) {
                    if (e2 == null) continue;
                    ((CraftPlayer)e2).getHandle().playerConnection.sendPacket((Packet)pa);
                }
            }
        }.runTaskLaterAsynchronously((Plugin)SkySimEngine.getPlugin(), 30L);
    }

    @EventHandler
    public void onChunkLoad(ChunkLoadEvent e2) {
        for (Entity en : e2.getChunk().getEntities()) {
            if (!en.hasMetadata("pets")) continue;
            en.remove();
        }
    }

    @EventHandler
    public void watcherMobsDamage(EntityDamageEvent ev) {
        if (!ev.getEntity().hasMetadata("WATCHER_E")) {
            return;
        }
        if (((LivingEntity)ev.getEntity()).getHealth() - ev.getFinalDamage() <= 0.0) {
            Watcher watcher = Watcher.getWatcher(ev.getEntity().getWorld());
            if (watcher == null) {
                return;
            }
            --watcher.currentMobsCount;
            if (SUtil.random(0, 1) == 0) {
                watcher.sd(watcher.mobDeathConvs[SUtil.random(0, watcher.mobDeathConvs.length - 1)], 0, 50, true);
            }
        }
    }

    @EventHandler
    public void watcherDamage(final EntityDamageByEntityEvent ev) {
        Watcher watcher = Watcher.getWatcher(ev.getEntity().getWorld());
        if (watcher == null) {
            return;
        }
        if (watcher.welcomeParticles) {
            return;
        }
        if (!ev.getEntity().hasMetadata("WATCHER_M")) {
            return;
        }
        ev.setCancelled(true);
        watcher.sd(watcher.watcherAttack[SUtil.random(0, watcher.watcherAttack.length - 1)], 0, 50, true);
        if (!Watcher.getWatcher((World)ev.getEntity().getWorld()).isResting) {
            return;
        }
        if (Watcher.random(0, 2) == 1 && (ev.getDamager() instanceof Player || ev.getDamager() instanceof Arrow)) {
            Player p2 = null;
            p2 = ev.getDamager() instanceof Player ? (Player)ev.getDamager() : (Player)((Arrow)ev.getDamager()).getShooter();
            User.getUser(p2.getUniqueId()).damage(p2.getMaxHealth() / 10.0, EntityDamageEvent.DamageCause.CUSTOM, ev.getEntity());
            final Beam beam = new Beam(ev.getEntity().getLocation().clone().add(0.0, 1.3, 0.0), p2.getLocation().clone().add(0.0, 1.0, 0.0));
            p2.damage(1.0E-5);
            beam.start();
            final Player p1 = p2;
            new BukkitRunnable(){
                int i = 0;

                public void run() {
                    if (this.i >= 20 || !Watcher.getWatcher((World)ev.getEntity().getWorld()).isResting) {
                        beam.stop();
                        this.cancel();
                        return;
                    }
                    ++this.i;
                    beam.setStartingPosition(ev.getEntity().getLocation().clone().add(0.0, 1.3, 0.0));
                    beam.setEndingPosition(p1.getLocation().clone().add(0.0, 1.0, 0.0));
                    beam.update();
                }
            }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
        }
    }

    @EventHandler
    public void ans(BlockPlaceEvent e2) {
        if (e2.getPlayer().getWorld().getName().contains("arena") && e2.getPlayer().getGameMode() != GameMode.CREATIVE) {
            e2.setCancelled(true);
        }
    }

    @EventHandler
    public void swingSword(PlayerInteractEvent e2) {
        Player p2 = e2.getPlayer();
        if (User.getUser(p2.getUniqueId()) == null) {
            return;
        }
        if (SItem.find(p2.getItemInHand()) == null) {
            return;
        }
        if (SItem.find(p2.getItemInHand()).getType() != SMaterial.HIDDEN_REVANTUS_SWORD) {
            return;
        }
        if (e2.getAction() == Action.LEFT_CLICK_AIR) {
            Location playerLocation = e2.getPlayer().getEyeLocation();
            Location entityTargetLocation = e2.getPlayer().getEyeLocation().clone().add(playerLocation.getDirection().normalize().multiply(7));
            Vector vector = playerLocation.clone().toVector().subtract(entityTargetLocation.clone().toVector());
            int count = 60;
            for (int i2 = 1; i2 <= count; ++i2) {
                Entity[] clt;
                Location nl = entityTargetLocation.clone().add(vector.clone().multiply((double)i2 / (double)count));
                Collection el = nl.getWorld().getNearbyEntities(nl, 0.15, 0.15, 0.15);
                for (Entity en : clt = el.toArray(new Entity[el.size()])) {
                    if (en instanceof Player || !(en instanceof LivingEntity) || en.isDead() || en.hasMetadata("GiantSword") || en.hasMetadata("NPC") || en instanceof ArmorStand || en.getLocation().distance(e2.getPlayer().getLocation()) <= 3.0) continue;
                    Object[] atp = Sputnik.calculateDamage(p2, p2, p2.getItemInHand(), (LivingEntity)en, false);
                    double finalDamage1 = ((Float)atp[0]).floatValue();
                    PlayerListener.spawnDamageInd(en, ((Float)atp[2]).floatValue(), (Boolean)atp[1]);
                    FerocityCalculation.activeFerocityTimes(p2, (LivingEntity)en, (int)finalDamage1, (Boolean)atp[1]);
                    User.getUser(p2.getUniqueId()).damageEntity((Damageable)en, finalDamage1);
                    return;
                }
            }
        }
    }

    public Map<UUID, Boolean> getIsNotLoaded() {
        return this.isNotLoaded;
    }

    private static void lambda$onEntityDamage$7(Entity en, Vector v2) {
        en.setVelocity(v2);
    }

    public static interface CombatAction {
        public boolean attacked();

        public double getDamageDealt();

        public boolean isBowShot();

        public long getTimeStamp();
    }

    private static interface BowShooting {
        public ItemStack getBow();

        public float getForce();
    }
}

