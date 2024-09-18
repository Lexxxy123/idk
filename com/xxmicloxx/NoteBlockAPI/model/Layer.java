/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.model;

import com.xxmicloxx.NoteBlockAPI.model.Note;
import java.util.HashMap;

public class Layer {
    private HashMap<Integer, Note> notesAtTicks = new HashMap();
    private byte volume = (byte)100;
    private int panning = 100;
    private String name = "";

    public HashMap<Integer, Note> getNotesAtTicks() {
        return this.notesAtTicks;
    }

    public void setNotesAtTicks(HashMap<Integer, Note> notesAtTicks) {
        this.notesAtTicks = notesAtTicks;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Note getNote(int tick) {
        return this.notesAtTicks.get(tick);
    }

    public void setNote(int tick, Note note) {
        this.notesAtTicks.put(tick, note);
    }

    public byte getVolume() {
        return this.volume;
    }

    public void setVolume(byte volume) {
        this.volume = volume;
    }

    public int getPanning() {
        return this.panning;
    }

    public void setPanning(int panning) {
        this.panning = panning;
    }
}

