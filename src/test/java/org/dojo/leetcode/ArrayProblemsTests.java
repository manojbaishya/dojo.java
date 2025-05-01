package org.dojo.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ArrayProblemsTests {
    private final ArrayProblems sut = new ArrayProblems();

    static Stream<Arguments> imageData() {
        return Stream.of(
                Arguments.of(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][] {{7, 4, 1}, {8, 5, 2}, {9, 6, 3}})
        );
    }

    @ParameterizedTest
    @MethodSource("imageData")
    void rotateImage(int[][] input, int[][] expected) {
        sut.rotateImage(input);
        assertArrayEquals(expected, input);
    }

    static Stream<Arguments> leadersData() {
        return Stream.of(
                Arguments.of(new int[] {16, 17, 4, 3, 5, 2}, new int[] {17, 5, 2})
        );
    }

    @ParameterizedTest
    @MethodSource("leadersData")
    public void leaders(int[] nums, int[] expected) {
        int[] actual = sut.leaders(nums).stream().mapToInt(i -> i).toArray();
        System.out.printf("Expected: %s, Actual: %s\n", Arrays.toString(expected), Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }
}
