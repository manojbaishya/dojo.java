package org.dojo.leetcode;

public enum Bracket {
    PARENTHESES_OPEN('('),
    PARENTHESES_CLOSED(')'),
    BRACES_OPEN('{'),
    BRACES_CLOSED('}'),
    BRACKETS_OPEN('['),
    BRACKETS_CLOSED(']');

    Bracket(char symbol) {
        this.symbol = symbol;
    }
    private final char symbol;
    public char getSymbol() { return symbol; }

    public static Bracket fromSymbol(char symbol) {
        for (Bracket bracket : Bracket.values()) {
            if (bracket.getSymbol() == symbol) return bracket;
        }
        throw new IllegalArgumentException("Invalid symbol: " + symbol);
    }

    public boolean isMatching(Bracket other) {
        return switch (this) {
            case PARENTHESES_OPEN -> other.equals(PARENTHESES_CLOSED);
            case BRACES_OPEN -> other.equals(BRACES_CLOSED);
            case BRACKETS_OPEN -> other.equals(BRACKETS_CLOSED);
            case PARENTHESES_CLOSED, BRACES_CLOSED, BRACKETS_CLOSED -> false;
        };
    }
}
