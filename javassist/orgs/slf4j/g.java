/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j;

import java.io.Closeable;
import javassist.orgs.slf4j.f;

public class g
implements Closeable {
    private final String a;

    private g(String string) {
        this.a = string;
    }

    @Override
    public void close() {
        f.a(this.a);
    }

    /* synthetic */ g(String string, g g2) {
        this(string);
    }
}

