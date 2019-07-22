/* this code check if a string contains valid paranthesis or not using Stack
    Valid parenthesis : {[a+(b - c)]}
    Invalid parenthsis: {(a + [b - c)]}

*/
import java.util.Scanner;
import java.util.Stack;

public class ValidStrings{

    //function to check if string  containing paranthesis is valid or not
    public static boolean balancedParenthesis(String str) {
        if(str == null) {
            return false;
        }

        Stack<Character> stack = new Stack<>();
        char[] charArr1 = str.toCharArray();
        for(int i=0; i<charArr1.length; i++) {

            //check if char has opening bracket, then push it and when we get closing bracket, we pop out from the stack and compare
            if(charArr1[i] == '[' || charArr1[i] == '{' || charArr1[i] == '(') {
                stack.push(charArr1[i]);
            } 

            if (charArr1[i] == '}' || charArr1[i] == ')' || charArr1[i] == ']') {
                if (stack.isEmpty())
                    return false;
                char last = stack.peek();
                if (charArr1[i] == '}' && last == '{' || charArr1[i] == ')' && last == '(' || charArr1[i] == ']' && last == '[')
                    stack.pop();
                else 
                    return false;
            }
        }

        //check if at the end, stack is empty then returns true as this mean string has valid parenthesis
        return stack.isEmpty() ? true : false;
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