/**
 * This code calculates the power mod D
 * Implement pow(x, n) % d.
    In other words, given x, n and d,
    find (xn % d)
    Input : x = 2, n = 3, d = 3
    Output : 2

    Note that remainders on division cannot be negative. 
    In other words, make sure the answer you return is non negative.
*/

public class ImplementPowerModD {

    public static int powModD(int x, int n, int d) {
        
        long rem = 1;
        int check = 0;

        // simple cases
        if(x == 0) {
            return 0;
        }
        if(n == 0) {
            return 1;
        }

        // make x positive check if power is odd
        if(x < 0) {
            x = Math.abs(x);
            if(n % 2 != 0) {
                check = 1;
            }
        }

        // x - 2  n - 3 and d - 3
        long temp = x % d;
        while(n != 0) {
            if(n % 2 != 0) {
                rem = (rem * temp) % d;
            }

            temp = temp * temp;
            temp = temp % d;
            n = n/2;
            
            if(rem > d) {
                rem = rem % d;
            }
        }

        if(check == 1) {
            return -(int)rem;
        }

        return (int)rem;
    }

    // main method
    public static void main(String args[]) {
        int n = 3;
        int x = -2;
        int d = 4;
        int val = powModD(x, n, d);
        System.out.println(val);
    }
}