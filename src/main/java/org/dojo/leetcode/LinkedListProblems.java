package org.dojo.leetcode;

import static org.dojo.leetcode.SinglyLinkedList.SinglyLinkedListNode;

public class LinkedListProblems {
    public SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        var carryover = 0;
        var sumNode = new SinglyLinkedListNode();
        SinglyLinkedListNode head = sumNode;

        SinglyLinkedListNode lm1 = l1;
        SinglyLinkedListNode lm2 = l2;

        while (lm1 != null || lm2 != null) {
            int sum;

            if (lm1 != null && lm2 != null) sum = lm1.getVal() + lm2.getVal() + carryover;
            else if (lm2 != null) sum = lm2.getVal() + carryover;
            else sum = lm1.getVal() + carryover;

            if (sum > 9) {
                carryover = 1;
                sum %= 10;
            } else {
                carryover = 0;
            }

            sumNode.setVal(sum);

            if (lm1 != null && lm1.getNext() != null || lm2 != null && lm2.getNext() != null) {
                sumNode.setNext(new SinglyLinkedListNode());
                sumNode = sumNode.getNext();
            }

            lm1 = (lm1 != null) ? lm1.getNext() : null;
            lm2 = (lm2 != null) ? lm2.getNext() : null;
        }

        if (carryover == 1) {
            sumNode.setNext(new SinglyLinkedListNode(carryover));
        }

        return head;
    }

    public SinglyLinkedListNode reverseList(SinglyLinkedListNode head) {
        SinglyLinkedListNode dummy = null;
        SinglyLinkedListNode next;
        while (head != null) {
            next = head.getNext();
            head.setNext(dummy);
            dummy = head;
            head = next;
        }

        return dummy;
    }

    // Slow and Fast Pointers - LinkedList
    public SinglyLinkedListNode middleNode(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head, fast = head;

        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return slow;
    }

    public SinglyLinkedListNode mergeTwoLists(SinglyLinkedListNode list1, SinglyLinkedListNode list2) {
        if (list1 == null) return list2;
        else if (list2 == null) return list1;

        SinglyLinkedListNode l1 = list1, l2 = list2;
        SinglyLinkedListNode result = list1.getVal() <= l2.getVal() ? list1 : l2;
        SinglyLinkedListNode tmp = l1.getVal() > l2.getVal() ? l2 : l1;
        while (l1 != null) {
            if (l1.getVal() > l2.getVal()) {
                tmp = l1;
                l1 = l2;
                l2 = tmp;
            }
            while (l1.getVal() <= l2.getVal()) {
                tmp = l1;
                l1 = l1.getNext();

                if (l1 == null) break;
            }
            tmp.setNext(l2);
        }

        return result;
    }
}
