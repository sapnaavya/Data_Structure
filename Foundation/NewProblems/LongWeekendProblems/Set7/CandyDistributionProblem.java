import java.util.Arrays;

/**
 * This code finds the minimum no of candies we need to give to the students based on their ratings
 * 
 */
public class CandyDistributionProblem {

    public static int candiesDistribution(int[] ratings) {
        int n = ratings.length;
        if(n <= 1) return 1;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        for(int i = 1; i < n; i++) {
            if(ratings[i] > ratings[i-1]) {
                candies[i] = Math.max(candies[i], candies[i-1] + 1);
            }
        }
    
        for(int i = n-2; i >= 0; i--) {
            if(ratings[i] > ratings[i+1]) {
                candies[i] = Math.max(candies[i+1] + 1, candies[i]);
            }
        }
        
        int count = 0;
        for(int candy:candies) {
            count += candy;
        }
        return count;
    }
    // main method
    public static void main(String args[]) {
       int [] arr = {1, 5, 2, 1};
       int minCandies = candiesDistribution(arr);
       System.out.println(minCandies);
    }
}