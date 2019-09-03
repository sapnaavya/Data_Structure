/**
 * This code converts integer to roman numerals
 * Assumption: Input is guaranteed to be within the range from 1 to 3999
 * Reference: https://www.youtube.com/watch?v=BvNKb7XtP5Q
 *  List:
 *  I -> 1, V -> 5, X -> 10, L -> 50, C -> 100, D -> 500, M -> 1000
 *  IV -> 4, IX -> 9, XL -> 40, XC -> 90, CD -> 400, CM -> 900
*/
public class ConvertIntegerToRoman {

    // function to convert integert to romans
    public static String convertIntToRoman(int num) {
        int[] arabics = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", 
                                        "X", "IX", "V", "IV", "I"};
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<arabics.length; i++) {
            while(num - arabics[i] >= 0) {
                sb.append(romans[i]);
                num = num - arabics[i];
            }
        }
        
        return sb.toString();
    }

    // main method
    public static void main(String args[]) {
        int num = 1904;
        String str = convertIntToRoman(num);
        System.out.println(str);
    }
}