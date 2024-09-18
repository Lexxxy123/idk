/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.md_5.bungee.api.chat.BaseComponent
 *  net.md_5.bungee.api.chat.ClickEvent
 *  net.md_5.bungee.api.chat.ClickEvent$Action
 *  net.md_5.bungee.api.chat.HoverEvent
 *  net.md_5.bungee.api.chat.HoverEvent$Action
 *  net.md_5.bungee.api.chat.TextComponent
 *  net.minecraft.server.v1_8_R3.EntityHuman
 *  net.minecraft.server.v1_8_R3.EntityPlayer
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 *  org.bukkit.GameMode
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.World
 *  org.bukkit.block.Block
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity
 *  org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer
 *  org.bukkit.entity.Arrow
 *  org.bukkit.entity.Damageable
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.HumanEntity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.entity.Player
 *  org.bukkit.event.entity.EntityDamageEvent$DamageCause
 *  org.bukkit.inventory.Inventory
 *  org.bukkit.inventory.ItemStack
 *  org.bukkit.inventory.PlayerInventory
 *  org.bukkit.metadata.MetadataValue
 *  org.bukkit.plugin.Plugin
 *  org.bukkit.potion.PotionEffect
 *  org.bukkit.scheduler.BukkitRunnable
 *  org.bukkit.scheduler.BukkitTask
 *  org.bukkit.util.Vector
 */
package vn.giakhanhvn.skysim.user;

import com.google.common.util.concurrent.AtomicDouble;
import de.tr7zw.nbtapi.NBTItem;
import java.io.File;
import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.stream.Collectors;
import net.md_5.bungee.api.chat.BaseComponent;
import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.HoverEvent;
import net.md_5.bungee.api.chat.TextComponent;
import net.minecraft.server.v1_8_R3.EntityHuman;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftHumanEntity;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.metadata.MetadataValue;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import vn.giakhanhvn.skysim.Repeater;
import vn.giakhanhvn.skysim.SkySimEngine;
import vn.giakhanhvn.skysim.api.serializer.ItemStackSerializer;
import vn.giakhanhvn.skysim.config.Config;
import vn.giakhanhvn.skysim.features.auction.AuctionBid;
import vn.giakhanhvn.skysim.features.auction.AuctionEscrow;
import vn.giakhanhvn.skysim.features.auction.AuctionItem;
import vn.giakhanhvn.skysim.features.collection.ItemCollection;
import vn.giakhanhvn.skysim.features.collection.ItemCollectionReward;
import vn.giakhanhvn.skysim.features.collection.ItemCollectionRewards;
import vn.giakhanhvn.skysim.features.dungeons.ItemSerial;
import vn.giakhanhvn.skysim.features.enchantment.Enchantment;
import vn.giakhanhvn.skysim.features.enchantment.EnchantmentType;
import vn.giakhanhvn.skysim.features.entity.SEntity;
import vn.giakhanhvn.skysim.features.entity.dungeons.boss.sadan.SadanFunction;
import vn.giakhanhvn.skysim.features.entity.dungeons.boss.sadan.SadanHuman;
import vn.giakhanhvn.skysim.features.entity.nms.VoidgloomSeraph;
import vn.giakhanhvn.skysim.features.item.GenericItemType;
import vn.giakhanhvn.skysim.features.item.PlayerBoostStatistics;
import vn.giakhanhvn.skysim.features.item.SItem;
import vn.giakhanhvn.skysim.features.item.SMaterial;
import vn.giakhanhvn.skysim.features.item.pet.Pet;
import vn.giakhanhvn.skysim.features.potion.ActivePotionEffect;
import vn.giakhanhvn.skysim.features.potion.PotionEffectType;
import vn.giakhanhvn.skysim.features.reforge.Reforge;
import vn.giakhanhvn.skysim.features.reforge.ReforgeType;
import vn.giakhanhvn.skysim.features.region.Region;
import vn.giakhanhvn.skysim.features.skill.ArcherSkill;
import vn.giakhanhvn.skysim.features.skill.BerserkSkill;
import vn.giakhanhvn.skysim.features.skill.CatacombsSkill;
import vn.giakhanhvn.skysim.features.skill.CombatSkill;
import vn.giakhanhvn.skysim.features.skill.EnchantingSkill;
import vn.giakhanhvn.skysim.features.skill.FarmingSkill;
import vn.giakhanhvn.skysim.features.skill.ForagingSkill;
import vn.giakhanhvn.skysim.features.skill.HealerSkill;
import vn.giakhanhvn.skysim.features.skill.MageSkill;
import vn.giakhanhvn.skysim.features.skill.MiningSkill;
import vn.giakhanhvn.skysim.features.skill.Skill;
import vn.giakhanhvn.skysim.features.skill.TankSkill;
import vn.giakhanhvn.skysim.features.slayer.SlayerBossType;
import vn.giakhanhvn.skysim.features.slayer.SlayerQuest;
import vn.giakhanhvn.skysim.gui.PetsGUI;
import vn.giakhanhvn.skysim.listener.PlayerListener;
import vn.giakhanhvn.skysim.user.AuctionSettings;
import vn.giakhanhvn.skysim.user.PlayerStatistics;
import vn.giakhanhvn.skysim.user.PlayerUtils;
import vn.giakhanhvn.skysim.util.EntityManager;
import vn.giakhanhvn.skysim.util.SLog;
import vn.giakhanhvn.skysim.util.SUtil;
import vn.giakhanhvn.skysim.util.Sputnik;
import vn.giakhanhvn.skysim.util.SputnikPlayer;

public class User {
    public static final int ISLAND_SIZE = 125;
    private static final Map<UUID, User> USER_CACHE = new HashMap<UUID, User>();
    private static final SkySimEngine plugin = SkySimEngine.getPlugin();
    private static final File USER_FOLDER = new File(plugin.getDataFolder(), "./users");
    private long sadancollections;
    private long totalfloor6run;
    private UUID uuid;
    private final Config config;
    private final Map<ItemCollection, Integer> collections;
    private long coins;
    private long bits;
    private long bankCoins;
    private List<ItemStack> stashedItems = new ArrayList<ItemStack>();
    private int cooldownAltar = 0;
    private boolean headShot = false;
    private boolean playingSong = false;
    private boolean inDanger = false;
    private Double islandX;
    private Double islandZ;
    private Region lastRegion;
    private final Map<SMaterial, Integer> quiver;
    private final List<ActivePotionEffect> effects;
    private double farmingXP;
    private boolean boneToZeroDamage = false;
    private boolean cooldownAPI = false;
    private double miningXP;
    private double combatXP;
    private double enchantXP;
    private double archerXP;
    private double cataXP;
    private double berserkXP;
    private double healerXP;
    private double tankXP;
    private double mageXP;
    private double foragingXP;
    private final int[] highestSlayers;
    private final int[] slayerXP;
    private final int[] crystalLVL;
    private boolean saveable = true;
    private int bonusFerocity;
    private boolean fatalActive;
    private boolean permanentCoins;
    private SlayerQuest slayerQuest;
    private List<Pet.PetItem> pets;
    private AuctionSettings auctionSettings;
    private boolean auctionCreationBIN;
    private AuctionEscrow auctionEscrow;
    private boolean voidlingWardenActive;
    private boolean waitingForSign = false;
    private String signContent = null;
    private boolean isCompletedSign = false;

    private User(UUID uuid) {
        this.uuid = uuid;
        this.collections = ItemCollection.getDefaultCollections();
        this.totalfloor6run = 0L;
        this.coins = 0L;
        this.bits = 0L;
        this.bankCoins = 0L;
        this.sadancollections = 0L;
        this.islandX = null;
        this.islandZ = null;
        this.lastRegion = null;
        this.quiver = new HashMap<SMaterial, Integer>();
        this.effects = new ArrayList<ActivePotionEffect>();
        this.farmingXP = 0.0;
        this.miningXP = 0.0;
        this.combatXP = 0.0;
        this.foragingXP = 0.0;
        this.enchantXP = 0.0;
        this.highestSlayers = new int[4];
        this.slayerXP = new int[4];
        this.crystalLVL = new int[8];
        this.permanentCoins = false;
        this.pets = new ArrayList<Pet.PetItem>();
        this.auctionSettings = new AuctionSettings();
        this.auctionCreationBIN = false;
        this.auctionEscrow = new AuctionEscrow();
        if (!USER_FOLDER.exists()) {
            USER_FOLDER.mkdirs();
        }
        String path = uuid.toString() + ".yml";
        File configFile = new File(USER_FOLDER, path);
        boolean save = false;
        try {
            if (!configFile.exists()) {
                save = true;
                configFile.createNewFile();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        this.config = new Config(USER_FOLDER, path);
        USER_CACHE.put(uuid, this);
        if (save) {
            this.save();
        }
        this.load();
    }

    public void unload() {
        USER_CACHE.remove(this.uuid);
    }

    public void load() {
        this.uuid = UUID.fromString(this.config.getString("uuid"));
        if (this.config.contains("collections")) {
            for (String identifier : this.config.getConfigurationSection("collections").getKeys(false)) {
                this.collections.put(ItemCollection.getByIdentifier(identifier), this.config.getInt("collections." + identifier));
            }
        }
        this.coins = this.config.getLong("coins");
        this.bits = this.config.getLong("bits");
        this.bankCoins = this.config.getLong("bankCoins");
        this.islandX = this.config.contains("island.x") ? Double.valueOf(this.config.getDouble("island.x")) : null;
        this.islandZ = this.config.contains("island.z") ? Double.valueOf(this.config.getDouble("island.z")) : null;
        this.lastRegion = this.config.getString("lastRegion") != null ? Region.get(this.config.getString("lastRegion")) : null;
        Region region = this.lastRegion;
        if (this.config.contains("quiver")) {
            for (String m2 : this.config.getConfigurationSection("quiver").getKeys(false)) {
                this.quiver.put(SMaterial.getMaterial(m2), this.config.getInt("quiver." + m2));
            }
        }
        if (this.config.contains("effects")) {
            for (String key : this.config.getConfigurationSection("effects").getKeys(false)) {
                this.effects.add(new ActivePotionEffect(new vn.giakhanhvn.skysim.features.potion.PotionEffect(PotionEffectType.getByNamespace(key), this.config.getInt("effects." + key + ".level"), this.config.getLong("effects." + key + ".duration")), this.config.getLong("effects." + key + ".remaining")));
            }
        }
        this.totalfloor6run = this.config.getLong("dungeons.floor6.run");
        this.sadancollections = this.config.getLong("dungeons.boss.sadan");
        this.farmingXP = this.config.getDouble("xp.farming");
        this.miningXP = this.config.getDouble("xp.mining");
        this.combatXP = this.config.getDouble("xp.combat");
        this.foragingXP = this.config.getDouble("xp.foraging");
        this.enchantXP = this.config.getDouble("xp.enchant");
        this.cataXP = this.config.getDouble("xp.dungeons.cata");
        this.archerXP = this.config.getDouble("xp.dungeons.arch");
        this.mageXP = this.config.getDouble("xp.dungeons.mage");
        this.tankXP = this.config.getDouble("xp.dungeons.tank");
        this.berserkXP = this.config.getDouble("xp.dungeons.bers");
        this.healerXP = this.config.getDouble("xp.dungeons.heal");
        this.highestSlayers[0] = this.config.getInt("slayer.revenantHorror.highest");
        this.highestSlayers[1] = this.config.getInt("slayer.tarantulaBroodfather.highest");
        this.highestSlayers[2] = this.config.getInt("slayer.svenPackmaster.highest");
        this.highestSlayers[3] = this.config.getInt("slayer.voidgloomSeraph.highest");
        this.slayerXP[0] = this.config.getInt("xp.slayer.revenantHorror");
        this.slayerXP[1] = this.config.getInt("xp.slayer.tarantulaBroodfather");
        this.slayerXP[2] = this.config.getInt("xp.slayer.svenPackmaster");
        this.slayerXP[3] = this.config.getInt("xp.slayer.voidgloomSeraph");
        this.permanentCoins = this.config.getBoolean("permanentCoins");
        this.slayerQuest = (SlayerQuest)this.config.get("slayer.quest");
        if (this.config.contains("pets")) {
            this.pets = this.config.getList("pets");
        }
        this.auctionSettings = (AuctionSettings)this.config.get("auction.settings");
        if (this.auctionSettings == null) {
            this.auctionSettings = new AuctionSettings();
        }
        this.auctionCreationBIN = this.config.getBoolean("auction.creationBIN");
        this.auctionEscrow = (AuctionEscrow)this.config.get("auction.escrow");
        if (this.auctionEscrow == null) {
            this.auctionEscrow = new AuctionEscrow();
        }
    }

    public void asyncSavingData() {
        new BukkitRunnable(){

            public void run() {
                User.this.saveCookie();
                User.this.save();
                User.this.saveAllVanillaInstances();
            }
        }.runTaskAsynchronously((Plugin)plugin);
    }

    public void syncSavingData() {
        new BukkitRunnable(){

            public void run() {
                User.this.saveCookie();
                User.this.save();
                User.this.saveAllVanillaInstances();
            }
        }.runTask((Plugin)plugin);
    }

    public void loadStatic() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        User user = User.getUser(this.uuid);
        PlayerUtils.AUTO_SLAYER.put(player.getUniqueId(), this.config.getBoolean("configures.autoSlayer"));
        Repeater.SBA_MAP.put(player.getUniqueId(), this.config.getBoolean("configures.sbaToggle"));
        PetsGUI.setShowPets(player, this.config.getBoolean("configures.showPets"));
    }

    public void loadCookieStatus() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        PlayerUtils.setCookieDurationTicks(player, this.config.getLong("user.cookieDuration"));
        PlayerUtils.loadCookieStatsBuff(player);
    }

    public void saveCookie() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        if (!Bukkit.getPlayer((UUID)this.uuid).isOnline()) {
            return;
        }
        if (!PlayerUtils.COOKIE_DURATION_CACHE.containsKey(this.uuid)) {
            return;
        }
        this.config.set("user.cookieDuration", PlayerUtils.getCookieDurationTicks(Bukkit.getPlayer((UUID)this.uuid)));
        this.config.save();
    }

    public void save() {
        this.config.set("uuid", this.uuid.toString());
        this.config.set("collections", null);
        for (Map.Entry<ItemCollection, Integer> entry : this.collections.entrySet()) {
            this.config.set("collections." + entry.getKey().getIdentifier(), entry.getValue());
        }
        this.config.set("coins", this.coins);
        this.config.set("bits", this.bits);
        this.config.set("bankCoins", this.bankCoins);
        this.config.set("island.x", this.islandX);
        this.config.set("island.z", this.islandZ);
        if (this.lastRegion != null) {
            this.config.set("lastRegion", this.lastRegion.getName());
        }
        this.config.set("quiver", null);
        for (Map.Entry<Object, Integer> entry : this.quiver.entrySet()) {
            this.config.set("quiver." + ((SMaterial)((Object)entry.getKey())).name().toLowerCase(), entry.getValue());
        }
        this.config.set("effects", null);
        for (ActivePotionEffect activePotionEffect : this.effects) {
            PotionEffectType type = activePotionEffect.getEffect().getType();
            this.config.set("effects." + type.getNamespace() + ".level", activePotionEffect.getEffect().getLevel());
            this.config.set("effects." + type.getNamespace() + ".duration", activePotionEffect.getEffect().getDuration());
            this.config.set("effects." + type.getNamespace() + ".remaining", activePotionEffect.getRemaining());
        }
        try {
            this.config.set("user.lastPlayedVersion", SkySimEngine.getPlugin().getServerVersion().readableString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        this.config.set("dungeons.floor6.run", this.totalfloor6run);
        this.config.set("dungeons.boss.sadan", this.sadancollections);
        this.config.set("xp.farming", this.farmingXP);
        this.config.set("xp.mining", this.miningXP);
        this.config.set("xp.combat", this.combatXP);
        this.config.set("xp.foraging", this.foragingXP);
        this.config.set("xp.enchant", this.enchantXP);
        this.config.set("xp.dungeons.cata", this.cataXP);
        this.config.set("xp.dungeons.arch", this.archerXP);
        this.config.set("xp.dungeons.bers", this.berserkXP);
        this.config.set("xp.dungeons.heal", this.healerXP);
        this.config.set("xp.dungeons.mage", this.mageXP);
        this.config.set("xp.dungeons.tank", this.tankXP);
        this.config.set("slayer.revenantHorror.highest", this.highestSlayers[0]);
        this.config.set("slayer.tarantulaBroodfather.highest", this.highestSlayers[1]);
        this.config.set("slayer.svenPackmaster.highest", this.highestSlayers[2]);
        this.config.set("slayer.voidgloomSeraph.highest", this.highestSlayers[3]);
        this.config.set("xp.slayer.revenantHorror", this.slayerXP[0]);
        this.config.set("xp.slayer.tarantulaBroodfather", this.slayerXP[1]);
        this.config.set("xp.slayer.svenPackmaster", this.slayerXP[2]);
        this.config.set("xp.slayer.voidgloomSeraph", this.slayerXP[3]);
        this.config.set("permanentCoins", this.permanentCoins);
        this.config.set("slayer.quest", this.slayerQuest);
        this.config.set("pets", this.pets);
        this.config.set("auction.settings", this.auctionSettings);
        this.config.set("auction.creationBIN", this.auctionCreationBIN);
        this.config.set("auction.escrow", this.auctionEscrow);
        if (Bukkit.getPlayer((UUID)this.uuid) != null && Bukkit.getPlayer((UUID)this.uuid).isOnline()) {
            this.config.set("configures.showPets", PetsGUI.getShowPet(Bukkit.getPlayer((UUID)this.uuid)));
            this.config.set("configures.autoSlayer", PlayerUtils.isAutoSlayer(Bukkit.getPlayer((UUID)this.uuid)));
            this.config.set("configures.sbaToggle", PlayerUtils.isSBAToggle(Bukkit.getPlayer((UUID)this.uuid)));
        }
        this.config.save();
    }

    public void saveStorageData(int page) {
    }

    public void setIslandLocation(double x2, double z2) {
        this.islandX = x2;
        this.islandZ = z2;
    }

    public void saveInventory() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        String a2 = null;
        PlayerInventory piv = Bukkit.getPlayer((UUID)this.uuid).getInventory();
        a2 = this.getPureListFrom((Inventory)piv);
        this.config.set("database.inventory", a2);
        this.config.save();
    }

    public String getPureListFrom(Inventory piv) {
        ItemStack[] ist = piv.getContents();
        List<ItemStack> arraylist = Arrays.asList(ist);
        for (int i2 = 0; i2 < ist.length; ++i2) {
            NBTItem nbti;
            ItemStack stack = ist[i2];
            if (stack == null || !(nbti = new NBTItem(stack)).hasKey("dontSaveToProfile").booleanValue()) continue;
            arraylist.remove(i2);
        }
        ItemStack[] arrl = (ItemStack[])arraylist.toArray();
        return ItemStackSerializer.itemStackArrayToBase64(arrl);
    }

    public void saveArmor() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        String a2 = null;
        a2 = ItemStackSerializer.itemStackArrayToBase64(Bukkit.getPlayer((UUID)this.uuid).getInventory().getArmorContents());
        this.config.set("database.armor", a2);
        this.config.save();
    }

    public void saveEnderChest() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        Inventory inv = Bukkit.getPlayer((UUID)this.uuid).getEnderChest();
        String a2 = this.getPureListFrom(inv);
        this.config.set("database.enderchest", a2);
        this.config.save();
    }

    public void saveExp() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        this.config.set("database.minecraft_xp", Sputnik.getTotalExperience(Bukkit.getPlayer((UUID)this.uuid)));
        this.config.save();
    }

    public void loadPlayerData() throws IllegalArgumentException, IOException {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (this.config.getString("database.inventory") != null) {
            player.getInventory().setContents(ItemStackSerializer.itemStackArrayFromBase64(this.config.getString("database.inventory")));
        } else {
            player.getInventory().setContents(new ItemStack[player.getInventory().getSize()]);
        }
        if (this.config.getString("database.enderchest") != null) {
            player.getEnderChest().setContents(ItemStackSerializer.itemStackArrayFromBase64(this.config.getString("database.enderchest")));
        } else {
            player.getInventory().setContents(new ItemStack[player.getEnderChest().getSize()]);
        }
        if (this.config.getString("database.armor") != null) {
            player.getInventory().setArmorContents(ItemStackSerializer.itemStackArrayFromBase64(this.config.getString("database.armor")));
        } else {
            player.getInventory().setContents(new ItemStack[player.getInventory().getArmorContents().length]);
        }
        if (this.config.contains("database.minecraft_xp")) {
            Sputnik.setTotalExperience(player, this.config.getInt("database.minecraft_xp"));
        }
        if (this.config.contains("database.stashed")) {
            ItemStack[] arr = ItemStackSerializer.itemStackArrayFromBase64(this.config.getString("database.stashed"));
            this.stashedItems = Arrays.asList(arr);
        } else {
            this.stashedItems = new ArrayList<ItemStack>();
        }
        if (this.config.contains("configures.slot_selected")) {
            player.getInventory().setHeldItemSlot(this.config.getInt("configures.slot_selected"));
        }
    }

    public void saveLastSlot() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        this.config.set("configures.slot_selected", Bukkit.getPlayer((UUID)this.uuid).getInventory().getHeldItemSlot());
        this.config.save();
    }

    public void saveAllVanillaInstances() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        this.saveArmor();
        this.saveEnderChest();
        this.saveInventory();
        this.saveExp();
        this.saveLastSlot();
        this.saveAttributesForAPI();
        this.saveStash();
    }

    public void saveStash() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        if (this.stashedItems == null) {
            return;
        }
        ItemStack[] is = new ItemStack[this.stashedItems.size()];
        is = this.stashedItems.toArray(is);
        this.config.set("database.stashed", ItemStackSerializer.itemStackArrayToBase64(is));
        this.config.save();
    }

    public void saveAttributesForAPI() {
        if (Bukkit.getPlayer((UUID)this.uuid) == null) {
            return;
        }
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(this.getUuid());
        if (statistics == null) {
            return;
        }
        Double visualcap = statistics.getCritChance().addAll() * 100.0;
        if (visualcap > 100.0) {
            visualcap = 100.0;
        }
        this.config.set("apistats.health", statistics.getMaxHealth().addAll().intValue());
        this.config.set("apistats.defense", statistics.getDefense().addAll().intValue());
        this.config.set("apistats.strength", statistics.getStrength().addAll().intValue());
        this.config.set("apistats.crit_chance", visualcap.intValue());
        this.config.set("apistats.speed", Double.valueOf(statistics.getSpeed().addAll() * 100.0).intValue());
        this.config.set("apistats.crit_damage", Double.valueOf(statistics.getCritDamage().addAll() * 100.0).intValue());
        this.config.set("apistats.intelligence", statistics.getIntelligence().addAll().intValue());
        this.config.set("apistats.attack_speed", Double.valueOf(Math.min(100.0, statistics.getAttackSpeed().addAll())).intValue());
        this.config.set("apistats.magic_find", Double.valueOf(statistics.getMagicFind().addAll() * 100.0).intValue());
        this.config.set("apistats.ferocity", statistics.getFerocity().addAll().intValue());
        this.config.set("apistats.ability_damage", statistics.getAbilityDamage().addAll().intValue());
        this.config.save();
    }

    public void addCoins(long coins) {
        this.coins += coins;
    }

    public void subCoins(long coins) {
        this.coins -= coins;
    }

    public void addBankCoins(long bankCoins) {
        this.bankCoins += bankCoins;
    }

    public void subBankCoins(long bankCoins) {
        this.bankCoins -= bankCoins;
    }

    public boolean addBits(long value) {
        if (value > 0L) {
            this.bits += value;
            return true;
        }
        return false;
    }

    public boolean subBits(long value) {
        if (this.bits > value && value > 0L) {
            this.bits -= value;
            return true;
        }
        return false;
    }

    public void addBCollection(int a2) {
        this.sadancollections += (long)a2;
    }

    public void setBCollection(int a2) {
        this.sadancollections = a2;
    }

    public void subBCollection(int a2) {
        this.sadancollections -= (long)a2;
    }

    public long getBCollection() {
        return this.sadancollections;
    }

    public void addBRun6(int a2) {
        this.totalfloor6run += (long)a2;
    }

    public void subBRun6(int a2) {
        this.totalfloor6run -= (long)a2;
    }

    public long getBRun6() {
        return this.totalfloor6run;
    }

    public void addToCollection(ItemCollection collection, int amount) {
        int prevTier = collection.getTier(this.getCollection(collection));
        int i2 = this.collections.getOrDefault(collection, 0);
        this.collections.put(collection, i2 + amount);
        this.updateCollection(collection, prevTier);
    }

    public void addToCollection(ItemCollection collection) {
        this.addToCollection(collection, 1);
    }

    public void setCollection(ItemCollection collection, int amount) {
        int prevTier = collection.getTier(this.getCollection(collection));
        this.collections.put(collection, amount);
        this.updateCollection(collection, prevTier);
    }

    public void zeroCollection(ItemCollection collection) {
        int prevTier = collection.getTier(this.getCollection(collection));
        this.collections.put(collection, 0);
        this.updateCollection(collection, prevTier);
    }

    private void updateCollection(ItemCollection collection, int prevTier) {
        int tier = collection.getTier(this.getCollection(collection));
        if (prevTier != tier) {
            Player player = Bukkit.getPlayer((UUID)this.uuid);
            if (player != null) {
                player.playSound(player.getLocation(), Sound.LEVEL_UP, 1.0f, 2.0f);
            }
            StringBuilder builder = new StringBuilder();
            builder.append(ChatColor.YELLOW).append(ChatColor.BOLD).append("------------------------------------------\n");
            builder.append(ChatColor.GOLD).append(ChatColor.BOLD).append("  COLLECTION LEVEL UP ").append(ChatColor.RESET).append(ChatColor.YELLOW).append(collection.getName()).append(" ");
            if (prevTier != 0) {
                builder.append(ChatColor.DARK_GRAY).append(SUtil.toRomanNumeral(prevTier)).append("\u279c");
            }
            builder.append(ChatColor.YELLOW).append(SUtil.toRomanNumeral(tier)).append("\n");
            ItemCollectionRewards rewards = collection.getRewardsFor(tier);
            if (rewards != null && rewards.size() != 0) {
                builder.append(" \n");
                builder.append(ChatColor.GREEN).append(ChatColor.BOLD).append("  REWARD");
                if (rewards.size() != 1) {
                    builder.append("S");
                }
                builder.append(ChatColor.RESET);
                for (ItemCollectionReward reward : rewards) {
                    reward.onAchieve(player);
                    builder.append("\n    ").append(reward.toRewardString());
                }
            }
            builder.append(ChatColor.YELLOW).append(ChatColor.BOLD).append("------------------------------------------");
            this.send(builder.toString());
        }
    }

    public int getCollection(ItemCollection collection) {
        return this.collections.get(collection);
    }

    public boolean hasCollection(ItemCollection collection, int tier) {
        return collection.getTier(this.getCollection(collection)) >= tier;
    }

    public void addToQuiver(SMaterial material, int amount) {
        int i2 = this.quiver.getOrDefault((Object)material, 0);
        this.setQuiver(material, i2 + amount);
    }

    public void addToQuiver(SMaterial material) {
        this.addToQuiver(material, 1);
    }

    public void setQuiver(SMaterial material, int amount) {
        if (amount == 0) {
            this.quiver.remove((Object)material);
            return;
        }
        this.quiver.put(material, amount);
    }

    public int getQuiver(SMaterial material) {
        return this.quiver.get((Object)material);
    }

    public void subFromQuiver(SMaterial material, int amount) {
        if (!this.quiver.containsKey((Object)material)) {
            return;
        }
        this.setQuiver(material, this.quiver.get((Object)material) - amount);
    }

    public void addtoQuiver(SMaterial material, int amount) {
        if (!this.quiver.containsKey((Object)material)) {
            return;
        }
        this.setQuiver(material, this.quiver.get((Object)material) + amount);
    }

    public void subFromQuiver(SMaterial material) {
        this.subFromQuiver(material, 1);
    }

    public void addtoQuiver(SMaterial material) {
        this.addtoQuiver(material, 1);
    }

    public boolean hasQuiverItem(SMaterial material) {
        return this.quiver.containsKey((Object)material);
    }

    public void clearQuiver() {
        this.quiver.clear();
    }

    public void addPet(SItem item) {
        this.pets.add(new Pet.PetItem(item.getType(), item.getRarity(), item.getData().getDouble("xp")));
    }

    public void equipPet(Pet.PetItem pet) {
        for (Pet.PetItem p2 : this.pets) {
            if (!p2.isActive()) continue;
            p2.setActive(false);
            break;
        }
        pet.setActive(true);
    }

    public void removePet(Pet.PetItem pet) {
        Iterator<Pet.PetItem> iter = this.pets.iterator();
        while (iter.hasNext()) {
            Pet.PetItem p2 = iter.next();
            if (!pet.equals(p2)) continue;
            iter.remove();
            break;
        }
    }

    public Pet.PetItem getActivePet() {
        for (Pet.PetItem pet : this.pets) {
            if (!pet.isActive()) continue;
            return pet;
        }
        return null;
    }

    public Pet getActivePetClass() {
        Pet.PetItem item = this.getActivePet();
        if (item == null) {
            return null;
        }
        return (Pet)item.getType().getGenericInstance();
    }

    public double getSkillXP(Skill skill) {
        if (skill instanceof FarmingSkill) {
            return this.farmingXP;
        }
        if (skill instanceof MiningSkill) {
            return this.miningXP;
        }
        if (skill instanceof CombatSkill) {
            return this.combatXP;
        }
        if (skill instanceof ForagingSkill) {
            return this.foragingXP;
        }
        if (skill instanceof EnchantingSkill) {
            return this.enchantXP;
        }
        if (skill instanceof CatacombsSkill) {
            return this.cataXP;
        }
        if (skill instanceof ArcherSkill) {
            return this.archerXP;
        }
        if (skill instanceof TankSkill) {
            return this.tankXP;
        }
        if (skill instanceof HealerSkill) {
            return this.healerXP;
        }
        if (skill instanceof MageSkill) {
            return this.mageXP;
        }
        if (skill instanceof BerserkSkill) {
            return this.berserkXP;
        }
        return 0.0;
    }

    public void setSkillXP(Skill skill, double xp) {
        double prev = 0.0;
        if (skill instanceof FarmingSkill) {
            prev = this.farmingXP;
            this.farmingXP = xp;
        }
        if (skill instanceof MiningSkill) {
            prev = this.miningXP;
            this.miningXP = xp;
        }
        if (skill instanceof CombatSkill) {
            prev = this.combatXP;
            this.combatXP = xp;
        }
        if (skill instanceof ForagingSkill) {
            prev = this.foragingXP;
            this.foragingXP = xp;
        }
        if (skill instanceof EnchantingSkill) {
            prev = this.enchantXP;
            this.enchantXP = xp;
        }
        if (skill instanceof CatacombsSkill) {
            prev = this.cataXP;
            this.cataXP = xp;
        }
        if (skill instanceof TankSkill) {
            prev = this.tankXP;
            this.tankXP = xp;
        }
        if (skill instanceof ArcherSkill) {
            prev = this.archerXP;
            this.archerXP = xp;
        }
        if (skill instanceof BerserkSkill) {
            prev = this.berserkXP;
            this.berserkXP = xp;
        }
        if (skill instanceof MageSkill) {
            prev = this.mageXP;
            this.mageXP = xp;
        }
        if (skill instanceof HealerSkill) {
            prev = this.healerXP;
            this.healerXP = xp;
        }
        skill.onSkillUpdate(this, prev);
    }

    public void addSkillXP(Skill skill, double xp) {
        this.setSkillXP(skill, this.getSkillXP(skill) + xp);
    }

    public int getHighestRevenantHorror() {
        return this.highestSlayers[0];
    }

    public void setHighestRevenantHorror(int tier) {
        this.highestSlayers[0] = tier;
    }

    public int getHighestTarantulaBroodfather() {
        return this.highestSlayers[1];
    }

    public void setHighestTarantulaBroodfather(int tier) {
        this.highestSlayers[1] = tier;
    }

    public int getHighestSvenPackmaster() {
        return this.highestSlayers[2];
    }

    public void setHighestSvenPackmaster(int tier) {
        this.highestSlayers[2] = tier;
    }

    public int getHighestVoidgloomSeraph() {
        return this.highestSlayers[3];
    }

    public void setHighestVoidgloomSeraph(int tier) {
        this.highestSlayers[3] = tier;
    }

    public int getZombieSlayerXP() {
        return this.slayerXP[0];
    }

    public void setZombieSlayerXP(int xp) {
        this.slayerXP[0] = xp;
    }

    public int getSpiderSlayerXP() {
        return this.slayerXP[1];
    }

    public void setSpiderSlayerXP(int xp) {
        this.slayerXP[1] = xp;
    }

    public int getWolfSlayerXP() {
        return this.slayerXP[2];
    }

    public void setWolfSlayerXP(int xp) {
        this.slayerXP[2] = xp;
    }

    public int getEndermanSlayerXP() {
        return this.slayerXP[3];
    }

    public void setEndermanSlayerXP(int xp) {
        this.slayerXP[3] = xp;
    }

    public void setSlayerXP(SlayerBossType.SlayerMobType type, int xp) {
        this.slayerXP[type.ordinal()] = xp;
    }

    public int getSlayerXP(SlayerBossType.SlayerMobType type) {
        return this.slayerXP[type.ordinal()];
    }

    public int getCrystalLVL(int i2) {
        if (i2 > 7) {
            SLog.severe("Out of bound on action taking data from database!");
            return 0;
        }
        return this.crystalLVL[i2];
    }

    public void setCrystalLVL(int i2, int a2) {
        if (i2 > 7) {
            SLog.severe("Out of bound on action taking data from database!");
            return;
        }
        this.crystalLVL[i2] = a2;
    }

    public int getSlayerCombatXPBuff() {
        int buff = 0;
        for (int highest : this.highestSlayers) {
            buff += highest == 4 ? 5 : highest;
        }
        return buff;
    }

    public void startSlayerQuest(SlayerBossType type) {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return;
        }
        this.slayerQuest = new SlayerQuest(type, System.currentTimeMillis());
        player.playSound(player.getLocation(), Sound.ENDERDRAGON_GROWL, 1.0f, 2.0f);
        player.sendMessage("  " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "SLAYER QUEST STARTED!");
        player.sendMessage("   " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "\u00bb " + ChatColor.GRAY + "Slay " + ChatColor.RED + SUtil.commaify(type.getSpawnXP()) + " Combat XP" + ChatColor.GRAY + " worth of " + type.getType().getPluralName() + ".");
    }

    public void failSlayerQuest() {
        if (this.slayerQuest == null) {
            return;
        }
        if (this.slayerQuest.getDied() != 0L) {
            return;
        }
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return;
        }
        this.slayerQuest.setDied(System.currentTimeMillis());
        if (this.slayerQuest.getEntity() != null) {
            this.slayerQuest.getEntity().remove();
            this.slayerQuest.getEntity().getFunction().onDeath(this.slayerQuest.getEntity(), (Entity)this.slayerQuest.getEntity().getEntity(), (Entity)player);
        }
        SUtil.delay(() -> {
            this.removeAllSlayerBosses();
            player.sendMessage("  " + ChatColor.RED + ChatColor.BOLD + "SLAYER QUEST FAILED!");
            player.sendMessage("   " + ChatColor.DARK_PURPLE + ChatColor.BOLD + "\u00bb " + ChatColor.GRAY + "You need to learn how to play this game first!");
        }, 2L);
    }

    public void removeAllSlayerBosses() {
        for (Entity e2 : Bukkit.getPlayer((UUID)this.uuid).getWorld().getEntities()) {
            if (!e2.hasMetadata("BOSS_OWNER_" + this.uuid.toString()) || !e2.hasMetadata("SlayerBoss")) continue;
            e2.remove();
        }
    }

    public void send(String message) {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return;
        }
        player.sendMessage(Sputnik.trans(message));
    }

    public void damageEntity(Damageable entity1, double damageBase) {
        SItem sitem;
        if (entity1.isDead()) {
            return;
        }
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        double damage = damageBase;
        if (VoidgloomSeraph.HIT_SHIELD.containsKey(entity1)) {
            VoidgloomSeraph.HIT_SHIELD.put((Entity)entity1, VoidgloomSeraph.HIT_SHIELD.get(entity1) - 1);
            entity1.getWorld().playSound(entity1.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 2.0f);
        }
        if (entity1.getType() != EntityType.ENDER_DRAGON) {
            if (EntityManager.DEFENSE_PERCENTAGE.containsKey(entity1)) {
                int defensepercent = EntityManager.DEFENSE_PERCENTAGE.get(entity1);
                if (defensepercent > 100) {
                    defensepercent = 100;
                }
                damage -= damage * (double)defensepercent / 100.0;
            }
            PlayerUtils.handleSpecEntity((Entity)entity1, player, new AtomicDouble(damage));
            entity1.setHealth(Math.max(0.0, entity1.getHealth() - damage));
        } else {
            double formula = damage / entity1.getMaxHealth() * 100.0;
            damage = formula < 10.0 ? (damage = damage * 1.0) : (formula > 10.0 && formula < 15.0 ? (damage = damage - damage * 90.0 / 100.0) : (formula > 15.0 && formula < 20.0 ? (damage = damage - damage * 99.0 / 100.0) : (formula > 20.0 && formula <= 25.0 ? (damage = damage - damage * 99.9 / 100.0) : (formula > 25.0 ? (damage = damage * 0.0) : (damage = damage * 1.0)))));
            PlayerUtils.handleSpecEntity((Entity)entity1, player, new AtomicDouble(damage));
            entity1.setHealth(Math.max(0.0, entity1.getHealth() - damage));
        }
        double health = entity1.getMaxHealth();
        if (player == null) {
            return;
        }
        entity1.damage(1.0E-5);
        if (player.getItemInHand() != null && (sitem = SItem.find(player.getItemInHand())) != null && sitem.getEnchantment(EnchantmentType.VAMPIRISM) != null) {
            double lvl = sitem.getEnchantment(EnchantmentType.VAMPIRISM).getLevel();
            if (lvl > 100.0) {
                lvl = 100.0;
            }
            double aB2 = player.getHealth() + lvl / 100.0 * (player.getMaxHealth() - player.getHealth());
            double aC2 = Math.min(player.getMaxHealth(), aB2);
            player.setHealth(aC2);
        }
    }

    public void damageEntityIgnoreShield(Damageable entity1, double damageBase) {
        SItem sitem;
        if (entity1.isDead()) {
            return;
        }
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        double damage = damageBase;
        if (VoidgloomSeraph.HIT_SHIELD.containsKey(entity1)) {
            VoidgloomSeraph.HIT_SHIELD.put((Entity)entity1, VoidgloomSeraph.HIT_SHIELD.get(entity1) - 1);
            entity1.getWorld().playSound(entity1.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 2.0f);
        }
        if (entity1.getType() != EntityType.ENDER_DRAGON) {
            PlayerUtils.handleSpecEntity((Entity)entity1, player, new AtomicDouble(damage));
            entity1.setHealth(Math.max(0.0, entity1.getHealth() - damage));
        } else {
            double formula = damage / entity1.getMaxHealth() * 100.0;
            damage = formula < 10.0 ? (damage = damage * 1.0) : (formula > 10.0 && formula < 15.0 ? (damage = damage - damage * 90.0 / 100.0) : (formula > 15.0 && formula < 20.0 ? (damage = damage - damage * 99.0 / 100.0) : (formula > 20.0 && formula <= 25.0 ? (damage = damage - damage * 99.9 / 100.0) : (formula > 25.0 ? (damage = damage * 0.0) : (damage = damage * 1.0)))));
            PlayerUtils.handleSpecEntity((Entity)entity1, player, new AtomicDouble(damage));
            entity1.setHealth(Math.max(0.0, entity1.getHealth() - damage));
        }
        double health = entity1.getMaxHealth();
        if (player == null) {
            return;
        }
        entity1.damage(1.0E-5);
        if (player.getItemInHand() != null && (sitem = SItem.find(player.getItemInHand())) != null && sitem.getEnchantment(EnchantmentType.VAMPIRISM) != null) {
            double lvl = sitem.getEnchantment(EnchantmentType.VAMPIRISM).getLevel();
            if (lvl > 100.0) {
                lvl = 100.0;
            }
            double aB2 = player.getHealth() + lvl / 100.0 * (player.getMaxHealth() - player.getHealth());
            double aC2 = Math.min(player.getMaxHealth(), aB2);
            player.setHealth(aC2);
        }
    }

    public void damageEntityBowEman(Damageable entity1, double damage, Player player, Arrow a2) {
        if (VoidgloomSeraph.HIT_SHIELD.containsKey(entity1)) {
            VoidgloomSeraph.HIT_SHIELD.put((Entity)entity1, VoidgloomSeraph.HIT_SHIELD.get(entity1) - 1);
            entity1.getWorld().playSound(entity1.getLocation(), Sound.ENDERMAN_TELEPORT, 1.0f, 2.0f);
        }
        double health = entity1.getMaxHealth();
        if (player == null) {
            return;
        }
        if (entity1.getType() != EntityType.ENDER_DRAGON) {
            if (EntityManager.DEFENSE_PERCENTAGE.containsKey(entity1)) {
                int defensepercent = EntityManager.DEFENSE_PERCENTAGE.get(entity1);
                if (defensepercent > 100) {
                    defensepercent = 100;
                }
                damage -= damage * (double)defensepercent / 100.0;
            }
            entity1.setHealth(Math.max(0.0, entity1.getHealth() - damage));
        } else {
            double formula = damage / entity1.getMaxHealth() * 100.0;
            damage = formula < 10.0 ? (damage = damage * 1.0) : (formula > 10.0 && formula < 15.0 ? (damage = damage - damage * 90.0 / 100.0) : (formula > 15.0 && formula < 20.0 ? (damage = damage - damage * 99.0 / 100.0) : (formula > 20.0 && formula <= 25.0 ? (damage = damage - damage * 99.9 / 100.0) : (formula > 25.0 ? (damage = damage * 0.0) : (damage = damage * 1.0)))));
            entity1.setHealth(Math.max(0.0, entity1.getHealth() - damage));
        }
        PlayerUtils.handleSpecEntity((Entity)entity1, player, new AtomicDouble(damage));
        a2.remove();
    }

    public void damageEntity(LivingEntity entity) {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return;
        }
        entity.damage(0.0, (Entity)player);
    }

    public void damage(double d2, EntityDamageEvent.DamageCause cause, Entity entity) {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return;
        }
        if (player.getGameMode() == GameMode.CREATIVE || player.getGameMode() == GameMode.SPECTATOR) {
            return;
        }
        EntityHuman human = ((CraftHumanEntity)player).getHandle();
        PlayerStatistics statistics = PlayerUtils.STATISTICS_CACHE.get(player.getUniqueId());
        double trueDefense = statistics.getTrueDefense().addAll();
        double health = statistics.getMaxHealth().addAll();
        d2 -= d2 * (trueDefense / (trueDefense + 100.0));
        if (player.getHealth() + (double)SputnikPlayer.getCustomAbsorptionHP(player).intValue() - d2 <= 0.0) {
            this.kill(cause, entity);
            return;
        }
        float ab2 = (float)Math.max(0.0, (double)SputnikPlayer.getCustomAbsorptionHP(player).intValue() - d2);
        double actual = Math.max(0.0, d2 - (double)SputnikPlayer.getCustomAbsorptionHP(player).intValue());
        SputnikPlayer.setCustomAbsorptionHP(player, ab2);
        if (cause == EntityDamageEvent.DamageCause.FIRE || cause == EntityDamageEvent.DamageCause.FIRE_TICK || cause == EntityDamageEvent.DamageCause.LAVA) {
            boolean damage = false;
            if (cause == EntityDamageEvent.DamageCause.FIRE || cause == EntityDamageEvent.DamageCause.FIRE_TICK && cause != EntityDamageEvent.DamageCause.LAVA) {
                actual = 5.0;
            } else if (cause == EntityDamageEvent.DamageCause.LAVA) {
                actual = 20.0;
            }
        }
        if (cause == EntityDamageEvent.DamageCause.DROWNING && cause == EntityDamageEvent.DamageCause.DROWNING) {
            actual = health * 5.0 / 100.0;
        }
        if (cause == EntityDamageEvent.DamageCause.SUFFOCATION && cause == EntityDamageEvent.DamageCause.SUFFOCATION) {
            actual = health * 5.0 / 100.0;
        }
        if (cause == EntityDamageEvent.DamageCause.CONTACT && cause == EntityDamageEvent.DamageCause.CONTACT) {
            actual = 5.0;
        }
        if (!(cause != EntityDamageEvent.DamageCause.WITHER && cause != EntityDamageEvent.DamageCause.POISON || cause != EntityDamageEvent.DamageCause.WITHER && cause != EntityDamageEvent.DamageCause.POISON)) {
            actual = 20.0;
        }
        player.setHealth(Math.max(0.0, player.getHealth() - actual));
        if (cause == EntityDamageEvent.DamageCause.FIRE || cause == EntityDamageEvent.DamageCause.FIRE_TICK || cause == EntityDamageEvent.DamageCause.LAVA) {
            PlayerListener.spawnSpecialDamageInd((Entity)player, actual, ChatColor.GOLD);
        } else if (cause == EntityDamageEvent.DamageCause.FALL || cause == EntityDamageEvent.DamageCause.CONTACT || cause == EntityDamageEvent.DamageCause.SUFFOCATION) {
            PlayerListener.spawnSpecialDamageInd((Entity)player, actual, ChatColor.GRAY);
        } else if (cause == EntityDamageEvent.DamageCause.DROWNING) {
            PlayerListener.spawnSpecialDamageInd((Entity)player, actual, ChatColor.DARK_AQUA);
        } else if (cause == EntityDamageEvent.DamageCause.LIGHTNING) {
            PlayerListener.spawnSpecialDamageInd((Entity)player, actual, ChatColor.RED);
        } else if (cause == EntityDamageEvent.DamageCause.POISON) {
            PlayerListener.spawnSpecialDamageInd((Entity)player, actual, ChatColor.DARK_GREEN);
        } else if (cause == EntityDamageEvent.DamageCause.WITHER) {
            PlayerListener.spawnSpecialDamageInd((Entity)player, actual, ChatColor.BLACK);
        } else {
            PlayerListener.spawnSpecialDamageInd((Entity)player, actual, ChatColor.WHITE);
        }
        if (player.getHealth() <= 0.0) {
            player.setFireTicks(0);
            this.kill(cause, entity);
        }
    }

    public void damage(double d2) {
        this.damage(d2, EntityDamageEvent.DamageCause.CUSTOM, null);
    }

    public void kill(EntityDamageEvent.DamageCause cause, Entity entity) {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return;
        }
        player.setHealth(player.getMaxHealth());
        for (int i2 = 0; i2 < player.getInventory().getSize(); ++i2) {
            ItemStack stack = player.getInventory().getItem(i2);
            SItem sItem = SItem.find(stack);
            if (sItem == null) continue;
        }
        player.setFireTicks(0);
        player.setVelocity(new Vector(0, 0, 0));
        player.setFallDistance(0.0f);
        SputnikPlayer.AbsHP.put(player, 0);
        if (!player.getWorld().getName().contains("f6")) {
            this.sendToSpawn();
            if (!PlayerUtils.cookieBuffActive(player)) {
                this.clearPotionEffects();
            }
        } else {
            final World w2 = player.getWorld();
            for (Entity en : player.getWorld().getEntities()) {
                if (en instanceof HumanEntity) continue;
                en.remove();
            }
            SadanFunction.sendReMsg(false, w2);
            SadanHuman.IsMusicPlaying.put(w2.getUID(), false);
            SadanHuman.BossRun.put(w2.getUID(), false);
            SadanFunction.endRoom2(w2);
            final BukkitTask bkt = SadanHuman.playHBS(w2);
            new BukkitRunnable(){

                public void run() {
                    if (w2 == null || w2.getPlayers().size() == 0) {
                        bkt.cancel();
                        this.cancel();
                    }
                }
            }.runTaskTimer((Plugin)SkySimEngine.getPlugin(), 0L, 1L);
            SUtil.sendTitle(player, ChatColor.YELLOW + "You became a ghost!");
            SUtil.sendSubtitle(player, ChatColor.GRAY + "Hopefully your teammates can revive you.");
            if (cause == EntityDamageEvent.DamageCause.VOID) {
                this.sendToSpawn();
            }
        }
        String name = null;
        if (entity != null) {
            SEntity sEntity = SEntity.findSEntity(entity);
            name = sEntity != null ? sEntity.getStatistics().getEntityName() : entity.getCustomName();
        }
        String message = "You died";
        String out = "%s died";
        switch (cause) {
            case VOID: {
                message = "You fell into the void";
                out = "%s fell into the void";
                break;
            }
            case FALL: {
                message = "You fell to your death";
                out = "%s fell to their death";
                break;
            }
            case ENTITY_ATTACK: {
                message = "You were killed by " + name + ChatColor.GRAY;
                out = "%s was killed by " + name + ChatColor.GRAY;
                break;
            }
            case ENTITY_EXPLOSION: {
                message = "You were killed by " + name + ChatColor.GRAY + "'s explosion";
                out = "%s was killed by " + name + ChatColor.GRAY + "'s explosion";
                break;
            }
            case FIRE: 
            case FIRE_TICK: 
            case LAVA: {
                message = "You burned to death";
                out = "%s burned to death";
                break;
            }
            case MAGIC: {
                message = "You died by magic";
                out = "%s was killed by magic";
                break;
            }
            case POISON: {
                message = "You died by poisoning";
                out = "%s was killed by poisoning";
                break;
            }
            case LIGHTNING: {
                message = "You were struck by lightning and died";
                out = "%s was struck by lightning and killed";
                break;
            }
            case DROWNING: {
                message = "You drowned";
                out = "%s drowned";
                break;
            }
            case SUFFOCATION: {
                message = "You suffocated";
                out = "%s suffocated";
            }
        }
        if (this.slayerQuest != null && this.slayerQuest.getKilled() == 0L) {
            SlayerQuest slayerQuest;
            User user = User.getUser(player.getUniqueId());
            SlayerQuest quest = user.getSlayerQuest();
            if (slayerQuest.getXp() >= (double)quest.getType().getSpawnXP()) {
                this.failSlayerQuest();
            }
        }
        player.playSound(player.getLocation(), Sound.HURT_FLESH, 1.0f, 1.0f);
        if (!player.getWorld().getName().equalsIgnoreCase("limbo") && !player.getWorld().getName().contains("f6")) {
            player.sendMessage(ChatColor.RED + " \u2620 " + ChatColor.GRAY + message + ChatColor.GRAY + ".");
            SUtil.broadcastExcept(ChatColor.RED + " \u2620 " + ChatColor.GRAY + String.format(out, player.getName()) + ChatColor.GRAY + ".", player);
        }
        if (player.getWorld().getName().contains("f6")) {
            player.playSound(player.getLocation(), Sound.HURT_FLESH, 1.0f, 1.0f);
            player.sendMessage(ChatColor.RED + " \u2620 " + ChatColor.GRAY + message + ChatColor.GRAY + " and became a ghost.");
            SUtil.broadcastExcept(ChatColor.RED + " \u2620 " + ChatColor.GRAY + String.format(out, player.getName()) + ChatColor.GRAY + " and became a ghost.", player);
        }
        for (Entity e2 : player.getWorld().getEntities()) {
            if (!e2.hasMetadata("owner") || !((MetadataValue)e2.getMetadata("owner").get(0)).asString().equals(player.getUniqueId().toString())) continue;
            e2.remove();
            player.sendMessage(ChatColor.RED + "\u2620 Your Voidling's Warden Boss has been despawned since you died!");
        }
        if (PlayerUtils.cookieBuffActive(player)) {
            player.sendMessage(ChatColor.RED + "You died!");
            return;
        }
        if (this.isOnIsland() && cause == EntityDamageEvent.DamageCause.VOID || this.permanentCoins || player.getWorld().getName().equalsIgnoreCase("limbo") || player.getWorld().getName().contains("f6")) {
            return;
        }
        int piggyIndex = PlayerUtils.getSpecItemIndex(player, SMaterial.PIGGY_BANK);
        if (piggyIndex != -1 && this.coins >= 20000L) {
            SItem cracked = SItem.of(SMaterial.CRACKED_PIGGY_BANK);
            SItem piggy = SItem.find(player.getInventory().getItem(piggyIndex));
            if (piggy.getReforge() != null) {
                cracked.setReforge(piggy.getReforge());
            }
            player.getInventory().setItem(piggyIndex, cracked.getStack());
            player.sendMessage(ChatColor.RED + "You died and your piggy bank cracked!");
            return;
        }
        player.playSound(player.getLocation(), Sound.ZOMBIE_METAL, 1.0f, 2.0f);
        int crackedPiggyIndex = PlayerUtils.getSpecItemIndex(player, SMaterial.CRACKED_PIGGY_BANK);
        if (crackedPiggyIndex != -1 && this.coins >= 20000L) {
            SItem broken = SItem.of(SMaterial.BROKEN_PIGGY_BANK);
            SItem crackedPiggy = SItem.find(player.getInventory().getItem(crackedPiggyIndex));
            if (crackedPiggy.getReforge() != null) {
                broken.setReforge(crackedPiggy.getReforge());
            }
            player.getInventory().setItem(crackedPiggyIndex, broken.getStack());
            long sub = (long)((double)this.coins * 0.25);
            player.sendMessage(ChatColor.RED + "You died, lost " + SUtil.commaify(sub) + " coins, and your piggy bank broke!");
            this.coins -= sub;
            this.save();
            return;
        }
        long sub = this.coins / 2L;
        player.sendMessage(ChatColor.RED + "You died and lost " + SUtil.commaify(sub) + " coins!");
        this.coins -= sub;
        this.save();
    }

    public void addPotionEffect(vn.giakhanhvn.skysim.features.potion.PotionEffect effect) {
        this.effects.add(new ActivePotionEffect(effect, effect.getDuration()));
    }

    public void removePotionEffect(PotionEffectType type) {
        for (ActivePotionEffect effect : this.effects) {
            if (effect.getEffect().getType() != type) continue;
            effect.setRemaining(0L);
        }
    }

    public ActivePotionEffect getPotionEffect(PotionEffectType type) {
        for (ActivePotionEffect effect : this.effects) {
            if (effect.getEffect().getType() != type) continue;
            return effect;
        }
        return null;
    }

    public boolean hasPotionEffect(PotionEffectType type) {
        return this.effects.stream().filter(effect -> effect.getEffect().getType() == type).toArray().length != 0;
    }

    public void clearPotionEffects() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player != null) {
            for (PotionEffect potionEffect : player.getActivePotionEffects()) {
                player.removePotionEffect(potionEffect.getType());
            }
        }
        for (ActivePotionEffect activePotionEffect : this.effects) {
            activePotionEffect.setRemaining(0L);
        }
    }

    public boolean isOnIsland() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return false;
        }
        return this.isOnIsland(player.getLocation());
    }

    public boolean isOnIsland(Block block) {
        return this.isOnIsland(block.getLocation());
    }

    public boolean isOnIsland(Location location) {
        World world = Bukkit.getWorld((String)"islands");
        if (world == null) {
            return false;
        }
        double x2 = location.getX();
        double z2 = location.getZ();
        return world.getUID().equals(location.getWorld().getUID()) && x2 >= this.islandX - 125.0 && x2 <= this.islandX + 125.0 && z2 >= this.islandZ - 125.0 && z2 <= this.islandZ + 125.0;
    }

    public boolean isOnUserIsland() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return false;
        }
        World world = Bukkit.getWorld((String)"islands");
        if (world == null) {
            return false;
        }
        double x2 = player.getLocation().getX();
        double z2 = player.getLocation().getZ();
        return world.getUID().equals(player.getWorld().getUID()) && x2 < this.islandX - 125.0 && x2 > this.islandX + 125.0 && z2 < this.islandZ - 125.0 && z2 > this.islandZ + 125.0;
    }

    public List<AuctionItem> getBids() {
        return AuctionItem.getAuctions().stream().filter(item -> {
            for (AuctionBid bid : item.getBids()) {
                if (!bid.getBidder().equals(this.uuid) || !item.getParticipants().contains(this.uuid)) continue;
                return true;
            }
            return false;
        }).collect(Collectors.toList());
    }

    public List<AuctionItem> getAuctions() {
        return AuctionItem.getAuctions().stream().filter(item -> item.getOwner().getUuid().equals(this.uuid) && item.getParticipants().contains(this.uuid)).collect(Collectors.toList());
    }

    public Player toBukkitPlayer() {
        return Bukkit.getPlayer((UUID)this.uuid);
    }

    public EntityPlayer toNMSPlayer() {
        return ((CraftPlayer)Bukkit.getPlayer((UUID)this.uuid)).getHandle();
    }

    public void sendToSpawn() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player == null) {
            return;
        }
        if (this.isOnIsland()) {
            World world = Bukkit.getWorld((String)"islands");
            player.teleport(world.getHighestBlockAt(SUtil.blackMagic(this.islandX), SUtil.blackMagic(this.islandZ)).getLocation().add(0.5, 1.0, 0.5));
        } else if (this.lastRegion != null) {
            switch (this.lastRegion.getType()) {
                case BANK: {
                    player.teleport(player.getWorld().getSpawnLocation());
                }
                case FARM: 
                case RUINS: {
                    player.teleport(player.getWorld().getSpawnLocation());
                }
                case FOREST: 
                case LIBRARY: 
                case COAL_MINE: 
                case COAL_MINE_CAVES: 
                case MOUNTAIN: 
                case VILLAGE: {
                    player.teleport(player.getWorld().getSpawnLocation());
                }
                case HIGH_LEVEL: {
                    player.teleport(player.getWorld().getSpawnLocation());
                }
                case BLACKSMITH: {
                    player.teleport(player.getWorld().getSpawnLocation());
                }
                case AUCTION_HOUSE: {
                    player.teleport(player.getWorld().getSpawnLocation());
                }
                case WILDERNESS: 
                case BAZAAR_ALLEY: 
                case COLOSSEUM: 
                case GRAVEYARD: {
                    player.teleport(player.getWorld().getSpawnLocation());
                    break;
                }
                case SPIDERS_DEN: {
                    player.teleport(player.getWorld().getSpawnLocation());
                }
                case SPIDERS_DEN_HIVE: {
                    player.teleport(player.getWorld().getSpawnLocation());
                    break;
                }
                default: {
                    player.teleport(player.getWorld().getSpawnLocation());
                    break;
                }
            }
        } else {
            player.teleport(player.getWorld().getSpawnLocation());
        }
    }

    public static String generateRandom() {
        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = SUtil.random(7, 7);
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1).limit(targetStringLength).collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return generatedString;
    }

    public static void wipeUser(UUID uuid) {
        String wipeID = User.generateRandom();
        SLog.info("Wiping with " + wipeID);
        if (Bukkit.getPlayer((UUID)uuid).isOnline()) {
            Player p2 = Bukkit.getPlayer((UUID)uuid);
            p2.kickPlayer(ChatColor.RED + "You have been disconnected");
        }
        Path source = Paths.get(USER_FOLDER + "/" + uuid.toString() + ".yml", new String[0]);
        try {
            Files.move(source, source.resolveSibling("WIPED_" + wipeID + "_" + uuid + ".yml"), new CopyOption[0]);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static User getUser(UUID uuid) {
        if (uuid == null) {
            return null;
        }
        if (USER_CACHE.containsKey(uuid)) {
            return USER_CACHE.get(uuid);
        }
        return new User(uuid);
    }

    public static User of(Player player) {
        return User.getUser(player.getUniqueId());
    }

    public static Collection<User> getCachedUsers() {
        return USER_CACHE.values();
    }

    public boolean hasPermission(String permission) {
        return true;
    }

    public static Map<UUID, User> getHash() {
        return USER_CACHE;
    }

    public void updateArmorInventory() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player != null) {
            this.updateHelmet();
            this.updateChestplate();
            this.updateLeggings();
            this.updateBoots();
        }
    }

    public void updateEnderChest() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player != null) {
            for (int i2 = 0; i2 < player.getEnderChest().getContents().length; ++i2) {
                SItem sitem;
                ItemStack is = player.getEnderChest().getItem(i2);
                if (is == null || (sitem = SItem.find(is)) == null) continue;
                if (sitem.getReforge() != null && !player.isOp() && sitem.getReforge().toString().toUpperCase().contains("OVERPOWERED") | sitem.getReforge().toString().toUpperCase().contains("SUPERGENIUS")) {
                    sitem.setReforge(ReforgeType.STRONK.getReforge());
                    player.getEnderChest().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.LEGION) != null && !player.isOp() && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 5) {
                    sitem.removeEnchantment(EnchantmentType.LEGION);
                    player.sendMessage(ChatColor.RED + "you have illegal enchant in ur echest, that ench got wiped, haha sike u bruh lol sus.");
                    player.getEnderChest().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.LEGION) != null && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 10) {
                    sitem.removeEnchantment(EnchantmentType.LEGION);
                    player.sendMessage(ChatColor.RED + "you have illegal enchant in ur echest, that ench got wiped, haha sike u bruh lol sus, epik hole ze cum amogus hahaha bruh lol amogus.");
                    player.getEnderChest().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.SHARPNESS) != null && sitem.getEnchantment(EnchantmentType.SHARPNESS).getLevel() > 400 && !player.isOp()) {
                    sitem.removeEnchantment(EnchantmentType.SHARPNESS);
                    sitem.addEnchantment(EnchantmentType.SHARPNESS, 400);
                    player.getEnderChest().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.POWER) != null && sitem.getEnchantment(EnchantmentType.POWER).getLevel() > 300 && !player.isOp()) {
                    sitem.removeEnchantment(EnchantmentType.POWER);
                    sitem.addEnchantment(EnchantmentType.POWER, 300);
                    player.getEnderChest().setItem(i2, sitem.getStack());
                }
                sitem.update();
                player.getEnderChest().setItem(i2, this.updateItemBoost(sitem));
            }
        }
    }

    public void updateInventory() {
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        if (player != null) {
            this.updateHelmet();
            this.updateChestplate();
            this.updateLeggings();
            this.updateBoots();
            this.updateEnderChest();
            for (int i2 = 0; i2 < player.getInventory().getContents().length; ++i2) {
                SItem sitem;
                ItemStack is = player.getInventory().getItem(i2);
                if (is == null || (sitem = SItem.find(is)) == null) continue;
                if (sitem.getReforge() != null && !player.isOp() && sitem.getReforge().toString().toUpperCase().contains("OVERPOWERED") | sitem.getReforge().toString().toUpperCase().contains("SUPERGENIUS")) {
                    sitem.setReforge(ReforgeType.STRONK.getReforge());
                    player.getInventory().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.LEGION) != null && !player.isOp() && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 5) {
                    sitem.removeEnchantment(EnchantmentType.LEGION);
                    player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus.");
                    player.getInventory().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.LEGION) != null && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 10) {
                    sitem.removeEnchantment(EnchantmentType.LEGION);
                    player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus, epik hole ze cum amogus hahaha bruh lol amogus.");
                    player.getInventory().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.SHARPNESS) != null && sitem.getEnchantment(EnchantmentType.SHARPNESS).getLevel() > 400 && !player.isOp()) {
                    sitem.removeEnchantment(EnchantmentType.SHARPNESS);
                    sitem.addEnchantment(EnchantmentType.SHARPNESS, 400);
                    player.getInventory().setItem(i2, sitem.getStack());
                }
                if (sitem.getEnchantment(EnchantmentType.POWER) != null && sitem.getEnchantment(EnchantmentType.POWER).getLevel() > 320 && !player.isOp()) {
                    sitem.removeEnchantment(EnchantmentType.POWER);
                    sitem.addEnchantment(EnchantmentType.POWER, 320);
                    player.getInventory().setItem(i2, sitem.getStack());
                }
                sitem.update();
                player.getInventory().setItem(i2, this.updateItemBoost(sitem));
            }
        }
    }

    public void setNMSValSeq(float arg0) {
        this.toNMSPlayer().aA = arg0;
    }

    public void updateHelmet() {
        SItem sitem;
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        ItemStack is = player.getInventory().getHelmet();
        if (is != null && (sitem = SItem.find(is)) != null) {
            if (sitem.getReforge() != null && !player.isOp() && sitem.getReforge().toString().toUpperCase().contains("OVERPOWERED") | sitem.getReforge().toString().toUpperCase().contains("SUPERGENIUS")) {
                sitem.setReforge(ReforgeType.STRONK.getReforge());
                player.getInventory().setHelmet(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && !player.isOp() && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 5) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus.");
                player.getInventory().setHelmet(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 10) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus, epik hole ze cum amogus hahaha bruh lol amogus.");
                player.getInventory().setHelmet(sitem.getStack());
            }
            sitem.update();
            player.getInventory().setHelmet(this.updateItemBoost(sitem));
        }
    }

    public void updateChestplate() {
        SItem sitem;
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        ItemStack is = player.getInventory().getChestplate();
        if (is != null && (sitem = SItem.find(is)) != null) {
            if (sitem.getReforge() != null && !player.isOp() && sitem.getReforge().toString().toUpperCase().contains("OVERPOWERED") | sitem.getReforge().toString().toUpperCase().contains("SUPERGENIUS")) {
                sitem.setReforge(ReforgeType.STRONK.getReforge());
                player.getInventory().setChestplate(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && !player.isOp() && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 5) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus.");
                player.getInventory().setChestplate(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 10) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus, epik hole ze cum amogus hahaha bruh lol amogus.");
                player.getInventory().setChestplate(sitem.getStack());
            }
            sitem.update();
            player.getInventory().setChestplate(this.updateItemBoost(sitem));
        }
    }

    public void updateLeggings() {
        SItem sitem;
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        ItemStack is = player.getInventory().getLeggings();
        if (is != null && (sitem = SItem.find(is)) != null) {
            if (sitem.getReforge() != null && !player.isOp() && sitem.getReforge().toString().toUpperCase().contains("OVERPOWERED") | sitem.getReforge().toString().toUpperCase().contains("SUPERGENIUS")) {
                sitem.setReforge(ReforgeType.STRONK.getReforge());
                player.getInventory().setLeggings(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && !player.isOp() && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 5) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus.");
                player.getInventory().setLeggings(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 10) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus, epik hole ze cum amogus hahaha bruh lol amogus.");
                player.getInventory().setLeggings(sitem.getStack());
            }
            sitem.update();
            player.getInventory().setLeggings(this.updateItemBoost(sitem));
        }
    }

    public void updateBoots() {
        SItem sitem;
        Player player = Bukkit.getPlayer((UUID)this.uuid);
        ItemStack is = player.getInventory().getBoots();
        if (is != null && (sitem = SItem.find(is)) != null) {
            if (sitem.getReforge() != null && !player.isOp() && sitem.getReforge().toString().toUpperCase().contains("OVERPOWERED") | sitem.getReforge().toString().toUpperCase().contains("SUPERGENIUS")) {
                sitem.setReforge(ReforgeType.STRONK.getReforge());
                player.getInventory().setBoots(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && !player.isOp() && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 5) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus.");
                player.getInventory().setBoots(sitem.getStack());
            }
            if (sitem.getEnchantment(EnchantmentType.LEGION) != null && sitem.getEnchantment(EnchantmentType.LEGION).getLevel() > 10) {
                sitem.removeEnchantment(EnchantmentType.LEGION);
                player.sendMessage(ChatColor.RED + "you have illegal enchant in ur inv, that ench got wiped, haha sike u bruh lol sus, epik hole ze cum amogus hahaha bruh lol amogus.");
                player.getInventory().setBoots(sitem.getStack());
            }
            sitem.update();
            player.getInventory().setBoots(this.updateItemBoost(sitem));
        }
    }

    public ItemStack updateItemBoost(SItem sitem) {
        if (sitem.getDataBoolean("dungeons_item") && sitem.getType().getStatistics().getType() != GenericItemType.ITEM && sitem.getType().getStatistics().getType() != GenericItemType.PET && sitem.getType().getStatistics().getType() != GenericItemType.BLOCK && sitem.getType().getStatistics().getType() != GenericItemType.ACCESSORY) {
            int itemstar = sitem.getDataInt("itemStar");
            double hpbboostweapons = 0.0;
            double hpbboosthp = 0.0;
            double hpbboostdef = 0.0;
            PlayerBoostStatistics hs = sitem.getType().getBoostStatistics();
            ItemSerial is = ItemSerial.getItemBoostStatistics(sitem);
            Reforge reforge = sitem.getReforge() == null ? Reforge.blank() : sitem.getReforge();
            double bonusEn = 0.0;
            if (sitem.getType().getStatistics().getType() == GenericItemType.WEAPON && sitem.getEnchantment(EnchantmentType.ONE_FOR_ALL) != null) {
                Enchantment e2 = sitem.getEnchantment(EnchantmentType.ONE_FOR_ALL);
                bonusEn = hs.getBaseDamage() * (e2.getLevel() * 210) / 100;
            }
            if (sitem.getType().getStatistics().getType() == GenericItemType.WEAPON || sitem.getType().getStatistics().getType() == GenericItemType.RANGED_WEAPON) {
                hpbboostweapons = sitem.getDataInt("hpb") * 2;
            } else if (sitem.getType().getStatistics().getType() == GenericItemType.ARMOR) {
                hpbboosthp = sitem.getDataInt("hpb") * 4;
                hpbboostdef = sitem.getDataInt("hpb") * 2;
            }
            is.setDamage(this.getFinal((double)hs.getBaseDamage() + hpbboostweapons + bonusEn, itemstar));
            is.setStrength(this.getFinal(hs.getBaseStrength() + (hpbboostweapons + reforge.getStrength().getForRarity(sitem.getRarity())), itemstar));
            is.setCritchance(this.getFinal(hs.getBaseCritChance() + reforge.getCritChance().getForRarity(sitem.getRarity()), itemstar));
            is.setCritdamage(this.getFinal(hs.getBaseCritDamage() + reforge.getCritDamage().getForRarity(sitem.getRarity()), itemstar));
            is.setIntelligence(this.getFinal(hs.getBaseIntelligence() + reforge.getIntelligence().getForRarity(sitem.getRarity()), itemstar));
            is.setFerocity(this.getFinal(hs.getBaseFerocity() + reforge.getFerocity().getForRarity(sitem.getRarity()), itemstar));
            is.setSpeed(this.getFinal(hs.getBaseSpeed(), itemstar));
            is.setAtkSpeed(this.getFinal(hs.getBaseAttackSpeed() + reforge.getAttackSpeed().getForRarity(sitem.getRarity()), itemstar));
            is.setMagicFind(this.getFinal(hs.getBaseMagicFind(), itemstar));
            double health = hs.getBaseHealth();
            double defense = hs.getBaseDefense();
            if (sitem.isEnchantable()) {
                for (Enchantment enchantment : sitem.getEnchantments()) {
                    if (enchantment.getType() == EnchantmentType.GROWTH) {
                        health += 15.0 * (double)enchantment.getLevel();
                    }
                    if (enchantment.getType() != EnchantmentType.PROTECTION) continue;
                    defense += 3.0 * (double)enchantment.getLevel();
                }
            }
            is.setHealth(this.getFinal(health + hpbboosthp, itemstar));
            is.setDefense(this.getFinal(defense + hpbboostdef, itemstar));
            is.saveTo(sitem);
            return sitem.getStack();
        }
        return sitem.getStack();
    }

    public double getFinal(double stat, int starNum) {
        int cataLVL = Skill.getLevel(this.getCataXP(), false);
        int cataBuffPercentage = cataLVL * 5;
        int percentMstars = (starNum - 5) * 5;
        if (starNum <= 5) {
            percentMstars *= 0;
        }
        double d2 = 1.0 + (double)percentMstars / 100.0;
        return stat * ((double)(1 + percentMstars / 100) * (1.0 + 0.1 * (double)Math.min(5, starNum)) * (double)(1 + cataBuffPercentage / 100) * d2);
    }

    public void sendClickableMessage(String message, TextComponent[] hover, String commandToRun) {
        TextComponent tcp = new TextComponent(Sputnik.trans(message));
        if (hover != null) {
            tcp.setHoverEvent(new HoverEvent(HoverEvent.Action.SHOW_TEXT, (BaseComponent[])hover));
        }
        if (commandToRun != null) {
            tcp.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, commandToRun));
        }
        this.toBukkitPlayer().spigot().sendMessage((BaseComponent)tcp);
    }

    public boolean isCompletedSign() {
        return this.isCompletedSign;
    }

    public void setCompletedSign(boolean isCompletedSign) {
        this.isCompletedSign = isCompletedSign;
    }

    public long getSadancollections() {
        return this.sadancollections;
    }

    public long getTotalfloor6run() {
        return this.totalfloor6run;
    }

    public UUID getUuid() {
        return this.uuid;
    }

    public Config getConfig() {
        return this.config;
    }

    public void setCoins(long coins) {
        this.coins = coins;
    }

    public long getCoins() {
        return this.coins;
    }

    public void setBits(long bits) {
        this.bits = bits;
    }

    public long getBits() {
        return this.bits;
    }

    public void setBankCoins(long bankCoins) {
        this.bankCoins = bankCoins;
    }

    public long getBankCoins() {
        return this.bankCoins;
    }

    public void setStashedItems(List<ItemStack> stashedItems) {
        this.stashedItems = stashedItems;
    }

    public List<ItemStack> getStashedItems() {
        return this.stashedItems;
    }

    public void setCooldownAltar(int cooldownAltar) {
        this.cooldownAltar = cooldownAltar;
    }

    public int getCooldownAltar() {
        return this.cooldownAltar;
    }

    public void setHeadShot(boolean headShot) {
        this.headShot = headShot;
    }

    public boolean isHeadShot() {
        return this.headShot;
    }

    public void setPlayingSong(boolean playingSong) {
        this.playingSong = playingSong;
    }

    public boolean isPlayingSong() {
        return this.playingSong;
    }

    public void setInDanger(boolean inDanger) {
        this.inDanger = inDanger;
    }

    public boolean isInDanger() {
        return this.inDanger;
    }

    public Double getIslandX() {
        return this.islandX;
    }

    public Double getIslandZ() {
        return this.islandZ;
    }

    public void setLastRegion(Region lastRegion) {
        this.lastRegion = lastRegion;
    }

    public Region getLastRegion() {
        return this.lastRegion;
    }

    public Map<SMaterial, Integer> getQuiver() {
        return this.quiver;
    }

    public List<ActivePotionEffect> getEffects() {
        return this.effects;
    }

    public double getFarmingXP() {
        return this.farmingXP;
    }

    public void setBoneToZeroDamage(boolean boneToZeroDamage) {
        this.boneToZeroDamage = boneToZeroDamage;
    }

    public boolean isBoneToZeroDamage() {
        return this.boneToZeroDamage;
    }

    public void setCooldownAPI(boolean cooldownAPI) {
        this.cooldownAPI = cooldownAPI;
    }

    public boolean isCooldownAPI() {
        return this.cooldownAPI;
    }

    public double getMiningXP() {
        return this.miningXP;
    }

    public double getCombatXP() {
        return this.combatXP;
    }

    public double getEnchantXP() {
        return this.enchantXP;
    }

    public double getArcherXP() {
        return this.archerXP;
    }

    public double getCataXP() {
        return this.cataXP;
    }

    public double getBerserkXP() {
        return this.berserkXP;
    }

    public double getHealerXP() {
        return this.healerXP;
    }

    public double getTankXP() {
        return this.tankXP;
    }

    public double getMageXP() {
        return this.mageXP;
    }

    public double getForagingXP() {
        return this.foragingXP;
    }

    public void setSaveable(boolean saveable) {
        this.saveable = saveable;
    }

    public boolean isSaveable() {
        return this.saveable;
    }

    public void setBonusFerocity(int bonusFerocity) {
        this.bonusFerocity = bonusFerocity;
    }

    public int getBonusFerocity() {
        return this.bonusFerocity;
    }

    public void setFatalActive(boolean fatalActive) {
        this.fatalActive = fatalActive;
    }

    public boolean isFatalActive() {
        return this.fatalActive;
    }

    public void setPermanentCoins(boolean permanentCoins) {
        this.permanentCoins = permanentCoins;
    }

    public boolean isPermanentCoins() {
        return this.permanentCoins;
    }

    public void setSlayerQuest(SlayerQuest slayerQuest) {
        this.slayerQuest = slayerQuest;
    }

    public SlayerQuest getSlayerQuest() {
        return this.slayerQuest;
    }

    public List<Pet.PetItem> getPets() {
        return this.pets;
    }

    public AuctionSettings getAuctionSettings() {
        return this.auctionSettings;
    }

    public void setAuctionCreationBIN(boolean auctionCreationBIN) {
        this.auctionCreationBIN = auctionCreationBIN;
    }

    public boolean isAuctionCreationBIN() {
        return this.auctionCreationBIN;
    }

    public void setAuctionEscrow(AuctionEscrow auctionEscrow) {
        this.auctionEscrow = auctionEscrow;
    }

    public AuctionEscrow getAuctionEscrow() {
        return this.auctionEscrow;
    }

    public void setVoidlingWardenActive(boolean voidlingWardenActive) {
        this.voidlingWardenActive = voidlingWardenActive;
    }

    public boolean isVoidlingWardenActive() {
        return this.voidlingWardenActive;
    }

    public void setWaitingForSign(boolean waitingForSign) {
        this.waitingForSign = waitingForSign;
    }

    public boolean isWaitingForSign() {
        return this.waitingForSign;
    }

    public void setSignContent(String signContent) {
        this.signContent = signContent;
    }

    public String getSignContent() {
        return this.signContent;
    }
}

