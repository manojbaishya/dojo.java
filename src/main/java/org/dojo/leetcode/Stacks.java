package org.dojo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;

public class Stacks {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>(asteroids.length);

        for (int num : asteroids) {
            float sign = Math.signum(num);

            if (stack.isEmpty()) {
                stack.push(num);
                continue;
            }

            if (Math.signum(stack.peek()) > sign) {
                while (!stack.isEmpty() && Math.signum(stack.peek()) > sign) {
                    if (Math.abs(stack.peek()) > Math.abs(num)) break;
                    if (Math.abs(stack.peek()) == Math.abs(num)) {
                        stack.pop();
                        break;
                    }
                    if (Math.abs(stack.peek()) < Math.abs(num)) {
                        stack.pop();
                        if (stack.isEmpty() || Math.signum(stack.peek()) <= sign) stack.push(num);
                    }
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
            switch (op) {
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

    public int minOperations(String[] logs) {
        Deque<String> folderState = new ArrayDeque<>(logs.length);

        for (String log : logs) {
            switch (log) {
                case "./":
                    break;
                case "../":
                    if (!folderState.isEmpty()) folderState.pop();
                    break;
                default:
                    folderState.push(log);
            }
        }

        return folderState.size();
    }

    public int countStudents(int[] students, int[] sandwiches) {
        Deque<Integer> studentQueue = new ArrayDeque<>(students.length);
        for (int student : students) studentQueue.offer(student);

        Deque<Integer> sandwichQueue = new ArrayDeque<>(sandwiches.length);
        for (int sandwich : sandwiches) sandwichQueue.offer(sandwich);

        int rotations = studentQueue.size();
        do {
            if (Objects.equals(sandwichQueue.peek(), studentQueue.peek())) {
                sandwichQueue.remove();
                studentQueue.remove();
                rotations = studentQueue.size();
            } else {
                studentQueue.offer(studentQueue.remove());
                rotations--;
            }
        } while (rotations != 0);
        return studentQueue.size();
    }
}
