
/**
 * This code finds the duplicate in below ways:
 * Assumption: Below three functions assume that there is only one duplicate exist in the array
    * 1. findMissingDup -> Finds duplicate and missing in consecutive array
    * 2. findDupSortedArray -> Find duplicates in sorted array

 * Assumption: Below functions find all duplicates in unsorted array
 *  findDups -> Find all the duplicates in unsorted array and store them in set.
 */

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Map.Entry;

class Temp {
    int missingElem;
    int dupElem;
    Temp(int missingElem, int dupElem) {
        this.missingElem = missingElem;
        this.dupElem = dupElem;
    }
}

public class FindDup {

    /**
    * This code finds the missing and duplicate element in the consecutive array. 
    * Assumption: Array has to be consecutive and it does not necessarily need to start from 1
    */

    static Temp findMissingDup(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return new Temp(0,0);
        }
        
        int j = 0;
        for(int i = arr[0]; i <= arr[arr.length - 1]; i++) {
            if((arr[j] ^ i) != 0){
                return new Temp(i, arr[j]);
            }
            j++;
        }
        return new Temp(0,0);
    }

    //find duplicates in a sorted array - Traversing through the whole array. This method will return as soon as it finds first missing element
    public static int findDupSortedArray(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return 0;
        }
        for(int i=0; i < arr.length; i++) {
            if(arr[i+1] == arr[i]) {
                return arr[i];
            }
        }
        return 0;
    }

    //Brute force approach - find all duplicates in unsorted array - Time Complexity o(n^2)
    public static Set<Integer> findDupUnsorted(int[] arr) {
        Set<Integer> duplicates = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[i] == arr[j] && i != j) {
                    duplicates.add(arr[i]);
                }
            }
        }
        return duplicates;
    }

    /* 
    Find all duplicates in unsorted array with Time complexity - O(n) with generic  types array
        Iterate over the array and insert every element in hashset. 
        Since, it allows only unique elements, add method() will fail and return false when we try to add duplicates and tha would be duplicate element
        Other way to see the problem is to find unique elements as set will hold only unique elements .. we can return set if we want to get unique elements in an array
         -> if we want ot use it for generic array then use generic class.  For example, see below code in comments
                static <T extends Comparable<T>> void getDups(T[] array) {
                    Set<T> dups = new HashSet<T>();
                    for(T i: array) {
                        if(!dups.add(i)){
                            System.out.println("dup elements: " + i);
                        }
                    }
                }
    */

    //Find all duplicates in unsorted array with Time complexity - O(n)
    public static void findDups(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return;
        }
        Set<Integer> duplicates = new HashSet<Integer>();
        for(int i = 0; i < arr.length; i++) {
            if(!duplicates.add(arr[i])) {
                System.out.println("Duplicate elements in array: " + arr[i]);
            }  
        }
    }

    //main method
    public static void main(String args[]) {

        //find missing and duplicate in consecutive array
        int[] arr = new int[]{3,4,4,6,7}; 
        Temp obj = findMissingDup(arr);
        System.out.println("Missing element: " + obj.missingElem);
        System.out.println("Duplicate element: " + obj.dupElem);

        //find duplicate element in sorted array
        int[] sortedArr = new int[]{3,4,5,5,7};
        int dupElem = findDupSortedArray(sortedArr);
        //System.out.println("duplicate element: " +  dupElem);

        //Find all duplicate in all kinds of array and store them in a set hashset wont allow to store duplicates\
        // This apprpach computes with O(n^2) time complexity
        
        int[] array1 = new int[]{2,4,6,6,8,8,10,10,10};
        Set<Integer> duplicatesVal = new HashSet<Integer>();
        duplicatesVal = findDupUnsorted(array1);
        System.out.println("duplicate elements: ");
        Iterator iter = duplicatesVal.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }

        //Find all duplicates with O(n) time complexity
        int[] array2 = new int[]{2,4,6,6,8,8,10,10};
        findDups(array2);
    }    
}