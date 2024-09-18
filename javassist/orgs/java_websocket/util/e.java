/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.util;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e
implements ThreadFactory {
    private final ThreadFactory a;
    private final AtomicInteger a;
    private final String a = new AtomicInteger(1);

    public e(String string) {
        this.a = string;
    }

    @Override
    public Thread newThread(Runnable runnable) {
        Thread thread = this.a.newThread(runnable);
        thread.setName(String.valueOf(this.a) + "-" + this.a);
        return thread;
    }
}

