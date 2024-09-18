/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.minecraft;

import vn.giakhanhvn.skysim.nms.nmsutil.reflection.minecraft.Minecraft;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.ClassResolver;

public class NMSClassResolver
extends ClassResolver {
    @Override
    public Class resolve(String ... names) throws ClassNotFoundException {
        for (int i2 = 0; i2 < names.length; ++i2) {
            if (names[i2].startsWith("net.minecraft.server")) continue;
            names[i2] = "net.minecraft.server." + Minecraft.getVersion() + names[i2];
        }
        return super.resolve(names);
    }
}

