/**
 * This code merge k sorted array using MinHeap
 * Approach:
 * 1. Create an output array of size n*k.
   2. Create a min heap of size k and insert 1st element in all the arrays into the heap
   3. Repeat following steps n*k times.
     a) Get minimum element from heap (minimum is always at root) and store it in output array.
     b) Replace heap root with next element from the array from which the element is extracted. 
        If the array doesn’t have any more elements, then replace root with infinite. 
        After replacing the root, heapify the tree.
*/

using System;
namespace Foundation.Arrays {
    public class MinHeapNode {
        public int element;
        public int i; //index of the array from which element is taken
        public int j; //index of the next element to be picked from array
        public MinHeapNode(int element, int i, int j) {
            this.element = element;
            this.i = i;
            this.j = j;
        }
    }

    public class MergeKSortedArrayMinHeap {
        MinHeapNode[] _harr;
        int _heap_size;
        public MergeKSortedArrayMinHeap(MinHeapNode[] harr, int heap_size) {
            _harr = harr;
            _heap_size = heap_size;
            int i = (heap_size - 1) / 2;
            while(i >= 0) {
                minHeapify(i);
                i--;
            }
        }

        public void minHeapify(int i) {
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < _heap_size && _harr[left].element < _harr[smallest].element) {
                smallest = left;
            }
            if(right < _heap_size && _harr[right].element < _harr[smallest].element) {
                smallest = right;
            }
            if(smallest != i) {
                MinHeapNode temp = _harr[i];
                _harr[i] = _harr[smallest];
                _harr[smallest] = temp;
                minHeapify(smallest);
            }
        }

        public MinHeapNode GetMin() {
            if(_heap_size < 0) {
                return null;
            }
            
            return _harr[0];
        }
        
        public void ReplaceMin(MinHeapNode root) {
            _harr[0] = root;
            minHeapify(0);
        }
    }

    public class MergeKSortedArray {
        
        // function to merge k sorted array using min heap
        public int[] MergeKSortedArrUsingMinHeap(int[][] arr, int k) {
            // create an array of type as MinHeapNode
            MinHeapNode[] harr = new MinHeapNode[k];
            int result_size = 0;

            for(int i = 0; i < arr.Length; i++) {
                MinHeapNode node = new MinHeapNode(arr[i][0], i, 1);
                harr[i] =  node;
                result_size += arr[i].Length;
            }

            //create a min heap with k heap node
            //Every heap node has first element of an array
            MergeKSortedArrayMinHeap mh = new MergeKSortedArrayMinHeap(harr, k);
            int[] result = new int[result_size];

            for(int i = 0; i < result_size; i++) {
                // get the minimum element and store in the result
                MinHeapNode root = mh.GetMin();
                result[i] = root.element;

                //Find the next element that will replace the current root of the heap
                // the next element belongs to the same array as current root
                if(root.j < arr[root.i].Length) {
                    root.element = arr[root.i][root.j++];
                } else {
                    root.element = int.MaxValue;
                }

                //replace root with the next element of the array
                mh.ReplaceMin(root);
            }
            return result;
        }
    }
}