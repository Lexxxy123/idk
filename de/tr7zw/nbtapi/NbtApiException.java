/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtapi;

public class NbtApiException
extends RuntimeException {
    private static final long serialVersionUID = -993309714559452334L;

    public NbtApiException() {
    }

    public NbtApiException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public NbtApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public NbtApiException(String message) {
        super(message);
    }

    public NbtApiException(Throwable cause) {
        super(cause);
    }
}

