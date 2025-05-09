package org.dojo.leetcode;

import org.dojo.leetcode.SinglyLinkedList.SinglyLinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LinkedListProblemsTests {
    private final LinkedListProblems sut = new LinkedListProblems();

    static Stream<Arguments> addTwoNumbersData() {
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
    @MethodSource("addTwoNumbersData")
    void addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2, SinglyLinkedListNode expected) {
        SinglyLinkedListNode actual = sut.addTwoNumbers(l1, l2);

        while (expected.getNext() != null) {
            assertEquals(expected, actual);
            expected = expected.getNext();
            actual = actual.getNext();
        }
    }

    static Stream<Arguments> mergeTwoListsData() {
        return Stream.of(
                Arguments.of(
                        linkedListFromArray(new int[] {1, 2, 4}),
                        linkedListFromArray(new int[] {1, 3, 4}),
                        linkedListFromArray(new int[] {1, 1, 2, 3, 4, 4})
                )
        );
    }
    private static SinglyLinkedListNode linkedListFromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        SinglyLinkedListNode head = new SinglyLinkedListNode(arr[0]);
        SinglyLinkedListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            SinglyLinkedListNode newNode = new SinglyLinkedListNode(arr[i]);
            current.setNext(newNode);
            current = newNode;
        }

        return head;
    }
    @ParameterizedTest
    @MethodSource("mergeTwoListsData")
    void mergeTwoLists(SinglyLinkedListNode list1, SinglyLinkedListNode list2, SinglyLinkedListNode expectedList) {
        SinglyLinkedListNode actual = sut.mergeTwoLists(list1, list2);
        SinglyLinkedListNode expected = expectedList;
        while (expected != null) {
            assertEquals(expected.getVal(), actual.getVal());
            expected = expected.getNext();
            actual = actual.getNext();
        }
    }
}
