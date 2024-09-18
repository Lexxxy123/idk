/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import javassist.orgs.java_websocket.framing.f;
import javassist.orgs.java_websocket.framing.h;
import javassist.orgs.java_websocket.g;
import javassist.orgs.java_websocket.handshake.a;
import javassist.orgs.java_websocket.handshake.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface k {
    public i a(g var1, javassist.orgs.java_websocket.drafts.a var2, a var3);

    public void a(g var1, a var2, javassist.orgs.java_websocket.handshake.h var3);

    public void a(g var1, a var2);

    public void a(g var1, String var2);

    public void a(g var1, ByteBuffer var2);

    public void a(g var1, javassist.orgs.java_websocket.handshake.f var2);

    public void a(g var1, int var2, String var3, boolean var4);

    public void b(g var1, int var2, String var3, boolean var4);

    public void a(g var1, int var2, String var3);

    public void a(g var1, Exception var2);

    public void a(g var1, f var2);

    public h a(g var1);

    public void b(g var1, f var2);

    public void a(g var1);

    public InetSocketAddress a(g var1);

    public InetSocketAddress b(g var1);
}

