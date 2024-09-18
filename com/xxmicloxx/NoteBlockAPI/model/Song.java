/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.model;

import com.xxmicloxx.NoteBlockAPI.model.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.utils.InstrumentUtils;
import java.io.File;
import java.util.HashMap;

public class Song
implements Cloneable {
    private HashMap<Integer, Layer> layerHashMap = new HashMap();
    private short songHeight;
    private short length;
    private String title;
    private File path;
    private String author;
    private String originalAuthor;
    private String description;
    private float speed;
    private float delay;
    private CustomInstrument[] customInstruments;
    private int firstCustomInstrumentIndex;
    private boolean isStereo = false;

    public Song(Song other) {
        this(other.getSpeed(), other.getLayerHashMap(), other.getSongHeight(), other.getLength(), other.getTitle(), other.getAuthor(), other.getOriginalAuthor(), other.getDescription(), other.getPath(), other.getFirstCustomInstrumentIndex(), other.getCustomInstruments(), other.isStereo);
    }

    @Deprecated
    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String description, File path) {
        this(speed, layerHashMap, songHeight, length, title, author, description, path, InstrumentUtils.getCustomInstrumentFirstIndex(), new CustomInstrument[0], false);
    }

    @Deprecated
    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String description, File path, CustomInstrument[] customInstruments) {
        this(speed, layerHashMap, songHeight, length, title, author, description, path, InstrumentUtils.getCustomInstrumentFirstIndex(), customInstruments, false);
    }

    @Deprecated
    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String description, File path, int firstCustomInstrumentIndex) {
        this(speed, layerHashMap, songHeight, length, title, author, description, path, firstCustomInstrumentIndex, new CustomInstrument[0], false);
    }

    @Deprecated
    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String description, File path, int firstCustomInstrumentIndex, CustomInstrument[] customInstruments) {
        this(speed, layerHashMap, songHeight, length, title, author, description, path, firstCustomInstrumentIndex, customInstruments, false);
    }

    @Deprecated
    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String description, File path, int firstCustomInstrumentIndex, boolean isStereo) {
        this(speed, layerHashMap, songHeight, length, title, author, "", description, path, firstCustomInstrumentIndex, new CustomInstrument[0], isStereo);
    }

    @Deprecated
    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String description, File path, int firstCustomInstrumentIndex, CustomInstrument[] customInstruments, boolean isStereo) {
        this(speed, layerHashMap, songHeight, length, title, author, "", description, path, firstCustomInstrumentIndex, customInstruments, isStereo);
    }

    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String originalAuthor, String description, File path, int firstCustomInstrumentIndex, boolean isStereo) {
        this(speed, layerHashMap, songHeight, length, title, author, originalAuthor, description, path, firstCustomInstrumentIndex, new CustomInstrument[0], isStereo);
    }

    public Song(float speed, HashMap<Integer, Layer> layerHashMap, short songHeight, short length, String title, String author, String originalAuthor, String description, File path, int firstCustomInstrumentIndex, CustomInstrument[] customInstruments, boolean isStereo) {
        this.speed = speed;
        this.delay = 20.0f / speed;
        this.layerHashMap = layerHashMap;
        this.songHeight = songHeight;
        this.length = length;
        this.title = title;
        this.author = author;
        this.originalAuthor = originalAuthor;
        this.description = description;
        this.path = path;
        this.firstCustomInstrumentIndex = firstCustomInstrumentIndex;
        this.customInstruments = customInstruments;
        this.isStereo = isStereo;
    }

    public HashMap<Integer, Layer> getLayerHashMap() {
        return this.layerHashMap;
    }

    public short getSongHeight() {
        return this.songHeight;
    }

    public short getLength() {
        return this.length;
    }

    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getOriginalAuthor() {
        return this.originalAuthor;
    }

    public File getPath() {
        return this.path;
    }

    public String getDescription() {
        return this.description;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getDelay() {
        return this.delay;
    }

    public CustomInstrument[] getCustomInstruments() {
        return this.customInstruments;
    }

    public Song clone() {
        return new Song(this);
    }

    public int getFirstCustomInstrumentIndex() {
        return this.firstCustomInstrumentIndex;
    }

    public boolean isStereo() {
        return this.isStereo;
    }
}

