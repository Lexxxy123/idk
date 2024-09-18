/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler.ast;

import de.tr7zw.nbtinjector.javassist.compiler.CompileError;
import de.tr7zw.nbtinjector.javassist.compiler.ast.ASTree;
import de.tr7zw.nbtinjector.javassist.compiler.ast.Visitor;

public class Keyword
extends ASTree {
    private static final long serialVersionUID = 1L;
    protected int tokenId;

    public Keyword(int token) {
        this.tokenId = token;
    }

    public int get() {
        return this.tokenId;
    }

    @Override
    public String toString() {
        return "id:" + this.tokenId;
    }

    @Override
    public void accept(Visitor v2) throws CompileError {
        v2.atKeyword(this);
    }
}

