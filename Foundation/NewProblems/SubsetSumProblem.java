/*
  This code return whether the array contains the subset that combines to a certain sum 
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

    // main method
    public static void main(String args[]) {
        int[] arr = {4,3,5};
        int sum = 7;
        int len = arr.length;
        boolean isSubSum = isSubsetSum(arr, len, sum);
        System.out.print("Subset sum: " + isSubSum);
    }
}