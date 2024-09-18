/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.server;

import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import javassist.orgs.java_websocket.drafts.a;
import javassist.orgs.java_websocket.h;
import javassist.orgs.java_websocket.j;
import javassist.orgs.java_websocket.k;
import javassist.orgs.java_websocket.l;

public class c
implements l {
    @Override
    public j a(h h2, a a2) {
        return new j((k)h2, a2);
    }

    @Override
    public j a(h h2, List<a> list) {
        return new j((k)h2, list);
    }

    @Override
    public SocketChannel a(SocketChannel socketChannel, SelectionKey selectionKey) {
        return socketChannel;
    }

    @Override
    public void a() {
    }
}

