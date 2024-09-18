/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.plugin.tests.compounds;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTType;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;

public class TypeTest
implements Test {
    @Override
    public void test() throws Exception {
        NBTContainer comp = new NBTContainer();
        comp.setString("s", "test");
        comp.setInteger("i", 42);
        comp.addCompound("c");
        if (comp.getType("s") != NBTType.NBTTagString || comp.getType("i") != NBTType.NBTTagInt || comp.getType("c") != NBTType.NBTTagCompound) {
            throw new NbtApiException("One parsed type did not match what it should have been!");
        }
    }
}

