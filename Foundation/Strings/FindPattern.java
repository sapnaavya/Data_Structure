/**
  This code finds the pattern in a string. For example, 
  1. if a string is sapna and subset string is pna then subset string index found at index 2 in string
  2. String -> sapna ... Subset String -> sap  then subset string index found at index 0 in string
  3. String -> sappna ... Subset String -> pna then subset string index found at index 3
  4. String -> sapna ... Subset String -> sd.. no index found in string
 */
import java.util.Scanner;

public class FindPattern {

    //Find the starting index of a pattern in a string
    public static int findPattern(String str, String subsetString) {
        if(str == null || subsetString == null || str.length() == 0 || subsetString.length() == 0) {
            return -1;
        }

        //subset string can not have length greater than string
        if(subsetString.length() > str.length()) {
            return -1;
        }

        int k = 0;
        char[] charArr1 = str.toCharArray();
        char[] charArr2 = subsetString.toCharArray();
        int s = 0;
        int start = s;
        //for(int i=0; i<charArr1.length; i++) { //DO NOT USE THIS FOR LOOP AS IT INCREMENTS i AND WE DO NOT WANT TO INCREMENT I EVERYTIME TO AVOID BLIND SPOT
        
        /**
         * make sure to reset the k pointer..before incrementing i .. thus first else if and check if k != 0  and if k is 0 then increment i++ to move on with search
         * to avoid this scenario: for example, string is sappna and subset string is pna 
        */

        int i = 0;
        while(i < charArr1.length) {       
            if(charArr1[i] == charArr2[k]) {
                start = s;
                k++;
                if(k == subsetString.length()) { // if k is equal to subset length that mean we have traversed the whole subset and found the subset
                    return start;
                }
                i++; 
                continue; //make sure not to miss this continue
            } 
            else if(k != 0) { // In this case, do not increment i as we want to compare with k as 0 with existing i and if they do not match then increment i
                k = 0;
                s = i; //make sure to assign s to existing i 
                continue;// make sure to use this continue as we do not want increment i after resetting k to 0
            }
            i++;
            s = i;
        }
        //}
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