package com.company.List;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class StackEx {
    public static void main(String[] args) {
        // creating a stack
        System.out.println("creating a stack");
        Stack<Integer> stack = new Stack<>();
        // since it inheri vector we can check its capacity
        System.out.println("capacity of stack");
        System.out.println(stack.capacity());
        // adding element in stack
        System.out.println("adding element in stack");
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        stack.push(7);
        System.out.println(stack);
        // removing element from stack using pop . it will remove the last added element
        System.out.println("removing element from stack using pop");
        stack.pop();
        System.out.println(stack);
        // if we want to print the element at top of the stack then use peek method
        System.out.println("if we want to print the element at top of the stack then use peek method");
        System.out.println("printing top element");
        System.out.println(stack.peek());

        // search method it is 1 index method means for it index starts from 1
        System.out.println("search method it is 1 index method means for it index starts from 1");
        System.out.println(stack);
        int num = stack.search(3);
        System.out.println(num);

        // linkedlist as stsck
        System.out.println("linkedlist as stack");

        LinkedList<Integer>linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.addFirst(0);
        linkedList.addLast(5);
        linkedList.push(6);
        System.out.println(linkedList);
        System.out.println("linkedlist after pop");
        linkedList.pop();
        System.out.println(linkedList);

        // can we arraylist as stack? no we cannot directly use arraylist as stack as like linkedlist



    }
}
