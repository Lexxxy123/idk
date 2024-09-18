/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.model;

public class Note {
    private byte instrument;
    private byte key;
    private byte velocity;
    private int panning;
    private short pitch;

    public Note(byte instrument, byte key) {
        this(instrument, key, 100, 100, 0);
    }

    public Note(byte instrument, byte key, byte velocity, int panning, short pitch) {
        this.instrument = instrument;
        this.key = key;
        this.velocity = velocity;
        this.panning = panning;
        this.pitch = pitch;
    }

    public byte getInstrument() {
        return this.instrument;
    }

    public void setInstrument(byte instrument) {
        this.instrument = instrument;
    }

    public byte getKey() {
        return this.key;
    }

    public void setKey(byte key) {
        this.key = key;
    }

    public short getPitch() {
        return this.pitch;
    }

    public void setPitch(short pitch) {
        this.pitch = pitch;
    }

    public byte getVelocity() {
        return this.velocity;
    }

    public void setVelocity(byte velocity) {
        if (velocity < 0) {
            velocity = 0;
        }
        if (velocity > 100) {
            velocity = (byte)100;
        }
        this.velocity = velocity;
    }

    public int getPanning() {
        return this.panning;
    }

    public void setPanning(int panning) {
        this.panning = panning;
    }
}

