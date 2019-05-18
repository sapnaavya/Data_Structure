/* Code to check if linkedlist2 is a subset of linkedlist1 assuming continguous traversal */

public class SubSetList {
    static class Node {
        int data;
        Node next;
        Node(int data) { 
            this.data =  data;
            next = null;
        }
    }
    
    Node head;

    public static boolean isSubset(Node list1, Node list2) {
        if(list1 == null || list2 == null) {
            System.out.println("in if block");
            return true;
        }
        
        Node resetList2 = list2;
        while(list1 != null || list2 != null) {
        /* if list. data is equal to list2.data, then increment only when both of the pointers are not null to avoid
        Null pointer exception and continue. If any of the node's pointer points to null means we have reached to the end
        So, return true as data match between both nodes */

            if(list1.data == list2.data) {
                if(list2.next != null || list2.next != null) {
                    list1 = list1.next;
                    list2 = list2.next;  
                    continue;        
                }
                else {
                    return true;
                }
            }
            /* if data does not match between list1 and list2, check if list.next is not null and then increment 
            the pointer; if list.next is null means we have traversed the whole list1 and could not found subset.
            In that case, return false */

            if(list1.next != null) {
                list1 = list1.next;
            }
            else{
                return false;
            }
            //Reset list to reset list2 in the hope of finding subset list ahead
            if(list2 != resetList2) {
                System.out.println("in the loop");
                list2 = resetList2;
            }
        }
        return false;
    }

    public void printList(Node node) {
        System.out.println("in print");
        while(node != null) {
            System.out.println(node.data);
            node = node.next;
        }
    }
    //main method
    public static void main(String args[]) {
        SubSetList list1 = new SubSetList();
        SubSetList list2 = new SubSetList();
        list1.head = new Node(4);
        list1.head.next = new Node(8);
        list1.head.next.next = new Node(12);
        list1.head.next.next.next = new Node(16);
        list1.head.next.next.next.next = new Node(20);
        list1.head.next.next.next.next.next = new Node(20);
        list1.head.next.next.next.next.next.next = new Node(24);
        //list1.printList(list1.head);

        list2.head = new Node(4);
        list2.head.next = new Node(8);
        list2.head.next.next = new Node(12);
        //list2.head.next.next.next = new Node(16);
        //list2.head.next.next.next.next = new Node(20);
        list2.printList(list2.head);


        boolean middleElem = isSubset(list1.head, list2.head);
        System.out.println("is subset" + middleElem);
    }
}