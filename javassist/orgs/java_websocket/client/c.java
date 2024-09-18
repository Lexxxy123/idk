/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.client;

import java.net.InetAddress;
import java.net.URI;
import javassist.orgs.java_websocket.client.a;
import javassist.orgs.java_websocket.client.b;

class c
implements a {
    final /* synthetic */ b a;

    c(b b2) {
        this.a = b2;
    }

    @Override
    public InetAddress a(URI uRI) {
        return InetAddress.getByName(uRI.getHost());
    }
}

