/*
 * Decompiled with CFR 0.153-SNAPSHOT (d6f6758-dirty).
 */
package de.slikey.exp4j.tokenizer;

import de.slikey.exp4j.function.Function;
import de.slikey.exp4j.function.Functions;
import de.slikey.exp4j.operator.Operator;
import de.slikey.exp4j.operator.Operators;
import de.slikey.exp4j.tokenizer.ArgumentSeparatorToken;
import de.slikey.exp4j.tokenizer.CloseParenthesesToken;
import de.slikey.exp4j.tokenizer.FunctionToken;
import de.slikey.exp4j.tokenizer.NumberToken;
import de.slikey.exp4j.tokenizer.OpenParenthesesToken;
import de.slikey.exp4j.tokenizer.OperatorToken;
import de.slikey.exp4j.tokenizer.Token;
import de.slikey.exp4j.tokenizer.VariableToken;
import java.util.Map;
import java.util.Set;

public class Tokenizer {
    private final char[] expression;
    private final int expressionLength;
    private final Map<String, Function> userFunctions;
    private final Map<String, Operator> userOperators;
    private final Set<String> variableNames;
    private int pos = 0;
    private Token lastToken;

    public Tokenizer(String expression, Map<String, Function> userFunctions, Map<String, Operator> userOperators, Set<String> variableNames) {
        this.expression = expression.trim().toCharArray();
        this.expressionLength = this.expression.length;
        this.userFunctions = userFunctions;
        this.userOperators = userOperators;
        this.variableNames = variableNames;
    }

    public boolean hasNext() {
        return this.expression.length > this.pos;
    }

    public Token nextToken() {
        char ch = this.expression[this.pos];
        while (Character.isWhitespace(ch)) {
            ch = this.expression[++this.pos];
        }
        if (Character.isDigit(ch) || ch == '.') {
            if (this.lastToken != null) {
                if (this.lastToken.getType() == 1) {
                    throw new IllegalArgumentException("Unable to parse char '" + ch + "' (Code:" + ch + ") at [" + this.pos + "]");
                }
                if (this.lastToken.getType() != 2 && this.lastToken.getType() != 4 && this.lastToken.getType() != 3 && this.lastToken.getType() != 7) {
                    this.lastToken = new OperatorToken(Operators.getBuiltinOperator('*', 2));
                    return this.lastToken;
                }
            }
            return this.parseNumberToken(ch);
        }
        if (this.isArgumentSeparator(ch)) {
            return this.parseArgumentSeparatorToken(ch);
        }
        if (this.isOpenParentheses(ch)) {
            if (this.lastToken != null && this.lastToken.getType() != 2 && this.lastToken.getType() != 4 && this.lastToken.getType() != 3 && this.lastToken.getType() != 7) {
                this.lastToken = new OperatorToken(Operators.getBuiltinOperator('*', 2));
                return this.lastToken;
            }
            return this.parseParentheses(true);
        }
        if (this.isCloseParentheses(ch)) {
            return this.parseParentheses(false);
        }
        if (Operator.isAllowedOperatorChar(ch)) {
            return this.parseOperatorToken(ch);
        }
        if (Tokenizer.isAlphabetic(ch) || ch == '_') {
            if (this.lastToken != null && this.lastToken.getType() != 2 && this.lastToken.getType() != 4 && this.lastToken.getType() != 3 && this.lastToken.getType() != 7) {
                this.lastToken = new OperatorToken(Operators.getBuiltinOperator('*', 2));
                return this.lastToken;
            }
            return this.parseFunctionOrVariable();
        }
        throw new IllegalArgumentException("Unable to parse char '" + ch + "' (Code:" + ch + ") at [" + this.pos + "]");
    }

    private Token parseArgumentSeparatorToken(char ch) {
        ++this.pos;
        this.lastToken = new ArgumentSeparatorToken();
        return this.lastToken;
    }

    private boolean isArgumentSeparator(char ch) {
        return ch == ',';
    }

    private Token parseParentheses(boolean open) {
        this.lastToken = open ? new OpenParenthesesToken() : new CloseParenthesesToken();
        ++this.pos;
        return this.lastToken;
    }

    private boolean isOpenParentheses(char ch) {
        return ch == '(' || ch == '{' || ch == '[';
    }

    private boolean isCloseParentheses(char ch) {
        return ch == ')' || ch == '}' || ch == ']';
    }

    private Token parseFunctionOrVariable() {
        int offset = this.pos++;
        int lastValidLen = 1;
        Token lastValidToken = null;
        int len = 1;
        if (this.isEndOfExpression(offset)) {
            // empty if block
        }
        while (!this.isEndOfExpression(offset + len - 1) && (Tokenizer.isAlphabetic(this.expression[offset + len - 1]) || Character.isDigit(this.expression[offset + len - 1]) || this.expression[offset + len - 1] == '_')) {
            String name = new String(this.expression, offset, len);
            if (this.variableNames != null && this.variableNames.contains(name)) {
                lastValidLen = len;
                lastValidToken = new VariableToken(name);
            } else {
                Function f2 = this.getFunction(name);
                if (f2 != null) {
                    lastValidLen = len;
                    lastValidToken = new FunctionToken(f2);
                }
            }
            ++len;
        }
        if (lastValidToken == null) {
            throw new IllegalArgumentException("Unable to parse setVariable or function starting at pos " + this.pos + " in expression '" + new String(this.expression) + "'");
        }
        this.pos += lastValidLen;
        this.lastToken = lastValidToken;
        return this.lastToken;
    }

    private Function getFunction(String name) {
        Function f2 = null;
        if (this.userFunctions != null) {
            f2 = this.userFunctions.get(name);
        }
        if (f2 == null) {
            f2 = Functions.getBuiltinFunction(name);
        }
        return f2;
    }

    private Token parseOperatorToken(char firstChar) {
        int offset = this.pos;
        int len = 1;
        StringBuilder symbol = new StringBuilder();
        Operator lastValid = null;
        symbol.append(firstChar);
        while (!this.isEndOfExpression(offset + len) && Operator.isAllowedOperatorChar(this.expression[offset + len])) {
            symbol.append(this.expression[offset + len++]);
        }
        while (symbol.length() > 0) {
            Operator op = this.getOperator(symbol.toString());
            if (op == null) {
                symbol.setLength(symbol.length() - 1);
                continue;
            }
            lastValid = op;
            break;
        }
        this.pos += symbol.length();
        this.lastToken = new OperatorToken(lastValid);
        return this.lastToken;
    }

    private Operator getOperator(String symbol) {
        Operator op = null;
        if (this.userOperators != null) {
            op = this.userOperators.get(symbol);
        }
        if (op == null && symbol.length() == 1) {
            int argc = this.lastToken == null || this.lastToken.getType() == 2 || this.lastToken.getType() == 4 || this.lastToken.getType() == 7 ? 1 : 2;
            op = Operators.getBuiltinOperator(symbol.charAt(0), argc);
        }
        return op;
    }

    private Token parseNumberToken(char firstChar) {
        int offset;
        int len = 1;
        if (this.isEndOfExpression((offset = this.pos++) + len)) {
            this.lastToken = new NumberToken(Double.parseDouble(String.valueOf(firstChar)));
            return this.lastToken;
        }
        while (!this.isEndOfExpression(offset + len) && Tokenizer.isNumeric(this.expression[offset + len], this.expression[offset + len - 1] == 'e' || this.expression[offset + len - 1] == 'E')) {
            ++len;
            ++this.pos;
        }
        if (this.expression[offset + len - 1] == 'e' || this.expression[offset + len - 1] == 'E') {
            --len;
            --this.pos;
        }
        this.lastToken = new NumberToken(this.expression, offset, len);
        return this.lastToken;
    }

    private static boolean isNumeric(char ch, boolean lastCharE) {
        return Character.isDigit(ch) || ch == '.' || ch == 'e' || ch == 'E' || lastCharE && (ch == '-' || ch == '+');
    }

    public static boolean isAlphabetic(int codePoint) {
        return Character.isLetter(codePoint);
    }

    private boolean isEndOfExpression(int offset) {
        return this.expressionLength <= offset;
    }
}

