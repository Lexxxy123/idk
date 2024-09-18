/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.handshake;

import javassist.orgs.java_websocket.handshake.b;
import javassist.orgs.java_websocket.handshake.g;

public class d
extends g
implements b {
    private String a = "*";

    @Override
    public void a(String string) {
        if (string == null) {
            throw new IllegalArgumentException("http resource descriptor must not be null");
        }
        this.a = string;
    }

    @Override
    public String a() {
        return this.a;
    }
}

