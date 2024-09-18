/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.compiler;

import java.io.Serializable;
import javassist.compiler.ast.a;
import javassist.compiler.ast.b;
import javassist.compiler.ast.c;
import javassist.compiler.ast.d;
import javassist.compiler.ast.f;
import javassist.compiler.ast.g;
import javassist.compiler.ast.h;
import javassist.compiler.ast.i;
import javassist.compiler.ast.j;
import javassist.compiler.ast.k;
import javassist.compiler.ast.l;
import javassist.compiler.ast.m;
import javassist.compiler.ast.o;
import javassist.compiler.ast.p;
import javassist.compiler.ast.q;
import javassist.compiler.ast.r;
import javassist.compiler.ast.s;
import javassist.compiler.ast.t;
import javassist.compiler.ast.v;
import javassist.compiler.e;
import javassist.compiler.n;
import javassist.compiler.w;
import javassist.compiler.x;
import javassist.compiler.z;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public final class u
implements z {
    private n a;
    private static final int[] b = new int[]{0, 0, 0, 0, 1, 6, 0, 0, 0, 1, 2, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 4, 0};

    public u(n n2) {
        this.a = n2;
    }

    public boolean a() {
        return this.a.b() >= 0;
    }

    public a a(w w2) {
        a a2 = this.b(w2);
        if (a2 instanceof q) {
            return this.a(w2, (q)a2);
        }
        return a2;
    }

    public a b(w w2) {
        a a2;
        a a3 = this.a();
        boolean bl2 = false;
        if (this.a.b() == 400 && this.a.a(1) == 40) {
            a2 = new i(344, 0);
            bl2 = true;
        } else {
            a2 = this.a(w2);
        }
        if (this.a.a() != 400) {
            throw new x(this.a);
        }
        String string = bl2 ? "<init>" : this.a.a();
        ((i)a2).a(new v(string));
        if (bl2 || this.a.b() == 40) {
            return this.a(w2, bl2, a3, (i)a2);
        }
        return this.a(w2, a3, (i)a2);
    }

    private l a(w w2, a a2, i i2) {
        int n2;
        b b2 = null;
        if (this.a.b() == 61) {
            this.a.a();
            b2 = this.a(w2);
        }
        if ((n2 = this.a.a()) == 59) {
            return new l(a2, new a(i2, new a(b2)));
        }
        if (n2 == 44) {
            throw new e("only one field can be declared in one declaration", this.a);
        }
        throw new x(this.a);
    }

    private q a(w w2, boolean bl2, a a2, i i2) {
        if (this.a.a() != 40) {
            throw new x(this.a);
        }
        a a3 = null;
        if (this.a.b() != 41) {
            while (true) {
                a3 = javassist.compiler.ast.a.a(a3, (b)this.b(w2));
                int n2 = this.a.b();
                if (n2 == 44) {
                    this.a.a();
                    continue;
                }
                if (n2 == 41) break;
            }
        }
        this.a.a();
        i2.a(this.a());
        if (bl2 && i2.c() > 0) {
            throw new x(this.a);
        }
        a a4 = null;
        if (this.a.b() == 341) {
            this.a.a();
            while (true) {
                a4 = javassist.compiler.ast.a.a(a4, this.c(w2));
                if (this.a.b() != 44) break;
                this.a.a();
            }
        }
        return new q(a2, new a(i2, javassist.compiler.ast.a.a(a3, a4, null)));
    }

    public q a(w w2, q q2) {
        a a2 = null;
        if (this.a.b() == 59) {
            this.a.a();
        } else {
            a2 = this.b(w2);
            if (a2 == null) {
                a2 = new t(66);
            }
        }
        q2.a(4).c(a2);
        return q2;
    }

    private a a() {
        int n2;
        a a2 = null;
        while ((n2 = this.a.b()) == 300 || n2 == 315 || n2 == 332 || n2 == 331 || n2 == 330 || n2 == 338 || n2 == 335 || n2 == 345 || n2 == 342 || n2 == 347) {
            a2 = new a(new o(this.a.a()), a2);
        }
        return a2;
    }

    private i a(w w2) {
        int n2 = this.a.b();
        if (u.a(n2) || n2 == 344) {
            this.a.a();
            int n3 = this.a();
            return new i(n2, n3);
        }
        b b2 = this.c(w2);
        int n4 = this.a();
        return new i((a)b2, n4);
    }

    private static boolean a(int n2) {
        return n2 == 301 || n2 == 303 || n2 == 306 || n2 == 334 || n2 == 324 || n2 == 326 || n2 == 317 || n2 == 312;
    }

    private i b(w w2) {
        a a2 = this.a(w2);
        if (this.a.a() != 400) {
            throw new x(this.a);
        }
        String string = this.a.a();
        ((i)a2).a(new v(string));
        ((i)a2).a(this.a());
        w2.a(string, (i)a2);
        return a2;
    }

    public t a(w w2) {
        int n2 = this.a.b();
        if (n2 == 123) {
            return this.b(w2);
        }
        if (n2 == 59) {
            this.a.a();
            return new t(66);
        }
        if (n2 == 400 && this.a.a(1) == 58) {
            this.a.a();
            String string = this.a.a();
            this.a.a();
            return t.a(76, (b)new v(string), (b)this.a(w2));
        }
        if (n2 == 320) {
            return this.c(w2);
        }
        if (n2 == 346) {
            return this.d(w2);
        }
        if (n2 == 311) {
            return this.e(w2);
        }
        if (n2 == 318) {
            return this.f(w2);
        }
        if (n2 == 343) {
            return this.k(w2);
        }
        if (n2 == 337) {
            return this.g(w2);
        }
        if (n2 == 338) {
            return this.j(w2);
        }
        if (n2 == 333) {
            return this.l(w2);
        }
        if (n2 == 340) {
            return this.m(w2);
        }
        if (n2 == 302) {
            return this.n(w2);
        }
        if (n2 == 309) {
            return this.o(w2);
        }
        return this.a(w2, false);
    }

    private t b(w w2) {
        if (this.a.a() != 123) {
            throw new x(this.a);
        }
        t t2 = null;
        w w3 = new w(w2);
        while (this.a.b() != 125) {
            a a2 = this.a(w3);
            if (a2 == null) continue;
            t2 = (t)javassist.compiler.ast.a.a(t2, new t(66, (b)a2));
        }
        this.a.a();
        if (t2 == null) {
            return new t(66);
        }
        return t2;
    }

    private t c(w w2) {
        a a2;
        int n2 = this.a.a();
        b b2 = this.c(w2);
        a a3 = this.a(w2);
        if (this.a.b() == 313) {
            this.a.a();
            a2 = this.a(w2);
        } else {
            a2 = null;
        }
        return new t(n2, b2, new a(a3, new a(a2)));
    }

    private t d(w w2) {
        int n2 = this.a.a();
        b b2 = this.c(w2);
        a a2 = this.a(w2);
        return new t(n2, b2, a2);
    }

    private t e(w w2) {
        int n2 = this.a.a();
        a a2 = this.a(w2);
        if (this.a.a() != 346 || this.a.a() != 40) {
            throw new x(this.a);
        }
        b b2 = this.a(w2);
        if (this.a.a() != 41 || this.a.a() != 59) {
            throw new x(this.a);
        }
        return new t(n2, b2, a2);
    }

    private t f(w w2) {
        t t2;
        int n2 = this.a.a();
        w w3 = new w(w2);
        if (this.a.a() != 40) {
            throw new x(this.a);
        }
        if (this.a.b() == 59) {
            this.a.a();
            t2 = null;
        } else {
            t2 = this.a(w3, true);
        }
        b b2 = this.a.b() == 59 ? null : this.a(w3);
        if (this.a.a() != 59) {
            throw new e("; is missing", this.a);
        }
        t t3 = this.a.b() == 41 ? null : this.p(w3);
        if (this.a.a() != 41) {
            throw new e(") is missing", this.a);
        }
        a a2 = this.a(w3);
        return new t(n2, t2, new a(b2, new a(t3, a2)));
    }

    private t g(w w2) {
        int n2 = this.a.a();
        b b2 = this.c(w2);
        t t2 = this.h(w2);
        return new t(n2, b2, t2);
    }

    private t h(w w2) {
        if (this.a.a() != 123) {
            throw new x(this.a);
        }
        w w3 = new w(w2);
        t t2 = this.i(w3);
        if (t2 == null) {
            throw new e("empty switch block", this.a);
        }
        int n2 = t2.b();
        if (n2 != 304 && n2 != 310) {
            throw new e("no case or default in a switch block", this.a);
        }
        t t3 = new t(66, (b)t2);
        while (this.a.b() != 125) {
            t t4 = this.i(w3);
            if (t4 == null) continue;
            int n3 = t4.b();
            if (n3 == 304 || n3 == 310) {
                t3 = (t)javassist.compiler.ast.a.a((a)t3, new t(66, (b)t4));
                t2 = t4;
                continue;
            }
            t2 = (t)javassist.compiler.ast.a.a((a)t2, new t(66, (b)t4));
        }
        this.a.a();
        return t3;
    }

    private t i(w w2) {
        int n2 = this.a.b();
        if (n2 != 304 && n2 != 310) {
            return this.a(w2);
        }
        this.a.a();
        t t2 = n2 == 304 ? new t(n2, this.a(w2)) : new t(310);
        if (this.a.a() != 58) {
            throw new e(": is missing", this.a);
        }
        return t2;
    }

    private t j(w w2) {
        int n2 = this.a.a();
        if (this.a.a() != 40) {
            throw new x(this.a);
        }
        b b2 = this.a(w2);
        if (this.a.a() != 41) {
            throw new x(this.a);
        }
        a a2 = this.b(w2);
        return new t(n2, b2, a2);
    }

    private t k(w w2) {
        Serializable serializable;
        this.a.a();
        a a2 = this.b(w2);
        a a3 = null;
        while (this.a.b() == 305) {
            this.a.a();
            if (this.a.a() != 40) {
                throw new x(this.a);
            }
            serializable = new w(w2);
            a a4 = this.b((w)serializable);
            if (((i)a4).c() > 0 || ((i)a4).b() != 307) {
                throw new x(this.a);
            }
            if (this.a.a() != 41) {
                throw new x(this.a);
            }
            a a5 = this.b((w)serializable);
            a3 = javassist.compiler.ast.a.a(a3, new s(a4, a5));
        }
        serializable = null;
        if (this.a.b() == 316) {
            this.a.a();
            serializable = this.b(w2);
        }
        return t.a(343, a2, a3, serializable);
    }

    private t l(w w2) {
        int n2 = this.a.a();
        t t2 = new t(n2);
        if (this.a.b() != 59) {
            t2.a(this.a(w2));
        }
        if (this.a.a() != 59) {
            throw new e("; is missing", this.a);
        }
        return t2;
    }

    private t m(w w2) {
        int n2 = this.a.a();
        b b2 = this.a(w2);
        if (this.a.a() != 59) {
            throw new e("; is missing", this.a);
        }
        return new t(n2, b2);
    }

    private t n(w w2) {
        return this.o(w2);
    }

    private t o(w w2) {
        int n2 = this.a.a();
        t t2 = new t(n2);
        int n3 = this.a.a();
        if (n3 == 400) {
            t2.a(new v(this.a.a()));
            n3 = this.a.a();
        }
        if (n3 != 59) {
            throw new e("; is missing", this.a);
        }
        return t2;
    }

    private t a(w w2, boolean bl2) {
        int n2;
        int n3 = this.a.b();
        while (n3 == 315) {
            this.a.a();
            n3 = this.a.b();
        }
        if (u.a(n3)) {
            n3 = this.a.a();
            int n4 = this.a();
            return this.a(w2, new i(n3, n4));
        }
        if (n3 == 400 && (n2 = this.b(0)) >= 0 && this.a.a(n2) == 400) {
            b b2 = this.c(w2);
            int n5 = this.a();
            return this.a(w2, new i((a)b2, n5));
        }
        t t2 = bl2 ? this.p(w2) : new t(69, this.a(w2));
        if (this.a.a() != 59) {
            throw new e("; is missing", this.a);
        }
        return t2;
    }

    private t p(w w2) {
        t t2 = null;
        while (true) {
            t t3 = new t(69, this.a(w2));
            t2 = (t)javassist.compiler.ast.a.a(t2, new t(66, (b)t3));
            if (this.a.b() != 44) break;
            this.a.a();
        }
        return t2;
    }

    private t a(w w2, i i2) {
        int n2;
        t t2 = null;
        do {
            t2 = (t)javassist.compiler.ast.a.a(t2, new t(68, (b)this.a(w2, i2)));
            n2 = this.a.a();
            if (n2 != 59) continue;
            return t2;
        } while (n2 == 44);
        throw new e("; is missing", this.a);
    }

    private i a(w w2, i i2) {
        if (this.a.a() != 400 || i2.b() == 344) {
            throw new x(this.a);
        }
        String string = this.a.a();
        v v2 = new v(string);
        int n2 = this.a();
        b b2 = null;
        if (this.a.b() == 61) {
            this.a.a();
            b2 = this.b(w2);
        }
        i i3 = i2.a(v2, n2, b2);
        w2.a(string, i3);
        return i3;
    }

    private b b(w w2) {
        if (this.a.b() == 123) {
            return this.a(w2);
        }
        return this.a(w2);
    }

    private c a(w w2) {
        this.a.a();
        if (this.a.b() == 125) {
            this.a.a();
            return new c(null);
        }
        b b2 = this.a(w2);
        c c2 = new c(b2);
        while (this.a.b() == 44) {
            this.a.a();
            b2 = this.a(w2);
            javassist.compiler.ast.a.a((a)c2, b2);
        }
        if (this.a.a() != 125) {
            throw new x(this.a);
        }
        return c2;
    }

    private b c(w w2) {
        if (this.a.a() != 40) {
            throw new x(this.a);
        }
        b b2 = this.a(w2);
        if (this.a.a() != 41) {
            throw new x(this.a);
        }
        return b2;
    }

    public b a(w w2) {
        b b2 = this.d(w2);
        if (!u.b(this.a.b())) {
            return b2;
        }
        int n2 = this.a.a();
        b b3 = this.a(w2);
        return d.a(n2, b2, b3);
    }

    private static boolean b(int n2) {
        return n2 == 61 || n2 == 351 || n2 == 352 || n2 == 353 || n2 == 354 || n2 == 355 || n2 == 356 || n2 == 360 || n2 == 361 || n2 == 365 || n2 == 367 || n2 == 371;
    }

    private b d(w w2) {
        b b2 = this.e(w2);
        if (this.a.b() == 63) {
            this.a.a();
            b b3 = this.a(w2);
            if (this.a.a() != 58) {
                throw new e(": is missing", this.a);
            }
            b b4 = this.a(w2);
            return new h(b2, b3, b4);
        }
        return b2;
    }

    private b e(w w2) {
        b b2 = this.f(w2);
        int n2;
        int n3;
        while ((n3 = this.a(n2 = this.a.b())) != 0) {
            b2 = this.a(w2, b2, n3);
        }
        return b2;
    }

    private b a(w w2, b b2) {
        int n2 = this.a.b();
        if (u.a(n2)) {
            this.a.a();
            int n3 = this.a();
            return new m(n2, n3, b2);
        }
        b b3 = this.c(w2);
        int n4 = this.a();
        return new m((a)b3, n4, b2);
    }

    private b a(w w2, b b2, int n2) {
        int n3;
        int n4;
        int n5 = this.a.a();
        if (n5 == 323) {
            return this.a(w2, b2);
        }
        b b3 = this.f(w2);
        while ((n4 = this.a(n3 = this.a.b())) != 0 && n2 > n4) {
            b3 = this.a(w2, b3, n4);
        }
        return javassist.compiler.ast.e.a(n5, b2, b3);
    }

    private int a(int n2) {
        if (33 <= n2 && n2 <= 63) {
            return b[n2 - 33];
        }
        if (n2 == 94) {
            return 7;
        }
        if (n2 == 124) {
            return 8;
        }
        if (n2 == 369) {
            return 9;
        }
        if (n2 == 368) {
            return 10;
        }
        if (n2 == 358 || n2 == 350) {
            return 5;
        }
        if (n2 == 357 || n2 == 359 || n2 == 323) {
            return 4;
        }
        if (n2 == 364 || n2 == 366 || n2 == 370) {
            return 3;
        }
        return 0;
    }

    private b f(w w2) {
        switch (this.a.b()) {
            case 33: 
            case 43: 
            case 45: 
            case 126: 
            case 362: 
            case 363: {
                int n2 = this.a.a();
                if (n2 == 45) {
                    int n3 = this.a.b();
                    switch (n3) {
                        case 401: 
                        case 402: 
                        case 403: {
                            this.a.a();
                            return new javassist.compiler.ast.n(-this.a.a(), n3);
                        }
                        case 404: 
                        case 405: {
                            this.a.a();
                            return new j(-this.a.a(), n3);
                        }
                    }
                }
                return k.a(n2, this.f(w2));
            }
            case 40: {
                return this.g(w2);
            }
        }
        return this.h(w2);
    }

    private b g(w w2) {
        int n2 = this.a.a(1);
        if (u.a(n2) && this.b()) {
            this.a.a();
            this.a.a();
            int n3 = this.a();
            if (this.a.a() != 41) {
                throw new e(") is missing", this.a);
            }
            return new g(n2, n3, this.f(w2));
        }
        if (n2 == 400 && this.c()) {
            this.a.a();
            b b2 = this.c(w2);
            int n4 = this.a();
            if (this.a.a() != 41) {
                throw new e(") is missing", this.a);
            }
            return new g((a)b2, n4, this.f(w2));
        }
        return this.h(w2);
    }

    private boolean b() {
        int n2;
        int n3 = 2;
        while ((n2 = this.a.a(n3++)) == 91) {
            if (this.a.a(n3++) == 93) continue;
            return false;
        }
        return this.a.a(n3 - 1) == 41;
    }

    private boolean c() {
        int n2 = this.b(1);
        if (n2 < 0) {
            return false;
        }
        int n3 = this.a.a(n2);
        if (n3 != 41) {
            return false;
        }
        n3 = this.a.a(n2 + 1);
        return n3 == 40 || n3 == 412 || n3 == 406 || n3 == 400 || n3 == 339 || n3 == 336 || n3 == 328 || n3 == 410 || n3 == 411 || n3 == 403 || n3 == 402 || n3 == 401 || n3 == 405 || n3 == 404;
    }

    private int b(int n2) {
        int n3;
        while (this.a.a(++n2) == 46) {
            if (this.a.a(++n2) == 400) continue;
            return -1;
        }
        while ((n3 = this.a.a(n2++)) == 91) {
            if (this.a.a(n2++) == 93) continue;
            return -1;
        }
        return n2 - 1;
    }

    private int a() {
        int n2 = 0;
        while (this.a.b() == 91) {
            ++n2;
            this.a.a();
            if (this.a.a() == 93) continue;
            throw new e("] is missing", this.a);
        }
        return n2;
    }

    private a c(w w2) {
        a a2 = null;
        while (true) {
            if (this.a.a() != 400) {
                throw new x(this.a);
            }
            a2 = javassist.compiler.ast.a.a(a2, new v(this.a.a()));
            if (this.a.b() != 46) break;
            this.a.a();
        }
        return a2;
    }

    private b h(w w2) {
        int n2 = this.a.b();
        switch (n2) {
            case 401: 
            case 402: 
            case 403: {
                this.a.a();
                return new javassist.compiler.ast.n(this.a.a(), n2);
            }
            case 404: 
            case 405: {
                this.a.a();
                return new j(this.a.a(), n2);
            }
        }
        b b2 = this.i(w2);
        block11: while (true) {
            switch (this.a.b()) {
                case 40: {
                    b2 = this.b(w2, b2);
                    continue block11;
                }
                case 91: {
                    if (this.a.a(1) == 93) {
                        int n3 = this.a();
                        if (this.a.a() != 46 || this.a.a() != 307) {
                            throw new x(this.a);
                        }
                        b2 = this.a(b2, n3);
                        continue block11;
                    }
                    b b3 = this.j(w2);
                    if (b3 == null) {
                        throw new x(this.a);
                    }
                    b2 = k.a(65, b2, b3);
                    continue block11;
                }
                case 362: 
                case 363: {
                    int n4 = this.a.a();
                    b2 = k.a(n4, null, b2);
                    continue block11;
                }
                case 46: {
                    String string;
                    this.a.a();
                    int n4 = this.a.a();
                    if (n4 == 307) {
                        b2 = this.a(b2, 0);
                        continue block11;
                    }
                    if (n4 == 336) {
                        b2 = k.a(46, (b)new v(this.a(b2)), (b)new o(n4));
                        continue block11;
                    }
                    if (n4 == 400) {
                        string = this.a.a();
                        b2 = k.a(46, b2, (b)new p(string));
                        continue block11;
                    }
                    throw new e("missing member name", this.a);
                }
                case 35: {
                    this.a.a();
                    int n4 = this.a.a();
                    if (n4 != 400) {
                        throw new e("missing static member name", this.a);
                    }
                    String string = this.a.a();
                    b2 = k.a(35, (b)new v(this.a(b2)), (b)new p(string));
                    continue block11;
                }
            }
            break;
        }
        return b2;
    }

    private b a(b b2, int n2) {
        String string = this.a(b2);
        if (n2 > 0) {
            StringBuffer stringBuffer = new StringBuffer();
            while (n2-- > 0) {
                stringBuffer.append('[');
            }
            stringBuffer.append('L').append(string.replace('.', '/')).append(';');
            string = stringBuffer.toString();
        }
        return k.a(46, (b)new v(string), (b)new p("class"));
    }

    private b a(int n2, int n3) {
        String string;
        if (n3 > 0) {
            String string2 = javassist.compiler.b.a(n2, n3);
            return k.a(46, (b)new v(string2), (b)new p("class"));
        }
        switch (n2) {
            case 301: {
                string = "java.lang.Boolean";
                break;
            }
            case 303: {
                string = "java.lang.Byte";
                break;
            }
            case 306: {
                string = "java.lang.Character";
                break;
            }
            case 334: {
                string = "java.lang.Short";
                break;
            }
            case 324: {
                string = "java.lang.Integer";
                break;
            }
            case 326: {
                string = "java.lang.Long";
                break;
            }
            case 317: {
                string = "java.lang.Float";
                break;
            }
            case 312: {
                string = "java.lang.Double";
                break;
            }
            case 344: {
                string = "java.lang.Void";
                break;
            }
            default: {
                throw new e("invalid builtin type: " + n2);
            }
        }
        return k.a(35, (b)new v(string), (b)new p("TYPE"));
    }

    private b b(w w2, b b2) {
        int n2;
        int n3;
        if (b2 instanceof o ? (n3 = ((o)b2).a()) != 339 && n3 != 336 : !(b2 instanceof v) && b2 instanceof k && (n2 = ((k)b2).b()) != 46 && n2 != 35) {
            throw new x(this.a);
        }
        return f.a(b2, this.e(w2));
    }

    private String a(b b2) {
        StringBuffer stringBuffer = new StringBuffer();
        this.a(b2, stringBuffer);
        return stringBuffer.toString();
    }

    private void a(b b2, StringBuffer stringBuffer) {
        k k2;
        if (b2 instanceof v) {
            stringBuffer.append(((v)b2).b());
            return;
        }
        if (b2 instanceof k && (k2 = (k)b2).b() == 46) {
            this.a(k2.d(), stringBuffer);
            stringBuffer.append('.');
            this.a(k2.e(), stringBuffer);
            return;
        }
        throw new e("bad static member access", this.a);
    }

    private b i(w w2) {
        int n2 = this.a.a();
        switch (n2) {
            case 336: 
            case 339: 
            case 410: 
            case 411: 
            case 412: {
                return new o(n2);
            }
            case 400: {
                String string = this.a.a();
                i i2 = w2.a(string);
                if (i2 == null) {
                    return new p(string);
                }
                return new javassist.compiler.ast.w(string, i2);
            }
            case 406: {
                return new javassist.compiler.ast.u(this.a.a());
            }
            case 328: {
                return this.a(w2);
            }
            case 40: {
                b b2 = this.a(w2);
                if (this.a.a() == 41) {
                    return b2;
                }
                throw new e(") is missing", this.a);
            }
        }
        if (u.a(n2) || n2 == 344) {
            int n3 = this.a();
            if (this.a.a() == 46 && this.a.a() == 307) {
                return this.a(n2, n3);
            }
        }
        throw new x(this.a);
    }

    private r a(w w2) {
        a a2 = null;
        int n2 = this.a.b();
        if (u.a(n2)) {
            this.a.a();
            b b2 = this.d(w2);
            if (this.a.b() == 123) {
                a2 = this.a(w2);
            }
            return new r(n2, (a)b2, (c)a2);
        }
        if (n2 == 400) {
            b b3 = this.c(w2);
            n2 = this.a.b();
            if (n2 == 40) {
                b b4 = this.e(w2);
                return new r((a)b3, (a)b4);
            }
            if (n2 == 91) {
                b b5 = this.d(w2);
                if (this.a.b() == 123) {
                    a2 = this.a(w2);
                }
                return r.a((a)b3, (a)b5, (c)a2);
            }
        }
        throw new x(this.a);
    }

    private a d(w w2) {
        a a2 = null;
        while (this.a.b() == 91) {
            a2 = javassist.compiler.ast.a.a(a2, this.j(w2));
        }
        return a2;
    }

    private b j(w w2) {
        this.a.a();
        if (this.a.b() == 93) {
            this.a.a();
            return null;
        }
        b b2 = this.a(w2);
        if (this.a.a() != 93) {
            throw new e("] is missing", this.a);
        }
        return b2;
    }

    private a e(w w2) {
        if (this.a.a() != 40) {
            throw new e("( is missing", this.a);
        }
        a a2 = null;
        if (this.a.b() != 41) {
            while (true) {
                a2 = javassist.compiler.ast.a.a(a2, this.a(w2));
                if (this.a.b() != 44) break;
                this.a.a();
            }
        }
        if (this.a.a() != 41) {
            throw new e(") is missing", this.a);
        }
        return a2;
    }
}

