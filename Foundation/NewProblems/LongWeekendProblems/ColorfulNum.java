/**
 * A number can be broken into different continguous sub-subsequence parts
 * Suppose, a number 3245 can be broken into parts like 3 2 4 5 32 24 45 324 245.
   And this number is a COLORFUL number, since product of every digit of a contiguous subsequence is
   different.

    N = 23
    2 3 23
    2 -> 2
    3 -> 3
    23 -> 6
    this number is a COLORFUL number since product of every digit of a sub-sequence are different.
*/
import java.util.HashSet;

public class ColorfulNum {

    // function returns 1 if integer is a colorful else return 0
    public static int colorful(int n) {
        if(n <= 0) {
            return 0;
        }

        HashSet<Integer> set = new HashSet<>();
        int prod;
        String a = String.valueOf(n);
        for(int i = 0; i < a.length(); i++) {
            prod = 1;
            for(int j = i; j < a.length(); j++) {
                prod *= a.charAt(j) - '0';
                if(!set.contains(prod)) {
                    set.add(prod);
                } else {
                    return 0;
                }
            }
        }
        return 1;
    }

    // main method
    public static void main(String args[]) {
        int n = 23;
        int colorFul = colorful(n);
        System.out.println(colorFul);
    }
}