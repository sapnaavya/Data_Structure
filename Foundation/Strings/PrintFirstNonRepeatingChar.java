import java.util.HashMap;
import java.util.Map.Entry;
import java.util.*; 
public class PrintFirstNonRepeatingChar {

    // using integer array to print first non repeating character
    public static char printFirstUniqChar(String str) {
        if(str == null || str.length() == 0) {
            return Character.MIN_VALUE;
        }

        int[] arr = new int[128];
        char[] charArr = str.toCharArray();
        for(int i = 0; i < charArr.length; i++) {
            arr[charArr[i]]++;
        }

        for(int i = 0; i < charArr.length; i++) {
            if(arr[charArr[i]] == 1){
                return charArr[i];
            }
        }

        return Character.MIN_VALUE;
    }

    // print first non repeating character using hashmap
    public static char printFirstUniqCharHashMap(String str) {
        if(str == null || str.length() == 0) {
            return Character.MIN_VALUE;
        }
        HashMap<Character, Integer> map = new HashMap<>();
        char[] charArr = str.toCharArray();
        for(int i = 0; i < charArr.length; i++) {

            if(!map.containsKey(charArr[i])) {
                map.put(charArr[i], 1);
            } else {
                map.put(charArr[i], map.get(charArr[i]) + 1);
            }
        }

        for(int i = 0; i < charArr.length; i++) {
            if(map.get(charArr[i]) == 1) {
                return charArr[i];
            }
        }

        return Character.MIN_VALUE;
        // // Using for-each loop 
        // for (Map.Entry elem : map.entrySet()) { 
        //     //String key = (String)elem.getKey(); 
  
            
        //     if((int)elem.getValue() == 1) {
        // //int value = ((int)elem.getValue() + 10); 
        //         return (char)elem.getKey();
        //     }
        // } 
    }

    // main method
    public static void main(String args[]) {
        String str = "ssapna";
        char ch = printFirstUniqChar(str);
        System.out.println(ch);
        char ch1 = printFirstUniqCharHashMap(str);
        System.out.println(ch1);
    }
}