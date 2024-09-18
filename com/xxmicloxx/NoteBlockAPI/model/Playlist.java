/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.model;

import com.xxmicloxx.NoteBlockAPI.model.Song;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Playlist {
    ArrayList<Song> songs = new ArrayList();

    public Playlist(Song ... songs) {
        if (songs.length == 0) {
            throw new IllegalArgumentException("Cannot create empty playlist");
        }
        this.checkNull(songs);
        this.songs.addAll(Arrays.asList(songs));
    }

    public void add(Song ... songs) {
        if (songs.length == 0) {
            return;
        }
        this.checkNull(songs);
        this.songs.addAll(Arrays.asList(songs));
    }

    public void insert(int index, Song ... songs) {
        if (songs.length == 0) {
            return;
        }
        if (index > this.songs.size()) {
            throw new IllegalArgumentException("Index is higher than playlist size");
        }
        this.checkNull(songs);
        this.songs.addAll(index, Arrays.asList(songs));
    }

    private void checkNull(Song ... songs) {
        List<Song> songList = Arrays.asList(songs);
        if (songList.contains(null)) {
            throw new IllegalArgumentException("Cannot add null to playlist");
        }
    }

    public void remove(Song ... songs) {
        ArrayList<Song> songsTemp = new ArrayList<Song>();
        songsTemp.addAll(this.songs);
        songsTemp.removeAll(Arrays.asList(songs));
        if (songsTemp.size() <= 0) {
            throw new IllegalArgumentException("Cannot remove all songs from playlist");
        }
        this.songs = songsTemp;
    }

    public Song get(int songNumber) {
        return this.songs.get(songNumber);
    }

    public int getCount() {
        return this.songs.size();
    }

    public boolean hasNext(int songNumber) {
        return this.songs.size() > songNumber + 1;
    }

    public boolean exist(int songNumber) {
        return this.songs.size() > songNumber;
    }

    public int getIndex(Song song) {
        return this.songs.indexOf(song);
    }

    public boolean contains(Song song) {
        return this.songs.contains(song);
    }

    public ArrayList<Song> getSongList() {
        return (ArrayList)this.songs.clone();
    }
}

