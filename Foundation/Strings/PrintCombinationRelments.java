/**
 * This problem prints combination of a string for r elements. 
 * For example, if a string is wxyz and r = 2 them output would be printing all combination with two character
 * i.e. wx, xy, yz, wy, xz, wz
 * For example, if a string is wxyz and r = 3 then output would be: wxz, wyz, wxy, xyz
 * Please make sure to do problem print combination of a string before doing this problem
*/
import java.util.HashMap;
import java.util.Map.Entry;

public class PrintCombinationRelments {
    private static String inputString;
    StringBuilder sb = new StringBuilder();
    HashMap<String, String> map = new HashMap<>();

    public PrintCombinationRelments(String str) {
        inputString = str;
    }


    //print combination of r elements in a string
    public void printRCombination(int r) {
        int start = 0;
        printRCombinations(start, r);
        for(Entry<String, String> entry: map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }

    public void printRCombinations(int start, int r) {
        for(int i = start; i < inputString.length(); i++) {
            sb.append(inputString.charAt(i));
            if(sb.length() == r) {
                map.put(sb.toString(), sb.toString());
            }
            if(i < inputString.length()) {
                printRCombinations(i + 1, r);
            }
            sb.setLength(sb.length() - 1);
        }
    }

    //main method
    public static void main(String args[]) {
        PrintCombinationRelments strObj = new PrintCombinationRelments("aabc");
        int r = 3;
        strObj.printRCombination(r);

    }
}