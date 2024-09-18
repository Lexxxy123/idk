/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 */
package de.slikey.effectlib.particle;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import org.bukkit.Bukkit;

public final class ReflectionHandler {
    private ReflectionHandler() {
    }

    public static Class<?> getClass(String name, PackageType type) throws Exception {
        return Class.forName((Object)((Object)type) + "." + name);
    }

    public static Class<?> getClass(String name, SubPackageType type) throws Exception {
        return Class.forName((Object)((Object)type) + "." + name);
    }

    public static Constructor<?> getConstructor(Class<?> clazz, Class<?> ... parameterTypes) {
        Class<?>[] p2 = DataType.convertToPrimitive(parameterTypes);
        for (Constructor<?> c2 : clazz.getConstructors()) {
            if (!DataType.equalsArray(DataType.convertToPrimitive(c2.getParameterTypes()), p2)) continue;
            return c2;
        }
        return null;
    }

    public static Constructor<?> getConstructor(String className, PackageType type, Class<?> ... parameterTypes) throws Exception {
        return ReflectionHandler.getConstructor(ReflectionHandler.getClass(className, type), parameterTypes);
    }

    public static Constructor<?> getConstructor(String className, SubPackageType type, Class<?> ... parameterTypes) throws Exception {
        return ReflectionHandler.getConstructor(ReflectionHandler.getClass(className, type), parameterTypes);
    }

    public static Object newInstance(Class<?> clazz, Object ... args) throws Exception {
        return ReflectionHandler.getConstructor(clazz, DataType.convertToPrimitive(args)).newInstance(args);
    }

    public static Object newInstance(String className, PackageType type, Object ... args) throws Exception {
        return ReflectionHandler.newInstance(ReflectionHandler.getClass(className, type), args);
    }

    public static Object newInstance(String className, SubPackageType type, Object ... args) throws Exception {
        return ReflectionHandler.newInstance(ReflectionHandler.getClass(className, type), args);
    }

    public static Method getMethod(Class<?> clazz, String name, Class<?> ... parameterTypes) {
        Class<?>[] p2 = DataType.convertToPrimitive(parameterTypes);
        for (Method m2 : clazz.getMethods()) {
            if (!m2.getName().equals(name) || !DataType.equalsArray(DataType.convertToPrimitive(m2.getParameterTypes()), p2)) continue;
            return m2;
        }
        return null;
    }

    public static Method getMethod(String className, PackageType type, String name, Class<?> ... parameterTypes) throws Exception {
        return ReflectionHandler.getMethod(ReflectionHandler.getClass(className, type), name, parameterTypes);
    }

    public static Method getMethod(String className, SubPackageType type, String name, Class<?> ... parameterTypes) throws Exception {
        return ReflectionHandler.getMethod(ReflectionHandler.getClass(className, type), name, parameterTypes);
    }

    public static Object invokeMethod(String name, Object instance, Object ... args) throws Exception {
        return ReflectionHandler.getMethod(instance.getClass(), name, DataType.convertToPrimitive(args)).invoke(instance, args);
    }

    public static Object invokeMethod(Class<?> clazz, String name, Object instance, Object ... args) throws Exception {
        return ReflectionHandler.getMethod(clazz, name, DataType.convertToPrimitive(args)).invoke(instance, args);
    }

    public static Object invokeMethod(String className, PackageType type, String name, Object instance, Object ... args) throws Exception {
        return ReflectionHandler.invokeMethod(ReflectionHandler.getClass(className, type), name, instance, args);
    }

    public static Object invokeMethod(String className, SubPackageType type, String name, Object instance, Object ... args) throws Exception {
        return ReflectionHandler.invokeMethod(ReflectionHandler.getClass(className, type), name, instance, args);
    }

    public static Field getField(Class<?> clazz, String name) throws Exception {
        Field f2 = clazz.getField(name);
        f2.setAccessible(true);
        return f2;
    }

    public static Field getField(String className, PackageType type, String name) throws Exception {
        return ReflectionHandler.getField(ReflectionHandler.getClass(className, type), name);
    }

    public static Field getField(String className, SubPackageType type, String name) throws Exception {
        return ReflectionHandler.getField(ReflectionHandler.getClass(className, type), name);
    }

    public static Field getDeclaredField(Class<?> clazz, String name) throws Exception {
        Field f2 = clazz.getDeclaredField(name);
        f2.setAccessible(true);
        return f2;
    }

    public static Field getDeclaredField(String className, PackageType type, String name) throws Exception {
        return ReflectionHandler.getDeclaredField(ReflectionHandler.getClass(className, type), name);
    }

    public static Field getDeclaredField(String className, SubPackageType type, String name) throws Exception {
        return ReflectionHandler.getDeclaredField(ReflectionHandler.getClass(className, type), name);
    }

    public static Object getValue(Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getField(instance.getClass(), fieldName).get(instance);
    }

    public static Object getValue(Class<?> clazz, Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getField(clazz, fieldName).get(instance);
    }

    public static Object getValue(String className, PackageType type, Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getValue(ReflectionHandler.getClass(className, type), instance, fieldName);
    }

    public static Object getValue(String className, SubPackageType type, Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getValue(ReflectionHandler.getClass(className, type), instance, fieldName);
    }

    public static Object getDeclaredValue(Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getDeclaredField(instance.getClass(), fieldName).get(instance);
    }

    public static Object getDeclaredValue(Class<?> clazz, Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getDeclaredField(clazz, fieldName).get(instance);
    }

    public static Object getDeclaredValue(String className, PackageType type, Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getDeclaredValue(ReflectionHandler.getClass(className, type), instance, fieldName);
    }

    public static Object getDeclaredValue(String className, SubPackageType type, Object instance, String fieldName) throws Exception {
        return ReflectionHandler.getDeclaredValue(ReflectionHandler.getClass(className, type), instance, fieldName);
    }

    public static void setValue(Object instance, String fieldName, Object fieldValue) throws Exception {
        Field f2 = ReflectionHandler.getField(instance.getClass(), fieldName);
        f2.set(instance, fieldValue);
    }

    public static void setValue(Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setValue(instance, pair.getName(), pair.getValue());
    }

    public static void setValue(Class<?> clazz, Object instance, String fieldName, Object fieldValue) throws Exception {
        Field f2 = ReflectionHandler.getField(clazz, fieldName);
        f2.set(instance, fieldValue);
    }

    public static void setValue(Class<?> clazz, Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setValue(clazz, instance, pair.getName(), pair.getValue());
    }

    public static void setValue(String className, PackageType type, Object instance, String fieldName, Object fieldValue) throws Exception {
        ReflectionHandler.setValue(ReflectionHandler.getClass(className, type), instance, fieldName, fieldValue);
    }

    public static void setValue(String className, PackageType type, Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setValue(className, type, instance, pair.getName(), pair.getValue());
    }

    public static void setValue(String className, SubPackageType type, Object instance, String fieldName, Object fieldValue) throws Exception {
        ReflectionHandler.setValue(ReflectionHandler.getClass(className, type), instance, fieldName, fieldValue);
    }

    public static void setValue(String className, SubPackageType type, Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setValue(className, type, instance, pair.getName(), pair.getValue());
    }

    public static void setValues(Object instance, FieldPair ... pairs) throws Exception {
        for (FieldPair pair : pairs) {
            ReflectionHandler.setValue(instance, pair);
        }
    }

    public static void setValues(Class<?> clazz, Object instance, FieldPair ... pairs) throws Exception {
        for (FieldPair pair : pairs) {
            ReflectionHandler.setValue(clazz, instance, pair);
        }
    }

    public static void setValues(String className, PackageType type, Object instance, FieldPair ... pairs) throws Exception {
        ReflectionHandler.setValues(ReflectionHandler.getClass(className, type), instance, pairs);
    }

    public static void setValues(String className, SubPackageType type, Object instance, FieldPair ... pairs) throws Exception {
        ReflectionHandler.setValues(ReflectionHandler.getClass(className, type), instance, pairs);
    }

    public static void setDeclaredValue(Object instance, String fieldName, Object fieldValue) throws Exception {
        Field f2 = ReflectionHandler.getDeclaredField(instance.getClass(), fieldName);
        f2.set(instance, fieldValue);
    }

    public static void setDeclaredValue(Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setDeclaredValue(instance, pair.getName(), pair.getValue());
    }

    public static void setDeclaredValue(Class<?> clazz, Object instance, String fieldName, Object fieldValue) throws Exception {
        Field f2 = ReflectionHandler.getDeclaredField(clazz, fieldName);
        f2.set(instance, fieldValue);
    }

    public static void setDeclaredValue(Class<?> clazz, Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setDeclaredValue(clazz, instance, pair.getName(), pair.getValue());
    }

    public static void setDeclaredValue(String className, PackageType type, Object instance, String fieldName, Object fieldValue) throws Exception {
        ReflectionHandler.setDeclaredValue(ReflectionHandler.getClass(className, type), instance, fieldName, fieldValue);
    }

    public static void setDeclaredValue(String className, PackageType type, Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setDeclaredValue(className, type, instance, pair.getName(), pair.getValue());
    }

    public static void setDeclaredValue(String className, SubPackageType type, Object instance, String fieldName, Object fieldValue) throws Exception {
        ReflectionHandler.setDeclaredValue(ReflectionHandler.getClass(className, type), instance, fieldName, fieldValue);
    }

    public static void setDeclaredValue(String className, SubPackageType type, Object instance, FieldPair pair) throws Exception {
        ReflectionHandler.setDeclaredValue(className, type, instance, pair.getName(), pair.getValue());
    }

    public static void setDeclaredValues(Object instance, FieldPair ... pairs) throws Exception {
        for (FieldPair pair : pairs) {
            ReflectionHandler.setDeclaredValue(instance, pair);
        }
    }

    public static void setDeclaredValues(Class<?> clazz, Object instance, FieldPair ... pairs) throws Exception {
        for (FieldPair pair : pairs) {
            ReflectionHandler.setDeclaredValue(clazz, instance, pair);
        }
    }

    public static void setDeclaredValues(String className, PackageType type, Object instance, FieldPair ... pairs) throws Exception {
        ReflectionHandler.setDeclaredValues(ReflectionHandler.getClass(className, type), instance, pairs);
    }

    public static void setDeclaredValues(String className, SubPackageType type, Object instance, FieldPair ... pairs) throws Exception {
        ReflectionHandler.setDeclaredValues(ReflectionHandler.getClass(className, type), instance, pairs);
    }

    public static enum PacketType {
        HANDSHAKING_IN_SET_PROTOCOL("PacketHandshakingInSetProtocol"),
        LOGIN_IN_ENCRYPTION_BEGIN("PacketLoginInEncryptionBegin"),
        LOGIN_IN_START("PacketLoginInStart"),
        LOGIN_OUT_DISCONNECT("PacketLoginOutDisconnect"),
        LOGIN_OUT_ENCRYPTION_BEGIN("PacketLoginOutEncryptionBegin"),
        LOGIN_OUT_SUCCESS("PacketLoginOutSuccess"),
        PLAY_IN_ABILITIES("PacketPlayInAbilities"),
        PLAY_IN_ARM_ANIMATION("PacketPlayInArmAnimation"),
        PLAY_IN_BLOCK_DIG("PacketPlayInBlockDig"),
        PLAY_IN_BLOCK_PLACE("PacketPlayInBlockPlace"),
        PLAY_IN_CHAT("PacketPlayInChat"),
        PLAY_IN_CLIENT_COMMAND("PacketPlayInClientCommand"),
        PLAY_IN_CLOSE_WINDOW("PacketPlayInCloseWindow"),
        PLAY_IN_CUSTOM_PAYLOAD("PacketPlayInCustomPayload"),
        PLAY_IN_ENCHANT_ITEM("PacketPlayInEnchantItem"),
        PLAY_IN_ENTITY_ACTION("PacketPlayInEntityAction"),
        PLAY_IN_FLYING("PacketPlayInFlying"),
        PLAY_IN_HELD_ITEM_SLOT("PacketPlayInHeldItemSlot"),
        PLAY_IN_KEEP_ALIVE("PacketPlayInKeepAlive"),
        PLAY_IN_LOOK("PacketPlayInLook"),
        PLAY_IN_POSITION("PacketPlayInPosition"),
        PLAY_IN_POSITION_LOOK("PacketPlayInPositionLook"),
        PLAY_IN_SET_CREATIVE_SLOT("PacketPlayInSetCreativeSlot "),
        PLAY_IN_SETTINGS("PacketPlayInSettings"),
        PLAY_IN_STEER_VEHICLE("PacketPlayInSteerVehicle"),
        PLAY_IN_TAB_COMPLETE("PacketPlayInTabComplete"),
        PLAY_IN_TRANSACTION("PacketPlayInTransaction"),
        PLAY_IN_UPDATE_SIGN("PacketPlayInUpdateSign"),
        PLAY_IN_USE_ENTITY("PacketPlayInUseEntity"),
        PLAY_IN_WINDOW_CLICK("PacketPlayInWindowClick"),
        PLAY_OUT_ABILITIES("PacketPlayOutAbilities"),
        PLAY_OUT_ANIMATION("PacketPlayOutAnimation"),
        PLAY_OUT_ATTACH_ENTITY("PacketPlayOutAttachEntity"),
        PLAY_OUT_BED("PacketPlayOutBed"),
        PLAY_OUT_BLOCK_ACTION("PacketPlayOutBlockAction"),
        PLAY_OUT_BLOCK_BREAK_ANIMATION("PacketPlayOutBlockBreakAnimation"),
        PLAY_OUT_BLOCK_CHANGE("PacketPlayOutBlockChange"),
        PLAY_OUT_CHAT("PacketPlayOutChat"),
        PLAY_OUT_CLOSE_WINDOW("PacketPlayOutCloseWindow"),
        PLAY_OUT_COLLECT("PacketPlayOutCollect"),
        PLAY_OUT_CRAFT_PROGRESS_BAR("PacketPlayOutCraftProgressBar"),
        PLAY_OUT_CUSTOM_PAYLOAD("PacketPlayOutCustomPayload"),
        PLAY_OUT_ENTITY("PacketPlayOutEntity"),
        PLAY_OUT_ENTITY_DESTROY("PacketPlayOutEntityDestroy"),
        PLAY_OUT_ENTITY_EFFECT("PacketPlayOutEntityEffect"),
        PLAY_OUT_ENTITY_EQUIPMENT("PacketPlayOutEntityEquipment"),
        PLAY_OUT_ENTITY_HEAD_ROTATION("PacketPlayOutEntityHeadRotation"),
        PLAY_OUT_ENTITY_LOOK("PacketPlayOutEntityLook"),
        PLAY_OUT_ENTITY_METADATA("PacketPlayOutEntityMetadata"),
        PLAY_OUT_ENTITY_STATUS("PacketPlayOutEntityStatus"),
        PLAY_OUT_ENTITY_TELEPORT("PacketPlayOutEntityTeleport"),
        PLAY_OUT_ENTITY_VELOCITY("PacketPlayOutEntityVelocity"),
        PLAY_OUT_EXPERIENCE("PacketPlayOutExperience"),
        PLAY_OUT_EXPLOSION("PacketPlayOutExplosion"),
        PLAY_OUT_GAME_STATE_CHANGE("PacketPlayOutGameStateChange"),
        PLAY_OUT_HELD_ITEM_SLOT("PacketPlayOutHeldItemSlot"),
        PLAY_OUT_KEEP_ALIVE("PacketPlayOutKeepAlive"),
        PLAY_OUT_KICK_DISCONNECT("PacketPlayOutKickDisconnect"),
        PLAY_OUT_LOGIN("PacketPlayOutLogin"),
        PLAY_OUT_MAP("PacketPlayOutMap"),
        PLAY_OUT_MAP_CHUNK("PacketPlayOutMapChunk"),
        PLAY_OUT_MAP_CHUNK_BULK("PacketPlayOutMapChunkBulk"),
        PLAY_OUT_MULTI_BLOCK_CHANGE("PacketPlayOutMultiBlockChange"),
        PLAY_OUT_NAMED_ENTITY_SPAWN("PacketPlayOutNamedEntitySpawn"),
        PLAY_OUT_NAMED_SOUND_EFFECT("PacketPlayOutNamedSoundEffect"),
        PLAY_OUT_OPEN_SIGN_EDITOR("PacketPlayOutOpenSignEditor"),
        PLAY_OUT_OPEN_WINDOW("PacketPlayOutOpenWindow"),
        PLAY_OUT_PLAYER_INFO("PacketPlayOutPlayerInfo"),
        PLAY_OUT_POSITION("PacketPlayOutPosition"),
        PLAY_OUT_REL_ENTITY_MOVE("PacketPlayOutRelEntityMove"),
        PLAY_OUT_REL_ENTITY_MOVE_LOOK("PacketPlayOutRelEntityMoveLook"),
        PLAY_OUT_REMOVE_ENTITY_EFFECT("PacketPlayOutRemoveEntityEffect"),
        PLAY_OUT_RESPAWN("PacketPlayOutRespawn"),
        PLAY_OUT_SCOREBOARD_DISPLAY_OBJECTIVE("PacketPlayOutScoreboardDisplayObjective"),
        PLAY_OUT_SCOREBOARD_OBJECTIVE("PacketPlayOutScoreboardObjective"),
        PLAY_OUT_SCOREBOARD_SCORE("PacketPlayOutScoreboardScore"),
        PLAY_OUT_SCOREBOARD_TEAM("PacketPlayOutScoreboardTeam"),
        PLAY_OUT_SET_SLOT("PacketPlayOutSetSlot"),
        PLAY_OUT_SPAWN_ENTITY("PacketPlayOutSpawnEntity"),
        PLAY_OUT_SPAWN_ENTITY_EXPERIENCE_ORB("PacketPlayOutSpawnEntityExperienceOrb"),
        PLAY_OUT_SPAWN_ENTITY_LIVING("PacketPlayOutSpawnEntityLiving"),
        PLAY_OUT_SPAWN_ENTITY_PAINTING("PacketPlayOutSpawnEntityPainting"),
        PLAY_OUT_SPAWN_ENTITY_WEATHER("PacketPlayOutSpawnEntityWeather"),
        PLAY_OUT_SPAWN_POSITION("PacketPlayOutSpawnPosition"),
        PLAY_OUT_STATISTIC("PacketPlayOutStatistic"),
        PLAY_OUT_TAB_COMPLETE("PacketPlayOutTabComplete"),
        PLAY_OUT_TILE_ENTITY_DATA("PacketPlayOutTileEntityData"),
        PLAY_OUT_TRANSACTION("PacketPlayOutTransaction"),
        PLAY_OUT_UPDATE_ATTRIBUTES("PacketPlayOutUpdateAttributes"),
        PLAY_OUT_UPDATE_HEALTH("PacketPlayOutUpdateHealth"),
        PLAY_OUT_UPDATE_SIGN("PacketPlayOutUpdateSign"),
        PLAY_OUT_UPDATE_TIME("PacketPlayOutUpdateTime"),
        PLAY_OUT_WINDOW_ITEMS("PacketPlayOutWindowItems"),
        PLAY_OUT_WORLD_EVENT("PacketPlayOutWorldEvent"),
        PLAY_OUT_WORLD_PARTICLES("PacketPlayOutWorldParticles", "Packet63WorldParticles"),
        STATUS_IN_PING("PacketStatusInPing"),
        STATUS_IN_START("PacketStatusInStart"),
        STATUS_OUT_PONG("PacketStatusOutPong"),
        STATUS_OUT_SERVER_INFO("PacketStatusOutServerInfo");

        private final String name;
        private final String legacy;
        private Class<?> packet;

        private PacketType(String name) {
            this.name = name;
            this.legacy = null;
        }

        private PacketType(String name, String legacy) {
            this.name = name;
            this.legacy = legacy;
        }

        public String getName() {
            return this.getName();
        }

        public Class<?> getPacket() throws Exception {
            if (this.packet == null) {
                try {
                    this.packet = ReflectionHandler.getClass(this.name, PackageType.MINECRAFT_SERVER);
                } catch (Exception ex) {
                    if (this.legacy == null) {
                        throw ex;
                    }
                    this.packet = ReflectionHandler.getClass(this.legacy, PackageType.MINECRAFT_SERVER);
                }
            }
            return this.packet;
        }
    }

    public static enum SubPackageType {
        BLOCK,
        CHUNKIO,
        COMMAND,
        CONVERSATIONS,
        ENCHANTMENS,
        ENTITY,
        EVENT,
        GENERATOR,
        HELP,
        INVENTORY,
        MAP,
        METADATA,
        POTION,
        PROJECTILES,
        SCHEDULER,
        SCOREBOARD,
        UPDATER,
        UTIL;

        private final String name = (Object)((Object)PackageType.CRAFTBUKKIT) + "." + this.name().toLowerCase();

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public static enum PackageType {
        MINECRAFT_SERVER("net.minecraft.server." + Bukkit.getServer().getClass().getPackage().getName().substring(23)),
        CRAFTBUKKIT(Bukkit.getServer().getClass().getPackage().getName());

        private final String name;

        private PackageType(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }

        public String toString() {
            return this.name;
        }
    }

    public final class FieldPair {
        private final String name;
        private final Object value;

        public FieldPair(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return this.name;
        }

        public Object getValue() {
            return this.value;
        }
    }

    public static enum DataType {
        BYTE(Byte.TYPE, Byte.class),
        SHORT(Short.TYPE, Short.class),
        INTEGER(Integer.TYPE, Integer.class),
        LONG(Long.TYPE, Long.class),
        CHARACTER(Character.TYPE, Character.class),
        FLOAT(Float.TYPE, Float.class),
        DOUBLE(Double.TYPE, Double.class),
        BOOLEAN(Boolean.TYPE, Boolean.class);

        private static final Map<Class<?>, DataType> CLASS_MAP;
        private final Class<?> primitive;
        private final Class<?> reference;

        private DataType(Class<?> primitive, Class<?> reference) {
            this.primitive = primitive;
            this.reference = reference;
        }

        public Class<?> getPrimitive() {
            return this.primitive;
        }

        public Class<?> getReference() {
            return this.reference;
        }

        public static DataType fromClass(Class<?> c2) {
            return CLASS_MAP.get(c2);
        }

        public static Class<?> getPrimitive(Class<?> c2) {
            DataType t2 = DataType.fromClass(c2);
            return t2 == null ? c2 : t2.getPrimitive();
        }

        public static Class<?> getReference(Class<?> c2) {
            DataType t2 = DataType.fromClass(c2);
            return t2 == null ? c2 : t2.getReference();
        }

        public static Class<?>[] convertToPrimitive(Class<?>[] classes) {
            int length = classes == null ? 0 : classes.length;
            Class[] types = new Class[length];
            for (int i2 = 0; i2 < length; ++i2) {
                types[i2] = DataType.getPrimitive(classes[i2]);
            }
            return types;
        }

        public static Class<?>[] convertToPrimitive(Object[] objects) {
            int length = objects == null ? 0 : objects.length;
            Class[] types = new Class[length];
            for (int i2 = 0; i2 < length; ++i2) {
                types[i2] = DataType.getPrimitive(objects[i2].getClass());
            }
            return types;
        }

        public static boolean equalsArray(Class<?>[] a1, Class<?>[] a2) {
            if (a1 == null || a2 == null || a1.length != a2.length) {
                return false;
            }
            for (int i2 = 0; i2 < a1.length; ++i2) {
                if (a1[i2].equals(a2[i2]) || a1[i2].isAssignableFrom(a2[i2])) continue;
                return false;
            }
            return true;
        }

        static {
            CLASS_MAP = new HashMap();
            for (DataType t2 : DataType.values()) {
                CLASS_MAP.put(t2.primitive, t2);
                CLASS_MAP.put(t2.reference, t2);
            }
        }
    }
}

