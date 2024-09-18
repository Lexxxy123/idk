/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.util;

import java.nio.ByteBuffer;

public class c {
    private c() {
    }

    public static int a(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) {
        int n2;
        if (byteBuffer == null || byteBuffer2 == null) {
            throw new IllegalArgumentException();
        }
        int n3 = byteBuffer.remaining();
        if (n3 > (n2 = byteBuffer2.remaining())) {
            int n4 = Math.min(n3, n2);
            byteBuffer.limit(n4);
            byteBuffer2.put(byteBuffer);
            return n4;
        }
        byteBuffer2.put(byteBuffer);
        return n3;
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(0);
    }
}

