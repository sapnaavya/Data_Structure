namespace Foundation.Arrays {
    public class TernarySearch {
        public int Ternary_Search_Iter(int[] arr, int start, int end, int key) {
            if(arr.Length == 0) {
                return -1;
            }

            while(end >= start) {
                int mid1 = start + (end - start) / 3;
                int mid2 = mid1 + (end - start) / 3;
                if(key == arr[mid1]) {
                    return mid1;
                }
                if(key == arr[mid2]) {
                    return mid2;
                }
                if(key < arr[mid1]) {
                    end = mid1 - 1;
                } else if(key > arr[mid2]) {
                    start = mid2 + 1;
                } else {
                    start = mid1 + 1;
                    end = mid2 - 1;
                }
            }
            return -1;
        }

        public int TernarySearch_Recursive(int[] arr, int start, int end, int key) {
            if(arr.Length == 0) {
                return -1;
            }

            if(end >= start) {
                int mid1 = start + (end - start) /3;
                int mid2 = mid1 + (end - start) / 3;
                if(arr[mid1] == key) {
                    return mid1;
                }
                if(arr[mid2] == key) {
                    return mid2;
                }

                if(key < arr[mid1]) {
                    return TernarySearch_Recursive(arr, start, mid1 - 1, key);
                } 
                if(key > arr[mid2]) {
                    return TernarySearch_Recursive(arr, mid2 + 1, end, key);
                } 
                return TernarySearch_Recursive(arr, mid1 + 1, mid2 - 1, key);
            }

            return -1;
        }
    }
}