/**
 * Word break problem:
 * Given an input string and a dictionary of words, 
 * find out if the input string can be segmented into a space-separated sequence of dictionary words
 * Approach:
    * The idea is simple, we consider each prefix and search it in dictionary. If the prefix is present in dictionary, 
    * we recur for rest of the string (or suffix). If the recursive call for suffix returns true,
    * we return true, otherwise we try next prefix. 
    * If we have tried all prefixes and none of them resulted in a solution, we return false.
*/

import java.util.Dictionary;
import java.util.HashSet;

public class WordBreakProblem {

    public static HashSet<String> dictionary = new HashSet<>();
    // Recursive function that returns true if the word can be segmented into parts 
    // such that each part is contained in dictionary

    public static boolean wordBreak(String word) {
        int size = word.length();

        // base case
        if(size == 0) {
            return true;
        }

        for(int i = 1; i <= size; i++) {
            // Now we will first divide the word into two parts , 
            // the prefix will have a length of i and check if it is  
            // present in dictionary ,if yes then we will check for  
            // suffix of length size-i recursively. if both prefix and  
            // suffix are present the word is found in dictionary. 
            if(dictionary.contains(word.substring(0, i)) && wordBreak(word.substring(i, size))) {
                return true;
            }
        }

        // if all cases failed then return false
        return false;
    }

    // main method
    public static void main(String args[]) {
        // array of strings to be added in dictionary set. 
        String temp_dictionary[] = {"mobile","samsung","sam","sung",  
        "man","mango","icecream","and",  
        "go","i","like","ice","cream"}; 

        for(String str: temp_dictionary) {
            dictionary.add(str);
        }

        // sample input cases 
        System.out.println(wordBreak("ilikesamsung")); 
        System.out.println(wordBreak("iiiiiiii")); 
        System.out.println(wordBreak("")); 
        System.out.println(wordBreak("ilikelikeimangoiii")); 
        System.out.println(wordBreak("samsungandmango")); 
        System.out.println(wordBreak("samsungandmango")); 
    }
}