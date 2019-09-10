/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which give the sum of zero.
    Note: The solution set may or may not contain duplicate triplets. Make sure to consider that scenario
    Example: Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
    Example: {1,2,3,4,5,7}

    Reference: https://fizzbuzzed.com/top-interview-questions-1/
               https://blog.gainlo.co/index.php/2016/07/19/3sum/
*/

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumProblem {
    static ArrayList<Integer> llistOptimize = new ArrayList<>();
    static ArrayList<Integer> llistBruteforce = new ArrayList<>();
    static ArrayList<Integer> llistBruteforceSorted = new ArrayList<>();

    // brute force solution 
    // Plese note it assume array does not have duplicates
    public static boolean threeSum(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
    
        for(int i = 0; i < n - 2; i++) {
            for(int j = i + 1; i < n - 1; j++) {
                for(int k = j + 1; k < n; k++) {
                    if(arr[i] + arr[j] + arr[k] == 0) {
                        llistBruteforce.add(arr[i]);
                        llistBruteforce.add(arr[j]);
                        llistBruteforce.add(arr[k]);
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // this code remove duplicates while findind three elements thats is equal to target
    // A brute force solution with working code that removes duplicates is as follows:
    public static boolean threeSumBruteForceSorted(int[] nums) {
        if(nums.length == 0 || nums == null) {
            return false;
        }
        int n = nums.length;
        Arrays.sort(nums);

        for(int i = 0; i < n; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) continue;
            for(int j = i + 1; j < n; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) continue;
                for(int k = j + 1; k < n; k++) {
                    if (k != j + 1 && nums[k] == nums[k - 1]) continue;
                    if(nums[i] + nums[j] + nums[k] == 9) {
                        llistBruteforceSorted.add(nums[i]);
                        llistBruteforceSorted.add(nums[j]);
                        llistBruteforceSorted.add(nums[k]);
                        return true;
                    }
                }
            }
        }
        return false;

    }

    // two Pointer Approach to find three sum solution
    public static boolean threeSumTwoPointer(int[] arr) {
        int l, r;
        Arrays.sort(arr);
        int n = arr.length;
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < n - 2; i++) {
            // To find the other two elements, start two index variables 
            // from two corners of the array and move them toward each other 
            l = i+1; // index of the first element in the remaining elements
            r = n-1; // index of the last element
            
            while(l < r) {
                //int sum = arr[i] + arr[l] + arr[r];
                if(arr[i] + arr[l] + arr[r] == 0) {
                    //System.out.print("hello");
                    llistOptimize.add(arr[i]);
                    llistOptimize.add(arr[l]);
                    llistOptimize.add(arr[r]);
                    return true;
                } else if(arr[i] + arr[l] + arr[r] < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return false;
    }

    // main method
    public static void main(String args[]) {
        int [] arr = {-1, 0, 1, 2, -1, -4};
        // BruteForce test
        boolean foundElemBruteforce = threeSum(arr);
        if(foundElemBruteforce) {
            for(int i = 0 ; i < llistBruteforce.size(); i++) {
                System.out.println(llistBruteforce.get(i));
            }
        }

        // bruteforce sorted test
        int[] arr1 = {-1,2,3,4};
        boolean foundElemBruteforcesorted = threeSumBruteForceSorted(arr1);
        if(foundElemBruteforcesorted) {
            for(int i = 0 ; i < llistBruteforceSorted.size(); i++) {
                System.out.println(llistBruteforceSorted.get(i));
            }
        }

        // Optimize test
        boolean foundElemOpt = threeSumTwoPointer(arr);
        if(foundElemOpt) {
            for(int i = 0 ; i < llistOptimize.size(); i++) {
                System.out.println(llistOptimize.get(i));
            }
        }

    }
}