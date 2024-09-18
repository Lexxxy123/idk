/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.enums;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class b
extends Enum<b> {
    public static final /* enum */ b a = new b();
    public static final /* enum */ b b = new b();
    private static final /* synthetic */ b[] a;

    static {
        a = new b[]{a, b};
    }

    public static b[] values() {
        b[] bArray = a;
        int n2 = bArray.length;
        b[] bArray2 = new b[n2];
        System.arraycopy(a, 0, bArray2, 0, n2);
        return bArray2;
    }

    public static b valueOf(String string) {
        return Enum.valueOf(b.class, string);
    }
}

