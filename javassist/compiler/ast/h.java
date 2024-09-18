/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler.ast;

import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.x;

public class h
extends a {
    private static final long a = 1L;

    public h(b b2, b b3, b b4) {
        super(b2, new a(b3, new a(b4)));
    }

    public b d() {
        return this.c();
    }

    public void d(b b2) {
        this.c(b2);
    }

    public b e() {
        return ((a)this.a()).c();
    }

    public void e(b b2) {
        ((a)this.a()).c(b2);
    }

    public b f() {
        return ((a)((a)this.a()).a()).c();
    }

    public void f(b b2) {
        ((a)((a)this.a()).a()).c(b2);
    }

    @Override
    public String a() {
        return "?:";
    }

    @Override
    public void a(x x2) {
        x2.a(this);
    }
}

