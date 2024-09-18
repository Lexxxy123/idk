/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.bytecode;

import de.tr7zw.nbtinjector.javassist.Modifier;
import de.tr7zw.nbtinjector.javassist.bytecode.AccessFlag;
import de.tr7zw.nbtinjector.javassist.bytecode.AnnotationsAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.AttributeInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.BadBytecode;
import de.tr7zw.nbtinjector.javassist.bytecode.ClassFile;
import de.tr7zw.nbtinjector.javassist.bytecode.CodeAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.FieldInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.MethodInfo;
import de.tr7zw.nbtinjector.javassist.bytecode.ParameterAnnotationsAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.SignatureAttribute;
import de.tr7zw.nbtinjector.javassist.bytecode.StackMap;
import de.tr7zw.nbtinjector.javassist.bytecode.StackMapTable;
import java.io.PrintWriter;
import java.util.List;

public class ClassFilePrinter {
    public static void print(ClassFile cf) {
        ClassFilePrinter.print(cf, new PrintWriter(System.out, true));
    }

    public static void print(ClassFile cf, PrintWriter out) {
        int mod = AccessFlag.toModifier(cf.getAccessFlags() & 0xFFFFFFDF);
        out.println("major: " + cf.major + ", minor: " + cf.minor + " modifiers: " + Integer.toHexString(cf.getAccessFlags()));
        out.println(Modifier.toString(mod) + " class " + cf.getName() + " extends " + cf.getSuperclass());
        String[] infs = cf.getInterfaces();
        if (infs != null && infs.length > 0) {
            out.print("    implements ");
            out.print(infs[0]);
            for (int i2 = 1; i2 < infs.length; ++i2) {
                out.print(", " + infs[i2]);
            }
            out.println();
        }
        out.println();
        List<FieldInfo> fields = cf.getFields();
        for (FieldInfo finfo : fields) {
            int acc = finfo.getAccessFlags();
            out.println(Modifier.toString(AccessFlag.toModifier(acc)) + " " + finfo.getName() + "\t" + finfo.getDescriptor());
            ClassFilePrinter.printAttributes(finfo.getAttributes(), out, 'f');
        }
        out.println();
        List<MethodInfo> methods = cf.getMethods();
        for (MethodInfo minfo : methods) {
            int acc = minfo.getAccessFlags();
            out.println(Modifier.toString(AccessFlag.toModifier(acc)) + " " + minfo.getName() + "\t" + minfo.getDescriptor());
            ClassFilePrinter.printAttributes(minfo.getAttributes(), out, 'm');
            out.println();
        }
        out.println();
        ClassFilePrinter.printAttributes(cf.getAttributes(), out, 'c');
    }

    static void printAttributes(List<AttributeInfo> list, PrintWriter out, char kind) {
        if (list == null) {
            return;
        }
        for (AttributeInfo ai2 : list) {
            if (ai2 instanceof CodeAttribute) {
                CodeAttribute ca = (CodeAttribute)ai2;
                out.println("attribute: " + ai2.getName() + ": " + ai2.getClass().getName());
                out.println("max stack " + ca.getMaxStack() + ", max locals " + ca.getMaxLocals() + ", " + ca.getExceptionTable().size() + " catch blocks");
                out.println("<code attribute begin>");
                ClassFilePrinter.printAttributes(ca.getAttributes(), out, kind);
                out.println("<code attribute end>");
                continue;
            }
            if (ai2 instanceof AnnotationsAttribute) {
                out.println("annnotation: " + ai2.toString());
                continue;
            }
            if (ai2 instanceof ParameterAnnotationsAttribute) {
                out.println("parameter annnotations: " + ai2.toString());
                continue;
            }
            if (ai2 instanceof StackMapTable) {
                out.println("<stack map table begin>");
                StackMapTable.Printer.print((StackMapTable)ai2, out);
                out.println("<stack map table end>");
                continue;
            }
            if (ai2 instanceof StackMap) {
                out.println("<stack map begin>");
                ((StackMap)ai2).print(out);
                out.println("<stack map end>");
                continue;
            }
            if (ai2 instanceof SignatureAttribute) {
                SignatureAttribute sa = (SignatureAttribute)ai2;
                String sig = sa.getSignature();
                out.println("signature: " + sig);
                try {
                    String s2 = kind == 'c' ? SignatureAttribute.toClassSignature(sig).toString() : (kind == 'm' ? SignatureAttribute.toMethodSignature(sig).toString() : SignatureAttribute.toFieldSignature(sig).toString());
                    out.println("           " + s2);
                } catch (BadBytecode e2) {
                    out.println("           syntax error");
                }
                continue;
            }
            out.println("attribute: " + ai2.getName() + " (" + ai2.get().length + " byte): " + ai2.getClass().getName());
        }
    }
}

