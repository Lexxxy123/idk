/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode.annotation;

import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.AnnotationsWriter;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.MemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.MemberValueVisitor;
import java.io.IOException;
import java.lang.reflect.Method;

public class FloatMemberValue
extends MemberValue {
    int valueIndex;

    public FloatMemberValue(int index, ConstPool cp) {
        super('F', cp);
        this.valueIndex = index;
    }

    public FloatMemberValue(float f2, ConstPool cp) {
        super('F', cp);
        this.setValue(f2);
    }

    public FloatMemberValue(ConstPool cp) {
        super('F', cp);
        this.setValue(0.0f);
    }

    @Override
    Object getValue(ClassLoader cl, ClassPool cp, Method m2) {
        return Float.valueOf(this.getValue());
    }

    @Override
    Class<?> getType(ClassLoader cl) {
        return Float.TYPE;
    }

    public float getValue() {
        return this.cp.getFloatInfo(this.valueIndex);
    }

    public void setValue(float newValue) {
        this.valueIndex = this.cp.addFloatInfo(newValue);
    }

    public String toString() {
        return Float.toString(this.getValue());
    }

    @Override
    public void write(AnnotationsWriter writer) throws IOException {
        writer.constValueIndex(this.getValue());
    }

    @Override
    public void accept(MemberValueVisitor visitor) {
        visitor.visitFloatMemberValue(this);
    }
}

