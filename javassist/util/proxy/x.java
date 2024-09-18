/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.util.proxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javassist.util.proxy.o;

/*
 * Duplicate member names - consider using --renamedupmembers true
 */
class x {
    final Class<?> a;
    final Object a;
    final Map<String, List<Method>> a = new HashMap();
    final /* synthetic */ o a;

    /*
     * Ignored method signature, as it can't be verified against descriptor
     */
    x(o o2, Class clazz, Object object) {
        this.a = o2;
        this.a = clazz;
        this.a = object;
        for (Method method : this.a.getDeclaredMethods()) {
            if (!this.a.containsKey(method.getName())) {
                this.a.put(method.getName(), Collections.singletonList(method));
                continue;
            }
            if (((List)this.a.get(method.getName())).size() == 1) {
                this.a.put(method.getName(), new ArrayList((Collection)this.a.get(method.getName())));
            }
            ((List)this.a.get(method.getName())).add(method);
        }
    }

    private Method a(String string, Object[] objectArray) {
        return (Method)((List)this.a.get(string)).get(0);
    }

    public Object a(String string, Object ... objectArray) {
        try {
            return this.a(string, objectArray).invoke(this.a, objectArray);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            return null;
        }
    }
}

