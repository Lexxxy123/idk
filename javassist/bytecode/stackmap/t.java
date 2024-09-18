/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import javassist.bytecode.J;
import javassist.bytecode.al;
import javassist.bytecode.i;
import javassist.bytecode.r;
import javassist.bytecode.stackmap.a;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.q;
import javassist.bytecode.stackmap.s;
import javassist.bytecode.stackmap.u;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class t
extends a {
    public int d;
    public int e;
    public h[] a = null;
    public h[] b;

    public static t[] a(al al2, r r2, boolean bl2) {
        t[] tArray = (t[])new u().a(al2);
        if (bl2 && tArray.length < 2 && (tArray.length == 0 || tArray[0].c == 0)) {
            return null;
        }
        J j2 = al2.a();
        boolean bl3 = (al2.a() & 8) != 0;
        tArray[0].a(r2.a(), r2.d(), j2.a(), al2.b(), bl3, al2.b());
        return tArray;
    }

    protected t(int n2) {
        super(n2);
    }

    @Override
    protected void a(StringBuffer stringBuffer) {
        super.a(stringBuffer);
        stringBuffer.append(",\n stack={");
        this.a(stringBuffer, this.d, this.b);
        stringBuffer.append("}, locals={");
        this.a(stringBuffer, this.e, this.a);
        stringBuffer.append('}');
    }

    private void a(StringBuffer stringBuffer, int n2, h[] hArray) {
        if (hArray == null) {
            return;
        }
        for (int i2 = 0; i2 < n2; ++i2) {
            h h2;
            if (i2 > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append((h2 = hArray[i2]) == null ? "<>" : h2.toString());
        }
    }

    public boolean a() {
        return this.a != null;
    }

    public void a(int n2, h[] hArray, int n3, h[] hArray2) {
        this.d = n2;
        this.b = hArray;
        this.e = n3;
        this.a = hArray2;
    }

    public void a() {
        if (this.a != null) {
            int n2;
            for (n2 = this.a.length; !(n2 <= 0 || this.a[n2 - 1].a() != s.a || n2 > 1 && this.a[n2 - 2].a()); --n2) {
            }
            this.e = n2;
        }
    }

    void a(int n2, int n3, String string, String string2, boolean bl2, boolean bl3) {
        if (string2.charAt(0) != '(') {
            throw new i("no method descriptor: " + string2);
        }
        this.d = 0;
        this.b = h.a(n2);
        h[] hArray = h.a(n3);
        if (bl3) {
            hArray[0] = new q(string);
        } else if (!bl2) {
            hArray[0] = new m(string);
        }
        int n4 = bl2 ? -1 : 0;
        int n5 = 1;
        try {
            while ((n5 = t.a(string2, n5, ++n4, hArray)) > 0) {
                if (!hArray[n4].a()) continue;
                hArray[++n4] = s.a;
            }
        } catch (StringIndexOutOfBoundsException stringIndexOutOfBoundsException) {
            throw new i("bad method descriptor: " + string2);
        }
        this.e = n4;
        this.a = hArray;
    }

    private static int a(String string, int n2, int n3, h[] hArray) {
        int n4 = n2;
        int n5 = 0;
        char c2 = string.charAt(n2);
        if (c2 == ')') {
            return 0;
        }
        while (c2 == '[') {
            ++n5;
            c2 = string.charAt(++n2);
        }
        if (c2 == 'L') {
            int n6 = string.indexOf(59, ++n2);
            hArray[n3] = n5 > 0 ? new m(string.substring(n4, ++n6)) : new m(string.substring(n4 + 1, ++n6 - 1).replace('/', '.'));
            return n6;
        }
        if (n5 > 0) {
            hArray[n3] = new m(string.substring(n4, ++n2));
            return n2;
        }
        h h2 = t.a(c2);
        if (h2 == null) {
            throw new i("bad method descriptor: " + string);
        }
        hArray[n3] = h2;
        return n2 + 1;
    }

    private static h a(char c2) {
        switch (c2) {
            case 'B': 
            case 'C': 
            case 'I': 
            case 'S': 
            case 'Z': {
                return s.b;
            }
            case 'J': {
                return s.e;
            }
            case 'F': {
                return s.c;
            }
            case 'D': {
                return s.d;
            }
        }
        return null;
    }

    public static String a(String string) {
        int n2 = string.indexOf(41);
        if (n2 < 0) {
            return "java.lang.Object";
        }
        char c2 = string.charAt(n2 + 1);
        if (c2 == '[') {
            return string.substring(n2 + 1);
        }
        if (c2 == 'L') {
            return string.substring(n2 + 2, string.length() - 1).replace('/', '.');
        }
        return "java.lang.Object";
    }
}

