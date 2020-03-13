using System;
namespace Foundation.Arrays {
    public class ArrayOperations {
        public void PrintAllElements(int[] arr) {
            if(arr.Length == 0) {
                return;
            }
            for(int i = 0; i < arr.Length; i++) {
                System.Console.Write(arr[i] + " ");
            }
        }

        public void ReverseElem(int[] arr) {
            if(arr.Length == 0) {
                return;
            }
            for(int i = 0; i < arr.Length/2; i++) {
                SwapElem(i, arr.Length-i-1, arr);
            }
            foreach(int item in arr) {
                System.Console.Write(item + " ");
            }
        }

        private void SwapElem(int i, int j, int[] arr) {
            if(arr.Length == 0) {
                return;
            }

            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] =  temp;
        }

        public int minElemInArray(int[] arr) {
            if(arr.Length == 0) {
                return -1;
            }
            int minElem = arr[0];
            int i;
            for(i=0; i < arr.Length; i++) {
                if(arr[i] < minElem) {
                    minElem = arr[i];
                }
            }
            return minElem;
        }

        public int[] ArrangBinaryElements(int[] arr) {
            if(arr.Length == 0) {
                return null;
            }
            int left = 0;
            int right = arr.Length - 1;
            while(left < right) {
                while(arr[left] == 0 && left < right) {
                    left++;
                }
                while(arr[right] == 1 && left < right) {
                    right--;
                }
                if(left < right) {
                    arr[left] = 0;
                    arr[right] = 1;
                    left++;
                    right--;
                }
            }
            return arr;
        }

        public int[] ArrangeElem(int[] arr) {
            if(arr.Length == 0) {
                return null;
            }
            int low = 0;
            int mid = 0;
            int high = arr.Length - 1;
            while(mid < high) {
                if(arr[mid] == 0) {
                    SwapElem(low, mid, arr);
                    low++;
                    mid++;
                } else if(arr[mid] == 1) {
                    mid++;
                } else if(arr[mid] == 2) {
                    SwapElem(mid, high, arr);
                    high--;
                }
            }
            return arr;
        }

        public int[] SeggregateNumUsingCounting(int[] arr) {
            if(arr.Length == 0) {
                return null;
            }
            int zeroCount = 0;
            int oneCount = 0;
            foreach(int i in arr) {
                if(i == 0)
                    zeroCount++;
                if(i == 1)
                    oneCount++;
            }
            for(int i = 0; i < zeroCount; i++) {
                arr[i] = 0;
            }
            for(int i = zeroCount; i < zeroCount+oneCount; i++) {
                arr[i] = 1;
            }
            for(int i = zeroCount+oneCount; i < arr.Length; i++) {
                arr[i] = 2;
            }
            return arr;
        }

        //find the missing element in the consecutive array
        public int FindMissingElementinArray(int[] arr) {
            if(arr.Length == 0) {
                return -1;
            }
            int x1 = arr[0];
            int x2 = arr[0];
            for(int i = 1; i < arr.Length; i++) {
                x1 = x1 ^ arr[i];
            }

            for(int j = arr[0] + 1; j <= arr[arr.Length - 1]; j++) {
                x2 = x2 ^ j;
            }
            return x1 ^ x2;
        }
    }
}