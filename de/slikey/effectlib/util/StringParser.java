/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.effectlib.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;

public final class StringParser {
    private StringParser() {
    }

    public static BufferedImage stringToBufferedImage(Font font, String s2) {
        BufferedImage img = new BufferedImage(1, 1, 6);
        Graphics g2 = img.getGraphics();
        g2.setFont(font);
        FontRenderContext frc = g2.getFontMetrics().getFontRenderContext();
        Rectangle2D rect = font.getStringBounds(s2, frc);
        g2.dispose();
        img = new BufferedImage((int)Math.ceil(rect.getWidth()), (int)Math.ceil(rect.getHeight()), 6);
        g2 = img.getGraphics();
        g2.setColor(Color.black);
        g2.setFont(font);
        FontMetrics fm = g2.getFontMetrics();
        int x2 = 0;
        int y2 = fm.getAscent();
        g2.drawString(s2, x2, y2);
        g2.dispose();
        return img;
    }
}

