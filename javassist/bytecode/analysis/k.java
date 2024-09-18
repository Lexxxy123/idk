/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.bytecode.analysis;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class k {
    private List<Integer> a;
    private Set<Integer> a;
    private int a = new HashSet();

    public k(int n2, int n3) {
        this.a = n2;
        this.a.add(n3);
    }

    public void a(int n2) {
        this.a.add(n2);
    }

    public int a() {
        return this.a;
    }

    public void b(int n2) {
        this.a.add(n2);
    }

    public boolean a(int n2) {
        return this.a.contains(n2);
    }

    public Collection<Integer> a() {
        return this.a;
    }

    public Collection<Integer> b() {
        return this.a;
    }

    public String toString() {
        return "start = " + this.a + " callers = " + this.a.toString();
    }
}

