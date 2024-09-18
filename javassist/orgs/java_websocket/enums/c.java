/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.enums;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class c
extends Enum<c> {
    public static final /* enum */ c a = new c();
    public static final /* enum */ c b = new c();
    public static final /* enum */ c c = new c();
    public static final /* enum */ c d = new c();
    public static final /* enum */ c e = new c();
    public static final /* enum */ c f = new c();
    private static final /* synthetic */ c[] a;

    static {
        a = new c[]{a, b, c, d, e, f};
    }

    public static c[] values() {
        c[] cArray = a;
        int n2 = cArray.length;
        c[] cArray2 = new c[n2];
        System.arraycopy(a, 0, cArray2, 0, n2);
        return cArray2;
    }

    public static c valueOf(String string) {
        return Enum.valueOf(c.class, string);
    }
}

