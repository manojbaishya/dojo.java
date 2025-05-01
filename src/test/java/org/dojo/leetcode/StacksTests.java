package org.dojo.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    public static Stream<Arguments> reversePrefixData() {
        return Stream.of(
                Arguments.of("abcdefd", 'd', "dcbaefd"),
                Arguments.of("xyxzxe", 'z', "zxyxxe"),
                Arguments.of("abcd", 'z', "abcd")
        );
    }

    @ParameterizedTest
    @MethodSource("reversePrefixData")
    void reversePrefix(String word, char ch, String expected) {
        String actual = sut.reversePrefix(word, ch);
        System.out.printf("Input: \"%s\", '%c' => Expected: \"%s\", Actual: \"%s\"\n", word, ch, expected, actual);
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> testCalPointsData() {
        return Stream.of(
                Arguments.of(new String[] {"5", "2", "C", "D", "+"}, 30),
                Arguments.of(new String[] {"5", "-2", "4", "C", "D", "9", "+", "+"}, 27),
                Arguments.of(new String[] {"1", "C"}, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("testCalPointsData")
    public void testCalPoints(String[] operations, int expected) {
        assertEquals(expected, sut.calPoints(operations));
    }
}
