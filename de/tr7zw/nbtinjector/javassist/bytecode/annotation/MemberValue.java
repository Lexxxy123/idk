/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode.annotation;

import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.Descriptor;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.AnnotationsWriter;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.MemberValueVisitor;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.NoSuchClassError;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class MemberValue {
    ConstPool cp;
    char tag;

    MemberValue(char tag, ConstPool cp) {
        this.cp = cp;
        this.tag = tag;
    }

    abstract Object getValue(ClassLoader var1, ClassPool var2, Method var3) throws ClassNotFoundException;

    abstract Class<?> getType(ClassLoader var1) throws ClassNotFoundException;

    static Class<?> loadClass(ClassLoader cl, String classname) throws ClassNotFoundException, NoSuchClassError {
        try {
            return Class.forName(MemberValue.convertFromArray(classname), true, cl);
        } catch (LinkageError e2) {
            throw new NoSuchClassError(classname, e2);
        }
    }

    private static String convertFromArray(String classname) {
        int index = classname.indexOf("[]");
        if (index != -1) {
            String rawType = classname.substring(0, index);
            StringBuffer sb = new StringBuffer(Descriptor.of(rawType));
            while (index != -1) {
                sb.insert(0, "[");
                index = classname.indexOf("[]", index + 1);
            }
            return sb.toString().replace('/', '.');
        }
        return classname;
    }

    public abstract void accept(MemberValueVisitor var1);

    public abstract void write(AnnotationsWriter var1) throws IOException;
}

