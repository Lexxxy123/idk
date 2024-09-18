/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.Player
 *  org.bukkit.plugin.Plugin
 */
package xyz.xenondevs.particle.utils;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URISyntaxException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.utils.PlayerConnectionCache;

public final class ReflectionUtils {
    private static final String NET_MINECRAFT_SERVER_PACKAGE_PATH;
    private static final String CRAFT_BUKKIT_PACKAGE_PATH;
    public static final double MINECRAFT_VERSION;
    private static final Class<?> PLUGIN_CLASS_LOADER_CLASS;
    private static final Field PLUGIN_CLASS_LOADER_PLUGIN_FIELD;
    public static final PlayerConnectionCache PLAYER_CONNECTION_CACHE;
    private static Plugin plugin;
    private static final ZipFile zipFile;

    public static Plugin getPlugin() {
        return plugin;
    }

    public static void setPlugin(Plugin plugin) {
        boolean wasNull = ReflectionUtils.plugin == null;
        ReflectionUtils.plugin = plugin;
        if (wasNull) {
            PLAYER_CONNECTION_CACHE.registerListener();
        }
    }

    public static Class<?> getClassSafe(String path) {
        try {
            return Class.forName(path);
        } catch (Exception ex) {
            return null;
        }
    }

    public static String getNMSPath(String path) {
        return ReflectionUtils.getNetMinecraftServerPackagePath() + "." + path;
    }

    public static Class<?> getNMSClass(String path) {
        return ReflectionUtils.getClassSafe(ReflectionUtils.getNMSPath(path));
    }

    public static String getCraftBukkitPath(String path) {
        return ReflectionUtils.getCraftBukkitPackagePath() + "." + path;
    }

    public static Class<?> getCraftBukkitClass(String path) {
        return ReflectionUtils.getClassSafe(ReflectionUtils.getCraftBukkitPath(path));
    }

    public static Method getMethodOrNull(Class targetClass, String methodName, Class<?> ... parameterTypes) {
        try {
            return targetClass.getMethod(methodName, parameterTypes);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Field getFieldOrNull(Class targetClass, String fieldName, boolean declared) {
        try {
            return declared ? targetClass.getDeclaredField(fieldName) : targetClass.getField(fieldName);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Constructor getConstructorOrNull(Class targetClass, Class ... parameterTypes) {
        try {
            return targetClass.getConstructor(parameterTypes);
        } catch (Exception ex) {
            return null;
        }
    }

    public static boolean existsClass(String path) {
        try {
            Class.forName(path);
            return true;
        } catch (Exception ignored) {
            return false;
        }
    }

    public static Object readField(Class targetClass, String fieldName, Object object) {
        if (targetClass == null || fieldName == null) {
            return null;
        }
        return ReflectionUtils.readField(ReflectionUtils.getFieldOrNull(targetClass, fieldName, false), object);
    }

    public static <T> T readField(Field field, Object object) {
        if (field == null) {
            return null;
        }
        try {
            return (T)field.get(object);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object readDeclaredField(Class targetClass, String fieldName, Object object) {
        if (targetClass == null || fieldName == null) {
            return null;
        }
        return ReflectionUtils.readDeclaredField(ReflectionUtils.getFieldOrNull(targetClass, fieldName, true), object);
    }

    public static <T> T readDeclaredField(Field field, Object object) {
        if (field == null) {
            return null;
        }
        field.setAccessible(true);
        try {
            return (T)field.get(object);
        } catch (Exception ex) {
            return null;
        }
    }

    public static void writeDeclaredField(Class targetClass, String fieldName, Object object, Object value) {
        if (targetClass == null || fieldName == null) {
            return;
        }
        ReflectionUtils.writeDeclaredField(ReflectionUtils.getFieldOrNull(targetClass, fieldName, true), object, value);
    }

    public static void writeDeclaredField(Field field, Object object, Object value) {
        if (field == null) {
            return;
        }
        field.setAccessible(true);
        try {
            field.set(object, value);
        } catch (Exception exception) {
            // empty catch block
        }
    }

    public static void writeField(Class targetClass, String fieldName, Object object, Object value) {
        if (targetClass == null || fieldName == null) {
            return;
        }
        ReflectionUtils.writeField(ReflectionUtils.getFieldOrNull(targetClass, fieldName, false), object, value);
    }

    public static void writeField(Field field, Object object, Object value) {
        if (field == null) {
            return;
        }
        try {
            field.set(object, value);
        } catch (Exception exception) {
            // empty catch block
        }
    }

    public static String getNetMinecraftServerPackagePath() {
        return NET_MINECRAFT_SERVER_PACKAGE_PATH;
    }

    public static String getCraftBukkitPackagePath() {
        return CRAFT_BUKKIT_PACKAGE_PATH;
    }

    public static Object getMinecraftKey(String key) {
        if (key == null) {
            return null;
        }
        try {
            return ParticleConstants.MINECRAFT_KEY_CONSTRUCTOR.newInstance(key);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object createVector3fa(float x2, float y2, float z2) {
        try {
            return ParticleConstants.VECTOR_3FA_CONSTRUCTOR.newInstance(Float.valueOf(x2), Float.valueOf(y2), Float.valueOf(z2));
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object createBlockPosition(Location location) {
        try {
            return ParticleConstants.BLOCK_POSITION_CONSTRUCTOR.newInstance(location.getBlockX(), location.getBlockY(), location.getBlockZ());
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object getEntityHandle(Entity entity) {
        if (entity == null || !ParticleConstants.CRAFT_ENTITY_CLASS.isAssignableFrom(entity.getClass())) {
            return null;
        }
        try {
            return ParticleConstants.CRAFT_ENTITY_GET_HANDLE_METHOD.invoke(entity, new Object[0]);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object getPlayerHandle(Player player) {
        if (player == null || player.getClass() != ParticleConstants.CRAFT_PLAYER_CLASS) {
            return null;
        }
        try {
            return ParticleConstants.CRAFT_PLAYER_GET_HANDLE_METHOD.invoke(player, new Object[0]);
        } catch (Exception ex) {
            return null;
        }
    }

    public static Object getPlayerConnection(Player target) {
        try {
            return ReflectionUtils.readField(ParticleConstants.ENTITY_PLAYER_PLAYER_CONNECTION_FIELD, ReflectionUtils.getPlayerHandle(target));
        } catch (Exception ex) {
            return null;
        }
    }

    public static void sendPacket(Player player, Object packet) {
        try {
            Object connection = PLAYER_CONNECTION_CACHE.getConnection(player);
            ParticleConstants.PLAYER_CONNECTION_SEND_PACKET_METHOD.invoke(connection, packet);
        } catch (Exception exception) {
            // empty catch block
        }
    }

    public static InputStream getResourceStreamSafe(String resource) {
        ZipEntry entry = zipFile.getEntry(resource);
        if (entry == null) {
            return null;
        }
        try {
            return zipFile.getInputStream(entry);
        } catch (IOException ex) {
            return null;
        }
    }

    static {
        String bukkitVersion;
        PLUGIN_CLASS_LOADER_CLASS = ReflectionUtils.getClassSafe("org.bukkit.plugin.java.PluginClassLoader");
        PLUGIN_CLASS_LOADER_PLUGIN_FIELD = ReflectionUtils.getFieldOrNull(PLUGIN_CLASS_LOADER_CLASS, "plugin", true);
        String serverPath = Bukkit.getServer().getClass().getPackage().getName();
        String version = serverPath.substring(serverPath.lastIndexOf(".") + 1);
        int dashIndex = (bukkitVersion = Bukkit.getBukkitVersion()).indexOf("-");
        MINECRAFT_VERSION = Double.parseDouble(bukkitVersion.substring(2, dashIndex > -1 ? bukkitVersion.indexOf("-") : bukkitVersion.length()));
        NET_MINECRAFT_SERVER_PACKAGE_PATH = "net.minecraft" + (MINECRAFT_VERSION < 17.0 ? ".server." + version : "");
        CRAFT_BUKKIT_PACKAGE_PATH = "org.bukkit.craftbukkit." + version;
        plugin = (Plugin)ReflectionUtils.readDeclaredField(PLUGIN_CLASS_LOADER_PLUGIN_FIELD, ReflectionUtils.class.getClassLoader());
        PLAYER_CONNECTION_CACHE = new PlayerConnectionCache();
        try {
            zipFile = new ZipFile(ReflectionUtils.class.getProtectionDomain().getCodeSource().getLocation().toURI().getPath());
        } catch (IOException | URISyntaxException ex) {
            throw new IllegalStateException("Error while finding zip file", ex);
        }
    }
}

