package org.dojo.leetcode;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GraphsTest {
    private Graphs sut;

    @BeforeEach
    void setUp() {
        sut = new Graphs();
    }

    static Stream<Arguments> countGroupsData() {
        return Stream.of(
                Arguments.of(
                        Arrays.asList("1100", "1110", "0110", "0001"),
                        2
                ),
                Arguments.of(
                        Arrays.asList("10000", "01000", "00100", "00010", "00001"),
                        5
                )
        );
    }

    @ParameterizedTest
    @MethodSource("countGroupsData")
    void countGroups(List<String> related, int expectedGroupCount) {
        int actual = sut.countGroupsDFS(related);
        System.out.printf("DFS Expected: %d, Actual: %d%n", expectedGroupCount, actual);
        assertEquals(expectedGroupCount, actual);

        actual = sut.countGroupsBFS(related);
        System.out.printf("BFS Expected: %d, Actual: %d%n", expectedGroupCount, actual);
        assertEquals(expectedGroupCount, actual);
    }
}
