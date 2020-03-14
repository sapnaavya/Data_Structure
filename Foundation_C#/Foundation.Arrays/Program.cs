using System;
using System.Collections.Generic;

namespace Foundation.Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3, 4}; 
            ArrayOperations obj = new ArrayOperations();

            //print all the elementsand reverse elements in the array
            obj.PrintAllElements(arr);
            System.Console.WriteLine();
            obj.ReverseElem(arr);

            //find minimum elem in the array
            System.Console.WriteLine();
            System.Console.WriteLine(obj.minElemInArray(arr));
            System.Console.WriteLine();

            //arrange binary elements
            int[] binaryArr = new int[] {1,0,0,1,1,1};
            binaryArr = obj.ArrangBinaryElements(binaryArr);
            foreach(int item in binaryArr)
            {
                System.Console.Write(item + " ");
            }

            //arrange 0,1 and 2 in an order
            System.Console.WriteLine();
            int[] arr1 = new int[]{2,2,2,2,1,1,1,1,0,0,0,0};
            arr1 =  obj.ArrangeElem(arr1);
            foreach(int item in arr1) {
                System.Console.Write(item + " ");
            }

            //arrange 0, 1 and 2 in an order using bruteforce
            System.Console.WriteLine();
            int[] arr2 = new int[]{1,1,1,1,1,1,1,1,0,0,0,0,2,2};
            arr2 = obj.SeggregateNumUsingCounting(arr2);
            foreach(int item in arr2) {
                System.Console.Write(item + " ");
            }

            //find missing element in the array
            System.Console.WriteLine();
            int [] arr3 = new int[]{1,2,3,4,6};
            int missingElem = obj.FindMissingElementinArray(arr3);
            System.Console.WriteLine(missingElem);

            //build Min_Heap
            BuildHeap obj1 = new BuildHeap();
            int[] heap_arr = new int[]{2,3,1,4,5,8};
            obj1.Build_MinHeap(heap_arr);
            System.Console.WriteLine("minimum element in the array: " + heap_arr[0]);

            //build max heap
            obj1.Build_MaxHeap(heap_arr);
            System.Console.WriteLine("maximum element in the array: " + heap_arr[0]);

            //HeapSort
            obj1.HeapSort(heap_arr);
            foreach(int item in heap_arr) {
                System.Console.Write(item + " ");
            }

            // find element in the sorted array
            System.Console.WriteLine();
            FoundElemSortedArray obj3 = new FoundElemSortedArray();
            System.Console.WriteLine(obj3.FindElemIterative(arr3, 3));
            System.Console.WriteLine(obj3.FindElemRecursive(arr3, 3, 0, 5));

            // find duplicates in array
            Duplicates dup = new Duplicates();
            int[] dupArr = new int[]{1,2,3,2,2,3};
            HashSet<int> set = new HashSet<int>();
            set = dup.FindDuplicateUnsortedArrUsingHashSet(dupArr);
            foreach(int i in set){
                System.Console.Write(i + " ");
            }
            System.Console.WriteLine();
            dup.FindDuplicatesinUnsortedArray(dupArr);

            //Remove duplicates
            RemoveDuplicates remDup = new RemoveDuplicates();
            int[] dupSortedArr = new int[]{2,2,2,4,4,6,6};

            //remDup.RemoveDupSortedUsingThirdArr(dupSortedArr);
            remDup.removeDupSortedArrayWithoutThirdArr(dupSortedArr);
            System.Console.WriteLine();
            int[] dupUnsortedArr = new int[]{2,4,4,3,3,1};
            //remDup.removeDupUnsortedArray(dupUnsortedArr);
            remDup.removeDupUnsortedWithoutPreservingOrder(dupUnsortedArr);

            // Maximum sum sub array
            System.Console.WriteLine();
            System.Console.Write("Maximum Sum sub array: ");
            MaximumSumSubArray maxSumObj = new MaximumSumSubArray();
            int[] maxSumArr = new int[]{2,3,4,-9,-6,-5,7,8,3,4};
            maxSumObj.Maximum_Sum_SubArray(maxSumArr);

            //Print K max in an array
            System.Console.WriteLine();
            PrintKMax printKMaxObj = new PrintKMax();
            printKMaxObj.PrintK_MaxBruteForce(maxSumArr, 3);
        }
    }
}
