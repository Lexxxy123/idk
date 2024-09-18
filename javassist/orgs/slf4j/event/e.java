/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.event;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class e
extends Enum<e> {
    public static final /* enum */ e a = new e(40, "ERROR");
    public static final /* enum */ e b = new e(30, "WARN");
    public static final /* enum */ e c = new e(20, "INFO");
    public static final /* enum */ e d = new e(10, "DEBUG");
    public static final /* enum */ e e = new e(0, "TRACE");
    private int a;
    private String a;
    private static final /* synthetic */ e[] a;

    static {
        a = new e[]{a, b, c, d, e};
    }

    private e(int n3, String string2) {
        this.a = n3;
        this.a = string2;
    }

    public int a() {
        return this.a;
    }

    public static e a(int n2) {
        switch (n2) {
            case 0: {
                return e;
            }
            case 10: {
                return d;
            }
            case 20: {
                return c;
            }
            case 30: {
                return b;
            }
            case 40: {
                return a;
            }
        }
        throw new IllegalArgumentException("Level integer [" + n2 + "] not recognized.");
    }

    public String toString() {
        return this.a;
    }

    public static e[] values() {
        e[] eArray = a;
        int n2 = eArray.length;
        e[] eArray2 = new e[n2];
        System.arraycopy(a, 0, eArray2, 0, n2);
        return eArray2;
    }

    public static e valueOf(String string) {
        return Enum.valueOf(e.class, string);
    }
}

