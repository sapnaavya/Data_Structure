/**
 * This code finds the number and its index in a sorted array. Since, array is sorted, we will use binary search algorithm
 * Assumptions: if it can not find the element, it will return -1
*/

class Index {
    int index;
    Index(int index) {
        this.index = index;
    }
}

public class FindElementSortedArray {

    //This function finds the number and its index in the array using recursive approach
    public static Index findIndex(int [] arr, int num, int start, int end) { 
        if (start > end)
        {
            return new Index(-1); //not found
        }

        int mid = (start + end) / 2;
        if(arr[mid] == num) {   
            return new Index(mid);
        } else if(arr[mid] < num) {
            return findIndex(arr, num, mid + 1, end);
        } 
        else {
            return findIndex(arr, num, start, mid - 1);
        } 
    }

    // Itrative function to find elements in a sorted array
    public static Index findIndexIter(int[] arr, int num, int start, int end) {
        if(arr.length == 0) {
            return null;
        }

        while(end >= start) {
            int mid = (start + end)/2;
            if(num == arr[mid]) {
                return new Index(mid);
            }
            if(num < arr[mid]) {
                end = mid - 1;
            }
            if(num > arr[mid]) {
                start = mid + 1;
            }
        }
        return new Index(-1);
    }

    //main method
    public static void main(String args[]) {
        int [] array1 = new int[]{2,4,6,8,10};
        int num = 10;
        int start = 0;
        int length = array1.length;
        Index index = findIndex(array1, num, start, length - 1);
        Index indexIter = findIndexIter(array1, num, start, length - 1);
        System.out.println("Number and its index is: "  +  index.index);
        System.out.println("Number and its index (Iterative): " + indexIter.index);
    }
}