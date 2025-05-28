package org.dojo.algorithms;

import org.dojo.algorithms.LinkedListProblems.ListNode;
import org.dojo.algorithms.SinglyLinkedList.SinglyLinkedListNode;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

class LinkedListProblemsTests {
    private final LinkedListProblems sut = new LinkedListProblems();

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

    private static ListNode linkedListNodeFromArray(int[] arr) {
        if (arr == null || arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            ListNode newNode = new ListNode(arr[i]);
            current.next = newNode;
            current = newNode;
        }

        return head;
    }

    private int countElements(ListNode list) {
        int count = 0;
        ListNode temp = list;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

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

    private static Stream<Arguments> removeNthFromEndTestData() {
        return Stream.of(
                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2, 3, 4, 5}),
                        2,
                        linkedListNodeFromArray(new int[] {1, 2, 3, 5})
                ),

                Arguments.of(
                        linkedListNodeFromArray(new int[] {1}),
                        1,
                        null
                ),

                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2}),
                        1,
                        linkedListNodeFromArray(new int[] {1})
                ),

                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2, 3}),
                        3,
                        linkedListNodeFromArray(new int[] {2, 3})
                ),

                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2, 3, 4, 5, 6}),
                        3,
                        linkedListNodeFromArray(new int[] {1, 2, 3, 5, 6})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("removeNthFromEndTestData")
    void removeNthFromEnd(ListNode head, int n, ListNode expectedList) {
        ListNode actual = sut.removeNthFromEnd(head, n);

        if (expectedList == null) {
            assertNull(actual);
            return;
        }

        ListNode expected = expectedList;
        while (expected != null) {
            assertNotNull(actual, "Actual list is shorter than expected");
            assertEquals(expected.val, actual.val);
            expected = expected.next;
            actual = actual.next;
        }

        assertNull(actual, "Actual list is longer than expected");
    }

    private static Stream<Arguments> reverseKGroupTestData() {
        return Stream.of(
                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2, 3, 4, 5}),
                        2,
                        linkedListNodeFromArray(new int[] {2, 1, 4, 3, 5})
                ),
                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2, 3, 4, 5}),
                        3,
                        linkedListNodeFromArray(new int[] {3, 2, 1, 4, 5})
                ),
                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2}),
                        3,
                        linkedListNodeFromArray(new int[] {1, 2})
                ),
                Arguments.of(
                        linkedListNodeFromArray(new int[] {1}),
                        1,
                        linkedListNodeFromArray(new int[] {1})
                ),
                Arguments.of(
                        linkedListNodeFromArray(new int[] {1, 2, 3}),
                        3,
                        linkedListNodeFromArray(new int[] {3, 2, 1})
                )
        );
    }

    @ParameterizedTest
    @MethodSource("reverseKGroupTestData")
    void reverseKGroup(ListNode head, int k, ListNode expectedList) {
        ListNode actual = sut.reverseKGroup(head, k);

        if (expectedList == null) {
            assertNull(actual, "Expected list is null, but the actual list is not null");
            return;
        }

        int expectedCount = countElements(expectedList);
        int actualCount = countElements(actual);

        System.out.printf("Expected Count: %d, Actual Count: %d%n", expectedCount, actualCount);
        System.out.printf("Expected List: %s%n", LinkedListProblems.listNodeToList(expectedList));
        System.out.printf("Actual List: %s%n", LinkedListProblems.listNodeToList(actual));

        assertEquals(expectedCount, actualCount,
                String.format("The number of elements in the actual list (%d) does not match the expected list (%d)", actualCount, expectedCount));

        ListNode expected = expectedList;
        while (expected != null) {
            assertNotNull(actual, "Actual list is shorter than expected: a node in the expected list has no corresponding node in the actual list");
            assertEquals(expected.val, actual.val,
                    String.format("Mismatch in node values: expected %d but found %d", expected.val, actual.val));
            expected = expected.next;
            actual = actual.next;
        }

        assertNull(actual, "Actual list is longer than expected: additional nodes found in the actual list after expected nodes");
    }


}
