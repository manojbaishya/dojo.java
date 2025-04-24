package org.dojo.leetcode;

public class LinkedListProblems {
    public SinglyLinkedListNode addTwoNumbers(SinglyLinkedListNode l1, SinglyLinkedListNode l2) {
        var carryover = 0;
        var sumNode = new SinglyLinkedListNode();
        SinglyLinkedListNode head = sumNode;

        SinglyLinkedListNode lm1 = l1;
        SinglyLinkedListNode lm2 = l2;

        while (lm1 != null || lm2 != null)
        {
            int sum;

            if (lm1 != null && lm2 != null) sum = lm1.getVal() + lm2.getVal() + carryover;
            else if (lm2 != null) sum = lm2.getVal() + carryover;
            else sum = lm1.getVal() + carryover;

            if (sum > 9)
            {
                carryover = 1;
                sum %= 10;
            }
            else
            {
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

        if (carryover == 1)
        {
            sumNode.setNext(new SinglyLinkedListNode(carryover));
        }

        return head;
    }
}
