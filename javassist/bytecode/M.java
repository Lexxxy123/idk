/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class m
implements Cloneable {
    private byte[] a;
    private int a = 0;

    public Object clone() {
        m m2 = (m)super.clone();
        m2.a = (byte[])this.a.clone();
        return m2;
    }

    public final int a() {
        return this.a;
    }

    public final byte[] a() {
        byte[] byArray = new byte[this.a];
        System.arraycopy(this.a, 0, byArray, 0, this.a);
        return byArray;
    }

    public int a(int n2) {
        if (n2 < 0 || this.a <= n2) {
            throw new ArrayIndexOutOfBoundsException(n2);
        }
        return this.a[n2];
    }

    public void a(int n2, int n3) {
        if (n2 < 0 || this.a <= n2) {
            throw new ArrayIndexOutOfBoundsException(n2);
        }
        this.a[n2] = (byte)n3;
    }

    public void a(int n2) {
        this.b(1);
        this.a[this.a - 1] = (byte)n2;
    }

    public void b(int n2, int n3) {
        this.b(2);
        this.a[this.a - 2] = (byte)n2;
        this.a[this.a - 1] = (byte)n3;
    }

    public void a(int n2, int n3, int n4, int n5) {
        this.b(4);
        this.a[this.a - 4] = (byte)n2;
        this.a[this.a - 3] = (byte)n3;
        this.a[this.a - 2] = (byte)n4;
        this.a[this.a - 1] = (byte)n5;
    }

    public void b(int n2) {
        if (this.a + n2 > this.a.length) {
            int n3 = this.a << 1;
            if (n3 < this.a + n2) {
                n3 = this.a + n2;
            }
            byte[] byArray = new byte[n3];
            System.arraycopy(this.a, 0, byArray, 0, this.a);
            this.a = byArray;
        }
        this.a += n2;
    }
}

