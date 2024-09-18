/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.aA;
import javassist.bytecode.aB;
import javassist.bytecode.aC;
import javassist.bytecode.aD;
import javassist.bytecode.aF;
import javassist.bytecode.aG;
import javassist.bytecode.aH;
import javassist.bytecode.aI;
import javassist.bytecode.aJ;
import javassist.bytecode.ay;
import javassist.bytecode.az;
import javassist.bytecode.h;
import javassist.bytecode.i;
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class aw
extends h {
    public static final String a = "Signature";

    aw(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public aw(J j2, String string) {
        super(j2, a);
        int n2 = j2.c(string);
        byte[] byArray = new byte[]{(byte)(n2 >>> 8), (byte)n2};
        this.a(byArray);
    }

    public String b() {
        return this.a().m(l.a(this.a(), 0));
    }

    public void a(String string) {
        int n2 = this.a().c(string);
        l.a(n2, (byte[])this.a, 0);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        return new aw(j2, this.b());
    }

    @Override
    void a(String string, String string2) {
        String string3 = aw.a(this.b(), string, string2);
        this.a(string3);
    }

    @Override
    void a(Map<String, String> map) {
        String string = aw.a(this.b(), map);
        this.a(string);
    }

    static String a(String string, String string2, String string3) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(string2, string3);
        return aw.a(string, hashMap);
    }

    static String a(String string, Map<String, String> map) {
        int n2;
        if (map == null) {
            return string;
        }
        StringBuilder stringBuilder = new StringBuilder();
        int n3 = 0;
        int n4 = 0;
        while ((n2 = string.indexOf(76, n4)) >= 0) {
            char c2;
            StringBuilder stringBuilder2 = new StringBuilder();
            int n5 = n2;
            try {
                while ((c2 = string.charAt(++n5)) != ';') {
                    stringBuilder2.append(c2);
                    if (c2 != '<') continue;
                    while ((c2 = string.charAt(++n5)) != '>') {
                        stringBuilder2.append(c2);
                    }
                    stringBuilder2.append(c2);
                }
            } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
                break;
            }
            n4 = n5 + 1;
            String string2 = stringBuilder2.toString();
            String string3 = map.get(string2);
            if (string3 == null) continue;
            stringBuilder.append(string.substring(n3, n2));
            stringBuilder.append('L');
            stringBuilder.append(string3);
            stringBuilder.append(c2);
            n3 = n4;
        }
        if (n3 == 0) {
            return string;
        }
        n2 = string.length();
        if (n3 < n2) {
            stringBuilder.append(string.substring(n3, n2));
        }
        return stringBuilder.toString();
    }

    private static boolean a(int n2) {
        return n2 != 59 && n2 != 60;
    }

    public static aA a(String string) {
        try {
            return aw.b(string);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw aw.b(string);
        }
    }

    public static aD a(String string) {
        try {
            return aw.b(string);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw aw.b(string);
        }
    }

    public static aF a(String string) {
        try {
            return aw.a(string, new aC(null), false);
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw aw.b(string);
        }
    }

    public static aG a(String string) {
        try {
            return aw.a(string, new aC(null));
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            throw aw.b(string);
        }
    }

    private static aA b(String string) {
        aC aC2 = new aC(null);
        aI[] aIArray = aw.a(string, aC2);
        aB aB2 = aw.a(string, aC2);
        int n2 = string.length();
        ArrayList<aB> arrayList = new ArrayList<aB>();
        while (aC2.a < n2 && string.charAt(aC2.a) == 'L') {
            arrayList.add(aw.a(string, aC2));
        }
        aB[] aBArray = arrayList.toArray(new aB[arrayList.size()]);
        return new aA(aIArray, aB2, aBArray);
    }

    private static aD b(String string) {
        Object object;
        aG aG2;
        aC aC2 = new aC(null);
        aI[] aIArray = aw.a(string, aC2);
        if (string.charAt(aC2.a++) != '(') {
            throw aw.b(string);
        }
        ArrayList<aG> arrayList = new ArrayList<aG>();
        while (string.charAt(aC2.a) != ')') {
            aG2 = aw.a(string, aC2);
            arrayList.add(aG2);
        }
        ++aC2.a;
        aG2 = aw.a(string, aC2);
        int n2 = string.length();
        ArrayList<aG[]> arrayList2 = new ArrayList<aG[]>();
        while (aC2.a < n2 && string.charAt(aC2.a) == '^') {
            ++aC2.a;
            object = aw.a(string, aC2, false);
            if (object instanceof ay) {
                throw aw.b(string);
            }
            arrayList2.add((aG[])object);
        }
        object = arrayList.toArray(new aG[arrayList.size()]);
        aF[] aFArray = arrayList2.toArray(new aF[arrayList2.size()]);
        return new aD(aIArray, (aG[])object, aG2, aFArray);
    }

    private static aI[] a(String string, aC aC2) {
        ArrayList<Object> arrayList = new ArrayList<Object>();
        if (string.charAt(aC2.a) == '<') {
            ++aC2.a;
            while (string.charAt(aC2.a) != '>') {
                Object object;
                int n2 = aC2.a;
                int n3 = aC2.a(string, 58);
                aF aF2 = aw.a(string, aC2, true);
                ArrayList<aF> arrayList2 = new ArrayList<aF>();
                while (string.charAt(aC2.a) == ':') {
                    ++aC2.a;
                    object = aw.a(string, aC2, false);
                    arrayList2.add((aF)object);
                }
                object = new aI(string, n2, n3, aF2, arrayList2.toArray(new aF[arrayList2.size()]));
                arrayList.add(object);
            }
            ++aC2.a;
        }
        return arrayList.toArray(new aI[arrayList.size()]);
    }

    private static aF a(String string, aC aC2, boolean bl2) {
        int n2 = aC2.a;
        switch (string.charAt(n2)) {
            case 'L': {
                return aw.a(string, aC2, null);
            }
            case 'T': {
                int n3 = aC2.a(string, 59);
                return new aJ(string, n2 + 1, n3);
            }
            case '[': {
                return aw.a(string, aC2);
            }
        }
        if (bl2) {
            return null;
        }
        throw aw.b(string);
    }

    private static aB a(String string, aC aC2) {
        if (string.charAt(aC2.a) == 'L') {
            return aw.a(string, aC2, null);
        }
        throw aw.b(string);
    }

    private static aB a(String string, aC aC2, aB aB2) {
        aH[] aHArray;
        char c2;
        int n2 = ++aC2.a;
        while ((c2 = string.charAt(aC2.a++)) != '$' && c2 != '<' && c2 != ';') {
        }
        int n3 = aC2.a - 1;
        if (c2 == '<') {
            aHArray = aw.a(string, aC2);
            c2 = string.charAt(aC2.a++);
        } else {
            aHArray = null;
        }
        aB aB3 = aB.a(string, n2, n3, aHArray, aB2);
        if (c2 == '$' || c2 == '.') {
            --aC2.a;
            return aw.a(string, aC2, aB3);
        }
        return aB3;
    }

    private static aH[] a(String string, aC aC2) {
        char c2;
        ArrayList<aH> arrayList = new ArrayList<aH>();
        while ((c2 = string.charAt(aC2.a++)) != '>') {
            aH aH2;
            if (c2 == '*') {
                aH2 = new aH(null, '*');
            } else {
                if (c2 != '+' && c2 != '-') {
                    c2 = ' ';
                    --aC2.a;
                }
                aH2 = new aH(aw.a(string, aC2, false), c2);
            }
            arrayList.add(aH2);
        }
        return arrayList.toArray(new aH[arrayList.size()]);
    }

    private static aF a(String string, aC aC2) {
        int n2 = 1;
        while (string.charAt(++aC2.a) == '[') {
            ++n2;
        }
        return new ay(n2, aw.a(string, aC2));
    }

    private static aG a(String string, aC aC2) {
        aG aG2 = aw.a(string, aC2, true);
        if (aG2 == null) {
            aG2 = new az(string.charAt(aC2.a++));
        }
        return aG2;
    }

    private static i b(String string) {
        return new i("bad signature: " + string);
    }

    static /* synthetic */ i a(String string) {
        return aw.b(string);
    }
}

