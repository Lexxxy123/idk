/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode.annotation;

import de.tr7zw.nbtinjector.javassist.bytecode.annotation.AnnotationMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.ArrayMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.BooleanMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.ByteMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.CharMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.ClassMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.DoubleMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.EnumMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.FloatMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.IntegerMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.LongMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.ShortMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.StringMemberValue;

public interface MemberValueVisitor {
    public void visitAnnotationMemberValue(AnnotationMemberValue var1);

    public void visitArrayMemberValue(ArrayMemberValue var1);

    public void visitBooleanMemberValue(BooleanMemberValue var1);

    public void visitByteMemberValue(ByteMemberValue var1);

    public void visitCharMemberValue(CharMemberValue var1);

    public void visitDoubleMemberValue(DoubleMemberValue var1);

    public void visitEnumMemberValue(EnumMemberValue var1);

    public void visitFloatMemberValue(FloatMemberValue var1);

    public void visitIntegerMemberValue(IntegerMemberValue var1);

    public void visitLongMemberValue(LongMemberValue var1);

    public void visitShortMemberValue(ShortMemberValue var1);

    public void visitStringMemberValue(StringMemberValue var1);

    public void visitClassMemberValue(ClassMemberValue var1);
}

