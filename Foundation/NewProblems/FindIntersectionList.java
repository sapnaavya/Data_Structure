/**
 * This code finds the intersecting node between two linkedlist. 
 * Please note two things:
 * 1. In intersecting node, both linkedlist would have same tail.
 *    So, its a good idea to check tail in the beginning if they both have same tail or not.
 * 2. If both nodes are of different length then make sure to traverse those extra nodes in the beginning.
 *      Time complexity: O(A + B)
 *      Space complexity: O(1) as no extra space is being used
 */

public class FindIntersectionList {
    class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            next = null;
        }
    }

    class Result {
        public Node tail;
        public int size;
        public Result(Node tail, int size) {
            this.tail = tail;
            this.size = size;
        }
    }

    public Result getTailAndSize(Node node) {
        if(node == null) {
            return null;
        }
        int size = 1;
        Node current = node;
        while(current.next != null) {
            size++;
            current = current.next;
        }

        return new Result(current, size);
    }

    Node head1, head2;
    //function to insert in the beginning
    public Node insertFront(Node head, int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        return head;
    }

    //function to print List
    public void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    public Node findIntersection(Node list1, Node list2) {
        if(list1 == null || list2 == null) {
            return null;
        }

        // Get tail and size of both lists
        Result result1 = getTailAndSize(list1);
        Result result2 = getTailAndSize(list2);
        int diff;
        if(result1.tail != result2.tail) {
            System.out.println("tail did not match");
            return null;
        } else {
           if(result1.size > result2.size) {
               diff = result1.size - result2.size;
               return findIntersectionUtil(diff, list1, list2);
            } else {
                diff = result2.size - result1.size;
                return findIntersectionUtil(diff, list2, list1);
            }
        }
    }

    public static Node findIntersectionUtil(int d, Node list1, Node list2) {
        //traverse those extra nodes
        for(int i = 0; i < d; i++) {
            if(list1 != null) {
                list1 = list1.next;
            }
        }

        while(list1 != list2) {
            list1 = list1.next;
            list2= list2.next;
        }
        return list1; //return list1 or list2
    }

    //main method 
    public static void main(String args[]) {
        FindIntersectionList list = new FindIntersectionList();
        list.head1 = list.insertFront(list.head1, 30);
        list.head1 = list.insertFront(list.head1, 8);
        list.head1 = list.insertFront(list.head1, 7);
        list.head1 = list.insertFront(list.head1, 5);
        list.printList(list.head1);

        list.head2 = list.insertFront(list.head2, 40);
        list.head2 = list.insertFront(list.head2, 50);
        //list.head2.next.next = list.head1.next.next;
        System.out.println("\n");
        list.printList(list.head2);

        System.out.println("\n");
        Node intersectNode = list.findIntersection(list.head1, list.head2);
        System.out.print("\n");
        if(intersectNode != null) {
            System.out.println( "intersecting node:" + intersectNode.data);
        }
    }
}