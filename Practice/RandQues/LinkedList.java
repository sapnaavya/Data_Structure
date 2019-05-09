import java.util.*;

class Node 
{ 
  int data; 
  Node next; 
  Node(int d)  { data = d;  next = null; } 
} 

public class LinkedList {
    Node head;  // head of list 
    /* This function prints contents of linked list starting from head */
    public static void traverseHead (Node head)
    {
      Node n = head;
      if (n == null)
        return;
      else {
        System.out.println(n.data);
        traverseHead(n.next);
      };
    }

    /* This function prints contents of linked list starting from tail */
    public static void traverseTail(Node head)
    {
      Node n = head;
      if (n == null)
        return;
      else {
        traverseTail(n.next);
        System.out.println(n.data);
        
      };
    }
  
    public void listTraversal(String trversalOption) {
      if(trversalOption.equalsIgnoreCase("B")){
        traverseTail(head);
      }
      else if(trversalOption.equalsIgnoreCase("F")) {
        traverseHead(head);
      }
      else {
        System.out.println("No option selected for travesing linked list...");
      }
    }
    
    public static void main(String args[]) {
        LinkedList llist = new LinkedList(); 
        llist.head = new Node(1); 
        Node second = new Node(2); 
        Node third = new Node(3); 
        llist.head.next = second; // Link first node with the second node 
        second.next = third; // Link first node with the second node 
        Scanner sc = new Scanner (System.in);
        System.out.println("CHOOSE 'F' FOR FORWARD TRAVERSAL AND 'B' FOR BACKWARD TRAVERSAL");
        String trversalOption = sc.next();
        llist.listTraversal(trversalOption);
        sc.close();
    }
}