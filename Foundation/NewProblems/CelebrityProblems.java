import java.util.Stack;

public class CelebrityProblems {
    static int MATRIX[][] = {{0, 0, 1, 0}, 
                            {0, 0, 1, 0}, 
                            {0, 0, 0, 0},
                            {0, 0, 1, 0}};

    // function to check if a knows b
    public static boolean knows(int a, int b) {
        boolean res = (MATRIX[a][b] == 1) ? true:false;
        return res;
    }

    // function to find celebrity
    public static int findCeleb(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        int c;
        for(int i = 0; i < n; i++) {
            //push every person to stack
            stack.push(i);
        }

        while(stack.size() > 1) {
            // Step 2 :Pop off top 
            // two persons from the  
            // stack, discard one  
            // person based on return 
            // status of knows(A, B)
            int a = stack.pop();
            int b = stack.pop();
            if(knows(a, b)) {
                stack.push(b);
            } else {
                // Step 3 : Push the  
                // remained person onto stack
                stack.push(a);
            }
        }

        c = stack.pop();
        System.out.println("c" + c);
        // check if a last person is a celebrity or not
        for(int i = 0; i < n; i++) {
            // If any person doesn't 
            //  know 'c' or 'a' doesn't  
            // know any person, return -1 
            if (i != c && (knows(c, i) || !knows(i, c))) {
                return -1;
            }
        }
        return c;
    }

    // main method
    public static void main(String args[]) {
        int n = 4;
        int result = findCeleb(n);
        if(result == -1) {
            System.out.println("no celebrity..");
        } else {
            System.out.println("celebrity ID: " + result);
        }
    }
}