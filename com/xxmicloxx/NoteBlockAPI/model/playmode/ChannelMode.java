/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Location
 *  org.bukkit.entity.Player
 */
package com.xxmicloxx.NoteBlockAPI.model.playmode;

import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.model.Note;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public abstract class ChannelMode {
    @Deprecated
    public abstract void play(Player var1, Location var2, Song var3, Layer var4, Note var5, SoundCategory var6, float var7, float var8);

    public abstract void play(Player var1, Location var2, Song var3, Layer var4, Note var5, SoundCategory var6, float var7, boolean var8);
}

