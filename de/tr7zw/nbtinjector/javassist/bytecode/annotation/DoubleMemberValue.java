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

public class DoubleMemberValue
extends MemberValue {
    int valueIndex;

    public DoubleMemberValue(int index, ConstPool cp) {
        super('D', cp);
        this.valueIndex = index;
    }

    public DoubleMemberValue(double d2, ConstPool cp) {
        super('D', cp);
        this.setValue(d2);
    }

    public DoubleMemberValue(ConstPool cp) {
        super('D', cp);
        this.setValue(0.0);
    }

    @Override
    Object getValue(ClassLoader cl, ClassPool cp, Method m2) {
        return this.getValue();
    }

    @Override
    Class<?> getType(ClassLoader cl) {
        return Double.TYPE;
    }

    public double getValue() {
        return this.cp.getDoubleInfo(this.valueIndex);
    }

    public void setValue(double newValue) {
        this.valueIndex = this.cp.addDoubleInfo(newValue);
    }

    public String toString() {
        return Double.toString(this.getValue());
    }

    @Override
    public void write(AnnotationsWriter writer) throws IOException {
        writer.constValueIndex(this.getValue());
    }

    @Override
    public void accept(MemberValueVisitor visitor) {
        visitor.visitDoubleMemberValue(this);
    }
}

