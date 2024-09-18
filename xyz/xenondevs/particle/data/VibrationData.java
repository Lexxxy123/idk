/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 */
package xyz.xenondevs.particle.data;

import java.util.Objects;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import xyz.xenondevs.particle.ParticleConstants;
import xyz.xenondevs.particle.ParticleEffect;
import xyz.xenondevs.particle.data.ParticleData;
import xyz.xenondevs.particle.utils.ReflectionUtils;

public final class VibrationData
extends ParticleData {
    private final Location start;
    private final Location blockDestination;
    private final Entity entitydestination;
    private final int ticks;

    public VibrationData(Location start, Location destination, int ticks) {
        this.start = Objects.requireNonNull(start);
        this.blockDestination = Objects.requireNonNull(destination);
        this.entitydestination = null;
        this.ticks = ticks;
    }

    public VibrationData(Location destination, int ticks) {
        this.start = null;
        this.blockDestination = Objects.requireNonNull(destination);
        this.entitydestination = null;
        this.ticks = ticks;
    }

    public VibrationData(Location start, Entity destination, int ticks) {
        this.start = Objects.requireNonNull(start);
        this.entitydestination = Objects.requireNonNull(destination);
        this.blockDestination = null;
        this.ticks = ticks;
    }

    public VibrationData(Entity destination, int ticks) {
        this.start = null;
        this.entitydestination = Objects.requireNonNull(destination);
        this.blockDestination = null;
        this.ticks = ticks;
    }

    public Location getStart() {
        return this.start;
    }

    public Location getBlockDestination() {
        return this.blockDestination;
    }

    public Entity getEntityDestination() {
        return this.entitydestination;
    }

    public int getTicks() {
        return this.ticks;
    }

    @Override
    public Object toNMSData() {
        if (ReflectionUtils.MINECRAFT_VERSION < 17.0 || this.getEffect() != ParticleEffect.VIBRATION) {
            return null;
        }
        boolean isBlockDest = this.blockDestination != null;
        Object start = ReflectionUtils.createBlockPosition(this.getStart());
        try {
            Object source;
            if (ReflectionUtils.MINECRAFT_VERSION < 19.0) {
                Object source2;
                if (isBlockDest) {
                    Object dest = ReflectionUtils.createBlockPosition(this.getBlockDestination());
                    source2 = ParticleConstants.BLOCK_POSITION_SOURCE_CONSTRUCTOR.newInstance(dest);
                } else {
                    source2 = ParticleConstants.ENTITY_POSITION_SOURCE_CONSTRUCTOR.newInstance(this.getEntityDestination().getEntityId());
                }
                Object path = ParticleConstants.VIBRATION_PATH_CONSTRUCTOR.newInstance(start, source2, this.getTicks());
                return ParticleConstants.PARTICLE_PARAM_VIBRATION_CONSTRUCTOR.newInstance(path);
            }
            if (isBlockDest) {
                Object dest = ReflectionUtils.createBlockPosition(this.getBlockDestination());
                source = ParticleConstants.BLOCK_POSITION_SOURCE_CONSTRUCTOR.newInstance(dest);
            } else {
                source = ParticleConstants.ENTITY_POSITION_SOURCE_CONSTRUCTOR.newInstance(ReflectionUtils.getEntityHandle(this.getEntityDestination()), Float.valueOf(0.0f));
            }
            return ParticleConstants.PARTICLE_PARAM_VIBRATION_CONSTRUCTOR.newInstance(source, this.getTicks());
        } catch (Exception ex) {
            return null;
        }
    }
}

