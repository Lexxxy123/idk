/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.mojang.authlib.GameProfile
 */
package de.tr7zw.nbtapi;

import com.mojang.authlib.GameProfile;
import de.tr7zw.nbtapi.NBTCompound;
import de.tr7zw.nbtapi.NBTContainer;
import de.tr7zw.nbtapi.NBTReflectionUtil;
import de.tr7zw.nbtapi.utils.nmsmappings.ObjectCreator;
import de.tr7zw.nbtapi.utils.nmsmappings.ReflectionMethod;

public class NBTGameProfile {
    public static NBTCompound toNBT(GameProfile profile) {
        return new NBTContainer(ReflectionMethod.GAMEPROFILE_SERIALIZE.run(null, ObjectCreator.NMS_NBTTAGCOMPOUND.getInstance(new Object[0]), profile));
    }

    public static GameProfile fromNBT(NBTCompound compound) {
        return (GameProfile)ReflectionMethod.GAMEPROFILE_DESERIALIZE.run(null, NBTReflectionUtil.gettoCompount(compound.getCompound(), compound));
    }
}

