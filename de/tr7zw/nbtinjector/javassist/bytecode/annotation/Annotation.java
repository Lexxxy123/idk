/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode.annotation;

import de.tr7zw.nbtinjector.javassist.ClassPool;
import de.tr7zw.nbtinjector.javassist.CtClass;
import de.tr7zw.nbtinjector.javassist.CtMethod;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.bytecode.ConstPool;
import de.tr7zw.nbtinjector.javassist.bytecode.Descriptor;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.AnnotationImpl;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.AnnotationMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.AnnotationsWriter;
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
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.MemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.NoSuchClassError;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.ShortMemberValue;
import de.tr7zw.nbtinjector.javassist.bytecode.annotation.StringMemberValue;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class Annotation {
    ConstPool pool;
    int typeIndex;
    Map<String, Pair> members;

    public Annotation(int type, ConstPool cp) {
        this.pool = cp;
        this.typeIndex = type;
        this.members = null;
    }

    public Annotation(String typeName, ConstPool cp) {
        this(cp.addUtf8Info(Descriptor.of(typeName)), cp);
    }

    public Annotation(ConstPool cp, CtClass clazz) throws NotFoundException {
        this(cp.addUtf8Info(Descriptor.of(clazz.getName())), cp);
        if (!clazz.isInterface()) {
            throw new RuntimeException("Only interfaces are allowed for Annotation creation.");
        }
        CtMethod[] methods = clazz.getDeclaredMethods();
        if (methods.length > 0) {
            this.members = new LinkedHashMap<String, Pair>();
        }
        for (CtMethod m2 : methods) {
            this.addMemberValue(m2.getName(), Annotation.createMemberValue(cp, m2.getReturnType()));
        }
    }

    public static MemberValue createMemberValue(ConstPool cp, CtClass type) throws NotFoundException {
        if (type == CtClass.booleanType) {
            return new BooleanMemberValue(cp);
        }
        if (type == CtClass.byteType) {
            return new ByteMemberValue(cp);
        }
        if (type == CtClass.charType) {
            return new CharMemberValue(cp);
        }
        if (type == CtClass.shortType) {
            return new ShortMemberValue(cp);
        }
        if (type == CtClass.intType) {
            return new IntegerMemberValue(cp);
        }
        if (type == CtClass.longType) {
            return new LongMemberValue(cp);
        }
        if (type == CtClass.floatType) {
            return new FloatMemberValue(cp);
        }
        if (type == CtClass.doubleType) {
            return new DoubleMemberValue(cp);
        }
        if (type.getName().equals("java.lang.Class")) {
            return new ClassMemberValue(cp);
        }
        if (type.getName().equals("java.lang.String")) {
            return new StringMemberValue(cp);
        }
        if (type.isArray()) {
            CtClass arrayType = type.getComponentType();
            MemberValue member = Annotation.createMemberValue(cp, arrayType);
            return new ArrayMemberValue(member, cp);
        }
        if (type.isInterface()) {
            Annotation info = new Annotation(cp, type);
            return new AnnotationMemberValue(info, cp);
        }
        EnumMemberValue emv = new EnumMemberValue(cp);
        emv.setType(type.getName());
        return emv;
    }

    public void addMemberValue(int nameIndex, MemberValue value) {
        Pair p2 = new Pair();
        p2.name = nameIndex;
        p2.value = value;
        this.addMemberValue(p2);
    }

    public void addMemberValue(String name, MemberValue value) {
        Pair p2 = new Pair();
        p2.name = this.pool.addUtf8Info(name);
        p2.value = value;
        if (this.members == null) {
            this.members = new LinkedHashMap<String, Pair>();
        }
        this.members.put(name, p2);
    }

    private void addMemberValue(Pair pair) {
        String name = this.pool.getUtf8Info(pair.name);
        if (this.members == null) {
            this.members = new LinkedHashMap<String, Pair>();
        }
        this.members.put(name, pair);
    }

    public String toString() {
        StringBuffer buf = new StringBuffer("@");
        buf.append(this.getTypeName());
        if (this.members != null) {
            buf.append("(");
            for (String name : this.members.keySet()) {
                buf.append(name).append("=").append(this.getMemberValue(name)).append(", ");
            }
            buf.setLength(buf.length() - 2);
            buf.append(")");
        }
        return buf.toString();
    }

    public String getTypeName() {
        return Descriptor.toClassName(this.pool.getUtf8Info(this.typeIndex));
    }

    public Set<String> getMemberNames() {
        if (this.members == null) {
            return null;
        }
        return this.members.keySet();
    }

    public MemberValue getMemberValue(String name) {
        if (this.members == null || this.members.get(name) == null) {
            return null;
        }
        return this.members.get((Object)name).value;
    }

    public Object toAnnotationType(ClassLoader cl, ClassPool cp) throws ClassNotFoundException, NoSuchClassError {
        Class<?> clazz = MemberValue.loadClass(cl, this.getTypeName());
        try {
            return AnnotationImpl.make(cl, clazz, cp, this);
        } catch (IllegalArgumentException e2) {
            throw new ClassNotFoundException(clazz.getName(), e2);
        } catch (IllegalAccessError e2) {
            throw new ClassNotFoundException(clazz.getName(), e2);
        }
    }

    public void write(AnnotationsWriter writer) throws IOException {
        String typeName = this.pool.getUtf8Info(this.typeIndex);
        if (this.members == null) {
            writer.annotation(typeName, 0);
            return;
        }
        writer.annotation(typeName, this.members.size());
        for (Pair pair : this.members.values()) {
            writer.memberValuePair(pair.name);
            pair.value.write(writer);
        }
    }

    public int hashCode() {
        return this.getTypeName().hashCode() + (this.members == null ? 0 : this.members.hashCode());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || !(obj instanceof Annotation)) {
            return false;
        }
        Annotation other = (Annotation)obj;
        if (!this.getTypeName().equals(other.getTypeName())) {
            return false;
        }
        Map<String, Pair> otherMembers = other.members;
        if (this.members == otherMembers) {
            return true;
        }
        if (this.members == null) {
            return otherMembers == null;
        }
        if (otherMembers == null) {
            return false;
        }
        return this.members.equals(otherMembers);
    }

    static class Pair {
        int name;
        MemberValue value;

        Pair() {
        }
    }
}

