/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.wrapper;

import java.lang.reflect.Constructor;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.wrapper.WrapperAbstract;

public class ConstructorWrapper<R>
extends WrapperAbstract {
    private final Constructor<R> constructor;

    public ConstructorWrapper(Constructor<R> constructor) {
        this.constructor = constructor;
    }

    @Override
    public boolean exists() {
        return this.constructor != null;
    }

    public R newInstance(Object ... args) {
        try {
            return this.constructor.newInstance(args);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public R newInstanceSilent(Object ... args) {
        try {
            return this.constructor.newInstance(args);
        } catch (Exception e2) {
            return null;
        }
    }

    public Class<?>[] getParameterTypes() {
        return this.constructor.getParameterTypes();
    }

    public Constructor<R> getConstructor() {
        return this.constructor;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        ConstructorWrapper that = (ConstructorWrapper)object;
        return this.constructor != null ? this.constructor.equals(that.constructor) : that.constructor == null;
    }

    public int hashCode() {
        return this.constructor != null ? this.constructor.hashCode() : 0;
    }
}

