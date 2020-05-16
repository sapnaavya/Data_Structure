class Node {
    int data; 
    Node next;
}

class Cqueue {
    private int _maxSize;
    private int currSize;
    private int[] arr;
    private int front;
    private int rear;
    public Cqueue(int maxSize) {
        _maxSize = maxSize;
        arr = new int[_maxSize];
        currSize = 0;
        front = -1;
        rear = -1;
    }

    // function to enqueue elements
    void enqueue(int item) {
        if(isFull()) {
            System.out.println("queue is full");
            return;
        }
        rear = (rear + 1) % arr.length;
        arr[rear] = item;
        currSize++;
        if(front == -1) {
            front = rear;
        }
    }

    // function to dequeue from the element
    public int dequeue() {
        if(isEmpty()) {
            System.out.println("Empty queue");
            return -2;
        }
        int elem = arr[front];

        front = (front + 1) % arr.length;
        currSize --;
        return elem;   
    }

    // check if queue is full
    public boolean isFull() {
        return (currSize == arr.length);
    }

    // check if queue is empty
    public boolean isEmpty() {
        return currSize == 0;
    }

    //display circular queue
    public void display() {
        for(int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

}
public class CQueueOperationsUsingArrays {
    public static void main(String[] args) {

        Cqueue circularQueue = new Cqueue(8);

        circularQueue.enqueue(15);
        circularQueue.enqueue(16);
        circularQueue.enqueue(17);
        circularQueue.enqueue(18);
        circularQueue.enqueue(19);
        circularQueue.enqueue(20);
        circularQueue.enqueue(21);
        circularQueue.enqueue(22);
        circularQueue.display();
        
        int elem = circularQueue.dequeue();
        System.out.println("elem dequeued: " + elem);
        circularQueue.enqueue(23);
        circularQueue.display();
    }
    
    
}