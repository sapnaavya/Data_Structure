/**
 * This code merges two sorted arrays without using third arrays using below approach - O(1) extra space
 * 1. Compare x[i] with y[0]
 * 2. if x[i] > y[0]....Swap x[i] with y[0]
 * 3. Note that y is sorted from y[1 ... n-1] so rearrange y array and put y[0] to its right position
 * 4. Compare next element of x[i] with y[0]
*/

public class MergeTwoSortedArraysWithoutUsingThirdArray {

    //merge two sorted arrays without using third array
    public static void mergetwoSortedArray(int[] arr1, int[] arr2) {
        if(arr1.length == 0 || arr2.length == 0) {
            return;
        }
        for(int i = 0; i < arr1.length; i++) {
            if(arr1[i] > arr2[0]) {
                //swap elements arr1[i] and arr2[0]
                int temp = arr1[i];
                arr1[i] = arr2[0];
                arr2[0] = temp;

                //rearrange arr2 to put swapped element in the right position. Note: arr2[1.. n-1] is already sorted
                rearrangeElem(arr2);
            }
        }
    }

    //Rearrange sorted array to put arr[0] element in the right position
    private static void rearrangeElem(int [] arr) {
        int first = arr[0];
        int i;
        //Remember this for loop .. dont forget to put arr[i] < first...condition in for loop
        for(i = 1; i < arr.length && arr[i] < first ; i++) {
            arr[i - 1] = arr[i];
        }
        
        arr[i - 1] = first;
    }

    //Print arrays
    public static void printArrays(int [] arr) {
        for(int i = 0 ; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    //main method
    public static void main(String args[]) {
        int[] arr1 = {1, 2, 4,5, 6, 8};
        int[] arr2 = {1,7,9,10};
        mergetwoSortedArray(arr1, arr2);
        printArrays(arr1);
        System.out.print("\n");
        printArrays(arr2);
    }
}