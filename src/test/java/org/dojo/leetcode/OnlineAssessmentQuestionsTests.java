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

class OnlineAssessmentQuestionsTests {
    private OnlineAssessmentQuestions sut;

    @BeforeEach
    void setup() { sut = new OnlineAssessmentQuestions(); }

    static Stream<Arguments> inlineData() {
        return Stream.of(
                Arguments.of(List.of("1 2 50", "1 7 70", "1 3 20", "2 2 17"), 2, List.of("1", "2")),
                Arguments.of(List.of("9 7 50", "22 7 20", "33 7 50", "22 7 30"), 3, List.of("7"))
        );
    }

    @ParameterizedTest
    @MethodSource("inlineData")
    void processLogs(List<String> logs, int threshold, List<String> expectedUsersExceedingThreshold) {
        List<String> actual = sut.processLogs(logs, threshold);
        System.out.println(String.join(",", actual));
        assertEquals(expectedUsersExceedingThreshold, actual);
    }

    static Stream<Arguments> getItemsInClosedContainersData() {
        return Stream.of(
                Arguments.of(
                        "|**|*|*",
                        new int[] {1, 1},
                        new int[] {5, 6},
                        new int[] {2, 3}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("getItemsInClosedContainersData")
    void getItemsInClosedContainers(String compartments, int[] startIndices, int[] endIndices, int[] expectedItems) {
        int[] actualItems = sut.getItemsInClosedContainers(compartments, startIndices, endIndices);

        System.out.printf("Expected Items: %s, Actual Items: %s%n",
                Arrays.toString(expectedItems),
                Arrays.toString(actualItems));

        assertArrayEquals(expectedItems, actualItems);
    }

    static Stream<Arguments> lengthOfLongestSubstringData() {
        return Stream.of(
                Arguments.of("abcabcbb", 3),
                Arguments.of("bbbbb", 1),
                Arguments.of("pwwkew", 3),
                Arguments.of("qrsvbspk", 5)
        );
    }

    @ParameterizedTest
    @MethodSource("lengthOfLongestSubstringData")
    void testLengthOfLongestSubstring(String testString, int expectedLength) {
        int actualLength = sut.lengthOfLongestSubstring(testString);

        System.out.printf("expectedLength: %d, actualLength: %d%n",
                expectedLength, actualLength);

        assertEquals(expectedLength, actualLength);
    }

    static Stream<Arguments> minimalHeaviestBoxData() {
        return Stream.of(
                Arguments.of(
                        new int[] {3, 7, 5, 6, 2},
                        new int[] {6, 7}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("minimalHeaviestBoxData")
    void testMinimalHeaviestBox(int[] weights, int[] expectedMinimalHeaviestSubset) {
        int[] actualMinimalHeaviestSubset = sut.minimalHeaviestBox(weights);

        System.out.printf("Input weights: %s%n", Arrays.toString(weights));
        System.out.printf("Actual minimal heaviest subset: %s%n",
                Arrays.toString(actualMinimalHeaviestSubset));

        assertArrayEquals(expectedMinimalHeaviestSubset, actualMinimalHeaviestSubset);
    }
}
