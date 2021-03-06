/** 
 *  Java program to clone a linked list with next and arbit pointers in O(n) time  and O(1) space
 *  Approach:
 *   1. Insert new copy of node in original next:
 *         While traversing the original list, make copy of every node and save that in original node's next
 *   2.  Adjust random pointer of copyied nodes
 *         Add node.next.random = node.random.next
 *   3. Since original next is pointing copied node.. both the lists are intervined ... so separate the both lists from each other
 * 
*/
 

class ClonedListWithoutUsingHashMap { 
    // Structure of linked list Node 
    static class Node 
    { 
        int data; 
        Node next,random; 
        Node(int x) 
        { 
            data = x; 
            next = random = null; 
        } 
    }

    // Utility function to print the list. 
    static void print(Node start) 
    { 
        Node ptr = start; 
        while (ptr != null) 
        { 
            System.out.println("Data = " + ptr.data +  ", Random = " + ptr.random.data); 
            ptr = ptr.next; 
        } 
    } 

    // This function clones a given 
    // linked list in O(1) space 
    static Node clone(Node start) 
    { 
        Node curr = start, temp = null; 

        // insert additional node after 
        // every node of original list 
        while (curr != null) 
        { 
            //save next pointer in temp variable
            temp = curr.next; 
            // Inserting node 
            curr.next = new Node(curr.data); 
            curr.next.next = temp; 
            curr = temp; 
        } 

        //reset the curr to point to start of the node
        curr = start; 

        // adjust the random pointers of the newly added nodes 
        while (curr != null) 
        { 
            if(curr.next != null) {
                if(curr.random != null) {
                    curr.next.random = curr.random.next;
                } else {
                    curr.next.random = curr.random;
                }
            }  

            // move to the next newly added node by skipping an original node 
            if(curr.next != null) {
                curr = curr.next.next;
            } else {
                curr = curr.next;
            }
        } 

        //save original to point to start of original node
        Node original = start;

        // save the start of copied linked list in temp variable
        Node copy = start.next; 
        temp = copy; 

        // now separate the original list and copied list 
        while (original != null && copy != null) 
        { 
            if(original.next != null) {
                original.next = original.next.next;
            }
            
            if(copy.next != null) {
                copy.next = copy.next.next;
            }

            original = original.next; 
            copy = copy.next; 
        } 

        //since temp stores the starting point of cloned list, we return temp
        return temp; 
    } 

    // Driver code 
    public static void main(String[] args) 
    { 
        Node start = new Node(1); 
        start.next = new Node(2); 
        start.next.next = new Node(3); 
        start.next.next.next = new Node(4); 
        start.next.next.next.next = new Node(5); 

        // 1's random points to 3 
        start.random = start.next.next; 

        // 2's random points to 1 
        start.next.random = start; 

        // 3's and 4's random points to 5 
        start.next.next.random = start.next.next.next.next; 
        start.next.next.next.random = start.next.next.next.next; 

        // 5's random points to 2 
        start.next.next.next.next.random = start.next; 

        System.out.println("Original list : "); 
        print(start); 

        System.out.println("Cloned list : "); 
        Node cloned_list = clone(start); 
        print(cloned_list); 

    } 
} 
