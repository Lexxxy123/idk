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
import de.slikey.effectlib.util.ParticleEffect;
import de.slikey.effectlib.util.VectorUtils;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import org.bukkit.Location;
import org.bukkit.util.Vector;

public class ImageEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.FLAME;
    public String fileName = null;
    public boolean invert = false;
    public int stepX = 10;
    public int stepY = 10;
    public float size = 0.025f;
    public boolean enableRotation = true;
    public Plane plane = Plane.XYZ;
    public double angularVelocityX = 0.015707963267948967;
    public double angularVelocityY = 0.018479956785822312;
    public double angularVelocityZ = 0.02026833970057931;
    protected BufferedImage image = null;
    protected boolean isGif = false;
    protected File gifFile = null;
    protected int step = 0;

    public ImageEffect(EffectManager effectManager) throws IOException {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 10;
        this.iterations = 60;
    }

    public void loadFile(File file) {
        try {
            this.image = ImageIO.read(file);
            this.isGif = file.getName().endsWith(".gif");
            this.gifFile = file;
        } catch (Exception ex) {
            ex.printStackTrace();
            this.image = null;
        }
    }

    @Override
    public void onRun() {
        if (this.image == null && this.fileName != null) {
            this.loadFile(new File(this.fileName));
        }
        if (this.image == null) {
            this.cancel();
            return;
        }
        if (this.isGif) {
            try {
                this.image = this.getImg(this.step);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            ++this.step;
        }
        Location location = this.getLocation();
        for (int y2 = 0; y2 < this.image.getHeight(); y2 += this.stepY) {
            for (int x2 = 0; x2 < this.image.getWidth(); x2 += this.stepX) {
                int clr = this.image.getRGB(x2, y2);
                if (!this.invert && Color.black.getRGB() != clr || this.invert && Color.black.getRGB() == clr) continue;
                Vector v2 = new Vector((float)this.image.getWidth() / 2.0f - (float)x2, (float)this.image.getHeight() / 2.0f - (float)y2, 0.0f).multiply(this.size);
                VectorUtils.rotateAroundAxisY(v2, -location.getYaw() * ((float)Math.PI / 180));
                this.display(this.particle, location.add(v2));
                location.subtract(v2);
            }
        }
    }

    private BufferedImage getImg(int s2) throws IOException {
        ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
        ImageReader reader = ImageIO.getImageReadersBySuffix("GIF").next();
        ImageInputStream in = ImageIO.createImageInputStream(this.gifFile);
        reader.setInput(in);
        int count = reader.getNumImages(true);
        for (int i2 = 0; i2 < count; ++i2) {
            BufferedImage image = reader.read(i2);
            images.add(image);
        }
        if (this.step >= reader.getNumImages(true)) {
            this.step = 0;
            return (BufferedImage)images.get(s2 - 1);
        }
        return (BufferedImage)images.get(s2);
    }

    public static enum Plane {
        X,
        Y,
        Z,
        XY,
        XZ,
        XYZ,
        YZ;

    }
}

