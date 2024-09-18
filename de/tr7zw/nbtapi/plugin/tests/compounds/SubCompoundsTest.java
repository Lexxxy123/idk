/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.plugin.tests.compounds;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;

public class SubCompoundsTest
implements Test {
    private static final String COMP_TEST_KEY = "componentTest";
    private static final String STRING_TEST_KEY = "stringTest";
    private static final String INT_TEST_KEY = "intTest";
    private static final String DOUBLE_TEST_KEY = "doubleTest";
    private static final String BOOLEAN_TEST_KEY = "booleanTest";
    private static final String STRING_TEST_VALUE = "TestString";
    private static final int INT_TEST_VALUE = 42;
    private static final double DOUBLE_TEST_VALUE = 1.5;
    private static final boolean BOOLEAN_TEST_VALUE = true;

    @Override
    public void test() throws Exception {
        NBTContainer cont = new NBTContainer();
        NBTCompound comp = cont.addCompound(COMP_TEST_KEY);
        comp.setString(STRING_TEST_KEY, "TestString2");
        comp.setInteger(INT_TEST_KEY, 84);
        comp.setDouble(DOUBLE_TEST_KEY, 3.0);
        if (cont.getCompound("invalide") != null) {
            throw new NbtApiException("An invalide compound did not return null!");
        }
        comp = null;
        comp = cont.getCompound(COMP_TEST_KEY);
        if (comp == null) {
            throw new NbtApiException("Wasn't able to get the NBTCompound!");
        }
        if (!comp.hasKey(STRING_TEST_KEY).booleanValue()) {
            throw new NbtApiException("Wasn't able to check a compound key!");
        }
        if (!"TestString2".equals(comp.getString(STRING_TEST_KEY)) || comp.getInteger(INT_TEST_KEY) != 84 || comp.getDouble(DOUBLE_TEST_KEY) != 3.0 || comp.getBoolean(BOOLEAN_TEST_KEY).booleanValue()) {
            throw new NbtApiException("One key does not equal the original compound value!");
        }
        comp.getOrCreateCompound("someName").setString("test", "abc");
        if (!comp.getOrCreateCompound("someName").getString("test").equals("abc")) {
            throw new NbtApiException("getOrCreateCompound did not return the same compound!");
        }
    }
}

