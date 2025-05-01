package org.dojo.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class Stack {
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
                    while (Math.signum(stack.peek()) > sign) {
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
}
