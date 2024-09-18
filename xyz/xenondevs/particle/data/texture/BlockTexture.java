/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Material
 */
package xyz.xenondevs.particle.data.texture;

import java.lang.reflect.Field;
import org.bukkit.Material;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.PropertyType;
import xyz.xenondevs.particle.data.texture.ParticleTexture;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public final class BlockTexture
extends ParticleTexture {
    public BlockTexture(Material material) {
        super(material, (byte)0);
    }

    public BlockTexture(Material material, byte data) {
        super(material, data);
    }

    @Override
    public Object toNMSData() {
        if (this.getMaterial() == null || !this.getMaterial().isBlock() || this.getEffect() == null || !this.getEffect().hasProperty(PropertyType.REQUIRES_BLOCK)) {
            return null;
        }
        if (ReflectionUtils.MINECRAFT_VERSION < 13.0) {
            return super.toNMSData();
        }
        Object block = this.getBlockData(this.getMaterial());
        if (block == null) {
            return null;
        }
        try {
            return ParticleConstants.PARTICLE_PARAM_BLOCK_CONSTRUCTOR.newInstance(this.getEffect().getNMSObject(), block);
        } catch (Exception ex) {
            return null;
        }
    }

    public Object getBlockData(Material material) {
        try {
            Object block;
            if (ReflectionUtils.MINECRAFT_VERSION < 17.0) {
                Field blockField = ReflectionUtils.getFieldOrNull(ParticleConstants.BLOCKS_CLASS, material.name(), false);
                if (blockField == null) {
                    return null;
                }
                block = ReflectionUtils.readField(blockField, null);
            } else {
                block = ParticleConstants.REGISTRY_GET_METHOD.invoke(ParticleConstants.BLOCK_REGISTRY, ReflectionUtils.getMinecraftKey(material.name().toLowerCase()));
            }
            return ParticleConstants.BLOCK_GET_BLOCK_DATA_METHOD.invoke(block, new Object[0]);
        } catch (Exception ex) {
            return null;
        }
    }
}

