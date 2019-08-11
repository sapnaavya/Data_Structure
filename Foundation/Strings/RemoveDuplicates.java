/**
 * This code removes duplicates from the string
 */
import java.util.Scanner;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicates {

    // function to remove duplicates using ASCII Values of characters
    // boolean array converts the character to its numeric equivalent and checks for the value at this numeric index.
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

    // Function to remove duplicates using hashset
    // Remember the difference between Linkedset and hashset...
    // linkedhashset and hashset both do not allow duplicate values. However, linkedhashset maintains the insertion order
    public static String removeDupChar(String str) {
        if(str.length() == 0) {
            return null;
        }
        char[] charArr = str.toCharArray();
        HashSet<Character> set = new HashSet();
        StringBuilder sb = new StringBuilder();
        for(char c: charArr) {
            // if(!set.contains(c)) {
            //     set.add(c);
            //     sb.append(c);
            // }
            set.add(c);
        }

        for(char ch: set) {
            sb.append(ch);
        }
        return sb.toString();
    }

    // Bruteforce algorithm to remove duplicates from the string
    public static String removeDupBruteForce(String str) {
        if(str.length() == 0 || str == null) {
            return null;
        }
        char[] characters = str.toCharArray();
        int length = characters.length;

        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                if (characters[i] == characters[j]) {
                    // delete the duplicate element by shifting the elements to left
                    for (int k = j; k < length - 1; k++) {
                    	characters[k] = characters[k + 1];
                    }
                    
                    length--; // reduce char array length
                }
            }
        }

        String stringWithOutDuplicates = new String(characters);
	    stringWithOutDuplicates = stringWithOutDuplicates.substring(0, length);
        return  stringWithOutDuplicates;
    }

    // main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        /* Remove duplicates using ASCII value of character */
            // String removedDup = removeDup(str);
            // System.out.println(removedDup);

        /* Remove duplicates using LinkedHashSet */
           // String rmvDup = removeDupLinkedHashSet(str);
        
        /* Remove duplicates using hashset */
            String str1 = removeDupChar(str);
            System.out.println(str1);
        
        /* Remove duplicates using bruteforce approach */
            String str23 = removeDupBruteForce(str); 
            System.out.println(str23);
            sc.close();
    }
}