/**
 * This code finds the index of the key in sorted array using ternary search 
 * Time Complexity: O(log3 n) where n is the size of the array.
 * References: https://www.geeksforgeeks.org/binary-search-preferred-ternary-search/
 */
public class TernarySearch {

    //this function searches for the key usinh ternary search using recursive manner
    static int ternarySearchRecur(int [] arr, int start, int end, int key) {
        if(end >= start) {
            int mid1 = start + (end - start) / 3;
            int mid2 = mid1 + (end - start) / 3;

            if(arr[mid1] == key) {
                return mid1;
            }
            if(arr[mid2] == key) {
                return mid2;
            }
            //ternarySearchRecur(arr, )
            if(key < arr[mid1]) {
                return ternarySearchRecur(arr, start, mid1 - 1, key); 
            } else if(key > arr[mid2]) {
                return ternarySearchRecur(arr, mid2 - 1, end, key);
            } else {
                return ternarySearchRecur(arr, mid1 + 1, mid2 - 1, key);
            }
        }
        return -1;
    }

    //this function searches for the key usinh ternary search in iterative manner
    static int ternarySearchIter(int[] arr, int start, int end, int key) {
        if(arr.length == 0) {
            return 0;
        }

        while(end >= start) {

            int mid1 = start + (end - start) / 3;
            int mid2 = mid1 +  (end - start) / 3;
            //check if key is present in any mid
            if(key == arr[mid1]) {
                return mid1;
            }

            if(key == arr[mid2]) {
                return  mid2;
            }

            //since, key is not present in any region, check in which region is it present
            if(key < arr[mid1]) {
                //System.out.println("hello");
                //key lies between mid1 and start
                end = mid1 - 1;
            }
            else if(key > arr[mid2]) {
                //key lies in between mid2 and end
                start = mid2 + 1;
            } else {
                // The key lies in between mid1 and mid2 
                //System.out.println("hello");
                start = mid1 + 1;
                end = mid2 - 1;
            }
        }
        //key not found
        return -1;
    }

    //main method
    public static void main (String args[]) {
        int [] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int start = 0;
        int end = arr.length - 1;
        
        int key = 4;
        int keyIndexiter = ternarySearchIter(arr, start, end, key);
        System.out.println("key is at index: " + keyIndexiter);

        int keyIndexRecur = ternarySearchRecur(arr, start, end, key);
        System.out.println("key is at index: " + keyIndexRecur); 
    }
}