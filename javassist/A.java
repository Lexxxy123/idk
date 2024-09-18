/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.aa;
import javassist.compiler.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
extends Exception {
    private static final long a = 1L;
    private Throwable a;
    private String a;

    @Override
    public synchronized Throwable getCause() {
        return this.a == this ? null : this.a;
    }

    @Override
    public synchronized Throwable initCause(Throwable throwable) {
        this.a = throwable;
        return this;
    }

    public String a() {
        if (this.a != null) {
            return this.a;
        }
        return this.toString();
    }

    public a(String string) {
        super(string);
        this.a = string;
        this.initCause(null);
    }

    public a(Throwable throwable) {
        super("by " + throwable.toString());
        this.a = null;
        this.initCause(throwable);
    }

    public a(String string, Throwable throwable) {
        this(string);
        this.initCause(throwable);
    }

    public a(aa aa2) {
        this("cannot find " + aa2.getMessage(), aa2);
    }

    public a(e e2) {
        this("[source error] " + e2.getMessage(), e2);
    }

    public a(ClassNotFoundException classNotFoundException, String string) {
        this("cannot find " + string, classNotFoundException);
    }

    public a(ClassFormatError classFormatError, String string) {
        this("invalid class format: " + string, classFormatError);
    }
}

