/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver;

import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.ResolverAbstract;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.ResolverQuery;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.wrapper.ClassWrapper;

public class ClassResolver
extends ResolverAbstract<Class> {
    public ClassWrapper resolveWrapper(String ... names) {
        return new ClassWrapper(this.resolveSilent(names));
    }

    public Class resolveSilent(String ... names) {
        try {
            return this.resolve(names);
        } catch (Exception e2) {
            return null;
        }
    }

    public Class resolve(String ... names) throws ClassNotFoundException {
        ResolverQuery.Builder builder = ResolverQuery.builder();
        for (String name : names) {
            builder.with(name);
        }
        try {
            return (Class)super.resolve(builder.build());
        } catch (ReflectiveOperationException e2) {
            throw (ClassNotFoundException)e2;
        }
    }

    @Override
    protected Class resolveObject(ResolverQuery query) throws ReflectiveOperationException {
        return Class.forName(query.getName());
    }

    @Override
    protected ClassNotFoundException notFoundException(String joinedNames) {
        return new ClassNotFoundException("Could not resolve class for " + joinedNames);
    }
}

