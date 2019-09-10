/**
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which give the sum of zero.
    Note: The solution set may contain duplicate triplets.
    Example: Given array nums = [-1, 0, 1, 2, -1, -4],
    A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]

    Reference: https://fizzbuzzed.com/top-interview-questions-1/
               https://blog.gainlo.co/index.php/2016/07/19/3sum/
*/

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSumProblem {
    static ArrayList<Integer> llistOptimize = new ArrayList<>();
    static ArrayList<Integer> llistBruteforce = new ArrayList<>();

    // brute force solution
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

        // Optimize test
        boolean foundElemOpt = threeSumTwoPointer(arr);
        if(foundElemOpt) {
            for(int i = 0 ; i < llistOptimize.size(); i++) {
                System.out.println(llistOptimize.get(i));
            }
        }

    }
}