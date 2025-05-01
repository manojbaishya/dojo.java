package org.dojo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

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

    public boolean isValid(String s) {
        Deque<Character> bracketPairs = new ArrayDeque<>(s.length() / 2 + 1);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (bracketPairs.isEmpty()) {
                bracketPairs.push(c);
                continue;
            }

            if (isMatching(bracketPairs.peek(), c)) bracketPairs.pop();
            else bracketPairs.push(c);
        }

        return bracketPairs.isEmpty();
    }

    boolean isMatching(char self, char other) { return (self == '(' && other == ')') || (self == '{' && other == '}') || (self == '[' && other == ']'); }

    public String reversePrefix(String word, char ch) {
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                return new StringBuilder(word.substring(0, i + 1)).reverse().append(word, i + 1, word.length()).toString();
            }
        }
        return word;
    }

    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>(operations.length);
        for (String op : operations) {
            switch(op) {
                case "+":
                    int sum = 0;
                    Iterator<Integer> ptr = stack.iterator();
                    if (ptr.hasNext()) sum += ptr.next();
                    if (ptr.hasNext()) sum += ptr.next();
                    stack.push(sum);
                    break;
                case "D":
                    if (!stack.isEmpty()) stack.push(stack.peek() * 2);
                    break;
                case "C":
                    if (!stack.isEmpty()) stack.pop();
                    break;
                default:
                    stack.push(Integer.parseInt(op));
            }
        }

        return stack.stream().mapToInt(i -> i).sum();
    }
}
