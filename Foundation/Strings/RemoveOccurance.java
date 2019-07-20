/**
 * This function removes occurances of a specific character using three ways:
    * 1. StringBuilder function
    * 2. Using recursive function
    * 3. Using character array - example tommy
 */
import java.util.Scanner;

public class RemoveOccurance {

    //This function remove occurance of a specific character from a string
    public String removeOccur(String str, char ch){
        if(str == null || ch == '\u0000') {
            return null;
        }

        StringBuilder sb = new StringBuilder();
        char[] charArr = str.toCharArray();
        for(int i=0; i<charArr.length; i++) {
            if(charArr[i] != ch) {
                sb.append(charArr[i]);
            }
        }
        return sb.toString();
    }

    //This function recursively removes a character from a string
    public static String removeOccurRecur(String str, char ch) {
        int index = str.indexOf(ch);
        if(index == -1) {
            return str;
        }
        int length = str.length();
        return removeOccurRecur(str.substring(0, index) + str.substring(index + 1, length), ch);
    }

    //function to remove character from a string using character array
    public static void removeCharIter(String str, char ch) {
        if(str == null || ch == '\u0000') {
            return;
        }
        char[] charArr = str.toCharArray();
        int j = 0;
        int counter = 0;

        for(int i = 0; i < charArr.length; i++) {
            if(charArr[i] != ch) {
                charArr[j++] = charArr[i];
            } else {
                counter++;
            }
        }
        //make null to useless indexes 
        while(counter > 0) {
            charArr[j++] = '\0';
            counter--;
        }
        System.out.println(charArr);
    }
    
    //main method
    public static void main(String args[]) {
        RemoveOccurance obj = new RemoveOccurance();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the String to remove a specific character");
        String str = sc.nextLine();
        System.out.println("Enter a character to remove from string");
        char ch = sc.next().charAt(0);

        /* Remove character using StringBuilder */
        //String removeString = obj.removeOccur(str, ch);
        //System.out.println(removeString);

        /* Remove character using recursive methos */
        //String removeOccurRecur = removeOccurRecur(str, ch);
        //System.out.println(removeOccurRecur);

        /* Remove character using iterative way */
        removeCharIter(str, ch);
        sc.close();
    }
}