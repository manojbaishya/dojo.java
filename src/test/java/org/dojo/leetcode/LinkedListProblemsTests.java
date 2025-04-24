package org.dojo.leetcode;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListProblemsTests {

    private final LinkedListProblems sut = new LinkedListProblems();

    static Stream<Arguments> inlineData() {
        return Stream.of(
                Arguments.of(
                        new SinglyLinkedListNode(2, new SinglyLinkedListNode(4, new SinglyLinkedListNode(3))),
                        new SinglyLinkedListNode(5, new SinglyLinkedListNode(6, new SinglyLinkedListNode(4))),
                        new SinglyLinkedListNode(7, new SinglyLinkedListNode(0, new SinglyLinkedListNode(8)))
                ),
                Arguments.of(
                        new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9))))))),
                        new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9)))),
                        new SinglyLinkedListNode(8, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(9, new SinglyLinkedListNode(0, new SinglyLinkedListNode(0, new SinglyLinkedListNode(0, new SinglyLinkedListNode(1))))))))
                ),
                Arguments.of(new SinglyLinkedListNode(0), new SinglyLinkedListNode(0), new SinglyLinkedListNode(0))
        );
    }

    @ParameterizedTest
    @MethodSource("inlineData")
    void addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2, SinglyLinkedListNode expected) {
        SinglyLinkedListNode actual = sut.addTwoNumbers(l1, l2);

        while(expected.getNext() != null) {
            assertEquals(expected, actual);
            expected = expected.getNext();
            actual = actual.getNext();
        }
    }
}
