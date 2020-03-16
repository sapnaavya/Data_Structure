using System;
using System.Collections.Generic;
using System.Linq;

namespace Foundation.Arrays
{
    class Program
    {
        static void Main(string[] args)
        {
            int[] arr = {1, 2, 3, 4}; 
            ArrayOperations obj = new ArrayOperations();

            // //print all the elementsand reverse elements in the array
            // obj.PrintAllElements(arr);
            // System.Console.WriteLine();
            // obj.ReverseElem(arr);

            // //find minimum elem in the array
            // System.Console.WriteLine();
            // System.Console.WriteLine(obj.minElemInArray(arr));
            // System.Console.WriteLine();

            // //arrange binary elements
            // int[] binaryArr = new int[] {1,0,0,1,1,1};
            // binaryArr = obj.ArrangBinaryElements(binaryArr);
            // foreach(int item in binaryArr)
            // {
            //     System.Console.Write(item + " ");
            // }

            // //arrange 0,1 and 2 in an order
            // System.Console.WriteLine();
            // int[] arr1 = new int[]{2,2,2,2,1,1,1,1,0,0,0,0};
            // arr1 =  obj.ArrangeElem(arr1);
            // foreach(int item in arr1) {
            //     System.Console.Write(item + " ");
            // }

            // //arrange 0, 1 and 2 in an order using bruteforce
            // System.Console.WriteLine();
            // int[] arr2 = new int[]{1,1,1,1,1,1,1,1,0,0,0,0,2,2};
            // arr2 = obj.SeggregateNumUsingCounting(arr2);
            // foreach(int item in arr2) {
            //     System.Console.Write(item + " ");
            // }

            // //find missing element in the array
            // System.Console.WriteLine();
            // int [] arr3 = new int[]{1,2,3,4,6};
            // int missingElem = obj.FindMissingElementinArray(arr3);
            // System.Console.WriteLine(missingElem);

            // //build Min_Heap
            // BuildHeap obj1 = new BuildHeap();
            // int[] heap_arr = new int[]{2,3,1,4,5,8};
            // obj1.Build_MinHeap(heap_arr);
            // System.Console.WriteLine("minimum element in the array: " + heap_arr[0]);

            // //build max heap
            // obj1.Build_MaxHeap(heap_arr);
            // System.Console.WriteLine("maximum element in the array: " + heap_arr[0]);

            // //HeapSort
            // obj1.HeapSort(heap_arr);
            // foreach(int item in heap_arr) {
            //     System.Console.Write(item + " ");
            // }

            // // // find element in the sorted array
            // // System.Console.WriteLine();
            // // FoundElemSortedArray obj3 = new FoundElemSortedArray();
            // // System.Console.WriteLine(obj3.FindElemIterative(arr3, 3));
            // // System.Console.WriteLine(obj3.FindElemRecursive(arr3, 3, 0, 5));

            // // // find duplicates in array
            // // Duplicates dup = new Duplicates();
            // // int[] dupArr = new int[]{1,2,3,2,2,3};
            // // HashSet<int> set = new HashSet<int>();
            // // set = dup.FindDuplicateUnsortedArrUsingHashSet(dupArr);
            // // foreach(int i in set){
            // //     System.Console.Write(i + " ");
            // // }
            // // System.Console.WriteLine();
            // // dup.FindDuplicatesinUnsortedArray(dupArr);

            // //Remove duplicates
            // RemoveDuplicates remDup = new RemoveDuplicates();
            // int[] dupSortedArr = new int[]{2,2,2,4,4,6,6};

            // //remDup.RemoveDupSortedUsingThirdArr(dupSortedArr);
            // // remDup.removeDupSortedArrayWithoutThirdArr(dupSortedArr);
            // // System.Console.WriteLine();
            // // int[] dupUnsortedArr = new int[]{2,4,4,3,3,1};
            // // //remDup.removeDupUnsortedArray(dupUnsortedArr);
            // // remDup.removeDupUnsortedWithoutPreservingOrder(dupUnsortedArr);

            // // Maximum sum sub array
            // // System.Console.WriteLine();
            // // System.Console.Write("Maximum Sum sub array: ");
            // // MaximumSumSubArray maxSumObj = new MaximumSumSubArray();
            // // int[] maxSumArr = new int[]{2,3,4,-9,-6,-5,7,8,3,4};
            // // maxSumObj.Maximum_Sum_SubArray(maxSumArr);

            // // //Print K max in an array
            // // System.Console.WriteLine();
            // // PrintKMax printKMaxObj = new PrintKMax();
            // // printKMaxObj.PrintK_MaxBruteForce(maxSumArr, 3);

            // // //Merge two sorted array
            // // System.Console.WriteLine();
            // // System.Console.Write("Merge Two Sorted Array: ");
            // // int [] x1 = new int[] {2,4,6,8};
            // // int[] y1 = new int[] {4,6,7,8,9, 10};
            // // MergeTwoSortedArr m_obj = new MergeTwoSortedArr();
            // // m_obj.Sorted_Merge_UsingThirdArray(x1, y1);
            // // System.Console.WriteLine();
            // // m_obj.Merge_Two_SortedArray_WithoutThirdArray(x1, y1);

            // // find next greater element in the array
            // System.Console.WriteLine();
            // FindNextGreaterElem find_obj = new FindNextGreaterElem();
            // find_obj.FindNextGreaterElemBruteForce(arr);
            // find_obj.FindNextgreaterElemUsingStack(arr);

            // //Job sequencing problem
            // // List of given jobs. Each job has an identifier, a deadline and
	        // // profit associated with it
            // Job[] job1 = new Job[] {
            //     new Job(1, 9, 15), new Job(2, 2, 2),
            //     new Job(3, 5, 18), new Job(4, 7, 1),
            //     new Job(5, 4, 25), new Job(6, 2, 20),
            //     new Job(7, 5, 8), new Job(8, 7, 10),
            //     new Job(9, 4, 12), new Job(10, 3, 5)
            // };
            
            // List<Job> jobs = job1.ToList();
            // jobs.Sort((a, b) => b.getProfit().CompareTo(a.getProfit())); // descending sort
            // JobSequencing seq_obj = new JobSequencing();
            // int totalProfit = seq_obj.getTotalProfit(jobs, 15);
            // System.Console.WriteLine(totalProfit);

            // //Rotate an n*n 2d array by 90 degreee
            // RotateImage image = new RotateImage();
            // // create a matrix
            // int[,] twoDMatrix = new int[,] {
            //     { 1, 2, 5, 6 }, 
            //     { 3, 4, 7, 8 }, 
            //     { 5, 6, 9, 10 },
            //     { 7, 8, 3, 2 }
            // };
            // image.Rotate_ImageInPlace(4, twoDMatrix);
            
            // // Two-dimensional array of array.
            // System.Console.WriteLine();
            // int[][] array2D = new int[4][] {new int[4] { 1, 2, 5, 6 },new int[4]{ 3, 4, 7, 8 },new int[4]{ 5, 6, 9, 10 }, new int[4]{ 7, 8, 3, 2 } };
            // image.RotateImageOutPlace(array2D); 

            // //Ternary search
            // TernarySearch ts = new TernarySearch();
            // int [] ts_arr = new int[]{1,2,3,4,5,7,8,10};
            // int elem = ts.Ternary_Search_Iter(ts_arr, 0, 8, 10); 
            // System.Console.WriteLine(elem);
            // int elemRecur = ts.TernarySearch_Recursive(ts_arr, 0, 8, 10);
            // System.Console.WriteLine(elemRecur);

            // //merge K sorted array using Min Heap
            // int[][] array2D = new int[4][] {new int[4] { 1, 2, 5, 6 },new int[4]{ 3, 4, 7, 8 },new int[4]{ 5, 6, 9, 10 }, new int[4]{ 7, 8, 9, 10}};
            // MergeKSortedArray mer_obj = new MergeKSortedArray();
            // int[] result = mer_obj.MergeKSortedArrUsingMinHeap(array2D, 4);
            // foreach(int i in result) {
            //     System.Console.Write(i + " ");
            // }
            
            // System.Console.WriteLine();
            // MergeKSortedArrayPQ pq_obj = new MergeKSortedArrayPQ();
            // int[] pq_result = pq_obj.Merge_kSorted_UsingPQ(array2D);
            // foreach(int i in pq_result) {
            //     System.Console.Write(i + " ");
            // }

            // // Sort elements by Frequency - BST
            // int[] input = new int[]{5, 3, 7, 7, 7, 5, 4, 8, 6, 6};
            // CreateBST bst = new CreateBST();

            // //create a bst tree with number and its frequency
            // Node added = bst.Add(input);

            // //inorder traversal to flatten into array
            // List<Data> flattened = new List<Data>();
            // bst.InorderToFlattenList(added, flattened);

            // //sort by frequency
            // flattened.Sort((e1, e2) => e2.Frequency.CompareTo(e1.Frequency));
            // foreach(Data data in flattened) {
            //     int freq = data.Frequency;
            //     for(int i = 0; i < freq; i++) {
            //         System.Console.Write(data.Number + " ");
            //     }
            // }

            //Sort elements by frequency using Dictionary
            int[] input = new int[]{5, 3, 7, 7, 7, 5, 4, 8, 6, 6};
            SortElemDictionary sort_obj = new SortElemDictionary();
            sort_obj.SortElemByFreqDict(input, input.Length);
        }
    }
}
