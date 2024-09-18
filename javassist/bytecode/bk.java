/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.OutputStream;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.u;
import javassist.bytecode.bm;
import javassist.bytecode.d;

class bk
extends d {
    bm a;

    bk(byte[] byArray, J j2, J j3, Map<String, String> map) {
        super(byArray, j2, j3, map, false);
        u u2 = new u((OutputStream)((Object)this.a), j3);
        this.a = u2;
        this.a = new bm(byArray, j2, j3, map, u2);
    }

    @Override
    int a(int n2, int n3) {
        ((e)((Object)this.a)).b(n3);
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.a[n2] & 0xFF;
            n2 = this.a.b(n2 + 1, n4);
            n2 = this.a.a(n2);
            n2 = this.e(n2);
        }
        return n2;
    }
}

