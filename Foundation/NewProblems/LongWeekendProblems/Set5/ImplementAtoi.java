
/**
 * This code implements atoi functiont to convert string to integer
 * Reference: https://www.programcreek.com/2012/12/leetcode-string-to-integer-atoi/
 */
public class ImplementAtoi {
    public static int implementAtoi(String str) {
        if (str == null || str.length() < 1)
            return 0;

        // trim white spaces
        str = str.trim();
        char flag = '+';

        // check negative or positive
        int i = 0;
        if (str.charAt(0) == '-') {
            flag = '-';
            i++;
        } else if (str.charAt(0) == '+') {
            i++;
        }

        // use double to store result
        double result = 0; // do not forget to take this as double
        // calculate value
        while (str.length() > i && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            result = result * 10 + (str.charAt(i) - '0');
            i++;
        }

        if (flag == '-')
            result = -result;

        // handle max and min
        if (result > Integer.MAX_VALUE)
            return Integer.MAX_VALUE;
        if (result < Integer.MIN_VALUE)
            return Integer.MIN_VALUE;
            
        return (int) result;
    }
    // main method
    public static void main(String args[]) {
        String str = "-99. 9";
        int val = implementAtoi(str);
        System.out.println(val);
    }
}