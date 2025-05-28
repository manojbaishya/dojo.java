package org.dojo.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class RecursionTests {
    private Recursion sut;

    @BeforeEach
    void setUp() { sut = new Recursion(); }

    static Stream<Arguments> printStringNTimesData() {
        return Stream.of(
                Arguments.of("Ramesh", 6),
                Arguments.of("Suresh", 15),
                Arguments.of("Mahesh", 20),
                Arguments.of("Five Star", 35)
        );
    }
    @ParameterizedTest
    @MethodSource("printStringNTimesData")
    void printStringNTimes(String name, int count) {
        sut.printStringNTimes(name, 0, count);
    }

    static Stream<Arguments> printNTimesData() {
        return Stream.of(
                Arguments.of(6),
                Arguments.of(15),
                Arguments.of(20),
                Arguments.of(35)
        );
    }
    @ParameterizedTest
    @MethodSource("printNTimesData")
    void printNTimes(int count) {
        sut.printNTimes(0, count);
    }
    @ParameterizedTest
    @MethodSource("printNTimesData")
    void printNTimesReverse(int count) {
        sut.printNTimesReverse(count, count);
    }
    @ParameterizedTest
    @MethodSource("printNTimesData")
    void printNTimesBacktracking(int count) {
        sut.printNTimesBacktracking(count, count);
    }
    @ParameterizedTest
    @MethodSource("printNTimesData")
    void printNTimesReverseBacktracking(int count) {
        sut.printNTimesReverseBacktracking(1, count);
    }

    static Stream<Arguments> sumOfSeriesData() {
        return Stream.of(
                Arguments.of(6, 441.0),
                Arguments.of(15, 14400.0),
                Arguments.of(14, 11025.0),
                Arguments.of(11, 4356.0)
        );
    }
    @ParameterizedTest
    @MethodSource("sumOfSeriesData")
    void sumOfCubicSeries(int N, double expected) {
        double actual = sut.sumOfCubicSeries(N);
        assertEquals(expected, actual, 0.0001);
    }
    @ParameterizedTest
    @MethodSource("sumOfSeriesData")
    void sumOfCubicSeriesByFormula(int N, double expected) {
        double actual = sut.sumOfCubicSeriesByFormula(N);
        assertEquals(expected, actual, 0.0001);
    }

    static Stream<Arguments> sumOfNNumbersData() {
        return Stream.of(
                Arguments.of(6, 21.0),
                Arguments.of(15, 120.0),
                Arguments.of(14, 105.0),
                Arguments.of(11, 66.0)
        );
    }
    @ParameterizedTest
    @MethodSource("sumOfNNumbersData")
    void sumOfNNumbers(int N, double expected) {
        double actual = sut.sumOfNNumbers(N);
        assertEquals(expected, actual, 0.0001);
    }
    @ParameterizedTest
    @MethodSource("sumOfNNumbersData")
    void sumOfNNumbersByFormula(int N, double expected) {
        double actual = sut.sumOfNNumbersByFormula(N);
        assertEquals(expected, actual, 0.0001);
    }

    static Stream<Arguments> factorialData() {
        return Stream.of(
                Arguments.of(6, 720.0),
                Arguments.of(7, 5040.0),
                Arguments.of(9, 362880.0),
                Arguments.of(11, 39916800.0)
        );
    }
    @ParameterizedTest
    @MethodSource("factorialData")
    void factorial(int N, double expected) {
        double actual = sut.factorial(N);
        assertEquals(expected, actual, 0.0001);
    }

    static Stream<Arguments> reverseArrayData() {
        return Stream.of(
                Arguments.of(new int[] {5, 10, 15}, new int[] {15, 10, 5}),
                Arguments.of(new int[] {1, 2, 3, 4, 5}, new int[] {5, 4, 3, 2, 1}),
                Arguments.of(new int[] {7, 8, 9}, new int[] {9, 8, 7}),
                Arguments.of(new int[] {0, -1, -2}, new int[] {-2, -1, 0}),
                Arguments.of(new int[] {100}, new int[] {100})
        );
    }
    @ParameterizedTest
    @MethodSource("reverseArrayData")
    void reverseArray(int[] input, int[] expected) {
        int[] actual = sut.reverseArray(input);
        assertArrayEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("reverseArrayData")
    void reverseArrayWithSingleIndex(int[] input, int[] expected) {
        int[] actual = sut.reverseArrayWithSingleIndex(input);
        assertArrayEquals(expected, actual);
    }

    static Stream<Arguments> palindromeData() {
        return Stream.of(
                Arguments.of("madam", true),
                Arguments.of("racecar", true),
                Arguments.of("hello", false),
                Arguments.of("level", true),
                Arguments.of("world", false)
        );
    }
    @ParameterizedTest
    @MethodSource("palindromeData")
    void isPalindrome(String input, boolean expected) {
        boolean actual = sut.isPalindrome(input);
        assertEquals(expected, actual);
    }
    @ParameterizedTest
    @MethodSource("palindromeData")
    void isPalindromeChecks(String input, boolean expected) {
        boolean actual = sut.isPalindromeChecks(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> palindromeWithSanitizationData() {
        return Stream.of(
                Arguments.of("A man, a plan, a canal: Panama", true),
                Arguments.of("race a car", false),
                Arguments.of("", true)
        );
    }
    @ParameterizedTest
    @MethodSource("palindromeWithSanitizationData")
    void isPalindromeWithSanitization(String input, boolean expected) {
        boolean actual = sut.isPalindromeWithSanitization(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> fibonacciData() {
        return Stream.of(
                Arguments.of(10, 55),
                Arguments.of(16, 987),
                Arguments.of(19, 4181)
        );
    }
    @ParameterizedTest
    @MethodSource("fibonacciData")
    void fibonacciRecursive(int input, int expected) {
        int actual = sut.fibonacciRecursive(input);
        assertEquals(expected, actual);
    }
}
