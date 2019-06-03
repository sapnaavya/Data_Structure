/* this code check if a string contains valid paranthesis or not using Stack
    Valid parenthesis : {[()]}
    Invalid parenthsis: {([)]}
*/


import java.util.Scanner;
import java.util.Stack;

public class ValidStrings{

    //function to match pattern from popped element from stack and character array elements
    public static boolean ismatchingPair(char top, char ch) {
        if(top == '(' && ch == ')') {
            return true;
        } else if(top == '{' && ch == '}') {
            return true;
        } else if(top == '[' && ch == ']') {
            return true;
        } else { 
            return false;
        }
    }

    //function to check if string  containing paranthesis is valid or not
    public static boolean balancedParenthesis(String str) {
        if(str == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] charArr1 = str.toCharArray();
        for(int i=0; i<charArr1.length; i++) {

            //check if a character is not alphanumeric characters
            if ((charArr1[i] >= 'A' && charArr1[i] <= 'Z') || 
					(charArr1[i] >= 'a' && charArr1[i] <= 'z') &&
					    (charArr1[i] >= '0' && charArr1[i] <= '9')) {
                
                return Boolean.FALSE;
            }
            
            //check if char has opening bracket, then push it and when we get closing bracket, we pop out from the stack and compare
            if(charArr1[i] == '[' || charArr1[i] == '{' || charArr1[i] == '(') {
                stack.push(charArr1[i]);
                continue;
            } 
            else if(stack.isEmpty()) {
                return false;
            }

            char top = stack.pop();
            if(!ismatchingPair(top, charArr1[i])) {
                return false;
            }
        }

        //check if at the end, stack is empty then returns true as this mean string has valid parenthesis
        if(stack.isEmpty()) {
            return true;
        }
        return false;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean isValid = balancedParenthesis(str);
        System.out.println(isValid);
        sc.close();
    }
}