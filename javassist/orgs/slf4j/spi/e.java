/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.spi;

import java.util.function.Supplier;
import javassist.orgs.slf4j.h;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
public interface e {
    public e a(Throwable var1);

    public e a(h var1);

    public e a(Object var1);

    public e a(Supplier<Object> var1);

    public e a(String var1, Object var2);

    public e a(String var1, Supplier<Object> var2);

    public void a(String var1);

    public void a(String var1, Object var2);

    public void a(String var1, Object var2, Object var3);

    public void a(String var1, Object ... var2);

    public void a(Supplier<String> var1);
}

