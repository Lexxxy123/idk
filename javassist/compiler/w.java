/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.util.HashMap;
import javassist.compiler.ast.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class w
extends HashMap<String, i> {
    private static final long a = 1L;
    private w a;

    public w() {
        this((w)null);
    }

    public w(w w2) {
        this.a = w2;
    }

    public w a() {
        return this.a;
    }

    public i a(String string) {
        i i2 = (i)this.get(string);
        if (i2 == null && this.a != null) {
            return this.a.a(string);
        }
        return i2;
    }

    public void a(String string, i i2) {
        this.put(string, i2);
    }
}

