/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.wrapper;

import java.lang.reflect.Field;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.resolver.wrapper.WrapperAbstract;

public class FieldWrapper<R>
extends WrapperAbstract {
    private final Field field;

    public FieldWrapper(Field field) {
        this.field = field;
    }

    @Override
    public boolean exists() {
        return this.field != null;
    }

    public String getName() {
        return this.field.getName();
    }

    public R get(Object object) {
        try {
            return (R)this.field.get(object);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public R getSilent(Object object) {
        try {
            return (R)this.field.get(object);
        } catch (Exception e2) {
            return null;
        }
    }

    public void set(Object object, R value) {
        try {
            this.field.set(object, value);
        } catch (Exception e2) {
            throw new RuntimeException(e2);
        }
    }

    public void setSilent(Object object, R value) {
        try {
            this.field.set(object, value);
        } catch (Exception exception) {
            // empty catch block
        }
    }

    public Field getField() {
        return this.field;
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (object == null || this.getClass() != object.getClass()) {
            return false;
        }
        FieldWrapper that = (FieldWrapper)object;
        return this.field != null ? this.field.equals(that.field) : that.field == null;
    }

    public int hashCode() {
        return this.field != null ? this.field.hashCode() : 0;
    }
}

