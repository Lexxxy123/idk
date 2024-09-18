/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class r
extends Error {
    private static final long a = 1L;
    private String a;

    public r(String string, Error error) {
        super(error.toString(), error);
        this.a = string;
    }

    public String a() {
        return this.a;
    }
}

