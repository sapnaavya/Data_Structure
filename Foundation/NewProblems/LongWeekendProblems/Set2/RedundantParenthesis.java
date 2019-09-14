
/**
 * This code finds whether the string has redundant parenthesis or not
 * Reference: https://www.geeksforgeeks.org/expression-contains-redundant-bracket-not/
 * 
 */
import java.util.Stack;
public class RedundantParenthesis {

    // function to check whether string contains redundant parenthesis or not
    public static boolean redundantPar(String s) {
        char[] charArr = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        // Iterate through the given expression 
        for(int i = 0; i < charArr.length; i++) {
            // if current character is close parenthesis ')' 
            if(charArr[i] == ')') {
                char top = stack.peek();
                stack.pop();

                // If immediate pop have open parenthesis '(' 
				// duplicate brackets found 
                boolean flag = true;
                while(top != '(') {
                    // Check for operators in expression 
                    if (top == '+' || top == '-'
                            || top == '*' || top == '/') { 
                        flag = false; 
                    }

                    // fetch top element of the stack
                    top = stack.peek();
                    stack.pop(); 
                }

                // if operator not found
                if(flag == true) {
                    return true;
                }
            } else {
                stack.push(charArr[i]);
            }
        }
        return false;
    }

    // main method
    public static void main(String args[]) {
        String str = "((a+b))"; 
        boolean isRedPar = redundantPar(str); 
        System.out.println(isRedPar);

		str = "(a+(b)/c)"; 
        boolean isRedPar1 = redundantPar(str); 
        System.out.println(isRedPar1);

		str = "(a+b*(c-d))"; 
        boolean isRedPar2 = redundantPar(str); 
        System.out.println(isRedPar2);
    }
}