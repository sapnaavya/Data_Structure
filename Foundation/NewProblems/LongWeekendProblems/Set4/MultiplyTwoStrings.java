/**
 * This code multiply two strings
 * 
*/
import java.util.Scanner;

public class MultiplyTwoStrings {
    // Function to multiply two strings
    public static String multiple(String str1, String str2) {
        String n1 = new StringBuilder(str1).reverse().toString();
        String n2 = new StringBuilder(str2).reverse().toString();
        int [] d = new int[n1.length() + n2.length()];

        // multiply each position and sum at the corresponding positions
        for(int i = 0; i < n1.length(); i++) {
            for(int j = 0; j < n2.length(); j++) {
                d[i+j] +=(n1.charAt(i) - '0') * (n2.charAt(j) - '0');
            }
        }
        StringBuilder sb = new StringBuilder();

        // Calculate each digit
        for(int i = 0; i < d.length; i++) {
            int mod = d[i] % 10;
            int carry = d[i] / 10;
            if(i+1 < d.length) {
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        // remove front 0's
        while(sb.charAt(0) == '0' && sb.length() > 1) {
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    // main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String multiStr = multiple(str1, str2);
        System.out.println(multiStr);
    }
}