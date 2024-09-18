/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.stackmap;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javassist.CtClass;
import javassist.bytecode.J;
import javassist.bytecode.M;
import javassist.bytecode.stackmap.h;
import javassist.bytecode.stackmap.i;
import javassist.bytecode.stackmap.l;
import javassist.bytecode.stackmap.m;
import javassist.bytecode.stackmap.n;
import javassist.bytecode.stackmap.s;
import javassist.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class o
extends i {
    protected List<h> a;
    protected List<h> b;
    protected List<String> c;
    protected String a;
    private boolean a;
    private int a = new ArrayList<h>(2);
    private int b;
    private boolean b = new ArrayList<h>(2);
    private int c = null;

    public o(h h2) {
        this.a(h2);
        this.a = null;
        this.a = h2.a();
    }

    @Override
    public String a() {
        if (this.a == null) {
            return this.a.get(0).a();
        }
        return this.a;
    }

    @Override
    public l a() {
        if (this.a == null) {
            return this.a.get(0).a();
        }
        return null;
    }

    @Override
    public boolean a() {
        if (this.a == null) {
            return this.a;
        }
        return false;
    }

    @Override
    public boolean b() {
        if (this.a == null) {
            return this.a.get(0).b();
        }
        return false;
    }

    @Override
    public boolean c() {
        if (this.a == null) {
            return this.a.get(0).c();
        }
        return false;
    }

    @Override
    public void a(h h2) {
        this.a.add(h2);
        if (h2 instanceof o) {
            ((o)h2).b.add(this);
        }
    }

    @Override
    public int a() {
        if (this.a == null) {
            return this.a.get(0).a();
        }
        return super.a();
    }

    @Override
    public int a(J j2) {
        if (this.a == null) {
            return this.a.get(0).a(j2);
        }
        return super.a(j2);
    }

    @Override
    public void a(String string, f f2) {
        if (this.c == null) {
            this.c = new ArrayList<String>();
        }
        this.c.add(string);
    }

    @Override
    protected o a(int n2) {
        this.c = n2;
        return this;
    }

    @Override
    public h a(int n2) {
        if (n2 == 0) {
            return this;
        }
        l l2 = this.a();
        if (l2 == null) {
            if (this.b()) {
                return new n();
            }
            return new m(this.a()).a(n2);
        }
        return l2.a(n2);
    }

    @Override
    public int a(List<h> list, int n2, f f2) {
        h h2;
        if (this.a > 0) {
            return n2;
        }
        this.a = this.b = ++n2;
        list.add(this);
        this.b = true;
        int n3 = this.a.size();
        for (int i2 = 0; i2 < n3; ++i2) {
            h2 = this.a.get(i2).a(this.c);
            if (h2 == null) continue;
            if (((o)h2).a == 0) {
                n2 = ((o)h2).a(list, n2, f2);
                if (((o)h2).b >= this.b) continue;
                this.b = ((o)h2).b;
                continue;
            }
            if (!((o)h2).b || ((o)h2).a >= this.b) continue;
            this.b = ((o)h2).a;
        }
        if (this.a == this.b) {
            ArrayList<h> arrayList = new ArrayList<h>();
            do {
                h2 = (o)list.remove(list.size() - 1);
                ((o)h2).b = false;
                arrayList.add(h2);
            } while (h2 != this);
            this.a(arrayList, f2);
        }
        return n2;
    }

    private void a(List<h> list, f f2) {
        HashSet<String> hashSet = new HashSet<String>();
        boolean bl2 = false;
        h h2 = null;
        int n2 = list.size();
        block0: for (int i2 = 0; i2 < n2; ++i2) {
            o o2 = (o)list.get(i2);
            List<h> list2 = o2.a;
            int n3 = list2.size();
            for (int i3 = 0; i3 < n3; ++i3) {
                h h3 = list2.get(i3);
                h h4 = h3.a(o2.c);
                h h5 = h4.a();
                if (h2 == null) {
                    if (h5 == null) {
                        bl2 = false;
                        h2 = h4;
                        if (h4.c()) {
                            continue block0;
                        }
                    } else {
                        bl2 = true;
                        h2 = h5;
                    }
                } else if (h5 == null && bl2 || h5 != null && h2 != h5) {
                    bl2 = true;
                    h2 = s.a;
                    continue block0;
                }
                if (h5 != null || h4.b()) continue;
                hashSet.add(h4.a());
            }
        }
        if (bl2) {
            this.a = h2.a();
            this.a(list, h2);
        } else {
            String string = this.a(list, hashSet, f2);
            this.a(list, new m(string));
        }
    }

    private void a(List<h> list, h h2) {
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            o o2 = (o)list.get(i2);
            h h3 = h2.a(-o2.c);
            if (h3.a() == null) {
                o2.a = h3.a();
                continue;
            }
            o2.a.clear();
            o2.a.add(h3);
            o2.a = h3.a();
        }
    }

    private String a(List<h> list, Set<String> set, f f2) {
        Iterator<String> iterator = set.iterator();
        if (set.size() == 0) {
            return null;
        }
        if (set.size() == 1) {
            return iterator.next();
        }
        CtClass ctClass = f2.c(iterator.next());
        while (iterator.hasNext()) {
            ctClass = o.a(ctClass, f2.c(iterator.next()));
        }
        if (ctClass.b() == null || o.a(ctClass)) {
            ctClass = this.a(list, f2, new HashSet<h>(), ctClass);
        }
        if (ctClass.a()) {
            return M.a(ctClass);
        }
        return ctClass.a();
    }

    private static boolean a(CtClass ctClass) {
        return ctClass.a() && ctClass.a().b() == null;
    }

    private CtClass a(List<h> list, f f2, Set<h> set, CtClass ctClass) {
        if (list == null) {
            return ctClass;
        }
        int n2 = list.size();
        for (int i2 = 0; i2 < n2; ++i2) {
            o o2 = (o)list.get(i2);
            if (!set.add(o2)) {
                return ctClass;
            }
            if (o2.c != null) {
                int n3 = o2.c.size();
                for (int i3 = 0; i3 < n3; ++i3) {
                    CtClass ctClass2 = f2.c(o2.c.get(i3));
                    if (!ctClass2.a(ctClass)) continue;
                    ctClass = ctClass2;
                }
            }
            ctClass = this.a(o2.b, f2, set, ctClass);
        }
        return ctClass;
    }

    @Override
    String a(Set<h> set) {
        h h2;
        set.add(this);
        if (this.a.size() > 0 && (h2 = this.a.get(0)) != null && !set.contains(h2)) {
            return h2.a(set);
        }
        return "?";
    }
}

