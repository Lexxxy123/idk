/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.block.BlockState
 *  org.bukkit.entity.Entity
 *  org.bukkit.inventory.meta.ItemMeta
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTDoubleList;
import de.tr7zw.nbtapi.NBTFloatList;
import de.tr7zw.nbtapi.NBTIntegerList;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.NBTListCompound;
import de.tr7zw.nbtapi.NBTLongList;
import de.tr7zw.nbtapi.NBTStringList;
import de.tr7zw.nbtapi.NBTType;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.GsonWrapper;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ClassWrapper;
import de.tr7zw.nbtapi.utils.nmsmappings.ObjectCreator;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.Set;
import org.bukkit.block.BlockState;
import org.bukkit.entity.Entity;
import org.bukkit.inventory.meta.ItemMeta;

public class NBTReflectionUtil {
    private static Field field_unhandledTags = null;

    private NBTReflectionUtil() {
    }

    public static Object getNMSEntity(Entity entity) {
        try {
            return ReflectionMethod.CRAFT_ENTITY_GET_HANDLE.run(ClassWrapper.CRAFT_ENTITY.getClazz().cast(entity), new Object[0]);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting the NMS Entity from a Bukkit Entity!", e2);
        }
    }

    public static Object readNBT(InputStream stream) {
        try {
            return ReflectionMethod.NBTFILE_READ.run(null, stream);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while reading a NBT File!", e2);
        }
    }

    public static Object writeNBT(Object nbt, OutputStream stream) {
        try {
            return ReflectionMethod.NBTFILE_WRITE.run(null, nbt, stream);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while writing NBT!", e2);
        }
    }

    public static void writeApiNBT(NBTCompound comp, OutputStream stream) {
        try {
            Object nbttag = comp.getCompound();
            if (nbttag == null) {
                nbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
            }
            if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
                return;
            }
            Object workingtag = NBTReflectionUtil.gettoCompount(nbttag, comp);
            ReflectionMethod.NBTFILE_WRITE.run(null, workingtag, stream);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while writing NBT!", e2);
        }
    }

    public static Object getItemRootNBTTagCompound(Object nmsitem) {
        try {
            Object answer = ReflectionMethod.NMSITEM_GETTAG.run(nmsitem, new Object[0]);
            return answer != null ? answer : ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting an Itemstack's NBTCompound!", e2);
        }
    }

    public static Object convertNBTCompoundtoNMSItem(NBTCompound nbtcompound) {
        try {
            Object nmsComp = NBTReflectionUtil.gettoCompount(nbtcompound.getCompound(), nbtcompound);
            if (MinecraftVersion.getVersion().getVersionId() >= MinecraftVersion.MC1_11_R1.getVersionId()) {
                return ObjectCreator.NMS_COMPOUNDFROMITEM.getInstance(nmsComp);
            }
            return ReflectionMethod.NMSITEM_CREATESTACK.run(null, nmsComp);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while converting NBTCompound to NMS ItemStack!", e2);
        }
    }

    public static NBTContainer convertNMSItemtoNBTCompound(Object nmsitem) {
        try {
            Object answer = ReflectionMethod.NMSITEM_SAVE.run(nmsitem, ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]));
            return new NBTContainer(answer);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while converting NMS ItemStack to NBTCompound!", e2);
        }
    }

    public static Map<String, Object> getUnhandledNBTTags(ItemMeta meta) {
        try {
            return (Map)field_unhandledTags.get(meta);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting unhandled tags from ItemMeta!", e2);
        }
    }

    public static Object getEntityNBTTagCompound(Object nmsEntity) {
        try {
            Object nbt = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            Object answer = ReflectionMethod.NMS_ENTITY_GET_NBT.run(nmsEntity, nbt);
            if (answer == null) {
                answer = nbt;
            }
            return answer;
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting NBTCompound from NMS Entity!", e2);
        }
    }

    public static Object setEntityNBTTag(Object nbtTag, Object nmsEntity) {
        try {
            ReflectionMethod.NMS_ENTITY_SET_NBT.run(nmsEntity, nbtTag);
            return nmsEntity;
        } catch (Exception ex) {
            throw new NbtApiException("Exception while setting the NBTCompound of an Entity", ex);
        }
    }

    public static Object getTileEntityNBTTagCompound(BlockState tile) {
        try {
            Object cworld = ClassWrapper.CRAFT_WORLD.getClazz().cast(tile.getWorld());
            Object nmsworld = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(cworld, new Object[0]);
            Object o2 = null;
            if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
                o2 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY_1_7_10.run(nmsworld, tile.getX(), tile.getY(), tile.getZ());
            } else {
                Object pos = ObjectCreator.NMS_BLOCKPOSITION.getInstance(tile.getX(), tile.getY(), tile.getZ());
                o2 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY.run(nmsworld, pos);
            }
            Object tag = ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance();
            Object answer = ReflectionMethod.TILEENTITY_GET_NBT.run(o2, tag);
            if (answer == null) {
                answer = tag;
            }
            return answer;
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting NBTCompound from TileEntity!", e2);
        }
    }

    public static void setTileEntityNBTTagCompound(BlockState tile, Object comp) {
        try {
            Object cworld = ClassWrapper.CRAFT_WORLD.getClazz().cast(tile.getWorld());
            Object nmsworld = ReflectionMethod.CRAFT_WORLD_GET_HANDLE.run(cworld, new Object[0]);
            Object o2 = null;
            if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
                o2 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY_1_7_10.run(nmsworld, tile.getX(), tile.getY(), tile.getZ());
            } else {
                Object pos = ObjectCreator.NMS_BLOCKPOSITION.getInstance(tile.getX(), tile.getY(), tile.getZ());
                o2 = ReflectionMethod.NMS_WORLD_GET_TILEENTITY.run(nmsworld, pos);
            }
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_17_R1)) {
                ReflectionMethod.TILEENTITY_SET_NBT.run(o2, comp);
            } else if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_16_R1)) {
                Object blockData = ReflectionMethod.TILEENTITY_GET_BLOCKDATA.run(o2, new Object[0]);
                ReflectionMethod.TILEENTITY_SET_NBT_LEGACY1161.run(o2, blockData, comp);
            } else {
                ReflectionMethod.TILEENTITY_SET_NBT_LEGACY1151.run(o2, comp);
            }
        } catch (Exception e2) {
            throw new NbtApiException("Exception while setting NBTData for a TileEntity!", e2);
        }
    }

    public static Object getSubNBTTagCompound(Object compound, String name) {
        try {
            if (((Boolean)ReflectionMethod.COMPOUND_HAS_KEY.run(compound, name)).booleanValue()) {
                return ReflectionMethod.COMPOUND_GET_COMPOUND.run(compound, name);
            }
            throw new NbtApiException("Tried getting invalide compound '" + name + "' from '" + compound + "'!");
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting NBT subcompounds!", e2);
        }
    }

    public static void addNBTTagCompound(NBTCompound comp, String name) {
        if (name == null) {
            NBTReflectionUtil.remove(comp, name);
            return;
        }
        Object nbttag = comp.getCompound();
        if (nbttag == null) {
            nbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            return;
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(nbttag, comp);
        try {
            ReflectionMethod.COMPOUND_SET.run(workingtag, name, ClassWrapper.NMS_NBTTAGCOMPOUND.getClazz().newInstance());
            comp.setCompound(nbttag);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while adding a Compound!", e2);
        }
    }

    public static Boolean valideCompound(NBTCompound comp) {
        Object root = comp.getCompound();
        if (root == null) {
            root = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        return NBTReflectionUtil.gettoCompount(root, comp) != null;
    }

    protected static Object gettoCompount(Object nbttag, NBTCompound comp) {
        ArrayDeque<String> structure = new ArrayDeque<String>();
        while (comp.getParent() != null) {
            structure.add(comp.getName());
            comp = comp.getParent();
        }
        while (!structure.isEmpty()) {
            String target = (String)structure.pollLast();
            if ((nbttag = NBTReflectionUtil.getSubNBTTagCompound(nbttag, target)) != null) continue;
            throw new NbtApiException("Unable to find tag '" + target + "' in " + nbttag);
        }
        return nbttag;
    }

    public static void mergeOtherNBTCompound(NBTCompound comp, NBTCompound nbtcompoundSrc) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        Object rootnbttagSrc = nbtcompoundSrc.getCompound();
        if (rootnbttagSrc == null) {
            rootnbttagSrc = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(nbtcompoundSrc).booleanValue()) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object workingtagSrc = NBTReflectionUtil.gettoCompount(rootnbttagSrc, nbtcompoundSrc);
        try {
            ReflectionMethod.COMPOUND_MERGE.run(workingtag, workingtagSrc);
            comp.setCompound(rootnbttag);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while merging two NBTCompounds!", e2);
        }
    }

    public static String getContent(NBTCompound comp, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        try {
            return ReflectionMethod.COMPOUND_GET.run(workingtag, key).toString();
        } catch (Exception e2) {
            throw new NbtApiException("Exception while getting the Content for key '" + key + "'!", e2);
        }
    }

    public static void set(NBTCompound comp, String key, Object val) {
        if (val == null) {
            NBTReflectionUtil.remove(comp, key);
            return;
        }
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        try {
            ReflectionMethod.COMPOUND_SET.run(workingtag, key, val);
            comp.setCompound(rootnbttag);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while setting key '" + key + "' to '" + val + "'!", e2);
        }
    }

    public static <T> NBTList<T> getList(NBTCompound comp, String key, NBTType type, Class<T> clazz) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            return null;
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        try {
            Object nbt = ReflectionMethod.COMPOUND_GET_LIST.run(workingtag, key, type.getId());
            if (clazz == String.class) {
                return new NBTStringList(comp, key, type, nbt);
            }
            if (clazz == NBTListCompound.class) {
                return new NBTCompoundList(comp, key, type, nbt);
            }
            if (clazz == Integer.class) {
                return new NBTIntegerList(comp, key, type, nbt);
            }
            if (clazz == Float.class) {
                return new NBTFloatList(comp, key, type, nbt);
            }
            if (clazz == Double.class) {
                return new NBTDoubleList(comp, key, type, nbt);
            }
            if (clazz == Long.class) {
                return new NBTLongList(comp, key, type, nbt);
            }
            return null;
        } catch (Exception ex) {
            throw new NbtApiException("Exception while getting a list with the type '" + (Object)((Object)type) + "'!", ex);
        }
    }

    public static NBTType getListType(NBTCompound comp, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            return null;
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        try {
            Object nbt = ReflectionMethod.COMPOUND_GET.run(workingtag, key);
            String fieldname = "type";
            if (MinecraftVersion.isAtLeastVersion(MinecraftVersion.MC1_17_R1)) {
                fieldname = "w";
            }
            Field f2 = nbt.getClass().getDeclaredField(fieldname);
            f2.setAccessible(true);
            return NBTType.valueOf(f2.getByte(nbt));
        } catch (Exception ex) {
            throw new NbtApiException("Exception while getting the list type!", ex);
        }
    }

    public static Object getEntry(NBTCompound comp, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            return null;
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        try {
            Object nbt = ReflectionMethod.COMPOUND_GET.run(workingtag, key);
            return nbt;
        } catch (Exception ex) {
            throw new NbtApiException("Exception while getting an Entry!", ex);
        }
    }

    public static void setObject(NBTCompound comp, String key, Object value) {
        if (!MinecraftVersion.hasGsonSupport()) {
            return;
        }
        try {
            String json = GsonWrapper.getString(value);
            NBTReflectionUtil.setData(comp, ReflectionMethod.COMPOUND_SET_STRING, key, json);
        } catch (Exception e2) {
            throw new NbtApiException("Exception while setting the Object '" + value + "'!", e2);
        }
    }

    public static <T> T getObject(NBTCompound comp, String key, Class<T> type) {
        if (!MinecraftVersion.hasGsonSupport()) {
            return null;
        }
        String json = (String)NBTReflectionUtil.getData(comp, ReflectionMethod.COMPOUND_GET_STRING, key);
        if (json == null) {
            return null;
        }
        return GsonWrapper.deserializeJson(json, type);
    }

    public static void remove(NBTCompound comp, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            return;
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        ReflectionMethod.COMPOUND_REMOVE_KEY.run(workingtag, key);
        comp.setCompound(rootnbttag);
    }

    public static Set<String> getKeys(NBTCompound comp) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        return (Set)ReflectionMethod.COMPOUND_GET_KEYS.run(workingtag, new Object[0]);
    }

    public static void setData(NBTCompound comp, ReflectionMethod type, String key, Object data) {
        if (data == null) {
            NBTReflectionUtil.remove(comp, key);
            return;
        }
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            rootnbttag = ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]);
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        type.run(workingtag, key, data);
        comp.setCompound(rootnbttag);
    }

    public static Object getData(NBTCompound comp, ReflectionMethod type, String key) {
        Object rootnbttag = comp.getCompound();
        if (rootnbttag == null) {
            return null;
        }
        if (!NBTReflectionUtil.valideCompound(comp).booleanValue()) {
            throw new NbtApiException("The Compound wasn't able to be linked back to the root!");
        }
        Object workingtag = NBTReflectionUtil.gettoCompount(rootnbttag, comp);
        return type.run(workingtag, key);
    }

    static {
        try {
            field_unhandledTags = ClassWrapper.CRAFT_METAITEM.getClazz().getDeclaredField("unhandledTags");
            field_unhandledTags.setAccessible(true);
        } catch (NoSuchFieldException noSuchFieldException) {
            // empty catch block
        }
    }
}

