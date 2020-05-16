//stack class implementation
class Stack {
    private int top;
    private int _maxSize;
    private int[] arr;
    public Stack(int maxSize) {
        _maxSize = maxSize;
        arr = new int[_maxSize];
        top = -1;
    }

    //int [] items = new int[99];
    public void push(int x) {
        if(top == _maxSize - 1) {
            System.out.println("Stack full");
            return;
        } 
        arr[++top] = x;
    }

    //Pop element from stack
    public int pop() {
        if(top == -1) {
            System.out.println("Underflow error");
            return -1;
        } 

        int element = arr[top];
        top--;
        return element; 
    }

    //Stack is empty
    boolean isEmpty() {
        return top == -1 ? true: false;
    }
}

public class StackUsingArrays {
    public static void main(String args[]) {
        Stack stack = new Stack(3);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        stack.push(6);
        System.out.println(stack.pop());
    }
}