package org.dojo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stacks {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>(asteroids.length);

        for (int num : asteroids) {
            float sign = Math.signum(num);

            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }

            if (Math.signum(stack.peek()) != sign) {
                if (Math.signum(stack.peek()) > sign) {
                    while (!stack.isEmpty() && Math.signum(stack.peek()) > sign) {
                        int top = stack.peek();

                        if (Math.abs(top) > Math.abs(num)) break;

                        if (Math.abs(top) == Math.abs(num)) {
                            stack.pop();
                            break;
                        } else if (Math.abs(top) < Math.abs(num)) {
                            stack.pop();

                            if (stack.isEmpty()) stack.push(num);
                            else if (Math.signum(stack.peek()) <= sign) stack.push(num);
                        }
                    }
                } else {
                    stack.push(num);
                }
            } else {
                stack.push(num);
            }
        }

        return stack.reversed().stream().mapToInt(i -> i).toArray();
    }

    // public boolean isValid(String s) {
    //     Deque<Bracket> stack = new ArrayDeque<>();
    //     for (int i = 0; i < s.length(); i++) {
    //         char c = s.charAt(i);
    //         Bracket bracket = Bracket.fromSymbol(c);
    //
    //         if (stack.isEmpty()) {stack.push(bracket)}
    //
    //         ;
    //     }
    //
    //     return false;
    // }

    enum Bracket {
        PARENTHESES('(', ')'),
        BRACES('{', '}'),
        BRACKETS('[', ']');

        Bracket(char openSymbol, char closeSymbol) {
            this.openSymbol = openSymbol;
            this.closeSymbol = closeSymbol;
        }
        private final char openSymbol;
        public char getOpenSymbol() { return openSymbol; }

        private final char closeSymbol;
        public char getCloseSymbol() { return closeSymbol; }

        enum State {
            OPEN,
            CLOSED
        }

        public char getSymbol(State state) { return state == State.OPEN ? openSymbol : closeSymbol; }

        public static Bracket fromSymbol(char symbol) {
            for (Bracket bracket : Bracket.values()) {
                if (bracket.getOpenSymbol() == symbol || bracket.getCloseSymbol() == symbol) {
                    return bracket;
                }
            }
            throw new IllegalArgumentException("Unknown symbol: " + symbol);
        }

        public static boolean isMatching(char openSymbol, char closeSymbol) {
            return fromSymbol(openSymbol).getCloseSymbol() == closeSymbol;
        }
    }
}
