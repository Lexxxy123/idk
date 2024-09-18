/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.util.Vector
 */
package de.slikey.effectlib.effect;

import de.slikey.effectlib.EffectManager;
import de.slikey.effectlib.EffectType;
import de.slikey.effectlib.effect.LocationEffect;
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.VectorUtils;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ImageLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public boolean invert = false;
    public int stepX = 10;
    public int stepY = 10;
    public float size = 0.025f;
    protected BufferedImage image = null;

    public ImageLocationEffect(EffectManager effectManager, Location location, File file) throws IOException {
        super(effectManager, location);
        this.image = ImageIO.read(file);
        this.type = EffectType.REPEATING;
        this.period = 10;
        this.iterations = 60;
    }

    @Override
    public void onRun() {
        for (int y2 = 0; y2 < this.image.getHeight(); y2 += this.stepY) {
            for (int x2 = 0; x2 < this.image.getWidth(); x2 += this.stepX) {
                int clr = this.image.getRGB(x2, y2);
                if (!this.invert && Color.black.getRGB() != clr || this.invert && Color.black.getRGB() == clr) continue;
                Vector v2 = new Vector((float)this.image.getWidth() / 2.0f - (float)x2, (float)this.image.getHeight() / 2.0f - (float)y2, 0.0f).multiply(this.size);
                VectorUtils.rotateAroundAxisY(v2, -this.location.getYaw() * ((float)Math.PI / 180));
                this.particle.display(this.location.add(v2), this.visibleRange);
                this.location.subtract(v2);
            }
        }
    }
}

