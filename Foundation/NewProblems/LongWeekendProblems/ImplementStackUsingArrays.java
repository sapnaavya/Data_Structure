public class ImplementStackUsingArrays {
    int size;
    int arr[];
    int top;
    ImplementStackUsingArrays(int size) {
        this.size = size;
        this.arr = new int[size];
        this.top = -1;
    }

    // push function
    public void push(int x) {
        if(!isFull()) {
            top++;
            arr[top] = x;
            System.out.println("pushed element: " + x);
        } else {
            System.out.println("stack overflow");
        }
    }

    // pop function 
    public int pop() {
        if(!isEmpty()) {
            int returnedTop = top;
            top--;
            System.out.println("popped element: " + arr[returnedTop]);
            return arr[returnedTop];
        } else {
            System.out.println("stack is empty");
            return -1;
        }
    }

    public int peek() {
        if(!isEmpty()) {
            return arr[top];
        } else {
            System.out.println("stack is empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }
    public boolean isFull() {
        return (size - 1 == top);
    }
    // main method 
    public static void main(String args[]) {
        ImplementStackUsingArrays StackCustom = new ImplementStackUsingArrays(10);
        StackCustom.pop();
        System.out.println("=================");
        StackCustom.push(10);
        StackCustom.push(30);
        StackCustom.push(50);
        StackCustom.push(40);
        System.out.println("=================");
        StackCustom.pop();
        StackCustom.pop();
        StackCustom.pop();
        System.out.println("=================");
    }
}