/**
 * This code prints all distinct combination or subsequence of a string using following approach:
    1. For each letter from input start position to end of input string
    2. Append the letter to the output string and store tha value in hashset to avoid duplicate values
    3. Print letters in output string
    4. If the current letter isn’t the last in the input string
    5. Generate remaining combinations starting at next position with iteration starting at next letter beyond  the letter just selected     
    6. Delete the last character of the output string

    for example, Input : abc
                 Output : a, b, c, ab, bc, ac, abc

                 Input : aaa
                 Output : a, aa, aaa

    Reference Link: https://javahungry.blogspot.com/2014/02/algorithm-for-combinations-of-string-java-code-with-example.html
*/

import java.util.HashSet;
import java.util.Iterator;

public class PrintDistinctCombination {

    private final String inputString;
    HashSet<String> set = new HashSet<String>();

    public PrintDistinctCombination(String str) {
        inputString = str;
        System.out.println("input string is:" + inputString);
    }
    
    StringBuilder sb = new StringBuilder();
    public void printCombinationofString() {
       printCombination(0);

       //Traversing elements  
       Iterator<String> itr = set.iterator();  
       while(itr.hasNext()) {
            System.out.println(itr.next());  
        }
    }

    public void printCombination(int start) {
        for(int i = start; i < inputString.length(); i++) {
            sb.append(inputString.charAt(i));

            //storing these values in hashset as hashset does not store duplicate values and we want to store distinct combinations
            set.add(sb.toString());
            if(i < inputString.length()) {
                printCombination(i + 1);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    //main method
    public static void main(String args[]) {
        PrintDistinctCombination strObj = new PrintDistinctCombination("abc");
        strObj.printCombinationofString();
    }
}