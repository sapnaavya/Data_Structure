/**
This code generates all counts of permutations and unique combinations counts of coins combination, given an amount
This code uses two ways:
    1. Recursive
    2. Iterative
  
  Example:

    * we are given coin denominations {1,2} and amount is 4.. what all combinations can be made
    * Permutations or total possible combinations could be {1,1,1,1} {1,1,2} {1,2,1} {2,1,1} {2,2}
    * but we want unique combinations as {1, 1, 2} {2, 1, 1} and {1, 1, 2} are same 
    * So, unique combinations would be {1,1,1,1} {1,1,2} {2,2}
    * So, total possible combinations or permutations count would be 5. 
    * But, total unique combinations count would be 3  

  Logic behing using currentCoin variable :

    *  Please note that to calculate unique combinations, we are maintaining currentCoin variable and everytime, passing that with recursion
    *  becuase with every recursive call, we dont need to start from 0 as we are doing in calculating all possible combinations.
    *  But, we can start from the currentCoin variable as we are only interested in counting unique combinations
*/
import java.util.Scanner;

public class CoinChange {

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
    public static int uniqueCombIterative(int[] coins) {
       int [] ways = new int[coins.length + 1] ;

       //There is one ways to make 0 with 0 coins
       ways[0] = 1; 

       //Go through all the coins
       for(int i = 0; i < coins.length; i++) {
           //make comparison to each index value with coin value
           for(int j = 0; j < ways.length; j++) {
               if(coins[i] <= j) {
                   //Update the ways
                   ways[j] += ways[j - coins[i]];
               }
           }
        }

        //return the value at nth position of ways array
        return ways[coins.length];
    }

    
    //main method
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int amount = sc.nextInt(); 
        int[] coins = new int[]{1,2};  

        //Calculate total possible combinations of coin change problem
        int permCoinChange = permCoinChange(amount, coins);
        System.out.println("Total possible combinations are: " + permCoinChange);

        //Calculate unique combinations of coin change problem
        int currentCoin = 0;
        int uniqCombCount = uniqueCombinationCount(amount, coins, currentCoin);
        System.out.println("Total unique combinations are: " + uniqCombCount);

        int iter = uniqueCombIterative(coins);
        System.out.println("Total ways using iterative method:" + iter);
        sc.close();
    }
    
}