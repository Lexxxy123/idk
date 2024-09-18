/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.spi;

import java.util.function.Supplier;
import javassist.orgs.slf4j.c;
import javassist.orgs.slf4j.event.d;
import javassist.orgs.slf4j.event.f;
import javassist.orgs.slf4j.event.g;
import javassist.orgs.slf4j.h;
import javassist.orgs.slf4j.spi.e;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class a
implements e {
    javassist.orgs.slf4j.event.a a;
    c a;
    private static /* synthetic */ int[] a;

    public a(c c2, javassist.orgs.slf4j.event.e e2) {
        this.a = c2;
        this.a = new javassist.orgs.slf4j.event.a(e2, c2);
    }

    @Override
    public e a(h h2) {
        this.a.a(h2);
        return this;
    }

    @Override
    public e a(Throwable throwable) {
        this.a.a(throwable);
        return this;
    }

    @Override
    public e a(Object object) {
        this.a.a(object);
        return this;
    }

    @Override
    public e a(Supplier<Object> supplier) {
        this.a.a(supplier.get());
        return this;
    }

    @Override
    public void a(String string) {
        this.a.a(string);
        this.a(this.a);
    }

    @Override
    public void a(String string, Object object) {
        this.a.a(string);
        this.a.a(object);
        this.a(this.a);
    }

    @Override
    public void a(String string, Object object, Object object2) {
        this.a.a(string);
        this.a.a(object);
        this.a.a(object2);
        this.a(this.a);
    }

    @Override
    public void a(String string, Object ... objectArray) {
        this.a.a(string);
        this.a.a(objectArray);
        this.a(this.a);
    }

    private void a(f f2) {
        if (this.a instanceof g) {
            ((g)((Object)this.a)).a(f2);
        } else {
            this.b(f2);
        }
    }

    private void b(f f2) {
        Object[] objectArray = f2.a();
        int n2 = objectArray == null ? 0 : objectArray.length;
        Throwable throwable = f2.a();
        int n3 = throwable == null ? 0 : 1;
        String string = f2.b();
        Object[] objectArray2 = new Object[n2 + n3];
        if (objectArray != null) {
            System.arraycopy(objectArray, 0, objectArray2, 0, n2);
        }
        if (throwable != null) {
            objectArray2[n2] = throwable;
        }
        string = this.a(f2, string);
        switch (javassist.orgs.slf4j.spi.a.a()[f2.a().ordinal()]) {
            case 5: {
                this.a.a(string, objectArray2);
                break;
            }
            case 4: {
                this.a.b(string, objectArray2);
                break;
            }
            case 3: {
                this.a.c(string, objectArray2);
                break;
            }
            case 2: {
                this.a.d(string, objectArray2);
                break;
            }
            case 1: {
                this.a.e(string, objectArray2);
            }
        }
    }

    private String a(f f2, String string) {
        StringBuilder stringBuilder = null;
        if (this.a.a() != null) {
            stringBuilder = new StringBuilder();
            for (h object : f2.a()) {
                stringBuilder.append(object);
                stringBuilder.append(' ');
            }
        }
        if (f2.c() != null) {
            if (stringBuilder == null) {
                stringBuilder = new StringBuilder();
            }
            for (d d2 : f2.c()) {
                stringBuilder.append(d2.a);
                stringBuilder.append('=');
                stringBuilder.append(d2.a);
                stringBuilder.append(' ');
            }
        }
        if (stringBuilder != null) {
            stringBuilder.append(string);
            return stringBuilder.toString();
        }
        return string;
    }

    @Override
    public void a(Supplier<String> supplier) {
        if (supplier == null) {
            this.a((String)null);
        } else {
            this.a(supplier.get());
        }
    }

    @Override
    public e a(String string, Object object) {
        this.a.a(string, object);
        return this;
    }

    @Override
    public e a(String string, Supplier<Object> supplier) {
        this.a.a(string, supplier.get());
        return this;
    }

    static /* synthetic */ int[] a() {
        if (a != null) {
            return a;
        }
        int[] nArray = new int[javassist.orgs.slf4j.event.e.values().length];
        try {
            nArray[javassist.orgs.slf4j.event.e.d.ordinal()] = 4;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.slf4j.event.e.a.ordinal()] = 1;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.slf4j.event.e.c.ordinal()] = 3;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.slf4j.event.e.e.ordinal()] = 5;
        } catch (NoSuchFieldError noSuchFieldError) {}
        try {
            nArray[javassist.orgs.slf4j.event.e.b.ordinal()] = 2;
        } catch (NoSuchFieldError noSuchFieldError) {}
        a = nArray;
        return nArray;
    }
}

