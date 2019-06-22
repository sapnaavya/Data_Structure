/**
 This code checks whether two strings are anagram to each other using below approach:
 1. Bruteforce approach
 2. Subtract string each character and from another strings character and store the result .. at the end maxdiff would be 0 if two strings are anagram
 3. Using XOR 
*/

import java.util.Scanner;
import java.util.Arrays;
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

    //Anagram - BruteForce approach
    public static AnagramCheck isAnagramBruteForce(String str1, String str2) {
        if(str1 == null || str2 == null) {
            return new AnagramCheck();
        }

        //Store Strings into character arrays
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str1.toCharArray();

        //sort both the arrays
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        //Traverse the sorted arrays and return false if two elements are not equal
        for(int i=0; i< charArr1.length; i++){
            if(charArr1[i] != charArr2[i]) {
                return new AnagramCheck();
            }
        }

        return new AnagramCheck(true);
    }

    //function to check if two strings are anagram to each other
    // ASCII values a-z  -> 97- 122
    // ASCII values A-Z  -> 65 - 90
    // for example, sapp and ppas maxdiff would be - 3-15+15-3 = 0
    public static AnagramCheck isAnagram(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() != str2.length()) {
            return new AnagramCheck();
        }

        int maxDiff = 0;
        for(int i = 0; i < str1.length(); i++) {
            maxDiff += (int)str1.charAt(i) - (int) str2.charAt(i);
        }
        return new AnagramCheck(maxDiff == 0);
    }

    //function to check if two strings are anagram of each other using XOR 

    /* The implementation can be further optimized by using bit manipulation. 
    If we start at a value of 0 and XOR all the characters of both strings, we should return an end value of 0 if they are anagrams
    because there would be an even occurrence of all characters in the anagram */

    public static AnagramCheck isAnagramXOR(String str1, String str2) {
        if(str1 == null || str2 == null || str1.length() != str2.length()) {
            return new AnagramCheck();
        }
        int value = 0;
        for(int i = 0; i < str1.length(); i++) {
            value = value ^ (int) str1.charAt(i) ^ (int) str2.charAt(i);
            // value = value ^ (int) str2.charAt(i);
        }
        return new AnagramCheck(value == 0);
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter strings to check anagram");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        AnagramCheck anagCheck = isAnagram(str1, str2);
        System.out.println(anagCheck.isAnagram);

        AnagramCheck anagramCheckBruteforce = isAnagramBruteForce(str1, str2);
        System.out.println(anagramCheckBruteforce.isAnagram);

        //check for anagram using XOR 
        AnagramCheck anagramCheckXOR = isAnagramXOR(str1, str2);
        System.out.println(anagramCheckXOR.isAnagram);
        sc.close();
    }
}

