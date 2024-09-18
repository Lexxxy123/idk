/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.enums;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class a
extends Enum<a> {
    public static final /* enum */ a a = new a();
    public static final /* enum */ a b = new a();
    public static final /* enum */ a c = new a();
    private static final /* synthetic */ a[] a;

    static {
        a = new a[]{a, b, c};
    }

    public static a[] values() {
        a[] aArray = a;
        int n2 = aArray.length;
        a[] aArray2 = new a[n2];
        System.arraycopy(a, 0, aArray2, 0, n2);
        return aArray2;
    }

    public static a valueOf(String string) {
        return Enum.valueOf(a.class, string);
    }
}

