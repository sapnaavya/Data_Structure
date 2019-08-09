/**
 * This function counts the anagram of a pattern in a string using two ways:
 * 1. BruteForce Method
 *      Approach: 
 *      a. Create every substring of word length from text 
 *      b. Check if that substring is an anagram or not and increase the counter, if it's an anagram
 * 
 * 2. Optimize Code - O(1) space
 *      Approach:
 *      An Efficient Solution is to use count array to check for anagrams. 
 *      we can construct current count window from previous window in O(1) time using sliding window concept.
 * 
*/

import java.util.Scanner;
public class CountAnagrams {

    // This function creates every substring of pattern's length from text and check if its an anagram and increment the counter
    public static int countAnagramBruteForce(String text, String word) {
        int textLen = text.length();
        int wordLen = word.length();
        int count = 0;
        for(int i = 0; i <= textLen - wordLen; i++) {
            String substr = text.substring(i, i + wordLen);
            if(isAnagram(substr, word)) {
                count++;
            }
        }

        return count;
    }

    // Optimize code to count anagram of a pettern in a string
    public static int countAnagramOptimize(String text, String word) {
        int textLen = text.length();
        int wordLen = word.length();
        if(textLen < wordLen) {
            return 0;
        }
        
        int[] count = new int[256];
        int res = 0;
        // Check for first window. The idea is to 
		// use single count array to match counts 
        for(int i = 0; i < wordLen; i++) {
            char ch = Character.toLowerCase(word.charAt(i));
            count[ch]++;
        }
        for(int i = 0; i < wordLen; i++) {
            char ch1 = Character.toLowerCase(text.charAt(i));
            count[ch1]--;
        }

        // If first window itself is anagram 
        if(isCountZero(count)) {
            res++;
        }

        for(int i = wordLen; i < textLen; i++) {
            // Add last character of current window 
            char ch = Character.toLowerCase(text.charAt(i));
            count[ch]--;
            // Remove first character of previous window.
            char prevChar = Character.toLowerCase(text.charAt(i - wordLen));
            count[prevChar]++;
            // If count array is 0, we found an anagram. 
            if(isCountZero(count)) {
                res++;
            }
        }
        return res;
    }  

    //function to check of all elements of arrays are equal to zero
    public static boolean isCountZero(int[] count) {
        for(int i = 0; i < count.length; i++) {
            if(count[i] != 0) {
                return Boolean.FALSE;
            }
        }
        return Boolean.TRUE;
    }

    //check if two strings are anagram of each other
    public static boolean isAnagram(String text, String word) {
        if(text.length() == 0 && word.length() == 0) {
            return Boolean.TRUE;
        }

        if(text == null || word == null || text.length() != word.length()) {
            return Boolean.FALSE;
        }

        char [] ch1 = text.toCharArray();
        char [] ch2 = word.toCharArray();
        int [] arr1 = new int[26];
        int [] arr2 = new int[26];
        for(int i = 0; i < ch1.length; i++) {
            char ch = Character.toLowerCase(ch1[i]);
            arr1[ch - 'a']++;
        }

        for(int i = 0; i < ch2.length; i++) {
            char ch = Character.toLowerCase(ch2[i]);
            arr2[ch - 'a']++;
        }

        int maxDiff = 0;
        for(int i = 0; i < arr1.length; i++) {
          maxDiff += Math.abs(arr1[i] - arr2[i]) ;  
        }

        return maxDiff == 0 ? Boolean.TRUE: Boolean.FALSE;
    }

    // main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String text = sc.nextLine();
        String word = sc.nextLine();

        // Count anagram of a pattern using Bruteforce
        int anagramCount = countAnagramBruteForce(text, word);
        System.out.println("Anagram count: " + anagramCount);

        // Count anagram of a pattern in a string using optimize code in O(1) space
        int anagramCountOpt = countAnagramOptimize(text, word);
        System.out.println("Anagram count using optimization code: " + anagramCountOpt);

        sc.close();
    } 
}