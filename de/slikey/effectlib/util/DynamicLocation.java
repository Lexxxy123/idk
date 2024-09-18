/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Entity
 *  org.bukkit.entity.LivingEntity
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.util;

import de.slikey.effectlib.util.VectorUtils;
import java.lang.ref.WeakReference;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.util.Vector;

public class DynamicLocation {
    private final Location location;
    private final Location originalLocation;
    private final WeakReference<Entity> entity;
    private float yawOffset;
    private float pitchOffset;
    private Vector offset;
    private Vector relativeOffset;
    private Vector entityOffset;
    private boolean updateLocation = true;
    private boolean updateDirection = true;

    public DynamicLocation(Location location) {
        this.location = location != null ? location.clone() : null;
        this.originalLocation = location;
        this.entity = null;
    }

    public DynamicLocation(Entity entity) {
        if (entity != null) {
            this.entity = new WeakReference<Entity>(entity);
            this.location = this.getEntityLocation(entity);
        } else {
            this.entity = null;
            this.location = null;
        }
        this.originalLocation = this.location;
    }

    public DynamicLocation(Location location, Entity entity) {
        this.location = location != null ? location.clone() : (entity != null ? this.getEntityLocation(entity) : null);
        if (entity != null) {
            this.entity = new WeakReference<Entity>(entity);
            this.entityOffset = this.location.toVector().subtract(this.getEntityLocation(entity).toVector());
        } else {
            this.entity = null;
        }
        this.originalLocation = location;
    }

    public void addOffset(Vector offset) {
        if (this.offset == null) {
            this.offset = offset.clone();
        } else {
            this.offset.add(offset);
        }
        this.updateOffsets();
    }

    public void addRelativeOffset(Vector offset) {
        if (this.relativeOffset == null) {
            this.relativeOffset = offset.clone();
        } else {
            this.relativeOffset.add(offset);
        }
        this.updateOffsets();
    }

    public Entity getEntity() {
        return this.entity == null ? null : (Entity)this.entity.get();
    }

    public Location getLocation() {
        return this.location;
    }

    protected Location getEntityLocation(Entity entity) {
        if (entity instanceof LivingEntity) {
            return ((LivingEntity)entity).getEyeLocation();
        }
        return entity.getLocation();
    }

    public void setDirection(Vector direction) {
        this.location.setDirection(direction);
        this.updateDirectionOffsets();
    }

    protected void updateDirectionOffsets() {
        if (this.yawOffset != 0.0f) {
            this.location.setYaw(this.location.getYaw() + this.yawOffset);
        }
        if (this.pitchOffset != 0.0f) {
            this.location.setPitch(this.location.getPitch() + this.pitchOffset);
        }
    }

    public void updateFrom(Location newLocation) {
        if (this.originalLocation != null) {
            this.originalLocation.setX(newLocation.getX());
            this.originalLocation.setY(newLocation.getY());
            this.originalLocation.setZ(newLocation.getZ());
        }
        this.updateOffsets();
    }

    public void updateOffsets() {
        if (this.originalLocation == null || this.location == null) {
            return;
        }
        this.location.setX(this.originalLocation.getX());
        this.location.setY(this.originalLocation.getY());
        this.location.setZ(this.originalLocation.getZ());
        if (this.offset != null) {
            this.location.add(this.offset);
        }
        if (this.relativeOffset != null) {
            this.location.add(VectorUtils.rotateVector(this.relativeOffset, this.location));
        }
        if (this.entityOffset != null) {
            this.location.add(this.entityOffset);
        }
    }

    public void setUpdateLocation(boolean update) {
        this.updateLocation = update;
    }

    public void update() {
        Entity entityReference;
        if (this.location == null || !this.updateLocation && !this.updateDirection) {
            return;
        }
        Entity entity = entityReference = this.entity == null ? null : (Entity)this.entity.get();
        if (entityReference != null) {
            Location currentLocation = this.getEntityLocation(entityReference);
            if (this.updateDirection) {
                this.setDirection(currentLocation.getDirection());
            }
            if (this.updateLocation) {
                this.updateFrom(currentLocation);
            }
        }
    }

    public void setUpdateDirection(boolean updateDirection) {
        this.updateDirection = updateDirection;
    }

    public void setDirectionOffset(float yawOffset, float pitchOffset) {
        this.pitchOffset = pitchOffset;
        this.yawOffset = yawOffset;
        this.updateDirectionOffsets();
    }
}

