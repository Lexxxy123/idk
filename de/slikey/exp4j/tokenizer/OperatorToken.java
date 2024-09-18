/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j.tokenizer;

import de.slikey.exp4j.operator.Operator;
import de.slikey.exp4j.tokenizer.Token;

public class OperatorToken
extends Token {
    private final Operator operator;

    public OperatorToken(Operator op) {
        super(2);
        if (op == null) {
            throw new IllegalArgumentException("Operator is unknown for token.");
        }
        this.operator = op;
    }

    public Operator getOperator() {
        return this.operator;
    }
}

