/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTree;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class StringL
extends ASTree {
    private static final long serialVersionUID = 1L;
    protected String text;

    public StringL(String t2) {
        this.text = t2;
    }

    public String get() {
        return this.text;
    }

    @Override
    public String toString() {
        return "\"" + this.text + "\"";
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atStringL(this);
    }
}

