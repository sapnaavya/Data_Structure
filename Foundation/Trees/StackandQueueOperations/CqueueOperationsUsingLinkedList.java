public class CqueueOperationsUsingLinkedList {
    // Structure of a node 
    static class Node {
        int data;
        Node next;
    }

    static class Cqueue {
        Node front, rear;
    }

    // function to create a circular queue
    static void enQueue(Cqueue q, int val) {
        Node temp = new Node();
        temp.data = val;
        if(q.front == null) {
            q.front = temp;
        } else {
            q.rear.next = temp;
        }
        q.rear = temp;
        q.rear.next = q.front;
    }

    // function to dequeue from a queue
    static int deQueue(Cqueue q) {
        if(q.front == null) {
            return Integer.MIN_VALUE;
        }

        int val;
        if(q.front == q.rear) {
            val = q.front.data;
            q.front = null;
            q.rear = null;
        } else {
            Node temp = q.front;
            val = temp.data;
            q.front = q.front.next;
            q.rear.next = q.front;
        }  
        return val;  
    }

    // Display queue
    static void displayQueue(Cqueue q) {
        Node temp = q.front;
        do{
            System.out.println(temp.data);
            temp = temp.next;  
        } while(temp != q.front);
    }

    /*  Driver of the program  */
    public static void main(String args[]) 
    {  
        // Create a queue and initialize front and rear  
        Cqueue  q = new Cqueue();  
        q .front = q .rear =  null;  
        
        // Inserting elements in Circular Queue  
        enQueue(q, 14);  
        enQueue(q, 22);  
        enQueue(q, 6);  
        
        // Display elements present in Circular Queue  
        displayQueue(q);  
        
        // Deleting elements from Circular Queue  
        System.out.printf("\nDeleted value = %d", deQueue(q));  
        System.out.printf("\nDeleted value = %d", deQueue(q));  
        
        // Remaining elements in Circular Queue  
        displayQueue(q);  
        
        enQueue(q, 9);  
        enQueue(q, 20);  
        displayQueue(q);  
        
    } 
}