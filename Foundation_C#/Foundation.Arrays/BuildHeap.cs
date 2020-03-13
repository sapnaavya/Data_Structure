namespace Foundation.Arrays {
    public class BuildHeap {

        //build min heap
        public void Build_MinHeap(int[] arr) {
            if(arr.Length == 0) {
                return;
            }
            int n = arr.Length;
            int startIndex = n/2 - 1;
            for(int i = startIndex; i >= 0; i--) {
                heapify_MinHeap(arr, i, n);
            }
        }

        // heapify process to build min heap
        public void heapify_MinHeap(int[] arr, int i, int n) {
            int smallest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < n && arr[left] < arr[smallest]) {
                smallest = left;
            }
            if(right < n && arr[right] < arr[smallest]) {
                smallest = right;
            }
            if(smallest != i) {
                int temp = arr[i];
                arr[i] = arr[smallest];
                arr[smallest] = temp;
                heapify_MinHeap(arr, smallest, n);
            }
        }

        // build max heap
        public void Build_MaxHeap(int[] arr) {
            if(arr.Length == 0) {
                return;
            }
            int n = arr.Length;
            int startIndex = n/2 - 1;
            for(int i = startIndex; i >= 0; i--) {
                heapify_MaxHeap(arr, i, n);
            }
        }

        public void heapify_MaxHeap(int[] arr, int i, int n) {
            int largest = i;
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            if(left < n && arr[left] > arr[largest]) {
                largest = left;
            }
            if(right < n && arr[right] > arr[largest]) {
                largest = right;
            }

            if(largest != i) {
                int temp = arr[i];
                arr[i] = arr[largest];
                arr[largest] = temp;
                heapify_MaxHeap(arr, largest, n);
            }
        }

        // heapsort
        public void HeapSort(int[] arr) {
            if(arr.Length == 0) {
                return;
            }
            int n = arr.Length;
            int startIndex = n/2 - 1;
            for(int i = startIndex; i >= 0; i--) {
                Build_MinHeap(arr);
            }

            for(int i = n-1; i >= 0; i--) {
                int temp = arr[0];
                arr[0] = arr[i];
                arr[i] = temp;
                heapify_MinHeap(arr, 0, i);
            }
        }
    }
}