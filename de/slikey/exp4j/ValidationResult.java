/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j;

import java.util.List;

public class ValidationResult {
    private final boolean valid;
    private final List<String> errors;
    public static final ValidationResult SUCCESS = new ValidationResult(true, null);

    public ValidationResult(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors;
    }

    public boolean isValid() {
        return this.valid;
    }

    public List<String> getErrors() {
        return this.errors;
    }
}

