/* This code will check for pallindromic list using Stack and bruteforce method */

import java.util.Stack;

public class PallindromeList {

    Node head;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
    }

    //Insert at the beginning of the List
    public void insertFront(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    //Print the whole list
    public static void print(Node node) {
        //Node node = head;
        while(node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    //Check if it is a pallindromic list or not - Using Stack
    public static boolean isPallindrome(Node node) {
        Stack<Integer> stack = new Stack<Integer>();
        Node slow = node;
        Node fast = node;

        while(fast != null && fast.next != null) {
            stack.push(slow.data);
            slow = slow.next;
            fast = fast.next.next;
        }

        //node has odd number of elements
        if(fast != null) {
            slow = slow.next;
        }

        while(slow != null) {
            int element = stack.pop().intValue();
            if(slow.data != element) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    // Check if a linkedlist is a pallindrom or not using reverse and clone linkedlist
    public static boolean isPalLinkedList(Node originalList) {
        Node reverseList = reverseAndClone(originalList);
        return compareList(reverseList, originalList);
    }

    // Reverse a linkedList
    public static Node reverseAndClone(Node l1) {
        if(l1 == null) {
            return null;
        }
        Node prev = null;
        while(l1 != null) {
            Node newNode =  new Node(l1.data);
            newNode.next = prev;
            prev = newNode;
            l1 = l1.next;
        }
        return prev;
    }

    // Compare reverselist and actual list
    private static boolean compareList(Node list1, Node list2) {
        if(list1 == null && list2 == null) {
            return true;
        }
        while(list1 != null && list2 != null) {
            if(list1.data != list2.data) {
                return false;
            }
            list1 = list1.next;
            list2 = list2.next;
        }
        return true;
    }

    //Main method
    public static void main(String args[]) {
        PallindromeList list = new PallindromeList();
        list.insertFront(5);
        list.insertFront(6);
        list.insertFront(6);
        list.insertFront(7);
        list.insertFront(5);

        print(list.head);
        System.out.println(isPallindrome(list.head));
        System.out.println(isPalLinkedList(list.head));

    }
}