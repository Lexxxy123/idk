/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.inventory.ItemStack
 */
package de.tr7zw.nbtapi;

import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.NBTListCompound;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.NBTType;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.bukkit.inventory.ItemStack;

public class NBTCompound {
    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final Lock readLock = this.readWriteLock.readLock();
    private final Lock writeLock = this.readWriteLock.writeLock();
    private String compundName;
    private NBTCompound parent;

    protected NBTCompound(NBTCompound owner, String name) {
        this.compundName = name;
        this.parent = owner;
    }

    protected Lock getReadLock() {
        return this.readLock;
    }

    protected Lock getWriteLock() {
        return this.writeLock;
    }

    protected void saveCompound() {
        if (this.parent != null) {
            this.parent.saveCompound();
        }
    }

    public String getName() {
        return this.compundName;
    }

    public Object getCompound() {
        return this.parent.getCompound();
    }

    protected void setCompound(Object compound) {
        this.parent.setCompound(compound);
    }

    public NBTCompound getParent() {
        return this.parent;
    }

    public void mergeCompound(NBTCompound comp) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.mergeOtherNBTCompound(this, comp);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public void setString(String key, String value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_STRING, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public String getString(String key) {
        try {
            this.readLock.lock();
            String string = (String)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_STRING, key);
            return string;
        } finally {
            this.readLock.unlock();
        }
    }

    protected String getContent(String key) {
        return NBTReflectionUtil.getContent(this, key);
    }

    public void setInteger(String key, Integer value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_INT, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Integer getInteger(String key) {
        try {
            this.readLock.lock();
            Integer n2 = (Integer)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_INT, key);
            return n2;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setDouble(String key, Double value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_DOUBLE, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Double getDouble(String key) {
        try {
            this.readLock.lock();
            Double d2 = (Double)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_DOUBLE, key);
            return d2;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setByte(String key, Byte value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BYTE, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Byte getByte(String key) {
        try {
            this.readLock.lock();
            Byte by = (Byte)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BYTE, key);
            return by;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setShort(String key, Short value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_SHORT, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Short getShort(String key) {
        try {
            this.readLock.lock();
            Short s2 = (Short)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_SHORT, key);
            return s2;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setLong(String key, Long value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_LONG, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Long getLong(String key) {
        try {
            this.readLock.lock();
            Long l2 = (Long)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_LONG, key);
            return l2;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setFloat(String key, Float value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_FLOAT, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Float getFloat(String key) {
        try {
            this.readLock.lock();
            Float f2 = (Float)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_FLOAT, key);
            return f2;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setByteArray(String key, byte[] value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BYTEARRAY, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public byte[] getByteArray(String key) {
        try {
            this.readLock.lock();
            byte[] byArray = (byte[])NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BYTEARRAY, key);
            return byArray;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setIntArray(String key, int[] value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_INTARRAY, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public int[] getIntArray(String key) {
        try {
            this.readLock.lock();
            int[] nArray = (int[])NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_INTARRAY, key);
            return nArray;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setBoolean(String key, Boolean value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_BOOLEAN, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    protected void set(String key, Object val) {
        NBTReflectionUtil.set(this, key, val);
        this.saveCompound();
    }

    public Boolean getBoolean(String key) {
        try {
            this.readLock.lock();
            Boolean bl2 = (Boolean)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_BOOLEAN, key);
            return bl2;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setObject(String key, Object value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setObject(this, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public <T> T getObject(String key, Class<T> type) {
        try {
            this.readLock.lock();
            T t2 = NBTReflectionUtil.getObject(this, key, type);
            return t2;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setItemStack(String key, ItemStack item) {
        try {
            this.writeLock.lock();
            this.removeKey(key);
            this.addCompound(key).mergeCompound(NBTItem.convertItemtoNBT(item));
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public ItemStack getItemStack(String key) {
        try {
            this.readLock.lock();
            NBTCompound comp = this.getCompound(key);
            ItemStack itemStack = NBTItem.convertNBTtoItem(comp);
            return itemStack;
        } finally {
            this.readLock.unlock();
        }
    }

    public void setUUID(String key, UUID value) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.setData(this, ReflectionMethod.COMPOUND_SET_UUID, key, value);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public UUID getUUID(String key) {
        try {
            this.readLock.lock();
            UUID uUID = (UUID)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_UUID, key);
            return uUID;
        } finally {
            this.readLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public Boolean hasKey(String key) {
        try {
            this.readLock.lock();
            Boolean b2 = (Boolean)NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_HAS_KEY, key);
            if (b2 == null) {
                Boolean bl2 = false;
                return bl2;
            }
            Boolean bl3 = b2;
            return bl3;
        } finally {
            this.readLock.unlock();
        }
    }

    public void removeKey(String key) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.remove(this, key);
            this.saveCompound();
        } finally {
            this.writeLock.unlock();
        }
    }

    public Set<String> getKeys() {
        try {
            this.readLock.lock();
            Set<String> set = NBTReflectionUtil.getKeys(this);
            return set;
        } finally {
            this.readLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTCompound addCompound(String name) {
        try {
            this.writeLock.lock();
            if (this.getType(name) == NBTType.NBTTagCompound) {
                NBTCompound nBTCompound = this.getCompound(name);
                return nBTCompound;
            }
            NBTReflectionUtil.addNBTTagCompound(this, name);
            NBTCompound comp = this.getCompound(name);
            if (comp == null) {
                throw new NbtApiException("Error while adding Compound, got null!");
            }
            this.saveCompound();
            NBTCompound nBTCompound = comp;
            return nBTCompound;
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTCompound getCompound(String name) {
        try {
            this.readLock.lock();
            if (this.getType(name) != NBTType.NBTTagCompound) {
                NBTCompound nBTCompound = null;
                return nBTCompound;
            }
            NBTCompound next = new NBTCompound(this, name);
            if (NBTReflectionUtil.valideCompound(next).booleanValue()) {
                NBTCompound nBTCompound = next;
                return nBTCompound;
            }
            NBTCompound nBTCompound = null;
            return nBTCompound;
        } finally {
            this.readLock.unlock();
        }
    }

    public NBTCompound getOrCreateCompound(String name) {
        return this.addCompound(name);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTList<String> getStringList(String name) {
        try {
            this.writeLock.lock();
            NBTList<String> list = NBTReflectionUtil.getList(this, name, NBTType.NBTTagString, String.class);
            this.saveCompound();
            NBTList<String> nBTList = list;
            return nBTList;
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTList<Integer> getIntegerList(String name) {
        try {
            this.writeLock.lock();
            NBTList<Integer> list = NBTReflectionUtil.getList(this, name, NBTType.NBTTagInt, Integer.class);
            this.saveCompound();
            NBTList<Integer> nBTList = list;
            return nBTList;
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTList<Float> getFloatList(String name) {
        try {
            this.writeLock.lock();
            NBTList<Float> list = NBTReflectionUtil.getList(this, name, NBTType.NBTTagFloat, Float.class);
            this.saveCompound();
            NBTList<Float> nBTList = list;
            return nBTList;
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTList<Double> getDoubleList(String name) {
        try {
            this.writeLock.lock();
            NBTList<Double> list = NBTReflectionUtil.getList(this, name, NBTType.NBTTagDouble, Double.class);
            this.saveCompound();
            NBTList<Double> nBTList = list;
            return nBTList;
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTList<Long> getLongList(String name) {
        try {
            this.writeLock.lock();
            NBTList<Long> list = NBTReflectionUtil.getList(this, name, NBTType.NBTTagLong, Long.class);
            this.saveCompound();
            NBTList<Long> nBTList = list;
            return nBTList;
        } finally {
            this.writeLock.unlock();
        }
    }

    public NBTType getListType(String name) {
        try {
            this.readLock.lock();
            if (this.getType(name) != NBTType.NBTTagList) {
                NBTType nBTType = null;
                return nBTType;
            }
            NBTType nBTType = NBTReflectionUtil.getListType(this, name);
            return nBTType;
        } finally {
            this.readLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTCompoundList getCompoundList(String name) {
        try {
            this.writeLock.lock();
            NBTCompoundList list = (NBTCompoundList)NBTReflectionUtil.getList(this, name, NBTType.NBTTagCompound, NBTListCompound.class);
            this.saveCompound();
            NBTCompoundList nBTCompoundList = list;
            return nBTCompoundList;
        } finally {
            this.writeLock.unlock();
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public NBTType getType(String name) {
        try {
            this.readLock.lock();
            if (MinecraftVersion.getVersion() == MinecraftVersion.MC1_7_R4) {
                Object nbtbase = NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET, name);
                if (nbtbase == null) {
                    NBTType nBTType = null;
                    return nBTType;
                }
                NBTType nBTType = NBTType.valueOf(((Byte)ReflectionMethod.COMPOUND_OWN_TYPE.run(nbtbase, new Object[0])).byteValue());
                return nBTType;
            }
            Object o2 = NBTReflectionUtil.getData(this, ReflectionMethod.COMPOUND_GET_TYPE, name);
            if (o2 == null) {
                NBTType nBTType = null;
                return nBTType;
            }
            NBTType nBTType = NBTType.valueOf(((Byte)o2).byteValue());
            return nBTType;
        } finally {
            this.readLock.unlock();
        }
    }

    public void writeCompound(OutputStream stream) {
        try {
            this.writeLock.lock();
            NBTReflectionUtil.writeApiNBT(this, stream);
        } finally {
            this.writeLock.unlock();
        }
    }

    public String toString() {
        return this.asNBTString();
    }

    @Deprecated
    public String toString(String key) {
        return this.asNBTString();
    }

    @Deprecated
    public String asNBTString() {
        try {
            this.readLock.lock();
            Object comp = NBTReflectionUtil.gettoCompount(this.getCompound(), this);
            if (comp == null) {
                String string = "{}";
                return string;
            }
            String string = comp.toString();
            return string;
        } finally {
            this.readLock.unlock();
        }
    }

    public int hashCode() {
        return this.toString().hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (obj instanceof NBTCompound) {
            Iterator<String> iterator;
            NBTCompound other = (NBTCompound)obj;
            if (this.getKeys().equals(other.getKeys()) && (iterator = this.getKeys().iterator()).hasNext()) {
                String key = iterator.next();
                return NBTCompound.isEqual(this, other, key);
            }
        }
        return false;
    }

    protected static boolean isEqual(NBTCompound compA, NBTCompound compB, String key) {
        if (compA.getType(key) != compB.getType(key)) {
            return false;
        }
        switch (compA.getType(key)) {
            case NBTTagByte: {
                return compA.getByte(key).equals(compB.getByte(key));
            }
            case NBTTagByteArray: {
                return Arrays.equals(compA.getByteArray(key), compB.getByteArray(key));
            }
            case NBTTagCompound: {
                return compA.getCompound(key).equals(compB.getCompound(key));
            }
            case NBTTagDouble: {
                return compA.getDouble(key).equals(compB.getDouble(key));
            }
            case NBTTagEnd: {
                return true;
            }
            case NBTTagFloat: {
                return compA.getFloat(key).equals(compB.getFloat(key));
            }
            case NBTTagInt: {
                return compA.getInteger(key).equals(compB.getInteger(key));
            }
            case NBTTagIntArray: {
                return Arrays.equals(compA.getIntArray(key), compB.getIntArray(key));
            }
            case NBTTagList: {
                return NBTReflectionUtil.getEntry(compA, key).toString().equals(NBTReflectionUtil.getEntry(compB, key).toString());
            }
            case NBTTagLong: {
                return compA.getLong(key).equals(compB.getLong(key));
            }
            case NBTTagShort: {
                return compA.getShort(key).equals(compB.getShort(key));
            }
            case NBTTagString: {
                return compA.getString(key).equals(compB.getString(key));
            }
        }
        return false;
    }
}

