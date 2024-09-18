/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 */
package xyz.xenondevs.particle.data.texture;

import org.bukkit.Material;
import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.data.ParticleData;

public class ParticleTexture
extends ParticleData {
    private final Material material;
    private final byte data;

    ParticleTexture(Material material, byte data) {
        this.material = material;
        this.data = data;
    }

    public Material getMaterial() {
        return this.material;
    }

    public byte getData() {
        return this.data;
    }

    @Override
    public Object toNMSData() {
        int[] nArray;
        int id = this.getMaterial().getId();
        byte data = this.getData();
        if (this.getEffect() == ParticleEffect.ITEM_CRACK) {
            int[] nArray2 = new int[2];
            nArray2[0] = id;
            nArray = nArray2;
            nArray2[1] = data;
        } else {
            int[] nArray3 = new int[1];
            nArray = nArray3;
            nArray3[0] = id | data << 12;
        }
        return nArray;
    }
}

