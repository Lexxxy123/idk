/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.plugin.tests.compounds;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTCompoundList;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTList;
import de.tr7zw.nbtapi.NBTListCompound;
import de.tr7zw.nbtapi.NBTType;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import java.util.Arrays;

public class ListTest
implements Test {
    @Override
    public void test() throws Exception {
        NBTContainer comp = new NBTContainer();
        NBTList<String> list = comp.getStringList("testlist");
        list.add("test1");
        list.add("test2");
        list.add("test3");
        list.add("test4");
        list.set(2, "test42");
        list.remove(1);
        if (!((String)list.get(1)).equals("test42") || list.size() != 3) {
            throw new NbtApiException("The String-list did not match what it should have looked like.");
        }
        NBTCompoundList taglist = comp.getCompoundList("complist");
        NBTListCompound lcomp = taglist.addCompound();
        lcomp.setDouble("double1", 0.3333);
        lcomp.setInteger("int1", 42);
        lcomp.setString("test1", "test1");
        lcomp.setString("test2", "test2");
        lcomp.removeKey("test1");
        NBTCompound subsubcomp = lcomp.addCompound("listsubkey");
        subsubcomp.setString("deep", "String");
        subsubcomp.getCompoundList("deeplist").addCompound().setString("test", "test");
        subsubcomp.getCompoundList("clonelist").addCompound(comp);
        taglist = null;
        lcomp = null;
        subsubcomp = null;
        taglist = comp.getCompoundList("complist");
        if (taglist.size() == 1) {
            lcomp = taglist.get(0);
            if (lcomp.getKeys().size() != 4) {
                throw new NbtApiException("Wrong key amount in Taglist (" + lcomp.getKeys().size() + ")!");
            }
            if (lcomp.getDouble("double1") != 0.3333 || lcomp.getInteger("int1") != 42 || !lcomp.getString("test2").equals("test2") || lcomp.hasKey("test1").booleanValue()) {
                throw new NbtApiException("One key in the Taglist changed! The Item-NBT-API may not work!");
            }
            if (lcomp.getCompound("listsubkey") == null || !"String".equals(lcomp.getCompound("listsubkey").getString("deep"))) {
                throw new NbtApiException("The Compound nested in the listcompound was not correct! The Item-NBT-API may not work!");
            }
            if (lcomp.getCompound("listsubkey").getType("deep") != NBTType.NBTTagString) {
                throw new NbtApiException("The nested key's type wasn't correct! The Item-NBT-API may not work!");
            }
            if (lcomp.getCompound("listsubkey").getType("deeplist") != NBTType.NBTTagList) {
                throw new NbtApiException("The nested list's type wasn't correct '" + (Object)((Object)lcomp.getCompound("listsubkey").getType("deeplist")) + "'! The Item-NBT-API may not work!");
            }
        } else {
            throw new NbtApiException("Taglist is empty! The Item-NBT-API may not work!");
        }
        if (comp.getListType("complist") != NBTType.NBTTagCompound) {
            throw new NbtApiException("complist had the wrong type! The Item-NBT-API may not work!");
        }
        NBTList<Integer> intlist = comp.getIntegerList("inttest");
        intlist.add(42);
        intlist.add(69);
        if (intlist.size() != 2 || (Integer)intlist.get(0) != 42 || (Integer)intlist.get(1) != 69) {
            throw new NbtApiException("IntList is not correct! " + Arrays.toString((Object[])intlist.toArray((E[])new Integer[0])));
        }
        if (comp.getListType("inttest") != NBTType.NBTTagInt) {
            throw new NbtApiException("inttest had the wrong type! The Item-NBT-API may not work!");
        }
        NBTList<Double> doublelist = comp.getDoubleList("doubletest");
        doublelist.add(42.23);
        doublelist.add(69.69);
        if (doublelist.size() != 2 || (Double)doublelist.get(0) != 42.23 || (Double)doublelist.get(1) != 69.69) {
            throw new NbtApiException("DoubleList is not correct! " + Arrays.toString((Object[])doublelist.toArray((E[])new Double[0])));
        }
        if (comp.getListType("doubletest") != NBTType.NBTTagDouble) {
            throw new NbtApiException("doubletest had the wrong type! The Item-NBT-API may not work!");
        }
        NBTList<Float> floatlist = comp.getFloatList("floattest");
        floatlist.add(Float.valueOf(42.23f));
        floatlist.add(Float.valueOf(69.69f));
        if (floatlist.size() != 2 || ((Float)floatlist.get(0)).floatValue() != 42.23f || ((Float)floatlist.get(1)).floatValue() != 69.69f) {
            throw new NbtApiException("FloatList is not correct! " + Arrays.toString((Object[])floatlist.toArray((E[])new Float[0])));
        }
        if (comp.getListType("floattest") != NBTType.NBTTagFloat) {
            throw new NbtApiException("floattest had the wrong type! The Item-NBT-API may not work!");
        }
        NBTList<Long> longlist = comp.getLongList("longtest");
        longlist.add(1241234124124L);
        longlist.add(1231454321312L);
        if (longlist.size() != 2 || (Long)longlist.get(0) != 1241234124124L || (Long)longlist.get(1) != 1231454321312L) {
            throw new NbtApiException("LongList is not correct! " + Arrays.toString((Object[])longlist.toArray((E[])new Long[0])));
        }
        if (comp.getListType("longtest") != NBTType.NBTTagLong) {
            throw new NbtApiException("longtest had the wrong type! The Item-NBT-API may not work!");
        }
    }
}

