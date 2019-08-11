/**
 * General Idea: ways(n, m) = ways(n-1, m) + ways(n-2, m) + ... ways(n-m, m)
 * This code count the number of ways to reach the n steps if we take m hops. 
 * Assumption: Since we are starting our series from 0, we are considering step 0 and step 1 as will take atleast 1 hop i.e. stairs == 0 || stairs == 1 is 1 
 */

import java.util.Scanner;

public class NStairsGeneralize {

    //Calculate no of ways to reach n stairs using m steps - Recursion Technique
    static int nStairsRecur(int stairs, int hops) {
        if(stairs < 0) {
            return -1;
        }
        if(stairs == 0 || stairs == 1) {
            return 1;
        }
        int res = 0;
        for(int i = 1; i <= hops && i <= stairs; i++) {
            res += nStairsRecur(stairs - i, hops);
        }
        return res;
    }

    //Calculate no of ways to reach n stairs using m steps - Memoization Technique
    public static int nStairsGeneralizeMemoization(int stairs, int hops, int [] memo) {
        if(stairs < 0) {
            return -1;
        }
        if(stairs == 0 || stairs == 1) {
            return 1;
        } else if(memo[stairs] > 0) {
            return memo[stairs];
        }
        for(int i = 1; i <= stairs && i <= hops; i++) {
            memo[stairs] += nStairsGeneralizeMemoization(stairs - i, hops, memo);
        }
        return memo[stairs];
    }

    //Calculate no of ways to reach n stairs using m steps - Bottom Up Technique
    public static int nStairGeneralizeBottomUp(int stairs, int hops) {
        if(stairs < 0) {
            return -1;
        }
        int [] bottomUp = new int[stairs + 1];
        bottomUp[0] = 1;
        bottomUp[1] = 1;
        for(int i = 2; i <= stairs; i++) {
            for(int j = 1; j <= stairs && j <= hops; j++) {
                bottomUp[i] += bottomUp[i - j];
            }
        }
        return bottomUp[stairs];
    } 

    //main method
    public static void main(String args[]) {

        //Initialize scanner class and take input
        Scanner sc = new Scanner(System.in);
        int stairs = sc.nextInt();
        int hops = sc.nextInt();

        //Calculate no of ways using recursion
        int noofWays = nStairsRecur(stairs, hops);
        System.out.println(noofWays);

        //Calculate no of ways using memoization
        int [] memo = new int[stairs + 1];
        int noofwaysMemo = nStairsGeneralizeMemoization(stairs, hops, memo);
        System.out.println(noofwaysMemo);
        
        //Calculate no of ways using bottom up technique
        int noofwaysBottomup = nStairGeneralizeBottomUp(stairs, hops);
        System.out.println(noofwaysBottomup);
        
        sc.close();
    }
}