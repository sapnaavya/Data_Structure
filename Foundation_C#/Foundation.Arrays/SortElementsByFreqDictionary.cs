using System;
using System.Linq;
using System.Collections.Generic;

namespace Foundation.Arrays {
    public class SortElemDictionary {
        public void SortElemByFreqDict(int[] arr, int n) {
            Dictionary<int, int> d = GetCountMap(arr, n);

            //Reversed sort
            var items = from pair in d
                            orderby pair.Value descending
                            select pair;

            // Traverse through map and print frequencies 
            foreach(KeyValuePair<int, int> entry in items) 
            { 
                Console.WriteLine(entry.Key + " --> " + entry.Value); 
            } 

        }

        public Dictionary<int, int> GetCountMap(int[] arr, int n) {
            Dictionary<int, int> countMap = new Dictionary<int, int>();
            for(int i = 0; i < n; i++) {
                if (countMap.ContainsKey(arr[i]))  
                { 
                    var val = countMap[arr[i]]; 
                    countMap.Remove(arr[i]); 
                    countMap.Add(arr[i], val + 1);  
                }  else {
                    countMap.Add(arr[i], 1); 
                }
            }
            return countMap;
        }
    }
}