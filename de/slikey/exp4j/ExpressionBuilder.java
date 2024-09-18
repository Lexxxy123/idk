/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j;

import de.slikey.exp4j.Expression;
import de.slikey.exp4j.function.Function;
import de.slikey.exp4j.function.Functions;
import de.slikey.exp4j.operator.Operator;
import de.slikey.exp4j.shuntingyard.ShuntingYard;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExpressionBuilder {
    private final String expression;
    private final Map<String, Function> userFunctions;
    private final Map<String, Operator> userOperators;
    private final Set<String> variableNames;

    public ExpressionBuilder(String expression) {
        if (expression == null || expression.trim().length() == 0) {
            throw new IllegalArgumentException("Expression can not be empty");
        }
        this.expression = expression;
        this.userOperators = new HashMap<String, Operator>(4);
        this.userFunctions = new HashMap<String, Function>(4);
        this.variableNames = new HashSet<String>(4);
    }

    public ExpressionBuilder function(Function function) {
        this.userFunctions.put(function.getName(), function);
        return this;
    }

    public ExpressionBuilder functions(Function ... functions) {
        for (Function f2 : functions) {
            this.userFunctions.put(f2.getName(), f2);
        }
        return this;
    }

    public ExpressionBuilder functions(List<Function> functions) {
        for (Function f2 : functions) {
            this.userFunctions.put(f2.getName(), f2);
        }
        return this;
    }

    public ExpressionBuilder variables(Set<String> variableNames) {
        this.variableNames.addAll(variableNames);
        return this;
    }

    public ExpressionBuilder variables(String ... variableNames) {
        Collections.addAll(this.variableNames, variableNames);
        return this;
    }

    public ExpressionBuilder variable(String variableName) {
        this.variableNames.add(variableName);
        return this;
    }

    public ExpressionBuilder operator(Operator operator) {
        this.checkOperatorSymbol(operator);
        this.userOperators.put(operator.getSymbol(), operator);
        return this;
    }

    private void checkOperatorSymbol(Operator op) {
        String name = op.getSymbol();
        for (char ch : name.toCharArray()) {
            if (Operator.isAllowedOperatorChar(ch)) continue;
            throw new IllegalArgumentException("The operator symbol '" + name + "' is invalid");
        }
    }

    public ExpressionBuilder operator(Operator ... operators) {
        for (Operator o2 : operators) {
            this.operator(o2);
        }
        return this;
    }

    public ExpressionBuilder operator(List<Operator> operators) {
        for (Operator o2 : operators) {
            this.operator(o2);
        }
        return this;
    }

    public Expression build() {
        if (this.expression.length() == 0) {
            throw new IllegalArgumentException("The expression can not be empty");
        }
        for (String var : this.variableNames) {
            if (Functions.getBuiltinFunction(var) == null && !this.userFunctions.containsKey(var)) continue;
            throw new IllegalArgumentException("A variable can not have the same name as a function [" + var + "]");
        }
        return new Expression(ShuntingYard.convertToRPN(this.expression, this.userFunctions, this.userOperators, this.variableNames), this.userFunctions.keySet());
    }
}

