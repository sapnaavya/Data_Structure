/**
  This code counts the no of words in a string using below approach:

    1. It intializes two variable IN and OUT intialized as 1 and 0 repectively
    2. It sets the state variable to OUT in the beginning of the function.
    3. Whenever, it encounters special character, it chanegs the state as OUT
    4. whenever, the state is OUT and it encounters the character.. it changes the state to IN as increment the wordCount
    5. If state is still in and not out means we are still traversing the characters in the words.. so we will just increment the counter in that case
*/
import java.util.Scanner;

public class CountWords {

    static final int IN = 1;
    static final int OUT = 0;

    //This function count the no of words in a string
    public static int countWords(String str) {
        if(str == null) {
            return 0;
        }
        
        int state = OUT;
        int wordCount = 0;
        for(int i=0; i<str.length(); i++) {  

            if(str.charAt(i) == '\t' || str.charAt(i) == '\n'  || str.charAt(i) == ' ') {
                state = OUT;
            } else if(state == OUT) {
                state = IN;
                ++wordCount;
            } 
        }
        return wordCount;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int noOfWords = countWords(str);
        System.out.println(noOfWords);
        sc.close();
    }
}