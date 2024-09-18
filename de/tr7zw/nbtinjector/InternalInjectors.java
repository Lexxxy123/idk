/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 */
package de.tr7zw.nbtinjector;

import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.ReflectionUtil;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import de.tr7zw.nbtinjector.ClassGenerator;
import de.tr7zw.nbtinjector.INBTWrapper;
import de.tr7zw.nbtinjector.NBTInjector;
import de.tr7zw.nbtinjector.javassist.ClassPool;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Level;
import org.bukkit.Bukkit;

public class InternalInjectors {
    private static final List<String> skippingEntities = Arrays.asList("minecraft:player", "minecraft:fishing_bobber", "minecraft:lightning_bolt");
    private static final Map<String, String> classMappings = new HashMap<String, String>();
    protected static final Map<Class<?>, Object> classToMCKey = new HashMap();

    private InternalInjectors() {
    }

    protected static void entity1v10Below(ClassPool classPool) throws ReflectiveOperationException {
        for (Map.Entry<String, Class<?>> entry : new HashSet(NBTInjector.Entity.getCMap().entrySet())) {
            try {
                if (INBTWrapper.class.isAssignableFrom(entry.getValue())) continue;
                int entityId = NBTInjector.Entity.getFMap().get(entry.getValue());
                Class<?> wrapped = ClassGenerator.wrapEntity(classPool, entry.getValue(), "__extraData");
                NBTInjector.Entity.getCMap().put(entry.getKey(), wrapped);
                NBTInjector.Entity.getDMap().put(wrapped, entry.getKey());
                NBTInjector.Entity.getEMap().put(entityId, wrapped);
                NBTInjector.Entity.getFMap().put(wrapped, entityId);
            } catch (Exception e2) {
                throw new NbtApiException("Exception while injecting " + entry.getKey(), e2);
            }
        }
    }

    protected static void entity1v12Below(ClassPool classPool) throws ReflectiveOperationException {
        Object registry = NBTInjector.Entity.getRegistry();
        HashMap inverse = new HashMap();
        HashSet it = new HashSet((Set)ReflectionMethod.REGISTRY_KEYSET.run(registry, new Object[0]));
        Object registryId = NBTInjector.Entity.getRegistryId(registry);
        for (Object mckey : it) {
            Class entclass = (Class)ReflectionMethod.REGISTRY_GET.run(registry, mckey);
            inverse.put(entclass, mckey);
            try {
                if (INBTWrapper.class.isAssignableFrom(entclass)) continue;
                Class<?> wrapped = ClassGenerator.wrapEntity(classPool, entclass, "__extraData");
                ReflectionMethod.REGISTRY_SET.run(registry, mckey, wrapped);
                inverse.put(wrapped, mckey);
                int id = (Integer)registryId.getClass().getMethod("getId", Object.class).invoke(registryId, entclass);
                registryId.getClass().getMethod("a", Object.class, Integer.TYPE).invoke(registryId, wrapped, id);
                classToMCKey.put(entclass, mckey);
            } catch (Exception e2) {
                throw new NbtApiException("Exception while injecting " + mckey, e2);
            }
        }
        Field inverseField = registry.getClass().getDeclaredField("b");
        ReflectionUtil.setFinal(registry, inverseField, inverse);
    }

    protected static void entity1v13Below(ClassPool classPool) throws ReflectiveOperationException {
        Object entityRegistry = ClassWrapper.NMS_IREGISTRY.getClazz().getField("ENTITY_TYPE").get(null);
        HashSet registryentries = new HashSet((Set)ReflectionMethod.REGISTRYMATERIALS_KEYSET.run(entityRegistry, new Object[0]));
        for (Object mckey : registryentries) {
            Object entityTypesObj = ReflectionMethod.REGISTRYMATERIALS_GET.run(entityRegistry, mckey);
            Field supplierField = entityTypesObj.getClass().getDeclaredField("aT");
            Field classField = entityTypesObj.getClass().getDeclaredField("aS");
            classField.setAccessible(true);
            supplierField.setAccessible(true);
            final Function function = (Function)supplierField.get(entityTypesObj);
            Class nmsclass = (Class)classField.get(entityTypesObj);
            try {
                if (INBTWrapper.class.isAssignableFrom(nmsclass)) continue;
                final Class<?> wrapped = ClassGenerator.wrapEntity(classPool, nmsclass, "__extraData");
                ReflectionUtil.setFinal(entityTypesObj, classField, wrapped);
                ReflectionUtil.setFinal(entityTypesObj, supplierField, new Function<Object, Object>(){

                    @Override
                    public Object apply(Object t2) {
                        try {
                            return wrapped.getConstructor(ClassWrapper.NMS_WORLD.getClazz()).newInstance(t2);
                        } catch (Exception ex) {
                            NBTInjector.logger.log(Level.SEVERE, "Error while creating custom entity instance! ", ex);
                            return function.apply(t2);
                        }
                    }
                });
                classToMCKey.put(nmsclass, mckey);
            } catch (Exception e2) {
                throw new NbtApiException("Exception while injecting " + mckey, e2);
            }
        }
    }

    protected static void entity1v14(ClassPool classPool) throws ReflectiveOperationException {
        Object entityRegistry = ClassWrapper.NMS_IREGISTRY.getClazz().getField("ENTITY_TYPE").get(null);
        HashSet registryentries = new HashSet((Set)ReflectionMethod.REGISTRYMATERIALS_KEYSET.run(entityRegistry, new Object[0]));
        for (Object mckey : registryentries) {
            if (skippingEntities.contains(mckey.toString())) {
                NBTInjector.logger.info("Skipping, won't be able add NBT to '" + mckey + "' entities!");
                continue;
            }
            Object entityTypesObj = ReflectionMethod.REGISTRYMATERIALS_GET.run(entityRegistry, mckey);
            String creatorFieldName = "aZ";
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_15_R1.getVersionId()) {
                creatorFieldName = "ba";
            }
            Field creatorField = entityTypesObj.getClass().getDeclaredField(creatorFieldName);
            creatorField.setAccessible(true);
            Object creator = creatorField.get(entityTypesObj);
            Method createEntityMethod = creator.getClass().getMethod("create", ClassWrapper.NMS_ENTITYTYPES.getClazz(), ClassWrapper.NMS_WORLD.getClazz());
            createEntityMethod.setAccessible(true);
            Class<?> nmsclass = null;
            try {
                nmsclass = createEntityMethod.invoke(creator, entityTypesObj, null).getClass();
            } catch (Exception exception) {
                // empty catch block
            }
            if (nmsclass == null) {
                String version = Bukkit.getServer().getClass().getPackage().getName().replace(".", ",").split(",")[3];
                String name = mckey.toString().replace("minecraft:", "");
                name = name.substring(0, 1).toUpperCase() + name.substring(1);
                name = "Entity" + name;
                if (classMappings.containsKey(mckey.toString())) {
                    name = "Entity" + classMappings.get(mckey.toString());
                }
                try {
                    nmsclass = Class.forName("net.minecraft.server." + version + "." + name);
                } catch (Exception ignore) {
                    NBTInjector.logger.info("Not found: net.minecraft.server." + version + "." + name);
                }
            }
            if (nmsclass == null) {
                NBTInjector.logger.info("Wasn't able to create an Entity instace, won't be able add NBT to '" + mckey + "' entities!");
                continue;
            }
            classToMCKey.put(nmsclass, mckey);
            try {
                if (INBTWrapper.class.isAssignableFrom(nmsclass)) continue;
                Class<?> wrapped = ClassGenerator.wrapEntity(classPool, nmsclass, "__extraData");
                ReflectionUtil.setFinal(entityTypesObj, creatorField, ClassGenerator.createEntityTypeWrapper(classPool, wrapped).newInstance());
            } catch (Exception e2) {
                throw new NbtApiException("Exception while injecting " + mckey, e2);
            }
        }
    }

    protected static void tile1v10Below(ClassPool classPool) throws ReflectiveOperationException {
        for (Map.Entry<String, Class<?>> entry : new HashSet(NBTInjector.TileEntity.getFMap().entrySet())) {
            try {
                if (INBTWrapper.class.isAssignableFrom(entry.getValue())) continue;
                Class<?> wrapped = ClassGenerator.wrapTileEntity(classPool, entry.getValue(), "__extraData");
                NBTInjector.TileEntity.getFMap().put(entry.getKey(), wrapped);
                NBTInjector.TileEntity.getGMap().put(wrapped, entry.getKey());
            } catch (Exception e2) {
                throw new NbtApiException("Exception while injecting " + entry.getKey(), e2);
            }
        }
    }

    protected static void tile1v12Below(ClassPool classPool) throws ReflectiveOperationException {
        Object registry = NBTInjector.TileEntity.getRegistry();
        HashMap inverse = new HashMap();
        HashSet it = new HashSet((Set)ReflectionMethod.REGISTRY_KEYSET.run(registry, new Object[0]));
        for (Object mckey : it) {
            Class tileclass = (Class)ReflectionMethod.REGISTRY_GET.run(registry, mckey);
            inverse.put(tileclass, mckey);
            try {
                if (INBTWrapper.class.isAssignableFrom(tileclass)) continue;
                Class<?> wrapped = ClassGenerator.wrapTileEntity(classPool, tileclass, "__extraData");
                ReflectionMethod.REGISTRY_SET.run(registry, mckey, wrapped);
                inverse.put(wrapped, mckey);
            } catch (Exception e2) {
                throw new NbtApiException("Exception while injecting " + mckey, e2);
            }
        }
        Field inverseField = registry.getClass().getDeclaredField("b");
        ReflectionUtil.setFinal(registry, inverseField, inverse);
    }

    protected static void tile1v13(ClassPool classPool) throws ReflectiveOperationException {
        Object tileRegistry = ClassWrapper.NMS_IREGISTRY.getClazz().getField("BLOCK_ENTITY_TYPE").get(null);
        HashSet registryentries = new HashSet((Set)ReflectionMethod.REGISTRYMATERIALS_KEYSET.run(tileRegistry, new Object[0]));
        for (Object mckey : registryentries) {
            Object tileEntityTypesObj = ReflectionMethod.REGISTRYMATERIALS_GET.run(tileRegistry, mckey);
            String supplierFieldName = "A";
            if (MinecraftVersion.getVersion().getVersionId() == MinecraftVersion.MC1_14_R1.getVersionId()) {
                supplierFieldName = "H";
            } else if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_15_R1.getVersionId()) {
                supplierFieldName = "I";
            }
            Field supplierField = tileEntityTypesObj.getClass().getDeclaredField(supplierFieldName);
            supplierField.setAccessible(true);
            final Supplier supplier = (Supplier)supplierField.get(tileEntityTypesObj);
            Class<?> nmsclass = supplier.get().getClass();
            try {
                if (INBTWrapper.class.isAssignableFrom(nmsclass)) continue;
                final Class<?> wrapped = ClassGenerator.wrapTileEntity(classPool, nmsclass, "__extraData");
                ReflectionUtil.setFinal(tileEntityTypesObj, supplierField, new Supplier<Object>(){

                    @Override
                    public Object get() {
                        try {
                            return wrapped.newInstance();
                        } catch (IllegalAccessException | InstantiationException e2) {
                            NBTInjector.logger.log(Level.SEVERE, "Error while creating custom tile instance! ", e2);
                            return supplier.get();
                        }
                    }
                });
            } catch (Exception e2) {
                throw new NbtApiException("Exception while injecting " + mckey, e2);
            }
        }
    }

    static {
        classMappings.put("minecraft:wandering_trader", "VillagerTrader");
        classMappings.put("minecraft:trader_llama", "LlamaTrader");
        classMappings.put("minecraft:area_effect_cloud", "AreaEffectCloud");
        classMappings.put("minecraft:donkey", "HorseDonkey");
        classMappings.put("minecraft:ender_dragon", "EnderDragon");
        classMappings.put("minecraft:skeleton_horse", "HorseSkeleton");
        classMappings.put("minecraft:fireball", "LargeFireball");
        classMappings.put("minecraft:mule", "HorseMule");
        classMappings.put("minecraft:zombie_horse", "HorseZombie");
        classMappings.put("minecraft:mooshroom", "MushroomCow");
        classMappings.put("minecraft:wither_skeleton", "SkeletonWither");
        classMappings.put("minecraft:snow_golem", "Snowman");
        classMappings.put("minecraft:polar_bear", "PolarBear");
        classMappings.put("minecraft:magma_cube", "MagmaCube");
        classMappings.put("minecraft:armor_stand", "ArmorStand");
        classMappings.put("minecraft:elder_guardian", "GuardianElder");
        classMappings.put("minecraft:zombie_pigman", "PigZombie");
        classMappings.put("minecraft:giant", "GiantZombie");
        classMappings.put("minecraft:zombie_villager", "ZombieVillager");
        classMappings.put("minecraft:husk", "ZombieHusk");
        classMappings.put("minecraft:iron_golem", "IronGolem");
        classMappings.put("minecraft:tropical_fish", "TropicalFish");
        classMappings.put("minecraft:stray", "SkeletonStray");
        classMappings.put("minecraft:illusioner", "IllagerIllusioner");
        classMappings.put("minecraft:pufferfish", "PufferFish");
        classMappings.put("minecraft:cave_spider", "CaveSpider");
        classMappings.put("minecraft:item_frame", "ItemFrame");
        classMappings.put("minecraft:leash_knot", "Leash");
    }
}

