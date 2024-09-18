/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist;

import javassist.CtClass;
import javassist.Z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public abstract class G {
    G a;
    protected CtClass a;

    protected G(CtClass ctClass) {
        this.a = ctClass;
        this.a = null;
    }

    final G a() {
        return this.a;
    }

    void a() {
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(this.getClass().getName());
        stringBuffer.append("@");
        stringBuffer.append(Integer.toHexString(this.hashCode()));
        stringBuffer.append("[");
        stringBuffer.append(Z.a(this.a()));
        this.a(stringBuffer);
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    protected abstract void a(StringBuffer var1);

    public CtClass a() {
        return this.a;
    }

    public boolean a(CtClass ctClass) {
        int n2 = this.a();
        if (Z.a(n2)) {
            return true;
        }
        if (Z.b(n2)) {
            return ctClass == this.a;
        }
        String string = this.a.c();
        String string2 = ctClass.c();
        boolean bl2 = string == null ? string2 == null : string.equals(string2);
        if (!bl2 && Z.c(n2)) {
            return ctClass.b(this.a);
        }
        return bl2;
    }

    public abstract int a();

    public abstract void a(int var1);

    public boolean a(Class<?> clazz) {
        return this.a(clazz.getName());
    }

    public abstract boolean a(String var1);

    public abstract Object a(Class<?> var1);

    public abstract Object[] a();

    public abstract Object[] b();

    public abstract String d();

    public abstract String b();

    public abstract String c();

    public abstract void a(String var1);

    public abstract byte[] a(String var1);

    public abstract void a(String var1, byte[] var2);
}

