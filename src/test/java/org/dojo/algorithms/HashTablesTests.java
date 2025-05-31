package org.dojo.algorithms;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
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

    private static Stream<Arguments> testTwoSumData() {
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
    @MethodSource("testTwoSumData")
    public void testTwoSum(int[] inputArray, int inputTarget, int[] expected) {
        int[] actual = sut.twoSum(inputArray, inputTarget);
        System.out.printf("%s%n", Arrays.toString(expected));
        System.out.printf("%s%n", Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    private static Stream<Arguments> testTwoSumAlt2Data() {
        return Stream.of(
                Arguments.of(new int[] {2, 7, 11, 15}, 9, List.of(Pair.of(0, 1))),
                Arguments.of(new int[] {2, 7, 4, 5, 11, 15}, 9, List.of(Pair.of(0, 1), Pair.of(2, 3))),
                Arguments.of(new int[] {3, 2, 4}, 6, List.of(Pair.of(1, 2))),
                Arguments.of(new int[] {3, 3}, 6, List.of(Pair.of(0, 1))),
                Arguments.of(new int[] {3, 2, 3}, 6, List.of(Pair.of(0, 2))),
                Arguments.of(new int[] {0, 4, 3, 0}, 0, List.of(Pair.of(0, 3))),
                Arguments.of(new int[] {-3, 4, 3, 90}, 0, List.of(Pair.of(0, 2))),
                Arguments.of(new int[] {-1, -2, -3, -4, -5}, -8, List.of(Pair.of(2, 4))),
                Arguments.of(new int[] {-10, -1, -18, -19}, -19, List.of(Pair.of(1, 2))),
                Arguments.of(new int[] {1, 2, 3, 4, 5, 6}, 7, List.of(Pair.of(0, 5), Pair.of(1, 4), Pair.of(2, 3))),
                Arguments.of(new int[] {1, 2, 3}, 100, List.of())
        );
    }

    @ParameterizedTest
    @MethodSource("testTwoSumAlt2Data")
    public void testTwoSumAlt2(int[] inputArray, int inputTarget, List<Pair<Integer, Integer>> expected) {
        List<Pair<Integer, Integer>> actual = sut.twoSumAlt2(inputArray, inputTarget);
        assertThat(expected)
                .withFailMessage(() -> String.format("Expected pairs: %s, but got: %s", expected, actual))
                .containsAll(actual);
    }
}
