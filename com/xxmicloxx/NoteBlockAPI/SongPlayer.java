/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Event
 */
package com.xxmicloxx.NoteBlockAPI;

import com.xxmicloxx.NoteBlockAPI.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.FadeType;
import com.xxmicloxx.NoteBlockAPI.Interpolator;
import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.NoteBlockPlayerMain;
import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.SongDestroyingEvent;
import com.xxmicloxx.NoteBlockAPI.SongEndEvent;
import com.xxmicloxx.NoteBlockAPI.SongStoppedEvent;
import com.xxmicloxx.NoteBlockAPI.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.model.Note;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

@Deprecated
public abstract class SongPlayer {
    protected Song song;
    protected boolean playing = false;
    protected short tick = (short)-1;
    protected Map<String, Boolean> playerList = Collections.synchronizedMap(new HashMap());
    protected boolean autoDestroy = false;
    protected boolean destroyed = false;
    protected Thread playerThread;
    protected byte volume;
    protected byte fadeStart = this.volume = (byte)100;
    protected byte fadeTarget = (byte)100;
    protected int fadeDuration = 60;
    protected int fadeDone = 0;
    protected FadeType fadeType = FadeType.FADE_LINEAR;
    private final Lock lock = new ReentrantLock();
    protected NoteBlockPlayerMain plugin;
    protected SoundCategory soundCategory;
    private com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer newSongPlayer;

    public SongPlayer(Song song) {
        this(song, SoundCategory.MASTER);
    }

    public SongPlayer(Song song, SoundCategory soundCategory) {
        NoteBlockAPI.getAPI().handleDeprecated(Thread.currentThread().getStackTrace());
        this.song = song;
        this.soundCategory = soundCategory;
        this.plugin = NoteBlockPlayerMain.plugin;
        this.start();
    }

    SongPlayer(com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer songPlayer) {
        this.newSongPlayer = songPlayer;
        this.song = this.createSongFromNew(songPlayer.getSong());
        this.plugin = NoteBlockPlayerMain.plugin;
    }

    private Song createSongFromNew(com.xxmicloxx.NoteBlockAPI.model.Song s2) {
        HashMap<Integer, com.xxmicloxx.NoteBlockAPI.Layer> layerHashMap = new HashMap<Integer, com.xxmicloxx.NoteBlockAPI.Layer>();
        for (Integer i2 : s2.getLayerHashMap().keySet()) {
            Layer l2 = s2.getLayerHashMap().get(i2);
            HashMap<Integer, com.xxmicloxx.NoteBlockAPI.Note> noteHashMap = new HashMap<Integer, com.xxmicloxx.NoteBlockAPI.Note>();
            for (Integer iL : l2.getNotesAtTicks().keySet()) {
                Note note = l2.getNotesAtTicks().get(iL);
                noteHashMap.put(iL, new com.xxmicloxx.NoteBlockAPI.Note(note.getInstrument(), note.getKey()));
            }
            com.xxmicloxx.NoteBlockAPI.Layer layer = new com.xxmicloxx.NoteBlockAPI.Layer();
            layer.setHashMap(noteHashMap);
            layer.setVolume(l2.getVolume());
            layerHashMap.put(i2, layer);
        }
        CustomInstrument[] instruments = new CustomInstrument[s2.getCustomInstruments().length];
        for (int i3 = 0; i3 < s2.getCustomInstruments().length; ++i3) {
            com.xxmicloxx.NoteBlockAPI.model.CustomInstrument ci = s2.getCustomInstruments()[i3];
            instruments[i3] = new CustomInstrument(ci.getIndex(), ci.getName(), ci.getSoundFileName());
        }
        return new Song(s2.getSpeed(), layerHashMap, s2.getSongHeight(), s2.getLength(), s2.getTitle(), s2.getAuthor(), s2.getDescription(), s2.getPath(), instruments);
    }

    void update(String key, Object value) {
        switch (key) {
            case "playing": {
                this.playing = (Boolean)value;
                break;
            }
            case "fadeType": {
                this.fadeType = FadeType.valueOf((String)value);
                break;
            }
            case "fadeTarget": {
                this.fadeTarget = (Byte)value;
                break;
            }
            case "fadeStart": {
                this.fadeStart = (Byte)value;
                break;
            }
            case "fadeDuration": {
                this.fadeDuration = (Integer)value;
                break;
            }
            case "fadeDone": {
                this.fadeDone = (Integer)value;
                break;
            }
            case "tick": {
                this.tick = (Short)value;
                break;
            }
            case "addplayer": {
                this.addPlayer((Player)value, false);
                break;
            }
            case "removeplayer": {
                this.removePlayer((Player)value, false);
                break;
            }
            case "autoDestroy": {
                this.autoDestroy = (Boolean)value;
                break;
            }
            case "volume": {
                this.volume = (Byte)value;
                break;
            }
            case "soundCategory": {
                this.soundCategory = SoundCategory.valueOf((String)value);
                break;
            }
            case "song": {
                this.song = this.createSongFromNew((com.xxmicloxx.NoteBlockAPI.model.Song)value);
            }
        }
    }

    public FadeType getFadeType() {
        return this.fadeType;
    }

    public void setFadeType(FadeType fadeType) {
        this.fadeType = fadeType;
        this.CallUpdate("fadetype", fadeType.name());
    }

    public byte getFadeTarget() {
        return this.fadeTarget;
    }

    public void setFadeTarget(byte fadeTarget) {
        this.fadeTarget = fadeTarget;
        this.CallUpdate("fadeTarget", fadeTarget);
    }

    public byte getFadeStart() {
        return this.fadeStart;
    }

    public void setFadeStart(byte fadeStart) {
        this.fadeStart = fadeStart;
        this.CallUpdate("fadeStart", fadeStart);
    }

    public int getFadeDuration() {
        return this.fadeDuration;
    }

    public void setFadeDuration(int fadeDuration) {
        this.fadeDuration = fadeDuration;
        this.CallUpdate("fadeDuration", fadeDuration);
    }

    public int getFadeDone() {
        return this.fadeDone;
    }

    public void setFadeDone(int fadeDone) {
        this.fadeDone = fadeDone;
        this.CallUpdate("fadeDone", fadeDone);
    }

    protected void calculateFade() {
        if (this.fadeDone == this.fadeDuration) {
            return;
        }
        double targetVolume = Interpolator.interpLinear(new double[]{0.0, this.fadeStart, this.fadeDuration, this.fadeTarget}, this.fadeDone);
        this.setVolume((byte)targetVolume);
        ++this.fadeDone;
        this.CallUpdate("fadeDone", this.fadeDone);
    }

    private void start() {
        this.plugin.doAsync(() -> {
            while (!this.destroyed) {
                float delayMillis;
                long startTime;
                block11: {
                    startTime = System.currentTimeMillis();
                    this.lock.lock();
                    try {
                        if (this.destroyed || NoteBlockAPI.getAPI().isDisabling()) break;
                        if (!this.playing) break block11;
                        this.calculateFade();
                        this.tick = (short)(this.tick + 1);
                        if (this.tick > this.song.getLength()) {
                            this.playing = false;
                            this.tick = (short)-1;
                            SongEndEvent event = new SongEndEvent(this);
                            this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
                            if (!this.autoDestroy) continue;
                            this.destroy();
                            continue;
                        }
                        this.CallUpdate("tick", this.tick);
                        this.plugin.doSync(() -> {
                            for (String s2 : this.playerList.keySet()) {
                                Player p2 = Bukkit.getPlayerExact((String)s2);
                                if (p2 == null) continue;
                                this.playTick(p2, this.tick);
                            }
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    } finally {
                        this.lock.unlock();
                        continue;
                    }
                }
                if (this.destroyed) break;
                long duration = System.currentTimeMillis() - startTime;
                if (!((float)duration < (delayMillis = this.song.getDelay() * 50.0f))) continue;
                try {
                    Thread.sleep((long)(delayMillis - (float)duration));
                } catch (InterruptedException interruptedException) {}
            }
        });
    }

    @Deprecated
    public List<String> getPlayerList() {
        ArrayList<String> list = new ArrayList<String>();
        for (String s2 : this.playerList.keySet()) {
            list.add(Bukkit.getPlayer((String)s2).getName());
        }
        return Collections.unmodifiableList(list);
    }

    public void addPlayer(Player player) {
        this.addPlayer(player, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addPlayer(Player player, boolean notify) {
        this.lock.lock();
        try {
            if (!this.playerList.containsKey(player.getName())) {
                this.playerList.put(player.getName(), false);
                ArrayList<SongPlayer> songs = NoteBlockPlayerMain.plugin.playingSongs.get(player.getName());
                if (songs == null) {
                    songs = new ArrayList();
                }
                songs.add(this);
                NoteBlockPlayerMain.plugin.playingSongs.put(player.getName(), songs);
                if (notify) {
                    this.CallUpdate("addplayer", player);
                }
            }
        } finally {
            this.lock.unlock();
        }
    }

    public boolean getAutoDestroy() {
        this.lock.lock();
        try {
            boolean bl2 = this.autoDestroy;
            return bl2;
        } finally {
            this.lock.unlock();
        }
    }

    public void setAutoDestroy(boolean autoDestroy) {
        this.lock.lock();
        try {
            this.autoDestroy = autoDestroy;
            this.CallUpdate("autoDestroy", autoDestroy);
        } finally {
            this.lock.unlock();
        }
    }

    public abstract void playTick(Player var1, int var2);

    public void destroy() {
        this.lock.lock();
        try {
            SongDestroyingEvent event = new SongDestroyingEvent(this);
            this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
            if (event.isCancelled()) {
                return;
            }
            this.destroyed = true;
            this.playing = false;
            this.setTick((short)-1);
            this.CallUpdate("destroyed", this.destroyed);
            this.CallUpdate("playing", this.playing);
        } finally {
            this.lock.unlock();
        }
    }

    public boolean isPlaying() {
        return this.playing;
    }

    public void setPlaying(boolean playing) {
        this.playing = playing;
        if (!playing) {
            SongStoppedEvent event = new SongStoppedEvent(this);
            this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
        }
        this.CallUpdate("playing", playing);
    }

    public short getTick() {
        return this.tick;
    }

    public void setTick(short tick) {
        this.tick = tick;
        this.CallUpdate("tick", tick);
    }

    public void removePlayer(Player player) {
        this.removePlayer(player, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removePlayer(Player player, boolean notify) {
        this.lock.lock();
        try {
            if (notify) {
                this.CallUpdate("removeplayer", player);
            }
            this.playerList.remove(player.getName());
            if (NoteBlockPlayerMain.plugin.playingSongs.get(player.getName()) == null) {
                return;
            }
            ArrayList songs = new ArrayList(NoteBlockPlayerMain.plugin.playingSongs.get(player.getName()));
            songs.remove(this);
            NoteBlockPlayerMain.plugin.playingSongs.put(player.getName(), songs);
            if (this.playerList.isEmpty() && this.autoDestroy) {
                SongEndEvent event = new SongEndEvent(this);
                this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
                this.destroy();
            }
        } finally {
            this.lock.unlock();
        }
    }

    public byte getVolume() {
        return this.volume;
    }

    public void setVolume(byte volume) {
        this.volume = volume;
        this.CallUpdate("volume", volume);
    }

    public Song getSong() {
        return this.song;
    }

    public SoundCategory getCategory() {
        return this.soundCategory;
    }

    public void setCategory(SoundCategory soundCategory) {
        this.soundCategory = soundCategory;
        this.CallUpdate("soundCategory", soundCategory.name());
    }

    void CallUpdate(String key, Object value) {
        try {
            Method m2 = com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer.class.getDeclaredMethod("update", String.class, Object.class);
            m2.setAccessible(true);
            m2.invoke(this.newSongPlayer, key, value);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    void makeNewClone(Class newClass) {
        try {
            Constructor c2 = newClass.getDeclaredConstructor(SongPlayer.class);
            c2.setAccessible(true);
            this.newSongPlayer = (com.xxmicloxx.NoteBlockAPI.songplayer.SongPlayer)c2.newInstance(this);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }
}

