/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.inventory.ItemStack
 */
package xyz.xenondevs.particle.data.texture;

import org.bukkit.inventory.ItemStack;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.PropertyType;
import xyz.xenondevs.particle.data.texture.ParticleTexture;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public final class ItemTexture
extends ParticleTexture {
    private final ItemStack itemStack;

    public ItemTexture(ItemStack itemStack) {
        super(itemStack == null ? null : itemStack.getType(), (byte)0);
        this.itemStack = itemStack;
    }

    @Override
    public Object toNMSData() {
        if (this.getMaterial() == null || this.getData() < 0 || this.getEffect() == null || !this.getEffect().hasProperty(PropertyType.REQUIRES_ITEM)) {
            return null;
        }
        if (ReflectionUtils.MINECRAFT_VERSION < 13.0) {
            return super.toNMSData();
        }
        try {
            return ParticleConstants.PARTICLE_PARAM_ITEM_CONSTRUCTOR.newInstance(this.getEffect().getNMSObject(), ItemTexture.toNMSItemStack(this.getItemStack()));
        } catch (Exception ex) {
            return null;
        }
    }

    public ItemStack getItemStack() {
        return this.itemStack;
    }

    public static Object toNMSItemStack(ItemStack itemStack) {
        if (itemStack == null) {
            return null;
        }
        try {
            return ParticleConstants.CRAFT_ITEM_STACK_AS_NMS_COPY_METHOD.invoke(null, itemStack);
        } catch (Exception ex) {
            return null;
        }
    }
}

