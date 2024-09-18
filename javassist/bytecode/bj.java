/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.DataInputStream;
import java.util.HashMap;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.bk;
import javassist.bytecode.bl;
import javassist.bytecode.h;
import javassist.bytecode.l;

public class bj
extends h {
    public static final String a = "RuntimeVisibleTypeAnnotations";
    public static final String b = "RuntimeInvisibleTypeAnnotations";

    public bj(J j2, String string, byte[] byArray) {
        super(j2, string, byArray);
    }

    bj(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public int a() {
        return l.a((byte[])this.a, 0);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        bk bk2 = new bk((byte[])this.a, (J)((Object)this.a), j2, map);
        try {
            bk2.b();
            return new bj(j2, this.a(), bk2.a());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    void a(String string, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(string, string2);
        this.a(hashMap);
    }

    @Override
    void a(Map<String, String> map) {
        bl bl2 = new bl((byte[])this.a, this.a(), map);
        try {
            bl2.b();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    void b(Map<String, String> map) {
        this.a(map);
    }
}

