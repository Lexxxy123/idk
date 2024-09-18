/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.enums;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class e
extends Enum<e> {
    public static final /* enum */ e a = new e();
    public static final /* enum */ e b = new e();
    private static final /* synthetic */ e[] a;

    static {
        a = new e[]{a, b};
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

