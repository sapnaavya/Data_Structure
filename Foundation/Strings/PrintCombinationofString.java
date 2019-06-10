/**
 * This code prints all the combination of a string using following approach:
    1.For each letter from input start position to end of input string
    2. Append the letter to the output string
    3. Print letters in output string
    4. If the current letter isn’t the last in the input string
    5. Generate remaining combinations starting at next position with iteration starting at next letter beyond  the letter just selected     
    6. Delete the last character of the output string
    Important point: This code only works when string has non repeating characters
    It wont work in the case when string = aabc
    Reference Link: https://javahungry.blogspot.com/2014/02/algorithm-for-combinations-of-string-java-code-with-example.html
*/

public class PrintCombinationofString {
    private final String inputString;
    public PrintCombinationofString(String str) {
        inputString = str;
        System.out.println("input string is:" + inputString);
    }
    
    StringBuilder sb = new StringBuilder();
    public void printCombinationofString() {
       printCombination(0);
    }

    public void printCombination(int start) {
        for(int i = start; i < inputString.length(); i++) {
            sb.append(inputString.charAt(i));
            System.out.println(sb);
            if(i < inputString.length()) {
                printCombination(i + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }
    //main method
    public static void main(String args[]) {
        PrintCombinationofString strObj = new PrintCombinationofString("wxyz");
        strObj.printCombinationofString();
    }
}