/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javassist.CtClass;
import javassist.bytecode.H;
import javassist.bytecode.I;
import javassist.bytecode.M;
import javassist.bytecode.P;
import javassist.bytecode.R;
import javassist.bytecode.X;
import javassist.bytecode.Y;
import javassist.bytecode.aa;
import javassist.bytecode.ab;
import javassist.bytecode.ac;
import javassist.bytecode.ah;
import javassist.bytecode.ai;
import javassist.bytecode.aj;
import javassist.bytecode.ak;
import javassist.bytecode.an;
import javassist.bytecode.ao;
import javassist.bytecode.ap;
import javassist.bytecode.aq;
import javassist.bytecode.au;
import javassist.bytecode.bh;
import javassist.bytecode.bp;
import javassist.bytecode.p;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class J {
    ai a;
    int a;
    int b;
    Map<H, H> a;
    public static final int c = 7;
    public static final int d = 9;
    public static final int e = 10;
    public static final int f = 11;
    public static final int g = 8;
    public static final int h = 3;
    public static final int i = 4;
    public static final int j = 5;
    public static final int k = 6;
    public static final int l = 12;
    public static final int m = 1;
    public static final int n = 15;
    public static final int o = 16;
    public static final int p = 17;
    public static final int q = 18;
    public static final int r = 18;
    public static final int s = 19;
    public static final int t = 20;
    public static final CtClass a = null;
    public static final int u = 1;
    public static final int v = 2;
    public static final int w = 3;
    public static final int x = 4;
    public static final int y = 5;
    public static final int z = 6;
    public static final int A = 7;
    public static final int B = 8;
    public static final int C = 9;

    public J(String string) {
        this.a = new ai();
        this.a = null;
        this.a = 0;
        this.a((H)null);
        this.b = this.a(string);
    }

    public J(DataInputStream dataInputStream) {
        this.a = null;
        this.b = 0;
        this.a(dataInputStream);
    }

    void a() {
        this.a = null;
    }

    public int a() {
        return this.a;
    }

    public String a() {
        return this.a(this.b);
    }

    public int b() {
        return this.b;
    }

    void a(int n2) {
        this.b = n2;
    }

    H a(int n2) {
        return this.a.a(n2);
    }

    public int a(int n2) {
        return this.a(n2).a();
    }

    public String a(int n2) {
        p p2 = (p)this.a(n2);
        if (p2 == null) {
            return null;
        }
        return M.b(this.m(p2.b));
    }

    public String b(int n2) {
        p p2 = (p)this.a(n2);
        if (p2 == null) {
            return null;
        }
        String string = this.m(p2.b);
        if (string.charAt(0) == '[') {
            return string;
        }
        return M.d(string);
    }

    public int b(int n2) {
        aq aq2 = (aq)this.a(n2);
        return aq2.b;
    }

    public int c(int n2) {
        aq aq2 = (aq)this.a(n2);
        return aq2.d;
    }

    public int d(int n2) {
        aj aj2 = (aj)this.a(n2);
        return aj2.b;
    }

    public int e(int n2) {
        aj aj2 = (aj)this.a(n2);
        return aj2.d;
    }

    public int f(int n2) {
        X x2 = (X)this.a(n2);
        return x2.b;
    }

    public String c(int n2) {
        X x2 = (X)this.a(n2);
        if (x2 == null) {
            return null;
        }
        return this.a(x2.b);
    }

    public int g(int n2) {
        X x2 = (X)this.a(n2);
        return x2.d;
    }

    public String d(int n2) {
        X x2 = (X)this.a(n2);
        if (x2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(x2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.b);
    }

    public String e(int n2) {
        X x2 = (X)this.a(n2);
        if (x2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(x2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.d);
    }

    public int h(int n2) {
        aj aj2 = (aj)this.a(n2);
        return aj2.b;
    }

    public String f(int n2) {
        aj aj2 = (aj)this.a(n2);
        if (aj2 == null) {
            return null;
        }
        return this.a(aj2.b);
    }

    public int i(int n2) {
        aj aj2 = (aj)this.a(n2);
        return aj2.d;
    }

    public String g(int n2) {
        aj aj2 = (aj)this.a(n2);
        if (aj2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(aj2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.b);
    }

    public String h(int n2) {
        aj aj2 = (aj)this.a(n2);
        if (aj2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(aj2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.d);
    }

    public int j(int n2) {
        aj aj2 = (aj)this.a(n2);
        return aj2.b;
    }

    public String i(int n2) {
        aj aj2 = (aj)this.a(n2);
        return this.a(aj2.b);
    }

    public int k(int n2) {
        aj aj2 = (aj)this.a(n2);
        return aj2.d;
    }

    public String j(int n2) {
        aj aj2 = (aj)this.a(n2);
        if (aj2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(aj2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.b);
    }

    public String k(int n2) {
        aj aj2 = (aj)this.a(n2);
        if (aj2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(aj2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.d);
    }

    public Object a(int n2) {
        H h2 = this.a(n2);
        Object object = null;
        if (h2 instanceof bh) {
            object = this.l(n2);
        } else if (h2 instanceof Y) {
            object = Float.valueOf(this.a(n2));
        } else if (h2 instanceof aa) {
            object = this.l(n2);
        } else if (h2 instanceof ah) {
            object = this.a(n2);
        } else if (h2 instanceof P) {
            object = this.a(n2);
        }
        return object;
    }

    public int l(int n2) {
        aa aa2 = (aa)this.a(n2);
        return aa2.b;
    }

    public float a(int n2) {
        Y y2 = (Y)this.a(n2);
        return y2.a;
    }

    public long a(int n2) {
        ah ah2 = (ah)this.a(n2);
        return ah2.a;
    }

    public double a(int n2) {
        P p2 = (P)this.a(n2);
        return p2.a;
    }

    public String l(int n2) {
        bh bh2 = (bh)this.a(n2);
        return this.m(bh2.b);
    }

    public String m(int n2) {
        bp bp2 = (bp)this.a(n2);
        return bp2.a;
    }

    public int m(int n2) {
        ak ak2 = (ak)this.a(n2);
        return ak2.b;
    }

    public int n(int n2) {
        ak ak2 = (ak)this.a(n2);
        return ak2.d;
    }

    public int o(int n2) {
        an an2 = (an)this.a(n2);
        return an2.b;
    }

    public int p(int n2) {
        ac ac2 = (ac)this.a(n2);
        return ac2.b;
    }

    public int q(int n2) {
        ac ac2 = (ac)this.a(n2);
        return ac2.d;
    }

    public String n(int n2) {
        ac ac2 = (ac)this.a(n2);
        if (ac2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(ac2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.d);
    }

    public int r(int n2) {
        R r2 = (R)this.a(n2);
        return r2.b;
    }

    public int s(int n2) {
        R r2 = (R)this.a(n2);
        return r2.d;
    }

    public String o(int n2) {
        R r2 = (R)this.a(n2);
        if (r2 == null) {
            return null;
        }
        aq aq2 = (aq)this.a(r2.d);
        if (aq2 == null) {
            return null;
        }
        return this.m(aq2.d);
    }

    public String p(int n2) {
        ap ap2 = (ap)this.a(n2);
        return this.m(ap2.b);
    }

    public String q(int n2) {
        au au2 = (au)this.a(n2);
        return this.m(au2.b);
    }

    public int a(String string, int n2) {
        return this.a(string, "<init>", n2);
    }

    public int a(String string, String string2, int n2) {
        aj aj2 = (aj)this.a(n2);
        if (this.a(aj2.b).equals(string)) {
            aq aq2 = (aq)this.a(aj2.d);
            if (this.m(aq2.b).equals(string2)) {
                return aq2.d;
            }
        }
        return 0;
    }

    public String a(String string, String string2, int n2) {
        aj aj2 = (aj)this.a(n2);
        aq aq2 = (aq)this.a(aj2.d);
        if (this.m(aq2.b).equals(string) && this.m(aq2.d).equals(string2)) {
            return this.a(aj2.b);
        }
        return null;
    }

    private int a(H h2) {
        this.a.a(h2);
        return this.a++;
    }

    private int b(H h2) {
        H h3;
        if (this.a == null) {
            this.a = J.a(this.a);
        }
        if ((h3 = (H)this.a.get(h2)) != null) {
            return h3.c;
        }
        this.a.a(h2);
        this.a.put(h2, h2);
        return this.a++;
    }

    public int a(int n2, J j2, Map<String, String> map) {
        if (n2 == 0) {
            return 0;
        }
        H h2 = this.a(n2);
        return h2.a(this, j2, map);
    }

    int c() {
        return this.a(new I(this.a));
    }

    public int a(CtClass ctClass) {
        if (ctClass == a) {
            return this.b;
        }
        if (!ctClass.a()) {
            return this.a(ctClass.a());
        }
        return this.a(M.a(ctClass));
    }

    public int a(String string) {
        int n2 = this.c(M.a(string));
        return this.b(new p(n2, this.a));
    }

    public int a(String string, String string2) {
        return this.a(this.c(string), this.c(string2));
    }

    public int a(int n2, int n3) {
        return this.b(new aq(n2, n3, this.a));
    }

    public int a(int n2, String string, String string2) {
        int n3 = this.a(string, string2);
        return this.b(n2, n3);
    }

    public int b(int n2, int n3) {
        return this.b(new X(n2, n3, this.a));
    }

    public int b(int n2, String string, String string2) {
        int n3 = this.a(string, string2);
        return this.c(n2, n3);
    }

    public int c(int n2, int n3) {
        return this.b(new ao(n2, n3, this.a));
    }

    public int c(int n2, String string, String string2) {
        int n3 = this.a(string, string2);
        return this.d(n2, n3);
    }

    public int d(int n2, int n3) {
        return this.b(new ab(n2, n3, this.a));
    }

    public int b(String string) {
        int n2 = this.c(string);
        return this.b(new bh(n2, this.a));
    }

    public int t(int n2) {
        return this.b(new aa(n2, this.a));
    }

    public int a(float f2) {
        return this.b(new Y(f2, this.a));
    }

    public int a(long l2) {
        int n2 = this.b(new ah(l2, this.a));
        if (n2 == this.a - 1) {
            this.c();
        }
        return n2;
    }

    public int a(double d2) {
        int n2 = this.b(new P(d2, this.a));
        if (n2 == this.a - 1) {
            this.c();
        }
        return n2;
    }

    public int c(String string) {
        return this.b(new bp(string, this.a));
    }

    public int e(int n2, int n3) {
        return this.b(new ak(n2, n3, this.a));
    }

    public int u(int n2) {
        return this.b(new an(n2, this.a));
    }

    public int f(int n2, int n3) {
        return this.b(new ac(n2, n3, this.a));
    }

    public int g(int n2, int n3) {
        return this.b(new R(n2, n3, this.a));
    }

    public int v(int n2) {
        return this.b(new ap(n2, this.a));
    }

    public int w(int n2) {
        return this.b(new au(n2, this.a));
    }

    public Set<String> a() {
        HashSet<String> hashSet = new HashSet<String>();
        ai ai2 = this.a;
        int n2 = this.a;
        for (int i2 = 1; i2 < n2; ++i2) {
            String string = ai2.a(i2).a(this);
            if (string == null) continue;
            hashSet.add(string);
        }
        return hashSet;
    }

    public void a(String string, String string2) {
        ai ai2 = this.a;
        int n2 = this.a;
        for (int i2 = 1; i2 < n2; ++i2) {
            H h2 = ai2.a(i2);
            h2.a(this, string, string2, (Map<H, H>)((Object)this.a));
        }
    }

    public void a(Map<String, String> map) {
        ai ai2 = this.a;
        int n2 = this.a;
        for (int i2 = 1; i2 < n2; ++i2) {
            H h2 = ai2.a(i2);
            h2.a(this, map, (Map<H, H>)((Object)this.a));
        }
    }

    private void a(DataInputStream dataInputStream) {
        int n2 = dataInputStream.readUnsignedShort();
        this.a = new ai(n2);
        this.a = 0;
        this.a((H)null);
        while (--n2 > 0) {
            int n3 = this.a(dataInputStream);
            if (n3 != 5 && n3 != 6) continue;
            this.c();
            --n2;
        }
    }

    private static Map<H, H> a(ai ai2) {
        H h2;
        HashMap<H, H> hashMap = new HashMap<H, H>();
        int n2 = 1;
        while ((h2 = ai2.a(n2++)) != null) {
            hashMap.put(h2, h2);
        }
        return hashMap;
    }

    private int a(DataInputStream dataInputStream) {
        H h2;
        int n2 = dataInputStream.readUnsignedByte();
        switch (n2) {
            case 1: {
                h2 = new bp(dataInputStream, this.a);
                break;
            }
            case 3: {
                h2 = new aa(dataInputStream, this.a);
                break;
            }
            case 4: {
                h2 = new Y(dataInputStream, this.a);
                break;
            }
            case 5: {
                h2 = new ah(dataInputStream, this.a);
                break;
            }
            case 6: {
                h2 = new P(dataInputStream, this.a);
                break;
            }
            case 7: {
                h2 = new p(dataInputStream, this.a);
                break;
            }
            case 8: {
                h2 = new bh(dataInputStream, this.a);
                break;
            }
            case 9: {
                h2 = new X(dataInputStream, this.a);
                break;
            }
            case 10: {
                h2 = new ao(dataInputStream, this.a);
                break;
            }
            case 11: {
                h2 = new ab(dataInputStream, this.a);
                break;
            }
            case 12: {
                h2 = new aq(dataInputStream, this.a);
                break;
            }
            case 15: {
                h2 = new ak(dataInputStream, this.a);
                break;
            }
            case 16: {
                h2 = new an(dataInputStream, this.a);
                break;
            }
            case 17: {
                h2 = new R(dataInputStream, this.a);
                break;
            }
            case 18: {
                h2 = new ac(dataInputStream, this.a);
                break;
            }
            case 19: {
                h2 = new ap(dataInputStream, this.a);
                break;
            }
            case 20: {
                h2 = new au(dataInputStream, this.a);
                break;
            }
            default: {
                throw new IOException("invalid constant type: " + n2 + " at " + this.a);
            }
        }
        this.a(h2);
        return n2;
    }

    public void a(DataOutputStream dataOutputStream) {
        dataOutputStream.writeShort(this.a);
        ai ai2 = this.a;
        int n2 = this.a;
        for (int i2 = 1; i2 < n2; ++i2) {
            ai2.a(i2).a(dataOutputStream);
        }
    }

    public void b() {
        this.a(new PrintWriter(System.out, true));
    }

    public void a(PrintWriter printWriter) {
        int n2 = this.a;
        for (int i2 = 1; i2 < n2; ++i2) {
            printWriter.print(i2);
            printWriter.print(" ");
            this.a.a(i2).a(printWriter);
        }
    }
}

