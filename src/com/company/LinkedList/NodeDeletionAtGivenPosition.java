package com.company.LinkedList;

public class NodeDeletionAtGivenPosition {

    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void deleteAtPosition(int position){
        ListNode previousNode = head;
        int count = 1;
        if(position ==1){
            head = previousNode.next;
            previousNode.next = null;
        }
        while(count<position-1){
            previousNode = previousNode.next;
            count++;
        }
        ListNode temp =  previousNode.next;
        previousNode.next = temp.next;
        temp.next = null;


    }

    public static void main(String[] args) {
        NodeDeletionAtGivenPosition sil = new NodeDeletionAtGivenPosition();
        sil.head = new ListNode(10);
        ListNode first = new ListNode(20);
        ListNode second = new ListNode(30);
        ListNode third = new ListNode(40);
        sil.head.next = first;
        first.next = second;
        second.next = third;
        sil.deleteAtPosition(3);
        ListNode current = sil.head;
        while(current!=null){
            System.out.print(current.data+"--->");
            current = current.next;
        }

        System.out.println("null");
    }

}
