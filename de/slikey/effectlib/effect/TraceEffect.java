/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.World
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.ParticleEffect;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.util.Vector;

public class TraceEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public int refresh = 5;
    public int maxWayPoints = 30;
    protected final List<Vector> wayPoints = new ArrayList<Vector>();
    protected int step = 0;
    protected World world;

    public TraceEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 600;
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    @Override
    public void onRun() {
        Location location = this.getLocation();
        if (this.world == null) {
            this.world = location.getWorld();
        } else if (!location.getWorld().equals(this.world)) {
            this.cancel(true);
            return;
        }
        List<Vector> list = this.wayPoints;
        synchronized (list) {
            if (this.wayPoints.size() >= this.maxWayPoints) {
                this.wayPoints.remove(0);
            }
        }
        this.wayPoints.add(location.toVector());
        ++this.step;
        if (this.step % this.refresh != 0) {
            return;
        }
        list = this.wayPoints;
        synchronized (list) {
            for (Vector position : this.wayPoints) {
                Location particleLocation = new Location(this.world, position.getX(), position.getY(), position.getZ());
                this.display(this.particle, particleLocation);
            }
        }
    }
}

