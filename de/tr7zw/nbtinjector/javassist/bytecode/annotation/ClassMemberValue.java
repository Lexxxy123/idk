/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode.annotation;

import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.bytecode.BadBytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.Descriptor;
import de.tr7zw.nbtinjector.javassist.bytecode.SignatureAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.AnnotationsWriter;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.MemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.MemberValueVisitor;
import java.io.IOException;
import java.lang.reflect.Method;

public class ClassMemberValue
extends MemberValue {
    int valueIndex;

    public ClassMemberValue(int index, ConstPool cp) {
        super('c', cp);
        this.valueIndex = index;
    }

    public ClassMemberValue(String className, ConstPool cp) {
        super('c', cp);
        this.setValue(className);
    }

    public ClassMemberValue(ConstPool cp) {
        super('c', cp);
        this.setValue("java.lang.Class");
    }

    @Override
    Object getValue(ClassLoader cl, ClassPool cp, Method m2) throws ClassNotFoundException {
        String classname = this.getValue();
        if (classname.equals("void")) {
            return Void.TYPE;
        }
        if (classname.equals("int")) {
            return Integer.TYPE;
        }
        if (classname.equals("byte")) {
            return Byte.TYPE;
        }
        if (classname.equals("long")) {
            return Long.TYPE;
        }
        if (classname.equals("double")) {
            return Double.TYPE;
        }
        if (classname.equals("float")) {
            return Float.TYPE;
        }
        if (classname.equals("char")) {
            return Character.TYPE;
        }
        if (classname.equals("short")) {
            return Short.TYPE;
        }
        if (classname.equals("boolean")) {
            return Boolean.TYPE;
        }
        return ClassMemberValue.loadClass(cl, classname);
    }

    @Override
    Class<?> getType(ClassLoader cl) throws ClassNotFoundException {
        return ClassMemberValue.loadClass(cl, "java.lang.Class");
    }

    public String getValue() {
        String v2 = this.cp.getUtf8Info(this.valueIndex);
        try {
            return SignatureAttribute.toTypeSignature(v2).jvmTypeName();
        } catch (BadBytecode e2) {
            throw new RuntimeException(e2);
        }
    }

    public void setValue(String newClassName) {
        String setTo = Descriptor.of(newClassName);
        this.valueIndex = this.cp.addUtf8Info(setTo);
    }

    public String toString() {
        return this.getValue().replace('$', '.') + ".class";
    }

    @Override
    public void write(AnnotationsWriter writer) throws IOException {
        writer.classInfoIndex(this.cp.getUtf8Info(this.valueIndex));
    }

    @Override
    public void accept(MemberValueVisitor visitor) {
        visitor.visitClassMemberValue(this);
    }
}

