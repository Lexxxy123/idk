/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.java_websocket.extensions;

import javassist.orgs.java_websocket.exceptions.e;
import javassist.orgs.java_websocket.extensions.d;
import javassist.orgs.java_websocket.framing.f;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public class b
implements d {
    @Override
    public void b(f f2) {
    }

    @Override
    public void c(f f2) {
    }

    @Override
    public boolean a(String string) {
        return true;
    }

    @Override
    public boolean b(String string) {
        return true;
    }

    @Override
    public void a(f f2) {
        if (f2.b() || f2.c() || f2.d()) {
            throw new e("bad rsv RSV1: " + f2.b() + " RSV2: " + f2.c() + " RSV3: " + f2.d());
        }
    }

    @Override
    public String a() {
        return "";
    }

    @Override
    public String b() {
        return "";
    }

    @Override
    public d a() {
        return new b();
    }

    @Override
    public void a() {
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }

    public int hashCode() {
        return this.getClass().hashCode();
    }

    public boolean equals(Object object) {
        return this == object || object != null && this.getClass() == object.getClass();
    }
}

