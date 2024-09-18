/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler;

import de.tr7zw.nbtinjector.javassist.CannotCompileException;
import de.tr7zw.nbtinjector.javassist.NotFoundException;
import de.tr7zw.nbtinjector.javassist.compiler.Lex;

public class CompileError
extends Exception {
    private static final long serialVersionUID = 1L;
    private Lex lex;
    private String reason;

    public CompileError(String s2, Lex l2) {
        this.reason = s2;
        this.lex = l2;
    }

    public CompileError(String s2) {
        this.reason = s2;
        this.lex = null;
    }

    public CompileError(CannotCompileException e2) {
        this(e2.getReason());
    }

    public CompileError(NotFoundException e2) {
        this("cannot find " + e2.getMessage());
    }

    public Lex getLex() {
        return this.lex;
    }

    @Override
    public String getMessage() {
        return this.reason;
    }

    @Override
    public String toString() {
        return "compile error: " + this.reason;
    }
}

