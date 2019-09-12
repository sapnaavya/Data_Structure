/**
 * This code converts roman numerals to integer
 */
import java.util.HashMap;

public class ConvertRomanToInteger {

    // function to convert roman to integer
    public static int convertRomanToInt(String str) {
        if(str.length() == 0) {
            return 0;
        }

        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int len = str.length();
        int result = map.get(str.charAt(len - 1));
        for(int i = len - 2; i >= 0; i--) {
            if(map.get(str.charAt(i)) >= map.get(str.charAt(i+1))) {
                result += map.get(str.charAt(i));
            } else {
                result -= map.get(str.charAt(i));
            }
        }

        return result;
    }

    // main method
    public static void main (String args[]) {
        String str = "XL";
        int result = convertRomanToInt(str);
        System.out.println(result);
    }
}