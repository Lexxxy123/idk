/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.exceptions;

import java.io.UnsupportedEncodingException;

public class d
extends RuntimeException {
    private final UnsupportedEncodingException a;

    public d(UnsupportedEncodingException unsupportedEncodingException) {
        if (unsupportedEncodingException == null) {
            throw new IllegalArgumentException();
        }
        this.a = unsupportedEncodingException;
    }

    public UnsupportedEncodingException a() {
        return this.a;
    }
}

