/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import javassist.orgs.java_websocket.framing.f;
import javassist.orgs.java_websocket.framing.i;
import javassist.orgs.java_websocket.g;
import javassist.orgs.java_websocket.handshake.a;
import javassist.orgs.java_websocket.handshake.e;
import javassist.orgs.java_websocket.k;

public abstract class h
implements k {
    private javassist.orgs.java_websocket.framing.h a;

    @Override
    public javassist.orgs.java_websocket.handshake.i a(g g2, javassist.orgs.java_websocket.drafts.a a2, a a3) {
        return new e();
    }

    @Override
    public void a(g g2, a a2, javassist.orgs.java_websocket.handshake.h h2) {
    }

    @Override
    public void a(g g2, a a2) {
    }

    @Override
    public void a(g g2, f f2) {
        g2.a(new i((javassist.orgs.java_websocket.framing.h)f2));
    }

    @Override
    public void b(g g2, f f2) {
    }

    @Override
    public javassist.orgs.java_websocket.framing.h a(g g2) {
        if (this.a == null) {
            this.a = new javassist.orgs.java_websocket.framing.h();
        }
        return this.a;
    }
}

