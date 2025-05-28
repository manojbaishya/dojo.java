package org.dojo.algorithms;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinarySearchTests {
    private BinarySearch sut;

    @BeforeEach
    void setUp() {
        sut = new BinarySearch();
    }

    static Stream<Arguments> findMedianSortedArraysData() {
        return Stream.of(
                Arguments.of(
                        new int[] {1, 2},
                        new int[] {3, 4},
                        2.5
                )
        );
    }
    @ParameterizedTest
    @MethodSource("findMedianSortedArraysData")
    void testFindMedianSortedArrays(int[] inputArr1, int[] inputArr2, double expectedMedian) {
        double actualMedian = sut.findMedianSortedArrays(inputArr1, inputArr2);

        System.out.printf("Expected Median: %.1f, Actual Median: %.1f%n",
                expectedMedian, actualMedian);

        assertEquals(expectedMedian, actualMedian, 0.0001);
    }
}
