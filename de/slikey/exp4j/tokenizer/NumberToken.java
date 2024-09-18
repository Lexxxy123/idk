/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j.tokenizer;

import de.slikey.exp4j.tokenizer.Token;

public final class NumberToken
extends Token {
    private final double value;

    public NumberToken(double value) {
        super(1);
        this.value = value;
    }

    NumberToken(char[] expression, int offset, int len) {
        this(Double.parseDouble(String.valueOf(expression, offset, len)));
    }

    public double getValue() {
        return this.value;
    }
}

