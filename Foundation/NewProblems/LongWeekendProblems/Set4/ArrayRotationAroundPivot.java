/** This code does two things:
 * 
 * -> find index from where array is sorted
 * -> find the index of target values in rotated sorted array
*/

public class ArrayRotationAroundPivot {

    /*
    * Given an array. The array is sorted and rotated around an unknown point.Suggest a O(logn) algo for finding the index of unknown point.
        Eg. arr = [40, 50, 12, 14, 18, 30]
        For arr[], your function should return index of 12.
        The idea is to use the binary search algorithm.
        During Binary search look for a pattern where A[i ]>A[i+1]. 
    Job is to find a point from where array is sorted
    * Reference: https://techpuzzl.wordpress.com/2010/06/29/array-rotation-around-a-pivot/ 
    * 
    */

    // recursive function to find pivotted index in rotated array
    public static int findPivot(int[] arr, int start, int end) {
        while(start <= end) {
            int i = (end - start)/2;
            if(arr[i] > arr[i+1]) {
                return arr[i+1];
            } else if(arr[i] < arr[start]) {      // pivot lies in the first half
                return findPivot(arr, start, i);
            } else {
                return findPivot(arr, i+1, end); //pivot lies in second half
            }
        }
        return 0;
    }

    /*
        Suppose a sorted array is rotated at some pivot unknown to you beforehand.
        (i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2 ).
        You are given a target value to search. If found in the array, return its index, otherwise return -1.
        You may assume no duplicate exists in the array.
        Input : [4 5 6 7 0 1 2] and target = 4
        Output : 0

    */

    public static int search(int[] arr, int b) {
        int i = 0;
        int j = arr.length - 1;
        
        while(i <= j) {
            int mid = (i + j)/2;
            if(arr[mid] == b) {
                return mid;
            }

            else if(arr[mid] >= arr[i]) {
                if(b >= arr[i] && b < arr[j]) {
                    j = mid - 1;
                } else {
                    i = mid + 1;
                }
            } else {
                if(b > arr[mid] && b <= arr[j]) {
                    i = mid + 1;
                } else {
                    j = mid - 1;
                }
            }
        }
        return -1;
    }

    // main method
    public static void main(String args[]) {
        int[] arr = {40, 50, 60, 12, 14, 18, 30, 35};
        int start = 0;
        int end = arr.length;
        int pivotIndex = findPivot(arr, start, end);
        System.out.println(pivotIndex);
        int targetVal = 60;
        int target = search(arr,targetVal);
        System.out.println(target);
    }
}