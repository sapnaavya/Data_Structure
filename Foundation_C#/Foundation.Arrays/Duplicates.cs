using System.Collections.Generic;

namespace Foundation {
    public class Duplicates {

        // find first duplicate in the sorted array
        public int FindFirstDupSortedArray(int[] arr) {
            if(arr.Length == 0 || arr == null) {
                return -1;
            }
            for(int i = 0; i < arr.Length; i++) {
                if(arr[i] == arr[i+1]) {
                    return arr[i];
                }
            }
            return -1;
        }

        //find duplicates in unsorted array and store them in  hashset
        //Brute force approach - find all duplicates in unsorted array - Time Complexity o(n^2)
        public HashSet<int> FindDuplicateUnsortedArrUsingHashSet(int [] arr) {
            if(arr.Length == 0) {
                return null;
            }
            HashSet<int> hashSet = new HashSet<int>();
            for(int i = 0; i < arr.Length; i++) {
                for(int j = i+1; j < arr.Length; j++) {
                    if(arr[i] == arr[j]) {
                        hashSet.Add(arr[i]);
                    }
                }
            }
            return hashSet;
        }

        //Find all duplicates in unsorted array with Time complexity - O(n)
        public void FindDuplicatesinUnsortedArray(int[] arr) {
            if(arr.Length == 0 || arr == null) {
                return;
            }
            HashSet<int> hashSet = new HashSet<int>();
            for(int i = 0; i < arr.Length; i++) {
                if(hashSet.Add(arr[i]) == false) {
                    System.Console.Write(arr[i] + " ");
                }
            }
        }
    }
}