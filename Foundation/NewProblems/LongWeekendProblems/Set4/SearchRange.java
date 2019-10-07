/**
 * This code finds the starting and end index in a sorted array
 * Example: Given [5, 7, 7, 8, 8, 10]
    and target value 8,
    return [3, 4].

*/

class Range {
    int start;
    int end;
    Range() {
    }
}
public class SearchRange {

    // Example: Given [5, 7, 7, 8, 8, 10]

    // function to find range from a sorted array
    public static Range searchRange(int[] arr, int b) {
        Range range = new Range();
        int n = arr.length-1;
        range.start = getFirstOccurance(arr,0, n, b);
        range.end = getLastOccurance(arr, 0, n, b);
        return range;
    }

    public static int getFirstOccurance(int[] arr, int l, int r, int b) {
        if(l <= r){
            int m = (l+r)/2;
            if(m == 0 || b > arr[m-1] && arr[m] == b) {
                return m;
            }
            if(b > arr[m]) {
                return getFirstOccurance(arr, m+1, r, b);
            } else {
                return getFirstOccurance(arr, l, m-1, b);
            }
        }

        return -1;
    }

    public static int getLastOccurance(int[] arr, int l, int r, int b) {
        if(l <= r){
            int m = (l+r)/2;
            if(m == 0 || b < arr[m+1] && arr[m] == b) {
                return m;
            }
            if(b > arr[m]) {
                return getLastOccurance(arr, m+1, r, b);
            } else {
                return getLastOccurance(arr, l, m-1, b);
            }
        }
        return -1;
    }

    // main method
    public static void main(String args[]) {
        int [] arr = {5, 7, 7, 8, 8, 10};
        int targetVal = 8;
        Range range = searchRange(arr, targetVal);
        System.out.println("Starting and end range: " +  range.start  +" "+ range.end);
    }
}