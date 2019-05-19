/* Code to multiply two linkedlist in a number */

public class MultiplyTwoLinkedList {
    Node head;
    class Node {
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

    //Multiply two linkedlist
    public static long multiplyTwoLinkedList(Node l1, Node l2) {
        int num1 = 0, num2 = 0;
        while(l1 != null || l2 != null) {
            if(l1 != null) {
                num1 = num1*10 + l1.data;
                l1 = l1.next;
            }
            if(l2 != null) {
                num2 = num2*10 +  l2.data;
                l2 = l2.next;
            }
        }

        return num1*num2;
    }

    //main method
    public static void main(String args[]) {
        MultiplyTwoLinkedList list1 = new MultiplyTwoLinkedList();
        MultiplyTwoLinkedList list2 =  new MultiplyTwoLinkedList();
        list1.insertFront(1);
        list1.insertFront(2);

        list2.insertFront(0);
        list2.insertFront(1);

        print(list1.head);
        print(list2.head);

        long result = multiplyTwoLinkedList(list1.head, list2.head);
        System.out.print("the resultant number" + result);
    }
}