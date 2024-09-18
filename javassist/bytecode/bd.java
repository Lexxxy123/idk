/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode;

import javassist.bytecode.bf;
import javassist.bytecode.bg;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class bd
extends bf {
    private bg a;

    public bd(byte[] byArray) {
        super(byArray);
        this.a = new bg(byArray.length);
    }

    public byte[] a() {
        this.b();
        return this.a.a();
    }

    @Override
    public void a(int n2, int n3) {
        this.a.a(n3);
    }

    @Override
    public void a(int n2, int n3, int n4, int n5) {
        this.a.a(n3, n4, this.a(n4, n5));
    }

    @Override
    public void b(int n2, int n3, int n4) {
        this.a.a(n3, n4);
    }

    @Override
    public void a(int n2, int n3, int[] nArray, int[] nArray2) {
        this.a.a(n3, nArray, this.a(nArray, nArray2));
    }

    @Override
    public void a(int n2, int n3, int[] nArray, int[] nArray2, int[] nArray3, int[] nArray4) {
        this.a.a(n3, nArray, this.a(nArray, nArray2), nArray3, this.a(nArray3, nArray4));
    }

    protected int a(int n2, int n3) {
        return n3;
    }

    protected int[] a(int[] nArray, int[] nArray2) {
        return nArray2;
    }
}

