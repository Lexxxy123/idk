/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import javassist.bytecode.analysis.m;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class e {
    private m[] a;
    private m[] b;
    private int a;
    private boolean a;
    private boolean b;

    public e(int n2, int n3) {
        this.a = new m[n2];
        this.b = new m[n3];
    }

    public m a(int n2) {
        return this.a[n2];
    }

    public void a(int n2, m m2) {
        this.a[n2] = m2;
    }

    public m b(int n2) {
        return this.b[n2];
    }

    public void b(int n2, m m2) {
        this.b[n2] = m2;
    }

    public void a() {
        this.a = 0;
    }

    public int a() {
        return this.a - 1;
    }

    public int b() {
        return this.a.length;
    }

    public m a() {
        if (this.a < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return this.b[this.a - 1];
    }

    public m b() {
        if (this.a < 1) {
            throw new IndexOutOfBoundsException("Stack is empty");
        }
        return this.b[--this.a];
    }

    public void a(m m2) {
        this.b[this.a++] = m2;
    }

    public e a() {
        e e2 = new e(this.a.length, this.b.length);
        System.arraycopy(this.a, 0, e2.a, 0, this.a.length);
        System.arraycopy(this.b, 0, e2.b, 0, this.b.length);
        e2.a = this.a;
        return e2;
    }

    public e b() {
        e e2 = new e(this.a.length, this.b.length);
        System.arraycopy(this.b, 0, e2.b, 0, this.b.length);
        e2.a = this.a;
        return e2;
    }

    public boolean a(e e2) {
        boolean bl2 = false;
        if (this.a != e2.a) {
            throw new RuntimeException("Operand stacks could not be merged, they are different sizes!");
        }
        for (int i2 = 0; i2 < this.a; ++i2) {
            if (this.b[i2] == null) continue;
            m m2 = this.b[i2];
            m m3 = m2.a(e2.b[i2]);
            if (m3 == m.m) {
                throw new RuntimeException("Operand stacks could not be merged due to differing primitive types: pos = " + i2);
            }
            this.b[i2] = m3;
            if (m3.equals(m2) && !m3.a()) continue;
            bl2 = true;
        }
        return bl2;
    }

    public boolean b(e e2) {
        boolean bl2 = false;
        for (int i2 = 0; i2 < this.a.length; ++i2) {
            if (this.a[i2] != null) {
                m m2;
                m m3 = this.a[i2];
                this.a[i2] = m2 = m3.a(e2.a[i2]);
                if (m2.equals(m3) && !m2.a()) continue;
                bl2 = true;
                continue;
            }
            if (e2.a[i2] == null) continue;
            this.a[i2] = e2.a[i2];
            bl2 = true;
        }
        return bl2 |= this.a(e2);
    }

    public String toString() {
        int n2;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("locals = [");
        for (n2 = 0; n2 < this.a.length; ++n2) {
            stringBuffer.append(this.a[n2] == null ? "empty" : this.a[n2].toString());
            if (n2 >= this.a.length - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append("] stack = [");
        for (n2 = 0; n2 < this.a; ++n2) {
            stringBuffer.append(this.b[n2]);
            if (n2 >= this.a - 1) continue;
            stringBuffer.append(", ");
        }
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    boolean a() {
        return this.a;
    }

    void a(boolean bl2) {
        this.a = bl2;
    }

    boolean b() {
        return this.b;
    }

    void b(boolean bl2) {
        this.b = bl2;
    }
}

