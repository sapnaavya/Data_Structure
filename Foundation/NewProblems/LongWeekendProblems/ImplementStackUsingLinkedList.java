class Node {
    int data;
    Node next;
}

public class ImplementStackUsingLinkedList {
    Node node;

    ImplementStackUsingLinkedList() {
        this.node = null;
    }

    // push function
    public void push(int x) {
        Node temp = new Node();
        temp.data = x;
        // put top reference into top link
        temp.next = node;
        // update top preference
        node = temp;
    }
    
    // utility function to check if stack is empty or not
    public boolean isEmpty() {
        return node == null;
    }

    // utility function to return top element in a stack
    public int peek() {
        if(!isEmpty()) {
            return node.data;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }
    }

    // utility function to pop element from stack
    public void pop() {
        if(node == null) {
            System.out.println("underflow");
            return;
        } else {
            node = node.next;
        }
    }

    public void display() {
        if(node == null) {
            System.out.println("underflow");
            return;
        } else {
            Node temp = node;
            while(temp != null) {
                System.out.println(temp.data);
                temp = temp.next;
            }
        }
    }

    // main method
    public static void main(String args[]) {
        // create Object of Implementing class 
        ImplementStackUsingLinkedList obj = new ImplementStackUsingLinkedList(); 
        // insert Stack value 
        obj.push(11); 
        obj.push(22); 
        obj.push(33); 
        obj.push(44); 
  
        // print Stack elements 
        obj.display(); 
  
        // pritn Top element of Stack 
        System.out.printf("\nTop element is %d\n", obj.peek()); 
  
        // Delete top element of Stack 
        obj.pop(); 

        // pritn Stack elements 
        obj.display(); 

        // Delete top element of Stack 
        obj.pop(); 
  
        // print Top element of Stack 
        System.out.printf("\nTop element is %d\n", obj.peek()); 
    }

}