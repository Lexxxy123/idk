/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.util.Collection;
import javassist.orgs.java_websocket.drafts.a;
import javassist.orgs.java_websocket.enums.c;
import javassist.orgs.java_websocket.enums.d;
import javassist.orgs.java_websocket.framing.f;
import javax.net.ssl.SSLSession;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface g {
    public void a(int var1, String var2);

    public void a(int var1);

    public void a();

    public void b(int var1, String var2);

    public void a(String var1);

    public void a(ByteBuffer var1);

    public void a(byte[] var1);

    public void a(f var1);

    public void a(Collection<f> var1);

    public void b();

    public void a(c var1, ByteBuffer var2, boolean var3);

    public boolean a();

    public InetSocketAddress a();

    public InetSocketAddress b();

    public boolean b();

    public boolean c();

    public boolean d();

    public boolean e();

    public a a();

    public d a();

    public String a();

    public <T> void a(T var1);

    public <T> T a();

    public boolean f();

    public SSLSession a();
}

