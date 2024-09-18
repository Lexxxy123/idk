/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.Color
 *  org.bukkit.Location
 *  org.bukkit.Material
 *  org.bukkit.entity.Entity
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.DynamicLocation;
import de.slikey.effectlib.util.ParticleEffect;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public abstract class Effect
implements Runnable {
    public EffectType type = EffectType.INSTANT;
    public Color color = null;
    public float speed = 0.0f;
    public int delay = 0;
    public int period = 1;
    public int iterations = 0;
    public Integer duration = null;
    public Runnable callback = null;
    public float visibleRange = 32.0f;
    public boolean autoOrient = false;
    public Vector offset = null;
    public Vector relativeOffset = null;
    public Vector targetOffset = null;
    public float yawOffset = 0.0f;
    public float pitchOffset = 0.0f;
    public boolean updateLocations = true;
    public boolean updateDirections = true;
    public Material material;
    public Byte materialData;
    public int particleCount = 1;
    public int particleOffsetX = 0;
    public int particleOffsetY = 0;
    public int particleOffsetZ = 0;
    public boolean asynchronous = true;
    protected final EffectManager effectManager;
    protected Runnable asyncRunnableTask;
    private DynamicLocation origin = null;
    private DynamicLocation target = null;
    private boolean done = false;

    public Effect(EffectManager effectManager) {
        if (effectManager == null) {
            throw new IllegalArgumentException("EffectManager cannot be null!");
        }
        this.effectManager = effectManager;
        this.visibleRange = effectManager.getParticleRange();
    }

    public final void cancel() {
        this.cancel(true);
    }

    public final void cancel(boolean callback) {
        if (callback) {
            this.done();
        } else {
            this.done = true;
        }
    }

    public final boolean isDone() {
        return this.done;
    }

    public abstract void onRun();

    public void onDone() {
    }

    @Override
    public final void run() {
        if (!this.validate()) {
            this.cancel();
            return;
        }
        if (this.done) {
            return;
        }
        if (this.asynchronous) {
            if (this.asyncRunnableTask == null) {
                final Effect effect = this;
                this.asyncRunnableTask = new Runnable(){

                    @Override
                    public void run() {
                        try {
                            effect.onRun();
                        } catch (Exception ex) {
                            Effect.this.effectManager.onError(ex);
                            Bukkit.getScheduler().runTask(Effect.this.effectManager.getOwningPlugin(), new Runnable(){

                                @Override
                                public void run() {
                                    effect.done();
                                }
                            });
                        }
                    }
                };
            }
            Bukkit.getScheduler().runTaskAsynchronously(this.effectManager.getOwningPlugin(), this.asyncRunnableTask);
        } else {
            try {
                this.onRun();
            } catch (Exception ex) {
                this.done();
                this.effectManager.onError(ex);
            }
        }
        if (this.type == EffectType.REPEATING) {
            if (this.iterations == -1) {
                return;
            }
            --this.iterations;
            if (this.iterations < 1) {
                this.done();
            }
        } else {
            this.done();
        }
    }

    public final void start() {
        this.updateDuration();
        this.effectManager.start(this);
    }

    public final void infinite() {
        this.type = EffectType.REPEATING;
        this.iterations = -1;
    }

    public Entity getEntity() {
        return this.origin == null ? null : this.origin.getEntity();
    }

    public Entity getTargetEntity() {
        return this.target == null ? null : this.target.getEntity();
    }

    public final Location getLocation() {
        return this.origin == null ? null : this.origin.getLocation();
    }

    public final Location getTarget() {
        return this.target == null ? null : this.target.getLocation();
    }

    public void setDynamicOrigin(DynamicLocation location) {
        if (location == null) {
            throw new IllegalArgumentException("Origin Location cannot be null!");
        }
        this.origin = location;
        if (this.origin == null) {
            return;
        }
        if (this.offset != null) {
            this.origin.addOffset(this.offset);
        }
        if (this.relativeOffset != null) {
            this.origin.addRelativeOffset(this.relativeOffset);
        }
        this.origin.setDirectionOffset(this.yawOffset, this.pitchOffset);
        this.origin.setUpdateLocation(this.updateLocations);
        this.origin.setUpdateDirection(this.updateDirections);
    }

    public void setDynamicTarget(DynamicLocation location) {
        this.target = location;
        if (this.target != null && this.targetOffset != null) {
            this.target.addOffset(this.targetOffset);
        }
        if (this.target != null) {
            this.target.setUpdateLocation(this.updateLocations);
            this.target.setUpdateDirection(this.updateDirections);
        }
    }

    protected final boolean validate() {
        this.updateLocation();
        this.updateTarget();
        Location location = this.getLocation();
        if (location == null) {
            return false;
        }
        if (this.autoOrient) {
            Location targetLocation;
            Location location2 = targetLocation = this.target == null ? null : this.target.getLocation();
            if (targetLocation != null) {
                Vector direction = targetLocation.toVector().subtract(location.toVector());
                location.setDirection(direction);
                targetLocation.setDirection(direction.multiply(-1));
            }
        }
        return true;
    }

    protected void updateDuration() {
        if (this.duration != null) {
            if (this.period < 1) {
                this.period = 1;
            }
            this.iterations = this.duration / this.period / 50;
        }
    }

    protected void updateLocation() {
        if (this.origin != null) {
            this.origin.update();
        }
    }

    protected void updateTarget() {
        if (this.target != null) {
            this.target.update();
        }
    }

    protected void display(ParticleEffect effect, Location location) {
        this.display(effect, location, this.color);
    }

    protected void display(ParticleEffect particle, Location location, Color color) {
        this.display(particle, location, color, this.speed, this.particleCount);
    }

    protected void display(ParticleEffect particle, Location location, float speed, int amount) {
        this.display(particle, location, this.color, speed, amount);
    }

    protected void display(ParticleEffect particle, Location location, Color color, float speed, int amount) {
        particle.display(particle.getData(this.material, this.materialData), location, color, (double)this.visibleRange, (float)this.particleOffsetX, (float)this.particleOffsetY, this.particleOffsetZ, speed, amount);
    }

    private void done() {
        this.done = true;
        this.effectManager.done(this);
        this.onDone();
    }

    public void setEntity(Entity entity) {
        this.origin = new DynamicLocation(entity);
    }

    public void setLocation(Location location) {
        this.origin = new DynamicLocation(location);
    }

    public void setTargetEntity(Entity entity) {
        this.target = new DynamicLocation(entity);
    }

    public void setTargetLocation(Location location) {
        this.target = new DynamicLocation(location);
    }
}

