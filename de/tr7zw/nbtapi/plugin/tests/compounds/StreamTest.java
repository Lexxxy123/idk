/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.plugin.tests.compounds;

import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;

public class StreamTest
implements Test {
    @Override
    public void test() throws Exception {
        NBTContainer base = new NBTContainer();
        base.addCompound("sub").setString("hello", "world");
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        base.getCompound("sub").writeCompound(outStream);
        byte[] data = outStream.toByteArray();
        ByteArrayInputStream inputStream = new ByteArrayInputStream(data);
        NBTContainer container = new NBTContainer(inputStream);
        if (!container.toString().equals(base.getCompound("sub").toString())) {
            throw new NbtApiException("Component content did not match! " + base.getCompound("sub") + " " + container);
        }
    }
}

