/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.math.EquationTransform;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.VectorUtils;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class EquationEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.REDSTONE;
    public String xEquation = "t";
    public String yEquation = "0";
    public String zEquation = "0";
    public int particles = 1;
    public boolean orient = true;
    private EquationTransform xTransform;
    private EquationTransform yTransform;
    private EquationTransform zTransform;
    private int step;

    public EquationEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 1;
        this.iterations = 100;
        this.step = 0;
    }

    @Override
    public void onRun() {
        if (this.step == 0) {
            this.xTransform = new EquationTransform(this.xEquation);
            this.yTransform = new EquationTransform(this.yEquation);
            this.zTransform = new EquationTransform(this.zEquation);
        }
        Location location = this.getLocation();
        for (int i2 = 0; i2 < this.particles; ++i2) {
            Double xValue = this.xTransform.get(this.step);
            Double yValue = this.yTransform.get(this.step);
            Double zValue = this.zTransform.get(this.step);
            Vector result = new Vector(xValue.doubleValue(), yValue.doubleValue(), zValue.doubleValue());
            if (this.orient) {
                result = VectorUtils.rotateVector(result, location);
            }
            Location targetLocation = location.clone();
            targetLocation.add(result);
            this.display(this.particle, targetLocation);
            ++this.step;
        }
    }
}

