/**
 * This code evaluates expression
 * Reference: https://www.geeksforgeeks.org/expression-evaluation/
 * Example: 
*/
import java.util.Stack;

public class EvaluateExpression {

    // function to evaluate strings
    public static int evaluate(String expression) {
        char[] tokens = expression.toCharArray();

        // Stack for numbers
        Stack<Integer> values = new Stack<>();

        // Stack for operators
        Stack<Character> ops = new Stack<>();

        for(int i = 0; i < tokens.length; i++) {
            // if token is a whitespace, skip it
            if(tokens[i] == ' ') {
                continue;
            }

            // if current token is a number, push it to the stack for numbers
            if(tokens[i] >= '0' && tokens[i] <= '9') {
                StringBuilder sb = new StringBuilder();

                // There may be more than one digits in number 
				while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9') {
                    //System.out.print("hello");
                    //System.out.print(sb.toString());
                    sb.append(tokens[i++]);
                }
                //there may be more then one digit in a number
                values.push(Integer.parseInt(sb.toString()));
            }

            // current token is an opening braces, push it to the ops
            else if(tokens[i] == '(') {
                ops.push(tokens[i]);
            }

            // closing braces encountered, solve entire brace
            else if(tokens[i] == ')') {
                while(ops.peek() != '(') {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }
                ops.pop();
            }

            // else if current token is an operator
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {
                // While top of 'ops' has same or greater precedence to current 
                // token, which is an operator. Apply operator on top of 'ops' 
                // to top two elements in values stack 
                while(!ops.isEmpty() && hasPrecedence(tokens[i], ops.peek())) {
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                }

                // push current token to ops
                ops.push(tokens[i]);
            }
        }

        // entire expression has been parsed at this point, apply remaining ops to remaining values
        while(!ops.isEmpty()) {
            values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }

        // top of the values contain result, returns it
        // check for min and max value
        int result = values.pop();
        if(result > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } 
        if( result < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return result;
    }

    // Returns true if 'op2' has higher or same precedence as 'op1', 
    // otherwise returns false. 
    public static boolean hasPrecedence(char op1, char op2) 
    { 
        if (op2 == '(' || op2 == ')') 
            return false; 
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-')) 
            return false; 
        else
            return true; 
    } 

    // A utility method to apply an operator 'op' on operands 'a'  
    // and 'b'. Return the result. 
    public static int applyOp(char op, int b, int a) 
    { 
        switch (op) 
        { 
        case '+': 
            return a + b; 
        case '-': 
            return a - b; 
        case '*': 
            return a * b; 
        case '/': 
            if (b == 0) 
                throw new
                UnsupportedOperationException("Cannot divide by zero"); 
            return a / b; 
        } 
        return 0; 
    } 

    // main method
    public static void main(String args[]) {
        String str = "1 + 2";
        System.out.println(evaluate(str));
        System.out.println(evaluate("10 + 2 * 6")); 
        System.out.println(evaluate("100 * 2 + 12")); 
        System.out.println(evaluate("100 * ( 2 + 12 )")); 
        System.out.println(evaluate("100 * ( 2 + 12 ) / 14"));
        // below one also does not work
        //System.out.println(evaluate("4 + (3*1-3)")); 
        //below one wont work
        //System.out.println(evaluate("100(2)"));
    }
}