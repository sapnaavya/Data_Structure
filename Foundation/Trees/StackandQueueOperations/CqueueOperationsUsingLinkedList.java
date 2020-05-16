// Structure of a node 
class Node {
    int data;
    Node next;
}

class Cqueue {
    Node front, rear;
    public Cqueue() {
        front = null;
        rear = null;
    }

    // function to create a circular queue
    void enQueue(int val) {
        Node temp = new Node();
        temp.data = val;
        if(front == null) {
            front = temp;
        } else {
            rear.next = temp;
        }
        rear = temp;
        rear.next = front;
    }

    // function to dequeue from a queue
    int deQueue() {
        if(front == null) {
            return Integer.MIN_VALUE;
        }

        int val;
        if(front == rear) {
            val = front.data;
            front = null;
            rear = null;
        } else {
            Node temp = front;
            val = temp.data;
            front = front.next;
            rear.next = front;
        }  
        return val;  
    }

    // Display queue
    void displayQueue() {
        Node temp = front;
        do{
            System.out.println(temp.data);
            temp = temp.next;  
        } while(temp != front);
    }
}

public class CqueueOperationsUsingLinkedList {
    /*  Driver of the program  */
    public static void main(String args[]) 
    {  
        // Create a queue and initialize front and rear  
        Cqueue  q = new Cqueue();  
        //q .front = q .rear =  null;  
        
        // Inserting elements in Circular Queue  
        q.enQueue(14);  
        q.enQueue(22);  
        q.enQueue(6);  
        
        // Display elements present in Circular Queue  
        q.displayQueue();  
        
        // Deleting elements from Circular Queue  
        System.out.printf("\nDeleted value = %d", q.deQueue());  
        System.out.printf("\nDeleted value = %d", q.deQueue());  
        System.out.println();
        // Remaining elements in Circular Queue  
        q.displayQueue();  
        System.out.println();
        q.enQueue(9);  
        q.enQueue(20);  
        q.displayQueue();    
    } 
}