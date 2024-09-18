/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j.tokenizer;

import de.slikey.exp4j.function.Function;
import de.slikey.exp4j.tokenizer.Token;

public class FunctionToken
extends Token {
    private final Function function;

    public FunctionToken(Function function) {
        super(3);
        this.function = function;
    }

    public Function getFunction() {
        return this.function;
    }
}

