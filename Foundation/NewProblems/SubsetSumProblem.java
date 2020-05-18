/*
  This code return whether the array contains the subset that combines to a certain sum 
  Reference: https://github.com/mission-peace/interview/blob/master/src/com/interview/dynamic/SubsetSum.java
  example: https://www.youtube.com/watch?v=s6FhG--P7z0
*/
public class SubsetSumProblem {

    // Recursive function to check if subset sum exist or not 
    public static boolean isSubsetSum(int[] arr, int n, int sum) {
        if(sum == 0) {
            return true;
        }
        if(n == 0 && sum != 0) {
            return false;
        }
        return isSubsetSum(arr, n-1, sum) || isSubsetSum(arr, n-1, sum-arr[n-1]);
    }

    // Iterative method to check whether subset sum exists or not
    public static boolean isSubsetSumIter(int[] arr, int n, int sum) {
        // row -> sum and col -> element
        boolean [][] T = new boolean[n + 1][sum + 1];

        // if sum is zero then n is true
        for(int i = 0; i <= n; i++) {
            T[i][0] = true;
        }

        for (int i = 1; i <= arr.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j - arr[i - 1] >= 0) {
                    T[i][j] = T[i - 1][j] || T[i - 1][j - arr[i - 1]];
                } else {
                    T[i][j] = T[i - 1][j];
                }
            }
        }

        return T[n][sum];
    }

    // main method
    public static void main(String args[]) {
        int[] arr = {4,3,5};
        int sum = 7;
        int len = arr.length;
        boolean isSubSum = isSubsetSum(arr, len, sum);
        System.out.println("Subset sum: " + isSubSum);

        boolean isSubsetIter = isSubsetSumIter(arr, len, sum);
        System.out.println("subset sum iterative: " + isSubsetIter);
    }
}