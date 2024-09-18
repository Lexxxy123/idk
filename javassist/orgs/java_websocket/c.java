/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import java.nio.channels.SocketChannel;
import javassist.orgs.java_websocket.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
@Deprecated
public class c
implements m {
    private final ByteChannel a;

    @Deprecated
    public c(ByteChannel byteChannel) {
        this.a = byteChannel;
    }

    @Deprecated
    public c(m m2) {
        this.a = m2;
    }

    @Override
    public int read(ByteBuffer byteBuffer) {
        return this.a.read(byteBuffer);
    }

    @Override
    public boolean isOpen() {
        return this.a.isOpen();
    }

    @Override
    public void close() {
        this.a.close();
    }

    @Override
    public int write(ByteBuffer byteBuffer) {
        return this.a.write(byteBuffer);
    }

    @Override
    public boolean a() {
        return this.a instanceof m && ((m)this.a).a();
    }

    @Override
    public void a() {
        if (this.a instanceof m) {
            ((m)this.a).a();
        }
    }

    @Override
    public boolean b() {
        return this.a instanceof m && ((m)this.a).b();
    }

    @Override
    public int a(ByteBuffer byteBuffer) {
        return this.a instanceof m ? ((m)this.a).a(byteBuffer) : 0;
    }

    @Override
    public boolean c() {
        if (this.a instanceof SocketChannel) {
            return ((SocketChannel)this.a).isBlocking();
        }
        if (this.a instanceof m) {
            return ((m)this.a).c();
        }
        return false;
    }
}

