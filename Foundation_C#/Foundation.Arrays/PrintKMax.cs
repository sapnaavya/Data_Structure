using System;
using System.Collections;
using System.Collections.Generic;

namespace Foundation {
    public class PrintKMax {

        // BruteForce approach
        public void PrintK_MaxBruteForce(int[] arr, int k) {
            if(arr.Length == 0 || k < 1) {
                return;
            }
            int n = arr.Length;
            
            for(int i = 0; i < n - k; i++) {
                int max = arr[i];
                for(int j = 1; j < k; j++) {
                    if(max < arr[i+j]) {
                        max = arr[i+j];
                    }
                }
                System.Console.Write(max + " ");
            }
        }

        //Print k max using Dequeue - see the example in java
        // public void PrintKMaxUsingDequeue(int[] arr, int k) {
        // }

    }
}