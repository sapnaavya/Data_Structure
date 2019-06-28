/**
 This code checks whether two strings are anagram to each other using below approach:

 Assumption: Make sure to convert each char to lowercase
 we are converting each char to lowercase as we are counting the frequency 
 so we are considering 'b' and 'B' the same characters.
 Optimize approach:
    subtract each char from 'a' and count their frequency and store them in int array and subtract their frequencies from each other int array
        1. Store both the strings in an array
        2. Characters will get ascii values when one char gets subtracted from another
        2. Subtract all elements from char 'a' to normalize so get ASCII values
        3. Now, we subtract both the array from each other
        4. if we get 0 as the result then yes, both the strings are anagram of each other else else not anagram
        5. DO NOT FORGET TO DO MATH.abs before storing maxdiff value to cover 'aaaa' and 'dddd' scenario
 
  Bruteforce approach:
    1. Store both the strings in arrays
    2. sort both the arrays holding characters
    3. After sorting, traverse both the arrays and if elements are not equal then return false else return true
 
 Test Cases:
    1. aaaa dddd (same length, diff word)
    2. sapna sapna (same length, same arrangements)
    3. sap pas (same length, diff arrangements)
    4. sapna sapnaaa (diff lenght)
    5. AAAAA aaaaa(same characters but difference in caps letters )
*/

import java.util.Scanner;
import java.util.Arrays;
//class to hold value of anagram strings
class AnagramCheck {
    boolean isAnagram;
    AnagramCheck(boolean isAnagram) {
        this.isAnagram = isAnagram;
    }
}

public class AnagramStrings {

    //Anagram - BruteForce approach
    public static AnagramCheck isAnagramBruteForce(String str1, String str2) {
        if(str1 == null && str2 == null) {
            return new AnagramCheck(Boolean.TRUE);
        }

        if(str1 == null || str2 == null) {
            return new AnagramCheck(Boolean.FALSE);
        }

        //Store Strings into character arrays
        char[] charArr1 = str1.toCharArray();
        char[] charArr2 = str2.toCharArray();

        //sort both the arrays
        Arrays.sort(charArr1);
        Arrays.sort(charArr2);

        //Traverse the sorted arrays and return false if two elements are not equal
        for(int i=0; i< charArr1.length; i++){
            //convert to lower case first before comparing the letters
            char ch1 = Character.toLowerCase(charArr1[i]);
            char ch2 = Character.toLowerCase(charArr2[i]);

            if(ch1 != ch2) {
                return new AnagramCheck(Boolean.FALSE);
            }
        }

        return new AnagramCheck(Boolean.TRUE);
    }

    //Optimization - check each character's frequency in the strings and then subtract the frequency.

    public static AnagramCheck isAnagramOptimize(String str1, String str2) {
        //Both strings null -> return true
        if(str1 == null && str2 == null) {
            return new AnagramCheck(Boolean.TRUE);
        }

        // if one string is null or strings length is different -> return false
        if(str1 == null || str2 == null || str1.length() != str2.length()) {
            return new AnagramCheck(Boolean.FALSE);
        }

        char[] str1Array = str1.toCharArray();
        char[] str2Array = str2.toCharArray();
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
       
        //Subtract each char from 'a' and store the values in an integer array
        for(int i = 0; i < str1Array.length; i++) {
            //Convert to lower case first
            char ch = Character.toLowerCase(str1Array[i]);
            arr1[ch - 'a']++;
        }

        //subtract each char from 'a' and store the value in an integer array
        for(int i = 0; i < str2Array.length; i++) {
            //Convert to lower case first
            char ch = Character.toLowerCase(str2Array[i]);
            arr2[ch - 'a']++;
        }

        int maxDiff = 0;
        //Store the difference in a variable
        for(int i = 0; i < arr1.length; i++) {      
            maxDiff += Math.abs(arr1[i] - arr2[i]);
        }  

        if(maxDiff == 0) {
            return new AnagramCheck(Boolean.TRUE);
        } 

        return new AnagramCheck(Boolean.FALSE);
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter strings to check anagram");
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        AnagramCheck anagCheck = isAnagramOptimize(str1, str2);
        System.out.println(anagCheck.isAnagram);

        AnagramCheck anagramCheckBruteforce = isAnagramBruteForce(str1, str2);
        System.out.println(anagramCheckBruteforce.isAnagram);
        sc.close();
    }
}

