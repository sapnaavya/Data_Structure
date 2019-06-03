/**
  This code finds the pattern in a string
 */
import java.util.Scanner;

public class FindPattern {

    //Find the starting index of a pattern in a string
    public static int findPattern(String str, String subsetString) {
        if(str == null || subsetString == null) {
            return -1;
        }

        int k = 0;
        char[] charArr1 = str.toCharArray();
        char[] charArr2 = subsetString.toCharArray();
        int s = 0;
        int start = s;
        for(int i=0; i<charArr1.length; i++) {
            if(charArr1[i] == charArr2[k]) {
                start = s;
                k++;
                if(k == subsetString.length()) {
                    return start;
                } 
                continue;
            } 
            else if(k != 0) {
                k = 0;
            }
            s = i + 1;
        }
        return -1;
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        int index = findPattern(str1, str2);
        if(index != -1) {
            System.out.println(str2  + " found at index: " + index);
        } else{
            System.out.println("No index found...");
        }
        sc.close();
    }
}