package org.dojo.algorithms;

import java.util.regex.Pattern;

public class Recursion {
    public void printStringNTimes(String name, int iterations, int count) {
        iterations++;
        System.out.println("Name: " + name);

        if (iterations >= count) return;
        printStringNTimes(name, iterations, count);
    }

    public void printNTimes(int iterations, int count) {
        iterations++;
        System.out.println(iterations);

        if (iterations >= count) return;
        printNTimes(iterations, count);
    }

    public void printNTimesReverse(int iterations, int count) {
        System.out.println(String.valueOf(iterations));
        iterations--;

        if (iterations < 1) return;
        printNTimesReverse(iterations, count);
    }

    public void printNTimesBacktracking(int iterations, int count) {
        if (iterations < 1) return;
        printNTimesBacktracking(iterations - 1, count);
        System.out.println(iterations);
    }

    public void printNTimesReverseBacktracking(int iterations, int count) {
        if (iterations > count) return;
        printNTimesReverseBacktracking(iterations + 1, count);
        System.out.println(iterations);
    }

    public double sumOfCubicSeries(int n) {
        if (n == 1) return 1;
        return Math.pow(n, 3) + sumOfCubicSeries(n - 1);
    }

    public double sumOfCubicSeriesByFormula(int n) {
        return Math.pow((n * (n + 1.0)) / 2, 2);
    }

    public double sumOfNNumbers(int n) {
        if (n == 1) return 1;
        return n + sumOfNNumbers(n - 1);
    }

    public double sumOfNNumbersByFormula(int n) {
        return (n * (n + 1.0)) / 2;
    }

    public double factorial(int n) {
        if (n == 1) return 1;
        return n * factorial(n - 1);
    }

    public int[] reverseArray(int[] arr) {
        swap(arr, 0, arr.length - 1);
        return arr;
    }

    private void swap(int[] arr, int l, int r) {
        if (l >= r) return;
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        swap(arr, l + 1, r - 1);
    }

    public int[] reverseArrayWithSingleIndex(int[] arr) {
        reverse(arr, 0);
        return arr;
    }

    private void reverse(int[] arr, int i) {
        if (i >= arr.length / 2) return;
        int temp = arr[i];
        arr[i] = arr[arr.length - 1 - i];
        arr[arr.length - 1 - i] = temp;
        reverse(arr, i + 1);
    }

    public boolean isPalindrome(String inputString) {
        char[] str = inputString.toCharArray();
        reverseString(str, 0);
        String outputString = String.valueOf(str);
        return outputString.equalsIgnoreCase(inputString);
    }

    private void reverseString(char[] str, int i) {
        if (i >= str.length / 2) return;
        char temp = str[i];
        str[i] = str[str.length - 1 - i];
        str[str.length - 1 - i] = temp;
        reverseString(str, i + 1);
    }

    public boolean isPalindromeChecks(String inputString) {
        return reverseStringCheck(inputString.toCharArray(), 0);
    }

    private boolean reverseStringCheck(char[] str, int i) {
        if (i >= str.length / 2) return true;
        if (str[i] != str[str.length - 1 - i]) return false;
        return reverseStringCheck(str, i + 1);
    }

    private static final Pattern ALPHANUMERIC_FILTER = Pattern.compile("[^a-zA-Z0-9]");

    public boolean isPalindromeWithSanitization(String s) {
        String ip = ALPHANUMERIC_FILTER.matcher(s).replaceAll("").toLowerCase();
        return reverseStringCheck(ip.toCharArray(), 0);
    }

    public int fibonacciRecursive(int N) {
        if (N == 0) return 0;
        if (N == 1) return 1;
        return fibonacciRecursive(N - 1) + fibonacciRecursive(N - 2);
    }
}
