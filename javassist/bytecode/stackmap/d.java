/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javassist.bytecode.T;
import javassist.bytecode.al;
import javassist.bytecode.r;
import javassist.bytecode.stackmap.a;
import javassist.bytecode.stackmap.b;
import javassist.bytecode.stackmap.c;
import javassist.bytecode.stackmap.e;
import javassist.bytecode.u;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class d {
    protected a a(int n2) {
        return new a(n2);
    }

    protected a[] a(int n2) {
        return new a[n2];
    }

    private a[] a(a a2) {
        a[] aArray = this.a(1);
        aArray[0] = a2;
        return aArray;
    }

    private a[] a(a a2, a a3) {
        a[] aArray = this.a(2);
        aArray[0] = a2;
        aArray[1] = a3;
        return aArray;
    }

    public a[] a(al al2) {
        r r2 = al2.a();
        if (r2 == null) {
            return null;
        }
        u u2 = r2.a();
        return this.a(u2, 0, u2.c(), r2.a());
    }

    public a[] a(u u2, int n2, int n3, T t2) {
        Map<Integer, e> map = this.a(u2, n2, n3, t2);
        a[] aArray = this.a(map);
        this.a(aArray, t2);
        return aArray;
    }

    private e a(Map<Integer, e> map, int n2) {
        return this.a(map, n2, true, true);
    }

    private e a(Map<Integer, e> map, int n2, a[] aArray, int n3, boolean bl2) {
        e e2 = this.a(map, n2, false, false);
        e2.a(aArray, n3, bl2);
        return e2;
    }

    private e a(Map<Integer, e> map, int n2, boolean bl2, boolean bl3) {
        Integer n3 = n2;
        e e2 = map.get(n3);
        if (e2 == null) {
            e2 = new e(n2);
            map.put(n3, e2);
        }
        if (bl2) {
            if (e2.a == null) {
                e2.a = this.a(n2);
            }
            if (bl3) {
                ++e2.a.c;
            }
        }
        return e2;
    }

    private Map<Integer, e> a(u u2, int n2, int n3, T t2) {
        int n4;
        u2.a();
        u2.a(n2);
        HashMap<Integer, e> hashMap = new HashMap<Integer, e>();
        while (u2.a() && (n4 = u2.d()) < n3) {
            int n5 = u2.a(n4);
            if (153 <= n5 && n5 <= 166 || n5 == 198 || n5 == 199) {
                e e2 = this.a(hashMap, n4 + u2.d(n4 + 1));
                e e3 = this.a(hashMap, n4 + 3);
                this.a(hashMap, n4, this.a(e2.a, e3.a), 3, false);
                continue;
            }
            if (167 <= n5 && n5 <= 171) {
                switch (n5) {
                    case 167: {
                        this.b(hashMap, n4, n4 + u2.d(n4 + 1), 3);
                        break;
                    }
                    case 168: {
                        this.a(hashMap, n4, n4 + u2.d(n4 + 1), 3);
                        break;
                    }
                    case 169: {
                        this.a(hashMap, n4, null, 2, true);
                        break;
                    }
                    case 170: {
                        int n6;
                        int n7 = (n4 & 0xFFFFFFFC) + 4;
                        int n8 = u2.e(n7 + 4);
                        int n9 = u2.e(n7 + 8);
                        int n10 = n9 - n8 + 1;
                        a[] aArray = this.a(n10 + 1);
                        aArray[0] = this.a(hashMap, (int)(n4 + u2.e((int)n7))).a;
                        int n11 = n6 + n10 * 4;
                        int n12 = 1;
                        for (n6 = n7 + 12; n6 < n11; n6 += 4) {
                            aArray[n12++] = this.a(hashMap, (int)(n4 + u2.e((int)n6))).a;
                        }
                        this.a(hashMap, n4, aArray, n11 - n4, true);
                        break;
                    }
                    case 171: {
                        int n10;
                        int n13 = (n4 & 0xFFFFFFFC) + 4;
                        int n14 = u2.e(n13 + 4);
                        a[] aArray = this.a(n14 + 1);
                        aArray[0] = this.a(hashMap, (int)(n4 + u2.e((int)n13))).a;
                        int n15 = n10 + n14 * 8 - 4;
                        int n6 = 1;
                        for (n10 = n13 + 8 + 4; n10 < n15; n10 += 8) {
                            aArray[n6++] = this.a(hashMap, (int)(n4 + u2.e((int)n10))).a;
                        }
                        this.a(hashMap, n4, aArray, n15 - n4, true);
                        break;
                    }
                }
                continue;
            }
            if (172 <= n5 && n5 <= 177 || n5 == 191) {
                this.a(hashMap, n4, null, 1, true);
                continue;
            }
            if (n5 == 200) {
                this.b(hashMap, n4, n4 + u2.e(n4 + 1), 5);
                continue;
            }
            if (n5 == 201) {
                this.a(hashMap, n4, n4 + u2.e(n4 + 1), 5);
                continue;
            }
            if (n5 != 196 || u2.a(n4 + 1) != 169) continue;
            this.a(hashMap, n4, null, 4, true);
        }
        if (t2 != null) {
            n4 = t2.a();
            while (--n4 >= 0) {
                this.a(hashMap, t2.a(n4), true, false);
                this.a(hashMap, t2.c(n4));
            }
        }
        return hashMap;
    }

    private void b(Map<Integer, e> map, int n2, int n3, int n4) {
        e e2 = this.a(map, n3);
        a[] aArray = this.a(e2.a);
        this.a(map, n2, aArray, n4, true);
    }

    protected void a(Map<Integer, e> map, int n2, int n3, int n4) {
        throw new c();
    }

    private a[] a(Map<Integer, e> map) {
        Object[] objectArray = map.values().toArray(new e[map.size()]);
        Arrays.sort(objectArray);
        ArrayList<a> arrayList = new ArrayList<a>();
        int n2 = 0;
        a a2 = objectArray.length > 0 && ((e)objectArray[0]).a == 0 && ((e)objectArray[0]).a != null ? d.a((e)objectArray[n2++]) : this.a(0);
        arrayList.add(a2);
        while (n2 < objectArray.length) {
            Object object;
            a a3;
            if ((a3 = d.a((e)(object = objectArray[n2++]))) == null) {
                if (a2.b > 0) {
                    a2 = this.a(a2.a + a2.b);
                    arrayList.add(a2);
                }
                a2.b = ((e)object).a + ((e)object).b - a2.a;
                a2.a = ((e)object).a;
                a2.a = ((e)object).a;
                continue;
            }
            if (a2.b == 0) {
                a2.b = ((e)object).a - a2.a;
                ++a3.c;
                a2.a = this.a(a3);
            } else if (a2.a + a2.b < ((e)object).a) {
                a2 = this.a(a2.a + a2.b);
                arrayList.add(a2);
                a2.b = ((e)object).a - a2.a;
                a2.a = true;
                a2.a = this.a(a3);
            }
            arrayList.add(a3);
            a2 = a3;
        }
        return arrayList.toArray(this.a(arrayList.size()));
    }

    private static a a(e e2) {
        a a2 = e2.a;
        if (a2 != null && e2.b > 0) {
            a2.a = e2.a;
            a2.b = e2.b;
            a2.a = e2.a;
        }
        return a2;
    }

    private void a(a[] aArray, T t2) {
        if (t2 == null) {
            return;
        }
        int n2 = t2.a();
        while (--n2 >= 0) {
            a a2 = a.a(aArray, t2.c(n2));
            int n3 = t2.a(n2);
            int n4 = t2.b(n2);
            int n5 = t2.d(n2);
            --a2.c;
            for (int i2 = 0; i2 < aArray.length; ++i2) {
                a a3 = aArray[i2];
                int n6 = a3.a;
                if (n3 > n6 || n6 >= n4) continue;
                a3.a = new b(a2, n5, a3.a);
                ++a2.c;
            }
        }
    }
}

