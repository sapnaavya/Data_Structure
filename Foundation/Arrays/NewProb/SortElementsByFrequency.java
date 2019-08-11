/**
 * Reference: Print frequency of each element using Hashmap
 *            https://java2blog.com/count-occurences-frequency-each-element-sorted-array/
 *            https://stackoverflow.com/questions/27448266/java-8-streams-iterate-over-map-of-lists
 * Time complexity: O(n) to insert elements and their counts in the hash
 *                  We copy contents of hash to an array (or vector) and sort them by counts. 
 *                  This step takes O(m Log m) time where m is total number of distinct elements.
 *                  O(n) + O(mlogm)
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class SortElementsByFrequency {

    // function to sort elements by frequency
    // Build a map of array elements to its count
    public static String sortByFrequency(int[] arr, int n) {
        Map<Integer, Integer> countMap = getCountMap(arr, n);
        StringBuilder sb = new StringBuilder();

        // Sort the map using a comparingByValue comparator 
        // build the result by appending keys the count times to the result 
        countMap.entrySet().stream()
            //in reverse order
            //list.stream().sorted() sorts the stream in natural ordering
            .sorted(Map.Entry.<Integer, Integer> comparingByValue().reversed())
            .forEach( e -> {
                int key = e.getKey();
                int val = e.getValue();
                for(int i = 0; i < val; i++) {
                    sb.append(key + " ");
                }
            });
        return sb.toString(); 
    }

    // function to get frequency of each element in array
    // here, each element is working as key 
    public static Map<Integer, Integer>getCountMap(int[] arr, int n) {
        Map<Integer, Integer> countMap = new LinkedHashMap<>();
        for(int i = 0; i < n; i++) {
            if(!countMap.containsKey(arr[i])) {
                countMap.put(arr[i], 1);
            } else {
                countMap.put(arr[i], countMap.get(arr[i]) + 1);
            }
        }
        return countMap;
    }

    //main method
    public static void main(String args[]) {
        int a[] = { 2, 5, 2, 6, -1, 9999999, 5, 8, 8, 8 }; 
        System.out.println(sortByFrequency(a, a.length)); 
    }
}