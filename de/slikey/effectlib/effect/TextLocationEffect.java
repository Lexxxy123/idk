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
import de.slikey.effectlib.util.StringParser;
import de.slikey.effectlib.util.VectorUtils;
import java.awt.Color;
import java.awt.Font;
import java.awt.image.BufferedImage;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class TextLocationEffect
extends LocationEffect {
    public ParticleEffect particle = ParticleEffect.FIREWORKS_SPARK;
    public String text = "Text";
    public boolean invert = false;
    public int stepX = 1;
    public int stepY = 1;
    public float size = 0.2f;
    public boolean realtime = false;
    public Font font;
    protected BufferedImage image = null;

    public TextLocationEffect(EffectManager effectManager, Location location) {
        this(effectManager, location, new Font("Tahoma", 0, 16));
    }

    public TextLocationEffect(EffectManager effectManager, Location location, Font font) {
        super(effectManager, location);
        this.font = font;
        this.type = EffectType.REPEATING;
        this.period = 40;
        this.iterations = 20;
    }

    @Override
    public void onRun() {
        int clr = 0;
        try {
            if (this.image == null || this.realtime) {
                this.image = StringParser.stringToBufferedImage(this.font, this.text);
            }
            for (int y2 = 0; y2 < this.image.getHeight(); y2 += this.stepY) {
                for (int x2 = 0; x2 < this.image.getWidth(); x2 += this.stepX) {
                    clr = this.image.getRGB(x2, y2);
                    if (!this.invert && Color.black.getRGB() != clr || this.invert && Color.black.getRGB() == clr) continue;
                    Vector v2 = new Vector((float)this.image.getWidth() / 2.0f - (float)x2, (float)this.image.getHeight() / 2.0f - (float)y2, 0.0f).multiply(this.size);
                    VectorUtils.rotateAroundAxisY(v2, -this.location.getYaw() * ((float)Math.PI / 180));
                    this.particle.display(this.location.add(v2), this.visibleRange);
                    this.location.subtract(v2);
                }
            }
        } catch (Exception ex) {
            this.cancel(true);
        }
    }
}

