/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 */
package de.tr7zw.nbtapi.utils;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import de.tr7zw.nbtapi.NBTItem;
import de.tr7zw.nbtapi.utils.MinecraftVersion;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.logging.Level;

public class VersionChecker {
    private static final String USER_AGENT = "nbt-api Version check";
    private static final String REQUEST_URL = "https://api.spiget.org/v2/resources/7939/versions?size=100";

    protected static void checkForUpdates() throws Exception {
        URL url = new URL(REQUEST_URL);
        HttpURLConnection connection = (HttpURLConnection)url.openConnection();
        connection.addRequestProperty("User-Agent", USER_AGENT);
        InputStream inputStream = connection.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);
        JsonElement element = new JsonParser().parse((Reader)reader);
        if (element.isJsonArray()) {
            JsonArray updates = (JsonArray)element;
            JsonObject latest = (JsonObject)updates.get(updates.size() - 1);
            int versionDifference = VersionChecker.getVersionDifference(latest.get("name").getAsString());
            if (versionDifference == -1) {
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] The NBT-API at '" + NBTItem.class.getPackage() + "' seems to be outdated!");
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Current Version: '2.8.0' Newest Version: " + latest.get("name").getAsString() + "'");
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Please update the nbt-api or the plugin that contains the api!");
            } else if (versionDifference == 0) {
                MinecraftVersion.getLogger().log(Level.INFO, "[NBTAPI] The NBT-API seems to be up-to-date!");
            } else if (versionDifference == 1) {
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] The NBT-API at '" + NBTItem.class.getPackage() + "' seems to be a future Version, not yet released on Spigot/CurseForge!");
                MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Current Version: '2.8.0' Newest Version: " + latest.get("name").getAsString() + "'");
            }
        } else {
            MinecraftVersion.getLogger().log(Level.WARNING, "[NBTAPI] Error when looking for Updates! Got non Json Array: '" + element.toString() + "'");
        }
    }

    private static int getVersionDifference(String version) {
        int relPatchN;
        String current = "2.8.0";
        if (current.equals(version)) {
            return 0;
        }
        String pattern = "\\.";
        if (current.split(pattern).length != 3 || version.split(pattern).length != 3) {
            return -1;
        }
        int curMaj = Integer.parseInt(current.split(pattern)[0]);
        int curMin = Integer.parseInt(current.split(pattern)[1]);
        String curPatch = current.split(pattern)[2];
        int relMaj = Integer.parseInt(version.split(pattern)[0]);
        int relMin = Integer.parseInt(version.split(pattern)[1]);
        String relPatch = version.split(pattern)[2];
        if (curMaj < relMaj) {
            return -1;
        }
        if (curMaj > relMaj) {
            return 1;
        }
        if (curMin < relMin) {
            return -1;
        }
        if (curMin > relMin) {
            return 1;
        }
        int curPatchN = Integer.parseInt(curPatch.split("-")[0]);
        if (curPatchN < (relPatchN = Integer.parseInt(relPatch.split("-")[0]))) {
            return -1;
        }
        if (curPatchN > relPatchN) {
            return 1;
        }
        if (!relPatch.contains("-") && curPatch.contains("-")) {
            return -1;
        }
        if (relPatch.contains("-") && curPatch.contains("-")) {
            return 0;
        }
        return 1;
    }
}

