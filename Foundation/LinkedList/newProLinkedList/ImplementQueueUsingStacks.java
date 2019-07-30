/**
 * This code implements queue using extra stack
 */
import java.util.Stack;

public class ImplementQueueUsingStacks {
    static Stack<Integer> temp = new Stack<Integer>();

    //Function to implement queues using second stack
    public static void push(int i, Stack<Integer> stack) {
        if(stack.isEmpty()) {
            stack.push(i);
        } else {
            while(!stack.isEmpty()) {
                int elem = stack.pop();
                temp.push(elem);
            }
            stack.push(i);
            while(!temp.isEmpty()) {
                int tempElem = temp.pop();
                stack.push(tempElem);
            }
        }
    }

    //main method
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<Integer>();
        for(int i = 0; i < 10; i++) {
            push(i,stack);
        }
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
    }
}