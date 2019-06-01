/* Code to check if linkedlist2 is a subset of linkedlist1 assuming continguous traversal 
 Assumptions:
    SubsetList function return instance that holds the starting and end index in superset list when subset list match with superList
        If both list are null  
            -> retun null;
        If one of the superset (list1) is null 
            -> return null;
        If subset is null but superset holds value. Considering the fact that null could be subset of any superset 
            -> return superset;

*/

public class SubSetList {

    Node head;
    static class Node {
        int data;
        Node next;
        Node(int data) { 
            this.data =  data;
            next = null;
        }
    } 
    
    //Created new class to hold starting and end index where subset linkedlist match in the superset linkedlist
    static class ResultantPointer {
        public Node startIndex;
        public Node endIndex;
        ResultantPointer(Node superset) {
            startIndex = superset;
            endIndex = null;
        }

        ResultantPointer(Node startPointer, Node endPointer ) {
            startIndex = startPointer;
            endIndex = endPointer;
        }
    }

    public static ResultantPointer SubsetList(Node list1, Node list2) {
        if(list1 == null &&  list2 == null) {
            return new ResultantPointer(null, null);
        }

        if(list1 == null) {
            return new ResultantPointer(null, null); 
        }

        if (list2 == null) {
            return new ResultantPointer(list1);
        }
        
        Node resetList2 = list2;
        Node s = list1;
        Node startPointer = s;
        Node endPointer = list1;
        while(list1 != null || list2 != null) {
            if(list1.data == list2.data) {

                /* Note: We need to update startpointer and endpointer after we find that list1 data and list 2 is equal
                   if we changed these pointers in if condition then startpointer and endpointer wont be updated when list1 next and list2 next is null 
                   even though list1 data and list2 data is match, still pointers wont be updated as list1 next and lis2 next will be null 
                   for example, 1,2 are in superset and 2 is in subset .. after finding the 2 and 2 is match.. we wont be able to retun right pointer in superset and superset and subset list next is null
                   Thus, it is important to update them when we see we have a data match instead of going in if block
                */
                 
                startPointer = s; 
                endPointer = list1;

                if(list1.next != null &&  list2.next != null) {
                    list1 = list1.next;
                    list2 = list2.next;   
                    continue;        
                }
                else {
                    return new ResultantPointer(startPointer,endPointer);
                }
            }

            //make sure to reset the list2 first..before moving list1 to next pointer.. thus first else if and then if condition check
            // also, make sure to update s pointer in both else if and if condition both
            else if(list2 != resetList2 && list1.next != null) {
                list2 = resetList2;
                s = list1;
                continue;
            }
            if(list1.next != null) { 
                list1 = list1.next; 
                s = list1;
            }
            else{
               return new ResultantPointer(null, null);
            }   
        }
        return new ResultantPointer(null, null);
    }

    public void printList(Node node) {
        while(node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.print("\n");
    }

    //main method
    public static void main(String args[]) {
        SubSetList list1 = new SubSetList();
        SubSetList list2 = new SubSetList();
       
        list1.head = new Node(1);
        list1.head.next = new Node(3);
        // list1.head.next.next = new Node(8);
        // list1.head.next.next.next = new Node(4);
        // list1.head.next.next.next.next = new Node(1);
        // list1.head.next.next.next.next.next = new Node(4);
        // list1.head.next.next.next.next.next.next = new Node(1);
        // list1.head.next.next.next.next.next.next.next = new Node(2);
        // list1.head.next.next.next.next.next.next.next.next = new Node(5);
        list1.printList(list1.head);

        list2.head = new Node(3);
        // list2.head.next = new Node(8);
        // list2.head.next.next = new Node(4);
        // list2.head.next.next.next = new Node(1);
        // list2.head.next.next.next.next = new Node(4);
        list2.printList(list2.head);
        
        //SubSetList nullList = new SubSetList();
        //nullList.head = null;
        //ResultantPointer resultantPointer = SubsetList(list1.head, list3.head);

        ResultantPointer resultantPointer = SubsetList(list1.head, list2.head);
        if(resultantPointer.startIndex != null && resultantPointer.endIndex != null) {
            System.out.println("Matched elements in superset list");
            while(resultantPointer.startIndex != resultantPointer.endIndex) {
                System.out.println(resultantPointer.startIndex.data);
                resultantPointer.startIndex = resultantPointer.startIndex.next; 
            }
            System.out.println(resultantPointer.startIndex.data);
        } 
        else if(resultantPointer.startIndex != null) {
            System.out.println("subset linked list is null.Thus, returning list1");
            while(resultantPointer.startIndex != null) {
                System.out.println(resultantPointer.startIndex.data);
                resultantPointer.startIndex = resultantPointer.startIndex.next; 
            }
        } else{
            System.out.println("Either list1 is null or no subset found");
        }
    }
}