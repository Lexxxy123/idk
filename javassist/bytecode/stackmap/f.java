/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.ArrayList;
import javassist.aa;
import javassist.bytecode.J;
import javassist.bytecode.aL;
import javassist.bytecode.aU;
import javassist.bytecode.aV;
import javassist.bytecode.al;
import javassist.bytecode.bg;
import javassist.bytecode.r;
import javassist.bytecode.stackmap.b;
import javassist.bytecode.stackmap.c;
import javassist.bytecode.stackmap.g;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.i;
import javassist.bytecode.stackmap.l;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.t;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class f
extends g {
    public static aV a(javassist.f f2, al al2) {
        t[] tArray;
        r r2 = al2.a();
        if (r2 == null) {
            return null;
        }
        try {
            tArray = t.a(al2, r2, true);
        } catch (c c2) {
            return null;
        }
        if (tArray == null) {
            return null;
        }
        f f3 = new f(f2, al2, r2);
        try {
            f3.a(tArray, r2.b());
        } catch (javassist.bytecode.i i2) {
            throw new javassist.bytecode.i(al2, (Throwable)i2);
        }
        return f3.a(tArray);
    }

    public static aL a(javassist.f f2, al al2) {
        t[] tArray;
        r r2 = al2.a();
        if (r2 == null) {
            return null;
        }
        try {
            tArray = t.a(al2, r2, true);
        } catch (c c2) {
            return null;
        }
        if (tArray == null) {
            return null;
        }
        f f3 = new f(f2, al2, r2);
        try {
            f3.a(tArray, r2.b());
        } catch (javassist.bytecode.i i2) {
            throw new javassist.bytecode.i(al2, (Throwable)i2);
        }
        return f3.a(al2.a(), tArray);
    }

    public f(javassist.f f2, al al2, r r2) {
        super(f2, al2.a(), r2.a(), r2.d(), t.a(al2.b()));
    }

    protected f(f f2) {
        super(f2);
    }

    void a(t[] tArray, byte[] byArray) {
        this.a(byArray, tArray[0]);
        this.a(byArray, tArray);
        try {
            this.b(byArray, tArray);
        } catch (aa aa2) {
            throw new javassist.bytecode.i("failed to resolve types", (Throwable)aa2);
        }
    }

    /*
     * WARNING - void declaration
     */
    private void a(byte[] byArray, t t2) {
        void var3_4;
        f.a(t2.d, t2.b, this.a);
        this.a = t2.d;
        f.a(t2.a.length, t2.a, this.b);
        this.a(byArray, (b)t2.a);
        h[] hArray = t2.a;
        reference var4_5 = hArray + t2.b;
        while (var3_4 < var4_5) {
            var3_4 += this.a((int)var3_4, byArray);
            this.a(byArray, (b)t2.a);
        }
        if (t2.a != null) {
            for (int i2 = 0; i2 < t2.a.length; ++i2) {
                t t3 = (t)((Object)t2.a[i2]);
                if (t3.a()) {
                    this.a(t3, true);
                    continue;
                }
                this.a(t3);
                f f2 = new f(this);
                f2.a(byArray, t3);
            }
        }
    }

    private void a(byte[] byArray, b b2) {
        while (b2 != null) {
            t t2 = (t)b2.a;
            if (t2.a()) {
                this.a(t2, false);
                if (t2.d < 1) {
                    throw new javassist.bytecode.i("bad catch clause: " + b2.a);
                }
                t2.b[0] = this.a(this.a(b2.a), t2.b[0]);
            } else {
                this.a(t2, b2.a);
                f f2 = new f(this);
                f2.a(byArray, t2);
            }
            b2 = b2.a;
        }
    }

    private void a(t t2, boolean bl2) {
        int n2;
        int n3 = this.b.length;
        for (n2 = 0; n2 < n3; ++n2) {
            t2.a[n2] = this.a(f.a(this.b, n3, n2), t2.a[n2]);
        }
        if (bl2) {
            n3 = this.a;
            for (n2 = 0; n2 < n3; ++n2) {
                t2.b[n2] = this.a(this.a[n2], t2.b[n2]);
            }
        }
    }

    private h a(h h2, h h3) {
        if (h2 == h3) {
            return h3;
        }
        if (h3 instanceof m || h3 instanceof l) {
            return h3;
        }
        if (h3 instanceof i) {
            ((i)h3).a(h2);
            return h3;
        }
        throw new RuntimeException("fatal: this should never happen");
    }

    private void a(t t2) {
        h[] hArray = h.a(this.a.length);
        int n2 = this.a;
        f.a(n2, this.a, hArray);
        this.a(t2, n2, hArray);
    }

    private void a(t t2, int n2) {
        h[] hArray = h.a(this.a.length);
        hArray[0] = this.a(n2).a();
        this.a(t2, 1, hArray);
    }

    private m a(int n2) {
        String string = n2 == 0 ? "java.lang.Throwable" : this.a.a(n2);
        return new m(string);
    }

    private void a(t t2, int n2, h[] hArray) {
        int n3 = this.b.length;
        h[] hArray2 = h.a(n3);
        int n4 = f.a(n3, this.b, hArray2);
        t2.a(n2, hArray, n4, hArray2);
    }

    protected static int a(int n2, h[] hArray, h[] hArray2) {
        int n3 = -1;
        for (int i2 = 0; i2 < n2; ++i2) {
            h h2 = f.a(hArray, n2, i2);
            hArray2[i2] = h2.a();
            if (h2 == a) continue;
            n3 = i2 + 1;
        }
        return n3 + 1;
    }

    protected static void a(int n2, h[] hArray, h[] hArray2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            hArray2[i2] = hArray[i2];
        }
    }

    private static h a(h[] hArray, int n2, int n3) {
        h h2 = hArray[n3];
        if (h2.a() && n3 + 1 < n2 && hArray[n3 + 1] != a) {
            return a;
        }
        return h2;
    }

    private void a(byte[] byArray, t[] tArray) {
        for (t t2 : tArray) {
            t t3;
            if (t2.a()) continue;
            this.b(byArray, t2);
            h[] hArray = t2.a;
            if (hArray == null || (t3 = (t)hArray.a).a()) continue;
            this.a(t3, hArray.a);
            this.b(byArray, t3);
            t3.c = 1;
        }
    }

    private void b(byte[] byArray, t t2) {
        h[] hArray = t2.a;
        Object object = t2.b - 3;
        if (object < 0) {
            if (object == -1) {
                byArray[hArray] = 0;
            }
            byArray[hArray + t2.b - true] = -65;
            t2.c = 1;
            this.a(t2, 0);
            return;
        }
        t2.c = 0;
        for (int i2 = 0; i2 < object; ++i2) {
            byArray[hArray + i2] = 0;
        }
        byArray[hArray + object] = -89;
        javassist.bytecode.l.a((int)(-object), byArray, (int)(hArray + object + true));
    }

    private void b(byte[] byArray, t[] tArray) {
        ArrayList<h> arrayList = new ArrayList<h>();
        int n2 = tArray.length;
        int n3 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            int n4;
            t t2 = tArray[i2];
            if (!t2.a()) continue;
            int n5 = t2.a.length;
            for (n4 = 0; n4 < n5; ++n4) {
                n3 = t2.a[n4].a(arrayList, n3, this.a);
            }
            n5 = t2.d;
            for (n4 = 0; n4 < n5; ++n4) {
                n3 = t2.b[n4].a(arrayList, n3, this.a);
            }
        }
    }

    /*
     * WARNING - void declaration
     */
    public aV a(t[] tArray) {
        bg bg2 = new bg(32);
        int n2 = tArray.length;
        t t2 = tArray[0];
        h[] hArray = t2.b;
        if (t2.c > 0) {
            void var5_6;
            bg2.a(0);
            --var5_6;
        }
        for (int i2 = 1; i2 < n2; ++i2) {
            reference var5_7;
            t t3 = tArray[i2];
            if (this.a(t3, tArray[i2 - 1])) {
                t3.a();
                int n3 = f.a(t2.e, t2.a, t3.e, t3.a);
                this.a(bg2, t3, n3, (int)var5_7, t2);
                var5_7 = t3.b - true;
                t2 = t3;
                continue;
            }
            if (t3.c == 0) {
                bg2.a((int)var5_7);
                var5_7 = t3.b - true;
                continue;
            }
            var5_7 += t3.b;
        }
        return bg2.a(this.a);
    }

    private boolean a(t t2, t t3) {
        int n2 = t2.c;
        if (n2 > 1) {
            return true;
        }
        if (n2 < 1) {
            return false;
        }
        return (boolean)t3.a;
    }

    private void a(bg bg2, t t2, int n2, int n3, t t3) {
        Object object;
        int n4 = t2.d;
        if (n4 == 0) {
            if (n2 == 0) {
                bg2.a(n3);
                return;
            }
            if (0 > n2 && n2 >= -3) {
                bg2.a(n3, -n2);
                return;
            }
            if (0 < n2 && n2 <= 3) {
                int[] nArray = new int[n2];
                int[] nArray2 = this.a(t2.e - t3.e, t3.e, nArray, t2.a);
                bg2.a(n3, nArray2, nArray);
                return;
            }
        } else {
            if (n4 == 1 && n2 == 0) {
                h h2 = t2.b[0];
                bg2.a(n3, h2.a(), h2.a(this.a));
                return;
            }
            if (n4 == 2 && n2 == 0 && ((h)(object = (Object)t2.b[0])).a()) {
                bg2.a(n3, ((h)object).a(), ((h)object).a(this.a));
                return;
            }
        }
        object = new int[n4];
        int[] nArray = this.a(n4, 0, (int[])object, t2.b);
        int[] nArray3 = new int[t2.e];
        int[] nArray4 = this.a(t2.e, 0, nArray3, t2.a);
        bg2.a(n3, nArray4, nArray3, nArray, (int[])object);
    }

    private int[] a(int n2, int n3, int[] nArray, h[] hArray) {
        int n4 = f.a(hArray, n3, n3 + n2);
        J j2 = this.a;
        int[] nArray2 = new int[n4];
        int n5 = 0;
        for (int i2 = 0; i2 < n2; ++i2) {
            h h2 = hArray[n3 + i2];
            nArray2[n5] = h2.a();
            nArray[n5] = h2.a(j2);
            if (h2.a()) {
                ++i2;
            }
            ++n5;
        }
        return nArray2;
    }

    private static int a(int n2, h[] hArray, int n3, h[] hArray2) {
        int n4 = n3 - n2;
        int n5 = n4 > 0 ? n2 : n3;
        if (f.a(hArray, hArray2, n5)) {
            if (n4 > 0) {
                return f.a(hArray2, n5, n3);
            }
            return -f.a(hArray, n5, n2);
        }
        return -100;
    }

    private static boolean a(h[] hArray, h[] hArray2, int n2) {
        for (int i2 = 0; i2 < n2; ++i2) {
            if (hArray[i2].a(hArray2[i2])) continue;
            return false;
        }
        return true;
    }

    private static int a(h[] hArray, int n2, int n3) {
        int n4 = 0;
        while (n2 < n3) {
            h h2 = hArray[n2++];
            ++n4;
            if (!h2.a()) continue;
            ++n2;
        }
        return n4;
    }

    public aL a(J j2, t[] tArray) {
        int n2;
        aU aU2 = new aU();
        int n3 = tArray.length;
        boolean[] blArray = new boolean[n3];
        t t2 = tArray[0];
        blArray[0] = t2.c > 0;
        int n4 = blArray[0] ? 1 : 0;
        for (n2 = 1; n2 < n3; ++n2) {
            t t3 = tArray[n2];
            blArray[n2] = this.a(t3, tArray[n2 - 1]);
            if (!blArray[n2]) continue;
            t3.a();
            t2 = t3;
            ++n4;
        }
        if (n4 == 0) {
            return null;
        }
        aU2.a(n4);
        for (n2 = 0; n2 < n3; ++n2) {
            if (!blArray[n2]) continue;
            this.a(aU2, j2, (int)tArray[n2].a, tArray[n2]);
        }
        return aU2.a(j2);
    }

    private void a(aU aU2, J j2, int n2, t t2) {
        aU2.a(n2);
        this.a(aU2, j2, t2.a, t2.e);
        this.a(aU2, j2, t2.b, t2.d);
    }

    private void a(aU aU2, J j2, h[] hArray, int n2) {
        h h2;
        int n3;
        int n4 = 0;
        for (n3 = 0; n3 < n2; ++n3) {
            h2 = hArray[n3];
            if (h2 == null || !h2.a()) continue;
            ++n4;
            ++n3;
        }
        aU2.a(n2 - n4);
        for (n3 = 0; n3 < n2; ++n3) {
            h2 = hArray[n3];
            aU2.a(h2.a(), h2.a(j2));
            if (!h2.a()) continue;
            ++n3;
        }
    }
}

