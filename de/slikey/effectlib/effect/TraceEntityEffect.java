/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.entity.Entity
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.EntityEffect;
import de.slikey.effectlib.util.ParticleEffect;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.util.Vector;

public class TraceEntityEffect
extends EntityEffect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int refresh = 5;
    public int maxWayPoints = 30;
    protected List<Vector> wayPoints;
    protected int step = 0;
    protected World world;

    public TraceEntityEffect(EffectManager effectManager, Entity entity) {
        super(effectManager, entity);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 600;
        this.wayPoints = new ArrayList<Vector>();
    }

    @Override
    public void onRun() {
        if (this.world == null) {
            this.world = this.entity.getWorld();
        } else if (this.entity.getWorld() != this.world) {
            this.cancel(true);
            return;
        }
        if (this.wayPoints.size() >= this.maxWayPoints) {
            this.wayPoints.remove(0);
        }
        this.wayPoints.add(this.entity.getLocation().toVector());
        ++this.step;
        if (this.step % this.refresh != 0) {
            return;
        }
        for (Vector position : this.wayPoints) {
            Location location = new Location(this.world, position.getX(), position.getY(), position.getZ());
            this.particle.display(location, this.visibleRange);
        }
    }
}

