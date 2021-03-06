/**
This code generates all counts of permutations and unique combinations counts of coins combination, given an amount
This code uses two ways:
    1. Recursive - To calculate all possible combinations and uniqe combinations
    2. Iterative - To calculate unique combinations

  Example:
    https://www.youtube.com/watch?v=PafJOaMzstY
    
    * we are given coin denominations {1,2} and amount is 4.. what all combinations can be made
    * Permutations or total possible combinations could be {1,1,1,1} {1,1,2} {1,2,1} {2,1,1} {2,2}
    * but we want unique combinations as {1, 1, 2} {2, 1, 1} and {1, 1, 2} are same 
    * So, unique combinations would be {1,1,1,1} {1,1,2} {2,2}
    * So, total possible combinations or permutations count would be 5. 
    * But, total unique combinations count would be 3  

  Logic behind using currentCoin variable :

    *  Please note that to calculate unique combinations, we are maintaining currentCoin variable and everytime, passing that with recursion
    *  becuase with every recursive call, we dont need to start from 0 as we are doing in calculating all possible combinations.
    *  But, we can start from the currentCoin variable as we are only interested in counting unique combinations
*/
import java.util.Arrays;
import java.util.Scanner;

public class UniqueWaysCoinChange {

    //Calculate all possible combinations of coin change problem
    public static int permCoinChange(int amount, int [] coins) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0) {
            return 0;
        }

        int nPerms = 0;
        for(int coin = 0; coin < coins.length; coin++) {
            nPerms += permCoinChange(amount - coins[coin], coins);
        }
        return nPerms;
    }

    //Calculate unique combinations of coin change problem 
    public static int uniqueCombinationCount(int amount, int[] coins, int currentCoin) {
        if(amount == 0) {
            return 1;
        }
        if(amount < 0) {
            return 0;
        }
        int uniqueCombCount = 0;
        for(int i = currentCoin; i < coins.length; i++) {
            uniqueCombCount += uniqueCombinationCount(amount - coins[i], coins, i);
        }
        return uniqueCombCount;
    }

    //Calculate all unique combinations of coins change in iterative manner
    public static int uniqueCombIterative(int[] coins, int amount) {
       int [] ways = new int[amount + 1] ;

       //There is one ways to make 0 with 0 coins
       ways[0] = 1; 

       //Go through all the coins
       for(int i = 0; i < coins.length; i++) {
           //make comparison to each index value with coin value
           for(int j = 0; j < ways.length; j++) {
               if(coins[i] <= j) {
                   //Update the ways
                   ways[j] += ways[j - coins[i]];
                   //ways[j] = ways[j] + ways[j - coins[i]]
               }
           }
        }

        //return the value at nth position of ways array
        return ways[amount];
    }

    // // calculate no of ways to calculate coin change using 2D table
    // // m -> length of coins array
    // // n -> amount 
    // public static int countPerm(int[] coins, int m, int n) {
    //     int[][] table = new int[m+1][n+1];

    //     for(int i = 0; i < m; i++) {
    //         table[0][i] = 1;
    //     }

    //     for(int i = 1; i <= m; i++) {
    //         for(int j = 1; j <= n; j++) {
    //             if(coins[i-1] > j) {
    //                 table[i][j] = table[i-1][j];
    //             } else {
    //                 table[i][j] = table[i-1][j] + table[i][j-(i-1)];
    //             }
    //         }
    //     }
    //     return table[m][n];
    // }

    
    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt(); 
        int[] coins = new int[]{1,5,6,8};  

        //Calculate total possible combinations of coin change problem
        int permCoinChange = permCoinChange(amount, coins);
        System.out.println("Total possible combinations are: " + permCoinChange);

        //Calculate unique combinations of coin change problem
        int currentCoin = 0;
        int uniqCombCount = uniqueCombinationCount(amount, coins, currentCoin);
        System.out.println("Total unique combinations are: " + uniqCombCount);

        //Calculate unique combinations using iterative manner
        int iter = uniqueCombIterative(coins, amount);
        System.out.println("Total ways using iterative method:" + iter);
        sc.close();

        // // count no of ways to calculate combination using 2d table
        // int count1 = countPerm(coins, coins.length, amount);
        // System.out.println(count1);
    }
    
}