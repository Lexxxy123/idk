/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.Note;
import java.util.HashMap;

@Deprecated
public class Layer {
    private HashMap<Integer, Note> notesAtTicks = new HashMap();
    private byte volume = (byte)100;
    private String name = "";

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

    @Deprecated
    public HashMap<Integer, Note> getHashMap() {
        return this.notesAtTicks;
    }

    @Deprecated
    public void setHashMap(HashMap<Integer, Note> hashMap) {
        this.notesAtTicks = hashMap;
    }
}

