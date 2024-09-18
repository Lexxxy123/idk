/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j;

import de.slikey.exp4j.ArrayStack;
import de.slikey.exp4j.ValidationResult;
import de.slikey.exp4j.function.Function;
import de.slikey.exp4j.operator.Operator;
import de.slikey.exp4j.tokenizer.FunctionToken;
import de.slikey.exp4j.tokenizer.NumberToken;
import de.slikey.exp4j.tokenizer.OperatorToken;
import de.slikey.exp4j.tokenizer.Token;
import de.slikey.exp4j.tokenizer.VariableToken;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class Expression {
    private final Token[] tokens;
    private final Map<String, Double> variables;
    private final Set<String> userFunctionNames;

    Expression(Token[] tokens) {
        this.tokens = tokens;
        this.variables = new HashMap<String, Double>(4);
        this.userFunctionNames = Collections.emptySet();
    }

    Expression(Token[] tokens, Set<String> userFunctionNames) {
        this.tokens = tokens;
        this.variables = new HashMap<String, Double>(4);
        this.userFunctionNames = userFunctionNames;
    }

    public Expression setVariable(String name, double value) {
        this.checkVariableName(name);
        this.variables.put(name, value);
        return this;
    }

    private void checkVariableName(String name) {
        if (this.userFunctionNames.contains(name)) {
            throw new IllegalArgumentException("The setVariable name '" + name + "' is invalid. Since there exists a function with the same name");
        }
    }

    public Expression setVariables(Map<String, Double> variables) {
        for (Map.Entry<String, Double> v2 : variables.entrySet()) {
            this.setVariable(v2.getKey(), v2.getValue());
        }
        return this;
    }

    public ValidationResult validate(boolean checkVariablesSet) {
        ArrayList<String> errors = new ArrayList<String>(0);
        if (checkVariablesSet) {
            for (Token t2 : this.tokens) {
                String var;
                if (t2.getType() != 6 || this.variables.containsKey(var = ((VariableToken)t2).getName())) continue;
                errors.add("The setVariable '" + var + "' has not been set");
            }
        }
        int count = 0;
        for (Token tok : this.tokens) {
            switch (tok.getType()) {
                case 1: 
                case 6: {
                    ++count;
                    break;
                }
                case 3: {
                    Function func = ((FunctionToken)tok).getFunction();
                    int argsNum = func.getNumArguments();
                    if (argsNum > count) {
                        errors.add("Not enough arguments for '" + func.getName() + "'");
                    }
                    if (argsNum <= 1) break;
                    count -= argsNum - 1;
                    break;
                }
                case 2: {
                    Operator op = ((OperatorToken)tok).getOperator();
                    if (op.getNumOperands() != 2) break;
                    --count;
                }
            }
            if (count >= 1) continue;
            errors.add("Too many operators");
            return new ValidationResult(false, errors);
        }
        if (count > 1) {
            errors.add("Too many operands");
        }
        return errors.size() == 0 ? ValidationResult.SUCCESS : new ValidationResult(false, errors);
    }

    public ValidationResult validate() {
        return this.validate(true);
    }

    public Future<Double> evaluateAsync(ExecutorService executor) {
        return executor.submit(new Callable<Double>(){

            @Override
            public Double call() throws Exception {
                return Expression.this.evaluate();
            }
        });
    }

    public double evaluate() {
        ArrayStack output = new ArrayStack();
        for (int i2 = 0; i2 < this.tokens.length; ++i2) {
            Token t2 = this.tokens[i2];
            if (t2.getType() == 1) {
                output.push(((NumberToken)t2).getValue());
                continue;
            }
            if (t2.getType() == 6) {
                String name = ((VariableToken)t2).getName();
                Double value = this.variables.get(name);
                if (value == null) {
                    throw new IllegalArgumentException("No value has been set for the setVariable '" + name + "'.");
                }
                output.push(value);
                continue;
            }
            if (t2.getType() == 2) {
                OperatorToken op = (OperatorToken)t2;
                if (output.size() < op.getOperator().getNumOperands()) {
                    throw new IllegalArgumentException("Invalid number of operands available for '" + op.getOperator().getSymbol() + "' operator");
                }
                if (op.getOperator().getNumOperands() == 2) {
                    double rightArg = output.pop();
                    double leftArg = output.pop();
                    output.push(op.getOperator().apply(leftArg, rightArg));
                    continue;
                }
                if (op.getOperator().getNumOperands() != 1) continue;
                double arg = output.pop();
                output.push(op.getOperator().apply(arg));
                continue;
            }
            if (t2.getType() != 3) continue;
            FunctionToken func = (FunctionToken)t2;
            if (output.size() < func.getFunction().getNumArguments()) {
                throw new IllegalArgumentException("Invalid number of arguments available for '" + func.getFunction().getName() + "' function");
            }
            double[] args = new double[func.getFunction().getNumArguments()];
            for (int j2 = 0; j2 < func.getFunction().getNumArguments(); ++j2) {
                args[j2] = output.pop();
            }
            output.push(func.getFunction().apply(this.reverseInPlace(args)));
        }
        if (output.size() > 1) {
            throw new IllegalArgumentException("Invalid number of items on the output queue. Might be caused by an invalid number of arguments for a function.");
        }
        return output.pop();
    }

    private double[] reverseInPlace(double[] args) {
        int len = args.length;
        for (int i2 = 0; i2 < len / 2; ++i2) {
            double tmp = args[i2];
            args[i2] = args[len - i2 - 1];
            args[len - i2 - 1] = tmp;
        }
        return args;
    }
}

