package com.company.LinkedList;

import java.awt.*;

public class SinglyLinkedListCreation {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
    public void lengthCalculator(ListNode node){
        int count = 0;
        ListNode current = head;
        while(current!=null){
            count++;
            current = current.next;
        }
        System.out.println("The length of the linkedlist is"+":"+" "+count);
    }
    public void insertFirst (int value){
        ListNode newNode = new ListNode(value);
        newNode.next = head;
        head = newNode;
    }
    public void insertAtLast(int value){
        ListNode newNode = new ListNode(value);
        ListNode current = head;
        if(head == null){
            head = newNode;
            return;
        }
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }

    public static void main(String[] args) {
        SinglyLinkedListCreation sil = new SinglyLinkedListCreation();
        sil.head = new ListNode(10);
        ListNode first = new ListNode(20);
        ListNode second = new ListNode(30);
        ListNode third = new ListNode(40);
        sil.head.next = first;
        first.next = second;
        second.next = third;

        sil.insertFirst( 23);
        sil.insertAtLast(32);

        ListNode current = sil.head;
        while(current!=null){
            System.out.print(current.data+"--->");
            current = current.next;
        }

        System.out.println("null");
        sil.lengthCalculator(sil.head);
    }
}
