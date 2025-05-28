package org.dojo.algorithms;

import java.util.Objects;

public class SinglyLinkedList {

    private SinglyLinkedListNode head;
    public SinglyLinkedListNode getHead() { return head; }
    public void setHead(SinglyLinkedListNode head) { this.head = head; }
    public SinglyLinkedList() { this.head = null; }

    public void add(int data) {
        var newNode = new SinglyLinkedListNode(data);

        if (head == null) {
            setHead(newNode);
        } else {
            SinglyLinkedListNode current = getHead();
            while (current.getNext() != null) current.setNext(current.getNext());
            current.setNext(newNode);
        }
    }
    public static class SinglyLinkedListNode {
        private int val;
        public int getVal() { return val; }
        public void setVal(int val) { this.val = val; }

        private SinglyLinkedListNode next;
        public SinglyLinkedListNode getNext() { return next; }
        public void setNext(SinglyLinkedListNode next) { this.next = next; }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof SinglyLinkedListNode second)) return false;
            return getVal() == second.getVal();
        }
        @Override
        public int hashCode() { return Objects.hashCode(getVal()); }

        public SinglyLinkedListNode() { this(0, null); }
        public SinglyLinkedListNode(int val) { this(val, null); }
        public SinglyLinkedListNode(int val, SinglyLinkedListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
