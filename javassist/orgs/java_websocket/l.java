/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.nio.channels.ByteChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.List;
import javassist.orgs.java_websocket.drafts.a;
import javassist.orgs.java_websocket.h;
import javassist.orgs.java_websocket.i;
import javassist.orgs.java_websocket.j;

public interface l
extends i {
    @Override
    public j a(h var1, a var2);

    @Override
    public j a(h var1, List<a> var2);

    public ByteChannel a(SocketChannel var1, SelectionKey var2);

    public void a();
}

