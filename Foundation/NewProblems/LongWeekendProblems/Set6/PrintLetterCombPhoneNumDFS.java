/**
 * This code print all letter combination of a phone number
 * Reference: https://www.programcreek.com/2014/04/leetcode-letter-combinations-of-a-phone-number-java/ 
 * Example: I
 *  Input:Digit string "23", Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]
 * 
*/
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PrintLetterCombPhoneNumDFS {


    // DFS approach to print all combination of a number
    public static List<String> letterCombination(String digit) {
        HashMap<Character, char[]> dict = new HashMap<>();
        dict.put('2', new char[]{'a', 'b', 'c'});
        dict.put('3', new char[]{'d', 'e', 'f'});
        dict.put('4', new char[]{'g', 'h', 'i'});
        dict.put('5', new char[]{'j', 'k', 'l'});
        dict.put('6', new char[]{'m', 'n', 'o'});
        dict.put('7', new char[]{'p', 'q', 'r', 's'});
        dict.put('8', new char[]{'t', 'u', 'v'});
        dict.put('9', new char[]{'w', 'x', 'y', 'z'});
        
        List<String> result = new ArrayList<>();
        if(digit == null || digit.length() == 0) {
            return result;
        }
        
        char[] arr = new char[digit.length()];
        helper(digit, 0, dict, result, arr);
        return result;
    }
    
    public static void helper(String digit, int index, HashMap<Character, char[]> dict, 
                        List<String> result, char[] arr) {
        
        if(index == digit.length()) {
            result.add(new String(arr));
            return;
        }

        char number = digit.charAt(index);
        char[] candidates = dict.get(number);
        for(int i = 0; i < candidates.length; i++) {
            arr[index] = candidates[i];
            helper(digit, index+1, dict, result, arr);
        }
    }

    // main method
    public static void main(String args[]) {
        String str = "23";
        List<String> res = letterCombination(str);
        for(int i = 0; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}