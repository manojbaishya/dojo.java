package org.dojo.algorithms;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class EasyProblems {
    private int getRomanValue(char key) {
        return switch (key) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            case 'M' -> 1000;
            default -> 0;
        };
    }

    private boolean isSubtractRuleApply(char key, char value) {
        return switch (key) {
            case 'I' -> value == 'V' || value == 'X';
            case 'X' -> value == 'L' || value == 'C';
            case 'C' -> value == 'D' || value == 'M';
            default -> false;
        };
    }

    public int romanToInt(String s) {
        Queue<Character> chars = new ArrayDeque<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            chars.add(s.charAt(i));
        }

        int sum = 0;
        while (!chars.isEmpty()) {
            char curr = chars.remove();
            if (chars.isEmpty()) {
                sum += getRomanValue(curr);
                break;
            }

            char next = chars.peek();

            if (next != curr && isSubtractRuleApply(curr, next)) {
                next = chars.remove();
                sum += getRomanValue(next) - getRomanValue(curr);
            } else if (next != curr && !isSubtractRuleApply(curr, next)) {
                sum += getRomanValue(curr);
            } else if (next == curr) {
                next = chars.remove();

                if (chars.isEmpty()) {
                    sum += getRomanValue(curr) * 2;
                    break;
                }

                char third = chars.peek();
                if (third != next) {
                    sum += getRomanValue(curr) * 2;
                } else {
                    chars.remove();
                    sum += getRomanValue(curr) * 3;
                }
            }
        }

        return sum;
    }

    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String first = strs[0];
        String last = strs[strs.length - 1];

        int minLength = Math.min(first.length(), last.length());

        int idx = 0;
        while (idx < minLength && first.charAt(idx) == last.charAt(idx)) idx++;

        return first.substring(0, idx);
    }

    public void mergeSortedArrays(int[] nums1, int m, int[] nums2, int n) {
        int k = m + n - 1;
        int i = m - 1;
        int j = n - 1;

        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k] = nums1[i];
                k--;
                i--;
            } else {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }

        if (i < 0 && j >= 0) {
            while (j >= 0) {
                nums1[k] = nums2[j];
                k--;
                j--;
            }
        }
    }
}
