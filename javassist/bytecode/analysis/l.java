/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javassist.bytecode.T;
import javassist.bytecode.al;
import javassist.bytecode.analysis.k;
import javassist.bytecode.analysis.n;
import javassist.bytecode.at;
import javassist.bytecode.r;
import javassist.bytecode.u;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class l
implements at {
    private k[] a;
    Map<Integer, k> a;
    Set<Integer> a = new HashSet();

    public k[] a(al al2) {
        r r2 = al2.a();
        u u2 = r2.a();
        this.a = new k[r2.e()];
        this.a.clear();
        this.a.clear();
        this.a(0, u2, null);
        T t2 = r2.a();
        for (int i2 = 0; i2 < t2.a(); ++i2) {
            int n2 = t2.c(i2);
            this.a(n2, u2, this.a[t2.a(i2)]);
        }
        return this.a;
    }

    private void a(int n2, u u2, k k2) {
        boolean bl2;
        if (this.a.contains(n2)) {
            return;
        }
        this.a.add(n2);
        int n3 = u2.e();
        u2.a(n2);
        while (bl2 = this.a(n2 = u2.d(), u2, k2) && u2.a()) {
        }
        u2.a(n3);
    }

    private boolean a(int n2, u u2, k k2) {
        this.a[n2] = k2;
        int n3 = u2.a(n2);
        if (n3 == 170) {
            this.c(n2, u2, k2);
            return false;
        }
        if (n3 == 171) {
            this.b(n2, u2, k2);
            return false;
        }
        if (n.d(n3) || n3 == 169 || n3 == 191) {
            return false;
        }
        if (n.a(n3)) {
            int n4 = n.a(n2, u2);
            if (n3 == 168 || n3 == 201) {
                k k3 = (k)this.a.get(n4);
                if (k3 == null) {
                    k3 = new k(n4, n2);
                    this.a.put(n4, k3);
                    this.a(n4, u2, k3);
                } else {
                    k3.a(n2);
                }
            } else {
                this.a(n4, u2, k2);
                if (n.b(n3)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void b(int n2, u u2, k k2) {
        int n3 = (n2 & 0xFFFFFFFC) + 4;
        this.a(n2 + u2.e(n3), u2, k2);
        int n4 = u2.e(n3 += 4);
        int n5 = n4 * 8 + (n3 += 4);
        n3 += 4;
        while (n3 < n5) {
            int n6 = u2.e(n3) + n2;
            this.a(n6, u2, k2);
            n3 += 8;
        }
    }

    private void c(int n2, u u2, k k2) {
        int n3 = (n2 & 0xFFFFFFFC) + 4;
        this.a(n2 + u2.e(n3), u2, k2);
        int n4 = u2.e(n3 += 4);
        int n5 = u2.e(n3 += 4);
        int n6 = (n5 - n4 + 1) * 4 + (n3 += 4);
        while (n3 < n6) {
            int n7 = u2.e(n3) + n2;
            this.a(n7, u2, k2);
            n3 += 4;
        }
    }
}

