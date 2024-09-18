/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.util;

import java.util.logging.Level;
import java.util.logging.Logger;

public class SLog {
    private static final Logger LOGGER = Logger.getLogger("Minecraft");
    private static final String PREFIX = "[SkySim Engine]";

    private static void log(Object o2, Level l2) {
        LOGGER.log(l2, "[SkySim Engine] " + o2);
    }

    public static void info(Object o2) {
        SLog.log(o2, Level.INFO);
    }

    public static void warn(Object o2) {
        SLog.log(o2, Level.WARNING);
    }

    public static void severe(Object o2) {
        SLog.log(o2, Level.SEVERE);
    }
}

