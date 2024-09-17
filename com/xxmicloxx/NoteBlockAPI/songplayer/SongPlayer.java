/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.entity.Player
 *  org.bukkit.event.Event
 */
package com.xxmicloxx.NoteBlockAPI.songplayer;

import com.xxmicloxx.NoteBlockAPI.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.Layer;
import com.xxmicloxx.NoteBlockAPI.Note;
import com.xxmicloxx.NoteBlockAPI.NoteBlockAPI;
import com.xxmicloxx.NoteBlockAPI.Song;
import com.xxmicloxx.NoteBlockAPI.event.SongDestroyingEvent;
import com.xxmicloxx.NoteBlockAPI.event.SongEndEvent;
import com.xxmicloxx.NoteBlockAPI.event.SongLoopEvent;
import com.xxmicloxx.NoteBlockAPI.event.SongNextEvent;
import com.xxmicloxx.NoteBlockAPI.event.SongStoppedEvent;
import com.xxmicloxx.NoteBlockAPI.model.FadeType;
import com.xxmicloxx.NoteBlockAPI.model.Playlist;
import com.xxmicloxx.NoteBlockAPI.model.RepeatMode;
import com.xxmicloxx.NoteBlockAPI.model.SoundCategory;
import com.xxmicloxx.NoteBlockAPI.model.playmode.ChannelMode;
import com.xxmicloxx.NoteBlockAPI.model.playmode.MonoMode;
import com.xxmicloxx.NoteBlockAPI.songplayer.Fade;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;

public abstract class SongPlayer {
    protected com.xxmicloxx.NoteBlockAPI.model.Song song;
    protected Playlist playlist;
    protected int actualSong = 0;
    protected boolean playing = false;
    protected boolean fading = false;
    protected short tick = (short)-1;
    protected Map<UUID, Boolean> playerList = new ConcurrentHashMap<UUID, Boolean>();
    protected boolean autoDestroy = false;
    protected boolean destroyed = false;
    protected byte volume = (byte)100;
    protected Fade fadeIn;
    protected Fade fadeOut;
    protected Fade fadeTemp = null;
    protected RepeatMode repeat = RepeatMode.NO;
    protected boolean random = false;
    protected Map<com.xxmicloxx.NoteBlockAPI.model.Song, Boolean> songQueue = new ConcurrentHashMap<com.xxmicloxx.NoteBlockAPI.model.Song, Boolean>();
    private final Lock lock = new ReentrantLock();
    private final Random rng = new Random();
    protected NoteBlockAPI plugin;
    protected SoundCategory soundCategory;
    protected ChannelMode channelMode = new MonoMode();
    protected boolean enable10Octave = false;
    com.xxmicloxx.NoteBlockAPI.SongPlayer oldSongPlayer;

    public SongPlayer(com.xxmicloxx.NoteBlockAPI.model.Song song) {
        this(new Playlist(song), SoundCategory.MASTER);
    }

    public SongPlayer(com.xxmicloxx.NoteBlockAPI.model.Song song, SoundCategory soundCategory) {
        this(new Playlist(song), soundCategory);
    }

    public SongPlayer(com.xxmicloxx.NoteBlockAPI.model.Song song, SoundCategory soundCategory, boolean random) {
        this(new Playlist(song), soundCategory, random);
    }

    public SongPlayer(Playlist playlist) {
        this(playlist, SoundCategory.MASTER);
    }

    public SongPlayer(Playlist playlist, SoundCategory soundCategory) {
        this(playlist, soundCategory, false);
    }

    public SongPlayer(Playlist playlist, SoundCategory soundCategory, boolean random) {
        this.playlist = playlist;
        this.random = random;
        this.soundCategory = soundCategory;
        this.plugin = NoteBlockAPI.getAPI();
        this.fadeIn = new Fade(FadeType.NONE, 60);
        this.fadeIn.setFadeStart((byte)0);
        this.fadeIn.setFadeTarget(this.volume);
        this.fadeOut = new Fade(FadeType.NONE, 60);
        this.fadeOut.setFadeStart(this.volume);
        this.fadeOut.setFadeTarget((byte)0);
        if (random) {
            this.checkPlaylistQueue();
            this.actualSong = this.rng.nextInt(playlist.getCount());
        }
        this.song = playlist.get(this.actualSong);
        this.start();
    }

    SongPlayer(com.xxmicloxx.NoteBlockAPI.SongPlayer songPlayer) {
        this.oldSongPlayer = songPlayer;
        Song s2 = songPlayer.getSong();
        HashMap<Integer, com.xxmicloxx.NoteBlockAPI.model.Layer> layerHashMap = new HashMap<Integer, com.xxmicloxx.NoteBlockAPI.model.Layer>();
        for (Integer i2 : s2.getLayerHashMap().keySet()) {
            Layer l2 = s2.getLayerHashMap().get(i2);
            HashMap<Integer, com.xxmicloxx.NoteBlockAPI.model.Note> noteHashMap = new HashMap<Integer, com.xxmicloxx.NoteBlockAPI.model.Note>();
            for (Integer iL : l2.getHashMap().keySet()) {
                Note note = l2.getHashMap().get(iL);
                noteHashMap.put(iL, new com.xxmicloxx.NoteBlockAPI.model.Note(note.getInstrument(), note.getKey()));
            }
            com.xxmicloxx.NoteBlockAPI.model.Layer layer = new com.xxmicloxx.NoteBlockAPI.model.Layer();
            layer.setNotesAtTicks(noteHashMap);
            layer.setVolume(l2.getVolume());
            layerHashMap.put(i2, layer);
        }
        com.xxmicloxx.NoteBlockAPI.model.CustomInstrument[] instruments = new com.xxmicloxx.NoteBlockAPI.model.CustomInstrument[s2.getCustomInstruments().length];
        for (int i3 = 0; i3 < s2.getCustomInstruments().length; ++i3) {
            CustomInstrument ci = s2.getCustomInstruments()[i3];
            instruments[i3] = new com.xxmicloxx.NoteBlockAPI.model.CustomInstrument(ci.getIndex(), ci.getName(), ci.getSoundfile());
        }
        this.song = new com.xxmicloxx.NoteBlockAPI.model.Song(s2.getSpeed(), layerHashMap, s2.getSongHeight(), s2.getLength(), s2.getTitle(), s2.getAuthor(), s2.getDescription(), s2.getPath(), instruments);
        this.playlist = new Playlist(this.song);
        this.fadeIn = new Fade(FadeType.NONE, 60);
        this.fadeIn.setFadeStart((byte)0);
        this.fadeIn.setFadeTarget(this.volume);
        this.fadeOut = new Fade(FadeType.NONE, 60);
        this.fadeOut.setFadeStart(this.volume);
        this.fadeOut.setFadeTarget((byte)0);
        this.plugin = NoteBlockAPI.getAPI();
    }

    void update(String key, Object value) {
        switch (key) {
            case "playing": {
                this.playing = (Boolean)value;
                break;
            }
            case "fadeType": {
                this.fadeIn.setType(FadeType.valueOf(((String)value).replace("FADE_", "")));
                break;
            }
            case "fadeTarget": {
                this.fadeIn.setFadeTarget((Byte)value);
                break;
            }
            case "fadeStart": {
                this.fadeIn.setFadeStart((Byte)value);
                break;
            }
            case "fadeDuration": {
                this.fadeIn.setFadeDuration((Integer)value);
                break;
            }
            case "fadeDone": {
                this.fadeIn.setFadeDone((Integer)value);
                break;
            }
            case "tick": {
                this.tick = (Short)value;
                break;
            }
            case "addplayer": {
                this.addPlayer(((Player)value).getUniqueId(), false);
                break;
            }
            case "removeplayer": {
                this.removePlayer(((Player)value).getUniqueId(), false);
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
            }
        }
    }

    @Deprecated
    public FadeType getFadeType() {
        return this.fadeIn.getType();
    }

    @Deprecated
    public void setFadeType(FadeType fadeType) {
        this.fadeIn.setType(fadeType);
        this.CallUpdate("fadetype", "FADE_" + fadeType.name());
    }

    @Deprecated
    public byte getFadeTarget() {
        return this.fadeIn.getFadeTarget();
    }

    @Deprecated
    public void setFadeTarget(byte fadeTarget) {
        this.fadeIn.setFadeTarget(fadeTarget);
        this.CallUpdate("fadeTarget", fadeTarget);
    }

    @Deprecated
    public byte getFadeStart() {
        return this.fadeIn.getFadeStart();
    }

    @Deprecated
    public void setFadeStart(byte fadeStart) {
        this.fadeIn.setFadeStart(fadeStart);
        this.CallUpdate("fadeStart", fadeStart);
    }

    @Deprecated
    public int getFadeDuration() {
        return this.fadeIn.getFadeDuration();
    }

    @Deprecated
    public void setFadeDuration(int fadeDuration) {
        this.fadeIn.setFadeDuration(fadeDuration);
        this.CallUpdate("fadeDuration", fadeDuration);
    }

    @Deprecated
    public int getFadeDone() {
        return this.fadeIn.getFadeDone();
    }

    @Deprecated
    public void setFadeDone(int fadeDone) {
        this.fadeIn.setFadeDone(fadeDone);
        this.CallUpdate("fadeDone", fadeDone);
    }

    public boolean isEnable10Octave() {
        return this.enable10Octave;
    }

    public void setEnable10Octave(boolean enable10Octave) {
        this.enable10Octave = enable10Octave;
    }

    private void start() {
        this.plugin.doAsync(() -> {
            while (!this.destroyed) {
                float delayMillis;
                long startTime;
                block39: {
                    startTime = System.currentTimeMillis();
                    this.lock.lock();
                    try {
                        block42: {
                            byte fade;
                            block41: {
                                if (this.destroyed) return;
                                if (NoteBlockAPI.getAPI().isDisabling()) {
                                    return;
                                }
                                if (!this.playing && !this.fading) break block39;
                                if (this.fadeTemp == null) break block41;
                                if (this.fadeTemp.isDone()) {
                                    this.fadeTemp = null;
                                    this.fading = false;
                                    if (!this.playing) {
                                        SongStoppedEvent event = new SongStoppedEvent(this);
                                        this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
                                        this.volume = this.fadeIn.getFadeTarget();
                                        continue;
                                    }
                                    break block42;
                                } else {
                                    byte fade2 = this.fadeTemp.calculateFade();
                                    if (fade2 != -1) {
                                        this.volume = fade2;
                                    }
                                }
                                break block42;
                            }
                            if (this.tick < this.fadeIn.getFadeDuration()) {
                                byte fade3 = this.fadeIn.calculateFade();
                                if (fade3 != -1) {
                                    this.volume = fade3;
                                }
                                this.CallUpdate("fadeDone", this.fadeIn.getFadeDone());
                            } else if (this.tick >= this.song.getLength() - this.fadeOut.getFadeDuration() && (fade = this.fadeOut.calculateFade()) != -1) {
                                this.volume = fade;
                            }
                        }
                        this.tick = (short)(this.tick + 1);
                        if (this.tick > this.song.getLength()) {
                            block40: {
                                this.tick = (short)-1;
                                this.fadeIn.setFadeDone(0);
                                this.CallUpdate("fadeDone", this.fadeIn.getFadeDone());
                                this.fadeOut.setFadeDone(0);
                                this.volume = this.fadeIn.getFadeTarget();
                                if (this.repeat == RepeatMode.ONE) {
                                    SongLoopEvent event = new SongLoopEvent(this);
                                    this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
                                    if (!event.isCancelled()) {
                                        continue;
                                    }
                                } else {
                                    if (this.random) {
                                        Event event;
                                        this.songQueue.put(this.song, true);
                                        this.checkPlaylistQueue();
                                        ArrayList<com.xxmicloxx.NoteBlockAPI.model.Song> left = new ArrayList<com.xxmicloxx.NoteBlockAPI.model.Song>();
                                        for (com.xxmicloxx.NoteBlockAPI.model.Song s2 : this.songQueue.keySet()) {
                                            if (this.songQueue.get(s2).booleanValue()) continue;
                                            left.add(s2);
                                        }
                                        if (left.size() == 0) {
                                            left.addAll(this.songQueue.keySet());
                                            for (com.xxmicloxx.NoteBlockAPI.model.Song s2 : this.songQueue.keySet()) {
                                                this.songQueue.put(s2, false);
                                            }
                                            this.song = (com.xxmicloxx.NoteBlockAPI.model.Song)left.get(this.rng.nextInt(left.size()));
                                            this.actualSong = this.playlist.getIndex(this.song);
                                            this.CallUpdate("song", this.song);
                                            if (this.repeat == RepeatMode.ALL) {
                                                event = new SongLoopEvent(this);
                                                this.plugin.doSync(() -> SongPlayer.lambda$null$2((SongLoopEvent)event));
                                                if (!event.isCancelled()) {
                                                    continue;
                                                }
                                            }
                                            break block40;
                                        } else {
                                            this.song = (com.xxmicloxx.NoteBlockAPI.model.Song)left.get(this.rng.nextInt(left.size()));
                                            this.actualSong = this.playlist.getIndex(this.song);
                                            this.CallUpdate("song", this.song);
                                            event = new SongNextEvent(this);
                                            this.plugin.doSync(() -> SongPlayer.lambda$null$3((SongNextEvent)event));
                                            continue;
                                        }
                                    }
                                    if (this.playlist.hasNext(this.actualSong)) {
                                        ++this.actualSong;
                                        this.song = this.playlist.get(this.actualSong);
                                        this.CallUpdate("song", this.song);
                                        SongNextEvent event = new SongNextEvent(this);
                                        this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
                                        continue;
                                    }
                                    this.actualSong = 0;
                                    this.song = this.playlist.get(this.actualSong);
                                    this.CallUpdate("song", this.song);
                                    if (this.repeat == RepeatMode.ALL) {
                                        SongLoopEvent event = new SongLoopEvent(this);
                                        this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
                                        if (!event.isCancelled()) continue;
                                    }
                                }
                            }
                            this.playing = false;
                            SongEndEvent event = new SongEndEvent(this);
                            this.plugin.doSync(() -> Bukkit.getPluginManager().callEvent((Event)event));
                            if (!this.autoDestroy) continue;
                            this.destroy();
                            continue;
                        }
                        this.CallUpdate("tick", this.tick);
                        this.plugin.doSync(() -> {
                            for (UUID uuid : this.playerList.keySet()) {
                                Player player = Bukkit.getPlayer((UUID)uuid);
                                if (player == null) continue;
                                this.playTick(player, this.tick);
                            }
                        });
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    } finally {
                        this.lock.unlock();
                        continue;
                    }
                }
                if (this.destroyed) {
                    return;
                }
                long duration = System.currentTimeMillis() - startTime;
                if (!((float)duration < (delayMillis = this.song.getDelay() * 50.0f))) continue;
                try {
                    Thread.sleep((long)(delayMillis - (float)duration));
                } catch (InterruptedException interruptedException) {}
            }
        });
    }

    private void checkPlaylistQueue() {
        for (com.xxmicloxx.NoteBlockAPI.model.Song s2 : this.songQueue.keySet()) {
            if (this.playlist.contains(s2)) continue;
            this.songQueue.remove(s2);
        }
        for (com.xxmicloxx.NoteBlockAPI.model.Song s2 : this.playlist.getSongList()) {
            if (this.songQueue.containsKey(s2)) continue;
            this.songQueue.put(s2, false);
        }
    }

    public Fade getFadeIn() {
        return this.fadeIn;
    }

    public Fade getFadeOut() {
        return this.fadeOut;
    }

    public Set<UUID> getPlayerUUIDs() {
        HashSet<UUID> uuids = new HashSet<UUID>();
        uuids.addAll(this.playerList.keySet());
        return Collections.unmodifiableSet(uuids);
    }

    public void addPlayer(Player player) {
        this.addPlayer(player.getUniqueId());
    }

    public void addPlayer(UUID player) {
        this.addPlayer(player, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void addPlayer(UUID player, boolean notify) {
        this.lock.lock();
        try {
            if (!this.playerList.containsKey(player)) {
                Player p2;
                this.playerList.put(player, false);
                ArrayList<SongPlayer> songs = NoteBlockAPI.getSongPlayersByPlayer(player);
                if (songs == null) {
                    songs = new ArrayList();
                }
                songs.add(this);
                NoteBlockAPI.setSongPlayersByPlayer(player, songs);
                if (notify && (p2 = Bukkit.getPlayer((UUID)player)) != null) {
                    this.CallUpdate("addplayer", p2);
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
        this.setPlaying(playing, null);
    }

    public void setPlaying(boolean playing, boolean fade) {
        this.setPlaying(playing, fade ? (playing ? this.fadeIn : this.fadeOut) : null);
    }

    public void setPlaying(boolean playing, Fade fade) {
        if (this.playing == playing) {
            return;
        }
        this.playing = playing;
        if (fade != null && fade.getType() != FadeType.NONE) {
            this.fadeTemp = new Fade(fade.getType(), fade.getFadeDuration());
            this.fadeTemp.setFadeStart(playing ? (byte)0 : this.volume);
            this.fadeTemp.setFadeTarget(playing ? this.volume : (byte)0);
            this.fading = true;
        } else {
            this.fading = false;
            this.fadeTemp = null;
            this.volume = this.fadeIn.getFadeTarget();
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
        this.removePlayer(player.getUniqueId());
    }

    public void removePlayer(UUID uuid) {
        this.removePlayer(uuid, true);
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    private void removePlayer(UUID player, boolean notify) {
        this.lock.lock();
        try {
            Player p2;
            if (notify && (p2 = Bukkit.getPlayer((UUID)player)) != null) {
                this.CallUpdate("removeplayer", p2);
            }
            this.playerList.remove(player);
            if (NoteBlockAPI.getSongPlayersByPlayer(player) == null) {
                return;
            }
            ArrayList<SongPlayer> songs = new ArrayList<SongPlayer>(NoteBlockAPI.getSongPlayersByPlayer(player));
            songs.remove(this);
            NoteBlockAPI.setSongPlayersByPlayer(player, songs);
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
        if (volume > 100) {
            volume = (byte)100;
        } else if (volume < 0) {
            volume = 0;
        }
        this.volume = volume;
        this.fadeIn.setFadeTarget(volume);
        this.fadeOut.setFadeStart(volume);
        if (this.fadeTemp != null) {
            if (this.playing) {
                this.fadeTemp.setFadeTarget(volume);
            } else {
                this.fadeTemp.setFadeStart(volume);
            }
        }
        this.CallUpdate("volume", volume);
    }

    public com.xxmicloxx.NoteBlockAPI.model.Song getSong() {
        return this.song;
    }

    public Playlist getPlaylist() {
        return this.playlist;
    }

    public void setPlaylist(Playlist playlist) {
        this.playlist = playlist;
    }

    public int getPlayedSongIndex() {
        return this.actualSong;
    }

    public void playSong(int index) {
        this.lock.lock();
        try {
            if (this.playlist.exist(index)) {
                this.song = this.playlist.get(index);
                this.actualSong = index;
                this.tick = (short)-1;
                this.fadeIn.setFadeDone(0);
                this.fadeOut.setFadeDone(0);
                this.CallUpdate("song", this.song);
                this.CallUpdate("fadeDone", this.fadeIn.getFadeDone());
                this.CallUpdate("tick", this.tick);
            }
        } finally {
            this.lock.unlock();
        }
    }

    public void playNextSong() {
        this.lock.lock();
        try {
            this.tick = this.song.getLength();
        } finally {
            this.lock.unlock();
        }
    }

    public SoundCategory getCategory() {
        return this.soundCategory;
    }

    public void setCategory(SoundCategory soundCategory) {
        this.soundCategory = soundCategory;
        this.CallUpdate("soundCategory", soundCategory.name());
    }

    public void setLoop(boolean loop) {
        this.repeat = RepeatMode.ALL;
    }

    public boolean isLoop() {
        return this.repeat == RepeatMode.ALL;
    }

    public void setRepeatMode(RepeatMode repeatMode) {
        this.repeat = repeatMode;
    }

    public RepeatMode getRepeatMode() {
        return this.repeat;
    }

    public void setRandom(boolean random) {
        this.random = random;
    }

    public boolean isRandom() {
        return this.random;
    }

    public ChannelMode getChannelMode() {
        return this.channelMode;
    }

    void CallUpdate(String key, Object value) {
        if (this.oldSongPlayer == null) {
            return;
        }
        try {
            Method m2 = com.xxmicloxx.NoteBlockAPI.SongPlayer.class.getDeclaredMethod("update", String.class, Object.class);
            m2.setAccessible(true);
            m2.invoke(this.oldSongPlayer, key, value);
        } catch (IllegalAccessException | IllegalArgumentException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    void makeNewClone(Class newClass) {
        try {
            Constructor c2 = newClass.getDeclaredConstructor(SongPlayer.class);
            c2.setAccessible(true);
            this.oldSongPlayer = (com.xxmicloxx.NoteBlockAPI.SongPlayer)c2.newInstance(this);
        } catch (IllegalAccessException | IllegalArgumentException | InstantiationException | NoSuchMethodException | SecurityException | InvocationTargetException e2) {
            e2.printStackTrace();
        }
    }

    private static /* synthetic */ void lambda$null$3(SongNextEvent event) {
        Bukkit.getPluginManager().callEvent((Event)event);
    }

    private static /* synthetic */ void lambda$null$2(SongLoopEvent event) {
        Bukkit.getPluginManager().callEvent((Event)event);
    }
}

