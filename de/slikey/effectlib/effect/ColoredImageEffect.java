/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Color
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

public class ColoredImageEffect
extends Effect {
    public ParticleEffect particle = ParticleEffect.REDSTONE;
    public String fileName = null;
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
    protected int rotationStep = 0;
    protected int delay = 0;

    public ColoredImageEffect(EffectManager effectManager) throws IOException {
        super(effectManager);
        this.type = EffectType.REPEATING;
        this.period = 2;
        this.iterations = 200;
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
            File file = !this.fileName.startsWith(File.pathSeparator) ? new File(this.effectManager.getOwningPlugin().getDataFolder(), this.fileName) : new File(this.fileName);
            this.loadFile(file);
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
            if (this.delay == 5) {
                ++this.step;
                this.delay = 0;
            }
            ++this.delay;
        }
        Location location = this.getLocation();
        for (int y2 = 0; y2 < this.image.getHeight(); y2 += this.stepY) {
            for (int x2 = 0; x2 < this.image.getWidth(); x2 += this.stepX) {
                Vector v2 = new Vector((float)this.image.getWidth() / 2.0f - (float)x2, (float)this.image.getHeight() / 2.0f - (float)y2, 0.0f).multiply(this.size);
                VectorUtils.rotateAroundAxisY(v2, -location.getYaw() * ((float)Math.PI / 180));
                if (this.enableRotation) {
                    double rotX = 0.0;
                    double rotY = 0.0;
                    double rotZ = 0.0;
                    switch (this.plane) {
                        case X: {
                            rotX = this.angularVelocityX * (double)this.rotationStep;
                            break;
                        }
                        case Y: {
                            rotY = this.angularVelocityY * (double)this.rotationStep;
                            break;
                        }
                        case Z: {
                            rotZ = this.angularVelocityZ * (double)this.rotationStep;
                            break;
                        }
                        case XY: {
                            rotX = this.angularVelocityX * (double)this.rotationStep;
                            rotY = this.angularVelocityY * (double)this.rotationStep;
                            break;
                        }
                        case XZ: {
                            rotX = this.angularVelocityX * (double)this.rotationStep;
                            rotZ = this.angularVelocityZ * (double)this.rotationStep;
                            break;
                        }
                        case XYZ: {
                            rotX = this.angularVelocityX * (double)this.rotationStep;
                            rotY = this.angularVelocityY * (double)this.rotationStep;
                            rotZ = this.angularVelocityZ * (double)this.rotationStep;
                            break;
                        }
                        case YZ: {
                            rotY = this.angularVelocityY * (double)this.rotationStep;
                            rotZ = this.angularVelocityZ * (double)this.step;
                        }
                    }
                    VectorUtils.rotateVector(v2, rotX, rotY, rotZ);
                }
                int r2 = new Color(this.image.getRGB(x2, y2)).getRed();
                int g2 = new Color(this.image.getRGB(x2, y2)).getGreen();
                int b2 = new Color(this.image.getRGB(x2, y2)).getBlue();
                this.display(this.particle, location.add(v2), org.bukkit.Color.fromRGB((int)r2, (int)g2, (int)b2));
                location.subtract(v2);
            }
        }
        ++this.rotationStep;
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

