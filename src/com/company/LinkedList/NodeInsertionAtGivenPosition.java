package com.company.LinkedList;

public class NodeInsertionAtGivenPosition {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void insertAt(int value,int position){
        ListNode newNode = new ListNode(value);
        if(position ==1){
            newNode.next = head;
            head = newNode;
        } else {
            int count = 1;
            ListNode previousNode = head;
            while(count<position-1){
                previousNode = previousNode.next;
                count++;

            }
           ListNode current = previousNode.next;
            previousNode.next = newNode;
            newNode.next = current;
        }
    }

    public static void main(String[] args) {
        NodeInsertionAtGivenPosition sil = new NodeInsertionAtGivenPosition();
        sil.head = new ListNode(10);
        ListNode first = new ListNode(20);
        ListNode second = new ListNode(30);
        ListNode third = new ListNode(40);
        sil.head.next = first;
        first.next = second;
        second.next = third;
        sil.insertAt(78,5);
        ListNode current = sil.head;
        while(current!=null){
            System.out.print(current.data+"--->");
            current = current.next;
        }

        System.out.println("null");
    }
}
