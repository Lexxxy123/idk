/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.annotation;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import javassist.bytecode.J;
import javassist.bytecode.annotation.e;
import javassist.bytecode.annotation.p;
import javassist.bytecode.annotation.q;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class f
extends p {
    p a;
    p[] a;

    public f(J j2) {
        super('[', j2);
        this.a = null;
        this.a = null;
    }

    public f(p p2, J j2) {
        super('[', j2);
        this.a = p2;
        this.a = null;
    }

    @Override
    Object a(ClassLoader classLoader, javassist.f f2, Method method) {
        Class<?> clazz;
        if (this.a == null) {
            throw new ClassNotFoundException("no array elements found: " + method.getName());
        }
        int n2 = this.a.length;
        if (this.a == null) {
            clazz = method.getReturnType().getComponentType();
            if (clazz == null || n2 > 0) {
                throw new ClassNotFoundException("broken array type: " + method.getName());
            }
        } else {
            clazz = this.a.a(classLoader);
        }
        Object object = Array.newInstance(clazz, n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            Array.set(object, i2, this.a[i2].a(classLoader, f2, method));
        }
        return object;
    }

    @Override
    Class<?> a(ClassLoader classLoader) {
        if (this.a == null) {
            throw new ClassNotFoundException("no array type specified");
        }
        Object object = Array.newInstance(this.a.a(classLoader), 0);
        return object.getClass();
    }

    public p a() {
        return this.a;
    }

    public p[] a() {
        return this.a;
    }

    public void a(p[] pArray) {
        this.a = pArray;
        if (pArray != null && pArray.length > 0) {
            this.a = pArray[0];
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer("{");
        if (this.a != null) {
            for (int i2 = 0; i2 < this.a.length; ++i2) {
                stringBuffer.append(this.a[i2].toString());
                if (i2 + 1 >= this.a.length) continue;
                stringBuffer.append(", ");
            }
        }
        stringBuffer.append("}");
        return stringBuffer.toString();
    }

    @Override
    public void a(e e2) {
        int n2 = this.a == null ? 0 : this.a.length;
        e2.f(n2);
        for (int i2 = 0; i2 < n2; ++i2) {
            this.a[i2].a(e2);
        }
    }

    @Override
    public void a(q q2) {
        q2.a(this);
    }
}

