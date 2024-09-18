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
import javassist.bytecode.l;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class c
extends h {
    public static final String a = "RuntimeVisibleAnnotations";
    public static final String b = "RuntimeInvisibleAnnotations";

    public c(J j2, String string, byte[] byArray) {
        super(j2, string, byArray);
    }

    public c(J j2, String string) {
        this(j2, string, new byte[]{0, 0});
    }

    c(J j2, int n2, DataInputStream dataInputStream) {
        super(j2, n2, dataInputStream);
    }

    public int a() {
        return l.a((byte[])this.a, 0);
    }

    @Override
    public h a(J j2, Map<String, String> map) {
        d d2 = new d((byte[])this.a, (J)((Object)this.a), j2, map);
        try {
            d2.b();
            return new c(j2, this.a(), d2.a());
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public a a(String string) {
        a[] aArray = this.a();
        for (int i2 = 0; i2 < aArray.length; ++i2) {
            if (!aArray[i2].a().equals(string)) continue;
            return aArray[i2];
        }
        return null;
    }

    public void a(a a2) {
        String string = a2.a();
        a[] aArray = this.a();
        for (int i2 = 0; i2 < aArray.length; ++i2) {
            if (!aArray[i2].a().equals(string)) continue;
            aArray[i2] = a2;
            this.a(aArray);
            return;
        }
        a[] aArray2 = new a[aArray.length + 1];
        System.arraycopy(aArray, 0, aArray2, 0, aArray.length);
        aArray2[aArray.length] = a2;
        this.a(aArray2);
    }

    public boolean a(String string) {
        a[] aArray = this.a();
        for (int i2 = 0; i2 < aArray.length; ++i2) {
            if (!aArray[i2].a().equals(string)) continue;
            a[] aArray2 = new a[aArray.length - 1];
            System.arraycopy(aArray, 0, aArray2, 0, i2);
            if (i2 < aArray.length - 1) {
                System.arraycopy(aArray, i2 + 1, aArray2, i2, aArray.length - i2 - 1);
            }
            this.a(aArray2);
            return true;
        }
        return false;
    }

    public a[] a() {
        try {
            return new e((byte[])this.a, (J)((Object)this.a)).a();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    public void a(a[] aArray) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        javassist.bytecode.annotation.e e2 = new javassist.bytecode.annotation.e(byteArrayOutputStream, (J)((Object)this.a));
        try {
            int n2 = aArray.length;
            e2.b(n2);
            for (int i2 = 0; i2 < n2; ++i2) {
                aArray[i2].a(e2);
            }
            e2.a();
        } catch (IOException iOException) {
            throw new RuntimeException(iOException);
        }
        this.a(byteArrayOutputStream.toByteArray());
    }

    public void b(a a2) {
        this.a(new a[]{a2});
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
            f2.b();
        } catch (Exception exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    void b(Map<String, String> map) {
        this.a(map);
    }

    public String toString() {
        a[] aArray = this.a();
        StringBuilder stringBuilder = new StringBuilder();
        int n2 = 0;
        while (n2 < aArray.length) {
            stringBuilder.append(aArray[n2++].toString());
            if (n2 == aArray.length) continue;
            stringBuilder.append(", ");
        }
        return stringBuilder.toString();
    }
}

