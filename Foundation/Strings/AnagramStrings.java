/**
 This code checks whether two strings are anagram to each other using below approach:
 1. Store both the strings in an array
 2. Characters will get ascii values when one char gets subtracted from another
 2. Subtract all elements from char 'a' to normalize so get ASCII values
 3. Now, we subtract both the array from each other
 4. if we get 0 as the result then yes, both the strings are anagram of each other else else not anagram
*/

import java.util.Scanner;
//class to hold value of anagram strings
class AnagramCheck {
    boolean isAnagram;
    AnagramCheck() {
        isAnagram = false;
    }
    AnagramCheck(boolean isAnagram) {
        this.isAnagram = isAnagram;
    }
}

public class AnagramStrings {

    //function to check if two strings are anagram to each other
    public static AnagramCheck isAnagram(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return new AnagramCheck();
        }

        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        int maxDiff = 0;
        //Subtract each char from 'a' and store the values in an integer array
        for(int i=0; i<str1Array.length; i++) {
            arr1[str1Array[i] - 'a']++;
        }

        for(int j=0; j<str2Array.length; j++) {
            arr2[str2Array[j] - 'a']++;
        }

        //Store the difference in a variable
        for(int i=0; i<arr1.length; i++) {
            maxDiff += arr1[i] - arr2[i];

        }         

        if(maxDiff == 0) {
            return new AnagramCheck(true);
        } 
        return new AnagramCheck();
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter strings to check anagram");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        AnagramCheck anagCheck = isAnagram(str1, str2);
        System.out.print(anagCheck.isAnagram);
        sc.close();
    }
}

