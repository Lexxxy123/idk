/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.enums;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class d
extends Enum<d> {
    public static final /* enum */ d a = new d();
    public static final /* enum */ d b = new d();
    public static final /* enum */ d c = new d();
    public static final /* enum */ d d = new d();
    private static final /* synthetic */ d[] a;

    static {
        a = new d[]{a, b, c, d};
    }

    public static d[] values() {
        d[] dArray = a;
        int n2 = dArray.length;
        d[] dArray2 = new d[n2];
        System.arraycopy(a, 0, dArray2, 0, n2);
        return dArray2;
    }

    public static d valueOf(String string) {
        return Enum.valueOf(d.class, string);
    }
}

