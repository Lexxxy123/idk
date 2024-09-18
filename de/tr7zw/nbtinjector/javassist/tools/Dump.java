/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.tools;

import de.tr7zw.nbtinjector.javassist.bytecode.ClassFile;
import de.tr7zw.nbtinjector.javassist.bytecode.ClassFilePrinter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.PrintWriter;

public class Dump {
    private Dump() {
    }

    public static void main(String[] args) throws Exception {
        if (args.length != 1) {
            System.err.println("Usage: java Dump <class file name>");
            return;
        }
        DataInputStream in = new DataInputStream(new FileInputStream(args[0]));
        ClassFile w2 = new ClassFile(in);
        PrintWriter out = new PrintWriter(System.out, true);
        out.println("*** constant pool ***");
        w2.getConstPool().print(out);
        out.println();
        out.println("*** members ***");
        ClassFilePrinter.print(w2, out);
    }
}

