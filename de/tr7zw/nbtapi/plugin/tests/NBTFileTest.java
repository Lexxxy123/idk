/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi.plugin.tests;

import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTFile;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.NBTAPI;
import de.tr7zw.nbtapi.plugin.tests.Test;
import java.io.File;
import java.nio.file.Files;

public class NBTFileTest
implements Test {
    @Override
    public void test() throws Exception {
        NBTAPI.getInstance().getDataFolder().mkdirs();
        File testFile = new File(NBTAPI.getInstance().getDataFolder(), "test.nbt");
        Files.deleteIfExists(testFile.toPath());
        NBTFile file = new NBTFile(testFile);
        file.addCompound("testcomp").setString("test1", "ok");
        NBTCompound comp = file.getCompound("testcomp");
        comp.setString("test2", "ok");
        file.setLong("time", System.currentTimeMillis());
        file.setString("test", "test");
        NBTCompound chunks = file.addCompound("chunks");
        NBTCompound chunk = chunks.addCompound("somechunk");
        NBTCompound block = chunk.addCompound("someblock");
        block.setString("type", "wool");
        file.save();
        if (!"wool".equals(block.getString("type"))) {
            throw new NbtApiException("SubCompounds did not work!");
        }
        NBTFile fileLoaded = new NBTFile(testFile);
        if (!fileLoaded.getString("test").equals("test")) {
            throw new NbtApiException("Wasn't able to load NBT File with the correct content!");
        }
        Files.deleteIfExists(fileLoaded.getFile().toPath());
        String str = fileLoaded.asNBTString();
        NBTContainer rebuild = new NBTContainer(str);
        if (!str.equals(rebuild.asNBTString())) {
            throw new NbtApiException("Wasn't able to parse NBT from a String!");
        }
    }
}

