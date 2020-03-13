namespace Foundation.Arrays {
    public class FoundElemSortedArray {
        public int FindElemRecursive(int[] arr,int elem, int start, int end) {
            if(arr.Length == 0) {
                return -1;
            }
            int mid = (start + end)/2;
            if(arr[mid] ==  elem) {
                return mid;
            }
            if(arr[mid] > elem) {
                return FindElemRecursive(arr, elem, start, mid - 1);
            } else {
                return FindElemRecursive(arr, elem, mid + 1, end);
            }
        }

        public int FindElemIterative(int[] arr, int elem) {
            if(arr.Length == 0) {
                return -1;
            }
            int start = 0;
            int end = arr.Length;
            while(start < end) {
                int mid = (start + end) / 2;
                if(arr[mid] == elem) {
                    return mid;
                }
                if(arr[mid] > elem) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            return -1;
        }
    }
}