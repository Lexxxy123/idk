/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class f {
    public static f a = new f(null);
    private String a;
    private Throwable a;
    private Object[] a;

    public f(String string) {
        this(string, null, null);
    }

    public f(String string, Object[] objectArray, Throwable throwable) {
        this.a = string;
        this.a = throwable;
        this.a = objectArray;
    }

    public String a() {
        return this.a;
    }

    public Object[] a() {
        return this.a;
    }

    public Throwable a() {
        return this.a;
    }
}

