package org.dojo;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArrayToolsTest {

    static Stream<Arguments> provideArraysForSum() {
        return Stream.of(
                Arguments.of(new int[] {1, 2, 3}, 6),
                Arguments.of(new int[] {0, 0, 0}, 0),
                Arguments.of(new int[] {-1, -2, -3}, -6),
                Arguments.of(new int[] {}, 0),
                Arguments.of(new int[] {5}, 5)
        );
    }

    @ParameterizedTest
    @MethodSource("provideArraysForSum")
    void testSumArray(int[] input, int expected) {
        var tools = new ArrayTools();
        assertEquals(expected, tools.Sum(input));
    }

    @ParameterizedTest
    @MethodSource("provideArraysForSum")
    void testSumList(int[] input, int expected) {
        List<Integer> inputList = Arrays.stream(input).boxed().toList();
        var tools = new ArrayTools();
        assertEquals(expected, tools.Sum(inputList));
    }
}
