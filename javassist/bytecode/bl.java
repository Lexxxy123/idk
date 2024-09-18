/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.bn;
import javassist.bytecode.f;

class bl
extends f {
    bn a;

    bl(byte[] byArray, J j2, Map<String, String> map) {
        super(byArray, j2, map);
        this.a = new bn(byArray);
    }

    @Override
    int a(int n2, int n3) {
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4 = this.a[n2] & 0xFF;
            n2 = this.a.b(n2 + 1, n4);
            n2 = this.a.a(n2);
            n2 = this.e(n2);
        }
        return n2;
    }
}

