/* This code check if a string is a pallindromic string or not.

    brute force approach would be create a String build object and reverse the content of the string and store it in a another string object.
    In this approach, we are checking first and last element of string
*/

import java.util.Scanner;

public class PallindromeCheck {

    //Check if a string is pallindrome or not
    public boolean isPallindrome(String str) {
        if (str == null || str.isEmpty()) return false;

        int length = str.length();
        for(int i=0; i< length/2; i++) {
            char start = str.charAt(i);
            char end = str.charAt(length - i - 1);
            if(start != end) {
                return false;
            }
        }
        return true;
    }

    //Pallindrome check without storing string into character array
    public static boolean pallindromCheck(String str) {
        if (str == null || str.isEmpty()) return false;
        int length = str.length();
        for(int i=0; i< length/2; i++) {
            if(str.charAt(i) != str.charAt(length - i -1)) {
                return false;
            }
        }
        return true;
    }
    
    //main method
    public static void main(String args[]) {
        PallindromeCheck palObj = new PallindromeCheck();
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        boolean isPal = palObj.isPallindrome(str);
        System.out.println(isPal);

        boolean isPallindrome = pallindromCheck(str);
        System.out.println(isPallindrome);
        sc.close();
    }
}