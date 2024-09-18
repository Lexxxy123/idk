/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTList;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTree;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class ArrayInit
extends ASTList {
    private static final long serialVersionUID = 1L;

    public ArrayInit(ASTree firstElement) {
        super(firstElement);
    }

    public int size() {
        int s2 = this.length();
        if (s2 == 1 && this.head() == null) {
            return 0;
        }
        return s2;
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atArrayInit(this);
    }

    @Override
    public String getTag() {
        return "array";
    }
}

