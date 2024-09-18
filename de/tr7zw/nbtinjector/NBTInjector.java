/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.block.BlockState
 *  org.bukkit.entity.Entity
 */
package de.tr7zw.nbtinjector;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTEntity;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.NBTTileEntity;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ObjectCreator;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import de.tr7zw.nbtinjector.INBTWrapper;
import de.tr7zw.nbtinjector.InternalInjectors;
import de.tr7zw.nbtinjector.javassist.ClassPool;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;
import org.bukkit.block.BlockState;

public class NBTInjector {
    protected static Logger logger = Logger.getLogger("NBTInjector");
    private static boolean isInjected = false;
    private static final String NOT_INJECTED_MESSAGE = "The NBTInjector has not been enabled!\nYou need to call 'NBTInjector.inject()' during the Method 'onLoad' of your Plugin! Check the Wiki/Pluginpage for more information!";

    private NBTInjector() {
    }

    public static void inject() {
        if (isInjected) {
            return;
        }
        if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4 || MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_16_R1)) {
            logger.warning("[NBTINJECTOR] The NBT-Injector is not compatibel with this Minecraft Version! For 1.16+ please use the persistent storage API.");
            return;
        }
        isInjected = true;
        try {
            ClassPool classPool = ClassPool.getDefault();
            logger.info("[NBTINJECTOR] Injecting Entity classes...");
            if (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_10_R1.getVersionId()) {
                InternalInjectors.entity1v10Below(classPool);
            } else if (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_12_R1.getVersionId()) {
                InternalInjectors.entity1v12Below(classPool);
            } else if (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_13_R2.getVersionId()) {
                InternalInjectors.entity1v13Below(classPool);
            } else {
                InternalInjectors.entity1v14(classPool);
            }
            logger.info("[NBTINJECTOR] Injecting Tile Entity classes...");
            if (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_10_R1.getVersionId()) {
                InternalInjectors.tile1v10Below(classPool);
            } else if (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_12_R1.getVersionId()) {
                InternalInjectors.tile1v12Below(classPool);
            } else {
                InternalInjectors.tile1v13(classPool);
            }
        } catch (Exception e2) {
            throw new NbtApiException(e2);
        }
    }

    public static boolean isInjected() {
        return isInjected;
    }

    private static NBTCompound getNbtData(Object object) {
        if (object instanceof INBTWrapper) {
            return ((INBTWrapper)object).getNbtData();
        }
        return null;
    }

    public static org.bukkit.entity.Entity patchEntity(org.bukkit.entity.Entity entity) {
        if (entity == null) {
            return null;
        }
        if (!isInjected) {
            throw new NbtApiException(NOT_INJECTED_MESSAGE);
        }
        try {
            Object ent = NBTReflectionUtil.getNMSEntity(entity);
            if (!(ent instanceof INBTWrapper)) {
                Object cworld = ClassWrapper.CRAFT_WORLD.getClazz().cast(entity.getWorld());
                Object nmsworld = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(cworld, new Object[0]);
                NBTContainer oldNBT = new NBTContainer(new NBTEntity(entity).getCompound());
                Method create = ClassWrapper.NMS_ENTITYTYPES.getClazz().getMethod("a", ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz(), ClassWrapper.NMS_WORLD.getClazz());
                String id = "";
                id = MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_10_R1.getVersionId() ? Entity.getBackupMap().get(ent.getClass()) : (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_12_R1.getVersionId() ? ReflectionMethod.REGISTRY_GET_INVERSE.run(Entity.getRegistry(), ent.getClass()).toString() : (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_13_R2.getVersionId() ? InternalInjectors.classToMCKey.get(ent.getClass()).toString() : (String)ReflectionMethod.NMS_ENTITY_GETSAVEID.run(ent, new Object[0])));
                oldNBT.setString("id", id);
                oldNBT.removeKey("UUIDMost");
                oldNBT.removeKey("UUIDLeast");
                entity.remove();
                Object newEntity = create.invoke(null, oldNBT.getCompound(), nmsworld);
                if (newEntity instanceof Optional && ((Optional)newEntity).isPresent()) {
                    newEntity = ((Optional)newEntity).get();
                }
                Method spawn = ClassWrapper.NMS_WORLD.getClazz().getMethod("addEntity", ClassWrapper.NMS_ENTITY.getClazz());
                spawn.invoke(nmsworld, newEntity);
                Method asBukkit = newEntity.getClass().getMethod("getBukkitEntity", new Class[0]);
                return (org.bukkit.entity.Entity)asBukkit.invoke(newEntity, new Object[0]);
            }
        } catch (Exception e2) {
            throw new NbtApiException("Error while patching an Entity '" + entity + "'", e2);
        }
        return entity;
    }

    public static NBTCompound getNbtData(org.bukkit.entity.Entity entity) {
        if (entity == null) {
            return null;
        }
        if (!isInjected) {
            throw new NbtApiException(NOT_INJECTED_MESSAGE);
        }
        try {
            Object ent = NBTReflectionUtil.getNMSEntity(entity);
            if (!(ent instanceof INBTWrapper)) {
                logger.info("Entity wasn't the correct class! '" + ent.getClass().getName() + "'");
            }
            return NBTInjector.getNbtData(ent);
        } catch (Exception e2) {
            throw new NbtApiException("Error while getting the NBT from an Entity '" + entity + "'.", e2);
        }
    }

    public static NBTCompound getNbtData(BlockState tile) {
        if (tile == null) {
            return null;
        }
        if (!isInjected) {
            throw new NbtApiException(NOT_INJECTED_MESSAGE);
        }
        try {
            Object pos = ObjectCreator.NMS_BLOCKPOSITION.getInstance(tile.getX(), tile.getY(), tile.getZ());
            Object cworld = ClassWrapper.CRAFT_WORLD.getClazz().cast(tile.getWorld());
            Object nmsworld = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(cworld, new Object[0]);
            Object tileEntity = ReflectionMethod.NMS_WORLD_GET_TILEENTITY.run(nmsworld, pos);
            if (tileEntity == null) {
                return null;
            }
            if (!(tileEntity instanceof INBTWrapper)) {
                Object tileEntityUpdated = MinecraftVersion.getVersion() == MinecraftVersion.MC1_9_R1 ? ReflectionMethod.TILEENTITY_LOAD_LEGACY191.run(null, null, new NBTTileEntity(tile).getCompound()) : (MinecraftVersion.getVersion() == MinecraftVersion.MC1_8_R3 || MinecraftVersion.getVersion() == MinecraftVersion.MC1_9_R2 ? ReflectionMethod.TILEENTITY_LOAD_LEGACY183.run(null, new NBTTileEntity(tile).getCompound()) : (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_12_R1.getVersionId() ? ReflectionMethod.TILEENTITY_LOAD_LEGACY1121.run(null, nmsworld, new NBTTileEntity(tile).getCompound()) : ReflectionMethod.TILEENTITY_LOAD.run(null, new NBTTileEntity(tile).getCompound())));
                ReflectionMethod.NMS_WORLD_REMOVE_TILEENTITY.run(nmsworld, pos);
                ReflectionMethod.NMS_WORLD_SET_TILEENTITY.run(nmsworld, pos, tileEntityUpdated);
                return NBTInjector.getNbtData(tileEntityUpdated);
            }
            return NBTInjector.getNbtData(tileEntity);
        } catch (Exception e2) {
            throw new NbtApiException(e2);
        }
    }

    private static Field getAccessable(Field field) {
        field.setAccessible(true);
        return field;
    }

    static class TileEntity {
        private TileEntity() {
        }

        static Object getRegistry() throws ReflectiveOperationException {
            return NBTInjector.getAccessable(ClassWrapper.NMS_TILEENTITY.getClazz().getDeclaredField("f")).get(null);
        }

        static Map<String, Class<?>> getFMap() throws ReflectiveOperationException {
            return (Map)NBTInjector.getAccessable(ClassWrapper.NMS_TILEENTITY.getClazz().getDeclaredField("f")).get(null);
        }

        static Map<Class<?>, String> getGMap() throws ReflectiveOperationException {
            return (Map)NBTInjector.getAccessable(ClassWrapper.NMS_TILEENTITY.getClazz().getDeclaredField("g")).get(null);
        }
    }

    static class Entity {
        private static Map<Class<?>, String> backupMap = new HashMap();

        private Entity() {
        }

        static Object getRegistry() throws ReflectiveOperationException {
            return NBTInjector.getAccessable(ClassWrapper.NMS_ENTITYTYPES.getClazz().getDeclaredField("b")).get(null);
        }

        static Object getRegistryId(Object reg) throws ReflectiveOperationException {
            return NBTInjector.getAccessable(reg.getClass().getDeclaredField("a")).get(reg);
        }

        static Map<Class<?>, String> getBackupMap() throws ReflectiveOperationException {
            return backupMap;
        }

        static Map<String, Class<?>> getCMap() throws ReflectiveOperationException {
            return (Map)NBTInjector.getAccessable(ClassWrapper.NMS_ENTITYTYPES.getClazz().getDeclaredField("c")).get(null);
        }

        static Map<Class<?>, String> getDMap() throws ReflectiveOperationException {
            return (Map)NBTInjector.getAccessable(ClassWrapper.NMS_ENTITYTYPES.getClazz().getDeclaredField("d")).get(null);
        }

        static Map<Integer, Class<?>> getEMap() throws ReflectiveOperationException {
            return (Map)NBTInjector.getAccessable(ClassWrapper.NMS_ENTITYTYPES.getClazz().getDeclaredField("e")).get(null);
        }

        static Map<Class<?>, Integer> getFMap() throws ReflectiveOperationException {
            return (Map)NBTInjector.getAccessable(ClassWrapper.NMS_ENTITYTYPES.getClazz().getDeclaredField("f")).get(null);
        }

        static {
            try {
                if (MinecraftVersion.getVersion().getVersionId() <= MinecraftVersion.MC1_10_R1.getVersionId()) {
                    backupMap.putAll(Entity.getDMap());
                }
            } catch (ReflectiveOperationException e2) {
                throw new NbtApiException(e2);
            }
        }
    }
}

