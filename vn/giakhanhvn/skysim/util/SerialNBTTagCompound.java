/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  net.minecraft.server.v1_8_R3.NBTBase
 *  net.minecraft.server.v1_8_R3.NBTTagCompound
 *  org.bukkit.configuration.serialization.ConfigurationSerializable
 */
package vn.giakhanhvn.skysim.util;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.server.v1_8_R3.NBTBase;
import net.minecraft.server.v1_8_R3.NBTTagCompound;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import vn.giakhanhvn.skysim.util.SUtil;

public class SerialNBTTagCompound
extends NBTTagCompound
implements ConfigurationSerializable {
    public SerialNBTTagCompound() {
    }

    public SerialNBTTagCompound(NBTTagCompound compound) {
        for (String k2 : compound.c()) {
            this.set(k2, compound.get(k2));
        }
    }

    public Map<String, Object> serialize() {
        HashMap<String, Object> map = new HashMap<String, Object>();
        for (String k2 : this.c()) {
            NBTBase b2 = this.get(k2);
            if (b2 instanceof NBTTagCompound) {
                SerialNBTTagCompound serial = new SerialNBTTagCompound((NBTTagCompound)b2);
                for (Map.Entry<String, Object> entry : serial.serialize().entrySet()) {
                    map.put(k2 + "." + entry.getKey(), entry.getValue());
                }
                continue;
            }
            map.put(k2, SUtil.getObjectFromCompound(this, k2));
        }
        return map;
    }

    public static SerialNBTTagCompound deserialize(Map<String, Object> map) {
        SerialNBTTagCompound compound = new SerialNBTTagCompound();
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            String key = entry.getKey();
            String[] dir = entry.getKey().split("\\.");
            if (dir.length >= 2) {
                key = dir[dir.length - 1];
                SerialNBTTagCompound track = compound;
                for (int i2 = 0; i2 < dir.length - 1; ++i2) {
                    if (!track.hasKey(dir[i2])) {
                        track.set(dir[i2], (NBTBase)new NBTTagCompound());
                    }
                    track = (SerialNBTTagCompound)track.getCompound(dir[i2]);
                }
                track.set(key, SUtil.getBaseFromObject(entry.getValue()));
                continue;
            }
            compound.set(key, SUtil.getBaseFromObject(entry.getValue()));
        }
        return compound;
    }
}

