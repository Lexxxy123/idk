/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package javassist.orgs.slf4j.helpers;

import java.util.HashMap;
import java.util.Map;
import javassist.orgs.slf4j.helpers.b;

class c
extends InheritableThreadLocal<Map<String, String>> {
    final /* synthetic */ b a;

    c(b b2) {
        this.a = b2;
    }

    protected Map<String, String> a(Map<String, String> map) {
        if (map == null) {
            return null;
        }
        return new HashMap<String, String>(map);
    }

    @Override
    protected /* synthetic */ Object childValue(Object object) {
        return this.a((Map)object);
    }
}

