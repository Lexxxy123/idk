/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.extensions;

import javassist.orgs.java_websocket.extensions.b;
import javassist.orgs.java_websocket.framing.d;
import javassist.orgs.java_websocket.framing.e;
import javassist.orgs.java_websocket.framing.f;

public abstract class a
extends b {
    @Override
    public void a(f f2) {
        if (f2 instanceof e && (f2.c() || f2.d())) {
            throw new javassist.orgs.java_websocket.exceptions.e("bad rsv RSV1: " + f2.b() + " RSV2: " + f2.c() + " RSV3: " + f2.d());
        }
        if (f2 instanceof d && (f2.b() || f2.c() || f2.d())) {
            throw new javassist.orgs.java_websocket.exceptions.e("bad rsv RSV1: " + f2.b() + " RSV2: " + f2.c() + " RSV3: " + f2.d());
        }
    }
}

