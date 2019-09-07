/**
 * Need to understand the logic
 * Reference: https://www.programcreek.com/2014/04/leetcode-letter-combinations-of-a-phone-number-java/
              https://buttercola.blogspot.com/2014/09/leetcode-letter-combinations-of-phone.html
 */
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class PrintLetterCombPhoneNumBFS {
    public static List<String> letterCombinations(String digits) {
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
     
        List<String> l = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return l;
        }
     
        l.add("");
     
        for (int i = 0; i < digits.length(); i++) {
            ArrayList<String> temp = new ArrayList<>();
            String option = map.get(digits.charAt(i));
     
            for (int j = 0; j < l.size(); j++) {
                for (int p = 0; p < option.length(); p++) {
                    temp.add(new StringBuilder(l.get(j)).append(option.charAt(p)).toString());
                }
            }
     
            l.clear();
            l.addAll(temp);
        }
     
        return l;
    }

    // main method
    public static void main(String args[]) {
        String str = "23";
        List<String> res = letterCombinations(str);
        for(int i = 0 ; i < res.size(); i++) {
            System.out.print(res.get(i) + " ");
        }
    }
}