/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Declarator;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Symbol;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class Variable
extends Symbol {
    private static final long serialVersionUID = 1L;
    protected Declarator declarator;

    public Variable(String sym, Declarator d2) {
        super(sym);
        this.declarator = d2;
    }

    public Declarator getDeclarator() {
        return this.declarator;
    }

    @Override
    public String toString() {
        return this.identifier + ":" + this.declarator.getType();
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atVariable(this);
    }
}

