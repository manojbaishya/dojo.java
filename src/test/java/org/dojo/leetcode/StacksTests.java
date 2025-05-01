package org.dojo.leetcode;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class StacksTests {
    private final Stacks sut = new Stacks();


    static Stream<Arguments> asteroidCollisionProvider() {
        return Stream.of(
                Arguments.of(new int[] {5, 10, -5}, new int[] {5, 10}),
                Arguments.of(new int[] {-2, -1, 1, 2}, new int[] {-2, -1, 1, 2}),
                Arguments.of(new int[] {-2, -2, 1, -2}, new int[] {-2, -2, -2}),
                Arguments.of(new int[] {1, -2, -2, -2}, new int[] {-2, -2, -2})
        );
    }

    @ParameterizedTest
    @MethodSource("asteroidCollisionProvider")
    public void asteroidCollision(int[] input, int[] expected) {
        int[] actual = sut.asteroidCollision(input);
        System.out.printf("Expected: %s\n", Arrays.toString(expected));
        System.out.printf("Actual: %s\n", Arrays.toString(actual));
        assertArrayEquals(expected, actual);
    }

    public static Stream<Arguments> dataIsValid() {
        return Stream.of(
                Arguments.of("()", true),
                Arguments.of("()[]{}", true),
                Arguments.of("(]", false),
                Arguments.of("([])", true)
        );
    }


    @ParameterizedTest
    @MethodSource("dataIsValid")
    void isValid(String s, boolean expected) {
        boolean actual = sut.isValid(s);
        System.out.printf("Expected: %s, Actual: %s\n", expected, actual);
        assert expected == actual;
    }
}
