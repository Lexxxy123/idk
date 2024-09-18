/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.client;

import java.io.IOException;
import java.nio.ByteBuffer;
import javassist.orgs.java_websocket.client.b;
import javassist.orgs.java_websocket.g;

class d
implements Runnable {
    private final b b;
    final /* synthetic */ b a;

    d(b b2, b b3) {
        this.a = b2;
        this.b = b3;
    }

    @Override
    public void run() {
        Thread.currentThread().setName("WebSocketWriteThread-" + Thread.currentThread().getId());
        try {
            try {
                this.a();
            } catch (IOException iOException) {
                javassist.orgs.java_websocket.client.b.a(this.a, iOException);
                this.b();
                javassist.orgs.java_websocket.client.b.a(this.a, null);
            }
        } finally {
            this.b();
            javassist.orgs.java_websocket.client.b.a(this.a, null);
        }
    }

    /*
     * Unable to fully structure code
     */
    private void a() {
        block4: {
            try {
                while (!Thread.interrupted()) {
                    var1_1 = (ByteBuffer)javassist.orgs.java_websocket.client.b.a((b)this.a).a.take();
                    javassist.orgs.java_websocket.client.b.a(this.a).write(var1_1.array(), 0, var1_1.limit());
                    javassist.orgs.java_websocket.client.b.a(this.a).flush();
                }
                break block4;
            } catch (InterruptedException var1_2) {
                ** for (var2_4 : javassist.orgs.java_websocket.client.b.a((b)this.a).a)
            }
lbl-1000:
            // 1 sources

            {
                javassist.orgs.java_websocket.client.b.a(this.a).write(var2_4.array(), 0, var2_4.limit());
                javassist.orgs.java_websocket.client.b.a(this.a).flush();
                continue;
            }
lbl13:
            // 1 sources

            Thread.currentThread().interrupt();
        }
    }

    private void b() {
        try {
            if (javassist.orgs.java_websocket.client.b.a(this.a) != null) {
                javassist.orgs.java_websocket.client.b.a(this.a).close();
            }
        } catch (IOException iOException) {
            this.a.a((g)this.b, iOException);
        }
    }
}

