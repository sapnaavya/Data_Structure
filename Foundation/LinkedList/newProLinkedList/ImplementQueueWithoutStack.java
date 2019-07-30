/**
 * Function to implement queue without using extra stack
 *  References: https://www.dineshonjava.com/implement-queue-using-stack/
 */
import java.util.Stack;

public class ImplementQueueWithoutStack {

    public static Integer dequeue(Stack<Integer> stack) {
        return pop(stack);
    }


    //call pop recursively 
    public static Integer pop(Stack<Integer> stack) {
        Integer top = stack.pop();
        Integer last;
        if(stack.isEmpty()) {
            return top;
        } else {
            last = pop(stack);
        }
        stack.push(top);
        return last;
    }

    //main method
    public static void main(String args[]) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0; i < 10; i++) {
            stack.push(i);
        }
        int size = stack.size();
        for(int i = 0; i < size; i++) {
            int element = dequeue(stack);
            System.out.println(element);
        }
    }
}