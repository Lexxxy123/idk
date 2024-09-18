/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.nio.ByteBuffer;
import java.nio.channels.ByteChannel;
import javassist.orgs.java_websocket.enums.e;
import javassist.orgs.java_websocket.j;
import javassist.orgs.java_websocket.m;

public class f {
    private f() {
        throw new IllegalStateException("Utility class");
    }

    public static boolean a(ByteBuffer byteBuffer, j j2, ByteChannel byteChannel) {
        byteBuffer.clear();
        int n2 = byteChannel.read(byteBuffer);
        byteBuffer.flip();
        if (n2 == -1) {
            j2.d();
            return false;
        }
        return n2 != 0;
    }

    public static boolean a(ByteBuffer byteBuffer, j j2, m m2) {
        byteBuffer.clear();
        int n2 = m2.a(byteBuffer);
        byteBuffer.flip();
        if (n2 == -1) {
            j2.d();
            return false;
        }
        return m2.b();
    }

    public static boolean a(j j2, ByteChannel byteChannel) {
        if (j2 == null) {
            return false;
        }
        ByteBuffer byteBuffer = (ByteBuffer)j2.a.peek();
        m m2 = null;
        if (byteBuffer == null) {
            if (byteChannel instanceof m && (m2 = (m)byteChannel).a()) {
                m2.a();
            }
        } else {
            do {
                byteChannel.write(byteBuffer);
                if (byteBuffer.remaining() > 0) {
                    return false;
                }
                j2.a.poll();
            } while ((byteBuffer = (ByteBuffer)j2.a.peek()) != null);
        }
        if (j2.a.isEmpty() && j2.d() && j2.a() != null && j2.a().a() != null && j2.a().a() == e.b) {
            j2.c();
        }
        return m2 == null || !((m)byteChannel).a();
    }
}

