/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package vn.giakhanhvn.skysim.nms.nmsutil.reflection.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import vn.giakhanhvn.skysim.nms.nmsutil.reflection.minecraft.Minecraft;

@Target(value={ElementType.FIELD})
@Retention(value=RetentionPolicy.RUNTIME)
public @interface Method {
    public String className();

    public String[] value();

    public Minecraft.Version[] versions() default {};

    public boolean ignoreExceptions() default true;
}

