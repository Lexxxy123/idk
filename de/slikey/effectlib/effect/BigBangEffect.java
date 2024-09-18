/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Color
 *  org.bukkit.FireworkEffect
 *  org.bukkit.FireworkEffect$Builder
 *  org.bukkit.FireworkEffect$Type
 *  org.bukkit.Location
 *  org.bukkit.Sound
 *  org.bukkit.entity.EntityType
 *  org.bukkit.entity.Firework
 *  org.bukkit.inventory.meta.FireworkMeta
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.Effect;
import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.util.RandomUtils;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.util.Vector;

public class BigBangEffect
extends Effect {
    public FireworkEffect.Type fireworkType = FireworkEffect.Type.BURST;
    public Color color = Color.RED;
    public Color color2 = Color.ORANGE;
    public Color color3 = Color.BLACK;
    public Color fadeColor = Color.BLACK;
    public int intensity = 2;
    public float radius = 2.0f;
    public int explosions = 10;
    public int soundInterval = 5;
    public Sound sound = Sound.EXPLODE;
    public float soundVolume = 100.0f;
    public float soundPitch = 1.0f;
    protected int step = 0;
    protected FireworkEffect firework;

    public BigBangEffect(EffectManager effectManager) {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 400;
        this.asynchronous = false;
    }

    @Override
    public void onRun() {
        if (this.firework == null) {
            FireworkEffect.Builder b2 = FireworkEffect.builder().with(this.fireworkType);
            b2.withColor(this.color).withColor(this.color2).withColor(this.color3);
            b2.withFade(this.fadeColor);
            b2.trail(true);
            this.firework = b2.build();
        }
        Location location = this.getLocation();
        for (int i2 = 0; i2 < this.explosions; ++i2) {
            Vector v2 = RandomUtils.getRandomVector().multiply(this.radius);
            this.detonate(location, v2);
            if (this.soundInterval == 0 || this.step % this.soundInterval != 0) continue;
            location.getWorld().playSound(location, this.sound, this.soundVolume, this.soundPitch);
        }
        ++this.step;
    }

    protected void detonate(Location location, Vector v2) {
        Firework fw = (Firework)location.getWorld().spawnEntity(location.add(v2), EntityType.FIREWORK);
        location.subtract(v2);
        FireworkMeta meta = fw.getFireworkMeta();
        meta.setPower(0);
        for (int i2 = 0; i2 < this.intensity; ++i2) {
            meta.addEffect(this.firework);
        }
        fw.setFireworkMeta(meta);
        fw.detonate();
    }
}

