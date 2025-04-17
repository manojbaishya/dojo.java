package org.github;

import java.util.List;

public class ArrayTools {
    public int Sum(int[] arr) {
        int sum = 0;
        for (int j : arr) {
            sum += j;
        }
        return sum;
    }

    public int Sum(List<Integer> arr) {
        int sum = 0;
        for (Integer i : arr) {
            sum += i;
        }
        return sum;
    }
}
