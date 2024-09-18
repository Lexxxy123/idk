/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.server;

import javassist.orgs.java_websocket.server.e;
import javassist.orgs.java_websocket.server.f;

class g
implements Thread.UncaughtExceptionHandler {
    final /* synthetic */ f a;

    g(f f2) {
        this.a = f2;
    }

    @Override
    public void uncaughtException(Thread thread, Throwable throwable) {
        e.a(f.a(this.a)).e("Uncaught exception in thread {}: {}", (Object)thread.getName(), (Object)throwable);
    }
}

