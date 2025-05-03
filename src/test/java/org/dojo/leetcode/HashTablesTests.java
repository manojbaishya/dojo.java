package org.dojo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class HashTablesTests {
    private HashTables sut;
    @BeforeEach
    void setUp() {
        sut = new HashTables();
    }

    private static Stream<Arguments> countFrequenciesTestData() {
        return Stream.of(
                Arguments.of(new int[] {2, 3, 2, 3, 5}, new int[] {0, 2, 2, 0, 1}),
                Arguments.of(new int[] {3, 3, 3, 3}, new int[] {0, 0, 4, 0}),
                Arguments.of(new int[] {1}, new int[] {1})
        );
    }

    @ParameterizedTest
    @MethodSource("countFrequenciesTestData")
    void countFrequencies(int[] input, int[] expected) {
        int[] actual = sut.countFrequencies(input);
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testData() {
        return Stream.of(
                Arguments.of(new int[] {2, 7, 11, 15}, 9, new int[] {0, 1}),
                Arguments.of(new int[] {3, 2, 4}, 6, new int[] {1, 2}),
                Arguments.of(new int[] {3, 3}, 6, new int[] {0, 1}),
                Arguments.of(new int[] {3, 2, 3}, 6, new int[] {0, 2}),
                Arguments.of(new int[] {0, 4, 3, 0}, 0, new int[] {0, 3}),
                Arguments.of(new int[] {-3, 4, 3, 90}, 0, new int[] {0, 2}),
                Arguments.of(new int[] {-1, -2, -3, -4, -5}, -8, new int[] {2, 4}),
                Arguments.of(new int[] {-10, -1, -18, -19}, -19, new int[] {1, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("testData")
    public void testTwoSum(int[] inputArray, int inputTarget, int[] expected) {
        int[] actual = sut.twoSum(inputArray, inputTarget);
        System.out.printf("%s%n", Arrays.toString(expected));
        System.out.printf("%s%n", Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}
