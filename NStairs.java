/**
   This code counts in how many ways you can reach to n stairs if you can take max of 1 or 2 steps
   Please note that fibonacci series starts from 0.  
   but in our case, our series begins at 1 even though n is 0 as we are assuming to reach that 0 step we took 1 step. 
   Assumption: we can only take 1 or 2 steps(hops) to reach n stairs
*/

import java.util.Scanner;

public class NStairs {

    //Simple recursive formula to calculate no ways to reach n stairs
    static int fib(int n) {
        if(n < 0) {
            return -1;
        }
        if(n == 0 || n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2) ;
    }

    //Memoization techniques to count no of ways to reach n stairs
    static int fibMemo(int n, int[] memo) {
        if(n < 0) {
            return -1;
        }
        if(n == 0 || n == 1) {
            return 1;
        } else if(memo[n] > 0) {
            return memo[n];
        }
        memo[n] = fibMemo(n-1, memo) + fibMemo(n-2, memo);
        return memo[n];
    }

    //BottomUp approach to count no of ways to reach n stairs
    static int fibBottomUp(int n) {
        if(n < 0) {
            return -1;
        }
        if(n == 0 || n == 1) {
            return 1;
        }
        int [] bottomUp = new int[n + 1];
        bottomUp[0] = 1;
        bottomUp[1] = 1;
        for(int i = 2; i <= n; i++) {
            bottomUp[i] = bottomUp[i - 1] + bottomUp[i - 2];
        }
        return bottomUp[n];
    }

    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();

        //calculating no of ways using recursive approach
        int noofWays = fib(number);
        System.out.println(noofWays);

        //calculating no of ways using memoization
        int[] memo = new int[number + 1];
        int noofWaysmemo = fibMemo(number, memo);
        System.out.println(noofWaysmemo);

        //calculating no of ways using bottomup approach
        int noofWaysBottomUp = fibBottomUp(number);
        System.out.println(noofWaysBottomUp);

        sc.close();
    }
}