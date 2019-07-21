/**
 * This code removes duplicates from the string
 */
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    //function to remove duplicates using ASCII Values of characters
    public static String removeDup(String str) {
        if(str == null || str.length() == 0) {
            return null;
        }
        boolean[] found = new boolean[256];
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < charArr.length; i++) {
            if(!found[charArr[i]]) {
                found[charArr[i]] = true;
                sb.append(charArr[i]);
            } 
        }

        return sb.toString();
    }

    // function to remove duplicates from String using LinkedHashSet as this will preserve your ordering, and remove duplicates.
    public static String removeDupLinkedHashSet(String str) {
        if(str == null || str.length() == 0) {
            return null;
        }
        Set<Character> set = new LinkedHashSet<>();
        char[] charArr = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char c: charArr) {
            set.add(c);
        }
        for(Character ch: set) {
            sb.append(ch);
        }
        return sb.toString();
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        /* Remove duplicates using ASCII value of character */
        // String removedDup = removeDup(str);
        // System.out.println(removedDup);

        /* Remove duplicates using LinkedHashSet */
        String rmvDup = removeDupLinkedHashSet(str);
        System.out.println(rmvDup);

        sc.close();
    }
}