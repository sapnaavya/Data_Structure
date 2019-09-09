/**
 * Given an array S of n integers, find three integers in S such that the sum is closest to a
    given number, target.
    Return the sum of the three integers.
    Assume that there will only be one solution
    Reference: https://www.programcreek.com/2013/02/leetcode-3sum-closest-java/
               https://www.youtube.com/watch?v=bcE3ifBNFpo
*/
import java.util.Arrays;

public class ThreeSumClosestProblem {
    public static int threeSumClosest(int [] nums, int target) {
        if(nums == null || nums.length < 3) {
            return -1;
        }

        Arrays.sort(nums); // Do not forget this step
        int closestSum = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length - 1;
            while(left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if(Math.abs(sum - target) < Math.abs(closestSum - target)) {
                    closestSum = sum;
                } 
                  
                if(sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return closestSum;
    }

    // main method
    public static void main(String args[]) {
        int[] arr = {-1, 2, 1, 4};
        int target = 5;
        int closestSum = threeSumClosest(arr, target);
        System.out.println(closestSum);
    }
}