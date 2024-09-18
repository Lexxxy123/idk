/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javassist.orgs.java_websocket.b;
import javassist.orgs.java_websocket.g;
import javassist.orgs.java_websocket.h;
import javassist.orgs.java_websocket.j;
import javassist.orgs.java_websocket.util.e;
import javassist.orgs.slf4j.c;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class a
extends h {
    private final c a;
    private boolean a;
    private boolean b;
    private ScheduledExecutorService a;
    private ScheduledFuture a;
    private long a;
    private boolean c = false;
    private final Object a = new Object();

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public int a() {
        Object object = this.a;
        synchronized (object) {
            return (int)TimeUnit.NANOSECONDS.toSeconds(this.a);
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    public void a_(int n2) {
        Object object = this.a;
        synchronized (object) {
            this.a = TimeUnit.SECONDS.toNanos(n2);
            if (this.a <= 0L) {
                this.a.a("Connection lost timer stopped");
                this.d();
                return;
            }
            if (this.c) {
                this.a.a("Connection lost timer restarted");
                try {
                    ArrayList<g> arrayList = new ArrayList<g>(this.a());
                    for (g g2 : arrayList) {
                        if (!(g2 instanceof j)) continue;
                        j j2 = (j)g2;
                        j2.e();
                    }
                } catch (Exception exception) {
                    this.a.e("Exception during connection lost restart", exception);
                }
                this.c();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void a_() {
        Object object = this.a;
        synchronized (object) {
            if (this.a != null || this.a != null) {
                this.c = false;
                this.a.a("Connection lost timer stopped");
                this.d();
            }
        }
    }

    /*
     * WARNING - Removed try catching itself - possible behaviour change.
     */
    protected void b_() {
        Object object = this.a;
        synchronized (object) {
            if (this.a <= 0L) {
                this.a.a("Connection lost timer deactivated");
                return;
            }
            this.a.a("Connection lost timer started");
            this.c = true;
            this.c();
        }
    }

    private void c() {
        this.d();
        this.a = Executors.newSingleThreadScheduledExecutor(new e("connectionLostChecker"));
        b b2 = new b(this);
        this.a = this.a.scheduleAtFixedRate(b2, this.a, this.a, TimeUnit.NANOSECONDS);
    }

    private void a(g g2, long l2) {
        if (!(g2 instanceof j)) {
            return;
        }
        j j2 = (j)g2;
        if (j2.a() < l2) {
            this.a.a("Closing connection due to no pong received: {}", (Object)j2);
            j2.b(1006, "The connection was closed because the other endpoint did not respond with a pong in time. For more information check: https://github.com/TooTallNate/Java-WebSocket/wiki/Lost-connection-detection");
        } else if (j2.b()) {
            j2.b();
        } else {
            this.a.a("Trying to ping a non open connection: {}", (Object)j2);
        }
    }

    protected abstract Collection<g> a();

    private void d() {
        if (this.a != null) {
            this.a.shutdownNow();
            this.a = null;
        }
        if (this.a != null) {
            this.a.cancel(false);
            this.a = null;
        }
    }

    public boolean a_() {
        return this.a;
    }

    public void a(boolean bl2) {
        this.a = bl2;
    }

    public boolean b_() {
        return this.b;
    }

    public void b(boolean bl2) {
        this.b = bl2;
    }

    static /* synthetic */ long a(a a2) {
        return a2.a;
    }

    static /* synthetic */ void a(a a2, g g2, long l2) {
        a2.a(g2, l2);
    }
}

