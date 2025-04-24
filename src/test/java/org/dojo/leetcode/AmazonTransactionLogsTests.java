package org.dojo.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AmazonTransactionLogsTests {
    private final AmazonTransactionLogs sut = new AmazonTransactionLogs();

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
}
