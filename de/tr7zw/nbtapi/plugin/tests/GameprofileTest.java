/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 */
package de.tr7zw.nbtapi.plugin.tests;

import com.mojang.authlib.GameProfile;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTGameProfile;
import de.tr7zw.nbtapi.NbtApiException;
import de.tr7zw.nbtapi.plugin.tests.Test;
import java.util.UUID;

public class GameprofileTest
implements Test {
    @Override
    public void test() throws Exception {
        UUID uuid = UUID.randomUUID();
        GameProfile profile = new GameProfile(uuid, "random");
        NBTCompound nbt = NBTGameProfile.toNBT(profile);
        profile = null;
        profile = NBTGameProfile.fromNBT(nbt);
        if (profile == null || !profile.getId().equals(uuid)) {
            throw new NbtApiException("Error when converting a GameProfile from/to NBT!");
        }
    }
}

