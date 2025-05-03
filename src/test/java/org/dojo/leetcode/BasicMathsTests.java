package org.dojo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class BasicMathsTest {
    private BasicMaths sut;

    @BeforeEach
    void setUp() {
        sut = new BasicMaths();
    }

    static Stream<Arguments> evenlyDividesData() {
        return Stream.of(
                Arguments.of(12, 2)
        );
    }

    @ParameterizedTest
    @MethodSource("evenlyDividesData")
    void evenlyDivides(int number, int expected) {
        int actual = sut.evenlyDivides(number);
        System.out.printf("Expected: %d%n", expected);
        System.out.printf("Actual: %d%n", actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> reverseIntegerData() {
        return Stream.of(
                Arguments.of(9854, 4589),
                Arguments.of(1534236469, 0),
                Arguments.of(-9854, -4589)
        );
    }

    @ParameterizedTest
    @MethodSource("reverseIntegerData")
    void reverseInteger(int number, int expected) {
        int actual = sut.reverseInteger(number);
        System.out.printf("Expected: %d%n", expected);
        System.out.printf("Actual: %d%n", actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> isPalindromeData() {
        return Stream.of(
                Arguments.of(121, true),
                Arguments.of(-121, false),
                Arguments.of(10, false)
        );
    }

    @ParameterizedTest
    @MethodSource("isPalindromeData")
    void isPalindrome(int number, boolean expected) {
        boolean actual = sut.isPalindrome(number);
        System.out.printf("Expected: %b%n", expected);
        System.out.printf("Actual: %b%n", actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> isArmstrongNumberData() {
        return Stream.of(
                Arguments.of(371, true),
                Arguments.of(1634, false),
                Arguments.of(35, false)
        );
    }

    @ParameterizedTest
    @MethodSource("isArmstrongNumberData")
    void isArmstrongNumber(int number, boolean expected) {
        boolean actual = sut.isArmstrongNumber(number);
        System.out.printf("Expected: %b%n", expected);
        System.out.printf("Actual: %b%n", actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> getAllDivisorsData() {
        return Stream.of(
                Arguments.of(36, new int[] {36, 18, 12, 9, 6, 4, 3, 2, 1})
        );
    }

    @ParameterizedTest
    @MethodSource("getAllDivisorsData")
    void getAllDivisors(int number, int[] expected) {
        List<Integer> actual = sut.getAllDivisorsDesc(number);
        System.out.printf("Expected: %s%n", Arrays.toString(expected));
        System.out.printf("Actual: %s%n", actual);
        assertArrayEquals(expected, actual.stream().mapToInt(i -> i).toArray());
    }

    static Stream<Arguments> isPrimeData() {
        return Stream.of(
                Arguments.of(36, false),
                Arguments.of(13, true),
                Arguments.of(11, true),
                Arguments.of(1, false)
        );
    }

    @ParameterizedTest
    @MethodSource("isPrimeData")
    void isPrime(int number, boolean expected) {
        boolean actual = sut.isPrime(number);
        System.out.printf("Expected: %b%n", expected);
        System.out.printf("Actual: %b%n", actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> highestCommonFactorData() {
        return Stream.of(
                Arguments.of(12, 6, 6),
                Arguments.of(27, 18, 9),
                Arguments.of(11, 13, 1)
        );
    }

    @ParameterizedTest
    @MethodSource("highestCommonFactorData")
    void highestCommonFactor(int M, int N, int expected) {
        int actual = sut.highestCommonFactor(M, N);
        System.out.printf("Expected: %d%n", expected);
        System.out.printf("Actual: %d%n", actual);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("highestCommonFactorData")
    void highestCommonFactorEuclidean(int M, int N, int expected) {
        int actual = sut.highestCommonFactorEuclidean(M, N);
        System.out.printf("Expected: %d%n", expected);
        System.out.printf("Actual: %d%n", actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> leastCommonMultipleData() {
        return Stream.of(
                Arguments.of(12, 6, 12),
                Arguments.of(27, 18, 54),
                Arguments.of(11, 13, 143)
        );
    }

    @ParameterizedTest
    @MethodSource("leastCommonMultipleData")
    void leastCommonMultiple(int M, int N, int expected) {
        int actual = sut.leastCommonMultiple(M, N);
        System.out.printf("Expected: %d%n", expected);
        System.out.printf("Actual: %d%n", actual);
        assertEquals(expected, actual);
    }
}
