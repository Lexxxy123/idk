/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 * 
 * Could not load the following classes:
 *  org.bukkit.Bukkit
 */
package de.tr7zw.nbtapi.utils;

import de.tr7zw.nbtapi.utils.ApiMetricsLite;
import de.tr7zw.nbtapi.utils.VersionChecker;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bukkit.Bukkit;

public enum MinecraftVersion {
    UNKNOWN(Integer.MAX_VALUE),
    MC1_7_R4(174),
    MC1_8_R3(183),
    MC1_9_R1(191),
    MC1_9_R2(192),
    MC1_10_R1(1101),
    MC1_11_R1(1111),
    MC1_12_R1(1121),
    MC1_13_R1(1131),
    MC1_13_R2(1132),
    MC1_14_R1(1141),
    MC1_15_R1(1151),
    MC1_16_R1(1161),
    MC1_16_R2(1162),
    MC1_16_R3(1163),
    MC1_17_R1(1171);

    private static MinecraftVersion version;
    private static Boolean hasGsonSupport;
    private static boolean bStatsDisabled;
    private static boolean disablePackageWarning;
    private static boolean updateCheckDisabled;
    private static Logger logger;
    protected static final String VERSION = "2.8.0";
    private final int versionId;

    private MinecraftVersion(int versionId) {
        this.versionId = versionId;
    }

    public int getVersionId() {
        return this.versionId;
    }

    public static boolean isAtLeastVersion(MinecraftVersion version) {
        return MinecraftVersion.getVersion().getVersionId() >= version.getVersionId();
    }

    public static boolean isNewerThan(MinecraftVersion version) {
        return MinecraftVersion.getVersion().getVersionId() > version.getVersionId();
    }

    public static MinecraftVersion getVersion() {
        if (version != null) {
            return version;
        }
        String ver = Bukkit.getServer().getClass().getPackage().getName().split("\\.")[3];
        logger.info("[NBTAPI] Found Spigot: " + ver + "! Trying to find NMS support");
        try {
            version = MinecraftVersion.valueOf(ver.replace("v", "MC"));
        } catch (IllegalArgumentException ex) {
            version = UNKNOWN;
        }
        if (version != UNKNOWN) {
            logger.info("[NBTAPI] NMS support '" + version.name() + "' loaded!");
        } else {
            logger.warning("[NBTAPI] Wasn't able to find NMS Support! Some functions may not work!");
        }
        MinecraftVersion.init();
        return version;
    }

    private static void init() {
        try {
            if (MinecraftVersion.hasGsonSupport() && !bStatsDisabled) {
                new ApiMetricsLite();
            }
        } catch (Exception ex) {
            logger.log(Level.WARNING, "[NBTAPI] Error enabling Metrics!", ex);
        }
        if (MinecraftVersion.hasGsonSupport() && !updateCheckDisabled) {
            new Thread(() -> {
                try {
                    VersionChecker.checkForUpdates();
                } catch (Exception ex) {
                    logger.log(Level.WARNING, "[NBTAPI] Error while checking for updates!", ex);
                }
            }).start();
        }
        String defaultPackage = new String(new byte[]{100, 101, 46, 116, 114, 55, 122, 119, 46, 99, 104, 97, 110, 103, 101, 109, 101, 46, 110, 98, 116, 97, 112, 105, 46, 117, 116, 105, 108, 115});
        if (!disablePackageWarning && MinecraftVersion.class.getPackage().getName().equals(defaultPackage)) {
            logger.warning("#########################################- NBTAPI -#########################################");
            logger.warning("The NBT-API package has not been moved! This *will* cause problems with other plugins containing");
            logger.warning("a different version of the api! Please read the guide on the plugin page on how to get the");
            logger.warning("Maven Shade plugin to relocate the api to your personal location! If you are not the developer,");
            logger.warning("please check your plugins and contact their developer, so he can fix this issue.");
            logger.warning("#########################################- NBTAPI -#########################################");
        }
    }

    public static boolean hasGsonSupport() {
        if (hasGsonSupport != null) {
            return hasGsonSupport;
        }
        try {
            logger.info("[NBTAPI] Found Gson: " + Class.forName("com.google.gson.Gson"));
            hasGsonSupport = true;
        } catch (Exception ex) {
            logger.info("[NBTAPI] Gson not found! This will not allow the usage of some methods!");
            hasGsonSupport = false;
        }
        return hasGsonSupport;
    }

    public static void disableBStats() {
        bStatsDisabled = true;
    }

    public static void disableUpdateCheck() {
        updateCheckDisabled = true;
    }

    public static void disablePackageWarning() {
        disablePackageWarning = true;
    }

    public static Logger getLogger() {
        return logger;
    }

    public static void replaceLogger(Logger logger) {
        if (logger == null) {
            throw new NullPointerException("Logger can not be null!");
        }
        MinecraftVersion.logger = logger;
    }

    static {
        bStatsDisabled = false;
        disablePackageWarning = false;
        updateCheckDisabled = false;
        logger = Logger.getLogger("NBTAPI");
    }
}

