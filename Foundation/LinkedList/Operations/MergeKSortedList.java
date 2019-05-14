
import java.util.*;
public class MergeKSortedList {
    //An array of pointers storing the head node of the linked list
    static Node head [] = new Node[4];
    public class Node {
        Node next;
        int data;
        Node(int d) { 
            data = d;
        }
    }

    //Print List
    public void printListIndexwise(int nodeIndex) {
        Node node = head[nodeIndex];
        while(node != null) {  
            System.out.print(node.data + " ");
            node = node.next;
        }
    }

    //Print merge List
    public static void printMergeList(Node node) {
        while(node != null) {
            System.out.println(node.data + " ");
            node = node.next;
        }
    }

    //Merge K sorted list
    public  Node mergeKSortedList(Node[] lists) {
        if(lists == null || lists.length == 0) {
            return null;
        }

        //Implement priority queue and override comparator
        PriorityQueue<Node> pq = new PriorityQueue<Node>(new Comparator<Node>() {
            @Override
            public int compare(Node list1, Node list2) {
                return list1.data - list2.data;
            }
        });

       // push the head nodes of all the k lists in 'pq'
        Node head = null, last=null;
        for(Node list: lists) {
            if(list != null) {
                pq.offer(list);
            }
        }

        //Pop element from the pq until pq is empty. In the meantime, check if the next node exist of popped element from the queue.
        while(!pq.isEmpty()) {
            Node top = pq.poll(); 
            if(top.next != null) {
                pq.add(top.next);
            }
            //if head and last both null mean head and last will point to same extracted element from the pq.
            if(head == null) {
                head = top;
                last = top;
            }
            else {
                // insert 'top' at the end of the merged list so far  
                last.next = top;  
                // update the 'last' pointer  
                last = top;
            }
        }
        return head;
    }

    //Insert Frontin the list 
    public void insertinList(int listIndex, ArrayList<Integer> list) {
        for(int i=0; i<list.size(); i++){
            Node newNode = new Node(list.get(i));
            newNode.next = head[listIndex];
            head[listIndex] = newNode;
        }
    }

    //Main method
    public static void main(String args[]) {
        //No of linkedlist and no of elements in each list
        int k = 2;
        
        MergeKSortedList llist = new MergeKSortedList();
        List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> list1 = new ArrayList<Integer>(); 
        list1.add(12); 
        list1.add(4);  
        list1.add(3); 
        list1.add(2); 
        ArrayList<Integer> list2 = new ArrayList<Integer>(); 
        list2.add(13); 
        list2.add(12); 
        list2.add(11); 
        list2.add(10);

        list.add(list1);
        list.add(list2);
        for(int i=0; i<k; i++){
            llist.insertinList(i,list.get(i));
            llist.printListIndexwise(i);
        }

        Node mergeList = llist.mergeKSortedList(head);
        System.out.println("finished successfully");
        printMergeList(mergeList);

    }
}