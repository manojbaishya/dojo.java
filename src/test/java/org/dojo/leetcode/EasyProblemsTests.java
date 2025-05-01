package org.dojo.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class EasyProblemsTests {
    private final EasyProblems sut = new EasyProblems();

    static Stream<Arguments> romanToIntData() {
        return Stream.of(
                Arguments.of("III", 3),
                Arguments.of("LVIII", 58),
                Arguments.of("MCMXCIV", 1994),
                Arguments.of("MMMCMXCIX", 3999),
                Arguments.of("MMMCXCIX", 3199),
                Arguments.of("XLIX", 49),
                Arguments.of("CMXCIX", 999)
        );
    }

    @ParameterizedTest
    @MethodSource("romanToIntData")
    void romanToInt(String input, int expected) {
        int actual = sut.romanToInt(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> longestCommonPrefixData() {
        return Stream.of(
                Arguments.of(new String[] {"flower", "flow", "flight"}, "fl"),
                Arguments.of(new String[] {"dog", "racecar", "car"}, "")
        );
    }

    @ParameterizedTest
    @MethodSource("longestCommonPrefixData")
    void longestCommonPrefix(String[] input, String expected) {
        String actual = sut.longestCommonPrefix(input);
        System.out.printf("Expected: %s, Actual: %s\n", expected, actual);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> mergeSortedArraysData() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3, new int[] {1, 2, 2, 3, 5, 6})
        );
    }

    @ParameterizedTest
    @MethodSource("mergeSortedArraysData")
    public void mergeSortedArrays(int[] input1, int m, int[] input2, int n, int[] expected) {
        sut.mergeSortedArrays(input1, m, input2, n);
        assertArrayEquals(expected, input1);
    }
}
