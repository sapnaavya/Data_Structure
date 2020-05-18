import java.util.HashMap;
import java.util.Map;

import jdk.nashorn.internal.ir.ContinueNode;
import jdk.nashorn.internal.runtime.regexp.joni.ast.ConsAltNode;

/**
 * Problem: Given an amount and the infinite supply of certain denominations, how many minimum coins,
    do you need to get this amount
    This problem is different from count the unique ways to form an amount using infinite supply of coins. 
    Here, we are counting the minimum coins needed to make the amount given
    Example: (bottom-up) https://www.youtube.com/watch?v=Y0ZqKpToTic
             (Top-down) https://www.youtube.com/watch?v=Kf_M7RdHr1M&feature=youtu.be
    code: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/CoinChangingMinimumCoin.java
    Top-Down time-complesity: O(T*N) if we dont use memoization, it will be exponential
    Time complexity - O(coins.size * total)
    Space complexity- O(coins.size * total)
*/

public class MinimumCoinsNeededCoinChange {

    /**
     * Top down dynamic programing. Using map to store intermediate results.
     * Returns Integer.MAX_VALUE if total cannot be formed with given coins
    */
    public int minimumCoinstopDown(int total, int [] coins, Map<Integer, Integer> map) {
        // if total is zero, then there is nothing to do it here
        if(total == 0) {
            return 0;
        }

        // if map contains the result means we have calculated it before, then return it
        if(map.containsKey(total)) {
            return map.get(total);
        }

        //iterate thro all the coins and see which one gives the best results
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            // if value of the coins is greater than the total then just continue
            if(coins[i] > total) {
                continue;
            }

            // recurse with total-coins[i] as the new total
            int val = minimumCoinstopDown(total-coins[i], coins, map);

            //if val we get from picking coins[i] as first coin for current total is less
            // than value found so far make it minimum.
            if(val < min) {
                min = val;
            }
        }

        // if min is max_value, then dont change it otherwise add 1 to it
        min = (min == Integer.MAX_VALUE ? min : min + 1);

        // memoize the minimum for current total
        map.put(total, min);
        return min;
    }
    
    /**
     * Bottom up way of solving this problem.
     * Keep input sorted. Otherwise temp[j-arr[i]) + 1 can become Integer.Max_value + 1 which
     * can be very low negative number
     * Returns Integer.MAX_VALUE - 1 if solution is not possible.
    */

    public int minimumCoinsBottomUp(int amount, int[] coins) {
        int minCoinsCount[] = new int[amount + 1];
        int R[] = new int[amount + 1];
        minCoinsCount[0] = 0;

        for(int i=1; i <= amount; i++){
            minCoinsCount[i] = Integer.MAX_VALUE;
            R[i] = -1;
        }

        for(int i = 0; i < coins.length; i++) {
            for(int j = 1; j <= amount; j++) {
                if(coins[i] <= j) {
                    if(minCoinsCount[j] >  (minCoinsCount[j -  coins[i]] + 1)) {
                        minCoinsCount[j] = 1 + minCoinsCount[j - coins[i]];
                        R[j] = i;
                    }
                }
            }
        }

        printCoinCombinations(R, coins);
        return minCoinsCount[amount];
    }

    public void printCoinCombinations(int[] R, int[] coins) {
        if(R[R.length - 1] == -1) {
            System.out.println("No solution possible");
            return;
        }

        int start = R.length - 1;

        while(start != 0) {
            int j = R[start];
            System.out.print(coins[j] + " ");
            start = start - coins[j];
        }
        System.out.print("\n");
    }

    public static void main ( String args[] ) {
        int total = 11;
        int coins[] = {1, 5, 6, 8};
        MinimumCoinsNeededCoinChange cc = new MinimumCoinsNeededCoinChange();
        int bottomUpValue = cc.minimumCoinsBottomUp(total, coins);
        System.out.println(String.format("Minimum coins needed (botttomUp) : %s", bottomUpValue));
        HashMap<Integer, Integer> map = new HashMap<>();
        int topDownValue = cc.minimumCoinstopDown(total, coins, map);
        System.out.print(String.format("Minimum coins needed (TopDown) : %s", topDownValue));
    }
}