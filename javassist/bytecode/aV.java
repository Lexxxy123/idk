/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javassist.bytecode.J;
import javassist.bytecode.annotation.a;
import javassist.bytecode.d;
import javassist.bytecode.e;
import javassist.bytecode.f;
import javassist.bytecode.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class av
extends h {
    public static final String a = "RuntimeVisibleParameterAnnotations";
    public static final String b = "RuntimeInvisibleParameterAnnotations";

    public av(J j2, String string, byte[] byArray) {
        super(j2, string, byArray);
    }

    public av(J j2, String string) {
        this(j2, string, new byte[]{0});
    }

    av(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public int a() {
        return this.a[0] & 0xFF;
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        d d2 = new d((byte[])this.a, (J)((Object)this.a), j2, map);
        try {
            d2.a();
            return new av(j2, this.a(), d2.a());
        } catch (Exception exception) {
            throw new RuntimeException(exception.toString());
        }
    }

    public a[][] a() {
        try {
            return new e((byte[])this.a, (J)((Object)this.a)).a();
        } catch (Exception exception) {
            throw new RuntimeException(exception.toString());
        }
    }

    public void a(a[][] aArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        javassist.bytecode.annotation.e e2 = new javassist.bytecode.annotation.e(byteArrayOutputStream, (J)((Object)this.a));
        try {
            e2.a(aArray.length);
            for (a[] aArray2 : aArray) {
                e2.b(aArray2.length);
                for (int i2 = 0; i2 < aArray2.length; ++i2) {
                    aArray2[i2].a(e2);
                }
            }
            e2.a();
        } catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        this.a(byteArrayOutputStream.toByteArray());
    }

    @Override
    void a(String string, String string2) {
        HashMap<String, String> hashMap = new HashMap<String, String>();
        hashMap.put(string, string2);
        this.a(hashMap);
    }

    @Override
    void a(Map<String, String> map) {
        f f2 = new f((byte[])this.a, this.a(), map);
        try {
            f2.a();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    void b(Map<String, String> map) {
        this.a(map);
    }

    public String toString() {
        a[][] aArray = this.a();
        StringBuilder stringBuilder = new StringBuilder();
        a[][] aArray2 = aArray;
        int n2 = aArray2.length;
        for (int i2 = 0; i2 < n2; ++i2) {
            a[] aArray3;
            for (a a2 : aArray3 = aArray2[i2]) {
                stringBuilder.append(a2.toString()).append(" ");
            }
            stringBuilder.append(", ");
        }
        return stringBuilder.toString().replaceAll(" (?=,)|, $", "");
    }
}

