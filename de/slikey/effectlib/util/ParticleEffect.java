/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Color
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.entity.Player
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.util;

import de.slikey.effectlib.util.ReflectionUtils;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.util.Vector;

public enum ParticleEffect {
    EXPLOSION_NORMAL("explode", 0, -1),
    EXPLOSION_LARGE("largeexplode", 1, -1),
    EXPLOSION_HUGE("hugeexplosion", 2, -1),
    FIREWORKS_SPARK("fireworksSpark", 3, -1),
    WATER_BUBBLE("bubble", 4, -1, false, true),
    WATER_SPLASH("splash", 5, -1),
    WATER_WAKE("wake", 6, 7),
    SUSPENDED("suspended", 7, -1, false, true),
    SUSPENDED_DEPTH("depthSuspend", 8, -1),
    CRIT("crit", 9, -1),
    CRIT_MAGIC("magicCrit", 10, -1),
    SMOKE_NORMAL("smoke", 11, -1),
    SMOKE_LARGE("largesmoke", 12, -1),
    SPELL("spell", 13, -1),
    SPELL_INSTANT("instantSpell", 14, -1),
    SPELL_MOB("mobSpell", 15, -1),
    SPELL_MOB_AMBIENT("mobSpellAmbient", 16, -1),
    SPELL_WITCH("witchMagic", 17, -1),
    DRIP_WATER("dripWater", 18, -1),
    DRIP_LAVA("dripLava", 19, -1),
    VILLAGER_ANGRY("angryVillager", 20, -1),
    VILLAGER_HAPPY("happyVillager", 21, -1),
    TOWN_AURA("townaura", 22, -1),
    NOTE("note", 23, -1),
    PORTAL("portal", 24, -1),
    ENCHANTMENT_TABLE("enchantmenttable", 25, -1),
    FLAME("flame", 26, -1),
    LAVA("lava", 27, -1),
    FOOTSTEP("footstep", 28, -1),
    CLOUD("cloud", 29, -1),
    REDSTONE("reddust", 30, -1),
    SNOWBALL("snowballpoof", 31, -1),
    SNOW_SHOVEL("snowshovel", 32, -1),
    SLIME("slime", 33, -1),
    HEART("heart", 34, -1),
    BARRIER("barrier", 35, 8),
    ITEM_CRACK("iconcrack", 36, -1, true),
    BLOCK_CRACK("blockcrack", 37, -1, true),
    BLOCK_DUST("blockdust", 38, 7, true),
    WATER_DROP("droplet", 39, 8),
    ITEM_TAKE("take", 40, 8),
    MOB_APPEARANCE("mobappearance", 41, 8),
    DRAGON_BREATH("dragonbreath", 42, 9),
    END_ROD("endRod", 43, 9),
    DAMAGE_INDICATOR("damageIndicator", 44, 9),
    SWEEP_ATTACK("sweepAttack", 45, 9);

    private static final int LONG_DISTANCE = 16;
    private static final int LONG_DISTANCE_SQUARED = 256;
    private static final Map<String, ParticleEffect> NAME_MAP;
    private static final Map<Integer, ParticleEffect> ID_MAP;
    private final String name;
    private final int id;
    private final int requiredVersion;
    private final boolean requiresData;
    private final boolean requiresWater;

    private ParticleEffect(String name, int id, int requiredVersion, boolean requiresData, boolean requiresWater) {
        this.name = name;
        this.id = id;
        this.requiredVersion = requiredVersion;
        this.requiresData = requiresData;
        this.requiresWater = requiresWater;
    }

    private ParticleEffect(String name, int id, int requiredVersion, boolean requiresData) {
        this(name, id, requiredVersion, requiresData, false);
    }

    private ParticleEffect(String name, int id, int requiredVersion) {
        this(name, id, requiredVersion, false);
    }

    public String getName() {
        return this.name;
    }

    public int getId() {
        return this.id;
    }

    public int getRequiredVersion() {
        return this.requiredVersion;
    }

    public boolean getRequiresData() {
        return this.requiresData;
    }

    public boolean getRequiresWater() {
        return this.requiresWater;
    }

    public boolean isSupported() {
        if (this.requiredVersion == -1) {
            return true;
        }
        return ParticlePacket.getVersion() >= this.requiredVersion;
    }

    public static ParticleEffect fromName(String name) {
        for (Map.Entry<String, ParticleEffect> entry : NAME_MAP.entrySet()) {
            if (!entry.getKey().equalsIgnoreCase(name)) continue;
            return entry.getValue();
        }
        return null;
    }

    public static ParticleEffect fromId(int id) {
        for (Map.Entry<Integer, ParticleEffect> entry : ID_MAP.entrySet()) {
            if (entry.getKey() != id) continue;
            return entry.getValue();
        }
        return null;
    }

    private static boolean isWater(Location location) {
        Material material = location.getBlock().getType();
        return material == Material.WATER || material == Material.STATIONARY_WATER;
    }

    private static boolean isLongDistance(Location location, List<Player> players) {
        for (Player player : players) {
            if (!(player.getLocation().distanceSquared(location) > 256.0)) continue;
            return true;
        }
        return false;
    }

    private static boolean isDataCorrect(ParticleEffect effect, ParticleData data) {
        return (effect == BLOCK_CRACK || effect == BLOCK_DUST) && data instanceof BlockData || effect == ITEM_CRACK && data instanceof ItemData;
    }

    public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect requires additional data");
        }
        if (this.requiresWater && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 16.0, null).sendTo(center, range);
    }

    public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect requires additional data");
        }
        if (this.requiresWater && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, ParticleEffect.isLongDistance(center, players), null).sendTo(center, players);
    }

    public void display(float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player ... players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        this.display(offsetX, offsetY, offsetZ, speed, amount, center, Arrays.asList(players));
    }

    public void display(Vector direction, float speed, Location center, double range) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect requires additional data");
        }
        if (this.requiresWater && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, direction, speed, range > 16.0, null).sendTo(center, range);
    }

    public void display(Vector direction, float speed, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect requires additional data");
        }
        if (this.requiresWater && !ParticleEffect.isWater(center)) {
            throw new IllegalArgumentException("There is no water at the center location");
        }
        new ParticlePacket(this, direction, speed, ParticleEffect.isLongDistance(center, players), null).sendTo(center, players);
    }

    public void display(Vector direction, float speed, Location center, Player ... players) throws ParticleVersionException, ParticleDataException, IllegalArgumentException {
        this.display(direction, speed, center, Arrays.asList(players));
    }

    public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, double range) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (!this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect does not require additional data");
        }
        if (data == null) {
            return;
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect: " + data + " for " + (Object)((Object)this));
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, range > 16.0, data).sendTo(center, range);
    }

    public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (!this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect does not require additional data");
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect: " + data + " for " + (Object)((Object)this));
        }
        new ParticlePacket(this, offsetX, offsetY, offsetZ, speed, amount, ParticleEffect.isLongDistance(center, players), data).sendTo(center, players);
    }

    public void display(ParticleData data, float offsetX, float offsetY, float offsetZ, float speed, int amount, Location center, Player ... players) throws ParticleVersionException, ParticleDataException {
        this.display(data, offsetX, offsetY, offsetZ, speed, amount, center, Arrays.asList(players));
    }

    public void display(ParticleData data, Vector direction, float speed, Location center, double range) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (!this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect does not require additional data");
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect: " + data + " for " + (Object)((Object)this));
        }
        new ParticlePacket(this, direction, speed, range > 16.0, data).sendTo(center, range);
    }

    public void display(ParticleData data, Vector direction, float speed, Location center, List<Player> players) throws ParticleVersionException, ParticleDataException {
        if (!this.isSupported()) {
            throw new ParticleVersionException("The " + (Object)((Object)this) + " particle effect is not supported by your server version " + ParticlePacket.getVersion());
        }
        if (!this.requiresData) {
            throw new ParticleDataException("The " + (Object)((Object)this) + " particle effect does not require additional data");
        }
        if (!ParticleEffect.isDataCorrect(this, data)) {
            throw new ParticleDataException("The particle data type is incorrect: " + data + " for " + (Object)((Object)this));
        }
        new ParticlePacket(this, direction, speed, ParticleEffect.isLongDistance(center, players), data).sendTo(center, players);
    }

    public void display(ParticleData data, Vector direction, float speed, Location center, Player ... players) throws ParticleVersionException, ParticleDataException {
        this.display(data, direction, speed, center, Arrays.asList(players));
    }

    @Deprecated
    public void display(Location center, double range, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        this.display(offsetX, offsetY, offsetZ, speed, amount, center, range);
    }

    @Deprecated
    public void display(Location center, double range) {
        this.display(0.0f, 0.0f, 0.0f, 0.0f, 1, center, range);
    }

    @Deprecated
    public void display(ParticleData data, Location center, double range, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        if (this.requiresData) {
            this.display(data, offsetX, offsetY, offsetZ, speed, amount, center, range);
        } else {
            this.display(offsetX, offsetY, offsetZ, speed, amount, center, range);
        }
    }

    public void display(ParticleData data, Location center, Color color, double range, float offsetX, float offsetY, float offsetZ, float speed, int amount) {
        if (color != null && (this == REDSTONE || this == SPELL_MOB || this == SPELL_MOB_AMBIENT)) {
            amount = 0;
            if (speed == 0.0f) {
                speed = 1.0f;
            }
            offsetX = (float)color.getRed() / 255.0f;
            offsetY = (float)color.getGreen() / 255.0f;
            offsetZ = (float)color.getBlue() / 255.0f;
            if (offsetX < Float.MIN_NORMAL) {
                offsetX = Float.MIN_NORMAL;
            }
        }
        if (this.requiresData) {
            this.display(data, offsetX, offsetY, offsetZ, speed, amount, center, range);
        } else {
            this.display(offsetX, offsetY, offsetZ, speed, amount, center, range);
        }
    }

    public boolean requiresData() {
        return this.requiresData;
    }

    public boolean requiresWater() {
        return this.requiresWater;
    }

    public ParticleData getData(Material material, Byte blockData) {
        ParticleData data = null;
        if (blockData == null) {
            blockData = 0;
        }
        if ((this == BLOCK_CRACK || this == ITEM_CRACK || this == BLOCK_DUST) && material != null && material != Material.AIR) {
            data = this == ITEM_CRACK ? new ItemData(material, blockData) : new BlockData(material, blockData);
        }
        return data;
    }

    static {
        NAME_MAP = new HashMap<String, ParticleEffect>();
        ID_MAP = new HashMap<Integer, ParticleEffect>();
        for (ParticleEffect effect : ParticleEffect.values()) {
            NAME_MAP.put(effect.name, effect);
            ID_MAP.put(effect.id, effect);
        }
    }

    public static final class ParticlePacket {
        private static int version;
        private static boolean isKcauldron;
        private static Class<?> enumParticle;
        private static Constructor<?> packetConstructor;
        private static Method getHandle;
        private static Field playerConnection;
        private static Method sendPacket;
        private static boolean initialized;
        private final ParticleEffect effect;
        private final float offsetX;
        private final float offsetY;
        private final float offsetZ;
        private final float speed;
        private final int amount;
        private final boolean longDistance;
        private final ParticleData data;
        private Object packet;

        public ParticlePacket(ParticleEffect effect, float offsetX, float offsetY, float offsetZ, float speed, int amount, boolean longDistance, ParticleData data) throws IllegalArgumentException {
            ParticlePacket.initialize();
            if (speed < 0.0f) {
                throw new IllegalArgumentException("The speed is lower than 0");
            }
            if (amount < 0) {
                throw new IllegalArgumentException("The amount is lower than 0");
            }
            this.effect = effect;
            this.offsetX = offsetX;
            this.offsetY = offsetY;
            this.offsetZ = offsetZ;
            this.speed = speed;
            this.amount = amount;
            this.longDistance = longDistance;
            this.data = data;
        }

        public ParticlePacket(ParticleEffect effect, Vector direction, float speed, boolean longDistance, ParticleData data) throws IllegalArgumentException {
            ParticlePacket.initialize();
            if (speed < 0.0f) {
                throw new IllegalArgumentException("The speed is lower than 0");
            }
            this.effect = effect;
            this.offsetX = (float)direction.getX();
            this.offsetY = (float)direction.getY();
            this.offsetZ = (float)direction.getZ();
            this.speed = speed;
            this.amount = 0;
            this.longDistance = longDistance;
            this.data = data;
        }

        public static void initialize() throws VersionIncompatibleException {
            if (initialized) {
                return;
            }
            try {
                isKcauldron = false;
                version = Integer.parseInt(Character.toString(ReflectionUtils.PackageType.getServerVersion().charAt(3)));
                if (version > 7) {
                    enumParticle = ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass("EnumParticle");
                }
                Class<?> packetClass = ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass(version < 7 ? "Packet63WorldParticles" : "PacketPlayOutWorldParticles");
                packetConstructor = ReflectionUtils.getConstructor(packetClass, new Class[0]);
                getHandle = ReflectionUtils.getMethod("CraftPlayer", ReflectionUtils.PackageType.CRAFTBUKKIT_ENTITY, "getHandle", new Class[0]);
                playerConnection = ReflectionUtils.getField("EntityPlayer", ReflectionUtils.PackageType.MINECRAFT_SERVER, false, "playerConnection");
                sendPacket = ReflectionUtils.getMethod(playerConnection.getType(), "sendPacket", ReflectionUtils.PackageType.MINECRAFT_SERVER.getClass("Packet"));
            } catch (Exception exception) {
                try {
                    isKcauldron = true;
                    version = Integer.parseInt(Character.toString(ReflectionUtils.PackageType.getServerVersion().charAt(3)));
                    Class<?> packetClass = Class.forName("net.minecraft.network.play.server.S2APacketParticles");
                    packetConstructor = ReflectionUtils.getConstructor(packetClass, new Class[0]);
                    getHandle = ReflectionUtils.getMethod("CraftPlayer", ReflectionUtils.PackageType.CRAFTBUKKIT_ENTITY, "getHandle", new Class[0]);
                    playerConnection = Class.forName("net.minecraft.entity.player.EntityPlayerMP").getDeclaredField("field_71135_a");
                    sendPacket = playerConnection.getType().getDeclaredMethod("func_147359_a", Class.forName("net.minecraft.network.Packet"));
                } catch (Exception e2) {
                    throw new VersionIncompatibleException("Your current bukkit version seems to be incompatible with this library", exception);
                }
            }
            initialized = true;
        }

        public static int getVersion() {
            return version;
        }

        public static boolean isInitialized() {
            return initialized;
        }

        public void sendTo(Location center, Player player) throws PacketInstantiationException, PacketSendingException {
            if (isKcauldron) {
                this.sendToWithKCauldron(center, player);
            } else {
                this.sendToWithBukkit(center, player);
            }
        }

        private void sendToWithKCauldron(Location center, Player player) {
            if (this.packet == null) {
                try {
                    this.packet = packetConstructor.newInstance(new Object[0]);
                    ReflectionUtils.setValue(this.packet, true, "field_149236_a", this.effect.getName());
                    ReflectionUtils.setValue(this.packet, true, "field_149234_b", Float.valueOf((float)center.getX()));
                    ReflectionUtils.setValue(this.packet, true, "field_149235_c", Float.valueOf((float)center.getY()));
                    ReflectionUtils.setValue(this.packet, true, "field_149232_d", Float.valueOf((float)center.getZ()));
                    ReflectionUtils.setValue(this.packet, true, "field_149233_e", Float.valueOf(this.offsetX));
                    ReflectionUtils.setValue(this.packet, true, "field_149230_f", Float.valueOf(this.offsetY));
                    ReflectionUtils.setValue(this.packet, true, "field_149231_g", Float.valueOf(this.offsetZ));
                    ReflectionUtils.setValue(this.packet, true, "field_149237_h", Float.valueOf(this.speed));
                    ReflectionUtils.setValue(this.packet, true, "field_149238_i", this.amount);
                } catch (Exception exception) {
                    throw new PacketInstantiationException("Packet instantiation failed", exception);
                }
            }
            try {
                sendPacket.invoke(playerConnection.get(getHandle.invoke(player, new Object[0])), this.packet);
            } catch (Exception exception) {
                throw new PacketSendingException("Failed to send the packet to player '" + player.getName() + "'", exception);
            }
        }

        private void sendToWithBukkit(Location center, Player player) {
            if (this.packet == null) {
                try {
                    this.packet = packetConstructor.newInstance(new Object[0]);
                    Object id = version < 8 ? this.effect.getName() + (this.data == null ? "" : this.data.getPacketDataString()) : enumParticle.getEnumConstants()[this.effect.getId()];
                    ReflectionUtils.setValue(this.packet, true, "a", id);
                    ReflectionUtils.setValue(this.packet, true, "b", Float.valueOf((float)center.getX()));
                    ReflectionUtils.setValue(this.packet, true, "c", Float.valueOf((float)center.getY()));
                    ReflectionUtils.setValue(this.packet, true, "d", Float.valueOf((float)center.getZ()));
                    ReflectionUtils.setValue(this.packet, true, "e", Float.valueOf(this.offsetX));
                    ReflectionUtils.setValue(this.packet, true, "f", Float.valueOf(this.offsetY));
                    ReflectionUtils.setValue(this.packet, true, "g", Float.valueOf(this.offsetZ));
                    ReflectionUtils.setValue(this.packet, true, "h", Float.valueOf(this.speed));
                    ReflectionUtils.setValue(this.packet, true, "i", this.amount);
                    if (version > 7) {
                        ReflectionUtils.setValue(this.packet, true, "j", this.longDistance);
                        ReflectionUtils.setValue(this.packet, true, "k", this.data == null ? new int[]{} : this.data.getPacketData());
                    }
                } catch (Exception exception) {
                    throw new PacketInstantiationException("Packet instantiation failed", exception);
                }
            }
            try {
                sendPacket.invoke(playerConnection.get(getHandle.invoke(player, new Object[0])), this.packet);
            } catch (Exception exception) {
                throw new PacketSendingException("Failed to send the packet to player '" + player.getName() + "'", exception);
            }
        }

        public void sendTo(Location center, List<Player> players) throws IllegalArgumentException {
            if (players.isEmpty()) {
                throw new IllegalArgumentException("The player list is empty");
            }
            for (Player player : players) {
                this.sendTo(center, player);
            }
        }

        public void sendTo(Location center, double range) throws IllegalArgumentException {
            if (range < 1.0) {
                throw new IllegalArgumentException("The range is lower than 1");
            }
            String worldName = center.getWorld().getName();
            double squared = range * range;
            for (Player player : Bukkit.getOnlinePlayers()) {
                if (!player.getWorld().getName().equals(worldName) || player.getLocation().distanceSquared(center) > squared) continue;
                this.sendTo(center, player);
            }
        }

        private static final class PacketSendingException
        extends RuntimeException {
            private static final long serialVersionUID = 3203085387160737484L;

            public PacketSendingException(String message, Throwable cause) {
                super(message, cause);
            }
        }

        private static final class PacketInstantiationException
        extends RuntimeException {
            private static final long serialVersionUID = 3203085387160737484L;

            public PacketInstantiationException(String message, Throwable cause) {
                super(message, cause);
            }
        }

        private static final class VersionIncompatibleException
        extends RuntimeException {
            private static final long serialVersionUID = 3203085387160737484L;

            public VersionIncompatibleException(String message, Throwable cause) {
                super(message, cause);
            }
        }
    }

    private static final class ParticleVersionException
    extends RuntimeException {
        private static final long serialVersionUID = 3203085387160737484L;

        public ParticleVersionException(String message) {
            super(message);
        }
    }

    private static final class ParticleDataException
    extends RuntimeException {
        private static final long serialVersionUID = 3203085387160737484L;

        public ParticleDataException(String message) {
            super(message);
        }
    }

    public static final class BlockData
    extends ParticleData {
        public BlockData(Material material, byte data) throws IllegalArgumentException {
            super(material, data);
            if (!material.isBlock()) {
                throw new IllegalArgumentException("The material is not a block");
            }
        }
    }

    public static final class ItemData
    extends ParticleData {
        public ItemData(Material material, byte data) {
            super(material, data);
        }
    }

    public static abstract class ParticleData {
        private final Material material;
        private final byte data;
        private final int[] packetData;

        public ParticleData(Material material, byte data) {
            this.material = material;
            this.data = data;
            this.packetData = new int[]{data << 12 | material.getId() & 0xFFF};
        }

        public Material getMaterial() {
            return this.material;
        }

        public byte getData() {
            return this.data;
        }

        public int[] getPacketData() {
            return this.packetData;
        }

        public String getPacketDataString() {
            return "_" + this.packetData[0] + "_" + this.packetData[1];
        }
    }
}

