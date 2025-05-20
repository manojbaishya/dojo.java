package org.dojo.leetcode;

import java.util.ArrayList;
import java.util.List;

import static org.dojo.leetcode.SinglyLinkedList.SinglyLinkedListNode;

public class LinkedListProblems {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() { }
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static List<Integer> listNodeToList(ListNode node) {
        ListNode ptr = node;
        List<Integer> result = new ArrayList<>();
        while (ptr != null) {
            result.add(ptr.val);
            ptr = ptr.next;
        }
        return result;
    }

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

        SinglyLinkedListNode result = list1.getVal() <= list2.getVal() ? list1 : list2;

        SinglyLinkedListNode smaller = list1, larger = list2;
        SinglyLinkedListNode tmp = null;
        while (smaller != null) {
            if (smaller.getVal() > larger.getVal()) {
                tmp = smaller;
                smaller = larger;
                larger = tmp;
            }
            while (smaller.getVal() <= larger.getVal()) {
                tmp = smaller;
                smaller = smaller.getNext();

                if (smaller == null) break;
            }
            tmp.setNext(larger);
        }
        return result;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        int count = 1;
        for (int i = 0; i < n; i++) {
            if (fast.next == null) break;

            fast = fast.next;
            count++;
        }
        if (count == n) return head.next;

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }


        slow.next = slow.next.next;

        return head;
    }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int sizeA = 0;
        ListNode sA = headA;
        while (sA.next != null) {
            sA = sA.next;
            sizeA++;
        }

        int sizeB = 0;
        ListNode sB = headB;
        while (sB.next != null) {
            sB = sB.next;
            sizeB++;
        }

        ListNode longer;
        int delta;
        if (sizeA > sizeB) {
            delta = sizeA - sizeB;
            longer = headA;
        } else {
            delta = sizeB - sizeA;
            longer = headB;
        }

        sA = headA;
        sB = headB;

        if (longer == headA) {
            for (int i = 0; i < delta; i++) {
                sA = sA.next;
            }
        } else {
            for (int i = 0; i < delta; i++) {
                sB = sB.next;
            }
        }

        while (sA != null && sB != null) {
            if (sA == sB) return sA;

            sA = sA.next;
            sB = sB.next;
        }

        return null;
    }

    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = null;
        ListNode next;

        ListNode result = head;

        int size = 0;
        ListNode start = head;
        while (start != null) {
            start = start.next;
            size++;
        }

        int groups = size / k;

        for (int i = 0; i < groups; i++) {
            if (i > 0) {
                dummy.next = head.next;
                dummy = head;
                head = head.next;
                next = head;
            }

            for (int j = 0; j < k; j++) {
                next = head.next;
                head.next = dummy;
                dummy = head;
                head = next;
            }
        }
        return result;
    }


}
