/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package com.xxmicloxx.NoteBlockAPI.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Updater {
    public static boolean checkUpdate(String resource, String actualVersion) throws MalformedURLException, IOException {
        boolean snapshot = false;
        if (actualVersion.contains("-SNAPSHOT")) {
            snapshot = true;
            actualVersion = actualVersion.replace("-SNAPSHOT", "");
        }
        Float version = Updater.getVersionNumber(actualVersion);
        URLConnection con = new URL("https://api.spigotmc.org/legacy/update.php?resource=" + resource).openConnection();
        String newVersionString = new BufferedReader(new InputStreamReader(con.getInputStream())).readLine();
        int first = newVersionString.indexOf("(");
        String newVersion = first == -1 ? newVersionString : newVersionString.substring(0, first);
        Float newVer = Updater.getVersionNumber(newVersion);
        return snapshot ? newVer.floatValue() >= version.floatValue() : newVer.floatValue() > version.floatValue();
    }

    private static Float getVersionNumber(String version) {
        String[] versionParts = version.split("\\.");
        String versionString = "0.";
        for (String vpart : versionParts) {
            if (vpart.length() < 2) {
                versionString = versionString + "0";
            }
            versionString = versionString + vpart;
        }
        return Float.valueOf(Float.parseFloat(versionString));
    }
}

