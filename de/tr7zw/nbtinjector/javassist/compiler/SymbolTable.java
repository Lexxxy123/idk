/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.tr7zw.nbtinjector.javassist.compiler;

import de.tr7zw.nbtinjector.javassist.compiler.ast.Declarator;
import java.util.HashMap;

public final class SymbolTable
extends HashMap<String, Declarator> {
    private static final long serialVersionUID = 1L;
    private SymbolTable parent;

    public SymbolTable() {
        this((SymbolTable)null);
    }

    public SymbolTable(SymbolTable p2) {
        this.parent = p2;
    }

    public SymbolTable getParent() {
        return this.parent;
    }

    public Declarator lookup(String name) {
        Declarator found = (Declarator)this.get(name);
        if (found == null && this.parent != null) {
            return this.parent.lookup(name);
        }
        return found;
    }

    public void append(String name, Declarator value) {
        this.put(name, value);
    }
}

