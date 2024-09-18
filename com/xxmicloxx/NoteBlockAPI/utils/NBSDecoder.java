/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 *  org.bukkit.ChatColor
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import com.xxmicloxx.NoteBlockAPI.model.CustomInstrument;
import com.xxmicloxx.NoteBlockAPI.model.Layer;
import com.xxmicloxx.NoteBlockAPI.model.Note;
import com.xxmicloxx.NoteBlockAPI.model.Song;
import com.xxmicloxx.NoteBlockAPI.utils.CompatibilityUtils;
import com.xxmicloxx.NoteBlockAPI.utils.InstrumentUtils;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;

public class NBSDecoder {
    public static Song parse(File songFile) {
        try {
            return NBSDecoder.parse(new FileInputStream(songFile), songFile);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static Song parse(InputStream inputStream) {
        return NBSDecoder.parse(inputStream, null);
    }

    private static Song parse(InputStream inputStream, File songFile) {
        HashMap<Integer, Layer> layerHashMap = new HashMap<Integer, Layer>();
        int biggestInstrumentIndex = -1;
        boolean isStereo = false;
        try {
            short jumpTicks;
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            short length = NBSDecoder.readShort(dataInputStream);
            byte firstcustominstrument = 10;
            byte nbsversion = 0;
            if (length == 0) {
                nbsversion = dataInputStream.readByte();
                firstcustominstrument = dataInputStream.readByte();
                if (nbsversion >= 3) {
                    length = NBSDecoder.readShort(dataInputStream);
                }
            }
            int firstcustominstrumentdiff = InstrumentUtils.getCustomInstrumentFirstIndex() - firstcustominstrument;
            short s2 = NBSDecoder.readShort(dataInputStream);
            String title = NBSDecoder.readString(dataInputStream);
            String author = NBSDecoder.readString(dataInputStream);
            String originalAuthor = NBSDecoder.readString(dataInputStream);
            String description = NBSDecoder.readString(dataInputStream);
            float speed = (float)NBSDecoder.readShort(dataInputStream) / 100.0f;
            dataInputStream.readBoolean();
            dataInputStream.readByte();
            dataInputStream.readByte();
            NBSDecoder.readInt(dataInputStream);
            NBSDecoder.readInt(dataInputStream);
            NBSDecoder.readInt(dataInputStream);
            NBSDecoder.readInt(dataInputStream);
            NBSDecoder.readInt(dataInputStream);
            NBSDecoder.readString(dataInputStream);
            if (nbsversion >= 4) {
                dataInputStream.readByte();
                dataInputStream.readByte();
                NBSDecoder.readShort(dataInputStream);
            }
            short tick = -1;
            while ((jumpTicks = NBSDecoder.readShort(dataInputStream)) != 0) {
                short jumpLayers;
                tick = (short)(tick + jumpTicks);
                int layer = -1;
                while ((jumpLayers = NBSDecoder.readShort(dataInputStream)) != 0) {
                    layer = (short)(layer + jumpLayers);
                    byte instrument = dataInputStream.readByte();
                    if (firstcustominstrumentdiff > 0 && instrument >= firstcustominstrument) {
                        instrument = (byte)(instrument + firstcustominstrumentdiff);
                    }
                    byte key = dataInputStream.readByte();
                    byte velocity = 100;
                    int panning = 100;
                    short pitch = 0;
                    if (nbsversion >= 4) {
                        velocity = dataInputStream.readByte();
                        panning = 200 - dataInputStream.readUnsignedByte();
                        pitch = NBSDecoder.readShort(dataInputStream);
                    }
                    if (panning != 100) {
                        isStereo = true;
                    }
                    NBSDecoder.setNote(layer, tick, new Note(instrument, key, velocity, panning, pitch), layerHashMap);
                }
            }
            if (nbsversion > 0 && nbsversion < 3) {
                length = tick;
            }
            for (int i2 = 0; i2 < s2; ++i2) {
                Layer layer = (Layer)layerHashMap.get(i2);
                String name = NBSDecoder.readString(dataInputStream);
                if (nbsversion >= 4) {
                    dataInputStream.readByte();
                }
                byte volume = dataInputStream.readByte();
                int panning = 100;
                if (nbsversion >= 2) {
                    panning = 200 - dataInputStream.readUnsignedByte();
                }
                if (panning != 100) {
                    isStereo = true;
                }
                if (layer == null) continue;
                layer.setName(name);
                layer.setVolume(volume);
                layer.setPanning(panning);
            }
            int customAmnt = dataInputStream.readByte();
            CustomInstrument[] customInstrumentsArray = new CustomInstrument[customAmnt];
            for (int index = 0; index < customAmnt; ++index) {
                customInstrumentsArray[index] = new CustomInstrument((byte)index, NBSDecoder.readString(dataInputStream), NBSDecoder.readString(dataInputStream));
                dataInputStream.readByte();
                dataInputStream.readByte();
            }
            if (firstcustominstrumentdiff < 0) {
                ArrayList<CustomInstrument> customInstruments = CompatibilityUtils.getVersionCustomInstrumentsForSong(firstcustominstrument);
                customInstruments.addAll(Arrays.asList(customInstrumentsArray));
                customInstrumentsArray = customInstruments.toArray(customInstrumentsArray);
            } else {
                firstcustominstrument += firstcustominstrumentdiff;
            }
            return new Song(speed, layerHashMap, s2, length, title, author, originalAuthor, description, songFile, firstcustominstrument, customInstrumentsArray, isStereo);
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (EOFException e3) {
            String file = "";
            if (songFile != null) {
                file = songFile.getName();
            }
            Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.RED + "Song is corrupted: " + file);
        } catch (IOException e4) {
            e4.printStackTrace();
        }
        return null;
    }

    private static void setNote(int layerIndex, int ticks, Note note, HashMap<Integer, Layer> layerHashMap) {
        Layer layer = layerHashMap.get(layerIndex);
        if (layer == null) {
            layer = new Layer();
            layerHashMap.put(layerIndex, layer);
        }
        layer.setNote(ticks, note);
    }

    private static short readShort(DataInputStream dataInputStream) throws IOException {
        int byte1 = dataInputStream.readUnsignedByte();
        int byte2 = dataInputStream.readUnsignedByte();
        return (short)(byte1 + (byte2 << 8));
    }

    private static int readInt(DataInputStream dataInputStream) throws IOException {
        int byte1 = dataInputStream.readUnsignedByte();
        int byte2 = dataInputStream.readUnsignedByte();
        int byte3 = dataInputStream.readUnsignedByte();
        int byte4 = dataInputStream.readUnsignedByte();
        return byte1 + (byte2 << 8) + (byte3 << 16) + (byte4 << 24);
    }

    private static String readString(DataInputStream dataInputStream) throws IOException {
        int length;
        StringBuilder builder = new StringBuilder(length);
        for (length = NBSDecoder.readInt(dataInputStream); length > 0; --length) {
            char c2 = (char)dataInputStream.readByte();
            if (c2 == '\r') {
                c2 = ' ';
            }
            builder.append(c2);
        }
        return builder.toString();
    }
}

