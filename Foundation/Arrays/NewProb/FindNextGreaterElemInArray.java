/**
* This code find the next bigger element for each element in the array
    Two approaches:
    * 1. using two for loop
    * 2. Using stack
*/
public class FindNextGreaterElemInArray {

    //stack class implementation
    static class Stack {
        int top;
        int [] items = new int[99];
        public void push(int x) {
            if(top == 99) {
                System.out.println("Stack full");
            } else {
                items[++top] = x;
            }
        }

        //Pop element from stack
        public int pop() {
            if(top == -1) {
                System.out.println("Underflow error");
                return -1;
            } else {
                int element = items[top];
                top--;
                return element;
            }
        }

        //Stack is empty
        boolean isEmpty() {
            return top == -1 ? true: false;
        }
    }
    
    //function to find next greater element using two for loop
    //Time complexity - O(n*n)
    static void findNGE(int[] arr) {
        if(arr.length == 0) {
            return;
        }
        int n = arr.length;
        for(int i = 0; i < n; i++) {
            int next = -1;
            for(int j = i+1; j < n; j++) {
                if(arr[i] < arr[j]) {
                    next = arr[j];
                    break;
                }
            }
            System.out.println(arr[i] + " --> " + next);
        } 
    }

    //Function to find next greater element using stack
    //Here, we are using stack as an extra buffer. Time complexity - O(n)
    //4, 10, 5, 15, 25, 40
    static void findNGEUsingStack(int [] arr) {
        if(arr.length == 0) {
            return ;
        }
        int i = 0;
        Stack s = new Stack();
        s.top = -1;
        int element, next;
        int n = arr.length;

        //push the element from stack
        s.push(arr[0]);
        //iterate over the elements
        for(i = 1; i < n; i++) {
            next = arr[i];
            if(s.isEmpty() == false) {
                element = s.pop();
                /* If the popped element is smaller than  
                next, then a) print the pair b) keep  
                popping while elements are smaller and  
                stack is not empty */
                while(element < next) {
                    System.out.println(element + " --> " + next); 
                    if (s.isEmpty() == true) 
                        break; 
                    element = s.pop(); 
                }
                /* If element is greater than next, then  
                   push the element back */
                if(element > next) {
                    s.push(element);
                }
            }
            s.push(next);
        }

        /* After iterating over the loop, the remaining  
        elements in stack do not have the next greater  
        element, so print -1 for them */
        while (s.isEmpty() == false)  
        { 
            element = s.pop(); 
            next = -1; 
            System.out.println(element + " -- " + next); 
        } 
    }

    //main method
    public static void main(String args[]) {
        int [] arr = {4, 10, 5, 15, 25, 50};
        findNGE(arr);
        System.out.print("\n"); 
        findNGEUsingStack(arr);
    }
}