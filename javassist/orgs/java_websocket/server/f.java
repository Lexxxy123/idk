/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.server;

import java.nio.ByteBuffer;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import javassist.orgs.java_websocket.j;
import javassist.orgs.java_websocket.server.e;
import javassist.orgs.java_websocket.server.g;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class f
extends Thread {
    private BlockingQueue<j> a;
    final /* synthetic */ e a;
    static final /* synthetic */ boolean a;

    static {
        a = !e.class.desiredAssertionStatus();
    }

    public f(e e2) {
        this.a = e2;
        this.a = new LinkedBlockingQueue<j>();
        this.setName("WebSocketWorker-" + this.getId());
        this.setUncaughtExceptionHandler(new g(this));
    }

    public void a(j j2) {
        this.a.put(j2);
    }

    @Override
    public void run() {
        j j2 = null;
        try {
            while (true) {
                j2 = this.a.take();
                ByteBuffer byteBuffer = (ByteBuffer)j2.b.poll();
                if (!a && byteBuffer == null) {
                    throw new AssertionError();
                }
                this.a(j2, byteBuffer);
                j2 = null;
            }
        } catch (InterruptedException interruptedException) {
            Thread.currentThread().interrupt();
        } catch (RuntimeException runtimeException) {
            e.a(this.a, j2, runtimeException);
        }
    }

    private void a(j j2, ByteBuffer byteBuffer) {
        try {
            try {
                j2.b(byteBuffer);
            } catch (Exception exception) {
                e.a(this.a).e("Error while reading from remote connection", exception);
                e.a(this.a, byteBuffer);
            }
        } finally {
            e.a(this.a, byteBuffer);
        }
    }

    static /* synthetic */ e a(f f2) {
        return f2.a;
    }
}

