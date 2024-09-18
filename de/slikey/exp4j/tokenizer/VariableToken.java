/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j.tokenizer;

import de.slikey.exp4j.tokenizer.Token;

public class VariableToken
extends Token {
    private final String name;

    public String getName() {
        return this.name;
    }

    public VariableToken(String name) {
        super(6);
        this.name = name;
    }
}

