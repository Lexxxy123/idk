/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Color
 *  org.bukkit.FireworkEffect
 *  org.bukkit.FireworkEffect$Builder
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Firework
 *  org.bukkit.inventory.meta.FireworkMeta
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.LocationEffect;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

@Deprecated
public class BigBangLocationEffect
extends LocationEffect {
    public FireworkEffect firework;
    public int intensity = 2;
    public float radius = 2.0f;
    public int explosions = 10;
    public int soundInterval = 5;
    protected int step = 0;

    public BigBangLocationEffect(EffectManager effectManager, Location location) {
        super(effectManager, location);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 400;
        FireworkEffect.Builder b2 = FireworkEffect.builder();
        b2.withColor(Color.RED).withColor(Color.ORANGE).withColor(Color.BLACK);
        b2.withFade(Color.BLACK);
        b2.trail(true);
        this.firework = b2.build();
    }

    @Override
    public void onRun() {
        for (int i2 = 0; i2 < this.explosions; ++i2) {
            Vector v2 = RandomUtils.getRandomVector().multiply(this.radius);
            this.detonate(v2);
            if (this.step % this.soundInterval != 0) continue;
            this.location.getWorld().playSound(this.location, Sound.EXPLODE, 100.0f, 1.0f);
        }
        ++this.step;
    }

    protected void detonate(Vector v2) {
        Firework fw = (Firework)this.location.getWorld().spawnEntity(this.location.add(v2), EntityType.FIREWORK);
        this.location.subtract(v2);
        FireworkMeta meta = fw.getFireworkMeta();
        meta.setPower(0);
        for (int i2 = 0; i2 < this.intensity; ++i2) {
            meta.addEffect(this.firework);
        }
        fw.setFireworkMeta(meta);
        fw.detonate();
    }
}

