/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.songplayer;

import com.xxmicloxx.NoteBlockAPI.model.FadeType;
import com.xxmicloxx.NoteBlockAPI.utils.Interpolator;

public class Fade {
    private FadeType type;
    private byte fadeStart;
    private byte fadeTarget;
    private int fadeDuration;
    private int fadeDone = 0;

    public Fade(FadeType type, int fadeDuration) {
        this.type = type;
        this.fadeDuration = fadeDuration;
    }

    protected byte calculateFade() {
        switch (this.type) {
            case LINEAR: {
                if (this.fadeDone == this.fadeDuration) {
                    return -1;
                }
                double targetVolume = Interpolator.interpLinear(new double[]{0.0, this.fadeStart, this.fadeDuration, this.fadeTarget}, this.fadeDone);
                ++this.fadeDone;
                return (byte)targetVolume;
            }
        }
        ++this.fadeDone;
        return -1;
    }

    protected int getFadeDone() {
        return this.fadeDone;
    }

    protected void setFadeStart(byte fadeStart) {
        this.fadeStart = fadeStart;
    }

    protected void setFadeTarget(byte fadeTarget) {
        this.fadeTarget = fadeTarget;
    }

    public FadeType getType() {
        return this.type;
    }

    public void setType(FadeType type) {
        this.type = type;
    }

    public int getFadeDuration() {
        return this.fadeDuration;
    }

    public void setFadeDuration(int fadeDuration) {
        this.fadeDuration = fadeDuration;
    }

    protected byte getFadeStart() {
        return this.fadeStart;
    }

    protected byte getFadeTarget() {
        return this.fadeTarget;
    }

    protected void setFadeDone(int fadeDone) {
        this.fadeDone = fadeDone;
    }

    public boolean isDone() {
        return this.fadeDone >= this.fadeDuration;
    }
}

