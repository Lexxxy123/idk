/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import javassist.orgs.slf4j.event.f;
import javassist.orgs.slf4j.helpers.i;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class o {
    final String a;
    final Object[] a;
    final Throwable a;

    public o(String string, Object[] objectArray, Throwable throwable) {
        this.a = string;
        this.a = objectArray;
        this.a = throwable;
    }

    public o(String string, Object[] objectArray) {
        this(string, objectArray, null);
    }

    public String a() {
        return this.a;
    }

    public Object[] a() {
        return this.a;
    }

    public Throwable a() {
        return this.a;
    }

    public static Throwable a(Object[] objectArray) {
        if (objectArray == null || objectArray.length == 0) {
            return null;
        }
        Object object = objectArray[objectArray.length - 1];
        if (object instanceof Throwable) {
            return (Throwable)object;
        }
        return null;
    }

    public static Object[] a(Object[] objectArray) {
        if (objectArray == null || objectArray.length == 0) {
            throw new IllegalStateException("non-sensical empty or null argument array");
        }
        int n2 = objectArray.length - 1;
        Object[] objectArray2 = new Object[n2];
        if (n2 > 0) {
            System.arraycopy(objectArray, 0, objectArray2, 0, n2);
        }
        return objectArray2;
    }

    public static o a(String string, Object[] objectArray, Throwable throwable) {
        if (throwable != null) {
            return new o(string, objectArray, throwable);
        }
        if (objectArray == null || objectArray.length == 0) {
            return new o(string, objectArray, throwable);
        }
        Throwable throwable2 = o.a(objectArray);
        if (throwable2 != null) {
            Object[] objectArray2 = i.a(objectArray);
            return new o(string, objectArray2, throwable2);
        }
        return new o(string, objectArray);
    }

    public static o a(f f2) {
        return o.a(f2.b(), f2.a(), f2.a());
    }
}

