/* Code to sum to linkedlist.
    Assumption - Linkedlist are stored in reverse order such that 1's digit is at the head of the list.

    This is a bruteforce approach as this approach first reverse the list to get the 1's digit on the head
    and then after getting the sum of two list it again reverses the resultant list because the result is store in reverse order

    for example, we want to add 254 and 254..first, we will reverse the both lists. So, head points to 1's digith i.e. 4 and 4
    4->5->2 and 4->5->2 So, resultant list would be 8->0->5. We need to reverse the list so that we can result like this 5->0->8
    Steps:
        1. Reverse List L1.
        2. Reverse List L2.
        3. Add the nodes of both the lists iteratively.
        4. Reverse the resultant list and return its head.

    We are doing inplace sum here
    Time Complexity: O(max(m, n)) where m and n are number of nodes in first and second lists respectively.
    Space Complexity: O(1)

    Iterative approach Time complexity O(m + n)
*/

public class SumTwoListReverse {
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
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //Sum of two linked list in reverse order
    public static Node sumofTwoList(Node l1, Node l2, int carry) {

        //considering this is the last node .. so we have to make it as null
        if(l1 == null && l2 == null && carry == 0) {
            return null;
        }
        
        int value = carry;
        if(l1 != null) {
            value += l1.data;
        }
        if(l2 != null) {
            value += l2.data;
        }

        Node node = new Node(value%10);
        
        //if l1 is not null or l2 is not null then only go to if block
        if(l1 != null || l2 != null) {
            Node nextNode = sumofTwoList(l1 == null ? null: l1.next, l2 == null ? null : l2.next, value >= 10 ? 1: 0);
            node.next = nextNode;
        }
        return node;
    }

    //reverse a list
    public static Node reverseNode(Node node) {
        if(node == null) {
            return null;
        }

        Node current = node;
        Node prev = null;
        Node next = null;
        while(current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        return prev;
    }

    //utility function to do sum of two lists using iterative approach
    public static Node sumofTwoListsIterativeUtil(Node head1, Node head2) {
        Node revNode1 = reverseNode(head1);
        Node revNode2 = reverseNode(head2);

        Node sumNode = sumofTwoListIter(revNode1, revNode2);

        sumNode = reverseNode(sumNode);
        return sumNode;
    }

    public static Node sumofTwoListIter(Node l1, Node l2) {
        Node head = null; //res -> head node of linkedlist
        Node current = null;
        Node temp = null;
        int carry = 0, sum;

        while(l1 != null || l2 != null) {
            sum = carry + (l1 != null ? l1.data : 0) + (l2 != null ? l2.data : 0);
            carry = sum >= 10 ? 1: 0;
            sum = sum % 10;
            temp = new Node(sum);
            if(head == null) {
                head = temp;
                current = temp;
            }
            else {
                current.next = temp;  
                current = temp;   //0 <- 4 <- 0 <- 1
            }

            //move pointers of l1 and l2 to next node
            if(l1 != null) {
                l1 = l1.next;
            }
            if(l2 != null) {
                l2 = l2.next;
            }
        }

        if(carry > 0) {
            current.next = new Node(carry);
        }
        return head;
    }

    static Node revNodeUtil(Node head1, Node head2) {
        //reverse both the lists
        Node revNode1 = reverseNode(head1);
        Node revNode2 = reverseNode(head2);
        
        //sum two lists
        int carry = 0;
        Node sumNode = sumofTwoList(revNode1, revNode2, carry);

        //reverse the lists again
        sumNode = reverseNode(sumNode);
        return sumNode;
    }
   
    //main method
    public static void main(String args[]) {
        SumTwoListReverse list1 = new SumTwoListReverse();
        SumTwoListReverse list2 = new SumTwoListReverse();
    
        list1.insertFront(0);
        list1.insertFront(5);
        list1.insertFront(2);

        list2.insertFront(0);
        list2.insertFront(5  );
        list2.insertFront(2);

        print(list1.head);
        System.out.print("\n");
        print(list2.head);

        Node sumList = revNodeUtil(list1.head, list2.head);
        //Node sumListIter = sumofTwoListsIterativeUtil(list1.head, list2.head);
        System.out.print("\n");
        print(sumList);
        //print(sumListIter);
    }
}